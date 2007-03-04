package ru.amse.sd.visitor.visitors;

import ru.amse.sd.visitor.model.Mult;
import ru.amse.sd.visitor.model.Number;
import ru.amse.sd.visitor.model.Sum;
import ru.amse.sd.visitor.model.Value;
import ru.amse.sd.visitor.model.ValueVisitor;

public class ToRPNVisitor implements ValueVisitor<String, Void> {

	public static final ToRPNVisitor INSTANCE = new ToRPNVisitor();
	
	private ToRPNVisitor() {		
	}
	
	public String visit(Sum value, Void data) {
		return "+ " + dispatch(value.getX()) + " " + dispatch(value.getY());
	}

	public String visit(Mult value, Void data) {
		return "* " + dispatch(value.getX()) + " " + dispatch(value.getY());
	}

	public String visit(Number value, Void data) {
		return value.getValue() + "";
	}

	public static String dispatch(Value value) {
		return value.accept(INSTANCE, null);
	}
}
