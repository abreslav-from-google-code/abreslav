package ru.ifmo.rain.breslav.deferred;

public abstract class DObject<T> implements Deferred<T> {

	private T value;
	
	public DObject(T v) {
		value = v;
	}
	
	public DObject() {
		this(null);
	}
	
	public final T resolve() throws ResolveFailedException {
		if (!isResolved()) {
			value = doResolve();
			valueResolved(value);
		}
		return value;
	}
	
	protected abstract T doResolve() throws ResolveFailedException;
	
	/*package-private*/ final void resolveNow() {
		try {
			value = doResolve();
		} catch (ResolveFailedException e) {
			throw new RuntimeException("Child element resolve failed", e);
		}
	}

	protected void valueResolved(T v) {
		
	}

	public boolean isResolved() {
		return value != null;
	}
	
	@Override
	public String toString() {
		if (!isResolved()) {
			return "[not resolved]";
		}
		return value == null ? "null" : value.toString();
	}
	
}
