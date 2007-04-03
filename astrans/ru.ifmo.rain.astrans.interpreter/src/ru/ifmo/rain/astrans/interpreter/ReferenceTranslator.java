/**
 * 
 */
package ru.ifmo.rain.astrans.interpreter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

import astrans.EClassifierReference;
import astrans.Transformation;
import astrans.TranslateReferences;

class ReferenceTranslator {
	
	private final AstransInterpreterTrace trace;
	private final Transformation transformation;
	private final ReferenceResolver referenceResolver;
	private final EClassSet skipper;
	private final EClassMap<EClassifier> translatedTypes = new EClassMap<EClassifier>();
	private final Map<EClass, EClassifier> referenceMap = new HashMap<EClass, EClassifier>();
	
	public ReferenceTranslator(Transformation transformation, AstransInterpreterTrace trace, EClassSet skipper) {
		this.transformation = transformation;
		this.trace = trace;
		this.skipper = skipper;
		this.referenceResolver = new ReferenceResolver(trace);

		for (Iterator iter = this.transformation.getTranslateReferencesActions().iterator(); iter.hasNext();) {
			TranslateReferences action = (TranslateReferences) iter.next();
			translatedTypes.put(
					action.getModelReferenceTypeProto(), 
					(EClassifier) referenceResolver.doSwitch(action.getTextualReferenceType()), 
					action.isIncludeDescendants());
		}
	}

	public EClassifier translateReferenceType(EClass eClass) {
		EClassifier result = trace.getMappedClass(eClass);
//		for (Iterator iter = transformation.getTranslateReferencesActions().iterator(); iter.hasNext();) {
//			TranslateReferences action = (TranslateReferences) iter.next();
//			EClass modelReferenceTypeProto = action.getModelReferenceTypeProto();
//			boolean applicable;
//			if (action.isIncludeDescendants()) {
//				applicable = modelReferenceTypeProto.isSuperTypeOf(eClass);
//			} else {
//				applicable = modelReferenceTypeProto == eClass;
//			}
//			if (applicable) {
//				EClassifier textualReferenceType = resolveEClassifierReference(action.getTextualReferenceType());
//				result = textualReferenceType;
//				break;
//			}
//		}
		EClassifier translatedType = translatedTypes.get(eClass);
		if (translatedType != null) {
			result = translatedType;
		}
		
		if (result == null) {
			if (!skipper.contains(eClass)) {
				result = eClass;
			}
		}
		
		return result;
	}
	
	public EClassifier resolveEClassifierReference(EClassifierReference reference) {
		return (EClassifier) referenceResolver.doSwitch(reference);
	}

}