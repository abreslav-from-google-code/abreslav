package core;


/**
 * A single class for instances of all types.
 * Provides unified storage for an instance
 * 
 * @author abreslav
 *
 */
public final class Instance {
	
	/**
	 * Primitive types are the types having only one immutable field 
	 * represented by an object of this class
	 * @author abreslav
	 *
	 * @param <T> - a type of Java representation of the field's value
	 */
	public static final class DataField<T> {

		@SuppressWarnings("unchecked")
		public T readValue(Instance thiz) {
			return (T) thiz.data;
		}
	}

	private final Object data;
	
	private final IType type;

	/**
	 * Creates an instance of a primitive type
	 * @param type - the primitive type object
	 * @param data - value of the default field (might be converted by the type)
	 */
	/*package*/ Instance(IType type, Object data) {
		assert type != null;
		assert data != null;
		
		this.type = type;
		this.data = data;
	}

	/**
	 * @return intance's type
	 */
	public IType getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data.hashCode();
		result = prime * result + type.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		final Instance other = (Instance) obj;
		
		if (type != other.type) {
			return false;
		}
		return data.equals(other.data);
	}

	
}
