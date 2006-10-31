package ru.amse.abreslav.graphs.ui.renderers;

import java.awt.Graphics;

import ru.amse.abreslav.graphs.presentation.EdgePresentation;

public interface EdgeRenderer {
	public void render(EdgePresentation ep, Graphics gc);
}
