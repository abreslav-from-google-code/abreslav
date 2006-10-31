package ru.amse.abreslav.graphs.presentation;

import ru.amse.abreslav.graphs.model.Edge;
import ru.amse.abreslav.graphs.model.IGraph;
import ru.amse.abreslav.graphs.model.Vertex;
import ru.amse.abreslav.graphs.presentation.events.NotifyingGraph;

public class PresentationFactory<D> {
	
	public static class Result<D, V extends Vertex<D>, E extends Edge<V>> {
		public final IGraph<D, V, E> graph;
		public final PresentationFactory<D> factory;
		
		public Result(IGraph<D, V, E> graph, PresentationFactory<D> factory) {
			this.graph = graph;
			this.factory = factory;
		}
	}
	
	public static <D, V extends Vertex<D>, E extends Edge<V>> Result<D, V, E> createFactory(IGraph<D, V, E> graph) {
		NotifyingGraph<D, V, E> notifyingGraph = new NotifyingGraph<D, V, E>(graph);;
		PresentationFactory<D> presentationFactory = new PresentationFactory<D>(notifyingGraph);
		return new Result<D, V, E>(notifyingGraph, presentationFactory);
	}

	private GraphPresentation<D> presentation;
	
	private <V extends Vertex<D>, E extends Edge<V>> PresentationFactory(NotifyingGraph<D, V, E> graph) {
		presentation = new GraphPresentation<D>(graph, this);
	}
	
	public GraphPresentation<D> getGraphPresentation() {
		return presentation;
	}

	protected VertexPresentation<D> createVertexPresentation(Vertex<D> v, GraphPresentation<D> gp) {
		return new VertexPresentation<D>(v, gp);
	}

	protected EdgePresentation createEdgePresentation(Edge e) {
		return new EdgePresentation(e);
	}
	
}
