package com.google.abreslav.epexplorer.views;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;

import com.google.abreslav.epexplorer.Activator;
import com.google.abreslav.epexplorer.model.AttributeNode;
import com.google.abreslav.epexplorer.model.ConfigurationElementNode;
import com.google.abreslav.epexplorer.model.ContributorNode;
import com.google.abreslav.epexplorer.model.ContributorRoot;
import com.google.abreslav.epexplorer.model.ExtensionNode;
import com.google.abreslav.epexplorer.model.ExtensionPointNode;
import com.google.abreslav.epexplorer.model.ExtensionPointRoot;
import com.google.abreslav.epexplorer.model.IRoot;
import com.google.abreslav.epexplorer.model.ITreeNode;
import com.google.abreslav.epexplorer.model.NamespaceNode;
import com.google.abreslav.epexplorer.model.NamespaceRoot;

public class ExtensionsView extends ViewPart {
	
	private static final String HIDE_EMPTY = "hide_empty";

	private static final String HIDE_EMPTY_TOPLEVEL_ELEMENTS = "Hide empty toplevel elements";

	private static final String FILTER_EVERYTHING = "Filter everything";

	private static final String COLLAPSE_ALL = "Collapse all";

	private static final String SHOW_CONTRIBUTORS = "Show contributors";

	private static final String SHOW_EXTENSION_POINTS = "Show extension points";

	private static final String SHOW_NAMESPACES = "Show namespaces";

	private TreeViewer viewer;

	private DrillDownAdapter drillDownAdapter;

	private Action namespaceRootAction;

	private Action extensionPointRootAction;

	private Action contributorsRootAction;

	private Action hideEmptyAction;
	
	private Action collapseAllAction;
	
	private Action filterEverythingAction;
	
	private final class NotifiableFilteredTree extends FilteredTree {
		private NotifiableFilteredTree(Composite parent, int style, PatternFilter filter) {
			super(parent, style, filter);
		}
		
		protected void textChanged() {
			super.textChanged();
		}
	}

	private class FilterTypeAction extends Action {
		
		private final Class typeToFilter;

		public FilterTypeAction(final Class typeToFilter, String text) {
			super(text, IAction.AS_CHECK_BOX);
			this.typeToFilter = typeToFilter;
		} 
		
		public void run() {
			if (isChecked()) {
				patternFilter.addFilteredClass(typeToFilter);
			} else {
				patternFilter.removeFilteredClass(typeToFilter);
			}			
			filteredTree.textChanged();
		}
	}

	private ViewLabelProvider labelProvider = new ViewLabelProvider();
	
	private IAction[] filterTypeActions = new IAction[] {
			new FilterTypeAction(ExtensionPointNode.class, "Filter extension points"),	
			new FilterTypeAction(NamespaceNode.class, "Filter namespaces"),	
			new FilterTypeAction(ContributorNode.class, "Filter contributors"),	
			new FilterTypeAction(ExtensionNode.class, "Filter extensions"),	
			new FilterTypeAction(ConfigurationElementNode.class, "Filter configuration elements"),	
			new FilterTypeAction(AttributeNode.class, "Filter attributes"),	
	};
	
