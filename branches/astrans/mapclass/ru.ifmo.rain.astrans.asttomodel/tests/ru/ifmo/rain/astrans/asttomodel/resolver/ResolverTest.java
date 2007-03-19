package ru.ifmo.rain.astrans.asttomodel.resolver;

import static org.junit.Assert.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.Before;
import org.junit.Test;

import utils.QNUtils;

import astrans.AstransFactory;
import astrans.AstransPackage;
import astrans.CreateClass;
import astrans.CreatedEClass;
import astrans.EClassReference;
import astrans.EClassifierReference;
import astrans.ExistingEClass;
import astrans.ExistingEDataType;
import astrans.MapClass;
import astrans.MappedEClass;
import astransast.QualifiedName;

public class ResolverTest {

	private Resolver resolver;
	private QualifiedName actionQN;

	@Before
	public void setUp() throws Exception {
		actionQN = QNUtils.createQN("astrans.Action");
		
		MappedClasses mappedClasses = new MappedClasses();
		MapClass a = AstransFactory.eINSTANCE.createMapClass();
		a.setProto(AstransPackage.eINSTANCE.getAction());
		mappedClasses.add(a);
		CreatedClasses createdClasses = new CreatedClasses();
		CreateClass b = AstransFactory.eINSTANCE.createCreateClass();
		b.setName("B");
		createdClasses.add(b);
		resolver = new Resolver(AstransPackage.eINSTANCE, createdClasses, mappedClasses);
	}

	@Test
	public final void testResolveTranslateReferencesTextualReferenceType() {
		EClassifierReference reference = resolver.resolveTranslateReferencesTextualReferenceType(QNUtils.createQN("ecore.EString"));
		assertEquals(EcorePackage.eINSTANCE.getEString(), ((ExistingEDataType) reference).getEDataType());
	}
	
	@Test
	public final void testResolveTranslateReferencesModelReferenceTypeProto() {
		EClass eClass = resolver.resolveTranslateReferencesModelReferenceTypeProto(actionQN);
		assertEquals(AstransPackage.eINSTANCE.getAction(), eClass);
	}

	@Test
	public final void testResolveSkipClassTargetProto() {
		EClass eClass = resolver.resolveSkipClassTargetProto(actionQN);
		assertEquals(AstransPackage.eINSTANCE.getAction(), eClass);
	}

	@Test
	public final void testResolveCreateClassSuperclass() {
		EClassReference reference = resolver.resolveCreateClassSuperclass(QNUtils.createQN("ActionAS"));
		assertEquals("ActionAS", ((MappedEClass) reference).getMapping().getProto().getName() + "AS");
	}

	@Test
	public final void testResolveReferenceType() {
		EClassReference reference = resolver.resolveReferenceType(QNUtils.createQN("B"));
		assertEquals("B", ((CreatedEClass) reference).getCreate().getName());
	}

	@Test
	public final void testResolveReferenceTypeExistringEClass() {
		EClassReference reference = resolver.resolveReferenceType(QNUtils.createQN("ecore.EClass"));
		assertEquals(EcorePackage.eINSTANCE.getEClass(), ((ExistingEClass) reference).getEClass());
	}

	@Test
	public final void testResolveAttributeType() {
		EDataType type = resolver.resolveAttributeType(QNUtils.createQN("ecore.EInt"));
		assertEquals(EcorePackage.eINSTANCE.getEInt(), type);
	}

}
