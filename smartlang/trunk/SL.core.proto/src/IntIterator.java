
public class IntIterator implements IIntIterator {

	private int v;
	
	public int get() {
		return v;
	}

	public void inc() {
		v++;
	}

	public boolean isLessThan(int i) {
		return v < i;
	}

	public void set(int value) {
		v = value;
	}

}
