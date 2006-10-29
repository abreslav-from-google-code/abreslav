package ru.amse.abreslav.graphs.model;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public abstract class TestGraph<D, V extends Vertex<D>, E extends Edge<V>, G extends Graph<D, V, E>> {

	protected G graph;
	protected V a;
	protected V b;
	protected V c;
	protected V d;
	protected V e;
	
	public abstract G createGraph();
	
	@Before
	public void setUp() throws Exception {
		graph = createGraph();
		a = graph.addVertex();
		b = graph.addVertex();
		c = graph.addVertex();
		d = graph.addVertex();
		e = graph.addVertex();
		graph.connect(a, b);
		graph.connect(a, c);
		graph.connect(a, d);
		graph.connect(b, c);
		graph.connect(b, e);
	}

	@Test
	public void testAddVertex() {
		assertEquals(graph.size(), 5);
		graph.addVertex();
		assertEquals(graph.size(), 6);
	}

	@Test
	public void testConnectMatrixVertexOfDMatrixVertexOfD() {
		E edge = graph.connect(b, a);
		assertNotNull(edge);
		E edge1 = graph.connect(b, a);
		assertSame(edge, edge1);
	}

	@Test
	public void testDisconnectMatrixVertexOfDMatrixVertexOfD() {
		graph.disconnect(a, b);
		assertNull(graph.getConnected(a, b));
	}

	@Test
	public void testGetConnectedMatrixVertexOfDMatrixVertexOfD() {
		E edge = graph.getConnected(a, b);
		assertSame(edge.getStart(), a);
		assertSame(edge.getEnd(), b);
	}

	@Test
	public void testSize() {
		assertEquals(graph.size(), 5);
	}

	@Test
	public void testIterator() {
		Set<V> s = new HashSet<V>();
		for (V v : graph) {
			assertFalse(s.contains(v));
			s.add(v);
		}
		Set<V> r = new HashSet<V>();
		r.add(a);
		r.add(b);
		r.add(c);
		r.add(d);
		r.add(e);
		assertEquals(s, r);
	}

}
