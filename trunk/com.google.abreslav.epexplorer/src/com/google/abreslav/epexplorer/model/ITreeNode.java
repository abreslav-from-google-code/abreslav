package com.google.abreslav.epexplorer.model;


public interface ITreeNode {
	ITreeNode getParent();
	boolean hasChildren();
	ITreeNode[] getChildren();	
	Object accept(ITreeNodeVisitor visitor);
}
