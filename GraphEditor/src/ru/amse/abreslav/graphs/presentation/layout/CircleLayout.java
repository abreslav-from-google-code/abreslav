package ru.amse.abreslav.graphs.presentation.layout;

import java.awt.Rectangle;
import java.util.Collection;

import ru.amse.abreslav.graphs.presentation.GraphPresentation;
import ru.amse.abreslav.graphs.presentation.VertexPresentation;


import static java.lang.Math.*;

public class CircleLayout<D> implements GraphLayout<D> {

	public void layout(GraphPresentation<D> gp, Rectangle screen) {
		Collection<VertexPresentation<D>> vp = gp.getVertexPresentations();
		double cx = screen.getCenterX();
		double cy = screen.getCenterY();
		double r = min(screen.getHeight(), screen.getWidth()) / 2;
		double phi = 0;
		double dphi = 2 * PI / vp.size();
		for (VertexPresentation<D> v : vp) {
			v.setX((int) (cx + r * cos(phi)));
			v.setY((int) (cy - r * sin(phi)));
			phi += dphi;
		}
		
	}

}
