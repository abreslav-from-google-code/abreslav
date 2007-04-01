/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astrans.impl;

import astrans.Action;
import astrans.AstransPackage;
import astrans.ChangeInheritance;
import astrans.CreateClass;
import astrans.SkipClass;
import astrans.Transformation;

import astrans.TranslateReferences;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link astrans.impl.TransformationImpl#getCreateClassActions <em>Create Class Actions</em>}</li>
 *   <li>{@link astrans.impl.TransformationImpl#getTranslateReferencesActions <em>Translate References Actions</em>}</li>
 *   <li>{@link astrans.impl.TransformationImpl#getChangeInheritanceActions <em>Change Inheritance Actions</em>}</li>
 *   <li>{@link astrans.impl.TransformationImpl#getSkipClassActions <em>Skip Class Actions</em>}</li>
 *   <li>{@link astrans.impl.TransformationImpl#getInput <em>Input</em>}</li>
 *   <li>{@link astrans.impl.TransformationImpl#getOutputName <em>Output Name</em>}</li>
 *   <li>{@link astrans.impl.TransformationImpl#getOutputNsURI <em>Output Ns URI</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformationImpl extends EObjectImpl implements Transformation {
	/**
	 * The cached value of the '{@link #getCreateClassActions() <em>Create Class Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateClassActions()
	 * @generated
	 * @ordered
	 */
	protected EList createClassActions = null;

	/**
	 * The cached value of the '{@link #getTranslateReferencesActions() <em>Translate References Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranslateReferencesActions()
	 * @generated
	 * @ordered
	 */
	protected EList translateReferencesActions = null;

	/**
	 * The cached value of the '{@link #getChangeInheritanceActions() <em>Change Inheritance Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChangeInheritanceActions()
	 * @generated
	 * @ordered
	 */
	protected EList changeInheritanceActions = null;

	/**
	 * The cached value of the '{@link #getSkipClassActions() <em>Skip Class Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSkipClassActions()
	 * @generated
	 * @ordered
	 */
	protected EList skipClassActions = null;

	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected EPackage input = null;

	/**
	 * The default value of the '{@link #getOutputName() <em>Output Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputName()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTPUT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutputName() <em>Output Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputName()
	 * @generated
	 * @ordered
	 */
	protected String outputName = OUTPUT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutputNsURI() <em>Output Ns URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputNsURI()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTPUT_NS_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutputNsURI() <em>Output Ns URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputNsURI()
	 * @generated
	 * @ordered
	 */
	protected String outputNsURI = OUTPUT_NS_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AstransPackage.Literals.TRANSFORMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCreateClassActions() {
		if (createClassActions == null) {
			createClassActions = new EObjectContainmentEList(CreateClass.class, this, AstransPackage.TRANSFORMATION__CREATE_CLASS_ACTIONS);
		}
		return createClassActions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTranslateReferencesActions() {
		if (translateReferencesActions == null) {
			translateReferencesActions = new EObjectContainmentEList(TranslateReferences.class, this, AstransPackage.TRANSFORMATION__TRANSLATE_REFERENCES_ACTIONS);
		}
		return translateReferencesActions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getChangeInheritanceActions() {
		if (changeInheritanceActions == null) {
			changeInheritanceActions = new EObjectContainmentEList(ChangeInheritance.class, this, AstransPackage.TRANSFORMATION__CHANGE_INHERITANCE_ACTIONS);
		}
		return changeInheritanceActions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSkipClassActions() {
		if (skipClassActions == null) {
			skipClassActions = new EObjectContainmentEList(SkipClass.class, this, AstransPackage.TRANSFORMATION__SKIP_CLASS_ACTIONS);
		}
		return skipClassActions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage getInput() {
		if (input != null && input.eIsProxy()) {
			InternalEObject oldInput = (InternalEObject)input;
			input = (EPackage)eResolveProxy(oldInput);
			if (input != oldInput) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AstransPackage.TRANSFORMATION__INPUT, oldInput, input));
			}
		}
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetInput() {
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInput(EPackage newInput) {
		EPackage oldInput = input;
		input = newInput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransPackage.TRANSFORMATION__INPUT, oldInput, input));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutputName() {
		return outputName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputName(String newOutputName) {
		String oldOutputName = outputName;
		outputName = newOutputName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransPackage.TRANSFORMATION__OUTPUT_NAME, oldOutputName, outputName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutputNsURI() {
		return outputNsURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputNsURI(String newOutputNsURI) {
		String oldOutputNsURI = outputNsURI;
		outputNsURI = newOutputNsURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransPackage.TRANSFORMATION__OUTPUT_NS_URI, oldOutputNsURI, outputNsURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstransPackage.TRANSFORMATION__CREATE_CLASS_ACTIONS:
				return ((InternalEList)getCreateClassActions()).basicRemove(otherEnd, msgs);
			case AstransPackage.TRANSFORMATION__TRANSLATE_REFERENCES_ACTIONS:
				return ((InternalEList)getTranslateReferencesActions()).basicRemove(otherEnd, msgs);
			case AstransPackage.TRANSFORMATION__CHANGE_INHERITANCE_ACTIONS:
				return ((InternalEList)getChangeInheritanceActions()).basicRemove(otherEnd, msgs);
			case AstransPackage.TRANSFORMATION__SKIP_CLASS_ACTIONS:
				return ((InternalEList)getSkipClassActions()).basicRemove(otherEnd, msgs);
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
			case AstransPackage.TRANSFORMATION__CREATE_CLASS_ACTIONS:
				return getCreateClassActions();
			case AstransPackage.TRANSFORMATION__TRANSLATE_REFERENCES_ACTIONS:
				return getTranslateReferencesActions();
			case AstransPackage.TRANSFORMATION__CHANGE_INHERITANCE_ACTIONS:
				return getChangeInheritanceActions();
			case AstransPackage.TRANSFORMATION__SKIP_CLASS_ACTIONS:
				return getSkipClassActions();
			case AstransPackage.TRANSFORMATION__INPUT:
				if (resolve) return getInput();
				return basicGetInput();
			case AstransPackage.TRANSFORMATION__OUTPUT_NAME:
				return getOutputName();
			case AstransPackage.TRANSFORMATION__OUTPUT_NS_URI:
				return getOutputNsURI();
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
			case AstransPackage.TRANSFORMATION__CREATE_CLASS_ACTIONS:
				getCreateClassActions().clear();
				getCreateClassActions().addAll((Collection)newValue);
				return;
			case AstransPackage.TRANSFORMATION__TRANSLATE_REFERENCES_ACTIONS:
				getTranslateReferencesActions().clear();
				getTranslateReferencesActions().addAll((Collection)newValue);
				return;
			case AstransPackage.TRANSFORMATION__CHANGE_INHERITANCE_ACTIONS:
				getChangeInheritanceActions().clear();
				getChangeInheritanceActions().addAll((Collection)newValue);
				return;
			case AstransPackage.TRANSFORMATION__SKIP_CLASS_ACTIONS:
				getSkipClassActions().clear();
				getSkipClassActions().addAll((Collection)newValue);
				return;
			case AstransPackage.TRANSFORMATION__INPUT:
				setInput((EPackage)newValue);
				return;
			case AstransPackage.TRANSFORMATION__OUTPUT_NAME:
				setOutputName((String)newValue);
				return;
			case AstransPackage.TRANSFORMATION__OUTPUT_NS_URI:
				setOutputNsURI((String)newValue);
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
			case AstransPackage.TRANSFORMATION__CREATE_CLASS_ACTIONS:
				getCreateClassActions().clear();
				return;
			case AstransPackage.TRANSFORMATION__TRANSLATE_REFERENCES_ACTIONS:
				getTranslateReferencesActions().clear();
				return;
			case AstransPackage.TRANSFORMATION__CHANGE_INHERITANCE_ACTIONS:
				getChangeInheritanceActions().clear();
				return;
			case AstransPackage.TRANSFORMATION__SKIP_CLASS_ACTIONS:
				getSkipClassActions().clear();
				return;
			case AstransPackage.TRANSFORMATION__INPUT:
				setInput((EPackage)null);
				return;
			case AstransPackage.TRANSFORMATION__OUTPUT_NAME:
				setOutputName(OUTPUT_NAME_EDEFAULT);
				return;
			case AstransPackage.TRANSFORMATION__OUTPUT_NS_URI:
				setOutputNsURI(OUTPUT_NS_URI_EDEFAULT);
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
			case AstransPackage.TRANSFORMATION__CREATE_CLASS_ACTIONS:
				return createClassActions != null && !createClassActions.isEmpty();
			case AstransPackage.TRANSFORMATION__TRANSLATE_REFERENCES_ACTIONS:
				return translateReferencesActions != null && !translateReferencesActions.isEmpty();
			case AstransPackage.TRANSFORMATION__CHANGE_INHERITANCE_ACTIONS:
				return changeInheritanceActions != null && !changeInheritanceActions.isEmpty();
			case AstransPackage.TRANSFORMATION__SKIP_CLASS_ACTIONS:
				return skipClassActions != null && !skipClassActions.isEmpty();
			case AstransPackage.TRANSFORMATION__INPUT:
				return input != null;
			case AstransPackage.TRANSFORMATION__OUTPUT_NAME:
				return OUTPUT_NAME_EDEFAULT == null ? outputName != null : !OUTPUT_NAME_EDEFAULT.equals(outputName);
			case AstransPackage.TRANSFORMATION__OUTPUT_NS_URI:
				return OUTPUT_NS_URI_EDEFAULT == null ? outputNsURI != null : !OUTPUT_NS_URI_EDEFAULT.equals(outputNsURI);
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
		result.append(" (outputName: ");
		result.append(outputName);
		result.append(", outputNsURI: ");
		result.append(outputNsURI);
		result.append(')');
		return result.toString();
	}

} //TransformationImpl