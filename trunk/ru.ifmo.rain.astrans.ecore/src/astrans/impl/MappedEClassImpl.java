/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astrans.impl;

import astrans.AstransPackage;
import astrans.MapClass;
import astrans.MappedEClass;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapped EClass</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link astrans.impl.MappedEClassImpl#getProto <em>Proto</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappedEClassImpl extends EClassReferenceImpl implements MappedEClass {
	/**
	 * The cached value of the '{@link #getProto() <em>Proto</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProto()
	 * @generated
	 * @ordered
	 */
	protected EClass proto = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappedEClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AstransPackage.Literals.MAPPED_ECLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProto() {
		if (proto != null && proto.eIsProxy()) {
			InternalEObject oldProto = (InternalEObject)proto;
			proto = (EClass)eResolveProxy(oldProto);
			if (proto != oldProto) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AstransPackage.MAPPED_ECLASS__PROTO, oldProto, proto));
			}
		}
		return proto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetProto() {
		return proto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProto(EClass newProto) {
		EClass oldProto = proto;
		proto = newProto;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransPackage.MAPPED_ECLASS__PROTO, oldProto, proto));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AstransPackage.MAPPED_ECLASS__PROTO:
				if (resolve) return getProto();
				return basicGetProto();
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
			case AstransPackage.MAPPED_ECLASS__PROTO:
				setProto((EClass)newValue);
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
			case AstransPackage.MAPPED_ECLASS__PROTO:
				setProto((EClass)null);
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
			case AstransPackage.MAPPED_ECLASS__PROTO:
				return proto != null;
		}
		return super.eIsSet(featureID);
	}

} //MappedEClassImpl