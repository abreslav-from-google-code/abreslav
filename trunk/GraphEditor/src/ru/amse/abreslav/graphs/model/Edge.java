package ru.amse.abreslav.graphs.model;

public interface Edge<D, V extends Vertex<D>> {
	V getStart();
	V getEnd();
	String toString();
	
	public class Default<D, V extends Vertex<D>> implements Edge<D, V> {
		private final V start;
		private final V end;

		public Default(V a, V b) {
			start = a;
			end = b;
		}
		
		public V getStart() {
			return start;
		}
		
		public V getEnd() {
			return end;
		}
		
		@Override
		public String toString() {
			return start + " -> " + end;
		}
	}
}
