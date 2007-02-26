import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import astrans.AstransFactory;
import astrans.AstransPackage;
import astrans.MapClass;
import astrans.Transformation;


public class GenerateStubModelToAstTransformation {

	public static void main(String[] args) throws IOException {
		Resource resource = EMFHelper.getXMIResource(AstransPackage.eINSTANCE, "a");
		EMFHelper.loadResourceFromFile(resource, "model/Astrans-to-AST.xmi");
		Transformation transformation = (Transformation) resource.getContents().get(0);
		AstransInterpreter interpreter = new AstransInterpreter();
		Collection<EClass> classes = interpreter.run(transformation);
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.getEClassifiers().addAll(classes);
		EMFHelper.saveEObjectToFile(ePackage, "astransast.ecore");
	}

	@SuppressWarnings("unchecked")
// TODO: Generate mapping for referenced classes too. Not only for those contained in the package (e. g. EClass)
	public static Transformation createStubTransformation(EPackage ePackage) {
		if (ePackage == null) {
			throw new IllegalArgumentException();
		}
	
		Transformation result = (Transformation) EcoreUtil.create(AstransPackage.eINSTANCE.getTransformation());
		
		EList classifiers = ePackage.getEClassifiers();
		for (Iterator iter = classifiers.iterator(); iter.hasNext();) {
			EClassifier element = (EClassifier) iter.next();
			if (element instanceof EClass) {
				EClass eClass = (EClass) element;
				MapClass mapClass = AstransFactory.eINSTANCE.createMapClass();
				mapClass.setProto(eClass);
				result.getActions().add(mapClass);
			}
		}
		
		return result;
	}
}
