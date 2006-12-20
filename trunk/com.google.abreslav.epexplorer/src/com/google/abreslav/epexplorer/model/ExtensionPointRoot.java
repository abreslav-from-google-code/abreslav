package com.google.abreslav.epexplorer.model;

import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;

public class ExtensionPointRoot implements IRoot {

	public static final ExtensionPointRoot INSTANCE = new ExtensionPointRoot();
	
	private ExtensionPointNode[] extensionPointNodes;
	
	private ExtensionPointRoot() {		
	}
	
	public ITreeNode[] getChildren() {
		if (extensionPointNodes == null) {
			IExtensionPoint[] extensionPoints = Platform.getExtensionRegistry().getExtensionPoints();
			extensionPointNodes = new ExtensionPointNode[extensionPoints.length];
			for (int i = 0; i < extensionPoints.length; i++) {
				extensionPointNodes[i] = NodeFactory.INSTANCE.creatExtensionPointNode(extensionPoints[i]);
			}
		}

		return extensionPointNodes;
	}
}
