package com.google.abreslav.epexplorer.model;

import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;

public class NamespaceNode implements ITreeNode {
	private final String id;
	private ExtensionPointNode[] extensionPointNodes;
	private IExtensionPoint[] extensionPoints;

	public NamespaceNode(final String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public ExtensionPointNode[] getExtensionPointNodes() {
		if (extensionPointNodes == null) {
			initExtensionPoints();
			extensionPointNodes = new ExtensionPointNode[extensionPoints.length];
			for (int i = 0; i < extensionPointNodes.length; i++) {
				extensionPointNodes[i] = NodeFactory.INSTANCE.creatExtensionPointNode(extensionPoints[i]);
			}
		}
		return extensionPointNodes;
	}

	private void initExtensionPoints() {
		extensionPoints = Platform.getExtensionRegistry().getExtensionPoints(id);
	}

	public ITreeNode[] getChildren() {
		return getExtensionPointNodes();
	}

	public ITreeNode getParent() {
		return null;
	}

	public boolean hasChildren() {
		initExtensionPoints();
		return extensionPoints.length > 0;
	}
	
	public String toString() {
		return id;
	}

	public Object accept(ITreeNodeVisitor visitor) {
		return visitor.visit(this);
	}
}
