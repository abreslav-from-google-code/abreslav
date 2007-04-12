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

import trace.AttributeMapping;
import trace.ClassMapping;
import trace.ReferenceMapping;
import trace.ReferenceMappingType;
import trace.Trace;
import trace.TraceFactory;
import astrans.CreateClass;

public class AstransInterpreterTrace {
	private final Map<EClass, EClass> mapTrace = new HashMap<EClass, EClass>();
	private final Map<CreateClass, EClass> createActionTrace = new HashMap<CreateClass, EClass>();
	private final Map<EAttribute, EAttribute> attributeTrace = new HashMap<EAttribute, EAttribute>();
	private final Map<EReference, EStructuralFeature> referenceTrace = new HashMap<EReference, EStructuralFeature>();
	
	private final Trace trace;
	
	public AstransInterpreterTrace(final Trace trace) {
		this.trace = trace;
	}

	public void registerMappedClass(EClass proto, EClass image) {
		mapTrace.put(proto, image);
		
		ClassMapping mapping = TraceFactory.eINSTANCE.createClassMapping(proto, image);
		trace.getClassMappings().add(mapping);
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
	
	public void registerAttribute(EAttribute proto, EAttribute image) {
		attributeTrace.put(proto, image);
		
		AttributeMapping mapping = TraceFactory.eINSTANCE.createAttributeMapping(proto, image);
		trace.getAttributeMappings().add(mapping);
	}
	
	public EAttribute getCorrespondingAttribute(EAttribute proto) {
		return attributeTrace.get(proto);
	}

	public void registerReference(EReference proto, EStructuralFeature image, ReferenceMappingType mappingType) {
		referenceTrace.put(proto, image);
		
		ReferenceMapping mapping = TraceFactory.eINSTANCE.createReferenceMapping(proto, image, mappingType);
		trace.getReferenceMappings().add(mapping);
	}
	
	public EStructuralFeature getCorrespondingFeature(EReference proto) {
		return referenceTrace.get(proto);
	}
}