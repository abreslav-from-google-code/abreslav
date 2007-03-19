/**
 * 
 */
package ru.ifmo.rain.astrans.asttomodel.resolver;

import java.util.Iterator;

import astransast.QualifiedName;

class IterableClassQN extends IterableQN  {

	public IterableClassQN(QualifiedName qn) {
		super(qn);
	}
	
	@Override
	public Iterator<String> iterator() {
		return new QNIterator(getQN()) {
			@Override
			public boolean hasNext() {
				if (getCurrentQN() == null) {
					return false;
				}
				return getCurrentQN().getSubQN() != null;
			}
		};
	}
	
	public String getClassName() {
		return getClassName(getQN());
	}

	private String getClassName(QualifiedName qn) {
		assert qn != null;
		if (qn.getSubQN() == null) { 
			return qn.getName();
		}
		return getClassName(qn.getSubQN());
	}
}