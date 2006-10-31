package ru.amse.abreslav.graphs.presentation;

import java.awt.Point;

import ru.amse.abreslav.graphs.model.Edge;

public class EdgePresentation {

	private final Edge edge;
	private final Point start = new Point();
	private final Point end = new Point();
	
	/*package-private*/ EdgePresentation(Edge e) {
		edge = e;
	}
	
	public Edge getEdge() {
		return edge;
	}
	
	public Point getStart() {
		return start;
	}
	
	/*package-private*/ void setStart(Point p) {
		start.setLocation(p);
	}

	public Point getEnd() {
		return end;
	}
	
	/*package-private*/ void setEnd(Point p) {
		end.setLocation(p);
	}

}
