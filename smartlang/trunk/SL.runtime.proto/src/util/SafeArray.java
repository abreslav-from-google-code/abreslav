package util;

public final class SafeArray<T> implements IArray<T> {

	private final T[] myArray;
	
	public SafeArray(T[] array) {
		myArray = array;
	}

	public T get(int index) throws ArrayIndexOutOfBoundsException {
		return myArray[index];
	}

	public int size() {
		return myArray.length;
	}

}
