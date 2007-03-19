package ru.ifmo.rain.astrans.asttomodel.resolver;

import static org.junit.Assert.*;

import org.eclipse.emf.ecore.EcorePackage;
import org.junit.Before;
import org.junit.Test;

import astrans.AstransFactory;
import astrans.MapClass;
import astrans.MappedEClass;
import astransast.AstransastFactory;
import astransast.QualifiedName;

public class MappedClassesTest {

	private MapClass mapClass;
	private MappedClasses mappedClasses;
	private QualifiedName name;

	@Before
	public void setUp() throws Exception {
		mapClass = AstransFactory.eINSTANCE.createMapClass();
		mapClass.setProto(EcorePackage.eINSTANCE.getEAnnotation());
		
		mappedClasses = new MappedClasses();
		mappedClasses.add(mapClass);

		name = AstransastFactory.eINSTANCE.createQualifiedName();
		name.setName("EAnnotationAS");
	}

	@Test
	public final void testGetEClassifierReference() {
		MappedEClass ref1 = mappedClasses.getReference(name);
		MappedEClass ref2 = mappedClasses.getReference(name);
		assertTrue(ref1 != ref2);
		assertSame(ref1.getMapping(), ref2.getMapping());
	}

	@Test
	public final void testAdd() {
		assertSame(mapClass, mappedClasses.getReference(name).getMapping());
	}

}
