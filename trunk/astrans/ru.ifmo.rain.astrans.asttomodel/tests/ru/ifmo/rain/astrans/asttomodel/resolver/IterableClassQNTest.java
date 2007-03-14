package ru.ifmo.rain.astrans.asttomodel.resolver;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import astransast.AstransastFactory;
import astransast.QualifiedName;

public class IterableClassQNTest {

	private QualifiedName a;
	private QualifiedName b;
	private QualifiedName c;
	private IterableClassQN iterableClassQN;

	@Before
	public void setUp() throws Exception {
		a = AstransastFactory.eINSTANCE.createQualifiedName();
		a.setName("a");
		b = AstransastFactory.eINSTANCE.createQualifiedName();
		b.setName("b");
		c = AstransastFactory.eINSTANCE.createQualifiedName();
		c.setName("c");
		
		a.setSubQN(b);
		b.setSubQN(c);
		
		iterableClassQN = new IterableClassQN(a);
	}
	
	@Test
	public void testIterator() {
		String r = "";
		for (String s : iterableClassQN) {
			r += s;
		}
		assertEquals("ab", r);
	}

	@Test
	public void testGetClassName() {
		assertEquals("c", iterableClassQN.getClassName());
	}
}