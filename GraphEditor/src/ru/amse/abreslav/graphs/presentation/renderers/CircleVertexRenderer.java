package ru.amse.abreslav.graphs.presentation.renderers;

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
		gc.setColor(Color.WHITE);
		gc.fillOval(vp.getX() - radius, vp.getY() - radius, radius * 2, radius * 2);		
		gc.setColor(Color.BLACK);
		gc.drawOval(vp.getX() - radius, vp.getY() - radius, radius * 2, radius * 2);
		gc.drawString(vp.getVertex().getData().toString(), vp.getX() - radius / 4, vp.getY() + radius / 2);
	}

}
