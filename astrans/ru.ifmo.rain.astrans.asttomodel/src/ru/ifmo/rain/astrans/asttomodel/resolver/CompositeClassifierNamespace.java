package ru.ifmo.rain.astrans.asttomodel.resolver;

import java.util.LinkedHashSet;
import java.util.Set;

import astrans.EClassifierReference;
import astransast.QualifiedName;

public class CompositeClassifierNamespace implements IClassifierNamespace<EClassifierReference> {

	private final Set<IClassifierNamespace<EClassifierReference>> children = new LinkedHashSet<IClassifierNamespace<EClassifierReference>>(); 

	public CompositeClassifierNamespace(IClassifierNamespace... children) {
		for (IClassifierNamespace<EClassifierReference> child : children) {
			this.children.add(child);
		}
	}
	
	public EClassifierReference getEClassifierReference(QualifiedName name) {
		for (IClassifierNamespace<EClassifierReference> child : children) {
			EClassifierReference classifierReference = child.getEClassifierReference(name);
			if (classifierReference != null) {
				return classifierReference;
			}			                                  
		}
		return null;
	}

}
