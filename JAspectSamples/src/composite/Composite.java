package composite;


public interface Composite<T> extends Iterable<T> {
	boolean hasChildren();
	void addChild(T child);
}
