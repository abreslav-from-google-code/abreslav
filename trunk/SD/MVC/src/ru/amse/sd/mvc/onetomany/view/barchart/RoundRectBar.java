package ru.amse.sd.mvc.onetomany.view.barchart;

import java.awt.Color;
import java.awt.Graphics;

import ru.amse.sd.mvc.onetoone.DataArray;

/*package*/ class RoundRectBar extends Bar {

	public RoundRectBar(DataArray data, int index, Color color) {
		super(data, index, color);
	}

	@Override
	void paint(Graphics g, int height, double scale) {
		int top = height * getIndex();
		int width = (int) (getData().get(getIndex()) * scale);
		g.setColor(getColor());
		g.fillRoundRect(0, top, width, height, 30, 30);
	}

}
