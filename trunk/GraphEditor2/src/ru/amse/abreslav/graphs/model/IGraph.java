package ru.amse.abreslav.graphs.model;

import java.util.Collection;
import java.util.List;

public interface IGraph<D, V extends Vertex<D>, E extends Edge<V>> extends Iterable<V> {

	public abstract int size();

	public abstract V addVertex(D data);

	public abstract boolean hasVertex(V v);

	public abstract boolean removeVertex(V v);

	public abstract List<V> getVertices();

	public abstract E getEdge(V a, V b);

	public abstract E createEdge(V a, V b);

	public abstract boolean removeEdge(V a, V b);

	public abstract Collection<E> getEdges();

}