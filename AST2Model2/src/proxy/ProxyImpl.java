package proxy;

import org.eclipse.emf.ecore.EObject;

public class ProxyImpl<T extends EObject> extends DelegatingEObject<T> implements Proxy<T> {

	private boolean resolved;

	public ProxyImpl(T subject) {
		super(subject);
	}

	public boolean pIsResolved() {
		return resolved;
	}

	public void pResolve() {
		if (pIsResolved()) {
			throw new IllegalStateException();
		}
		resolved = true;
	}

	public void pResolve(T subj) {
		pResolve();
		subject = subj;
	}
}
