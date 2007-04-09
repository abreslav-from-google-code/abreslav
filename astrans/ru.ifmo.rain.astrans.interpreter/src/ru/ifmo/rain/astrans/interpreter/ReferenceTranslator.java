/**
 * 
 */
package ru.ifmo.rain.astrans.interpreter;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

import astrans.EClassifierReference;
import astrans.Transformation;
import astrans.TranslateReferences;

public class ReferenceTranslator {
	
	private final AstransInterpreterTrace trace;
	private final ReferenceResolver referenceResolver;
	private final EClassSet skippedClasses;
	private final EClassMap<EClassifier> translatedTypes = new EClassMap<EClassifier>();
	
	public ReferenceTranslator(Transformation transformation, AstransInterpreterTrace trace, EClassSet skippedClasses) {
		this.trace = trace;
		this.skippedClasses = skippedClasses;
		this.referenceResolver = new ReferenceResolver(trace);

		for (Iterator iter = transformation.getTranslateReferencesActions().iterator(); iter.hasNext();) {
			TranslateReferences action = (TranslateReferences) iter.next();
			translatedTypes.put(
					action.getModelReferenceTypeProto(), 
					(EClassifier) referenceResolver.doSwitch(action.getTextualReferenceType()), 
					action.isIncludeDescendants());
		}
	}

	public EClassifier translateReferenceType(EClass eClass) {
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
	
	public boolean isTranslated(EClass eClass) {
		return translatedTypes.get(eClass) != null;
	}
	
	public EClassifier resolveEClassifierReference(EClassifierReference reference) {
		return (EClassifier) referenceResolver.doSwitch(reference);
	}

}