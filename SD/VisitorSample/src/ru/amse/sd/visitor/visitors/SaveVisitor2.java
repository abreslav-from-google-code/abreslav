package ru.amse.sd.visitor.visitors;

import java.io.DataOutputStream;
import java.io.IOException;

import ru.amse.sd.visitor.model.BinaryOperation;
import ru.amse.sd.visitor.model.Mult;
import ru.amse.sd.visitor.model.Number;
import ru.amse.sd.visitor.model.Sum;
import ru.amse.sd.visitor.model.Value;
import ru.amse.sd.visitor.model.ValueVisitor;

public class SaveVisitor2 implements ValueVisitor<Void, DataOutputStream> {
	
	private final ValueVisitor<Byte, Void> codeVisitor = new ValueVisitor<Byte, Void>() {

		public Byte visit(Sum value, Void data) {
			return ValueCodes.SUM_CODE;
		}

		public Byte visit(Mult value, Void data) {
			return ValueCodes.MULT_CODE;
		}

		public Byte visit(Number value, Void data) {
			throw new UnsupportedOperationException();
		}
		
	};
	
	private static final SaveVisitor2 INSTANCE = new SaveVisitor2();
	
	public static void save(Value value, DataOutputStream stream) {
		value.accept(INSTANCE, stream);
	}

	private SaveVisitor2() {		
	}

	public Void visit(Sum value, DataOutputStream data) throws RuntimeException {
		saveBinaryOperation(value, data);
		return null;
	}

	public Void visit(Mult value, DataOutputStream data) {
		saveBinaryOperation(value, data);
		return null;
	}

	private void saveBinaryOperation(BinaryOperation value, DataOutputStream data) {
		try {
			data.writeByte(value.accept(codeVisitor, null));
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		value.getX().accept(this, data);
		value.getY().accept(this, data);
	}

	public Void visit(Number value, DataOutputStream data) {
		try {
			data.writeInt(ValueCodes.NUMBER_CODE);
			data.writeInt(value.getValue());
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		return null;
	}
	
}
