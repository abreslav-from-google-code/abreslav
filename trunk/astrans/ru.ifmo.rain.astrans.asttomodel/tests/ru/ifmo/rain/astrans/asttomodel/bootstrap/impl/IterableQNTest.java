package ru.ifmo.rain.astrans.asttomodel.bootstrap.impl;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import ru.ifmo.rain.astrans.asttomodel.bootstrap.impl.IterableQN;

import astransast.AstransastFactory;
import astransast.QualifiedName;

public class IterableQNTest {

	private QualifiedName a;
	private QualifiedName b;
	private QualifiedName c;
	private IterableQN iterableQN;

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
		
		iterableQN = new IterableQN(a);
	}

	@Test
	public void testIterator() {
		String r = "";
		for (String s : iterableQN) {
			r += s;
		}
		assertEquals("abc", r);
	}
	
	@Test
	public void testEmpty() {
		assertFalse(new IterableQN(null).iterator().hasNext());
	}
	
	@Test
	public void testSingle() {
		assertTrue(new IterableQN(c).iterator().hasNext());
	}
	
	@Test
	public void testSeveralIterations() {
		for (String s : iterableQN) {
			s.length();
		}
		String r = "";
		for (String s : iterableQN) {
			r += s;
		}
		assertEquals("abc", r);
	}

	@Test
	public void testOneIterationOnSingleQN() {
		Iterator<String> it = new IterableQN(c).iterator();
		it.next();
		assertFalse(it.hasNext());
	}
	
}
