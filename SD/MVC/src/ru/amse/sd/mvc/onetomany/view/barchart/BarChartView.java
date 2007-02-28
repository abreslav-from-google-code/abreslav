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
	private static final double SCALE = 5;
	
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
			int index = e.getX() / getBarWidth();
			assert index >= 0;
			int value = (int) (e.getY() / SCALE);
			if (index >= model.size()) { 
			    model.add(value);                        
			} else {
				model.set(index, value);
			}
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
			bar.paint(g, getBarWidth(), SCALE);
		}
	}

	private int getBarWidth() {
		return getWidth() / (model.size() + 1);
	}
}
