package ru.ifmo.rain.astrans.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

public class EMFComparator {
	/* Most part of the code is stollen from EqualityHelper from EcoreUtil */

	public static Diagnostic comapre(EObject o1, EObject o2) {
		EMFComparator comparator = new EMFComparator();
		return comparator.equals(o1, o2);		
	}
	
	public static class Diagnostic {
		
		public static final Diagnostic SUCCESS = new Diagnostic(true, null, null, null) {
			@Override
			public String toString() {
				return "SUCCESS";				
			}
		};
		
		public static Diagnostic getInstance(final boolean equals, final Location location, final Object object1, final Object object2) {
			if (equals) {
				return SUCCESS;
			}
			return new Diagnostic(equals, location, object1, object2);
		}
		
		private final boolean equals;
		private final Location location;
		private final Object object1;
		private final Object object2;
		
		private Diagnostic(final boolean equals, final Location location, final Object object1, final Object object2) {
			this.equals = equals;
			this.location = location;
			this.object1 = object1;
			this.object2 = object2;
		}
		
		public Object getObject1() {
			return object1;
		}

		public Object getObject2() {
			return object2;
		}

		public boolean areEqual() {
			return equals;
		}

		public Location getLocation() {
			return location;
		}
		
		@Override
		public String toString() {
			return "Objects " + object1 + " and " + object2 + " are not same as: " + location;
		}
	}
	
	public interface Location {		
	}
	
	private static enum CommonLocations implements Location {
		VALUE("Objects differ"), 
		VALUES("The same object is mapped to two or more different objects"), 
		CLASS("Classes differ"),
		LIST_LENGTH("List lengths differ"),
		DIFFERENT_FEATURES("Features in feature map differ");
		
		private final String comment;

		private CommonLocations(final String comment) {
			this.comment = comment;
		}
		
		@Override
		public String toString() {
			return comment;
		}
	}
	
	private static final class FeatureLocation implements Location {
		private final EStructuralFeature feature;

		private FeatureLocation(final EStructuralFeature feature) {
			super();
			this.feature = feature;
		}
		
		@Override
		public String toString() {
			return "Value of " + ((EClass) feature.eContainer()).getName() + "::" + feature.getName() + " differs";
		}
	}
	
	private final Map<EObject, EObject> map = new HashMap<EObject, EObject>();
	
	public Diagnostic equals(EObject eObject1, EObject eObject2) {
		// If the first object is null, the second object must be null.
		//
		if (eObject1 == null) {
			return Diagnostic.getInstance(eObject2 == null, CommonLocations.VALUE, eObject1, eObject2);
		}

		// We know the first object isn't null, so if the second one is, it
		// can't be equal.
		//
		if (eObject2 == null) {
			return Diagnostic.getInstance(false, CommonLocations.VALUE, eObject1, eObject2);
		}

		// Both eObject1 and eObject2 are not null.
		// If eObject1 has been compared already...
		//
		Object eObject1MappedValue = map.get(eObject1);
		if (eObject1MappedValue != null) {
			// Then eObject2 must be that previous match.
			//
			return Diagnostic.getInstance(eObject1MappedValue == eObject2, CommonLocations.VALUES, eObject1, eObject2);
		}

		// If eObject2 has been compared already...
		//
		Object eObject2MappedValue = map.get(eObject2);
		if (eObject2MappedValue != null) {
			// Then eObject1 must be that match.
			//
			return Diagnostic.getInstance(eObject2MappedValue == eObject1, CommonLocations.VALUES, eObject1, eObject2);
		}

		// Neither eObject1 nor eObject2 have been compared yet.

		// If eObject1 and eObject2 are the same instance...
		//
		if (eObject1 == eObject2) {
			// Match them and return true.
			//
			map.put(eObject1, eObject2);
			map.put(eObject2, eObject1);
			return Diagnostic.SUCCESS;
		}

		// If they don't have the same class, they can't be equal.
		//
		EClass eClass = eObject1.eClass();
		if (eClass != eObject2.eClass()) {
			return Diagnostic.getInstance(false, CommonLocations.CLASS, eObject1, eObject2);
		}

		// Assume from now on that they match.
		//
		map.put(eObject1, eObject2);
		map.put(eObject2, eObject1);

		// Check all the values.
		//
		for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i) {
			// Ignore derived features.
			//
			EStructuralFeature feature = eClass.getEStructuralFeature(i);
			if (!feature.isDerived()) {
				Diagnostic haveEqualFeature = haveEqualFeature(eObject1, eObject2, feature);
				if (haveEqualFeature != Diagnostic.SUCCESS) {
					return haveEqualFeature;
				}
			}
		}

