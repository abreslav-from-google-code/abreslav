package util;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class EMFHelper {

	public static Resource getResource(Factory factory, EPackage p, String name) {
		Resource resource = factory.createResource(URI.createURI(name));
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(p.getNsURI(), p);
		resourceSet.getResources().add(resource);
		return resource;
	}
	
	public static void saveResourceToFile(Resource r, String fileName) throws IOException {
		FileOutputStream stream = new FileOutputStream(fileName);
		r.save(stream, Collections.EMPTY_MAP);
	}
	
	public static void loadResourceFromFile(Resource r, String fileName) throws IOException {
		FileInputStream stream = new FileInputStream(fileName);
		r.load(stream, Collections.EMPTY_MAP);
	}
}
