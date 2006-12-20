package com.google.abreslav.epexplorer.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

public class ContributorRoot implements IRoot {

	public static final ContributorRoot INSTANCE = new ContributorRoot();
	
	private ContributorNode[] contributorNodes;
	
	private ContributorRoot() {		
	}
	
	public ITreeNode[] getChildren() {
		if (contributorNodes == null) {
			// IContributor => Set<IExtension>
			Map extensionsMap = new HashMap();
			
			IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
			IExtensionPoint[] extensionPoints = extensionRegistry.getExtensionPoints();
			for (int i = 0; i < extensionPoints.length; i++) {
				IExtension[] extensions = extensionPoints[i].getExtensions();
				for (int j = 0; j < extensions.length; j++) {
					IContributor contributor = extensions[j].getContributor();
					Set contributorsExtensions = (Set) extensionsMap.get(contributor);
					if (contributorsExtensions == null) {
						contributorsExtensions = new HashSet();
						extensionsMap.put(contributor, contributorsExtensions);
					}
					contributorsExtensions.add(extensions[j]);
				}
			}

			Set entries = extensionsMap.entrySet();
			contributorNodes = new ContributorNode[entries.size()];
			int k = 0; 
			for (Iterator i = entries.iterator(); i.hasNext();) {
				Map.Entry entry = (Map.Entry) i.next();
				contributorNodes[k] = new ContributorNode(
						(IContributor) entry.getKey(),
						(Set) entry.getValue()
				);
				k++;
			}
		}

		return contributorNodes;
	}
	
	public String toString() {
		return "contributors";
	}

	public boolean isTopLevelElement(Object element) {
		return element instanceof ContributorNode;
	}
}
