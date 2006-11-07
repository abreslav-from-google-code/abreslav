package ru.amse.abreslav.graphs.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class Graph<D, V extends Vertex<D>, E extends Edge<V>> implements IGraph<D, V, E> {
	private final ArrayList<V> vertices = new ArrayList<V>();
	protected final List<V> unmodifiableVertices = Collections.unmodifiableList(vertices);
	private final VertexFactory<D, ? extends V> vertexFactory;
	
	public Graph(VertexFactory<D, ? extends V> factory) {
		vertexFactory = factory; 
	}
	
	public final int size() {
		return vertices.size();
	}
	
	public final V addVertex(D data) {
		beforeVertexAdded();
		V v = vertexFactory.createVertex();
		v.setData(data);
		vertices.add(v);
		afterVertexAdded(v);
		return v;
	}
	
	protected void beforeVertexAdded() {
	}

	protected void afterVertexAdded(V v) {
	}
	
	public final boolean hasVertex(V v) {
		return vertices.contains(v);
	}
	
	public final boolean removeVertex(V v) {
		if (!beforeVertexRemoved(v)) {
			return false;
		}
		disconnectNeighbors(v);
		vertices.remove(v);
		return true;
	}
	
	protected void disconnectNeighbors(V v) {
		for (V a : vertices) {
			removeEdge(a, v);
			removeEdge(v, a);
		}		
	}

	protected boolean beforeVertexRemoved(V v) {
		return true;
	}
	
	public final Iterator<V> iterator() {		
		return unmodifiableVertices.iterator();
	}

	public final List<V> getVertices() {
		return unmodifiableVertices;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("<");	
		result.append(vertices).append("; ");
		result.append("[");
		for (V a : this) {
			for (V b : this) {
				E edge = getEdge(a, b);
				if (edge != null) {
					result.append(edge).append("; ");
				}
			}
		}
		result.append("]>");
		return result.toString();
	}
}
