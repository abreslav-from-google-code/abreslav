/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransast.impl;

import astransast.AstransastPackage;
import astransast.ChangeInheritanceAS;
import astransast.EClassifierReferenceAS;
import astransast.QualifiedName;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Change Inheritance AS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link astransast.impl.ChangeInheritanceASImpl#getTargetProto <em>Target Proto</em>}</li>
 *   <li>{@link astransast.impl.ChangeInheritanceASImpl#getSuperclasses <em>Superclasses</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChangeInheritanceASImpl extends ActionASImpl implements ChangeInheritanceAS {
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
	 * The cached value of the '{@link #getSuperclasses() <em>Superclasses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperclasses()
	 * @generated
	 * @ordered
	 */
	protected EList superclasses = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChangeInheritanceASImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AstransastPackage.Literals.CHANGE_INHERITANCE_AS;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstransastPackage.CHANGE_INHERITANCE_AS__TARGET_PROTO, oldTargetProto, newTargetProto);
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
				msgs = ((InternalEObject)targetProto).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstransastPackage.CHANGE_INHERITANCE_AS__TARGET_PROTO, null, msgs);
			if (newTargetProto != null)
				msgs = ((InternalEObject)newTargetProto).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstransastPackage.CHANGE_INHERITANCE_AS__TARGET_PROTO, null, msgs);
			msgs = basicSetTargetProto(newTargetProto, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransastPackage.CHANGE_INHERITANCE_AS__TARGET_PROTO, newTargetProto, newTargetProto));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSuperclasses() {
		if (superclasses == null) {
			superclasses = new EObjectContainmentEList(EClassifierReferenceAS.class, this, AstransastPackage.CHANGE_INHERITANCE_AS__SUPERCLASSES);
		}
		return superclasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstransastPackage.CHANGE_INHERITANCE_AS__TARGET_PROTO:
				return basicSetTargetProto(null, msgs);
			case AstransastPackage.CHANGE_INHERITANCE_AS__SUPERCLASSES:
				return ((InternalEList)getSuperclasses()).basicRemove(otherEnd, msgs);
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
			case AstransastPackage.CHANGE_INHERITANCE_AS__TARGET_PROTO:
				return getTargetProto();
			case AstransastPackage.CHANGE_INHERITANCE_AS__SUPERCLASSES:
				return getSuperclasses();
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
			case AstransastPackage.CHANGE_INHERITANCE_AS__TARGET_PROTO:
				setTargetProto((QualifiedName)newValue);
				return;
			case AstransastPackage.CHANGE_INHERITANCE_AS__SUPERCLASSES:
				getSuperclasses().clear();
				getSuperclasses().addAll((Collection)newValue);
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
			case AstransastPackage.CHANGE_INHERITANCE_AS__TARGET_PROTO:
				setTargetProto((QualifiedName)null);
				return;
			case AstransastPackage.CHANGE_INHERITANCE_AS__SUPERCLASSES:
				getSuperclasses().clear();
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
			case AstransastPackage.CHANGE_INHERITANCE_AS__TARGET_PROTO:
				return targetProto != null;
			case AstransastPackage.CHANGE_INHERITANCE_AS__SUPERCLASSES:
				return superclasses != null && !superclasses.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ChangeInheritanceASImpl