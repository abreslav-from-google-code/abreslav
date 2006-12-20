package com.google.abreslav.epexplorer.views;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.dialogs.PatternFilter;

public class MyPatternFilter extends PatternFilter {

	// Set of Class
	private final Set filteredClasses = new HashSet();
	private boolean filterEverything;

	public boolean isElementVisible(Viewer viewer, Object element) {
		//return elementMatches(element)/* || super.isElementVisible(viewer, element)*/;
		return super.isElementVisible(viewer, element);
	}
	
	private boolean labelMatches(Object node) {
		return wordMatches(node.toString());
	}
	
	private boolean elementMatches(Object element) {
		if (filterEverything || filteredClasses.contains(element.getClass())) {
			return labelMatches(element);
		}
		return true;
	}
	
	public void addFilteredClass(Class cl) {
		filteredClasses.add(cl);
	}
	
	public void removeFilteredClass(Class cl) {
		filteredClasses.remove(cl);
	}
	
	public boolean getFilterEverything() {
		return filterEverything;
	}
	
	public void setFilterEverything(boolean filterEverything) {
		this.filterEverything = filterEverything;
	}
	
}
