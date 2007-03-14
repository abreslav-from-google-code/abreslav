/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransast.impl;

import astransast.AstransastPackage;
import astransast.QualifiedName;
import astransast.TranslateReferencesAS;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Translate References AS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link astransast.impl.TranslateReferencesASImpl#isIncludeDescendants <em>Include Descendants</em>}</li>
 *   <li>{@link astransast.impl.TranslateReferencesASImpl#getModelReferenceTypeProto <em>Model Reference Type Proto</em>}</li>
 *   <li>{@link astransast.impl.TranslateReferencesASImpl#getTextualReferenceType <em>Textual Reference Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TranslateReferencesASImpl extends ActionASImpl implements TranslateReferencesAS {
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
	 * The cached value of the '{@link #getModelReferenceTypeProto() <em>Model Reference Type Proto</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelReferenceTypeProto()
	 * @generated
	 * @ordered
	 */
	protected QualifiedName modelReferenceTypeProto = null;

	/**
	 * The cached value of the '{@link #getTextualReferenceType() <em>Textual Reference Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextualReferenceType()
	 * @generated
	 * @ordered
	 */
	protected QualifiedName textualReferenceType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TranslateReferencesASImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AstransastPackage.Literals.TRANSLATE_REFERENCES_AS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, AstransastPackage.TRANSLATE_REFERENCES_AS__INCLUDE_DESCENDANTS, oldIncludeDescendants, includeDescendants));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName getModelReferenceTypeProto() {
		return modelReferenceTypeProto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModelReferenceTypeProto(QualifiedName newModelReferenceTypeProto, NotificationChain msgs) {
		QualifiedName oldModelReferenceTypeProto = modelReferenceTypeProto;
		modelReferenceTypeProto = newModelReferenceTypeProto;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstransastPackage.TRANSLATE_REFERENCES_AS__MODEL_REFERENCE_TYPE_PROTO, oldModelReferenceTypeProto, newModelReferenceTypeProto);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelReferenceTypeProto(QualifiedName newModelReferenceTypeProto) {
		if (newModelReferenceTypeProto != modelReferenceTypeProto) {
			NotificationChain msgs = null;
			if (modelReferenceTypeProto != null)
				msgs = ((InternalEObject)modelReferenceTypeProto).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstransastPackage.TRANSLATE_REFERENCES_AS__MODEL_REFERENCE_TYPE_PROTO, null, msgs);
			if (newModelReferenceTypeProto != null)
				msgs = ((InternalEObject)newModelReferenceTypeProto).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstransastPackage.TRANSLATE_REFERENCES_AS__MODEL_REFERENCE_TYPE_PROTO, null, msgs);
			msgs = basicSetModelReferenceTypeProto(newModelReferenceTypeProto, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransastPackage.TRANSLATE_REFERENCES_AS__MODEL_REFERENCE_TYPE_PROTO, newModelReferenceTypeProto, newModelReferenceTypeProto));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName getTextualReferenceType() {
		return textualReferenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTextualReferenceType(QualifiedName newTextualReferenceType, NotificationChain msgs) {
		QualifiedName oldTextualReferenceType = textualReferenceType;
		textualReferenceType = newTextualReferenceType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstransastPackage.TRANSLATE_REFERENCES_AS__TEXTUAL_REFERENCE_TYPE, oldTextualReferenceType, newTextualReferenceType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextualReferenceType(QualifiedName newTextualReferenceType) {
		if (newTextualReferenceType != textualReferenceType) {
			NotificationChain msgs = null;
			if (textualReferenceType != null)
				msgs = ((InternalEObject)textualReferenceType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstransastPackage.TRANSLATE_REFERENCES_AS__TEXTUAL_REFERENCE_TYPE, null, msgs);
			if (newTextualReferenceType != null)
				msgs = ((InternalEObject)newTextualReferenceType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstransastPackage.TRANSLATE_REFERENCES_AS__TEXTUAL_REFERENCE_TYPE, null, msgs);
			msgs = basicSetTextualReferenceType(newTextualReferenceType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransastPackage.TRANSLATE_REFERENCES_AS__TEXTUAL_REFERENCE_TYPE, newTextualReferenceType, newTextualReferenceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstransastPackage.TRANSLATE_REFERENCES_AS__MODEL_REFERENCE_TYPE_PROTO:
				return basicSetModelReferenceTypeProto(null, msgs);
			case AstransastPackage.TRANSLATE_REFERENCES_AS__TEXTUAL_REFERENCE_TYPE:
				return basicSetTextualReferenceType(null, msgs);
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
			case AstransastPackage.TRANSLATE_REFERENCES_AS__INCLUDE_DESCENDANTS:
				return isIncludeDescendants() ? Boolean.TRUE : Boolean.FALSE;
			case AstransastPackage.TRANSLATE_REFERENCES_AS__MODEL_REFERENCE_TYPE_PROTO:
				return getModelReferenceTypeProto();
			case AstransastPackage.TRANSLATE_REFERENCES_AS__TEXTUAL_REFERENCE_TYPE:
				return getTextualReferenceType();
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
			case AstransastPackage.TRANSLATE_REFERENCES_AS__INCLUDE_DESCENDANTS:
				setIncludeDescendants(((Boolean)newValue).booleanValue());
				return;
			case AstransastPackage.TRANSLATE_REFERENCES_AS__MODEL_REFERENCE_TYPE_PROTO:
				setModelReferenceTypeProto((QualifiedName)newValue);
				return;
			case AstransastPackage.TRANSLATE_REFERENCES_AS__TEXTUAL_REFERENCE_TYPE:
				setTextualReferenceType((QualifiedName)newValue);
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
			case AstransastPackage.TRANSLATE_REFERENCES_AS__INCLUDE_DESCENDANTS:
				setIncludeDescendants(INCLUDE_DESCENDANTS_EDEFAULT);
				return;
			case AstransastPackage.TRANSLATE_REFERENCES_AS__MODEL_REFERENCE_TYPE_PROTO:
				setModelReferenceTypeProto((QualifiedName)null);
				return;
			case AstransastPackage.TRANSLATE_REFERENCES_AS__TEXTUAL_REFERENCE_TYPE:
				setTextualReferenceType((QualifiedName)null);
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
			case AstransastPackage.TRANSLATE_REFERENCES_AS__INCLUDE_DESCENDANTS:
				return includeDescendants != INCLUDE_DESCENDANTS_EDEFAULT;
			case AstransastPackage.TRANSLATE_REFERENCES_AS__MODEL_REFERENCE_TYPE_PROTO:
				return modelReferenceTypeProto != null;
			case AstransastPackage.TRANSLATE_REFERENCES_AS__TEXTUAL_REFERENCE_TYPE:
				return textualReferenceType != null;
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

} //TranslateReferencesASImpl