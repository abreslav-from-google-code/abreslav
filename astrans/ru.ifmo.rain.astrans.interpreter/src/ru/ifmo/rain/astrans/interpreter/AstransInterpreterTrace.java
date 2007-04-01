/**
 * 
 */
package ru.ifmo.rain.astrans.interpreter;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;

import astrans.CreateClass;

class AstransInterpreterTrace {
	private final Map<EClass, EClass> mapTrace = new HashMap<EClass, EClass>();
	private final Map<CreateClass, EClass> createActionTrace = new HashMap<CreateClass, EClass>();
	
	public void registerMappedClass(EClass proto, EClass image) {
		mapTrace.put(proto, image);
	}
	
	public EClass getMappedClass(EClass proto) {
		return mapTrace.get(proto);
	}
	
	public void registerCreatedClass(CreateClass action, EClass result) {
		createActionTrace.put(action, result);
	}
		
	public EClass getCreatedClass(CreateClass action) {
		return createActionTrace.get(action);
	}
}