package ru.amse.sd.mvc.onetomany.view.barchart;

import java.awt.Color;
import java.awt.Graphics;

import ru.amse.sd.mvc.onetoone.DataArray;

/*package*/ abstract class Bar {

	private final int index;
	private final DataArray data;
	private Color color;
	
	public Bar(DataArray data, int index, Color color) {
		this.index = index;
		this.data = data;
		this.color = color;
	}
	
	protected int getIndex() {
		return index;
	}
	
	protected DataArray getData() {
		return data;
	}
	
	protected Color getColor() {
		return color;
	}
	
	/*package*/ abstract void paint(Graphics g, int height, double scale);
}
