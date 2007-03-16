package ru.ifmo.rain.astrans.asttomodel.resolver;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import astrans.AstransFactory;
import astrans.EClassifierReference;
import astrans.ExistingEClass;
import astransast.AstransastFactory;
import astransast.QualifiedName;

public class CompositeClassifierNamespaceTest {

	private final ExistingEClass ref1 = AstransFactory.eINSTANCE.createExistingEClass();
	private final ExistingEClass ref2 = AstransFactory.eINSTANCE.createExistingEClass();
	private IClassifierNamespace<EClassifierReference> ns1;
	private IClassifierNamespace<EClassifierReference> ns2;
	private CompositeClassifierNamespace composite;

	@Before
	public void setUp() throws Exception {
		ns1 = new IClassifierNamespace<EClassifierReference>() {
			public EClassifierReference getEClassifierReference(QualifiedName name) {
				return name.getName().equals("a") ? ref1 : null;
			}			
		};
		ns2 = new IClassifierNamespace<EClassifierReference>() {
			public EClassifierReference getEClassifierReference(QualifiedName name) {
				return name.getName().equals("b") ? ref2 : null;
			}			
		};
		
		composite = new CompositeClassifierNamespace(ns1, ns2);
	}

	@Test
	public final void testGetEClassifierReference() {
		QualifiedName qn = AstransastFactory.eINSTANCE.createQualifiedName();
		qn.setName("a");
		assertSame(ref1, composite.getEClassifierReference(qn));
		qn.setName("b");
		assertSame(ref2, composite.getEClassifierReference(qn));
	}

}
