package ru.amse.abreslav.graphs.presentation;

import java.awt.Point;

import ru.amse.abreslav.graphs.model.Vertex;

public class VertexPresentation<D> {

	private final GraphPresentation<D> graphPresentation;
	private final Vertex<D> vertex;
	private Point position = new Point();

	/*package-private*/ VertexPresentation(Vertex<D> v, GraphPresentation<D> gp) {
		graphPresentation = gp;
		vertex = v;
	}

	public Vertex<D> getVertex() {
		return vertex;
	}
	
	public Point getPositionCopy() {
		return new Point(position);
	}
	
	public int getX() {
		return position.x;
	}
	
	public void setX(int x) {
		if (this.position.x != x) {
			this.position.x = x;
			graphPresentation.vertexMoved(this);
		}
	}
	
	public int getY() {
		return position.y;
	}
	
	public void setY(int y) {
		if (this.position.y != y) {
			this.position.y = y;
			graphPresentation.vertexMoved(this);
		}
	}	
}
