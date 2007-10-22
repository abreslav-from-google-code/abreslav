package core;

public abstract class PrimitiveType<D> extends TypeImpl<D> {

	public IField lookupField(String name) {
		return NoSuch.FIELD;
	}

}