	private final ViewerFilter viewerFilter = new ViewerFilter() {
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if (parentElement instanceof IRoot) {
				return ((ITreeNode) element).hasChildren();
			}
			return true;
		}
	};

	private NotifiableFilteredTree filteredTree;

	private MyPatternFilter patternFilter = new MyPatternFilter();

	class NameSorter extends ViewerSorter{
		public int category(Object element) {
			if (element instanceof AttributeNode) {
				return 0;
			}
			return 1;
		}
	}

	public ExtensionsView() {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().addPartListener(new MyWorkbenchPartListener());
	}
	
	public void createPartControl(Composite parent) {
		filteredTree = new NotifiableFilteredTree(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER, patternFilter);
		viewer = filteredTree.getViewer();
		drillDownAdapter = new DrillDownAdapter(viewer);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(labelProvider);
		viewer.setSorter(new NameSorter());
		makeActions();
		hookContextMenu();
		contributeToActionBars();
		
		extensionPointRootAction.run();
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				ExtensionsView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(extensionPointRootAction);
		manager.add(namespaceRootAction);
		manager.add(contributorsRootAction);
		manager.add(new Separator());
		manager.add(hideEmptyAction);
		manager.add(new Separator());
		for (int i = 0; i < filterTypeActions.length; i++) {
			manager.add(filterTypeActions[i]);
		}
		manager.add(new Separator());
		manager.add(filterEverythingAction);
	}

	private void fillContextMenu(IMenuManager manager) {
		drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		drillDownAdapter.addNavigationActions(manager);
		manager.add(new Separator());
		manager.add(extensionPointRootAction);
		manager.add(namespaceRootAction);
		manager.add(contributorsRootAction);
		manager.add(new Separator());
		manager.add(hideEmptyAction);
		manager.add(new Separator());
		manager.add(collapseAllAction);
	}

	private void makeActions() {
		namespaceRootAction = new Action(SHOW_NAMESPACES, IAction.AS_RADIO_BUTTON) {
			public void run() {
				viewer.setInput(NamespaceRoot.INSTANCE);
			}
		};
		namespaceRootAction.setToolTipText(SHOW_NAMESPACES);
		namespaceRootAction.setImageDescriptor(labelProvider.getNamespaceImageDescriptor());

		extensionPointRootAction = new Action(SHOW_EXTENSION_POINTS, IAction.AS_RADIO_BUTTON) {
			public void run() {
				viewer.setInput(ExtensionPointRoot.INSTANCE);
			}
		};
		extensionPointRootAction.setChecked(true);
		extensionPointRootAction.setToolTipText(SHOW_EXTENSION_POINTS);
		extensionPointRootAction.setImageDescriptor(labelProvider.getExtensionPointImageDescriptor());

		contributorsRootAction = new Action(SHOW_CONTRIBUTORS, IAction.AS_RADIO_BUTTON) {
			public void run() {
				viewer.setInput(ContributorRoot.INSTANCE);
			}
		};
		contributorsRootAction.setToolTipText(SHOW_CONTRIBUTORS);
		contributorsRootAction.setImageDescriptor(labelProvider.getContributorImageDescriptor());

		hideEmptyAction = new Action(HIDE_EMPTY_TOPLEVEL_ELEMENTS, IAction.AS_CHECK_BOX) {
			public void run() {
				if (isChecked()) {
					viewer.addFilter(viewerFilter);
				} else {
					viewer.removeFilter(viewerFilter);
				}
			}
		};
		hideEmptyAction.setToolTipText(HIDE_EMPTY_TOPLEVEL_ELEMENTS);
		hideEmptyAction.setImageDescriptor(Activator.getImageDescriptor("icons/hideempty.gif"));
		
		
		collapseAllAction = new Action(COLLAPSE_ALL) {
			public void run() {
				viewer.collapseAll();
			}
		};
		collapseAllAction.setToolTipText(COLLAPSE_ALL);
		collapseAllAction.setImageDescriptor(Activator.getImageDescriptor("icons/collapseall.gif"));
		
		filterEverythingAction = new Action(FILTER_EVERYTHING, IAction.AS_CHECK_BOX) {
			public void run() {
				patternFilter.setFilterEverything(isChecked());
				filteredTree.textChanged();
			}
		};
		filterEverythingAction.setToolTipText(FILTER_EVERYTHING);
	}

	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	public void init(IViewSite site, IMemento memento) throws PartInitException {
		super.init(site, memento);
		
		if (memento != null) {
			Integer hideEmpty = memento.getInteger(HIDE_EMPTY);
			hideEmptyAction.setChecked(hideEmpty != null && hideEmpty.intValue() == 1);
			hideEmptyAction.run();
		}
	}
	
	public void saveState(IMemento memento) {
		memento.putInteger(HIDE_EMPTY, hideEmptyAction.isChecked() ? 1 : 0);
		memento.putString("top_level", "");
	}
	
	
}