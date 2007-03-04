package ru.amse.sd.visitor.model;

public class Number implements Value {

	private final int value;
	
		public Number(final int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public <R, D> R accept(ValueVisitor<R, D> visitor, D data) {
		return visitor.visit(this, data);
	}

}
