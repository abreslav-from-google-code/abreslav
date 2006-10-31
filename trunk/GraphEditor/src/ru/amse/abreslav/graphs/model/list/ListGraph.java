package ru.amse.abreslav.graphs.model.list;

import java.util.Collection;
import java.util.LinkedHashSet;

import ru.amse.abreslav.graphs.model.Graph;
import ru.amse.abreslav.graphs.model.SimpleEdge;
import ru.amse.abreslav.graphs.model.VertexFactory;

public class ListGraph<D> extends Graph<D, ListVertex<D>, SimpleEdge<ListVertex<D>>> {

	private Collection<SimpleEdge<ListVertex<D>>> edges = new LinkedHashSet<SimpleEdge<ListVertex<D>>>();
	
	public ListGraph() {
		super(new VertexFactory<D, ListVertex<D>>() {

			public ListVertex<D> createVertex() {
				return new ListVertex<D>();
			}
			
		});
		
	}

	public SimpleEdge<ListVertex<D>> connect(ListVertex<D> a, ListVertex<D> b) {
		SimpleEdge<ListVertex<D>> oldEdge = getConnected(a, b);
		if (oldEdge != null) {
			return oldEdge;
		}
		SimpleEdge<ListVertex<D>> edge = new SimpleEdge<ListVertex<D>>(a, b);
		a.acceptEdge(edge);
		edges.add(edge);
		return edge;
	}

	public void disconnect(ListVertex<D> a, ListVertex<D> b) {
		SimpleEdge<ListVertex<D>> e = getConnected(a, b);
		if (e != null) {
			edges.remove(e);
		}
		a.disconnectFrom(b);		
	}

	public SimpleEdge<ListVertex<D>> getConnected(ListVertex<D> a, ListVertex<D> b) {
		return a.getConnectedTo(b);
	}

	public Iterable<SimpleEdge<ListVertex<D>>> getEdges() {		
		return edges;
	}

}
