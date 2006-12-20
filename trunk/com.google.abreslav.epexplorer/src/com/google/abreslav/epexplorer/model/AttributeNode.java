package com.google.abreslav.epexplorer.model;

public class AttributeNode implements ITreeNode {

	private static final ITreeNode[] NO_CHILDREN = new ITreeNode[0];

	private final ConfigurationElementNode configurationElementNode;

	private final String name;

	private final String value;

	public AttributeNode(
			final String name,
			final String value,
			final ConfigurationElementNode configurationElementNode) {
		super();
		this.configurationElementNode = configurationElementNode;
		this.name = name;
		this.value = value;
	}

	public ConfigurationElementNode getConfigurationElementNode() {
		return configurationElementNode;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public ITreeNode[] getChildren() {
		return NO_CHILDREN;
	}

	public ITreeNode getParent() {
		return getConfigurationElementNode();
	}

	public boolean hasChildren() {
		return false;
	}
	
	public String toString() {
		return name + " = " + value;
	}
	
	public Object accept(ITreeNodeVisitor visitor) {
		return visitor.visit(this);
	}
}
