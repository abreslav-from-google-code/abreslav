/**
 * 
 */
package ru.amse.abreslav.graphs.ui;

import ru.amse.abreslav.graphs.model.Vertex;

public interface GraphActionListener<D> {
	boolean vertexClicked(Vertex<D> v);
}