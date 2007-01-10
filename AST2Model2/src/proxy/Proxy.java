package proxy;

import org.eclipse.emf.ecore.EObject;


public interface Proxy<T extends EObject> {

	/**
	 * @return the proxy's subject
	 */
	T pSubject();
	
	/**
	 * If the proxy is resolved
	 */
	public boolean pIsResolved();
	
	/**
	 * Marks the proxy as resolved.
	 * @throws IllegalStateException if the proxy is already resolved
	 */
	public void pResolve() throws IllegalStateException;

	/**
	 * Sets the proxy's subject to the specified object and marks the proxy as resolved.
	 * @param subj new subject
	 * @throws IllegalStateException if the proxy is already resolved
	 */
	public void pResolve(T subj) throws IllegalStateException;
	
}
