/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransast.impl;

import astransast.AstransastPackage;
import astransast.CreateClassAS;
import astransast.EClassifierReferenceAS;
import astransast.QualifiedName;
import astransast.StructuralFeatureAS;

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
 * An implementation of the model object '<em><b>Create Class AS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link astransast.impl.CreateClassASImpl#getName <em>Name</em>}</li>
 *   <li>{@link astransast.impl.CreateClassASImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link astransast.impl.CreateClassASImpl#getSuperclasses <em>Superclasses</em>}</li>
 *   <li>{@link astransast.impl.CreateClassASImpl#getStructuralFeatures <em>Structural Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CreateClassASImpl extends ActionASImpl implements CreateClassAS {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;

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
	 * The cached value of the '{@link #getStructuralFeatures() <em>Structural Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructuralFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList structuralFeatures = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateClassASImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AstransastPackage.Literals.CREATE_CLASS_AS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransastPackage.CREATE_CLASS_AS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransastPackage.CREATE_CLASS_AS__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSuperclasses() {
		if (superclasses == null) {
			superclasses = new EObjectContainmentEList(EClassifierReferenceAS.class, this, AstransastPackage.CREATE_CLASS_AS__SUPERCLASSES);
		}
		return superclasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getStructuralFeatures() {
		if (structuralFeatures == null) {
			structuralFeatures = new EObjectContainmentEList(StructuralFeatureAS.class, this, AstransastPackage.CREATE_CLASS_AS__STRUCTURAL_FEATURES);
		}
		return structuralFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstransastPackage.CREATE_CLASS_AS__SUPERCLASSES:
				return ((InternalEList)getSuperclasses()).basicRemove(otherEnd, msgs);
			case AstransastPackage.CREATE_CLASS_AS__STRUCTURAL_FEATURES:
				return ((InternalEList)getStructuralFeatures()).basicRemove(otherEnd, msgs);
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
			case AstransastPackage.CREATE_CLASS_AS__NAME:
				return getName();
			case AstransastPackage.CREATE_CLASS_AS__ABSTRACT:
				return isAbstract() ? Boolean.TRUE : Boolean.FALSE;
			case AstransastPackage.CREATE_CLASS_AS__SUPERCLASSES:
				return getSuperclasses();
			case AstransastPackage.CREATE_CLASS_AS__STRUCTURAL_FEATURES:
				return getStructuralFeatures();
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
			case AstransastPackage.CREATE_CLASS_AS__NAME:
				setName((String)newValue);
				return;
			case AstransastPackage.CREATE_CLASS_AS__ABSTRACT:
				setAbstract(((Boolean)newValue).booleanValue());
				return;
			case AstransastPackage.CREATE_CLASS_AS__SUPERCLASSES:
				getSuperclasses().clear();
				getSuperclasses().addAll((Collection)newValue);
				return;
			case AstransastPackage.CREATE_CLASS_AS__STRUCTURAL_FEATURES:
				getStructuralFeatures().clear();
				getStructuralFeatures().addAll((Collection)newValue);
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
			case AstransastPackage.CREATE_CLASS_AS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AstransastPackage.CREATE_CLASS_AS__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case AstransastPackage.CREATE_CLASS_AS__SUPERCLASSES:
				getSuperclasses().clear();
				return;
			case AstransastPackage.CREATE_CLASS_AS__STRUCTURAL_FEATURES:
				getStructuralFeatures().clear();
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
			case AstransastPackage.CREATE_CLASS_AS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AstransastPackage.CREATE_CLASS_AS__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
			case AstransastPackage.CREATE_CLASS_AS__SUPERCLASSES:
				return superclasses != null && !superclasses.isEmpty();
			case AstransastPackage.CREATE_CLASS_AS__STRUCTURAL_FEATURES:
				return structuralFeatures != null && !structuralFeatures.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", abstract: ");
		result.append(abstract_);
		result.append(')');
		return result.toString();
	}

} //CreateClassASImpl