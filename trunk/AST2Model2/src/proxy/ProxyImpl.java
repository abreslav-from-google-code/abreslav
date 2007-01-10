package proxy;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;

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
		internal = (InternalEObject) subj;
	}
	
	public boolean eIsProxy() {
		return true;// subject.eIsProxy();
	}

	public URI eProxyURI() {
		Resource resource = internal.eResource();
		return resource == null 
			? internal.eProxyURI() 
// TODO: Ugly hack. Works within the single resource only
			: URI.createURI("#" + resource.getURIFragment(internal)); // internal.eProxyURI();
	}

	public EObject eResolveProxy(InternalEObject proxy) {
		return subject; // internal.eResolveProxy(proxy);
	}

	public T pSubject() {
		return subject;
	}

	
}
