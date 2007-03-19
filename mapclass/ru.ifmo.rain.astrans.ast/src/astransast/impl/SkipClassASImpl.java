/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransast.impl;

import astransast.AstransastPackage;
import astransast.QualifiedName;
import astransast.SkipClassAS;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Skip Class AS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link astransast.impl.SkipClassASImpl#isIncludeDescendants <em>Include Descendants</em>}</li>
 *   <li>{@link astransast.impl.SkipClassASImpl#getTargetProto <em>Target Proto</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SkipClassASImpl extends ActionASImpl implements SkipClassAS {
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
	 * The cached value of the '{@link #getTargetProto() <em>Target Proto</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetProto()
	 * @generated
	 * @ordered
	 */
	protected QualifiedName targetProto = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SkipClassASImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AstransastPackage.Literals.SKIP_CLASS_AS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, AstransastPackage.SKIP_CLASS_AS__INCLUDE_DESCENDANTS, oldIncludeDescendants, includeDescendants));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName getTargetProto() {
		return targetProto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetProto(QualifiedName newTargetProto, NotificationChain msgs) {
		QualifiedName oldTargetProto = targetProto;
		targetProto = newTargetProto;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstransastPackage.SKIP_CLASS_AS__TARGET_PROTO, oldTargetProto, newTargetProto);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetProto(QualifiedName newTargetProto) {
		if (newTargetProto != targetProto) {
			NotificationChain msgs = null;
			if (targetProto != null)
				msgs = ((InternalEObject)targetProto).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstransastPackage.SKIP_CLASS_AS__TARGET_PROTO, null, msgs);
			if (newTargetProto != null)
				msgs = ((InternalEObject)newTargetProto).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstransastPackage.SKIP_CLASS_AS__TARGET_PROTO, null, msgs);
			msgs = basicSetTargetProto(newTargetProto, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransastPackage.SKIP_CLASS_AS__TARGET_PROTO, newTargetProto, newTargetProto));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstransastPackage.SKIP_CLASS_AS__TARGET_PROTO:
				return basicSetTargetProto(null, msgs);
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
			case AstransastPackage.SKIP_CLASS_AS__INCLUDE_DESCENDANTS:
				return isIncludeDescendants() ? Boolean.TRUE : Boolean.FALSE;
			case AstransastPackage.SKIP_CLASS_AS__TARGET_PROTO:
				return getTargetProto();
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
			case AstransastPackage.SKIP_CLASS_AS__INCLUDE_DESCENDANTS:
				setIncludeDescendants(((Boolean)newValue).booleanValue());
				return;
			case AstransastPackage.SKIP_CLASS_AS__TARGET_PROTO:
				setTargetProto((QualifiedName)newValue);
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
			case AstransastPackage.SKIP_CLASS_AS__INCLUDE_DESCENDANTS:
				setIncludeDescendants(INCLUDE_DESCENDANTS_EDEFAULT);
				return;
			case AstransastPackage.SKIP_CLASS_AS__TARGET_PROTO:
				setTargetProto((QualifiedName)null);
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
			case AstransastPackage.SKIP_CLASS_AS__INCLUDE_DESCENDANTS:
				return includeDescendants != INCLUDE_DESCENDANTS_EDEFAULT;
			case AstransastPackage.SKIP_CLASS_AS__TARGET_PROTO:
				return targetProto != null;
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

} //SkipClassASImpl