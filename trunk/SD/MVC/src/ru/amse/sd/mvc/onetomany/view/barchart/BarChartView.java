package ru.amse.sd.mvc.onetomany.view.barchart;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JComponent;

import ru.amse.sd.mvc.onetomany.DataChangedListener;
import ru.amse.sd.mvc.onetomany.NotifyingDataArray;

public class BarChartView extends JComponent {

	private static final long serialVersionUID = 7174862746873314457L;
	private static final double SCALE = 30;
	
	private final NotifyingDataArray model;
	private final Collection<Bar> bars = new ArrayList<Bar>();
	private final DataChangedListener dataChangedListener = new DataChangedListener() {
		public void dataChanged() {
			for (int i = bars.size(); i < model.size(); i++) {
				addBar(i);
			}
			repaint();
		}

	};

	private MouseListener mouseListener = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			int index = e.getY() / getBarHeight();
			assert index < model.size();
			int value = (int) (e.getX() / SCALE);
			model.set(index, value);
		}
	};
	
	public BarChartView(NotifyingDataArray model) {
		this.model = model;
		for (int i = 0; i < model.size(); i++) {
			addBar(i);
		}
		model.addDataChangedListener(dataChangedListener);
		addMouseListener(mouseListener);
	}

	private void addBar(int i) {
		Color color = new Color(
				(float) (Math.random()), 
				(float) (Math.random()), 
				(float) (Math.random()));
		bars.add(
				i % 2 == 0 
				? new RectBar(model, i, color) 
				: new RoundRectBar(model, i, color));
	}

	@Override
	public void paint(Graphics g) {
		for (Bar bar : bars) {
			bar.paint(g, getBarHeight(), SCALE);
		}
	}

	private int getBarHeight() {
		return getHeight() / model.size();
	}
}
