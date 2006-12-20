/**
 * 
 */
package com.google.abreslav.epexplorer.views;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.google.abreslav.epexplorer.model.IRoot;
import com.google.abreslav.epexplorer.model.ITreeNode;

class ViewContentProvider implements IStructuredContentProvider,
		ITreeContentProvider {

	private static final Object[] NO_OBJECTS = new Object[0];

	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}

	public void dispose() {
	}

	public Object[] getElements(Object parent) {
		if (parent instanceof IRoot) {
			return ((IRoot) parent).getChildren();
		}
		return getChildren(parent);
	}

	public Object getParent(Object child) {
		if (child instanceof ITreeNode) {
			return ((ITreeNode) child).getParent();
		}
		return null;
	}

	public Object[] getChildren(Object parent) {
		if (parent instanceof ITreeNode) {
			return ((ITreeNode) parent).getChildren();
		}
		return NO_OBJECTS;
	}

	public boolean hasChildren(Object parent) {
		if (parent instanceof ITreeNode) {
			return ((ITreeNode) parent).hasChildren();
		}
		return false;
	}
}