package ru.ifmo.rain.astrans.interpreter.backtrans;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;

import trace.ClassMapping;
import trace.ReferenceMapping;
import trace.ReferenceMappingType;
import astransformation.AssignAttribute;
import astransformation.AssignReference;
import astransformation.AstransformationFactory;
import astransformation.MappingRule;
import astransformation.ResolveObject;
import astransformation.Transformation;

public class BacktransCreator {

	public static Transformation createBackTransformation(TraceAdapter trace) {
		Transformation backTransformation = AstransformationFactory.eINSTANCE.createTransformation();
		backTransformation.setName("back");
		backTransformation.setResolverClassName("IResolver");
		backTransformation.setTraceClassName("ITracer");
	
		Collection<ClassMapping> mappings = trace.getClassMappings();
		for (ClassMapping mapping : mappings) {
			MappingRule rule = AstransformationFactory.eINSTANCE.createMappingRule();
			backTransformation.getMappingRules().add(rule);
			rule.setName("case" + mapping.getImage().getName());

			rule.setResult(AstransformationFactory.eINSTANCE.createParameter());
			rule.getResult().setName(lowercaseFirstLetter(mapping.getProto().getName()));
			rule.getResult().setType(mapping.getProto());
			
			rule.setParameter(AstransformationFactory.eINSTANCE.createParameter());
			rule.getParameter().setType(mapping.getImage());
			rule.getParameter().setName(lowercaseFirstLetter(mapping.getImage().getName()));
		
			EList allAttributes = mapping.getProto().getEAllAttributes();
			for (Iterator iter = allAttributes.iterator(); iter.hasNext();) {
				EAttribute attribute = (EAttribute) iter.next();
				AssignAttribute assignAttribute = AstransformationFactory.eINSTANCE.createAssignAttribute();
				assignAttribute.setDest(attribute);
				assignAttribute.setSource(trace.getAttributeMapping(attribute).getImage());
				rule.getAssignAttributeStatements().add(assignAttribute);
			}
			
			EList allReferences = mapping.getProto().getEAllReferences();
			for (Iterator iter = allReferences.iterator(); iter.hasNext();) {
				EReference reference = (EReference) iter.next();
				ReferenceMapping referenceMapping = trace.getReferenceMapping(reference);
				if (referenceMapping.getType() == ReferenceMappingType.TRANSLATED_LITERAL) {
					ResolveObject resolveObject = AstransformationFactory.eINSTANCE.createResolveObject();
					resolveObject.setDest(reference);
					resolveObject.setSource(referenceMapping.getImage());
					resolveObject.setResolverMethodName("resolve" + mapping.getProto().getName() + uppercaseFirstLetter(reference.getName()));
					rule.getResolveObjectStatements().add(resolveObject);
				} else {
					AssignReference assignReference = AstransformationFactory.eINSTANCE.createAssignReference();
					assignReference.setDest(reference);
					assignReference.setSource((EReference) referenceMapping.getImage());
					assignReference.setMappingNeeded(referenceMapping.getType() != ReferenceMappingType.NONE_LITERAL);
					rule.getAssignReferenceStatements().add(assignReference);
				}
			}
		}
		
		return backTransformation;
	}

	private static String lowercaseFirstLetter(String name) {
		return Character.toLowerCase(name.charAt(0)) + name.substring(1);
	}
	
	private static String uppercaseFirstLetter(String name) {
		return Character.toUpperCase(name.charAt(0)) + name.substring(1);
	}
	
}
