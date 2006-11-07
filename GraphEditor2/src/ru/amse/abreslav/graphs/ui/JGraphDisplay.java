package ru.amse.abreslav.graphs.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;

import ru.amse.abreslav.graphs.model.Vertex;
import ru.amse.abreslav.graphs.presentation.GraphPresentation;
import ru.amse.abreslav.graphs.presentation.PresentationListener;
import ru.amse.abreslav.graphs.presentation.VertexPresentation;
import ru.amse.abreslav.graphs.presentation.layout.CircleLayout;
import ru.amse.abreslav.graphs.presentation.layout.GraphLayout;
import ru.amse.abreslav.graphs.ui.renderers.CircleVertexRenderer;
import ru.amse.abreslav.graphs.ui.renderers.GraphRenderer;
import ru.amse.abreslav.graphs.ui.renderers.LineEdgeRenderer;

public class JGraphDisplay extends JComponent {

	private interface Painter {
		void paint(Graphics g);
	}

	private abstract class Mode extends MouseAdapter implements MouseMotionListener {
		
		public void additionalPaint(Graphics g) {
		}

		public void modeChangedTo(Mode newMode) {			
		}
		
		public void mouseDragged(MouseEvent e) {
		}
		
		public void mouseMoved(MouseEvent e) {
		}
	}

	private static final long serialVersionUID = 8706834037109961071L;

	/* Defined in the constructor due to typification */
	private final Mode DEFAULT; 

	private final Mode ADD_VERTEX = new Mode() {
		private static final int RADIUS = 10;

		@Override
		public void additionalPaint(Graphics g) {
			g.drawOval(mouseListener.getX() - RADIUS, mouseListener.getY()
					- RADIUS, 2 * RADIUS, 2 * RADIUS);
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			repaint();
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			Vertex vertex = elementCreator.createVertex();
			VertexPresentation<?> vertexPresentation = presentation.getVertexPresentation(vertex);
			vertexPresentation.setX(e.getX());
			vertexPresentation.setY(e.getY());
		}
		
		@Override
		public void modeChangedTo(Mode newMode) {
			if (newMode != this) {
				repaint();
			}
		}
	};

	private final Mode CREATE_EDGE = new Mode() {
		private VertexPresentation start;

		@Override
		public void mouseReleased(MouseEvent e) {
			if (start != null) {
				VertexPresentation v = findVertex(e);
				if (v != null) {
					createEdge(v);
				}
				repaint();
			}
			start = null;
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			start = findVertex(e);
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			if (start != null) {
				repaint();
			}
		}
		
		@SuppressWarnings("unchecked")
		private void createEdge(VertexPresentation v) {
			elementCreator.createEdge(start.getVertex(), v.getVertex());
		}

		@Override
		public void additionalPaint(Graphics g) {
			if (start != null) {
				g.drawLine(start.getX(), start.getY(), mouseListener.getX(), mouseListener.getY());
			}
		}
	};

	private final Mode MOVE_VERTEX = new Mode() {
		private VertexPresentation<?> moved;
		private int dx;
		private int dy;		
		
		@Override
		public void mouseReleased(MouseEvent e) {
			moved = null;
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			moved = findVertex(e);
			if (moved != null) {
				dx = moved.getX() - e.getX(); 
				dy = moved.getY() - e.getY(); 
			}
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			if (moved != null) {
				moved.setX(e.getX() + dx);
				moved.setY(e.getY() + dy);
			}						 
		}
	};

	private final Mode DELETE_VERTEX = new Mode() {
		private VertexPresentation<?> v;
		
		@Override
		public void additionalPaint(Graphics g) {
			if (v != null) {
				g.setColor(Color.RED);
				g.setColor(Color.RED);
				int l = 10;
				g.drawLine(v.getX() - l, v.getY() - l, v.getX() + l, v.getY() + l);
				g.drawLine(v.getX() + l, v.getY() - l, v.getX() - l, v.getY() + l);				
			}
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			v = findVertex(e);
			if (v != null) {
				removeVertex(v);
				v = null;
			}
		}
		
		@Override
		public void mouseMoved(MouseEvent e) {
			v = findVertex(e);
			repaint();
		}
		
		@SuppressWarnings("unchecked")
		private void removeVertex(VertexPresentation<?> v) {
			presentation.getNotifyingGraph().removeVertex(v.getVertex());
		}
	};

