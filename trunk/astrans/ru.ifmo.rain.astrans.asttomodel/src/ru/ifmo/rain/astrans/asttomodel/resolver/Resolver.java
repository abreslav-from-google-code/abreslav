/**
 * 
 */
package ru.ifmo.rain.astrans.asttomodel.resolver;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import astrans.CreatedEClass;
import astrans.EClassReference;
import astrans.EClassifierReference;
import astrans.MappedEClass;
import astransast.QualifiedName;

public class Resolver {		
	
	private final IClassifierNamespace<CreatedEClass> createdClasses;
	private final IClassifierNamespace<MappedEClass> mappedClasses;	
	private final EPackageResolver ecore = new EPackageResolver(EcorePackage.eINSTANCE);
	private final EPackageResolver proto;
	
	private final IClassifierNamespace<EClassifierReference> all;
	
	public Resolver(EPackage sourceEPackage, IClassifierNamespace<CreatedEClass> createdClasses, IClassifierNamespace<MappedEClass> mappedClasses) {
		this.createdClasses = createdClasses;
		this.mappedClasses = mappedClasses;
		this.proto = new EPackageResolver(sourceEPackage);
		this.all = new CompositeClassifierNamespace(
				this.proto,
				this.createdClasses,
				this.mappedClasses,
				this.ecore
		);
	}

	public EClassifierReference resolveTranslateReferencesTextualReferenceType(QualifiedName textualReferenceType) {
		return all.getEClassifierReference(textualReferenceType);
	}

	public EClass resolveTranslateReferencesModelReferenceTypeProto(QualifiedName modelReferenceTypeProto) {
		// lookup proto class
		EClassifierReference ref = proto.getEClassifierReference(modelReferenceTypeProto);
		if (false == ref instanceof EClassReference) {
			return null;
		}
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