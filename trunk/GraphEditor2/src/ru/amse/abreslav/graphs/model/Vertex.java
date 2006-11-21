package ru.amse.abreslav.graphs.model;

public interface Vertex<D> {
	D getData();
	void setData(D data);
	String toString();
}
