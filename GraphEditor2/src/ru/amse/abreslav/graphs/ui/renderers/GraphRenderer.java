package ru.amse.abreslav.graphs.ui.renderers;

import java.awt.Graphics;

import ru.amse.abreslav.graphs.presentation.EdgePresentation;
import ru.amse.abreslav.graphs.presentation.GraphPresentation;
import ru.amse.abreslav.graphs.presentation.VertexPresentation;

public class GraphRenderer<D> {
	
	private VertexRenderer<D> vertexRenderer;
	private EdgeRenderer edgeRenderer;

	public GraphRenderer(VertexRenderer<D> vr, EdgeRenderer er) {
		vertexRenderer = vr;
		edgeRenderer = er;
	}
	
	public void renderGraph(GraphPresentation<D> gp, Graphics gc) {
		for (EdgePresentation ep : gp.getEdgePresentations()) {
			edgeRenderer.render(ep, gc);
		}
		for (VertexPresentation<D> vp : gp.getVertexPresentations()) {
			vertexRenderer.render(vp, gc);
		}
	}
	
	public VertexRenderer<D> getVertexRenderer() {
		return vertexRenderer;
	}
	
	public EdgeRenderer getEdgeRenderer() {
		return edgeRenderer;
	}
}
