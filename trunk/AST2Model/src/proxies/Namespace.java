package proxies;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import msg.Named;


public class Namespace<T> {
	
	private final Map<String, T> map = new HashMap<String, T>();
	
	public T get(String key) {
		T result = map.get(key);
		if (result != null) {
			return result;
		}
		Object lookup = lookup(key);
		if (lookup != null) {
			T t = createNSObject(lookup);
			map.put(key, t);
			return t;
		}
		T t = createNSObjectWithKey(key);
		if (t != null) {
			map.put(key, t);
		}
		return t;
	}
	
	protected T createNSObjectWithKey(String key) {		
		return null;
	}

	@SuppressWarnings("unchecked")
	protected T createNSObject(Object lookup) {
			return (T) lookup;	
	}

	protected Object lookup(String key) {
		if (getNamedElements() == null) {
			return null;
		}
		for (Iterator iter = getNamedElements().iterator(); iter.hasNext();) {
			Named element = (Named) iter.next();
			if (key.equals(element.getName())) {
				return element;
			}
		}
		return null;
	}

	protected Collection getNamedElements() {
		return null;
	}

	public void put(String key, T value) {
		map.put(key, value);
	}
	
}
