package ru.amse.abreslav.graphs.model.matrix;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import ru.amse.abreslav.graphs.model.Graph;
import ru.amse.abreslav.graphs.model.SimpleEdge;
import ru.amse.abreslav.graphs.model.VertexFactory;

public class MatrixGraph<D> extends Graph<D, MatrixVertex<D>, SimpleEdge<MatrixVertex<D>>> {

	private SimpleEdge<MatrixVertex<D>>[][] matrix;
	private Collection<SimpleEdge<MatrixVertex<D>>> edges = new LinkedHashSet<SimpleEdge<MatrixVertex<D>>>();
	private Collection<SimpleEdge<MatrixVertex<D>>> unmodifiableEdges = Collections.unmodifiableCollection(edges);
	
	public MatrixGraph(VertexFactory<D, ? extends MatrixVertex<D>> factory, int capacity) {
		super(factory);
		createMatrix(capacity);
	}

	public MatrixGraph(int capacity) {
		this(new VertexFactory<D, MatrixVertex<D>>() {
			public MatrixVertex<D> createVertex() {
				return new MatrixVertex<D>();
			}
		}, capacity);
	}
	
	@SuppressWarnings("unchecked")
	private void createMatrix(int capacity) {
		matrix = new SimpleEdge[capacity][capacity];
	}
	
	public int getCapacity() {
		return matrix.length;
	}
	
	@Override
	protected void beforeVertexAdded() {
		if (size() >= matrix.length) {
			throw new IllegalStateException("Capacity exceeded");
		}
	}

	@Override
	protected void afterVertexAdded(MatrixVertex<D> v) {
		v.setIndex(size() - 1);
	}
	
	public SimpleEdge<MatrixVertex<D>> createEdge(MatrixVertex<D> a, MatrixVertex<D> b) {
		SimpleEdge<MatrixVertex<D>> edge = getEdge(a, b);
		if (edge != null) {
			return edge;
		}
		edge = new SimpleEdge<MatrixVertex<D>>(a, b);
		matrix[a.getIndex()][b.getIndex()] = edge;
		edges.add(edge);
		return edge;
	}

	public boolean removeEdge(MatrixVertex<D> a, MatrixVertex<D> b) {
		SimpleEdge<MatrixVertex<D>> edge = matrix[a.getIndex()][b.getIndex()];
		if (edge == null) {
			return false;
		}
		edges.remove(edge);
		matrix[a.getIndex()][b.getIndex()] = null;
		return true;
	}

	public SimpleEdge<MatrixVertex<D>> getEdge(MatrixVertex<D> a, MatrixVertex<D> b) {
		return matrix[a.getIndex()][b.getIndex()];
	}

	public Collection<SimpleEdge<MatrixVertex<D>>> getEdges() {
		return unmodifiableEdges;
	}

}
