package ru.amse.sd.visitor.model;

public interface Value {
	int getValue();
	<R, D> R accept(ValueVisitor<R, D> visitor, D data);
}
