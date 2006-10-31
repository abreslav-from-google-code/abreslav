package ru.amse.abreslav.graphs.presentation;

import java.awt.Rectangle;


public interface GraphLayout<D> {
	void layout(GraphPresentation<D> gp, Rectangle screen);
}
