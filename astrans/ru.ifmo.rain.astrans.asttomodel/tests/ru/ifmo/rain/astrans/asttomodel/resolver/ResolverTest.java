package ru.ifmo.rain.astrans.asttomodel.resolver;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import astrans.AstransFactory;
import astrans.AstransPackage;
import astrans.CreateClass;
import astrans.MapClass;

public class ResolverTest {

	private Resolver resolver;
	private MappedClasses mappedClasses;
	private CreatedClasses createdClasses;

	@Before
	public void setUp() throws Exception {
		mappedClasses = new MappedClasses();
		MapClass a = AstransFactory.eINSTANCE.createMapClass();
		a.setProto(AstransPackage.eINSTANCE.getAction());
		mappedClasses.add(a);
		createdClasses = new CreatedClasses();
		CreateClass b = AstransFactory.eINSTANCE.createCreateClass();
		b.setName("B");
		createdClasses.add(b);
		resolver = new Resolver(AstransPackage.eINSTANCE, createdClasses, mappedClasses);
	}

	@Test
	public final void testResolveTranslateReferencesTextualReferenceType() {
//		resolver.resolveTranslateReferencesTextualReferenceType(textualReferenceType);
	}

	@Test
	public final void testResolveTranslateReferencesModelReferenceTypeProto() {
		fail("Not yet implemented");
	}

	@Test
	public final void testResolveSkipClassTargetProto() {
		fail("Not yet implemented");
	}

	@Test
	public final void testResolveCreateClassSuperclass() {
		fail("Not yet implemented");
	}

	@Test
	public final void testResolveReferenceType() {
		fail("Not yet implemented");
	}

	@Test
	public final void testResolveAttributeType() {
		fail("Not yet implemented");
	}

}
