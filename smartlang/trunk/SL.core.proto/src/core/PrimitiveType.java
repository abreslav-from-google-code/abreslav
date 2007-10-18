package core;

public abstract class PrimitiveType<D> extends TypeImpl<D> {

	public FieldDescriptor lookupField(String name) {
		return NoSuch.FIELD;
	}

}
