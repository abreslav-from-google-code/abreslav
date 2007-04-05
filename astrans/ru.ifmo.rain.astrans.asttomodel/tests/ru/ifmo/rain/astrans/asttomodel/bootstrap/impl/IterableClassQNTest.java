package ru.ifmo.rain.astrans.asttomodel.bootstrap.impl;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import ru.ifmo.rain.astrans.asttomodel.bootstrap.impl.IterableClassQN;

import utils.QNUtils;
import astransast.QualifiedName;

public class IterableClassQNTest {

	private IterableClassQN iterableClassQN;

	@Before
	public void setUp() throws Exception {
		QualifiedName a = QNUtils.createQN("a.b.c.");		
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
	
	@Test
	public void testSimpleName() {
		IterableClassQN classQN = new IterableClassQN(QNUtils.createQN("a"));
		Iterator<String> iterator = classQN.iterator();
		iterator.next();
		iterator.hasNext(); // used to throw an exception here
	}
}