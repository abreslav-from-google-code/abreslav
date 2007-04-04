/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransast.impl;

import astransast.AstransastPackage;
import astransast.MappedEClassAS;
import astransast.QualifiedName;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapped EClass AS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link astransast.impl.MappedEClassASImpl#getProto <em>Proto</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappedEClassASImpl extends EClassifierReferenceASImpl implements MappedEClassAS {
	/**
	 * The cached value of the '{@link #getProto() <em>Proto</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProto()
	 * @generated
	 * @ordered
	 */
	protected QualifiedName proto = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappedEClassASImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AstransastPackage.Literals.MAPPED_ECLASS_AS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName getProto() {
		return proto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProto(QualifiedName newProto, NotificationChain msgs) {
		QualifiedName oldProto = proto;
		proto = newProto;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstransastPackage.MAPPED_ECLASS_AS__PROTO, oldProto, newProto);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProto(QualifiedName newProto) {
		if (newProto != proto) {
			NotificationChain msgs = null;
			if (proto != null)
				msgs = ((InternalEObject)proto).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstransastPackage.MAPPED_ECLASS_AS__PROTO, null, msgs);
			if (newProto != null)
				msgs = ((InternalEObject)newProto).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstransastPackage.MAPPED_ECLASS_AS__PROTO, null, msgs);
			msgs = basicSetProto(newProto, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransastPackage.MAPPED_ECLASS_AS__PROTO, newProto, newProto));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstransastPackage.MAPPED_ECLASS_AS__PROTO:
				return basicSetProto(null, msgs);
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
			case AstransastPackage.MAPPED_ECLASS_AS__PROTO:
				return getProto();
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
			case AstransastPackage.MAPPED_ECLASS_AS__PROTO:
				setProto((QualifiedName)newValue);
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
			case AstransastPackage.MAPPED_ECLASS_AS__PROTO:
				setProto((QualifiedName)null);
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
			case AstransastPackage.MAPPED_ECLASS_AS__PROTO:
				return proto != null;
		}
		return super.eIsSet(featureID);
	}

} //MappedEClassASImpl