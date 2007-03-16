package ru.ifmo.rain.astrans.asttomodel.resolver;

import astrans.EClassifierReference;
import astransast.QualifiedName;

public interface IClassifierNamespace<T extends EClassifierReference> {

	/**
	 * Returns a reference to a classifier with given QN 
	 * @param name classifiers qualified name
	 * @return a reference of an appropriate type or <code>null</code> if nothing found
	 */
	T getEClassifierReference(QualifiedName name);

}