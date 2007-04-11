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

	public static Difference compare(EObject o1, EObject o2) {
		EMFComparator comparator = new EMFComparator();
		return comparator.compareEObjects(o1, o2);		
	}
	
	private final Map<EObject, EObject> map = new HashMap<EObject, EObject>();
	
	private Difference compareEObjects(EObject eObject1, EObject eObject2) {
		// If the first object is null, the second object must be null.
		//
		if (eObject1 == null) {
			return Difference.getInstance(eObject2 == null, CommonLocations.VALUE, eObject1, eObject2);
		}

		// We know the first object isn't null, so if the second one is, it
		// can't be equal.
		//
		if (eObject2 == null) {
			return Difference.getInstance(false, CommonLocations.VALUE, eObject1, eObject2);
		}

		// Both eObject1 and eObject2 are not null.
		// If eObject1 has been compared already...
		//
		Object eObject1MappedValue = map.get(eObject1);
		if (eObject1MappedValue != null) {
			// Then eObject2 must be that previous match.
			//
			return Difference.getInstance(eObject1MappedValue == eObject2, CommonLocations.VALUES, eObject1, eObject2);
		}

		// If eObject2 has been compared already...
		//
		Object eObject2MappedValue = map.get(eObject2);
		if (eObject2MappedValue != null) {
			// Then eObject1 must be that match.
			//
			return Difference.getInstance(eObject2MappedValue == eObject1, CommonLocations.VALUES, eObject1, eObject2);
		}

		// Neither eObject1 nor eObject2 have been compared yet.

		// If eObject1 and eObject2 are the same instance...
		//
		if (eObject1 == eObject2) {
			// Match them and return true.
			//
			map.put(eObject1, eObject2);
			map.put(eObject2, eObject1);
			return Difference.NO_DIFFERENCE;
		}

		// If they don't have the same class, they can't be equal.
		//
		EClass eClass = eObject1.eClass();
		if (eClass != eObject2.eClass()) {
			return Difference.getInstance(false, CommonLocations.CLASS, eObject1, eObject2);
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
				Difference haveEqualFeature = haveEqualFeature(eObject1, eObject2, feature);
				if (haveEqualFeature != Difference.NO_DIFFERENCE) {
					return haveEqualFeature;
				}
			}
		}

		// There's no reason they aren't equal, so they are.
		//
		return Difference.NO_DIFFERENCE;
	}

	private Difference compareLists(List list1, List list2) {
		int size = list1.size();
		if (size != list2.size()) {
			return Difference.getInstance(false, CommonLocations.LIST_LENGTH, list1, list2);
		}

		for (int i = 0; i < size; i++) {
			EObject eObject1 = (EObject) list1.get(i);
			EObject eObject2 = (EObject) list2.get(i);
			Difference equals = compareEObjects(eObject1, eObject2);
			if (equals != Difference.NO_DIFFERENCE) {
				return equals;
			}
		}

		return Difference.NO_DIFFERENCE;
	}

	private Difference haveEqualFeature(EObject eObject1, EObject eObject2,
			EStructuralFeature feature) {
		// If the set states are the same, and the values of the feature are the
		// structurally equal, they are equal.
		//
		if (eObject1.eIsSet(feature) != eObject2.eIsSet(feature)) {
			return Difference.getInstance(false, new FeatureLocation(feature), eObject1, eObject2);
		}
		return (feature instanceof EReference ? haveEqualReference(
						eObject1, eObject2, (EReference) feature)
						: haveEqualAttribute(eObject1, eObject2,
								(EAttribute) feature));
	}

	private Difference haveEqualReference(EObject eObject1, EObject eObject2,
			EReference reference) {
		Object value1 = eObject1.eGet(reference);
		Object value2 = eObject2.eGet(reference);

		return reference.isMany() ? compareLists((List) value1, (List) value2)
				: compareEObjects((EObject) value1, (EObject) value2);
	}

	private Difference haveEqualAttribute(EObject eObject1, EObject eObject2,
			EAttribute attribute) {
		Object value1 = eObject1.eGet(attribute);
		Object value2 = eObject2.eGet(attribute);

		// If the first value is null, the second value must be null.
		//
		if (value1 == null) {
			return Difference.getInstance(value2 == null, new FeatureLocation(attribute), eObject1, eObject2);
		}

		// Since the first value isn't null, if the second one is, they aren't
		// equal.
		//
		if (value2 == null) {
			return Difference.getInstance(false, new FeatureLocation(attribute), eObject1, eObject2);
		}

		// If this is a feature map...
		//
		if (FeatureMapUtil.isFeatureMap(attribute)) {
			// The feature maps must be equal.
			//
			FeatureMap featureMap1 = (FeatureMap) value1;
			FeatureMap featureMap2 = (FeatureMap) value2;
			return compareFeatureMaps(featureMap1, featureMap2);
		} else {
			// The values must be Java equal.
			//
			return Difference.getInstance(value1.equals(value2), new FeatureLocation(attribute), eObject1, eObject2);
		}
	}

	private Difference compareFeatureMaps(FeatureMap featureMap1,
			FeatureMap featureMap2) {
		// If they don't have the same size, the feature maps aren't equal.
		//
		int size = featureMap1.size();
		if (size != featureMap2.size()) {
			return Difference.getInstance(false, CommonLocations.LIST_LENGTH, featureMap1, featureMap2);
		}

		// Compare entries in order.
		//
		for (int i = 0; i < size; i++) {
			// If entries don't have the same feature, the feature maps aren't
			// equal.
			//
			EStructuralFeature feature = featureMap1.getEStructuralFeature(i);
			if (feature != featureMap2.getEStructuralFeature(i)) {
				return Difference.getInstance(false, CommonLocations.DIFFERENT_FEATURES, feature, featureMap2.getEStructuralFeature(i));
			}

			Object value1 = featureMap1.getValue(i);
			Object value2 = featureMap2.getValue(i);

			Difference equalFeatureMapValues = compareFeatureMapValues(value1, value2, feature);
			if (equalFeatureMapValues != Difference.NO_DIFFERENCE) {
				return equalFeatureMapValues;
			}
		}

		// There is no reason they aren't equals.
		//
		return Difference.NO_DIFFERENCE;
	}

	private Difference compareFeatureMapValues(Object value1, Object value2,
			EStructuralFeature feature) {
		if (feature instanceof EReference) {
			// If the referenced EObjects aren't equal, the feature maps aren't
			// equal.
			//
			return compareEObjects((EObject) value1, (EObject) value2);
		} else {
			// If the values aren't Java equal, the feature maps aren't equal.
			//
			return Difference.getInstance(value1 == null ? value2 == null : value1.equals(value2), new FeatureLocation(feature), value1, value2);
		}
	}

}
