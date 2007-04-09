/**
 * 
 */
package ru.ifmo.rain.astrans.asttomodel.bootstrap.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import astrans.AstransFactory;
import astrans.ExistingEClass;
import astrans.ExistingEDataType;
import astransast.QualifiedName;

class EPackageResolver extends ClassifierNamespace {

	private final Map<String, IPackage> packageMap = new HashMap<String, IPackage>();

	public EPackageResolver(EPackage... ePackages) {
		for (EPackage ePackage : ePackages) {
			packageMap.put(ePackage.getName(), new MyEPackage(ePackage));

		}
	}

	private IPackage getEPackage(Iterator<String> qn) {
		IPackage ePackage = packageMap.get(qn.next());
		while (qn.hasNext() && ePackage != null) {
			ePackage = ePackage.getSubIPackage(qn.next());
		}
		if (ePackage == null) {
			return null;
		}
		return ePackage;
	}

	public EPackage getEPackage(QualifiedName qn) {
		IterableQN iterableQN = new IterableQN(qn);
		IPackage iPackage = getEPackage(iterableQN.iterator());
		return iPackage.getEPackage();
	}

	public EClassifier getEClassifier(QualifiedName qn) {
		IterableClassQN iterableClassQN = new IterableClassQN(qn);
		IPackage ePackage = getEPackage(iterableClassQN.iterator());
		if (ePackage == null) {
			return null;
		}		
		return ePackage.getEClassifier(iterableClassQN.getClassName());
	}

	public ExistingEClass getExistingEClass(QualifiedName name) {
		EClassifier classifier = getEClassifier(name);
		if (classifier == null) {
			return null;
		}		
		if (classifier.eClass().getClassifierID() == EcorePackage.ECLASS) {
			ExistingEClass eClass = AstransFactory.eINSTANCE
				.createExistingEClass();
			eClass.setEClass((EClass) classifier);
			return eClass;
		}
		return null;
	}

	public ExistingEDataType getExistingEDataType(QualifiedName name) {
		EClassifier classifier = getEClassifier(name);
		if (classifier == null) {
			return null;
		}		
		if (classifier.eClass().getClassifierID() == EcorePackage.EDATA_TYPE) {		
			ExistingEDataType dataType = AstransFactory.eINSTANCE
					.createExistingEDataType();
			dataType.setEDataType((EDataType) classifier);
			return dataType;
		}
		return null;
	}

}