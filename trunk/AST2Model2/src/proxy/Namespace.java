package proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

public class Namespace<K, V extends EObject, P extends Proxy<V>> {
	
	private final Map<K, List<P>> map = new HashMap<K, List<P>>();
	
	public P getAnyway(K key) {
		P result = getExisting(key);
		if (result != null) {
			return result;
		}
		
		return createNew(key);
	}

	public P getExisting(K key) {
		List<P> list = get(key);
		if (list.isEmpty()) {
			return null;
		}		                  
		return list.get(0);
	}
	
	protected P createNew(K key) {
		P result = createElement(key);
		if (result != null) {
			put(key, result);
		}
		return result;
	}
	
	public P add(V element) {
		K key = getKey(element);
		P proxy = getExisting(key);
		if (proxy == null || proxy.pIsResolved()) {
			proxy = createNew(key);               
		}
		proxy.pResolve(element);
		return proxy;
	}

	protected P createElement(K key) {		
		return null;
	}

	protected K getKey(V element) {		
		return null;
	}

	public boolean containsValueForKey(K key) {
		return !get(key).isEmpty();
	}

	private List<P> get(K key) {
		List<P> list = map.get(key);
		if (list == null) {
			list = Collections.emptyList();
		}
		return list;
	}
	
	private void put(K key, P result) {
		List<P> list = map.get(key);
		if (list == null) {
			list = new ArrayList<P>();
			map.put(key, list);
		}
		list.add(result);
	}

}
