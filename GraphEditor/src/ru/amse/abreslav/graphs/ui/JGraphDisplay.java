package ru.amse.abreslav.graphs.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;

import ru.amse.abreslav.graphs.presentation.GraphPresentation;
import ru.amse.abreslav.graphs.presentation.PresentationListener;
import ru.amse.abreslav.graphs.presentation.layout.CircleLayout;
import ru.amse.abreslav.graphs.presentation.layout.GraphLayout;
import ru.amse.abreslav.graphs.presentation.renderers.CircleVertexRenderer;
import ru.amse.abreslav.graphs.presentation.renderers.GraphRenderer;
import ru.amse.abreslav.graphs.presentation.renderers.LineEdgeRenderer;

public class JGraphDisplay extends JComponent {

	private static final long serialVersionUID = 8706834037109961071L;

//	private IGraph<Integer, ? extends Vertex<Integer>, ? extends Edge<? extends Vertex<Integer>>> graph = new ListGraph<Integer>();
	
	private interface Painter {
		void paint(Graphics g);
	}
	private final Painter painter;
	private Action layoutAction;
	
	public <D> JGraphDisplay(
					final GraphPresentation<D> presentation, 
					final GraphLayout<D> layout, 
					final GraphRenderer<D> renderer) {

		layoutAction = new AbstractAction("Layout") {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				Rectangle bounds = getBounds();
				bounds.x = 0;
				bounds.y = 0;
				layout.layout(presentation, bounds);
				repaint();
			}
		};
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				layoutAction.actionPerformed(null);
			}			
		});
		
		presentation.addListener(new PresentationListener() {
			public void presentationUpdated() {
				repaint();
			}
		});
		
		painter = new Painter() {
			public void paint(Graphics g) {
				renderer.renderGraph(presentation, g);
			}			
		};
	}
	
	public <D> JGraphDisplay(
				final GraphPresentation<D> presentation) {
		this(presentation, new CircleLayout<D>(), new GraphRenderer<D>(
				new CircleVertexRenderer<D>(),
				new LineEdgeRenderer()
		));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		painter.paint(g);
	}
	
	public Action getLayoutAction() {
		return layoutAction;
	}

}
