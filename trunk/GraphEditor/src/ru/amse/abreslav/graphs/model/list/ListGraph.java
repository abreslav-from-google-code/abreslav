package ru.amse.abreslav.graphs.model.list;

import ru.amse.abreslav.graphs.model.Graph;
import ru.amse.abreslav.graphs.model.VertexFactory;

public class ListGraph<D> extends Graph<D, ListVertex<D>, ListEdge<D>> {

	public ListGraph() {
		super(new VertexFactory<D, ListVertex<D>>() {

			public ListVertex<D> createVertex() {
				return new ListVertex<D>();
			}
			
		});
		
	}

	@Override
	public ListEdge<D> connect(ListVertex<D> a, ListVertex<D> b) {
		ListEdge<D> edge = new ListEdge<D>(a, b);
		a.acceptEdge(edge);
		return edge;
	}

	@Override
	public void disconnect(ListVertex<D> a, ListVertex<D> b) {
		a.disconnectFrom(b);		
	}

	@Override
	public ListEdge<D> getConnected(ListVertex<D> a, ListVertex<D> b) {
		return a.getConnectedTo(b);
	}

}
