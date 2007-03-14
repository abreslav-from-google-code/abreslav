/**
 * 
 */
package ru.ifmo.rain.astrans.asttomodel.resolver;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EcorePackage;

import astrans.AstransFactory;
import astrans.AstransPackage;
import astrans.EClassReference;
import astrans.EClassifierReference;
import astransast.AstransastPackage;
import astransast.QualifiedName;

public class Resolver {		
	
	private final EPackageResolver protoClasses = new EPackageResolver(
			AstransPackage.eINSTANCE
	);
	private final EPackageResolver astClasses = new EPackageResolver(
			AstransastPackage.eINSTANCE
	);
	private final EPackageResolver allClasses = new EPackageResolver(
			AstransPackage.eINSTANCE,
			AstransastPackage.eINSTANCE,
			EcorePackage.eINSTANCE
	);	
	
	public EClassifierReference resolveTranslateReferencesTextualReferenceType(QualifiedName textualReferenceType) {
		EClassifier classifier = astClasses.getEClassifier(textualReferenceType);
		EClassifierReference result;
		if (classifier.eClass().getClassifierID() == EcorePackage.EDATA_TYPE) {			
			result = AstransFactory.eINSTANCE.createExistingEDataType();
		}
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