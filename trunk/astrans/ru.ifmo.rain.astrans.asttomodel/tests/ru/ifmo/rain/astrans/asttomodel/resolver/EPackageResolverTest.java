package ru.ifmo.rain.astrans.asttomodel.resolver;

import static org.junit.Assert.assertEquals;

import org.eclipse.emf.ecore.EcorePackage;
import org.junit.Test;

import astrans.AstransPackage;
import astransast.AstransastFactory;
import astransast.QualifiedName;

public class EPackageResolverTest {

	private QualifiedName ecore;
	private QualifiedName astrans;
	private QualifiedName transformation;

	@Test
	public void testGetEPackage() {
		ecore = AstransastFactory.eINSTANCE.createQualifiedName();
		ecore.setName("ecore");
		assertEquals(EcorePackage.eINSTANCE, EPackageResolver.INSTANCE.getEPackage(ecore));
	}

	@Test
	public void testGetEClassifier() {
		astrans = AstransastFactory.eINSTANCE.createQualifiedName();
		astrans.setName("astrans");
		transformation = AstransastFactory.eINSTANCE.createQualifiedName();
		transformation.setName("Transformation");
		
		astrans.setSubQN(transformation);
		assertEquals(AstransPackage.eINSTANCE.getTransformation(), EPackageResolver.INSTANCE.getEClassifier(astrans));
	}

}
