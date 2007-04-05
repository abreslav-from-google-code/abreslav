/**
 * 
 */
package ru.ifmo.rain.astrans.asttomodel.bootstrap.impl;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

interface IPackage {
	
	String getName();
	
	EClassifier getEClassifier(String name);
	
	IPackage getSubIPackage(String name);
	
	EPackage getEPackage();
	
}