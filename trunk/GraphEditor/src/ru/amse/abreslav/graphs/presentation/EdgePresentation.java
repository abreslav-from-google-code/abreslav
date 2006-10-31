package ru.amse.abreslav.graphs.presentation;

import ru.amse.abreslav.graphs.model.Edge;

public class EdgePresentation<E extends Edge<?>> {

	private final E edge;
	
	public EdgePresentation(E e) {
		edge = e;
	}
	
	public E getEdge() {
		return edge;
	}	

}
