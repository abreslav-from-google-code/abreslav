package ru.amse.abreslav.graphs.model.list;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ru.amse.abreslav.graphs.model.Vertex;

public class ListVertex<D> extends Vertex.Default<D> {

	private final Map<ListVertex<D>, ListEdge<D>> edges = new HashMap<ListVertex<D>, ListEdge<D>>();
	private final Collection<ListVertex<D>> neighbors = Collections.unmodifiableCollection(edges.keySet());
	
	/*package-private*/ ListVertex() {		
	}
	
	public ListEdge<D> getConnectedTo(ListVertex<D> v) {
		return edges.get(v);
	}
	
	/*package-private*/ void acceptEdge(ListEdge<D> e) {
		if (e.getStart() != this) {
			throw new IllegalArgumentException("Edge start doesn't match");
		}
		edges.put(e.getEnd(), e);
	}
	
	/*package-private*/ void disconnectFrom(ListVertex<D> v) {
		edges.keySet().remove(v);
	}	
	
	public Iterator<ListVertex<D>> neighborsIterator() {
		return neighbors.iterator();
	}
}
