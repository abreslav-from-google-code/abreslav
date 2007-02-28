package ru.amse.sd.mvc.onetoone.view;

import static junit.framework.Assert.*;

import org.junit.Test;

public class TreeVertexTest {

	private TreeVertex vertex;

	@Test
	public void testConstructor() throws Exception {
		vertex = new TreeVertex(1);
		assertEquals(1, vertex.getIndex());
	}
	
	@Test
	public void testCalculatePosition() throws Exception {
		vertex = new TreeVertex(6);
		assertEquals(7.0 / 8, vertex.getX());
		assertEquals(2.0, vertex.getY());
	}
	
	@Test
	public void testCalculatePositionForZero() throws Exception {
		vertex = new TreeVertex(0);
		assertEquals(0.5, vertex.getX());
		assertEquals(0.0, vertex.getY());
	}
	
	@Test
	public void testGetParentIndex() throws Exception {
		vertex = new TreeVertex(0);
		assertEquals(0, vertex.getParentIndex());
		vertex = new TreeVertex(5);
		assertEquals(2, vertex.getParentIndex());
	}
}
