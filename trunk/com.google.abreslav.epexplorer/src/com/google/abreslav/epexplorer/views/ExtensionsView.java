package com.google.abreslav.epexplorer.views;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;

import com.google.abreslav.epexplorer.Activator;
import com.google.abreslav.epexplorer.model.AttributeNode;
import com.google.abreslav.epexplorer.model.ContributorRoot;
import com.google.abreslav.epexplorer.model.ExtensionPointRoot;
import com.google.abreslav.epexplorer.model.IRoot;
import com.google.abreslav.epexplorer.model.ITreeNode;
import com.google.abreslav.epexplorer.model.NamespaceRoot;

public class ExtensionsView extends ViewPart {
	
	private class SetRootAction extends Action {
		private final IRoot root;

		public SetRootAction(String text, ImageDescriptor image, final IRoot root) {
			super(text, IAction.AS_RADIO_BUTTON);
			setImageDescriptor(image);
			setToolTipText(text);
			this.root = root;
		}
		
		public void run() {
			settings.setRoot(root);
		}
	}

	private ViewLabelProvider labelProvider = new ViewLabelProvider();	

	private SetRootAction[] rootActions = {
			new SetRootAction(IConstants.SHOW_EXTENSION_POINTS, labelProvider.getExtensionPointImageDescriptor(), ExtensionPointRoot.INSTANCE),
			new SetRootAction(IConstants.SHOW_NAMESPACES, labelProvider.getNamespaceImageDescriptor(), NamespaceRoot.INSTANCE),
			new SetRootAction(IConstants.SHOW_CONTRIBUTORS, labelProvider.getContributorImageDescriptor(), ContributorRoot.INSTANCE),
	};

	private PatternFilter patternFilter = new PatternFilter() {
		public boolean isElementVisible(Viewer viewer, Object element) {
			if (settings.getRoot().isTopLevelElement(element)) {
				return wordMatches(element.toString());
			}
			return true;
		}
	};
	
	private final class ExtensionsViewSettings {
		private static final String ROOT = "root";
		private static final String HIDE_EMPTY = "hideEmpty";
		private static final String ID = "com.google.abreslav.epexplorer.views.ExtensionsView";
		
		private final Map nameToRoot = new HashMap();
		{
			nameToRoot.put(ExtensionPointRoot.INSTANCE.toString(), ExtensionPointRoot.INSTANCE);
			nameToRoot.put(NamespaceRoot.INSTANCE.toString(), NamespaceRoot.INSTANCE);
			nameToRoot.put(ContributorRoot.INSTANCE.toString(), ContributorRoot.INSTANCE);
		}
		private final Map rootToAction = new HashMap();
		{
			for (int i = 0; i < rootActions.length; i++) {
				rootToAction.put(rootActions[i].root, rootActions[i]);
			}
		}
		
		private IRoot root = ExtensionPointRoot.INSTANCE;
		private boolean hideEmpty = false;
		private IDialogSettings section;
		
		public ExtensionsViewSettings(IDialogSettings ds) {
			section = ds.getSection(ID);
			if (section != null) {
				load();
			} else {
				section = ds.addNewSection(ID);
				save();
				apply();
			}
			applyToActions();
		}
		
		private void save() {
			section.put(HIDE_EMPTY, hideEmpty);
			section.put(ROOT, getRootName(root));
		}

		private void load() {
			hideEmpty = section.getBoolean(HIDE_EMPTY);
			IRoot rootByName = getRootByName(section.get(ROOT));
			root = rootByName != null ? rootByName : root;
			apply();
		}

		private void apply() {
			viewer.setInput(root);
			if (hideEmpty) {
				viewer.addFilter(viewerFilter);
			} else {
				viewer.removeFilter(viewerFilter);				
			}
		}

		private void applyToActions() {
			((IAction) rootToAction.get(root)).setChecked(true);
			hideEmptyAction.setChecked(hideEmpty);
		}

		private String getRootName(IRoot root) {
			return root.toString();
		}

		private IRoot getRootByName(String string) {
			return (IRoot) nameToRoot.get(string);
		}

		public boolean getHideEmpty() {
			return hideEmpty;
		}

		public void setHideEmpty(boolean hideEmpty) {
			this.hideEmpty = hideEmpty;
			save();
			apply();
		}

		public IRoot getRoot() {
			return root;
		}

		public void setRoot(IRoot root) {
			this.root = root;
			save();
			apply();
		}
	}
	
	private IAction hideEmptyAction;
	
	private IAction collapseAllAction;
	
	private IAction applyTextFilterAction;
	
	private final ViewerFilter viewerFilter = new ViewerFilter() {
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if (parentElement instanceof IRoot) {
				return ((ITreeNode) element).hasChildren();
			}
			return true;
		}
	};

	private class NameSorter extends ViewerSorter {
		public int category(Object element) {
			if (element instanceof AttributeNode) {
				return 0;
			}
			return 1;
		}
	}

	private TreeViewer viewer;

	private DrillDownAdapter drillDownAdapter;

	private ExtensionsViewSettings settings;
	
	public ExtensionsView() {
	}
	
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		drillDownAdapter = new DrillDownAdapter(viewer);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(labelProvider);
		viewer.setSorter(new NameSorter());
		makeActions();
		hookContextMenu();
		contributeToActionBars();
		settings = new ExtensionsViewSettings(Activator.getDefault().getDialogSettings());
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
		for (int i = 0; i < rootActions.length; i++) {
			manager.add(rootActions[i]);			
		}
		manager.add(new Separator());
		manager.add(hideEmptyAction);
		manager.add(applyTextFilterAction);
	}

	private void fillContextMenu(IMenuManager manager) {
		drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		drillDownAdapter.addNavigationActions(manager);
		manager.add(new Separator());
		for (int i = 0; i < rootActions.length; i++) {
			manager.add(rootActions[i]);			
		}
		manager.add(new Separator());
		manager.add(hideEmptyAction);
		manager.add(applyTextFilterAction);
		manager.add(new Separator());
		manager.add(collapseAllAction);
	}

	private void makeActions() {
		hideEmptyAction = new Action(IConstants.HIDE_EMPTY_TOPLEVEL_ELEMENTS, IAction.AS_CHECK_BOX) {
			public void run() {
				settings.setHideEmpty(isChecked());
			}
		};
		hideEmptyAction.setToolTipText(IConstants.HIDE_EMPTY_TOPLEVEL_ELEMENTS);
		hideEmptyAction.setImageDescriptor(Activator.getImageDescriptor("icons/hideempty.gif"));
		
		
		collapseAllAction = new Action(IConstants.COLLAPSE_ALL) {
			public void run() {
				viewer.collapseAll();
			}
		};
		collapseAllAction.setToolTipText(IConstants.COLLAPSE_ALL);
		collapseAllAction.setImageDescriptor(Activator.getImageDescriptor("icons/collapseall.gif"));
		
		applyTextFilterAction = new Action("Apply text filter...", Activator.getImageDescriptor("icons/filter.gif")) {
			
			private String pattern = "";
			
			public void run() {
				InputDialog dialog = new InputDialog(getSite().getShell(), "Apply text filter...", "Input pattern (* and ? work):", pattern, null);
				if (dialog.open() == Dialog.OK) {
					pattern = dialog.getValue();
					patternFilter.setPattern(pattern);
					viewer.removeFilter(patternFilter);
					viewer.addFilter(patternFilter);
				}
			}
		};
	}

	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
}