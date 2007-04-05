/**
 * 
 */
package ru.ifmo.rain.astrans.asttomodel.bootstrap.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

class MyEPackage implements IPackage {
	private final EPackage ePackage;
	private final Map<String, IPackage> packageMap = new HashMap<String, IPackage>();
	
	public MyEPackage(final EPackage ePackage) {
		this.ePackage = ePackage;
	}
	
	public String getName() {
		return ePackage.getName();
	}
	
	public EClassifier getEClassifier(String name) {
		return ePackage.getEClassifier(name);
	}
	
	public IPackage getSubIPackage(String name) {
		initPackageMap();
		return packageMap.get(name);
	}

	private void initPackageMap() {
		if (!packageMap.isEmpty()) {
			return;
		}
		EList subpackages = ePackage.getESubpackages();
		for (Iterator iter = subpackages.iterator(); iter.hasNext();) {
			EPackage subPackage = (EPackage) iter.next();
			packageMap.put(subPackage.getName(), new MyEPackage(subPackage));
		}
	}
	
	public EPackage getEPackage() {
		return ePackage;
	}
}