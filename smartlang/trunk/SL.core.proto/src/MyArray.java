
public class MyArray<T> implements IArray<T> {

	private final T[] array;

	public MyArray(T[] array) {
		this.array = array;
	}

	public T get(int i) {
		return array[i];
	}

	public int length() {
		return array.length;
	}

	public void set(int i, T value) {
		array[i] = value;
	}
}
