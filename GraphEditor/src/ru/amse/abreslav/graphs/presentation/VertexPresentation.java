package ru.amse.abreslav.graphs.presentation;

import ru.amse.abreslav.graphs.model.Vertex;

public class VertexPresentation<D, V extends Vertex<D>> {

	private final V vertex;

	public VertexPresentation(V v) {
		vertex = v;
	}

	public V getVertex() {
		return vertex;
	}	
}