	private class MyMouseListener implements MouseListener, MouseMotionListener {
		private int x;

		private int y;

		public void mouseDragged(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			mode.mouseDragged(e);
		}

		public void mouseMoved(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			mode.mouseMoved(e);
		}

		public void mouseClicked(MouseEvent e) {
			mode.mouseClicked(e);
		}
		
		public void mousePressed(MouseEvent e) {
			mode.mousePressed(e);
		}
		
		public void mouseReleased(MouseEvent e) {
			mode.mouseReleased(e);
		}

		public void mouseEntered(MouseEvent e) {
			mode.mouseEntered(e);
		}
		
		public void mouseExited(MouseEvent e) {
			mode.mouseExited(e);
		}
		
		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

	}

	// private IGraph<Integer, ? extends Vertex<Integer>, ? extends Edge<? extends Vertex<Integer>>> graph = new ListGraph<Integer>();

	private final Painter painter;

	private final List<Action> actions = new ArrayList<Action>();

	private final List<Action> unmodifiableActions = Collections.unmodifiableList(actions);

	private Mode mode;

	private final MyMouseListener mouseListener;

	private final GraphPresentation<?> presentation;

	private final ElementCreator elementCreator;
	
	private final GraphRenderer<?> renderer;
	
	public <D, V extends Vertex<D>> JGraphDisplay(
			final ElementCreator<D, V> elementCreator,
			final GraphPresentation<D> presentation,
			final GraphLayout<D> layout, 
			final GraphRenderer<D> renderer,
			final GraphActionListener<D> gal) {
		this.presentation = presentation;
		this.elementCreator = elementCreator;
		this.renderer = renderer;
		
		DEFAULT = new Mode() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				for (VertexPresentation<D> vp : presentation.getVertexPresentations()) {
					if (renderer.getVertexRenderer().isPointInVertexBounds(e.getX(), e.getY(), vp.getX(), vp.getY())) {
						if (gal.vertexClicked(vp.getVertex())) {
							repaint();							
						}
					}
				}
			}
		};

		mode = DEFAULT;
		
		createActions(presentation, layout);

		presentation.addListener(new PresentationListener() {
			public void presentationUpdated() {
				repaint();
			}
		});

		painter = new Painter() {
			public void paint(Graphics g) {
				renderer.renderGraph(presentation, g);
				mode.additionalPaint(g);
			}
		};

		mouseListener = new MyMouseListener();
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);
	}

	public <D, V extends Vertex<D>> JGraphDisplay(
			final ElementCreator<D, V> elementCreator, 
			final GraphPresentation<D> presentation,
			final GraphActionListener<D> gal) {
		this(
			elementCreator, presentation, new CircleLayout<D>(), new GraphRenderer<D>(
			new CircleVertexRenderer<D>(), new LineEdgeRenderer()), 
			gal);
	}

	private <D> void createActions(final GraphPresentation<D> presentation,
			final GraphLayout<D> layout) {
		
		class ModeAction extends AbstractAction {
			private static final long serialVersionUID = 1L;
			
			private Mode mode;

			public ModeAction(String name, Mode mode) {
				super(name);
				this.mode = mode;
			}

			public void actionPerformed(ActionEvent e) {
				setMode(mode);
			}
		}
		
		actions.add(new ModeAction("Default", DEFAULT));
		actions.add(new ModeAction("Add vertex", ADD_VERTEX));
		actions.add(new ModeAction("Delete vertex", DELETE_VERTEX));
		actions.add(new ModeAction("Create edge", CREATE_EDGE));
		actions.add(new ModeAction("Move vertex", MOVE_VERTEX));

		actions.add(new AbstractAction("Layout") {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				Rectangle bounds = getBounds();
				bounds.x = 0;
				bounds.y = 0;
				layout.layout(presentation, bounds);
				repaint();
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		painter.paint(g);
	}

	public List<Action> getActions() {
		return unmodifiableActions;
	}

	private VertexPresentation<?> findVertex(MouseEvent e) {
		for (VertexPresentation vp : presentation.getVertexPresentations()) {
			if (renderer.getVertexRenderer().isPointInVertexBounds(e.getX(), e.getY(), vp.getX(), vp.getY())) {
				return vp;
			}
		}
		return null;
	}
	
	public void setMode(Mode mode) {
		Mode oldMode = this.mode;
		this.mode = mode;
		oldMode.modeChangedTo(mode);
	}
}
