package ru.amse.abreslav.graphs.model;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public abstract class TestGraph<D, V extends Vertex<D>, E extends Edge<V>, G extends IGraph<D, V, E>> {

	protected G graph;
	protected V a;
	protected V b;
	protected V c;
	protected V d;
	protected V e;
	protected E ab;
	protected E ac;
	protected E ad;
	protected E bc;
	protected E be;
	
	public abstract G createGraph();
	
	@Before
	public void setUp() throws Exception {
		graph = createGraph();
		a = graph.addVertex(getVertexData());
		b = graph.addVertex(getVertexData());
		c = graph.addVertex(getVertexData());
		d = graph.addVertex(getVertexData());
		e = graph.addVertex(getVertexData());
		ab = graph.createEdge(a, b);
		ac = graph.createEdge(a, c);
		ad = graph.createEdge(a, d);
		bc = graph.createEdge(b, c);
		be = graph.createEdge(b, e);
	}

	protected abstract D getVertexData();

	@Test
	public void testAddVertex() {
		assertEquals(graph.size(), 5);
		graph.addVertex(getVertexData());
		assertEquals(graph.size(), 6);
	}

	@Test
	public void testRemoveVertex() {
		assertEquals(graph.size(), 5);
		graph.removeVertex(b);
		assertEquals(graph.size(), 4);

		Set<E> s = new HashSet<E>();
		for (E e : graph.getEdges()) {
			s.add(e);
		}
		Set<E> r = new HashSet<E>();
		r.add(ac);
		r.add(ad);
		assertEquals(s, r);		
	}

	@Test
	public void testConnect() {
		E edge = graph.createEdge(b, a);
		assertNotNull(edge);
		E edge1 = graph.createEdge(b, a);
		assertSame(edge, edge1);
	}

	@Test
	public void testDisconnect() {
		graph.removeEdge(a, b);
		assertNull(graph.getEdge(a, b));
	}

	@Test
	public void testGetConnected() {
		E edge = graph.getEdge(a, b);
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

	@Test
	public void testEdges() {
		Set<E> s = new HashSet<E>();
		for (E e : graph.getEdges()) {
			assertFalse(s.contains(e));
			s.add(e);
		}
		Set<E> r = new HashSet<E>();
		r.add(ab);
		r.add(ac);
		r.add(ad);
		r.add(bc);
		r.add(be);
		assertEquals(s, r);
	}

}
