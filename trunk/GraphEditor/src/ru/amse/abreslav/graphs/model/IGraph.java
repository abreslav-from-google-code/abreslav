package ru.amse.abreslav.graphs.model;

import java.util.List;

public interface IGraph<D, V extends Vertex<D>, E extends Edge<V>> extends Iterable<V> {

	public abstract int size();

	public abstract V addVertex(D data);

	public abstract V addVertex();

	public abstract boolean hasVertex(V v);

	public abstract boolean removeVertex(V v);

	public abstract List<V> getVertexList();

	public abstract E getConnected(V a, V b);

	public abstract E connect(V a, V b);

	public abstract void disconnect(V a, V b);

	public abstract Iterable<E> getEdges();

}