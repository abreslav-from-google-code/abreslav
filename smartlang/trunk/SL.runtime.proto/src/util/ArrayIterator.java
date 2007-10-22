package util;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {

	private final T[] myArray;
	private int myNextIndex = 0;
	
	public ArrayIterator(T[] array) {
		myArray = array;
	}
	
	public boolean hasNext() {
		return myNextIndex < myArray.length;
	}

	public T next() {
		return myArray[myNextIndex++];
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

}
