/**
 * 
 */
package ru.ifmo.rain.astrans.asttomodel.bootstrap.impl;

import java.util.Iterator;

import astransast.QualifiedName;

class IterableQN implements Iterable<String> {
	protected class QNIterator implements Iterator<String> {
		private QualifiedName currentQN;

		public QNIterator(QualifiedName qn) {
			currentQN = qn;
		}
		
		public boolean hasNext() {
			return currentQN != null;
		}

		public String next() {
			String result = currentQN.getName();
			currentQN = currentQN.getSubQN();						
			return result;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		protected QualifiedName getCurrentQN() {
			return currentQN;
		}
	}

	private final QualifiedName qn;
	
	public IterableQN(final QualifiedName qn) {
		this.qn = qn;
	}

	public Iterator<String> iterator() {
		return new QNIterator(qn);
	}
	
	protected QualifiedName getQN() {
		return qn;
	}
}