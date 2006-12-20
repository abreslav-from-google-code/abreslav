package com.google.abreslav.epexplorer.model;

import org.eclipse.core.runtime.IExtension;

public class PointsExtensionNode extends ExtensionNode {

	private final ExtensionPointNode extensionPointNode;

	public PointsExtensionNode(IExtension extension, ExtensionPointNode extensionPointNode) {
		super(extension);
		this.extensionPointNode = extensionPointNode;
	}

	public ITreeNode getParent() {
		return extensionPointNode;
	}

	public String toString() {
		String label = extension.getLabel();
		if ("".equals(label)) {
			label = extension.getNamespaceIdentifier();
		} else {
			label += " (" + extension.getNamespaceIdentifier() + ")";
		}
		return label;
	}

}
