/**
 * 
 */
package ru.ifmo.rain.astrans.interpreter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import astrans.CreateClass;

public class AstransInterpreterTrace {
	private final Map<EClass, EClass> mapTrace = new HashMap<EClass, EClass>();
	private final Map<CreateClass, EClass> createActionTrace = new HashMap<CreateClass, EClass>();
	private final Map<EAttribute, EAttribute> attributeTrace = new HashMap<EAttribute, EAttribute>();
	private final Map<EReference, EStructuralFeature> referenceTrace = new HashMap<EReference, EStructuralFeature>();
	
	public void registerMappedClass(EClass proto, EClass image) {
		mapTrace.put(proto, image);
	}
	
	public EClass getMappedClass(EClass proto) {
		return mapTrace.get(proto);
	}
	
	public Set<Map.Entry<EClass, EClass>> getMappings() {
		return Collections.unmodifiableSet(mapTrace.entrySet());
	}
	
	public void registerCreatedClass(CreateClass action, EClass result) {
		createActionTrace.put(action, result);
	}
		
	public EClass getCreatedClass(CreateClass action) {
		return createActionTrace.get(action);
	}
	
	public void registerAttribute(EAttribute source, EAttribute dest) {
		attributeTrace.put(source, dest);
	}
	
	public EAttribute getCorrespondingAttribute(EAttribute source) {
		return attributeTrace.get(source);
	}

	public void registerReference(EReference source, EStructuralFeature dest) {
		referenceTrace.put(source, dest);
	}
	
	public EStructuralFeature getCorrespondingFeature(EReference source) {
		return referenceTrace.get(source);
	}
}