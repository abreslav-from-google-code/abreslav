package ru.amse.abreslav.graphs.model.matrix;

import ru.amse.abreslav.graphs.model.Edge;
import ru.amse.abreslav.graphs.model.Graph;
import ru.amse.abreslav.graphs.model.VertexFactory;

public class MatrixGraph<D> extends Graph<D, MatrixVertex<D>, Edge.Default<D, MatrixVertex<D>>> {

	private Edge.Default<D, MatrixVertex<D>>[][] matrix;
	
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
		matrix = new Edge.Default[capacity][capacity];
	}
	
	public int getCapacity() {
		return matrix.length;
	}
	
	@Override
	public MatrixVertex<D> addVertex() {
		if (size() >= matrix.length) {
			throw new IllegalStateException("Capacity exceeded");
		}
		MatrixVertex<D> result = super.addVertex();
		result.setIndex(size() - 1);
		return result;
	}

	@Override
	public Edge.Default<D, MatrixVertex<D>> connect(MatrixVertex<D> a, MatrixVertex<D> b) {
		Edge.Default<D, MatrixVertex<D>> edge = getConnected(a, b);
		if (edge != null) {
			return edge;
		}
		matrix[a.getIndex()][b.getIndex()] = new Edge.Default<D, MatrixVertex<D>>(a, b); 
		return matrix[a.getIndex()][b.getIndex()];
	}

	@Override
	public void disconnect(MatrixVertex<D> a, MatrixVertex<D> b) {
		matrix[a.getIndex()][b.getIndex()] = null;
	}

	@Override
	public Edge.Default<D, MatrixVertex<D>> getConnected(MatrixVertex<D> a, MatrixVertex<D> b) {
		return matrix[a.getIndex()][b.getIndex()];
	}

}
