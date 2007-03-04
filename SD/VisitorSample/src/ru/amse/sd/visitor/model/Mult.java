package ru.amse.sd.visitor.model;

public class Mult extends BinaryOperation {

	public Mult(Value x, Value y) {
		super(x, y);
	}

	public <R, D> R accept(ValueVisitor<R, D> visitor, D data) {
		return visitor.visit(this, data);
	}

	@Override
	protected Integer calculateValue() {
		return getX().getValue() + getY().getValue();
	}
	
}
