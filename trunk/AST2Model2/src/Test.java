import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.resource.impl.URIConverterImpl;

import msg.Class;
import msjast.ClassAS;
import msjast.ClassReferenceAS;
import msjast.CompilationUnitAS;
import msjast.FQNameAS;
import msjast.FieldAS;
import msjast.MsjastFactory;
import msjast.util.MsjastResourceFactoryImpl;

public class Test {
	public static void main(String[] args) throws IOException {
		CompilationUnitAS unitAS = MsjastFactory.eINSTANCE.createCompilationUnitAS();		
		
		ClassAS classAS = MsjastFactory.eINSTANCE.createClassAS();
		DClassAS dc = new DClassAS(classAS);
		classAS.setName("name");
		FieldAS fieldAS = MsjastFactory.eINSTANCE.createFieldAS();
		fieldAS.setName("f");
		dc.getMembers().add(fieldAS);
		unitAS.getClasses().add(dc);
		
		ResourceSet rs = new ResourceSetImpl();
		rs.setURIConverter(new URIConverterImpl());
		Registry registry = MsjastResourceFactoryImpl.Registry.INSTANCE;
		
		registry.getExtensionToFactoryMap().put("msjast", new MsjastResourceFactoryImpl());
		rs.setResourceFactoryRegistry(registry);
		Resource resource = rs.createResource(URI.createURI("/a.msjast"));
		resource.getContents().add(unitAS);
		
		resource.save(System.out, Collections.EMPTY_MAP);
		
		
//		MSJTransformationFactory factory = new MSJTransformationFactory();
//		FQNameAS fqn = createFqn("java.lang.Object");
//		ClassReferenceAS cr = MsjastFactory.eINSTANCE.createClassReferenceAS();
//		cr.setFqn(fqn);
//		Class cz = factory.getClassReference(cr);
//		System.out.println(cz.getName());
//		ClassAS ast = MsjastFactory.eINSTANCE.createClassAS();
//		ast.setName("Object");
//		Class cl = factory.createClass(ast);		
	}

	private static FQNameAS createFqn(String fqn) {
		String[] strings = fqn.split("\\.");
		FQNameAS result = null;
		for (int i = strings.length - 1; i >= 0; i--) {
			FQNameAS f = MsjastFactory.eINSTANCE.createFQNameAS();
			f.setName(strings[i]);
			f.setSubFqn(result);
			result = f;			
		}
		return result;
	}
}
