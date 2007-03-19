package ru.ifmo.rain.astrans.asttomodel.resolver;

import static org.junit.Assert.assertEquals;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.junit.Before;
import org.junit.Test;

public class MyEPackageTest {

	private MyEPackage myEPackage;
	private EPackage p1;
	private EPackage p2;
	private EClass c1;

	@Before
	public void setUp() throws Exception {
		p1 = EcoreFactory.eINSTANCE.createEPackage();
		p1.setName("p1");
		
		p2 = EcoreFactory.eINSTANCE.createEPackage();
		p2.setName("p2");
		p1.getESubpackages().add(p2);
		
		c1 = EcoreFactory.eINSTANCE.createEClass();
		c1.setName("c1");
		p1.getEClassifiers().add(c1);
		
		myEPackage = new MyEPackage(p1);
	}

	@Test
	public void testGetName() {
		assertEquals(p1.getName(), myEPackage.getName());
	}

	@Test
	public void testGetEClassifier() {
		assertEquals(c1, myEPackage.getEClassifier(c1.getName()));
	}

	@Test
	public void testGetSubIPackage() {
		assertEquals(p2, myEPackage.getSubIPackage(p2.getName()).getEPackage());
	}

	@Test
	public void testGetEPackage() {
		assertEquals(p1, myEPackage.getEPackage());
	}

}
