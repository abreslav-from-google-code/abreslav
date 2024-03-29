package ru.amse.abreslav.graphs.ui.renderers;

import java.awt.Color;
import java.awt.Graphics;

import ru.amse.abreslav.graphs.presentation.VertexPresentation;

public class CircleVertexRenderer<D> implements VertexRenderer<D> {

	private int radius;

	public CircleVertexRenderer(int r) {
		radius = r;
	}
	
	public CircleVertexRenderer() {
		this(10);
	}
	
	public void render(VertexPresentation<D> vp, Graphics gc) {
		renderVertexShape(vp.getX(), vp.getY(), gc);
		String data = vp.getVertex().toString();
		int w = gc.getFontMetrics().stringWidth(data);
		int h = gc.getFontMetrics().getMaxAscent() - gc.getFontMetrics().getMaxDescent();		
		gc.drawString(data, (int) (vp.getX() - w / 2), (int) (vp.getY() + h / 2));
	}

	public boolean isPointInVertexBounds(int x, int y, int vx, int vy) {		
		return (sqr(x - vx) + sqr(y - vy) <= sqr(radius));
	}
	
	private static double sqr(double x) {
		return x * x;
	}

	public void renderVertexShape(int x, int y, Graphics gc) {
		gc.setColor(Color.WHITE);
		gc.fillOval(x - radius, y - radius, radius * 2, radius * 2);		
		gc.setColor(Color.BLACK);
		gc.drawOval(x - radius, y - radius, radius * 2, radius * 2);
	}

}
