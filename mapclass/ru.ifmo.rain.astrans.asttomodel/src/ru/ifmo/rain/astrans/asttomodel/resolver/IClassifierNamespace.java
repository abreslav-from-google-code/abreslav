package ru.ifmo.rain.astrans.asttomodel.resolver;

import astrans.CreatedEClass;
import astrans.EClassReference;
import astrans.EClassifierReference;
import astrans.ExistingEClass;
import astrans.ExistingEDataType;
import astrans.MappedEClass;
import astransast.QualifiedName;

public interface IClassifierNamespace {

	/**
	 * Returns a reference to a classifier with given QN 
	 * @param name classifiers qualified name
	 * @return a reference of an appropriate type or <code>null</code> if nothing found
	 */
	EClassifierReference getEClassifierReference(QualifiedName name);
	EClassReference getEClassReference(QualifiedName name);
	ExistingEClass getExistingEClass(QualifiedName name);
	ExistingEDataType getExistingEDataType(QualifiedName name);
	CreatedEClass getCreatedEClass(QualifiedName name);
	MappedEClass getMappedEClass(QualifiedName name);
}