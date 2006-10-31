package ru.amse.abreslav.graphs.presentation;

import static junit.framework.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ru.amse.abreslav.graphs.model.Edge;
import ru.amse.abreslav.graphs.model.SimpleEdge;
import ru.amse.abreslav.graphs.model.Vertex;
import ru.amse.abreslav.graphs.model.list.ListGraph;
import ru.amse.abreslav.graphs.model.list.ListVertex;

public class TestPresentation {
	
	protected ListGraph<Integer> graph;
	protected ListVertex<Integer> a;
	protected ListVertex<Integer> b;
	protected ListVertex<Integer> c;
	protected ListVertex<Integer> d;
	protected ListVertex<Integer> e;
	protected Edge<ListVertex<Integer>> ab;
	protected Edge<ListVertex<Integer>> ac;
	protected Edge<ListVertex<Integer>> ad;
	protected Edge<ListVertex<Integer>> bc;
	protected Edge<ListVertex<Integer>> be;
	private PresentationFactory<
		Integer, ListVertex<Integer>, 
		SimpleEdge<ListVertex<Integer>>> factory;
	private GraphPresentation<Integer, ListVertex<Integer>, SimpleEdge<ListVertex<Integer>>> gp;
	private Set<Edge<?>> allEdges;
	private Set<Vertex<?>> allVertices;
	
	@Before
	public void setUp() throws Exception {
		graph = new ListGraph<Integer>();
		a = graph.addVertex(0);
		b = graph.addVertex(1);
		c = graph.addVertex(2);
		d = graph.addVertex(3); 
		e = graph.addVertex(4);
		allVertices = new HashSet<Vertex<?>>();
		allVertices.add(a);
		allVertices.add(b);
		allVertices.add(c);
		allVertices.add(d);
		allVertices.add(e);
		ab = graph.connect(a, b);
		ac = graph.connect(a, c);
		ad = graph.connect(a, d);
		bc = graph.connect(b, c);
		be = graph.connect(b, e);
		allEdges = new HashSet<Edge<?>>();
		allEdges.add(ab);
		allEdges.add(ac);
		allEdges.add(ad);
		allEdges.add(bc);
		allEdges.add(be);
		factory = new PresentationFactory<Integer, ListVertex<Integer>, SimpleEdge<ListVertex<Integer>>>();
		gp = factory.createGraphPresentation(graph);
	}

	@Test
	public void testEdges() {
		assertEquals(allEdges, collectPresentedEdges());
	}
	
	@Test
	public void testVertices() {
		assertEquals(allVertices, collectDeclaredVertices());
	}

	@Test
	public void testRemoveVertex() {
		gp.getGraph().removeVertex(b);
		allVertices.remove(b);
		allEdges.remove(ab);
		allEdges.remove(bc);
		allEdges.remove(be);
		assertEquals(allVertices, collectDeclaredVertices());
		assertEquals(allEdges, collectPresentedEdges());
	}

	@Test
	public void testRemoveEdge() {
		gp.getGraph().disconnect(a, b);
		allEdges.remove(ab);
		assertEquals(allEdges, collectPresentedEdges());
	}

	private Set<Vertex<?>> collectDeclaredVertices() {
		Set<Vertex<?>> v = new HashSet<Vertex<?>>();
		for (VertexPresentation<?, ?> vp : gp.getVertexPresentations()) {
			v.add(vp.getVertex());		
		}
		return v;
	}

	private Set<Edge<?>> collectPresentedEdges() {
		Set<Edge<?>> e = new HashSet<Edge<?>>();
		for (EdgePresentation<?> ep : gp.getEdgePresentations()) {
			e.add(ep.getEdge());		
		}
		return e;
	}
}
