package ru.amse.abreslav.graphs.model.matrix;

import ru.amse.abreslav.graphs.model.SimpleVertex;

public class MatrixVertex<D> extends SimpleVertex<D> {

	private int index;
	
	/*package-private*/ MatrixVertex() {
	}

	/*package-private*/ int getIndex() {
		return index;
	}
	
	/*package-private*/ void setIndex(int index) {
		this.index = index;
	}
}

