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
import astrans.ExistingEClass;
import astrans.ExistingEDataType;
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
		return lookupProtoClass(modelReferenceTypeProto);
	}

	private EClass lookupProtoClass(QualifiedName modelReferenceTypeProto) {
		EClassifierReference ref = proto.getEClassifierReference(modelReferenceTypeProto);
		if (ref instanceof ExistingEClass) {
			return ((ExistingEClass) ref).getEClass();
		}
		return null;
	}

	public EClass resolveSkipClassTargetProto(QualifiedName targetProto) {
		return lookupProtoClass(targetProto);
	}

	public EClassReference resolveCreateClassSuperclass(QualifiedName superClassQN) {
		return lookupClass(superClassQN);
	}

	private EClassReference lookupClass(QualifiedName superClassQN) {
		EClassifierReference ref = all.getEClassifierReference(superClassQN);
		if (ref instanceof EClassReference) {
			return (EClassReference) ref;
		}
		return null;
	}

	public EClassReference resolveReferenceType(QualifiedName type) {
		return lookupClass(type);
	}

	public EDataType resolveAttributeType(QualifiedName type) {
		EClassifierReference ref = all.getEClassifierReference(type);
		if (ref instanceof ExistingEDataType) {
			return (EDataType) ref;
		}
		return null;
	}
}