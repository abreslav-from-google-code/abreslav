package ru.ifmo.rain.astrans.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class EMFHelper {

	private static final Resource.Factory XMI_RESOURCE_FACTORY = new XMIResourceFactoryImpl();
	private static final ResourceSet RESOURCE_SET = new ResourceSetImpl();	
	
	@SuppressWarnings("unchecked")
	public static Resource getResource(Factory factory, EPackage p, String name) {
		Resource resource = factory.createResource(URI.createURI(name));
		RESOURCE_SET.getPackageRegistry().put(p.getNsURI(), p);
		RESOURCE_SET.getResources().add(resource);
		return resource;
	}
	
	public static Resource getXMIResource(EPackage p, String name) {
		return getResource(XMI_RESOURCE_FACTORY, p, name);
	}
	
	@SuppressWarnings("unchecked")
	public static Resource wrapIntoXMIResource(EObject obj, String name) {
		EPackage ePackage = obj.eClass().getEPackage();
		Resource resource = getXMIResource(ePackage, name);
		resource.getContents().add(obj);
		return resource;
	}
	
	public static void saveResourceToFile(Resource r, String fileName) throws IOException {
		FileOutputStream stream = null;
		try {
			stream = new FileOutputStream(fileName);
			r.save(stream, Collections.EMPTY_MAP);
		} finally {
			if (stream != null) {
				stream.close();
			}
		}
	}
	
	public static void loadResourceFromFile(Resource r, String fileName) throws IOException {
		loadResourceFromFile(r, new File(fileName));
	}
	
	public static void loadResourceFromFile(Resource r, File file) throws IOException {
		FileInputStream stream = null;
		try {
			stream = new FileInputStream(file);
			r.load(stream, Collections.EMPTY_MAP);
		} finally {
			if (stream != null) {
				stream.close();
			}
		}
	}
	
	public static void saveEObjectToFile(EObject eObject, String fileName) throws IOException {
		Resource resource = EMFHelper.wrapIntoXMIResource(eObject, fileName);
		
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(fileName);
			resource.save(out, Collections.singletonMap(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE));
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
