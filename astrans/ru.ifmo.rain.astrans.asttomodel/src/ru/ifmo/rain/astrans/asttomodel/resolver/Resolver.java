package ru.ifmo.rain.astrans.asttomodel.resolver;


import java.io.IOException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;

import ru.ifmo.rain.astrans.asttomodel.IFileResolver;
import ru.ifmo.rain.astrans.utils.EMFHelper;

import utils.OR;
import astrans.AstransFactory;
import astrans.EClassReference;
import astrans.EClassifierReference;
import astrans.ExistingEClass;
import astrans.ExistingEDataType;
import astrans.MappedEClass;
import astransast.EClassifierReferenceAS;
import astransast.EPackagePath;
import astransast.EPackageReference;
import astransast.EPackageUri;
import astransast.MappedEClassAS;
import astransast.QualifiedName;
import astransast.util.AstransastSwitch;

public class Resolver {		
	
	private class ClassifierReferenceResolver extends AstransastSwitch {
		@Override
		public MappedEClass caseMappedEClassAS(MappedEClassAS object) {
			EClass proto = lookupProtoClass(object.getProto());
			MappedEClass mappedEClass = AstransFactory.eINSTANCE.createMappedEClass();
			mappedEClass.setProto(proto);
			return mappedEClass;
		}

		@Override
		public EClassifierReference caseQualifiedName(QualifiedName object) {
			// Any class
			return OR.<EClassReference>get(proto.getExistingEClass(object))
				.or(ecore.getExistingEClass(object))
				.or(createdClasses.getReference(object))
				.getObj();
		}
	}

	private final AstransastSwitch classReferenceResolver = new ClassifierReferenceResolver();
	private final AstransastSwitch classifierReferenceResolver = new ClassifierReferenceResolver() {
		@Override
		public EClassifierReference caseQualifiedName(QualifiedName qn) {
			// Any classifier
			return OR.<EClassifierReference>get(proto.getEClassifierReference(qn))
				.or(ecore.getEClassifierReference(qn))
				.or(createdClasses.getReference(qn))
				.getObj();
		}
	};
	
	private final CreatedClasses createdClasses;
	private final EPackageResolver ecore = new EPackageResolver(EcorePackage.eINSTANCE);
	private final EPackageResolver proto;
	private final IFileResolver fileResolver;
	private final AstransastSwitch inputEPackageResolver = new AstransastSwitch() {
		@Override
		public Object caseEPackageUri(EPackageUri object) {
			return EPackage.Registry.INSTANCE.getEPackage(object.getUri());
		}
		
		@Override
		public Object caseEPackagePath(EPackagePath object) {
			Resource resource = EMFHelper.getXMIResource(EcorePackage.eINSTANCE, object.getPath());
			try {
				EMFHelper.loadResourceFromFile(resource, fileResolver.getFile(object.getPath()));
			} catch (IOException e) {
				throw new IllegalArgumentException(e);
			}
			return resource.getContents().get(0);
		}
	};			

	
	public Resolver(EPackage sourceEPackage, CreatedClasses createdClasses, IFileResolver fileResolver) {
		this.createdClasses = createdClasses;
		this.proto = new EPackageResolver(sourceEPackage);
		this.fileResolver = fileResolver;
	}

	public EClassifierReference resolveTranslateReferencesTextualReferenceType(EClassifierReferenceAS textualReferenceType) {
		return (EClassifierReference) classifierReferenceResolver.doSwitch(textualReferenceType);
	}

	public EClass resolveTranslateReferencesModelReferenceTypeProto(QualifiedName modelReferenceTypeProto) {
		return lookupProtoClass(modelReferenceTypeProto);
	}

	public EClass resolveSkipClassTargetProto(QualifiedName targetProto) {
		return lookupProtoClass(targetProto);
	}

	public EClassReference resolveCreateClassSuperclass(EClassifierReferenceAS superClassQN) {
		return lookupClass(superClassQN);
	}

	public EClassReference resolveReferenceType(EClassifierReferenceAS type) {
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

	public EClassReference resolveChangeInheritanceSuperclass(EClassifierReferenceAS superclass) {
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

	private EClassReference lookupClass(EClassifierReferenceAS classifierReferenceAS) {
		return (EClassReference) classReferenceResolver.doSwitch(classifierReferenceAS);
	}

	public EPackage resolveTransformationInput(EPackageReference inputAS) {
		return (EPackage) inputEPackageResolver.doSwitch(inputAS);
	}
	
}