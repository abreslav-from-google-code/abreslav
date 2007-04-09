/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransformation.impl;

import astransformation.AssignAttribute;
import astransformation.AssignReference;
import astransformation.AstransformationPackage;
import astransformation.MappingRule;
import astransformation.Parameter;
import astransformation.ResolveObject;
import astransformation.WriteTrace;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link astransformation.impl.MappingRuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link astransformation.impl.MappingRuleImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link astransformation.impl.MappingRuleImpl#getResult <em>Result</em>}</li>
 *   <li>{@link astransformation.impl.MappingRuleImpl#getAssignAttributeStatements <em>Assign Attribute Statements</em>}</li>
 *   <li>{@link astransformation.impl.MappingRuleImpl#getAssignReferenceStatements <em>Assign Reference Statements</em>}</li>
 *   <li>{@link astransformation.impl.MappingRuleImpl#getWriteTraceStatement <em>Write Trace Statement</em>}</li>
 *   <li>{@link astransformation.impl.MappingRuleImpl#getResolveObjectStatements <em>Resolve Object Statements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingRuleImpl extends EObjectImpl implements MappingRule {
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
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected Parameter parameter = null;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected Parameter result = null;

	/**
	 * The cached value of the '{@link #getAssignAttributeStatements() <em>Assign Attribute Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignAttributeStatements()
	 * @generated
	 * @ordered
	 */
	protected EList assignAttributeStatements = null;

	/**
	 * The cached value of the '{@link #getAssignReferenceStatements() <em>Assign Reference Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignReferenceStatements()
	 * @generated
	 * @ordered
	 */
	protected EList assignReferenceStatements = null;

	/**
	 * The cached value of the '{@link #getWriteTraceStatement() <em>Write Trace Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWriteTraceStatement()
	 * @generated
	 * @ordered
	 */
	protected WriteTrace writeTraceStatement = null;

	/**
	 * The cached value of the '{@link #getResolveObjectStatements() <em>Resolve Object Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolveObjectStatements()
	 * @generated
	 * @ordered
	 */
	protected EList resolveObjectStatements = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AstransformationPackage.Literals.MAPPING_RULE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, AstransformationPackage.MAPPING_RULE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter getParameter() {
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameter(Parameter newParameter, NotificationChain msgs) {
		Parameter oldParameter = parameter;
		parameter = newParameter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstransformationPackage.MAPPING_RULE__PARAMETER, oldParameter, newParameter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameter(Parameter newParameter) {
		if (newParameter != parameter) {
			NotificationChain msgs = null;
			if (parameter != null)
				msgs = ((InternalEObject)parameter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstransformationPackage.MAPPING_RULE__PARAMETER, null, msgs);
			if (newParameter != null)
				msgs = ((InternalEObject)newParameter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstransformationPackage.MAPPING_RULE__PARAMETER, null, msgs);
			msgs = basicSetParameter(newParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransformationPackage.MAPPING_RULE__PARAMETER, newParameter, newParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter getResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResult(Parameter newResult, NotificationChain msgs) {
		Parameter oldResult = result;
		result = newResult;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstransformationPackage.MAPPING_RULE__RESULT, oldResult, newResult);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResult(Parameter newResult) {
		if (newResult != result) {
			NotificationChain msgs = null;
			if (result != null)
				msgs = ((InternalEObject)result).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstransformationPackage.MAPPING_RULE__RESULT, null, msgs);
			if (newResult != null)
				msgs = ((InternalEObject)newResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstransformationPackage.MAPPING_RULE__RESULT, null, msgs);
			msgs = basicSetResult(newResult, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransformationPackage.MAPPING_RULE__RESULT, newResult, newResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAssignAttributeStatements() {
		if (assignAttributeStatements == null) {
			assignAttributeStatements = new EObjectContainmentWithInverseEList(AssignAttribute.class, this, AstransformationPackage.MAPPING_RULE__ASSIGN_ATTRIBUTE_STATEMENTS, AstransformationPackage.ASSIGN_ATTRIBUTE__MAPPING_RULE);
		}
		return assignAttributeStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAssignReferenceStatements() {
		if (assignReferenceStatements == null) {
			assignReferenceStatements = new EObjectContainmentWithInverseEList(AssignReference.class, this, AstransformationPackage.MAPPING_RULE__ASSIGN_REFERENCE_STATEMENTS, AstransformationPackage.ASSIGN_REFERENCE__MAPPING_RULE);
		}
		return assignReferenceStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WriteTrace getWriteTraceStatement() {
		return writeTraceStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWriteTraceStatement(WriteTrace newWriteTraceStatement, NotificationChain msgs) {
		WriteTrace oldWriteTraceStatement = writeTraceStatement;
		writeTraceStatement = newWriteTraceStatement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstransformationPackage.MAPPING_RULE__WRITE_TRACE_STATEMENT, oldWriteTraceStatement, newWriteTraceStatement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWriteTraceStatement(WriteTrace newWriteTraceStatement) {
		if (newWriteTraceStatement != writeTraceStatement) {
			NotificationChain msgs = null;
			if (writeTraceStatement != null)
				msgs = ((InternalEObject)writeTraceStatement).eInverseRemove(this, AstransformationPackage.WRITE_TRACE__MAPPING_RULE, WriteTrace.class, msgs);
			if (newWriteTraceStatement != null)
				msgs = ((InternalEObject)newWriteTraceStatement).eInverseAdd(this, AstransformationPackage.WRITE_TRACE__MAPPING_RULE, WriteTrace.class, msgs);
			msgs = basicSetWriteTraceStatement(newWriteTraceStatement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstransformationPackage.MAPPING_RULE__WRITE_TRACE_STATEMENT, newWriteTraceStatement, newWriteTraceStatement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getResolveObjectStatements() {
		if (resolveObjectStatements == null) {
			resolveObjectStatements = new EObjectContainmentWithInverseEList(ResolveObject.class, this, AstransformationPackage.MAPPING_RULE__RESOLVE_OBJECT_STATEMENTS, AstransformationPackage.RESOLVE_OBJECT__MAPPING_RULE);
		}
		return resolveObjectStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstransformationPackage.MAPPING_RULE__ASSIGN_ATTRIBUTE_STATEMENTS:
				return ((InternalEList)getAssignAttributeStatements()).basicAdd(otherEnd, msgs);
			case AstransformationPackage.MAPPING_RULE__ASSIGN_REFERENCE_STATEMENTS:
				return ((InternalEList)getAssignReferenceStatements()).basicAdd(otherEnd, msgs);
			case AstransformationPackage.MAPPING_RULE__WRITE_TRACE_STATEMENT:
				if (writeTraceStatement != null)
					msgs = ((InternalEObject)writeTraceStatement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstransformationPackage.MAPPING_RULE__WRITE_TRACE_STATEMENT, null, msgs);
				return basicSetWriteTraceStatement((WriteTrace)otherEnd, msgs);
			case AstransformationPackage.MAPPING_RULE__RESOLVE_OBJECT_STATEMENTS:
				return ((InternalEList)getResolveObjectStatements()).basicAdd(otherEnd, msgs);
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
			case AstransformationPackage.MAPPING_RULE__PARAMETER:
				return basicSetParameter(null, msgs);
			case AstransformationPackage.MAPPING_RULE__RESULT:
				return basicSetResult(null, msgs);
			case AstransformationPackage.MAPPING_RULE__ASSIGN_ATTRIBUTE_STATEMENTS:
				return ((InternalEList)getAssignAttributeStatements()).basicRemove(otherEnd, msgs);
			case AstransformationPackage.MAPPING_RULE__ASSIGN_REFERENCE_STATEMENTS:
				return ((InternalEList)getAssignReferenceStatements()).basicRemove(otherEnd, msgs);
			case AstransformationPackage.MAPPING_RULE__WRITE_TRACE_STATEMENT:
				return basicSetWriteTraceStatement(null, msgs);
			case AstransformationPackage.MAPPING_RULE__RESOLVE_OBJECT_STATEMENTS:
				return ((InternalEList)getResolveObjectStatements()).basicRemove(otherEnd, msgs);
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
			case AstransformationPackage.MAPPING_RULE__NAME:
				return getName();
			case AstransformationPackage.MAPPING_RULE__PARAMETER:
				return getParameter();
			case AstransformationPackage.MAPPING_RULE__RESULT:
				return getResult();
			case AstransformationPackage.MAPPING_RULE__ASSIGN_ATTRIBUTE_STATEMENTS:
				return getAssignAttributeStatements();
			case AstransformationPackage.MAPPING_RULE__ASSIGN_REFERENCE_STATEMENTS:
				return getAssignReferenceStatements();
			case AstransformationPackage.MAPPING_RULE__WRITE_TRACE_STATEMENT:
				return getWriteTraceStatement();
			case AstransformationPackage.MAPPING_RULE__RESOLVE_OBJECT_STATEMENTS:
				return getResolveObjectStatements();
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
			case AstransformationPackage.MAPPING_RULE__NAME:
				setName((String)newValue);
				return;
			case AstransformationPackage.MAPPING_RULE__PARAMETER:
				setParameter((Parameter)newValue);
				return;
			case AstransformationPackage.MAPPING_RULE__RESULT:
				setResult((Parameter)newValue);
				return;
			case AstransformationPackage.MAPPING_RULE__ASSIGN_ATTRIBUTE_STATEMENTS:
				getAssignAttributeStatements().clear();
				getAssignAttributeStatements().addAll((Collection)newValue);
				return;
			case AstransformationPackage.MAPPING_RULE__ASSIGN_REFERENCE_STATEMENTS:
				getAssignReferenceStatements().clear();
				getAssignReferenceStatements().addAll((Collection)newValue);
				return;
			case AstransformationPackage.MAPPING_RULE__WRITE_TRACE_STATEMENT:
				setWriteTraceStatement((WriteTrace)newValue);
				return;
			case AstransformationPackage.MAPPING_RULE__RESOLVE_OBJECT_STATEMENTS:
				getResolveObjectStatements().clear();
				getResolveObjectStatements().addAll((Collection)newValue);
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
			case AstransformationPackage.MAPPING_RULE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AstransformationPackage.MAPPING_RULE__PARAMETER:
				setParameter((Parameter)null);
				return;
			case AstransformationPackage.MAPPING_RULE__RESULT:
				setResult((Parameter)null);
				return;
			case AstransformationPackage.MAPPING_RULE__ASSIGN_ATTRIBUTE_STATEMENTS:
				getAssignAttributeStatements().clear();
				return;
			case AstransformationPackage.MAPPING_RULE__ASSIGN_REFERENCE_STATEMENTS:
				getAssignReferenceStatements().clear();
				return;
			case AstransformationPackage.MAPPING_RULE__WRITE_TRACE_STATEMENT:
				setWriteTraceStatement((WriteTrace)null);
				return;
			case AstransformationPackage.MAPPING_RULE__RESOLVE_OBJECT_STATEMENTS:
				getResolveObjectStatements().clear();
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
			case AstransformationPackage.MAPPING_RULE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AstransformationPackage.MAPPING_RULE__PARAMETER:
				return parameter != null;
			case AstransformationPackage.MAPPING_RULE__RESULT:
				return result != null;
			case AstransformationPackage.MAPPING_RULE__ASSIGN_ATTRIBUTE_STATEMENTS:
				return assignAttributeStatements != null && !assignAttributeStatements.isEmpty();
			case AstransformationPackage.MAPPING_RULE__ASSIGN_REFERENCE_STATEMENTS:
				return assignReferenceStatements != null && !assignReferenceStatements.isEmpty();
			case AstransformationPackage.MAPPING_RULE__WRITE_TRACE_STATEMENT:
				return writeTraceStatement != null;
			case AstransformationPackage.MAPPING_RULE__RESOLVE_OBJECT_STATEMENTS:
				return resolveObjectStatements != null && !resolveObjectStatements.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //MappingRuleImpl