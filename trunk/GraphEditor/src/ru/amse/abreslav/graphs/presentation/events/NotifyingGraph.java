package ru.amse.abreslav.graphs.presentation.events;

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

	public V addVertex() {
		V v = graph.addVertex();
		fireVertexAdded(v);
		return v;
	}

	public E connect(V a, V b) {
		E e = graph.connect(a, b);
		fireVertexConnected(e);
		return e;
	}

	public void disconnect(V a, V b) {
		E e = graph.getConnected(a, b);
		graph.disconnect(a, b);
		if (e != null) {
			fireVertexDisconnected(e);
		}
	}

	public E getConnected(V a, V b) {
		return graph.getConnected(a, b);
	}

	public Iterable<E> getEdges() {
		return graph.getEdges();
	}

	public List<V> getVertexList() {
		return graph.getVertexList();
	}

	public boolean hasVertex(V v) {
		return graph.hasVertex(v);
	}

	public boolean removeVertex(V v) {
		// Disconnect neighbors
		// Due to notifications
		Set<E> edgesToRemove = new HashSet<E>();
		for (V a : graph) {
			edgesToRemove.add(getConnected(a, v));
			edgesToRemove.add(getConnected(v, a));
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
