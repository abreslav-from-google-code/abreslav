/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astrans.impl;

import astrans.AstransPackage;
import astrans.ExistingEDataType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Existing EData Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link astrans.impl.ExistingEDataTypeImpl#getEDataType <em>EData Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExistingEDataTypeImpl extends EClassifierReferenceImpl implements ExistingEDataType {
	/**
	 * The cached value of the '{@link #getEDataType() <em>EData Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEDataType()
	 * @generated
	 * @ordered
	 */
	protected EDataType eDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExistingEDataTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AstransPackage.Literals.EXISTING_EDATA_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEDataType() {
		if (eDataType != null && eDataType.eIsProxy()) {
			InternalEObject oldEDataType = (InternalEObject)eDataType;
			eDataType = (EDataType)eResolveProxy(oldEDataType);
			if (eDataType != oldEDataType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AstransPackage.EXISTING_EDATA_TYPE__EDATA_TYPE, oldEDataType, eDataType));
			}
		}
		return eDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType basicGetEDataType() {
		return eDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEDataType(EDataType newEDataType) {
		EDataType oldEDataType = eDataType;
		eDataType = newEDataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransPackage.EXISTING_EDATA_TYPE__EDATA_TYPE, oldEDataType, eDataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AstransPackage.EXISTING_EDATA_TYPE__EDATA_TYPE:
				if (resolve) return getEDataType();
				return basicGetEDataType();
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
			case AstransPackage.EXISTING_EDATA_TYPE__EDATA_TYPE:
				setEDataType((EDataType)newValue);
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
			case AstransPackage.EXISTING_EDATA_TYPE__EDATA_TYPE:
				setEDataType((EDataType)null);
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
			case AstransPackage.EXISTING_EDATA_TYPE__EDATA_TYPE:
				return eDataType != null;
		}
		return super.eIsSet(featureID);
	}

} //ExistingEDataTypeImpl