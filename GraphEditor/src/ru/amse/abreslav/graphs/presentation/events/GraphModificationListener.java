package ru.amse.abreslav.graphs.presentation.events;

import ru.amse.abreslav.graphs.model.Edge;
import ru.amse.abreslav.graphs.model.Vertex;

public interface GraphModificationListener<D, V extends Vertex<D>, E extends Edge<V>> {
	void vertexAdded(V v);
	void vertexRemoved(V v);
	void vertexConnected(E e);
	void vertexDisconnected(E e);
}
