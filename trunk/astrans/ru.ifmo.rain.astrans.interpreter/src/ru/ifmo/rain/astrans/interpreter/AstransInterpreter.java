package ru.ifmo.rain.astrans.interpreter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;

import astrans.CreateClass;
import astrans.SkipClass;
import astrans.Transformation;


/*
 * Features to be supported:
 *   1. Manage containment on reference translation
 *   2. Change inheritance
 *   3. Test everything
 */
public class AstransInterpreter {

//	private final AstransInterpreterTrace trace;
//	
//	private final ReferenceTranslator referenceTranslator;
//	
//	private final Composer composer;
//	
//	private AstransInterpreter(final Transformation transformation) {
//		this.trace = new AstransInterpreterTrace();
//		this.referenceTranslator = new ReferenceTranslator(transformation, trace);
//		this.composer = new Composer(referenceTranslator);
//	}

	public static Collection<EClass> createEClassObjects(Transformation transformation, AstransInterpreterTrace trace, Skipper skipper) {
		ArrayList<EClass> classes = new ArrayList<EClass>();
		mapClasses(transformation, trace, classes, skipper);
		createClasses(transformation, trace, classes);
		return classes;
	}

	private static void mapClasses(Transformation transformation, AstransInterpreterTrace trace, Collection<EClass> classes, Skipper skipper) {
		EList classifiers = transformation.getInput().getEClassifiers();
		for (Iterator iter = classifiers.iterator(); iter.hasNext();) {
			EClassifier eClassifier = (EClassifier) iter.next();
			if (eClassifier instanceof EClass) {
				EClass proto = (EClass) eClassifier;

				if (skipper.isSkipped(proto)) {
					continue;
				}	
				
				EClass image = EcoreFactory.eINSTANCE.createEClass();
				trace.registerMappedClass(proto, image);
				
				classes.add(image);
			}
		}
	}

	private static Skipper createSkipper(Transformation transformation) {
		Skipper skipper = new Skipper();
		for (Iterator iter = transformation.getSkipClassActions().iterator(); iter.hasNext();) {
			SkipClass action = (SkipClass) iter.next();
			skipper.addSkippedEClass(action.getTargetProto(), action.isIncludeDescendants());
		}
		return skipper;
	}

	private static void createClasses(Transformation transformation, AstransInterpreterTrace trace, Collection<EClass> classes) {
		for (Iterator iter = transformation.getCreateClassActions().iterator(); iter.hasNext();) {
			CreateClass action = (CreateClass) iter.next();
			EClass result = EcoreFactory.eINSTANCE.createEClass();
			trace.registerCreatedClass(action, result);
			classes.add(result);
		}
	}

	private static EPackage createResult(Transformation transformation, Collection<? extends EClassifier> classes) {
		EPackage result = EcoreFactory.eINSTANCE.createEPackage();
		result.setName(transformation.getOutputName());
		result.setNsPrefix(transformation.getOutputName());
		result.setNsURI(transformation.getOutputNsURI());
		result.getEClassifiers().addAll(classes);
		return result;
	}

	public static EPackage run(Transformation transformation) {
		
		AstransInterpreterTrace trace = new AstransInterpreterTrace();
		Skipper skipper = createSkipper(transformation);
		Collection<EClass> classes = createEClassObjects(transformation, trace, skipper);

		ReferenceTranslator referenceTranslator = new ReferenceTranslator(transformation, trace, skipper);
		Composer composer = new Composer(referenceTranslator);
		composer.run(transformation, trace);
		
		return createResult(transformation, classes);
	}

}
