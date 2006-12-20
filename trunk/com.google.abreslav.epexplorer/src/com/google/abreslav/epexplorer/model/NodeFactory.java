package com.google.abreslav.epexplorer.model;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IExtensionPoint;

public class NodeFactory {

	public static final NodeFactory INSTANCE = new NodeFactory();
	
	// String => NamespaceNode
	private Map namespaceNodeCache = new HashMap();
	// IExtensionPoint => ExtensionPointNode
	private Map extensionPointNodeCache = new HashMap();
	
	private NodeFactory() {		
	}
	
	public NamespaceNode createNamespaceNode(String id) {
		NamespaceNode result = (NamespaceNode) namespaceNodeCache.get(id);
		if (result == null) {
			result = new NamespaceNode(id);
			namespaceNodeCache.put(id, result);
		}
		return result;
	}
	
	public ExtensionPointNode creatExtensionPointNode(IExtensionPoint extensionPoint) {
		ExtensionPointNode result = (ExtensionPointNode) extensionPointNodeCache.get(extensionPoint);
		if (result == null) {
			result = new ExtensionPointNode(extensionPoint);
			extensionPointNodeCache.put(extensionPoint, result);
		}
		return result;
	}

}
