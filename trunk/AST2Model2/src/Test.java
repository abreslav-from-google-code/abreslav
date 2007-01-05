import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;

import msg.Field;
import msg.MsgPackage;
import msg.Package;
import msjast.CompilationUnitAS;
import msjast.FQNameAS;
import msjast.MsjastFactory;
import msjast.MsjastPackage;
import msjast.util.MsjastResourceFactoryImpl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.resource.impl.URIConverterImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class Test {
	public static void main(String[] args) throws IOException {
		
		Factory factory = new MsjastResourceFactoryImpl();
		EPackage p = MsjastPackage.eINSTANCE;
		Resource resource = getResource(factory, p);
		FileInputStream stream = new FileInputStream("test10.xmi");		
		resource.load(stream, Collections.EMPTY_MAP);
		
		CompilationUnitAS unitAS = (CompilationUnitAS) resource.getContents().get(0);
		
		AST2MsgTransformation transformation = new AST2MsgTransformation();
		msg.Package pack = (Package) transformation.caseCompilationUnitAS(unitAS);
		
		resource = getResource(new XMIResourceFactoryImpl(), MsgPackage.eINSTANCE);
		resource.getContents().add(pack);
		resource.getContents().add(transformation.getDefaultPackage());
		
		msg.Class cl = (msg.Class) pack.getClasses().get(0);
		Field f = (Field) cl.getMembers().get(0);		
		System.out.println(resource.getURIFragment(f.getType()));
		
		resource.save(System.out, Collections.singletonMap(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_RECORD));
	}

	private static Resource getResource(Factory factory, EPackage p) {
		Resource resource = factory.createResource(URI.createURI("/test1.xmi"));
		ResourceSetImpl impl = new ResourceSetImpl();
		impl.getPackageRegistry().put(p.getNsURI(), p);
		impl.getResources().add(resource);
		return resource;
	}

	private static void printResource(EObject eObject) throws IOException {
		ResourceSet rs = new ResourceSetImpl();
		rs.setURIConverter(new URIConverterImpl());
		Registry registry = MsjastResourceFactoryImpl.Registry.INSTANCE;
		
		registry.getExtensionToFactoryMap().put("msjast", new MsjastResourceFactoryImpl());
		rs.setResourceFactoryRegistry(registry);
		Resource resource = rs.createResource(URI.createURI("/a.msjast"));
		resource.getContents().add(eObject);
		
		resource.save(System.out, Collections.EMPTY_MAP);
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
