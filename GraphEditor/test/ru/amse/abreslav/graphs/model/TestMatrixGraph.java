package ru.amse.abreslav.graphs.model;


import static org.junit.Assert.*;

import org.junit.Test;

import ru.amse.abreslav.graphs.model.matrix.MatrixGraph;
import ru.amse.abreslav.graphs.model.matrix.MatrixVertex;

public class TestMatrixGraph extends TestGraph<Integer, MatrixVertex<Integer>, 
										SimpleEdge<MatrixVertex<Integer>>, MatrixGraph<Integer>> {

	@Override
	public MatrixGraph<Integer> createGraph() {
		return new MatrixGraph<Integer>(6);
	}

	@Test
	public void testGetCapacity() {
		assertEquals(graph.getCapacity(), 6);
	}

	@Test
	public void testAddVertex() {
		try {
			assertEquals(graph.size(), 5);
			graph.addVertex();
			assertEquals(graph.size(), 6);
		} catch (IllegalStateException e) {
			fail("Capacity exceeded");
		}
		try {
			graph.addVertex();
			fail("Capacity not exceeded");
		} catch (IllegalStateException e) {
			assertTrue(true);
		}
	}

}
