/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astrans.impl;

import astrans.AstransPackage;
import astrans.SkipClass;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Skip Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link astrans.impl.SkipClassImpl#getTargetProto <em>Target Proto</em>}</li>
 *   <li>{@link astrans.impl.SkipClassImpl#isIncludeDescendants <em>Include Descendants</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SkipClassImpl extends ActionImpl implements SkipClass {
	/**
	 * The cached value of the '{@link #getTargetProto() <em>Target Proto</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetProto()
	 * @generated
	 * @ordered
	 */
	protected EClass targetProto = null;

	/**
	 * The default value of the '{@link #isIncludeDescendants() <em>Include Descendants</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIncludeDescendants()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INCLUDE_DESCENDANTS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIncludeDescendants() <em>Include Descendants</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIncludeDescendants()
	 * @generated
	 * @ordered
	 */
	protected boolean includeDescendants = INCLUDE_DESCENDANTS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SkipClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AstransPackage.Literals.SKIP_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetProto() {
		if (targetProto != null && targetProto.eIsProxy()) {
			InternalEObject oldTargetProto = (InternalEObject)targetProto;
			targetProto = (EClass)eResolveProxy(oldTargetProto);
			if (targetProto != oldTargetProto) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AstransPackage.SKIP_CLASS__TARGET_PROTO, oldTargetProto, targetProto));
			}
		}
		return targetProto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetTargetProto() {
		return targetProto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetProto(EClass newTargetProto) {
		EClass oldTargetProto = targetProto;
		targetProto = newTargetProto;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransPackage.SKIP_CLASS__TARGET_PROTO, oldTargetProto, targetProto));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIncludeDescendants() {
		return includeDescendants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncludeDescendants(boolean newIncludeDescendants) {
		boolean oldIncludeDescendants = includeDescendants;
		includeDescendants = newIncludeDescendants;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransPackage.SKIP_CLASS__INCLUDE_DESCENDANTS, oldIncludeDescendants, includeDescendants));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AstransPackage.SKIP_CLASS__TARGET_PROTO:
				if (resolve) return getTargetProto();
				return basicGetTargetProto();
			case AstransPackage.SKIP_CLASS__INCLUDE_DESCENDANTS:
				return isIncludeDescendants() ? Boolean.TRUE : Boolean.FALSE;
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
			case AstransPackage.SKIP_CLASS__TARGET_PROTO:
				setTargetProto((EClass)newValue);
				return;
			case AstransPackage.SKIP_CLASS__INCLUDE_DESCENDANTS:
				setIncludeDescendants(((Boolean)newValue).booleanValue());
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
			case AstransPackage.SKIP_CLASS__TARGET_PROTO:
				setTargetProto((EClass)null);
				return;
			case AstransPackage.SKIP_CLASS__INCLUDE_DESCENDANTS:
				setIncludeDescendants(INCLUDE_DESCENDANTS_EDEFAULT);
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
			case AstransPackage.SKIP_CLASS__TARGET_PROTO:
				return targetProto != null;
			case AstransPackage.SKIP_CLASS__INCLUDE_DESCENDANTS:
				return includeDescendants != INCLUDE_DESCENDANTS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (includeDescendants: ");
		result.append(includeDescendants);
		result.append(')');
		return result.toString();
	}

} //SkipClassImpl