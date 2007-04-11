/**
 * 
 */
package ru.ifmo.rain.astrans.interpreter;

import java.util.Iterator;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;

import trace.ReferenceMappingType;

import astrans.Attribute;
import astrans.CreateClass;
import astrans.EClassifierReference;
import astrans.Reference;
import astrans.StructuralFeature;
import astrans.Transformation;
import astrans.util.AstransSwitch;

class Composer extends AstransSwitch {

	private final EClassMap<EClassifier> translatedTypes;
	private final AstransInterpreterTrace trace;
	private final EClassSet skippedClasses;
	private final ReferenceResolver referenceResolver;

	public Composer(final EClassMap<EClassifier> translatedTypes, final AstransInterpreterTrace trace, final EClassSet skippedClasses, final ReferenceResolver referenceResolver) {
		this.translatedTypes = translatedTypes;
		this.trace = trace;
		this.skippedClasses = skippedClasses;
		this.referenceResolver = referenceResolver;
	}

	private EClassifier translateReferenceType(EClass eClass) {
		EClassifier translatedType = translatedTypes.get(eClass);
		if (translatedType != null) {
			return translatedType;
		}
		
		EClassifier result = trace.getMappedClass(eClass);
		if (result == null) {
			if (!skippedClasses.contains(eClass)) {
				result = eClass;
			}
		}
		
		return result;
	}
	
	public void run(Transformation transformation) {
		for (Iterator iter = transformation.getCreateClassActions().iterator(); iter.hasNext();) {
			CreateClass action = (CreateClass) iter.next();
			composeCreatedClass(action, trace);
		}
		for (Entry<EClass, EClass> mapping : trace.getMappings()) {
			composeMappedClass(mapping.getKey(), trace);
		}
	}
	
	public void composeMappedClass(EClass proto, AstransInterpreterTrace trace) {
		assert proto != null;

		EClass image = trace.getMappedClass(proto);
		assert image != null;			
		
		image.setName(proto.getName() + "AS");
		image.setAbstract(proto.isAbstract());

		EList attributes = proto.getEAttributes();
		for (Iterator iter = attributes.iterator(); iter.hasNext();) {
			EAttribute attribute = (EAttribute) iter.next();
			EAttribute copy = (EAttribute) EcoreUtil.copy(attribute);
			image.getEStructuralFeatures().add(copy);
			trace.registerAttribute(attribute, copy);
		}
		
		EList references = proto.getEReferences();
		for (Iterator iter = references.iterator(); iter.hasNext();) {
			EReference eReference = (EReference) iter.next();
			EStructuralFeature feature = createReferenceFeature(
											eReference.getEReferenceType(), 
											true // AST has no cross-references in it
											/*eReference.isContainment()*/);
			image.getEStructuralFeatures().add(feature);
			feature.setName(eReference.getName());
			feature.setLowerBound(eReference.getLowerBound());
			feature.setUpperBound(eReference.getUpperBound());
			
			trace.registerReference(eReference, feature, getMappingType(eReference));
		}
		
		EList superTypes = proto.getESuperTypes();
		for (Iterator iter = superTypes.iterator(); iter.hasNext();) {
			EClass eClass = (EClass) iter.next();
			image.getESuperTypes().add(trace.getMappedClass(eClass));
		}
	}

	private ReferenceMappingType getMappingType(EReference eReference) {
		ReferenceMappingType mappingType;
		if (translatedTypes.get(eReference.getEReferenceType()) != null) {
			mappingType = ReferenceMappingType.TRANSLATED_LITERAL;
		} else {
			mappingType = skippedClasses.contains(eReference.getEReferenceType()) 
				? ReferenceMappingType.NONE_LITERAL
				: ReferenceMappingType.MAPPED_LITERAL;
		}
		return mappingType;
	}

	public void composeCreatedClass(CreateClass action, AstransInterpreterTrace trace) {
		EClass result = trace.getCreatedClass(action);
		assert result != null;			
		
		result.setName(action.getName());
		result.setAbstract(action.isAbstract());
		
		EList structuralFeatures = action.getStructuralFeatures();
		for (Iterator iter = structuralFeatures.iterator(); iter.hasNext();) {
			StructuralFeature feature = (StructuralFeature) iter.next();
			result.getEStructuralFeatures().add(doSwitch(feature));
		}
		
		EList superclasses = action.getSuperclasses();
		for (Iterator iter = superclasses.iterator(); iter.hasNext();) {
			EClassifierReference reference = (EClassifierReference) iter.next();
			result.getESuperTypes().add(referenceResolver.resolveEClassifierReference(reference));
		}
	}

	@Override
	public EAttribute caseAttribute(Attribute attribute) {
		assert attribute != null;
		
		EAttribute result = EcoreFactory.eINSTANCE.createEAttribute();
		result.setName(attribute.getName());
		result.setLowerBound(attribute.getLowerBound());
		result.setUpperBound(attribute.getUpperBound());
		result.setEType(attribute.getType());
		return result;
	}

	@Override
	public EStructuralFeature caseReference(Reference reference) {
		assert reference != null;
	
		EClass resolvedType = (EClass) referenceResolver.resolveEClassifierReference(reference.getType());
		boolean containment = reference.isContainment();
		EStructuralFeature result = createReferenceFeature(resolvedType, containment);
		
		result.setName(reference.getName());
		result.setLowerBound(reference.getLowerBound());
		result.setUpperBound(reference.getUpperBound());
		
		return result;
	}

	private EStructuralFeature createReferenceFeature(EClass type, boolean containment) {
		EClassifier calculatedType = translateReferenceType(type);
		
		EStructuralFeature result;
		if (calculatedType instanceof EClass || calculatedType == null) {
			EReference ref = EcoreFactory.eINSTANCE.createEReference();
			ref.setContainment(containment);
			result = ref;
		} else {
			result = EcoreFactory.eINSTANCE.createEAttribute();
		}
		assert result != null;
		result.setEType(calculatedType);
		return result;
	}

}