package proxy;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

public class AmbiguousNamespace<K, V extends EObject> implements INamespace<K, V>{

	private List<INamespace<K, V>> subnamespaces = new ArrayList<INamespace<K,V>>();
	
	public AmbiguousNamespace(INamespace<K, V>... subNS) {
		if (subNS.length == 0) {
			throw new IllegalArgumentException();
		}
		for (INamespace<K, V> namespace : subNS) {
			subnamespaces.add(namespace);
		}
	}
	
	public V add(V element) {
		throw new UnsupportedOperationException();
	}

	public List<V> getAll(K key) {
		throw new UnsupportedOperationException();
	}

	private INamespace<K, V> getFirstNS() {
		return subnamespaces.get(0);
	}	
	
	public V getAnyway(K key) {
		V result = getFirstNS().getExisting(key);
		if (result != null) {
			return result;
		}		                     
		
		return result;
	}

	public V getExisting(K key) {
		for (int i = 0; i < subnamespaces.size(); i++) {
			V result = subnamespaces.get(i).getExisting(key);
			if (result != null) {
				return result;
			}
		}
		return null;
	}
}
