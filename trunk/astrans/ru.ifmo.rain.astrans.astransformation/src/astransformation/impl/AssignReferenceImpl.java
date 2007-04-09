/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransformation.impl;

import astransformation.AssignReference;
import astransformation.AstransformationPackage;
import astransformation.MappingRule;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assign Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link astransformation.impl.AssignReferenceImpl#getMappingRule <em>Mapping Rule</em>}</li>
 *   <li>{@link astransformation.impl.AssignReferenceImpl#getSource <em>Source</em>}</li>
 *   <li>{@link astransformation.impl.AssignReferenceImpl#getDest <em>Dest</em>}</li>
 *   <li>{@link astransformation.impl.AssignReferenceImpl#isMappingNeeded <em>Mapping Needed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssignReferenceImpl extends EObjectImpl implements AssignReference {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected EReference source = null;

	/**
	 * The cached value of the '{@link #getDest() <em>Dest</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDest()
	 * @generated
	 * @ordered
	 */
	protected EReference dest = null;

	/**
	 * The default value of the '{@link #isMappingNeeded() <em>Mapping Needed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMappingNeeded()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MAPPING_NEEDED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isMappingNeeded() <em>Mapping Needed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMappingNeeded()
	 * @generated
	 * @ordered
	 */
	protected boolean mappingNeeded = MAPPING_NEEDED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssignReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AstransformationPackage.Literals.ASSIGN_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingRule getMappingRule() {
		if (eContainerFeatureID != AstransformationPackage.ASSIGN_REFERENCE__MAPPING_RULE) return null;
		return (MappingRule)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingRule(MappingRule newMappingRule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMappingRule, AstransformationPackage.ASSIGN_REFERENCE__MAPPING_RULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingRule(MappingRule newMappingRule) {
		if (newMappingRule != eInternalContainer() || (eContainerFeatureID != AstransformationPackage.ASSIGN_REFERENCE__MAPPING_RULE && newMappingRule != null)) {
			if (EcoreUtil.isAncestor(this, newMappingRule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMappingRule != null)
				msgs = ((InternalEObject)newMappingRule).eInverseAdd(this, AstransformationPackage.MAPPING_RULE__ASSIGN_REFERENCE_STATEMENTS, MappingRule.class, msgs);
			msgs = basicSetMappingRule(newMappingRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransformationPackage.ASSIGN_REFERENCE__MAPPING_RULE, newMappingRule, newMappingRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (EReference)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AstransformationPackage.ASSIGN_REFERENCE__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(EReference newSource) {
		EReference oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransformationPackage.ASSIGN_REFERENCE__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDest() {
		if (dest != null && dest.eIsProxy()) {
			InternalEObject oldDest = (InternalEObject)dest;
			dest = (EReference)eResolveProxy(oldDest);
			if (dest != oldDest) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AstransformationPackage.ASSIGN_REFERENCE__DEST, oldDest, dest));
			}
		}
		return dest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetDest() {
		return dest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDest(EReference newDest) {
		EReference oldDest = dest;
		dest = newDest;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransformationPackage.ASSIGN_REFERENCE__DEST, oldDest, dest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMappingNeeded() {
		return mappingNeeded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingNeeded(boolean newMappingNeeded) {
		boolean oldMappingNeeded = mappingNeeded;
		mappingNeeded = newMappingNeeded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransformationPackage.ASSIGN_REFERENCE__MAPPING_NEEDED, oldMappingNeeded, mappingNeeded));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstransformationPackage.ASSIGN_REFERENCE__MAPPING_RULE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMappingRule((MappingRule)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstransformationPackage.ASSIGN_REFERENCE__MAPPING_RULE:
				return basicSetMappingRule(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case AstransformationPackage.ASSIGN_REFERENCE__MAPPING_RULE:
				return eInternalContainer().eInverseRemove(this, AstransformationPackage.MAPPING_RULE__ASSIGN_REFERENCE_STATEMENTS, MappingRule.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AstransformationPackage.ASSIGN_REFERENCE__MAPPING_RULE:
				return getMappingRule();
			case AstransformationPackage.ASSIGN_REFERENCE__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case AstransformationPackage.ASSIGN_REFERENCE__DEST:
				if (resolve) return getDest();
				return basicGetDest();
			case AstransformationPackage.ASSIGN_REFERENCE__MAPPING_NEEDED:
				return isMappingNeeded() ? Boolean.TRUE : Boolean.FALSE;
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
			case AstransformationPackage.ASSIGN_REFERENCE__MAPPING_RULE:
				setMappingRule((MappingRule)newValue);
				return;
			case AstransformationPackage.ASSIGN_REFERENCE__SOURCE:
				setSource((EReference)newValue);
				return;
			case AstransformationPackage.ASSIGN_REFERENCE__DEST:
				setDest((EReference)newValue);
				return;
			case AstransformationPackage.ASSIGN_REFERENCE__MAPPING_NEEDED:
				setMappingNeeded(((Boolean)newValue).booleanValue());
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
			case AstransformationPackage.ASSIGN_REFERENCE__MAPPING_RULE:
				setMappingRule((MappingRule)null);
				return;
			case AstransformationPackage.ASSIGN_REFERENCE__SOURCE:
				setSource((EReference)null);
				return;
			case AstransformationPackage.ASSIGN_REFERENCE__DEST:
				setDest((EReference)null);
				return;
			case AstransformationPackage.ASSIGN_REFERENCE__MAPPING_NEEDED:
				setMappingNeeded(MAPPING_NEEDED_EDEFAULT);
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
			case AstransformationPackage.ASSIGN_REFERENCE__MAPPING_RULE:
				return getMappingRule() != null;
			case AstransformationPackage.ASSIGN_REFERENCE__SOURCE:
				return source != null;
			case AstransformationPackage.ASSIGN_REFERENCE__DEST:
				return dest != null;
			case AstransformationPackage.ASSIGN_REFERENCE__MAPPING_NEEDED:
				return mappingNeeded != MAPPING_NEEDED_EDEFAULT;
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
		result.append(" (mappingNeeded: ");
		result.append(mappingNeeded);
		result.append(')');
		return result.toString();
	}

} //AssignReferenceImpl