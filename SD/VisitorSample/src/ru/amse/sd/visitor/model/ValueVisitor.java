package ru.amse.sd.visitor.model;

public interface ValueVisitor<R, D> {
	R visit(Sum value, D data);
	R visit(Mult value, D data);
	R visit(Number value, D data);
}
