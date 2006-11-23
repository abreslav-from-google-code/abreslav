package ru.ifmo.rain.breslav.deferred;

/**
 * Nulls accepted
 * Resolve is always posiible
 * No assignment is valid after resolve 
 */
public class DArray<T> extends DComposite<T[]> {
	
	private final class DElement extends DObjectNullPossible<T> {

		private final int index;
		
		public DElement(int i) {
			index = i;
		}

		@Override
		protected T doResolve() throws ResolveFailedException {
			if (!DArray.this.isResolved()) {
				throw new ResolveFailedException();
			}
			setResolved(true);
			return array[index];
		}
		
	}

	private final T[] array;
	private final DObjectNullPossible<T>[] deferredArray;
	
	@SuppressWarnings("unchecked")
	public DArray(T[] data) {
		array = data.clone();
		deferredArray = new DObjectNullPossible[data.length];
	}
	
	@Override
	protected T[] doResolve() throws ResolveFailedException {
		return array;
	}
	
	public DObjectNullPossible<T> get(int index) {
		if (deferredArray[index] == null) {
			deferredArray[index] = new DElement(index);
		}
		addChild(deferredArray[index]);
		return deferredArray[index];
	}
	
	public void set(int index, T value) {
		if (isResolved()) {
			throw new IllegalStateException("Assignment after resolve");
		}
		array[index] = value;
	}
	
	public int length() {
		return array.length;
	}

}
