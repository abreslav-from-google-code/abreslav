package ru.ifmo.rain.astrans.interpreter;

import static org.junit.Assert.*;

import org.eclipse.emf.ecore.EcorePackage;
import org.junit.Before;
import org.junit.Test;

public class EClassMapTest {

	private EClassMap<String> map;

	@Before
	public void setUp() throws Exception {
		map = new EClassMap<String>();
		map.put(EcorePackage.eINSTANCE.getEAnnotation(), "a", false);
		map.put(EcorePackage.eINSTANCE.getEClassifier(), "c", true);
	}

	@Test
	public final void testGetSingleClass() {
		assertEquals("a", map.get(EcorePackage.eINSTANCE.getEAnnotation()));
	}

	@Test
	public final void testGetChildClass() {
		assertEquals("c", map.get(EcorePackage.eINSTANCE.getEClass()));
	}

	@Test
	public final void testGetNotContainedClass() {
		assertNull(map.get(EcorePackage.eINSTANCE.getEAttribute()));
	}

	@Test
	public final void testPut() {
		map.put(EcorePackage.eINSTANCE.getEAttribute(), "d", false);
		assertEquals("d", map.get(EcorePackage.eINSTANCE.getEAttribute()));
	}

}
