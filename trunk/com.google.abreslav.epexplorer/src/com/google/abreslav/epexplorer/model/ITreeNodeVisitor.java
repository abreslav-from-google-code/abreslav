package com.google.abreslav.epexplorer.model;

public interface ITreeNodeVisitor {
	Object visit(AttributeNode node);
	Object visit(ConfigurationElementNode node);
	Object visit(ExtensionNode node);
	Object visit(ExtensionPointNode node);
	Object visit(NamespaceNode node);
	Object visit(ContributorNode node);
}
