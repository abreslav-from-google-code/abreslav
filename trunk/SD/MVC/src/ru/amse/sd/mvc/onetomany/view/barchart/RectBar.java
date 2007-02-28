package ru.amse.sd.mvc.onetomany.view.barchart;

import java.awt.Color;
import java.awt.Graphics;

import ru.amse.sd.mvc.onetoone.DataArray;

/*package*/ class RectBar extends Bar {

	public RectBar(DataArray data, int index, Color color) {
		super(data, index, color);
	}

	@Override
	void paint(Graphics g, int width, double scale) {
		int left = width * getIndex();
		int height = (int) (getData().get(getIndex()) * scale);
		g.setColor(getColor());
		g.fillRect(left, 0, width, height);
	}

}
