package ru.amse.abreslav.graphs.model;


import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import ru.amse.abreslav.graphs.model.list.ListGraph;
import ru.amse.abreslav.graphs.model.list.ListVertex;

public class TestListGraph extends TestGraph<Integer, ListVertex<Integer>, 
										SimpleEdge<ListVertex<Integer>>, ListGraph<Integer>> {

	@Override
	public ListGraph<Integer> createGraph() {		
		return new ListGraph<Integer>();
	}
	
	@Test
	public void testListVertexGetConnectedTo() throws Exception {
		assertSame(a.getConnectedTo(b), graph.getConnected(a, b));
	}
	
	@Test
	public void testListVertexNeighborsIterator() throws Exception {
		Iterator<ListVertex<Integer>> i = a.neighborsIterator();
		Set<ListVertex<Integer>> s = new HashSet<ListVertex<Integer>>();
		while (i.hasNext()) {
			ListVertex<Integer> v = i.next();
			assertFalse(s.contains(v));
			s.add(v);
		}
		try {
			i.remove();
			fail("Not read only");
		} catch (UnsupportedOperationException e) {			
		}
		Set<ListVertex<Integer>> r = new HashSet<ListVertex<Integer>>();
		r.add(b);
		r.add(c);
		r.add(d);
		assertEquals(r, r);
	}
	
}
