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
	private final EPackageResolver ecore = new EPackageResolver(EcorePackage.eINSTANCE);
	private final EPackageResolver proto;
	
	public Resolver(EPackage sourceEPackage, CreatedClasses createdClasses) {
		this.createdClasses = createdClasses;
		this.proto = new EPackageResolver(sourceEPackage);
	}

	public EClassifierReference resolveTranslateReferencesTextualReferenceType(QualifiedName textualReferenceType) {
		return getAnyFromAll(textualReferenceType);
	}

	private EClassifierReference getAnyFromAll(QualifiedName qn) {
		return OR.<EClassifierReference>get(proto.getEClassifierReference(qn))
					.or(ecore.getEClassifierReference(qn))
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
		return ref == null ? null : ref.getEDataType();
	}

	public EClass resolveChangeInheritanceTargetProto(QualifiedName targetProto) {
		return lookupProtoClass(targetProto);
	}

	public EClassReference resolveChangeInheritanceSuperclass(QualifiedName superclass) {
		return lookupClass(superclass);
	}
	
	private EClass lookupProtoClass(QualifiedName modelReferenceTypeProto) {
		/* 
		 * We lookup in Ecore due to problems with determinig input model 
		 * bounds.
		 * To behave exactly right we must treat input package and all the
		 * packages it depends on as input class set.
		 * This simple hack assumes that input depends on no package
		 * except for Ecore and that Ecore classes are always skipped
		 * and never have AST images.
		 */
		ExistingEClass ref = 
			OR.<ExistingEClass>get(proto.getExistingEClass(modelReferenceTypeProto))
			.or(ecore.getExistingEClass(modelReferenceTypeProto))
			.getObj();
		return ref == null ? null : ref.getEClass();
	}

	private EClassReference lookupClass(QualifiedName superClassQN) {
		return OR.<EClassReference>get(proto.getExistingEClass(superClassQN))
			.or(ecore.getExistingEClass(superClassQN))
			.or(createdClasses.getReference(superClassQN))
			.getObj();
	}

}