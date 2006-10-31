package ru.amse.abreslav.graphs.presentation;

import ru.amse.abreslav.graphs.model.Edge;
import ru.amse.abreslav.graphs.model.IGraph;
import ru.amse.abreslav.graphs.model.Vertex;

public class PresentationFactory<D, V extends Vertex<D>, E extends Edge<V>> {
	
	public GraphPresentation<D, V, E> createGraphPresentation(IGraph<D, V, E> graph) {
		return new GraphPresentation<D, V, E>(graph, this);
	}
	
	public VertexPresentation<D, V> createVertexPresentation(V v) {
		return new VertexPresentation<D, V>(v);
	}

	public EdgePresentation<E> createEdgePresentation(E e) {
		return new EdgePresentation<E>(e);
	}

}
