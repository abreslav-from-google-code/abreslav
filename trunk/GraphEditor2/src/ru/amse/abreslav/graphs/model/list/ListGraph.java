package ru.amse.abreslav.graphs.model.list;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import ru.amse.abreslav.graphs.model.Graph;
import ru.amse.abreslav.graphs.model.SimpleEdge;
import ru.amse.abreslav.graphs.model.VertexFactory;

public class ListGraph<D> extends Graph<D, ListVertex<D>, SimpleEdge<ListVertex<D>>> {

	private Collection<SimpleEdge<ListVertex<D>>> edges = new LinkedHashSet<SimpleEdge<ListVertex<D>>>();
	private Collection<SimpleEdge<ListVertex<D>>> unmodifiableEdges = Collections.unmodifiableCollection(edges);
	
	public ListGraph(VertexFactory<D, ? extends ListVertex<D>> factory) {
		super(factory);
	}

	public ListGraph() {
		this(new VertexFactory<D, ListVertex<D>>() {
			public ListVertex<D> createVertex() {
				return new ListVertex<D>();
			}
		});		
	}
	
	public SimpleEdge<ListVertex<D>> createEdge(ListVertex<D> a, ListVertex<D> b) {
		SimpleEdge<ListVertex<D>> oldEdge = getEdge(a, b);
		if (oldEdge != null) {
			return oldEdge;
		}
		SimpleEdge<ListVertex<D>> edge = new SimpleEdge<ListVertex<D>>(a, b);
		a.acceptEdge(edge);
		edges.add(edge);
		return edge;
	}

	public boolean removeEdge(ListVertex<D> a, ListVertex<D> b) {
		SimpleEdge<ListVertex<D>> e = getEdge(a, b);
		if (e == null) {
			return false;
		}
		edges.remove(e);
		a.disconnectFrom(b);
		return true;
	}

	public SimpleEdge<ListVertex<D>> getEdge(ListVertex<D> a, ListVertex<D> b) {
		return a.getConnectedTo(b);
	}

	public Collection<SimpleEdge<ListVertex<D>>> getEdges() {		
		return unmodifiableEdges;
	}

}
