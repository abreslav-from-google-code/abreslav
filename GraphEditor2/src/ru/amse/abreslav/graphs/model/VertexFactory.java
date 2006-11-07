package ru.amse.abreslav.graphs.model;

public abstract class VertexFactory<D, V extends Vertex<D>> {
	
	public abstract V createVertex();
}
