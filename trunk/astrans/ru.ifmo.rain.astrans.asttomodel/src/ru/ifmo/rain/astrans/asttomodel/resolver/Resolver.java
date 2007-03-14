/**
 * 
 */
package ru.ifmo.rain.astrans.asttomodel.resolver;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;

import astrans.EClassReference;
import astrans.EClassifierReference;
import astransast.QualifiedName;

public class Resolver {		
	

	public EClassifierReference resolveTranslateReferencesTextualReferenceType(QualifiedName textualReferenceType) {
		// lookup classifier
		return null;
	}

	public EClass resolveTranslateReferencesModelReferenceTypeProto(QualifiedName modelReferenceTypeProto) {
		// lookup proto class
		return null;
	}

	public EClass resolveSkipClassTargetProto(QualifiedName targetProto) {
		// lookup proto class
		return null;
	}

	public EClassReference resolveCreateClassSuperclass(QualifiedName superClassQN) {
		// lookup EClass
		return null;
	}

	public EClassReference resolveReferenceType(QualifiedName type) {
		// lookup EClass
		return null;
	}

	public EDataType resolveAttributeType(QualifiedName type) {
		// lookup EDataType
		return null;
	}
}