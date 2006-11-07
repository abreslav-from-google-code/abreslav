package ru.amse.abreslav.graphs.ui.renderers;

import java.awt.Graphics;

import ru.amse.abreslav.graphs.presentation.VertexPresentation;

public interface VertexRenderer<D> {
	void render(VertexPresentation<D> vp, Graphics gc);
	void renderVertexShape(int x, int y, Graphics gc);
	boolean isPointInVertexBounds(int x, int y, int vx, int vy);
}
