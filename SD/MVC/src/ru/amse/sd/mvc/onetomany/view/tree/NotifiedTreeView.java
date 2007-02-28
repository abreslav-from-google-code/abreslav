package ru.amse.sd.mvc.onetomany.view.tree;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import ru.amse.sd.mvc.onetomany.DataChangedListener;
import ru.amse.sd.mvc.onetomany.NotifyingDataArray;
import ru.amse.sd.mvc.onetoone.DataArray;

@SuppressWarnings("serial")
public class NotifiedTreeView extends JComponent {

	private static final int TOP_FIELD = 20;
	private static final int RADIUS = 15;
	private static final int DIAMETER = 2 * RADIUS;
	private static final int WIDTH = 512;
	private static final int ROW_HEIGHT = 50;

	private final NotifyingDataArray model;
	private final List<TreeVertex> vertices = new ArrayList<TreeVertex>();
	
	private final MouseListener mouseListener = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			String stringData = "";
			while (true) {
				stringData = JOptionPane.showInputDialog("Input vertex data, please:", stringData);
				if (stringData == null) {
					break;
				}
				try {
					Integer data = Integer.valueOf(stringData);
					model.add(data);
//					addVertex(model.size() - 1);
//					repaint();
					break;
				} catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(NotifiedTreeView.this, "Input a number, please");
				}
			}			
		}
	};
	
	private final DataChangedListener dataChangedListener = new DataChangedListener() {
		public void dataChanged() {
			for (int i = vertices.size(); i < model.size(); i++) {
				addVertex(i);
			}
			repaint();
		}
	};
	
	public NotifiedTreeView(NotifyingDataArray model) {
		this.model = model;
		for (int i = 0; i < model.size(); i++) {
			addVertex(i);
		}
		addMouseListener(mouseListener);
		model.addDataChangedListener(dataChangedListener);
	}

	private void addVertex(int i) {
		vertices.add(new TreeVertex(i));
	}

	public DataArray getModel() {
		return model;
	}
	
	@Override
	public void paint(Graphics g) {
		for (TreeVertex vertex : vertices) {
			TreeVertex parent = vertices.get(vertex.getParentIndex());
			g.drawLine(getVertexX(vertex), getVertexY(vertex), getVertexX(parent), getVertexY(parent));
			
		}
		for (TreeVertex vertex : vertices) {
			int x = getVertexX(vertex);
			int y = getVertexY(vertex);
			g.setColor(Color.WHITE);
			g.fillOval(x - RADIUS, y - RADIUS, DIAMETER, DIAMETER);
			String s = String.valueOf(model.get(vertex.getIndex()));
			FontMetrics fm = g.getFontMetrics();
			Rectangle2D sb = fm.getStringBounds(s, g);
			g.setColor(Color.BLACK);
			g.drawString(s, x  - (int) sb.getWidth() / 2, y  - fm.getHeight() / 2 + fm.getMaxAscent());
		}
	}

	private int getVertexY(TreeVertex vertex) {
		return TOP_FIELD + (int) (vertex.getY() * ROW_HEIGHT);
	}

	private int getVertexX(TreeVertex vertex) {
		return (int) (vertex.getX() * WIDTH);
	}
	
}
