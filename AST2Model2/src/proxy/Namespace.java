package proxy;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

public abstract class Namespace<K, V extends EObject> implements INamespace<K, V> {
	
	private List<V> list;
	
	public Namespace(List<V> list) {
		this.list = list;
	}
	
	@SuppressWarnings("unchecked")
	public void setList(List list) {
		this.list = list;
	}
	
	public List getList() {
		return list;
	}
	
	public V getAnyway(K key) {
		V result = getExisting(key);
		if (result != null) {
			return result;
		}
		
		return createNew(key);
	}

	public V getExisting(K key) {
		for (int i = 0; i < list.size(); i++) {
			K itemKey = getKey(list.get(i));
			if (itemKey.equals(key)) {
				return list.get(i);
			}
		}
		return null;
	}
	
	protected V createNew(K key) {
		V result = createElement(key);
		if (result != null) {
			list.add(result);
		}
		return result;
	}
	
	public List<V> getAll(K key) {
		List<V> result = new ArrayList<V>();
		for (int i = 0; i < list.size(); i++) {
			K itemKey = getKey(list.get(i));
			if (itemKey.equals(key)) {
				result.add(list.get(i));
			}
		}
		return result;
	}
	
	public V add(V element) {
		K key = getKey(element);
		List<V> all = getAll(key);
		for (V v : all) {
			if (v instanceof Proxy) {
				@SuppressWarnings("unchecked")
				Proxy<V> proxy = (Proxy) v;
				
				if (!proxy.pIsResolved()) {
					proxy.pResolve(element);
					list.add(element);
					
					@SuppressWarnings("unchecked")
					V result = (V) proxy;
					return result;
				}
			}
		}
		list.add(element);
		return element;               
	}

	protected abstract V createElement(K key);

	protected abstract K getKey(V element);

}
