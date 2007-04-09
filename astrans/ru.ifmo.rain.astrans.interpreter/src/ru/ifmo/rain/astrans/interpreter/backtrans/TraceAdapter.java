package ru.ifmo.rain.astrans.interpreter.backtrans;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;

import trace.AttributeMapping;
import trace.ClassMapping;
import trace.ReferenceMapping;
import trace.Trace;

public class TraceAdapter {

	private final Collection<ClassMapping> classMappings;
	private final Map<EAttribute, AttributeMapping> attributeMappings;
	private final Map<EReference, ReferenceMapping> referenceMappings;
	
	public TraceAdapter(Trace trace) {
		classMappings = Collections.<ClassMapping>unmodifiableCollection(trace.getClassMappings());
		
		Map<EAttribute, AttributeMapping> attrMap = new HashMap<EAttribute, AttributeMapping>();
		for (Iterator iter = trace.getAttributeMappings().iterator(); iter.hasNext();) {
			AttributeMapping mapping = (AttributeMapping) iter.next();
			attrMap.put(mapping.getProto(), mapping);
		}
		attributeMappings = Collections.unmodifiableMap(attrMap);
		
		Map<EReference, ReferenceMapping> refMap = new HashMap<EReference, ReferenceMapping>();
		for (Iterator iter = trace.getReferenceMappings().iterator(); iter.hasNext();) {
			ReferenceMapping mapping = (ReferenceMapping) iter.next();
			refMap.put(mapping.getProto(), mapping);
		}
		referenceMappings = Collections.unmodifiableMap(refMap);
		
	}
	
	public Collection<ClassMapping> getClassMappings() {
		return classMappings;
	}
	
	public AttributeMapping getAttributeMapping(EAttribute attribute) {
		return attributeMappings.get(attribute);
	}
	
	public ReferenceMapping getReferenceMapping(EReference reference) {
		return referenceMappings.get(reference);
	}
}
