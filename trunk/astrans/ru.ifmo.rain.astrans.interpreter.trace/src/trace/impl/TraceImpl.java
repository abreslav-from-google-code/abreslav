/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package trace.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import trace.AttributeMapping;
import trace.ClassMapping;
import trace.ReferenceMapping;
import trace.Trace;
import trace.TracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link trace.impl.TraceImpl#getClassMappings <em>Class Mappings</em>}</li>
 *   <li>{@link trace.impl.TraceImpl#getAttributeMappings <em>Attribute Mappings</em>}</li>
 *   <li>{@link trace.impl.TraceImpl#getReferenceMappings <em>Reference Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceImpl extends EObjectImpl implements Trace {
	/**
	 * The cached value of the '{@link #getClassMappings() <em>Class Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassMappings()
	 * @generated
	 * @ordered
	 */
	protected EList classMappings = null;

	/**
	 * The cached value of the '{@link #getAttributeMappings() <em>Attribute Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeMappings()
	 * @generated
	 * @ordered
	 */
	protected EList attributeMappings = null;

	/**
	 * The cached value of the '{@link #getReferenceMappings() <em>Reference Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceMappings()
	 * @generated
	 * @ordered
	 */
	protected EList referenceMappings = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TracePackage.Literals.TRACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getClassMappings() {
		if (classMappings == null) {
			classMappings = new EObjectContainmentEList(ClassMapping.class, this, TracePackage.TRACE__CLASS_MAPPINGS);
		}
		return classMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAttributeMappings() {
		if (attributeMappings == null) {
			attributeMappings = new EObjectContainmentEList(AttributeMapping.class, this, TracePackage.TRACE__ATTRIBUTE_MAPPINGS);
		}
		return attributeMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getReferenceMappings() {
		if (referenceMappings == null) {
			referenceMappings = new EObjectContainmentEList(ReferenceMapping.class, this, TracePackage.TRACE__REFERENCE_MAPPINGS);
		}
		return referenceMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracePackage.TRACE__CLASS_MAPPINGS:
				return ((InternalEList)getClassMappings()).basicRemove(otherEnd, msgs);
			case TracePackage.TRACE__ATTRIBUTE_MAPPINGS:
				return ((InternalEList)getAttributeMappings()).basicRemove(otherEnd, msgs);
			case TracePackage.TRACE__REFERENCE_MAPPINGS:
				return ((InternalEList)getReferenceMappings()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TracePackage.TRACE__CLASS_MAPPINGS:
				return getClassMappings();
			case TracePackage.TRACE__ATTRIBUTE_MAPPINGS:
				return getAttributeMappings();
			case TracePackage.TRACE__REFERENCE_MAPPINGS:
				return getReferenceMappings();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TracePackage.TRACE__CLASS_MAPPINGS:
				getClassMappings().clear();
				getClassMappings().addAll((Collection)newValue);
				return;
			case TracePackage.TRACE__ATTRIBUTE_MAPPINGS:
				getAttributeMappings().clear();
				getAttributeMappings().addAll((Collection)newValue);
				return;
			case TracePackage.TRACE__REFERENCE_MAPPINGS:
				getReferenceMappings().clear();
				getReferenceMappings().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case TracePackage.TRACE__CLASS_MAPPINGS:
				getClassMappings().clear();
				return;
			case TracePackage.TRACE__ATTRIBUTE_MAPPINGS:
				getAttributeMappings().clear();
				return;
			case TracePackage.TRACE__REFERENCE_MAPPINGS:
				getReferenceMappings().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TracePackage.TRACE__CLASS_MAPPINGS:
				return classMappings != null && !classMappings.isEmpty();
			case TracePackage.TRACE__ATTRIBUTE_MAPPINGS:
				return attributeMappings != null && !attributeMappings.isEmpty();
			case TracePackage.TRACE__REFERENCE_MAPPINGS:
				return referenceMappings != null && !referenceMappings.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TraceImpl