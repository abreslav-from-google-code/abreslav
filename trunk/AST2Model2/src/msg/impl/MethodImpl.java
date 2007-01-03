/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package msg.impl;

import java.util.Collection;

import msg.FormalParameter;
import msg.Method;
import msg.MsgPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link msg.impl.MethodImpl#getThrows <em>Throws</em>}</li>
 *   <li>{@link msg.impl.MethodImpl#getFormalParameters <em>Formal Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MethodImpl extends MemberImpl implements Method {
	/**
	 * The cached value of the '{@link #getThrows() <em>Throws</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrows()
	 * @generated
	 * @ordered
	 */
	protected EList throws_ = null;

	/**
	 * The cached value of the '{@link #getFormalParameters() <em>Formal Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormalParameters()
	 * @generated
	 * @ordered
	 */
	protected EList formalParameters = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MethodImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return MsgPackage.Literals.METHOD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getThrows() {
		if (throws_ == null) {
			throws_ = new EObjectResolvingEList(msg.Class.class, this, MsgPackage.METHOD__THROWS);
		}
		return throws_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getFormalParameters() {
		if (formalParameters == null) {
			formalParameters = new EObjectContainmentEList(FormalParameter.class, this, MsgPackage.METHOD__FORMAL_PARAMETERS);
		}
		return formalParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MsgPackage.METHOD__FORMAL_PARAMETERS:
				return ((InternalEList)getFormalParameters()).basicRemove(otherEnd, msgs);
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
			case MsgPackage.METHOD__THROWS:
				return getThrows();
			case MsgPackage.METHOD__FORMAL_PARAMETERS:
				return getFormalParameters();
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
			case MsgPackage.METHOD__THROWS:
				getThrows().clear();
				getThrows().addAll((Collection)newValue);
				return;
			case MsgPackage.METHOD__FORMAL_PARAMETERS:
				getFormalParameters().clear();
				getFormalParameters().addAll((Collection)newValue);
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
			case MsgPackage.METHOD__THROWS:
				getThrows().clear();
				return;
			case MsgPackage.METHOD__FORMAL_PARAMETERS:
				getFormalParameters().clear();
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
			case MsgPackage.METHOD__THROWS:
				return throws_ != null && !throws_.isEmpty();
			case MsgPackage.METHOD__FORMAL_PARAMETERS:
				return formalParameters != null && !formalParameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MethodImpl