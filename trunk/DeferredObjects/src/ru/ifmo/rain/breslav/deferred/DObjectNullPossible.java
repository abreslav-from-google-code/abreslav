package ru.ifmo.rain.breslav.deferred;

public abstract class DObjectNullPossible<T> extends DObject<T> {

	private boolean resolved;
	
	public DObjectNullPossible(T v, boolean r) {
		super(v);
		resolved = r;
	}

	public DObjectNullPossible(T v) {
		super(v);
		resolved = v != null;
	}

	public DObjectNullPossible() {
		super();
		resolved = false;
	}
	
	protected void setResolved(boolean resolved) {
		this.resolved = resolved;
	}

	@Override
	public boolean isResolved() {
		return resolved;
	}
}
