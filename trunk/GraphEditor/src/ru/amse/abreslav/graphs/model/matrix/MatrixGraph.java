package ru.amse.abreslav.graphs.model.matrix;

import java.util.Collection;
import java.util.LinkedHashSet;

import ru.amse.abreslav.graphs.model.Graph;
import ru.amse.abreslav.graphs.model.SimpleEdge;
import ru.amse.abreslav.graphs.model.VertexFactory;

public class MatrixGraph<D> extends Graph<D, MatrixVertex<D>, SimpleEdge<MatrixVertex<D>>> {

	private SimpleEdge<MatrixVertex<D>>[][] matrix;
	private Collection<SimpleEdge<MatrixVertex<D>>> edges = new LinkedHashSet<SimpleEdge<MatrixVertex<D>>>();
	
	public MatrixGraph(int capacity) {
		super(new VertexFactory<D, MatrixVertex<D>>() {
			public MatrixVertex<D> createVertex() {
				return new MatrixVertex<D>();
			}
		});
		createMatrix(capacity);
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
	
	public SimpleEdge<MatrixVertex<D>> connect(MatrixVertex<D> a, MatrixVertex<D> b) {
		SimpleEdge<MatrixVertex<D>> edge = getConnected(a, b);
		if (edge != null) {
			return edge;
		}
		edge = new SimpleEdge<MatrixVertex<D>>(a, b);
		matrix[a.getIndex()][b.getIndex()] = edge;
		edges.add(edge);
		return matrix[a.getIndex()][b.getIndex()];
	}

	public void disconnect(MatrixVertex<D> a, MatrixVertex<D> b) {
		if (matrix[a.getIndex()][b.getIndex()] != null) {
			edges.remove(matrix[a.getIndex()][b.getIndex()]);
			matrix[a.getIndex()][b.getIndex()] = null;
		}
	}

	public SimpleEdge<MatrixVertex<D>> getConnected(MatrixVertex<D> a, MatrixVertex<D> b) {
		return matrix[a.getIndex()][b.getIndex()];
	}

	public Iterable<SimpleEdge<MatrixVertex<D>>> getEdges() {
		return edges;
	}

}
