package ru.amse.abreslav.graphs.ui.renderers;

import java.awt.Graphics;

import ru.amse.abreslav.graphs.presentation.EdgePresentation;

public class LineEdgeRenderer implements EdgeRenderer{

	public void render(EdgePresentation ep, Graphics gc) {
		gc.drawLine(ep.getStart().x, ep.getStart().y, ep.getEnd().x, ep.getEnd().y);
	}

}
