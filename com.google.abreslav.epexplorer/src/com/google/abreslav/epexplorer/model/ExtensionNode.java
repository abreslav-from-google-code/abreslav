package com.google.abreslav.epexplorer.model;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;

public abstract class ExtensionNode implements ITreeNode {

	protected final IExtension extension;

	private ConfigurationElementNode[] configurationElementNodes;

	public ExtensionNode(final IExtension extension) {
		super();
		this.extension = extension;
	}

	public ITreeNode[] getChildren() {
		if (configurationElementNodes == null) {
			IConfigurationElement[] configurationElements = extension.getConfigurationElements();
			configurationElementNodes = new ConfigurationElementNode[configurationElements.length];
			
			for (int i = 0; i < configurationElements.length; i++) {
				configurationElementNodes[i] = new ConfigurationElementNode(
					configurationElements[i],
					this
				);
			}
		}
		return configurationElementNodes;
	}

	public boolean hasChildren() {
		return getChildren().length > 0;
	}
	
	public Object accept(ITreeNodeVisitor visitor) {
		return visitor.visit(this);
	}
}
