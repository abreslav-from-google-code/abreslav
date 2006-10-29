/**
 * 
 */
package ru.amse.abreslav.graphs.model;

public class SimpleEdge<V extends Vertex<?>> implements Edge<V> {
	private final V start;
	private final V end;

	public SimpleEdge(V a, V b) {
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