package ru.amse.abreslav.graphs.presentation.events;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import ru.amse.abreslav.graphs.model.Edge;
import ru.amse.abreslav.graphs.model.IGraph;
import ru.amse.abreslav.graphs.model.Vertex;

public class NotifyingGraph<D, V extends Vertex<D>, E extends Edge<V>> implements IGraph<D, V, E> {
	
	private final IGraph<D, V, E> graph;
	private final LinkedHashSet<GraphModificationListener<V, E>> listeners = new LinkedHashSet<GraphModificationListener<V, E>>();

	public NotifyingGraph(IGraph<D, V, E> g) {
		graph = g;
	}

	public V addVertex(D data) {
		V v = graph.addVertex(data);
		fireVertexAdded(v);
		return v;
	}

	public E createEdge(V a, V b) {
		E e = graph.createEdge(a, b);
		fireVertexConnected(e);
		return e;
	}

	public boolean removeEdge(V a, V b) {
		E e = graph.getEdge(a, b);
		boolean result = graph.removeEdge(a, b);
		if (result) {
			fireVertexDisconnected(e);
		}
		return result;
	}

	public E getEdge(V a, V b) {
		return graph.getEdge(a, b);
	}

	public Collection<E> getEdges() {
		return graph.getEdges();
	}

	public List<V> getVertices() {
		return graph.getVertices();
	}

	public boolean hasVertex(V v) {
		return graph.hasVertex(v);
	}

	public boolean removeVertex(V v) {
		// Disconnect neighbors
		// Due to notifications
		Set<E> edgesToRemove = new HashSet<E>();
		for (V a : graph) {
			edgesToRemove.add(getEdge(a, v));
			edgesToRemove.add(getEdge(v, a));
		}		
		boolean removed = graph.removeVertex(v);
		if (removed) {
			for (E e : edgesToRemove) {
				if (e != null) {
					fireVertexDisconnected(e);
				}
			}
			fireVertexRemoved(v);
		}
		return removed;
	}

	public int size() {
		return graph.size();
	}

	public Iterator<V> iterator() {
		return graph.iterator();
	}
	
	public void addModificationListener(GraphModificationListener<V, E> listener) {
		listeners.add(listener);
	}

	public void removeModificationListener(GraphModificationListener<V, E> listener) {
		listeners.remove(listener);
	}
	
	private void fireVertexAdded(V v) {
		for (GraphModificationListener<V, E> listener : listeners) {
			listener.vertexAdded(v);
		}
	}
	
	private void fireVertexRemoved(V v) {
		for (GraphModificationListener<V, E> listener : listeners) {
			listener.vertexRemoved(v);
		}
	}

	private void fireVertexConnected(E e) {
		for (GraphModificationListener<V, E> listener : listeners) {
			listener.vertexConnected(e);
		}
	}

	private void fireVertexDisconnected(E e) {
		for (GraphModificationListener<V, E> listener : listeners) {
			listener.vertexDisconnected(e);
		}
	}	
}
