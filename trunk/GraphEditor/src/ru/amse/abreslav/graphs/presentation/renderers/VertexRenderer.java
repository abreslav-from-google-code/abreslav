package ru.amse.abreslav.graphs.presentation.renderers;

import java.awt.Graphics;

import ru.amse.abreslav.graphs.presentation.VertexPresentation;

public interface VertexRenderer<D> {
	public void render(VertexPresentation<D> vp, Graphics gc);
}
