package ru.amse.abreslav.graphs.model.list;

import ru.amse.abreslav.graphs.model.Edge;

public class ListEdge<D> extends Edge.Default<D, ListVertex<D>> {

	public ListEdge(ListVertex<D> a, ListVertex<D> b) {
		super(a, b);
	}

}
