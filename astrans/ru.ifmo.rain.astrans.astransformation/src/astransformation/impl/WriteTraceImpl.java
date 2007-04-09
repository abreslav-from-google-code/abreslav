/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransformation.impl;

import astransformation.AstransformationPackage;
import astransformation.MappingRule;
import astransformation.WriteTrace;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Write Trace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link astransformation.impl.WriteTraceImpl#getMappingRule <em>Mapping Rule</em>}</li>
 *   <li>{@link astransformation.impl.WriteTraceImpl#getTraceMethodName <em>Trace Method Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WriteTraceImpl extends EObjectImpl implements WriteTrace {
	/**
	 * The default value of the '{@link #getTraceMethodName() <em>Trace Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceMethodName()
	 * @generated
	 * @ordered
	 */
	protected static final String TRACE_METHOD_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTraceMethodName() <em>Trace Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceMethodName()
	 * @generated
	 * @ordered
	 */
	protected String traceMethodName = TRACE_METHOD_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WriteTraceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AstransformationPackage.Literals.WRITE_TRACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingRule getMappingRule() {
		if (eContainerFeatureID != AstransformationPackage.WRITE_TRACE__MAPPING_RULE) return null;
		return (MappingRule)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingRule(MappingRule newMappingRule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMappingRule, AstransformationPackage.WRITE_TRACE__MAPPING_RULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingRule(MappingRule newMappingRule) {
		if (newMappingRule != eInternalContainer() || (eContainerFeatureID != AstransformationPackage.WRITE_TRACE__MAPPING_RULE && newMappingRule != null)) {
			if (EcoreUtil.isAncestor(this, newMappingRule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMappingRule != null)
				msgs = ((InternalEObject)newMappingRule).eInverseAdd(this, AstransformationPackage.MAPPING_RULE__WRITE_TRACE_STATEMENT, MappingRule.class, msgs);
			msgs = basicSetMappingRule(newMappingRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransformationPackage.WRITE_TRACE__MAPPING_RULE, newMappingRule, newMappingRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTraceMethodName() {
		return traceMethodName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraceMethodName(String newTraceMethodName) {
		String oldTraceMethodName = traceMethodName;
		traceMethodName = newTraceMethodName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransformationPackage.WRITE_TRACE__TRACE_METHOD_NAME, oldTraceMethodName, traceMethodName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstransformationPackage.WRITE_TRACE__MAPPING_RULE:
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
			case AstransformationPackage.WRITE_TRACE__MAPPING_RULE:
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
			case AstransformationPackage.WRITE_TRACE__MAPPING_RULE:
				return eInternalContainer().eInverseRemove(this, AstransformationPackage.MAPPING_RULE__WRITE_TRACE_STATEMENT, MappingRule.class, msgs);
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
			case AstransformationPackage.WRITE_TRACE__MAPPING_RULE:
				return getMappingRule();
			case AstransformationPackage.WRITE_TRACE__TRACE_METHOD_NAME:
				return getTraceMethodName();
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
			case AstransformationPackage.WRITE_TRACE__MAPPING_RULE:
				setMappingRule((MappingRule)newValue);
				return;
			case AstransformationPackage.WRITE_TRACE__TRACE_METHOD_NAME:
				setTraceMethodName((String)newValue);
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
			case AstransformationPackage.WRITE_TRACE__MAPPING_RULE:
				setMappingRule((MappingRule)null);
				return;
			case AstransformationPackage.WRITE_TRACE__TRACE_METHOD_NAME:
				setTraceMethodName(TRACE_METHOD_NAME_EDEFAULT);
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
			case AstransformationPackage.WRITE_TRACE__MAPPING_RULE:
				return getMappingRule() != null;
			case AstransformationPackage.WRITE_TRACE__TRACE_METHOD_NAME:
				return TRACE_METHOD_NAME_EDEFAULT == null ? traceMethodName != null : !TRACE_METHOD_NAME_EDEFAULT.equals(traceMethodName);
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
		result.append(" (traceMethodName: ");
		result.append(traceMethodName);
		result.append(')');
		return result.toString();
	}

} //WriteTraceImpl