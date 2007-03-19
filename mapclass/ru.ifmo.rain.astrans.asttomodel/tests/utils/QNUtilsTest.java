package utils;

import static org.junit.Assert.*;

import org.junit.Test;

import astransast.QualifiedName;

public class QNUtilsTest {

	@Test
	public final void testCreateQN() {
		QualifiedName qn = QNUtils.createQN("a.b.c");
		assertEquals("a", qn.getName());
		assertEquals("b", qn.getSubQN().getName());
		assertEquals("c", qn.getSubQN().getSubQN().getName());
		assertNull(qn.getSubQN().getSubQN().getSubQN());
	}

	@Test
	public void testSimpleName() {
		QualifiedName qn = QNUtils.createQN("a");
		assertEquals("a", qn.getName());
		assertNull(qn.getSubQN());
	}
	
	@Test
	public void testToString() {
		assertEquals("a.b.c", QNUtils.toString(QNUtils.createQN("a.b.c")));
	}
	
	@Test
	public void testToStringSimpleName() {
		assertEquals("a", QNUtils.toString(QNUtils.createQN("a")));
	}
	
}
