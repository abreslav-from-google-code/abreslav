package com.google.abreslav.epexplorer.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtension;

public class ContributorNode implements ITreeNode {

	private final IContributor contributor;
	private ExtensionNode[] extensionNodes;
	// ExtensionNodes
	private final Set children;
	
	
	public ContributorNode(final IContributor contributor, Collection children) {
		super();
		this.contributor = contributor;
		this.children = new HashSet(children);
	}
	
	public IContributor getContributor() {
		return contributor;
	}

	public Object accept(ITreeNodeVisitor visitor) {
		return visitor.visit(this);
	}

	public ITreeNode[] getChildren() {
		if (extensionNodes == null) {
			extensionNodes = new ContributorsExtensionNode[children.size()];
			int i = 0;
			for (Iterator iter = children.iterator(); iter.hasNext();) {
				IExtension extension = (IExtension) iter.next();
				extensionNodes[i] = new ContributorsExtensionNode(extension, this);
				i++;
			}
		}

		return extensionNodes;
	}

	public ITreeNode getParent() {
		return null;
	}

	public boolean hasChildren() {
		return !children.isEmpty();
	}
	
	public String toString() {
		return contributor.getName();
	}

}
