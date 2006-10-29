package ru.amse.abreslav.graphs.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class Graph<D, V extends Vertex<D>, E extends Edge<D, V>> implements Iterable<V> {
	private final ArrayList<V> vertices = new ArrayList<V>();
	protected final List<V> unmodifiableVertices = Collections.unmodifiableList(vertices);
	private final VertexFactory<D, V> vertexFactory;
	
	public Graph(VertexFactory<D, V> factory) {
		vertexFactory = factory; 
	}
	
	public final int size() {
		return vertices.size();
	}
	
	public V addVertex(D data) {
		V v = addVertex();
		v.setData(data);
		return v;
	}
	
	public V addVertex() {
		V v = vertexFactory.createVertex();
		vertices.add(v);
		return v;
	}
	
	public final boolean hasVertex(V v) {
		return vertices.contains(v);
	}
	
	public final boolean removeVertex(V v) {
		if (!beforeVertexRemoved(v)) {
			return false;
		}
		vertices.remove(v);
		return true;
	}
	
	protected boolean beforeVertexRemoved(V v) {
		return true;
	}
	
	public final Iterator<V> iterator() {		
		return unmodifiableVertices.iterator();
	}

	public final List<V> getVertexList() {
		return new ArrayList<V>(vertices);
	}
	
	public abstract E getConnected(V a, V b);
	public abstract E connect(V a, V b);
	public abstract void disconnect(V a, V b);
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("<");	
		result.append(vertices).append("; ");
		result.append("[");
		for (V a : this) {
			for (V b : this) {
				E edge = getConnected(a, b);
				if (edge != null) {
					result.append(edge).append("; ");
				}
			}
		}
		result.append("]>");
		return result.toString();
	}
}
