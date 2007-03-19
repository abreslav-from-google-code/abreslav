/**
 * 
 */
package ru.ifmo.rain.astrans.asttomodel.resolver;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import utils.OR;

import astrans.EClassReference;
import astrans.EClassifierReference;
import astrans.ExistingEClass;
import astrans.ExistingEDataType;
import astransast.QualifiedName;

public class Resolver {		
	
	private final CreatedClasses createdClasses;
	private final MappedClasses mappedClasses;	
	private final EPackageResolver ecore = new EPackageResolver(EcorePackage.eINSTANCE);
	private final EPackageResolver proto;
	
	public Resolver(EPackage sourceEPackage, CreatedClasses createdClasses, MappedClasses mappedClasses) {
		this.createdClasses = createdClasses;
		this.mappedClasses = mappedClasses;
		this.proto = new EPackageResolver(sourceEPackage);
	}

	public EClassifierReference resolveTranslateReferencesTextualReferenceType(QualifiedName textualReferenceType) {
		return getAnyFromAll(textualReferenceType);
	}

	private EClassifierReference getAnyFromAll(QualifiedName qn) {
		return OR.<EClassifierReference>get(proto.getEClassifierReference(qn))
					.or(ecore.getEClassifierReference(qn))
					.or(mappedClasses.getReference(qn))
					.or(createdClasses.getReference(qn))
					.getObj();
	}

	public EClass resolveTranslateReferencesModelReferenceTypeProto(QualifiedName modelReferenceTypeProto) {
		return lookupProtoClass(modelReferenceTypeProto);
	}

	public EClass resolveSkipClassTargetProto(QualifiedName targetProto) {
		return lookupProtoClass(targetProto);
	}

	public EClassReference resolveCreateClassSuperclass(QualifiedName superClassQN) {
		return lookupClass(superClassQN);
	}

	public EClassReference resolveReferenceType(QualifiedName type) {
		return lookupClass(type);
	}

	public EDataType resolveAttributeType(QualifiedName type) {
		ExistingEDataType ref = OR
			.get(ecore.getExistingEDataType(type))
			.or(proto.getExistingEDataType(type))
			.getObj();
		if (ref == null) {
			return null;
		}
		return ref.getEDataType();
	}

	private EClass lookupProtoClass(QualifiedName modelReferenceTypeProto) {
		ExistingEClass ref = proto.getExistingEClass(modelReferenceTypeProto);
		if (ref == null) {
			return null;
		}
		return ref.getEClass();
	}

	private EClassReference lookupClass(QualifiedName superClassQN) {
		return OR.<EClassReference>get(proto.getExistingEClass(superClassQN))
			.or(ecore.getExistingEClass(superClassQN))
			.or(mappedClasses.getReference(superClassQN))
			.or(createdClasses.getReference(superClassQN))
			.getObj();
	}

}