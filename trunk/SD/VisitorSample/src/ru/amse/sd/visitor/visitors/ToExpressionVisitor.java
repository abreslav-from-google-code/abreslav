package ru.amse.sd.visitor.visitors;

import ru.amse.sd.visitor.model.Mult;
import ru.amse.sd.visitor.model.Number;
import ru.amse.sd.visitor.model.Sum;
import ru.amse.sd.visitor.model.Value;
import ru.amse.sd.visitor.model.ValueVisitor;

public class ToExpressionVisitor implements ValueVisitor<String, Void> {

	public static final ToExpressionVisitor INSTANCE = new ToExpressionVisitor();
	
	private ToExpressionVisitor() {		
	}
	
	public String visit(Sum value, Void data) {
		return "(" + dispatch(value.getX()) + "+" + dispatch(value.getY()) + ")";
	}

	public String visit(Mult value, Void data) {
		return "(" + dispatch(value.getX()) + "*" + dispatch(value.getY()) + ")";
	}

	public String visit(Number value, Void data) {
		return value.getValue() + "";
	}

	public String dispatch(Value value) {
		return value.accept(this, null);
	}
}
