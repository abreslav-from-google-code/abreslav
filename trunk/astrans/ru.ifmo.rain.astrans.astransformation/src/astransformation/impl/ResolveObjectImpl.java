/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransformation.impl;

import astransformation.AstransformationPackage;
import astransformation.MappingRule;
import astransformation.ResolveObject;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resolve Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link astransformation.impl.ResolveObjectImpl#getMappingRule <em>Mapping Rule</em>}</li>
 *   <li>{@link astransformation.impl.ResolveObjectImpl#getSource <em>Source</em>}</li>
 *   <li>{@link astransformation.impl.ResolveObjectImpl#getDest <em>Dest</em>}</li>
 *   <li>{@link astransformation.impl.ResolveObjectImpl#getResolverMethodName <em>Resolver Method Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResolveObjectImpl extends EObjectImpl implements ResolveObject {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature source = null;

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
	 * The default value of the '{@link #getResolverMethodName() <em>Resolver Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolverMethodName()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOLVER_METHOD_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResolverMethodName() <em>Resolver Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolverMethodName()
	 * @generated
	 * @ordered
	 */
	protected String resolverMethodName = RESOLVER_METHOD_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResolveObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AstransformationPackage.Literals.RESOLVE_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingRule getMappingRule() {
		if (eContainerFeatureID != AstransformationPackage.RESOLVE_OBJECT__MAPPING_RULE) return null;
		return (MappingRule)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingRule(MappingRule newMappingRule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMappingRule, AstransformationPackage.RESOLVE_OBJECT__MAPPING_RULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingRule(MappingRule newMappingRule) {
		if (newMappingRule != eInternalContainer() || (eContainerFeatureID != AstransformationPackage.RESOLVE_OBJECT__MAPPING_RULE && newMappingRule != null)) {
			if (EcoreUtil.isAncestor(this, newMappingRule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMappingRule != null)
				msgs = ((InternalEObject)newMappingRule).eInverseAdd(this, AstransformationPackage.MAPPING_RULE__RESOLVE_OBJECT_STATEMENTS, MappingRule.class, msgs);
			msgs = basicSetMappingRule(newMappingRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransformationPackage.RESOLVE_OBJECT__MAPPING_RULE, newMappingRule, newMappingRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (EStructuralFeature)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AstransformationPackage.RESOLVE_OBJECT__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(EStructuralFeature newSource) {
		EStructuralFeature oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransformationPackage.RESOLVE_OBJECT__SOURCE, oldSource, source));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AstransformationPackage.RESOLVE_OBJECT__DEST, oldDest, dest));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AstransformationPackage.RESOLVE_OBJECT__DEST, oldDest, dest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResolverMethodName() {
		return resolverMethodName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolverMethodName(String newResolverMethodName) {
		String oldResolverMethodName = resolverMethodName;
		resolverMethodName = newResolverMethodName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransformationPackage.RESOLVE_OBJECT__RESOLVER_METHOD_NAME, oldResolverMethodName, resolverMethodName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstransformationPackage.RESOLVE_OBJECT__MAPPING_RULE:
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
			case AstransformationPackage.RESOLVE_OBJECT__MAPPING_RULE:
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
			case AstransformationPackage.RESOLVE_OBJECT__MAPPING_RULE:
				return eInternalContainer().eInverseRemove(this, AstransformationPackage.MAPPING_RULE__RESOLVE_OBJECT_STATEMENTS, MappingRule.class, msgs);
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
			case AstransformationPackage.RESOLVE_OBJECT__MAPPING_RULE:
				return getMappingRule();
			case AstransformationPackage.RESOLVE_OBJECT__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case AstransformationPackage.RESOLVE_OBJECT__DEST:
				if (resolve) return getDest();
				return basicGetDest();
			case AstransformationPackage.RESOLVE_OBJECT__RESOLVER_METHOD_NAME:
				return getResolverMethodName();
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
			case AstransformationPackage.RESOLVE_OBJECT__MAPPING_RULE:
				setMappingRule((MappingRule)newValue);
				return;
			case AstransformationPackage.RESOLVE_OBJECT__SOURCE:
				setSource((EStructuralFeature)newValue);
				return;
			case AstransformationPackage.RESOLVE_OBJECT__DEST:
				setDest((EReference)newValue);
				return;
			case AstransformationPackage.RESOLVE_OBJECT__RESOLVER_METHOD_NAME:
				setResolverMethodName((String)newValue);
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
			case AstransformationPackage.RESOLVE_OBJECT__MAPPING_RULE:
				setMappingRule((MappingRule)null);
				return;
			case AstransformationPackage.RESOLVE_OBJECT__SOURCE:
				setSource((EStructuralFeature)null);
				return;
			case AstransformationPackage.RESOLVE_OBJECT__DEST:
				setDest((EReference)null);
				return;
			case AstransformationPackage.RESOLVE_OBJECT__RESOLVER_METHOD_NAME:
				setResolverMethodName(RESOLVER_METHOD_NAME_EDEFAULT);
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
			case AstransformationPackage.RESOLVE_OBJECT__MAPPING_RULE:
				return getMappingRule() != null;
			case AstransformationPackage.RESOLVE_OBJECT__SOURCE:
				return source != null;
			case AstransformationPackage.RESOLVE_OBJECT__DEST:
				return dest != null;
			case AstransformationPackage.RESOLVE_OBJECT__RESOLVER_METHOD_NAME:
				return RESOLVER_METHOD_NAME_EDEFAULT == null ? resolverMethodName != null : !RESOLVER_METHOD_NAME_EDEFAULT.equals(resolverMethodName);
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
		result.append(" (resolverMethodName: ");
		result.append(resolverMethodName);
		result.append(')');
		return result.toString();
	}

} //ResolveObjectImpl