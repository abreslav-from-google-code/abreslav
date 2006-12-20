package com.google.abreslav.epexplorer.model;

import org.eclipse.core.runtime.Platform;

public class NamespaceRoot implements IRoot {

	public static final NamespaceRoot INSTANCE = new NamespaceRoot();
	
	private NamespaceNode[] namespaceNodes;
	
	private NamespaceRoot() {		
	}
	
	public ITreeNode[] getChildren() {
		if (namespaceNodes == null) {
			String[] namespaces = Platform.getExtensionRegistry().getNamespaces();
			namespaceNodes = new NamespaceNode[namespaces.length];
			
			for (int i = 0; i < namespaces.length; i++) {
				namespaceNodes[i] = NodeFactory.INSTANCE.createNamespaceNode(namespaces[i]);
			}
		}
		return namespaceNodes;
	}
}
