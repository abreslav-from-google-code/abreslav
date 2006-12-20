package com.google.abreslav.epexplorer.model;

import org.eclipse.core.runtime.IExtension;

public class ContributorsExtensionNode extends ExtensionNode {

	private final ContributorNode contributonNode;

	public ContributorsExtensionNode(IExtension extension, ContributorNode contributorNode) {
		super(extension);
		this.contributonNode = contributorNode;
	}

	public ITreeNode getParent() {
		return contributonNode;
	}

	public String toString() {
		String label = extension.getLabel();
		if ("".equals(label)) {
			label = extension.getExtensionPointUniqueIdentifier();
		} else {
			label += " (" + extension.getExtensionPointUniqueIdentifier() + ")";
		}
		return label;
	}

}
