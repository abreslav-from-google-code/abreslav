package ru.amse.abreslav.graphs.presentation;

import ru.amse.abreslav.graphs.model.Edge;
import ru.amse.abreslav.graphs.model.IGraph;
import ru.amse.abreslav.graphs.model.Vertex;
import ru.amse.abreslav.graphs.presentation.events.NotifyingGraph;

public class PresentationFactory<D> {
	
	public static class Result<D, V extends Vertex<D>, E extends Edge<V>> {
		public final IGraph<D, V, E> graph;
		public final GraphPresentation<D> presentation;
		
		public Result(IGraph<D, V, E> graph, GraphPresentation<D> presentation) {
			this.graph = graph;
			this.presentation = presentation;
		}
	}
	
	public static <D, V extends Vertex<D>, E extends Edge<V>> Result<D, V, E> createPresentationAndGraph(IGraph<D, V, E> graph) {
		NotifyingGraph<D, V, E> notifyingGraph = new NotifyingGraph<D, V, E>(graph);
		GraphPresentation<D> presentation = new GraphPresentation<D>(notifyingGraph, new PresentationFactory<D>());
		return new Result<D, V, E>(notifyingGraph, presentation);
	}

	public static <D, V extends Vertex<D>, E extends Edge<V>> GraphPresentation<D> createPresentation(IGraph<D, V, E> graph) {
		return new GraphPresentation<D>(new NotifyingGraph<D, V, E>(graph), new PresentationFactory<D>());
	}

	private PresentationFactory() {
	}
	
	protected VertexPresentation<D> createVertexPresentation(Vertex<D> v, GraphPresentation<D> gp) {
		return new VertexPresentation<D>(v, gp);
	}

	protected EdgePresentation createEdgePresentation(Edge e) {
		return new EdgePresentation(e);
	}	
}
