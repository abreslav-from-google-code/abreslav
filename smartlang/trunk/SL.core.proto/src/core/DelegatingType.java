package core;



public class DelegatingType<D, T extends IType> implements IType {

	protected final T delegate;
	
	public DelegatingType(T delegate) {
		this.delegate = delegate;
	}

	public Instance getDefaultValue() {
		return delegate.getDefaultValue();
	}

	public IField lookupField(String name) {
		return delegate.lookupField(name);
	}

	public IMethod lookupMethod(String name) {
		return delegate.lookupMethod(name);
	}

	public boolean conformsTo(IType other) {
		return (other == this) || (delegate.conformsTo(other));
	}

	public IType getSupertype() {
		return delegate;
	}

	public IFunction getCastFrom(IType type) {
		return delegate.getCastFrom(type);
	}

	@SuppressWarnings("unchecked")
	@Deprecated
	public final Instance create(Object data) {
		return createInstance((D) data);
	}

	public Instance createInstance(D value) {
		return delegate.create(value);
	}
}
