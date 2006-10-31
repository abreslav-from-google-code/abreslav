package ru.amse.abreslav.graphs.ui;

import java.awt.Rectangle;

import ru.amse.abreslav.graphs.presentation.GraphPresentation;

public interface GraphLayout<D> {
	void layout(GraphPresentation<D> gp, Rectangle screen);
}
