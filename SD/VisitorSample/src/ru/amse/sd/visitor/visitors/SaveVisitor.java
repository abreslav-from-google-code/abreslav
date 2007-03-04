package ru.amse.sd.visitor.visitors;

import java.io.DataOutputStream;
import java.io.IOException;

import ru.amse.sd.visitor.model.Mult;
import ru.amse.sd.visitor.model.Number;
import ru.amse.sd.visitor.model.Sum;
import ru.amse.sd.visitor.model.Value;
import ru.amse.sd.visitor.model.ValueVisitor;

public class SaveVisitor implements ValueVisitor<Void, DataOutputStream> {
	private static final byte SUM_CODE = 0;
	private static final byte MULT_CODE = 1;
	private static final byte NUMBER_CODE = 2;
	
	private static final SaveVisitor INSTANCE = new SaveVisitor();
	
	public static void save(Value value, DataOutputStream stream) {
		value.accept(INSTANCE, stream);
	}

	private SaveVisitor() {		
	}

	public Void visit(Sum value, DataOutputStream data) throws RuntimeException {
		try {
			data.writeByte(SUM_CODE);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		value.getX().accept(this, data);
		value.getY().accept(this, data);
		return null;
	}

	public Void visit(Mult value, DataOutputStream data) {
		try {
			data.writeByte(MULT_CODE);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		value.getX().accept(this, data);
		value.getY().accept(this, data);
		return null;
	}

	public Void visit(Number value, DataOutputStream data) {
		try {
			data.writeByte(NUMBER_CODE);
			data.writeInt(value.getValue());
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		return null;
	}
	
}
