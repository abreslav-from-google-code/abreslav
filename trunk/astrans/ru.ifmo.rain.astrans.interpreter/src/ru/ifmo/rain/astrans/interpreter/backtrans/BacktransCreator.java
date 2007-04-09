package ru.ifmo.rain.astrans.interpreter.backtrans;

import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

import ru.ifmo.rain.astrans.interpreter.AstransInterpreterTrace;
import ru.ifmo.rain.astrans.interpreter.EClassSet;
import ru.ifmo.rain.astrans.interpreter.ReferenceTranslator;
import astransformation.AssignAttribute;
import astransformation.AssignReference;
import astransformation.AstransformationFactory;
import astransformation.MappingRule;
import astransformation.ResolveObject;
import astransformation.Transformation;

public class BacktransCreator {

	public static Transformation createBackTransformation(AstransInterpreterTrace trace, EClassSet skippedClasses, ReferenceTranslator referenceTranslator) {
		Transformation backTransformation = AstransformationFactory.eINSTANCE.createTransformation();
		backTransformation.setName("back");
		backTransformation.setResolverClassName("IResolver");
		backTransformation.setTraceClassName("ITracer");
	
		Set<Entry<EClass,EClass>> mappings = trace.getMappings();
		for (Entry<EClass, EClass> mapping : mappings) {
			MappingRule rule = AstransformationFactory.eINSTANCE.createMappingRule();
			backTransformation.getMappingRules().add(rule);
			rule.setName("case" + mapping.getValue().getName());

			rule.setResult(AstransformationFactory.eINSTANCE.createParameter());
			rule.getResult().setName(lowercaseFirstLetter(mapping.getKey().getName()));
			rule.getResult().setType(mapping.getKey());
			
			rule.setParameter(AstransformationFactory.eINSTANCE.createParameter());
			rule.getParameter().setType(mapping.getValue());
			rule.getParameter().setName(lowercaseFirstLetter(mapping.getValue().getName()));
		
			EList allAttributes = mapping.getKey().getEAllAttributes();
			for (Iterator iter = allAttributes.iterator(); iter.hasNext();) {
				EAttribute attribute = (EAttribute) iter.next();
				AssignAttribute assignAttribute = AstransformationFactory.eINSTANCE.createAssignAttribute();
				assignAttribute.setDest(attribute);
				assignAttribute.setSource(trace.getCorrespondingAttribute(attribute));
				rule.getAssignAttributeStatements().add(assignAttribute);
			}
			
			EList allReferences = mapping.getKey().getEAllReferences();
			for (Iterator iter = allReferences.iterator(); iter.hasNext();) {
				EReference reference = (EReference) iter.next();
				if (referenceTranslator.isTranslated(reference.getEReferenceType())) {
					ResolveObject resolveObject = AstransformationFactory.eINSTANCE.createResolveObject();
					resolveObject.setDest(reference);
					resolveObject.setSource(trace.getCorrespondingFeature(reference));
					resolveObject.setResolverMethodName("resolve" + mapping.getKey().getName() + uppercaseFirstLetter(reference.getName()));
					rule.getResolveObjectStatements().add(resolveObject);
				} else {
					AssignReference assignReference = AstransformationFactory.eINSTANCE.createAssignReference();
					assignReference.setDest(reference);
					assignReference.setSource((EReference) trace.getCorrespondingFeature(reference));
					assignReference.setMappingNeeded(!skippedClasses.contains(reference.getEReferenceType()));
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
