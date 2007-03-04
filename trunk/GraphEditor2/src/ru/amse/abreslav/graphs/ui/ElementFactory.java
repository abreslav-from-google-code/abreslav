/**
 * 
 */
package ru.amse.abreslav.graphs.ui;

import ru.amse.abreslav.graphs.model.Edge;
import ru.amse.abreslav.graphs.model.Vertex;

public interface ElementFactory<D, V extends Vertex<D>> {
	V createVertex();
	Edge<V> createEdge(V a, V b);
}