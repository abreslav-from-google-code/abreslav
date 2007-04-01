/**
 * 
 */
package ru.ifmo.rain.astrans.interpreter;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;

import astrans.Attribute;
import astrans.CreateClass;
import astrans.EClassifierReference;
import astrans.Reference;
import astrans.StructuralFeature;
import astrans.Transformation;
import astrans.util.AstransSwitch;

class Composer extends AstransSwitch {

	private final ReferenceTranslator referenceTranslator;
	
	public Composer(final ReferenceTranslator referenceTranslator) {
		this.referenceTranslator = referenceTranslator;
	}

	public void run(Transformation transformation, AstransInterpreterTrace trace) {
		for (Iterator iter = transformation.getCreateClassActions().iterator(); iter.hasNext();) {
			CreateClass action = (CreateClass) iter.next();
			composeCreatedClass(action, trace);
		}
		for (Iterator iter = transformation.getInput().getEClassifiers().iterator(); iter.hasNext();) {
			EClassifier eClassifier = (EClassifier) iter.next();
		
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				EClass mappedClass = trace.getMappedClass(eClass);
				if (mappedClass != null) {
					composeMappedClass(eClass, trace);
				}
			}
		}
	}
	
	public void composeMappedClass(EClass proto, AstransInterpreterTrace trace) {
		assert proto != null;

		EClass image = trace.getMappedClass(proto);
		assert image != null;			
		
		image.setName(proto.getName() + "AS");
		image.setAbstract(proto.isAbstract());
		image.getEStructuralFeatures().addAll(EcoreUtil.copyAll(proto.getEAttributes()));
		
		EList references = proto.getEReferences();
		for (Iterator iter = references.iterator(); iter.hasNext();) {
			EReference eReference = (EReference) iter.next();
			EStructuralFeature feature = createReferenceFeature(
											(EClass) eReference.getEType(), 
											true // AST has no croos-references in it
											/*eReference.isContainment()*/);
			image.getEStructuralFeatures().add(feature);
			feature.setName(eReference.getName());
			feature.setLowerBound(eReference.getLowerBound());
			feature.setUpperBound(eReference.getUpperBound());
		}
		
		EList superTypes = proto.getESuperTypes();
		for (Iterator iter = superTypes.iterator(); iter.hasNext();) {
			EClass eClass = (EClass) iter.next();
			image.getESuperTypes().add(trace.getMappedClass(eClass));
		}
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
			result.getESuperTypes().add(referenceTranslator.resolveEClassifierReference(reference));
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
	
		EClass resolvedType = (EClass) referenceTranslator.resolveEClassifierReference(reference.getType());
		boolean containment = reference.isContainment();
		EStructuralFeature result = createReferenceFeature(resolvedType, containment);
		
		result.setName(reference.getName());
		result.setLowerBound(reference.getLowerBound());
		result.setUpperBound(reference.getUpperBound());
		
		return result;
	}

	private EStructuralFeature createReferenceFeature(EClass resolvedType, boolean containment) {
		EClassifier calculatedType = referenceTranslator.translateReferenceType(resolvedType);
		
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