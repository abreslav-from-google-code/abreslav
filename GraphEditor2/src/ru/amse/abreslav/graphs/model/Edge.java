package ru.amse.abreslav.graphs.model;

public interface Edge<V extends Vertex<?>> {
	V getStart();
	V getEnd();
	String toString();
}
