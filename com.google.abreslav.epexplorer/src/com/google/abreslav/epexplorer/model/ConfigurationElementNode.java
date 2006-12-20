package com.google.abreslav.epexplorer.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;

public class ConfigurationElementNode implements ITreeNode {

	private final IConfigurationElement configurationElement;

	private final ITreeNode parentNode;

	private ITreeNode[] childNodes;

	public ConfigurationElementNode(
			final IConfigurationElement configurationElement,
			final ITreeNode parentNode) {
		super();
		this.configurationElement = configurationElement;
		this.parentNode = parentNode;
	}

	public IConfigurationElement getConfigurationElement() {
		return configurationElement;
	}

	public ITreeNode[] getChildren() {
		if (childNodes == null) {
			// ITreeNode
			List children = new ArrayList();
			
			String value = configurationElement.getValue();
			if (value != null && value.length() > 0) {
				children.add(new AttributeNode("", value, this));
			}
			
			String[] attributeNames = configurationElement.getAttributeNames();
			for (int i = 0; i < attributeNames.length; i++) {
				children.add(new AttributeNode(
						attributeNames[i], 
						configurationElement.getAttribute(attributeNames[i]), 
						this
				));
			}
			
			IConfigurationElement[] configurationElements = configurationElement.getChildren();
			for (int i = 0; i < configurationElements.length; i++) {
				children.add(new ConfigurationElementNode(configurationElements[i], this));
			}
			
			childNodes = (ITreeNode[]) children.toArray(new ITreeNode[children.size()]);
		}
		return childNodes;
	}

	public ITreeNode getParent() {
		return parentNode;
	}

	public boolean hasChildren() {
		return getChildren().length > 0;
	}

	public String toString() {
		String result = configurationElement.getName();
		String label = configurationElement.getAttribute("label");
		if (label == null) {
			label = configurationElement.getAttribute("name");
		}
		if (label != null) {
			result = label + " (" + result + ")";
		}
		return result;
	}

	public Object accept(ITreeNodeVisitor visitor) {
		return visitor.visit(this);
	}
}