		// There's no reason they aren't equal, so they are.
		//
		return Diagnostic.SUCCESS;
	}

	public Diagnostic equals(List list1, List list2) {
		int size = list1.size();
		if (size != list2.size()) {
			return Diagnostic.getInstance(false, CommonLocations.LIST_LENGTH, list1, list2);
		}

		for (int i = 0; i < size; i++) {
			EObject eObject1 = (EObject) list1.get(i);
			EObject eObject2 = (EObject) list2.get(i);
			Diagnostic equals = equals(eObject1, eObject2);
			if (equals != Diagnostic.SUCCESS) {
				return equals;
			}
		}

		return Diagnostic.SUCCESS;
	}

	protected Diagnostic haveEqualFeature(EObject eObject1, EObject eObject2,
			EStructuralFeature feature) {
		// If the set states are the same, and the values of the feature are the
		// structurally equal, they are equal.
		//
		if (eObject1.eIsSet(feature) != eObject2.eIsSet(feature)) {
			return Diagnostic.getInstance(false, new FeatureLocation(feature), eObject1, eObject2);
		}
		return (feature instanceof EReference ? haveEqualReference(
						eObject1, eObject2, (EReference) feature)
						: haveEqualAttribute(eObject1, eObject2,
								(EAttribute) feature));
	}

	protected Diagnostic haveEqualReference(EObject eObject1, EObject eObject2,
			EReference reference) {
		Object value1 = eObject1.eGet(reference);
		Object value2 = eObject2.eGet(reference);

		return reference.isMany() ? equals((List) value1, (List) value2)
				: equals((EObject) value1, (EObject) value2);
	}

	protected Diagnostic haveEqualAttribute(EObject eObject1, EObject eObject2,
			EAttribute attribute) {
		Object value1 = eObject1.eGet(attribute);
		Object value2 = eObject2.eGet(attribute);

		// If the first value is null, the second value must be null.
		//
		if (value1 == null) {
			return Diagnostic.getInstance(value2 == null, new FeatureLocation(attribute), eObject1, eObject2);
		}

		// Since the first value isn't null, if the second one is, they aren't
		// equal.
		//
		if (value2 == null) {
			return Diagnostic.getInstance(false, new FeatureLocation(attribute), eObject1, eObject2);
		}

		// If this is a feature map...
		//
		if (FeatureMapUtil.isFeatureMap(attribute)) {
			// The feature maps must be equal.
			//
			FeatureMap featureMap1 = (FeatureMap) value1;
			FeatureMap featureMap2 = (FeatureMap) value2;
			return equalFeatureMaps(featureMap1, featureMap2);
		} else {
			// The values must be Java equal.
			//
			return Diagnostic.getInstance(value1.equals(value2), new FeatureLocation(attribute), eObject1, eObject2);
		}
	}

	protected Diagnostic equalFeatureMaps(FeatureMap featureMap1,
			FeatureMap featureMap2) {
		// If they don't have the same size, the feature maps aren't equal.
		//
		int size = featureMap1.size();
		if (size != featureMap2.size()) {
			return Diagnostic.getInstance(false, CommonLocations.LIST_LENGTH, featureMap1, featureMap2);
		}

		// Compare entries in order.
		//
		for (int i = 0; i < size; i++) {
			// If entries don't have the same feature, the feature maps aren't
			// equal.
			//
			EStructuralFeature feature = featureMap1.getEStructuralFeature(i);
			if (feature != featureMap2.getEStructuralFeature(i)) {
				return Diagnostic.getInstance(false, CommonLocations.DIFFERENT_FEATURES, feature, featureMap2.getEStructuralFeature(i));
			}

			Object value1 = featureMap1.getValue(i);
			Object value2 = featureMap2.getValue(i);

			Diagnostic equalFeatureMapValues = equalFeatureMapValues(value1, value2, feature);
			if (equalFeatureMapValues != Diagnostic.SUCCESS) {
				return equalFeatureMapValues;
			}
		}

		// There is no reason they aren't equals.
		//
		return Diagnostic.SUCCESS;
	}

	protected Diagnostic equalFeatureMapValues(Object value1, Object value2,
			EStructuralFeature feature) {
		if (feature instanceof EReference) {
			// If the referenced EObjects aren't equal, the feature maps aren't
			// equal.
			//
			return equals((EObject) value1, (EObject) value2);
		} else {
			// If the values aren't Java equal, the feature maps aren't equal.
			//
			return Diagnostic.getInstance(value1 == null ? value2 == null : value1.equals(value2), new FeatureLocation(feature), value1, value2);
		}
	}

}
