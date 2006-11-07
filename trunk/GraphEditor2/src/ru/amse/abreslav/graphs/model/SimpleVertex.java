package ru.amse.abreslav.graphs.model;

public class SimpleVertex<D> implements Vertex<D> {
	private D data;
	
	public D getData() {
		return data;
	}

	public void setData(D data) {
		this.data = data; 
	}

	@Override
	public String toString() {
		return data == null ? "null" : data.toString();
	}
}