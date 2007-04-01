package ru.ifmo.rain.astrans.interpreter;

import static org.junit.Assert.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.Before;
import org.junit.Test;

public class SkipperTest {

	private Skipper skipper;

	@Before
	public void setUp() throws Exception {
		skipper = new Skipper();
		skipper.addSkippedEClass(EcorePackage.eINSTANCE.getEAnnotation(), false);
		skipper.addSkippedEClass(EcorePackage.eINSTANCE.getEClassifier(), true);
	}

	@Test
	public final void testIsSkippedSuccessNoChildren() {
		assertTrue(skipper.isSkipped(EcorePackage.eINSTANCE.getEAnnotation()));
	}

	@Test
	public final void testIsSkippedFailureNoChildren() {
		assertFalse(skipper.isSkipped(EcorePackage.eINSTANCE.getEAttribute()));
	}

	@Test
	public final void testIsSkippedSuccessWithChildren() {
		assertTrue(skipper.isSkipped(EcorePackage.eINSTANCE.getEClass()));
	}

	@Test
	public final void testAddSkippedEClassNoChildren() {
		EClass eClass = EcorePackage.eINSTANCE.getEStructuralFeature();
		assertFalse(skipper.isSkipped(eClass));
		skipper.addSkippedEClass(eClass, false);
		assertTrue(skipper.isSkipped(eClass));
	}

	@Test
	public final void testAddSkippedEClassWithChildren() {
		EClass eClass = EcorePackage.eINSTANCE.getEAttribute();
		assertFalse(skipper.isSkipped(eClass));
		skipper.addSkippedEClass(EcorePackage.eINSTANCE.getEStructuralFeature(), true);
		assertTrue(skipper.isSkipped(eClass));
	}

}
