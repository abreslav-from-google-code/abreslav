package ru.amse.sd.mvc.onetoone.view;

/*package*/ class TreeVertex {

	private final int index;
	private double x;
	private double y;
	
	public TreeVertex(int index) {
		this.index = index;
		calculatePosition();
	}
	
	public int getIndex() {
		return index;
	}
	
	private void calculatePosition() {
		int d = 0;
		for (int k = getIndex() + 1; k != 0; k /= 2) {
			d++;
		}
		x = (2 * getIndex() - (1 << d) + 3) * 1.0 / (1 << d);
		y = d - 1;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public int getParentIndex() {
		return getIndex() == 0 ? 0 : (getIndex() + 1) / 2 - 1;
	}
	
	@Override
	public String toString() {
		return "[" + getIndex() + "]";
	}
	
}
