package composite;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public aspect CompositeAspect {

	private List<T> Composite<T>.children = new ArrayList<T>();

	public Iterator<T> Composite<T>.iterator() {
		return children.iterator();
	}

	public boolean Composite<T>.hasChildren() {
		return !children.isEmpty();
	}

	public void Composite<T>.addChild(T child) {
		children.add(child);
	}
}
