package ru.ifmo.rain.astrans.interpreter;
import org.eclipse.emf.ecore.EClass;

public class EClassSet {

	private static final Object VALUE = new Object();
	
	private EClassMap<Object> map = new EClassMap<Object>();	
	public boolean contains(EClass eClass) {
		return map.get(eClass) != null;
	}
	
	public void addEClass(EClass eClass, boolean withChildren) {
		map.put(eClass, VALUE, withChildren);
	}
}
