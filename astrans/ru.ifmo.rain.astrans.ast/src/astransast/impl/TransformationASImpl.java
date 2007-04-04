/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransast.impl;

import astransast.ActionAS;
import astransast.AstransastPackage;
import astransast.ChangeInheritanceAS;
import astransast.CreateClassAS;
import astransast.EPackageReference;
import astransast.SkipClassAS;
import astransast.TransformationAS;

import astransast.TranslateReferencesAS;

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
 * An implementation of the model object '<em><b>Transformation AS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link astransast.impl.TransformationASImpl#getOutputName <em>Output Name</em>}</li>
 *   <li>{@link astransast.impl.TransformationASImpl#getOutputNsURI <em>Output Ns URI</em>}</li>
 *   <li>{@link astransast.impl.TransformationASImpl#getCreateClassActions <em>Create Class Actions</em>}</li>
 *   <li>{@link astransast.impl.TransformationASImpl#getTranslateReferencesActions <em>Translate References Actions</em>}</li>
 *   <li>{@link astransast.impl.TransformationASImpl#getChangeInheritanceActions <em>Change Inheritance Actions</em>}</li>
 *   <li>{@link astransast.impl.TransformationASImpl#getSkipClassActions <em>Skip Class Actions</em>}</li>
 *   <li>{@link astransast.impl.TransformationASImpl#getInput <em>Input</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformationASImpl extends EObjectImpl implements TransformationAS {
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
	 * The cached value of the '{@link #getInput() <em>Input</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected EPackageReference input = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformationASImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AstransastPackage.Literals.TRANSFORMATION_AS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, AstransastPackage.TRANSFORMATION_AS__OUTPUT_NAME, oldOutputName, outputName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AstransastPackage.TRANSFORMATION_AS__OUTPUT_NS_URI, oldOutputNsURI, outputNsURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCreateClassActions() {
		if (createClassActions == null) {
			createClassActions = new EObjectContainmentEList(CreateClassAS.class, this, AstransastPackage.TRANSFORMATION_AS__CREATE_CLASS_ACTIONS);
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
			translateReferencesActions = new EObjectContainmentEList(TranslateReferencesAS.class, this, AstransastPackage.TRANSFORMATION_AS__TRANSLATE_REFERENCES_ACTIONS);
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
			changeInheritanceActions = new EObjectContainmentEList(ChangeInheritanceAS.class, this, AstransastPackage.TRANSFORMATION_AS__CHANGE_INHERITANCE_ACTIONS);
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
			skipClassActions = new EObjectContainmentEList(SkipClassAS.class, this, AstransastPackage.TRANSFORMATION_AS__SKIP_CLASS_ACTIONS);
		}
		return skipClassActions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackageReference getInput() {
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInput(EPackageReference newInput, NotificationChain msgs) {
		EPackageReference oldInput = input;
		input = newInput;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstransastPackage.TRANSFORMATION_AS__INPUT, oldInput, newInput);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInput(EPackageReference newInput) {
		if (newInput != input) {
			NotificationChain msgs = null;
			if (input != null)
				msgs = ((InternalEObject)input).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstransastPackage.TRANSFORMATION_AS__INPUT, null, msgs);
			if (newInput != null)
				msgs = ((InternalEObject)newInput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstransastPackage.TRANSFORMATION_AS__INPUT, null, msgs);
			msgs = basicSetInput(newInput, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransastPackage.TRANSFORMATION_AS__INPUT, newInput, newInput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstransastPackage.TRANSFORMATION_AS__CREATE_CLASS_ACTIONS:
				return ((InternalEList)getCreateClassActions()).basicRemove(otherEnd, msgs);
			case AstransastPackage.TRANSFORMATION_AS__TRANSLATE_REFERENCES_ACTIONS:
				return ((InternalEList)getTranslateReferencesActions()).basicRemove(otherEnd, msgs);
			case AstransastPackage.TRANSFORMATION_AS__CHANGE_INHERITANCE_ACTIONS:
				return ((InternalEList)getChangeInheritanceActions()).basicRemove(otherEnd, msgs);
			case AstransastPackage.TRANSFORMATION_AS__SKIP_CLASS_ACTIONS:
				return ((InternalEList)getSkipClassActions()).basicRemove(otherEnd, msgs);
			case AstransastPackage.TRANSFORMATION_AS__INPUT:
				return basicSetInput(null, msgs);
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
			case AstransastPackage.TRANSFORMATION_AS__OUTPUT_NAME:
				return getOutputName();
			case AstransastPackage.TRANSFORMATION_AS__OUTPUT_NS_URI:
				return getOutputNsURI();
			case AstransastPackage.TRANSFORMATION_AS__CREATE_CLASS_ACTIONS:
				return getCreateClassActions();
			case AstransastPackage.TRANSFORMATION_AS__TRANSLATE_REFERENCES_ACTIONS:
				return getTranslateReferencesActions();
			case AstransastPackage.TRANSFORMATION_AS__CHANGE_INHERITANCE_ACTIONS:
				return getChangeInheritanceActions();
			case AstransastPackage.TRANSFORMATION_AS__SKIP_CLASS_ACTIONS:
				return getSkipClassActions();
			case AstransastPackage.TRANSFORMATION_AS__INPUT:
				return getInput();
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
			case AstransastPackage.TRANSFORMATION_AS__OUTPUT_NAME:
				setOutputName((String)newValue);
				return;
			case AstransastPackage.TRANSFORMATION_AS__OUTPUT_NS_URI:
				setOutputNsURI((String)newValue);
				return;
			case AstransastPackage.TRANSFORMATION_AS__CREATE_CLASS_ACTIONS:
				getCreateClassActions().clear();
				getCreateClassActions().addAll((Collection)newValue);
				return;
			case AstransastPackage.TRANSFORMATION_AS__TRANSLATE_REFERENCES_ACTIONS:
				getTranslateReferencesActions().clear();
				getTranslateReferencesActions().addAll((Collection)newValue);
				return;
			case AstransastPackage.TRANSFORMATION_AS__CHANGE_INHERITANCE_ACTIONS:
				getChangeInheritanceActions().clear();
				getChangeInheritanceActions().addAll((Collection)newValue);
				return;
			case AstransastPackage.TRANSFORMATION_AS__SKIP_CLASS_ACTIONS:
				getSkipClassActions().clear();
				getSkipClassActions().addAll((Collection)newValue);
				return;
			case AstransastPackage.TRANSFORMATION_AS__INPUT:
				setInput((EPackageReference)newValue);
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
			case AstransastPackage.TRANSFORMATION_AS__OUTPUT_NAME:
				setOutputName(OUTPUT_NAME_EDEFAULT);
				return;
			case AstransastPackage.TRANSFORMATION_AS__OUTPUT_NS_URI:
				setOutputNsURI(OUTPUT_NS_URI_EDEFAULT);
				return;
			case AstransastPackage.TRANSFORMATION_AS__CREATE_CLASS_ACTIONS:
				getCreateClassActions().clear();
				return;
			case AstransastPackage.TRANSFORMATION_AS__TRANSLATE_REFERENCES_ACTIONS:
				getTranslateReferencesActions().clear();
				return;
			case AstransastPackage.TRANSFORMATION_AS__CHANGE_INHERITANCE_ACTIONS:
				getChangeInheritanceActions().clear();
				return;
			case AstransastPackage.TRANSFORMATION_AS__SKIP_CLASS_ACTIONS:
				getSkipClassActions().clear();
				return;
			case AstransastPackage.TRANSFORMATION_AS__INPUT:
				setInput((EPackageReference)null);
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
			case AstransastPackage.TRANSFORMATION_AS__OUTPUT_NAME:
				return OUTPUT_NAME_EDEFAULT == null ? outputName != null : !OUTPUT_NAME_EDEFAULT.equals(outputName);
			case AstransastPackage.TRANSFORMATION_AS__OUTPUT_NS_URI:
				return OUTPUT_NS_URI_EDEFAULT == null ? outputNsURI != null : !OUTPUT_NS_URI_EDEFAULT.equals(outputNsURI);
			case AstransastPackage.TRANSFORMATION_AS__CREATE_CLASS_ACTIONS:
				return createClassActions != null && !createClassActions.isEmpty();
			case AstransastPackage.TRANSFORMATION_AS__TRANSLATE_REFERENCES_ACTIONS:
				return translateReferencesActions != null && !translateReferencesActions.isEmpty();
			case AstransastPackage.TRANSFORMATION_AS__CHANGE_INHERITANCE_ACTIONS:
				return changeInheritanceActions != null && !changeInheritanceActions.isEmpty();
			case AstransastPackage.TRANSFORMATION_AS__SKIP_CLASS_ACTIONS:
				return skipClassActions != null && !skipClassActions.isEmpty();
			case AstransastPackage.TRANSFORMATION_AS__INPUT:
				return input != null;
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

} //TransformationASImpl