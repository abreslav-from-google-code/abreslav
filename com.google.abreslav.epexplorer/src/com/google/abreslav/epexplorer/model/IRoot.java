package com.google.abreslav.epexplorer.model;

public interface IRoot {

	ITreeNode[] getChildren();
	boolean isTopLevelElement(Object element);
	
}
