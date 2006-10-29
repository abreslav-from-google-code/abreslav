package ru.amse.abreslav.graphs.model;

public interface Vertex<D> {
	
	D getData();
	void setData(D data);
	String toString();
	
	/**
	 * SimpleEdge implementation 
	 */
	public class Default<D> implements Vertex<D> {
		private D data;
		
		public D getData() {
			return data;
		}

		public void setData(D data) {
			this.data = data; 
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}
}
