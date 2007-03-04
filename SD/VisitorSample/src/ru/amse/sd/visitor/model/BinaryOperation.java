package ru.amse.sd.visitor.model;

public abstract class BinaryOperation implements Value {

	private final Value x;
	private final Value y;
	private Integer valueCache = null; 

	public BinaryOperation(final Value x, final Value y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Value getX() {
		return x;
	}
	
	public Value getY() {
		return y;
	}
	
	protected void setValueCache(int value) {
		valueCache = value;
	}
	
	public final int getValue() {
		if (valueCache == null) {
			valueCache = calculateValue();
		}
		return valueCache;
	}

	protected abstract Integer calculateValue();
}
