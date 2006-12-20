package com.google.abreslav.epexplorer.model;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;

public class ExtensionPointNode implements ITreeNode {
	private final IExtensionPoint extensionPoint;

	private NamespaceNode namespaceNode;
	
	private ExtensionNode[] extensionNodes;

	private IExtension[] extensions;

	public ExtensionPointNode(final IExtensionPoint extensionPoint) {
		super();
		this.extensionPoint = extensionPoint;
	}

	public NamespaceNode getNamespaceNode() {
		if (namespaceNode == null) {
			namespaceNode = NodeFactory.INSTANCE.createNamespaceNode(extensionPoint.getNamespaceIdentifier());
			
		}
		return namespaceNode;
	}
	
	public IExtensionPoint getExtensionPoint() {
		return extensionPoint;
	}
	
	public ExtensionNode[] getExtensionNodes() {
		if (extensionNodes == null) {
			initExtensions();
			extensionNodes = new ExtensionNode[extensions.length];
			
			for (int i = 0; i < extensions.length; i++) {
				extensionNodes[i] = new PointsExtensionNode(extensions[i], this);
			}
			                                   
		}
		return extensionNodes;
	}

	private void initExtensions() {
		extensions = extensionPoint.getExtensions();
	}

	public ITreeNode[] getChildren() {
		return getExtensionNodes();
	}

	public ITreeNode getParent() {
		return getNamespaceNode();
	}

	public boolean hasChildren() {
		initExtensions();
		return extensions.length > 0;
	}
	
	public String toString() {
		String label = extensionPoint.getLabel();
		if ("".equals(label)) {
			label = extensionPoint.getUniqueIdentifier();
		} else {
			label += " (" + extensionPoint.getUniqueIdentifier() + ")"; 
		}
		return label;
	}
	
	public Object accept(ITreeNodeVisitor visitor) {
		return visitor.visit(this);
	}
}
