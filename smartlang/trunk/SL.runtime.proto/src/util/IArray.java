package util;

public interface IArray<T> {
	T get(int index) throws ArrayIndexOutOfBoundsException;
	int size();
}
