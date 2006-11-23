package ru.ifmo.rain.breslav.deferred;

import java.util.Collection;
import java.util.HashSet;

public abstract class DComposite<T> extends DObject<T> {

	private final Collection<DObject<?>> children = new HashSet<DObject<?>>();
	
	protected void addChild(DObject<?> child) {
		children.add(child);
	}
	
	@Override
	protected void valueResolved(T v) {
		for (DObject<?> child : children) {
			resolveChild(child);
		}
	}

	protected void resolveChild(DObject<?> child) {
		child.resolveNow();
	}
}
