package proxy;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * A namespace is a scope to look for EObjects having there keys (names for example).
 * @author Administrator
 *
 * @param <K> key type
 * @param <V> value type
 */
public interface INamespace<K, V extends EObject> {

	/**
	 * Returns an object (possibly a {@link proxy.Proxy Proxy}) with given key value.
	 * An object is returned whenever it was created before, resolved or not. 
	 * In other words - anyway. 
	 * @param key the key value specified for the object
	 * @return An object with the specified key vallue. Returned value cannot be null
	 */
	public abstract V getAnyway(K key);

	/**
	 * Returns an object with the specified key value.
	 * An object is returned only if it was created before by calling 
	 * {@link #add() add()} or {@link #getAnyway(Object) getAnyway()}.
	 * @param key the key value specified for the object
	 * @return An object if it was created before, null otherwise
	 */
	public abstract V getExisting(K key);

	/**
	 * Returns all the objects with the specified key value created by calling 
	 * {@link #add() add()} or {@link #getAnyway(Object) getAnyway()}.
	 * @param key the key value specified for objects
	 * @return A (possibly empty) List of existing objects
	 */
	public abstract List<V> getAll(K key);

	/**
	 * Adds an object. The object must be previously created by the caller.
	 * If there's an unresolved proxy with such a key value, it would be resolved 
	 * with the given object.
	 * @param element the object to be added
	 * @return The view of the object. This means an object that might be used on the same reasons as 
	 * as the given object. Possibly it is a resolved proxy.
	 */
	public abstract V add(V element);

}