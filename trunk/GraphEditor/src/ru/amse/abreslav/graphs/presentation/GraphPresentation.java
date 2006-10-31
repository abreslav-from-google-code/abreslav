package ru.amse.abreslav.graphs.presentation;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import ru.amse.abreslav.graphs.model.Edge;
import ru.amse.abreslav.graphs.model.IGraph;
import ru.amse.abreslav.graphs.model.Vertex;
import ru.amse.abreslav.graphs.presentation.events.GraphModificationListener;
import ru.amse.abreslav.graphs.presentation.events.NotifyingGraph;
import ru.amse.abreslav.graphs.presentation.events.PresentationListener;

public class GraphPresentation<D, V extends Vertex<D>, E extends Edge<V>> implements GraphModificationListener<D, V, E> {
	private final PresentationFactory<D, V, E> factory;
	
	private final Map<V, VertexPresentation<D, V>> vertexPresentations = new LinkedHashMap<V, VertexPresentation<D, V>>();
	private final Collection<VertexPresentation<D, V>> unmodifiableVertexPresentations = Collections.unmodifiableCollection(vertexPresentations.values());

	private final Map<E, EdgePresentation<E>> edgePresentations = new LinkedHashMap<E, EdgePresentation<E>>();
	private final Collection<EdgePresentation<E>> unmodifiableEdgePresentations = Collections.unmodifiableCollection(edgePresentations.values());
	
	private final NotifyingGraph<D, V, E> notifyingGraph;
	
	private final Collection<PresentationListener> listeners = new LinkedHashSet<PresentationListener>();
	
	/*package-private*/ GraphPresentation(IGraph<D, V, E> graph, PresentationFactory<D, V, E> f) {
		this.factory = f;
		notifyingGraph = new NotifyingGraph<D, V, E>(graph);
		notifyingGraph.addModificationListener(this);
		for (V v : graph) {
			acceptVertex(v);
		}
		for (E e : graph.getEdges()) {
			acceptEdge(e);
		}
	}
	
	public IGraph<D, V, E> getGraph() {
		return notifyingGraph;
	}

	private void acceptEdge(E e) {
		edgePresentations.put(e, factory.createEdgePresentation(e));
	}

	private void acceptVertex(V v) {
		vertexPresentations.put(v, factory.createVertexPresentation(v));
	}

	public Collection<VertexPresentation<D, V>> getVertexPresentations() {
		return unmodifiableVertexPresentations;
	}

	public Collection<EdgePresentation<E>> getEdgePresentations() {
		return unmodifiableEdgePresentations;
	}

	public void vertexAdded(V v) {
		acceptVertex(v);
	}

	public void vertexConnected(E e) {
		acceptEdge(e);		
	}

	public void vertexDisconnected(E e) {
		edgePresentations.remove(e);		
	}

	public void vertexRemoved(V v) {
		vertexPresentations.remove(v);		
	}
	
	public void addListener(PresentationListener listener) {
		listeners.add(listener);
	}
	
	public void removeListener(PresentationListener listener) {
		listeners.remove(listener);
	}
}
