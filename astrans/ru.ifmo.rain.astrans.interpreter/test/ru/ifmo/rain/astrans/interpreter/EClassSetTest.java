package ru.ifmo.rain.astrans.interpreter;

import static org.junit.Assert.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.Before;
import org.junit.Test;

public class EClassSetTest {

	private EClassSet skipper;

	@Before
	public void setUp() throws Exception {
		skipper = new EClassSet();
		skipper.addEClass(EcorePackage.eINSTANCE.getEAnnotation(), false);
		skipper.addEClass(EcorePackage.eINSTANCE.getEClassifier(), true);
	}

	@Test
	public final void testIsSkippedSuccessNoChildren() {
		assertTrue(skipper.contains(EcorePackage.eINSTANCE.getEAnnotation()));
	}

	@Test
	public final void testIsSkippedFailureNoChildren() {
		assertFalse(skipper.contains(EcorePackage.eINSTANCE.getEAttribute()));
	}

	@Test
	public final void testIsSkippedSuccessWithChildren() {
		assertTrue(skipper.contains(EcorePackage.eINSTANCE.getEClass()));
	}

	@Test
	public final void testAddSkippedEClassNoChildren() {
		EClass eClass = EcorePackage.eINSTANCE.getEStructuralFeature();
		assertFalse(skipper.contains(eClass));
		skipper.addEClass(eClass, false);
		assertTrue(skipper.contains(eClass));
	}

	@Test
	public final void testAddSkippedEClassWithChildren() {
		EClass eClass = EcorePackage.eINSTANCE.getEAttribute();
		assertFalse(skipper.contains(eClass));
		skipper.addEClass(EcorePackage.eINSTANCE.getEStructuralFeature(), true);
		assertTrue(skipper.contains(eClass));
	}

}
