package ru.amse.sd.visitor.visitors;

import java.io.DataInputStream;
import java.io.IOException;

import ru.amse.sd.visitor.model.Mult;
import ru.amse.sd.visitor.model.Number;
import ru.amse.sd.visitor.model.Sum;
import ru.amse.sd.visitor.model.Value;

public class Loader {

	public static Value readValue(DataInputStream stream) throws IOException {
		byte b = stream.readByte();
		switch (b) {
		case ValueCodes.NUMBER_CODE:
			return readNumber(stream);
		case ValueCodes.SUM_CODE:
			return readSum(stream);
		case ValueCodes.MULT_CODE:
			return readMult(stream);
		default:
			throw new IllegalStateException();
		}
	}

	private static Value readMult(DataInputStream stream) throws IOException {
		Value x = readValue(stream);
		Value y = readValue(stream);
		return new Mult(x, y);
	}

	private static Value readSum(DataInputStream stream) throws IOException {
		Value x = readValue(stream);
		Value y = readValue(stream);
		return new Sum(x, y);
	}

	private static Value readNumber(DataInputStream stream) throws IOException {
		return new Number(stream.readInt());
	}

}
