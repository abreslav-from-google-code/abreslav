package ru.ifmo.rain.astrans.interpreter;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;

public class EClassMap<V> {

	private Map<EClass, V> singleClasses = new HashMap<EClass, V>();	
	private Map<EClass, V> classesWithChildren = new HashMap<EClass, V>();
	
	public V get(EClass eClass) {
		V singleClassValue = singleClasses.get(eClass);
		if (singleClassValue != null) {
			return singleClassValue;
		}
		for (Map.Entry<EClass, V> parentEntry : classesWithChildren.entrySet()) {
			if (parentEntry.getKey().isSuperTypeOf(eClass)) {
				singleClasses.put(eClass, parentEntry.getValue());
				return parentEntry.getValue();
			}
		}
		return null;
	}
	
	public void put(EClass eClass, V value, boolean withChildren) {
		singleClasses.put(eClass, value);
		if (withChildren) {
			classesWithChildren.put(eClass, value);
		}
	}
}
