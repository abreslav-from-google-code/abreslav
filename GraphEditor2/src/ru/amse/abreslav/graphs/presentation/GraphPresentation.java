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

public class GraphPresentation<D> {
	private final PresentationFactory<D> factory;
	
	private final Map<Vertex, VertexPresentation<D>> vertexPresentations = new LinkedHashMap<Vertex, VertexPresentation<D>>();
	private final Collection<VertexPresentation<D>> unmodifiableVertexPresentations = Collections.unmodifiableCollection(vertexPresentations.values());

	private final Map<Edge, EdgePresentation> edgePresentations = new LinkedHashMap<Edge, EdgePresentation>();
	private final Collection<EdgePresentation> unmodifiableEdgePresentations = Collections.unmodifiableCollection(edgePresentations.values());
	
	private final NotifyingGraph<?, ? extends Vertex<?>, ? extends Edge<? extends Vertex<?>>> notifyingGraph;
	
	private final Collection<PresentationListener> listeners = new LinkedHashSet<PresentationListener>();
	
	/*package-private*/ <V extends Vertex<D>, E extends Edge<V>> GraphPresentation(NotifyingGraph<D, V, E> graph, PresentationFactory<D> f) {
		this.factory = f;
		notifyingGraph = graph;
		graph.addModificationListener(new GraphModificationListener<V, E>() {
			public void vertexAdded(V v) {
				if (acceptVertex(v)) {
					notifyListeners();
				}
			}

			public void vertexConnected(E e) {
				if (acceptEdge(e)) {		
					notifyListeners();
				}
			}

			public void vertexDisconnected(E e) {
				if (edgePresentations.remove(e) != null) {
					notifyListeners();
				}
			}

			public void vertexRemoved(V v) {
				if (vertexPresentations.remove(v) != null) {
					notifyListeners();
				}
			}
			
		});
		
		for (V v : graph) {
			acceptVertex(v);
		}
		for (E e : graph.getEdges()) {
			acceptEdge(e);
		}
	}
	
	private boolean acceptEdge(Edge e) {
		if (edgePresentations.containsKey(e)) {
			return false;
		}
		EdgePresentation ep = factory.createEdgePresentation(e);
		ep.setStart(getVertexPresentation(e.getStart()).getPositionCopy());
		ep.setEnd(getVertexPresentation(e.getEnd()).getPositionCopy());
		edgePresentations.put(e, ep);
		return true;
	}

	private boolean acceptVertex(Vertex<D> v) {
		if (vertexPresentations.containsKey(v)) {
			return false;
		}
		vertexPresentations.put(v, factory.createVertexPresentation(v, this));
		return true;
	}

	public Collection<VertexPresentation<D>> getVertexPresentations() {
		return unmodifiableVertexPresentations;
	}

	public VertexPresentation<D> getVertexPresentation(Vertex v) {
		return vertexPresentations.get(v);
	}

	public Collection<EdgePresentation> getEdgePresentations() {
		return unmodifiableEdgePresentations;
	}

	public EdgePresentation getEdgePresentation(Edge e) {
		return edgePresentations.get(e);
	}

	/*package-private*/ void vertexMoved(VertexPresentation<D> vp) {
		for (Edge e : notifyingGraph.getEdges()) {
			if (e.getStart() == vp.getVertex()) {
				edgePresentations.get(e).setStart(vp.getPositionCopy());
			}
			if (e.getEnd() == vp.getVertex()) {
				edgePresentations.get(e).setEnd(vp.getPositionCopy());
			}
		}
		notifyListeners();
	}

	public void addListener(PresentationListener listener) {
		listeners.add(listener);
	}
	
	public void removeListener(PresentationListener listener) {
		listeners.remove(listener);
	}
	
	private void notifyListeners() {
		for (PresentationListener listener : listeners) {
			listener.presentationUpdated();
		}		
	}
	
	public IGraph getNotifyingGraph() {
		return notifyingGraph;
	}

}
