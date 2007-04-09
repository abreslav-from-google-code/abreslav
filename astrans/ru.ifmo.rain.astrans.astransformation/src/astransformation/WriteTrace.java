/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransformation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Write Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link astransformation.WriteTrace#getMappingRule <em>Mapping Rule</em>}</li>
 *   <li>{@link astransformation.WriteTrace#getTraceMethodName <em>Trace Method Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see astransformation.AstransformationPackage#getWriteTrace()
 * @model
 * @generated
 */
public interface WriteTrace extends EObject {
	/**
	 * Returns the value of the '<em><b>Mapping Rule</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link astransformation.MappingRule#getWriteTraceStatement <em>Write Trace Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Rule</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Rule</em>' container reference.
	 * @see #setMappingRule(MappingRule)
	 * @see astransformation.AstransformationPackage#getWriteTrace_MappingRule()
	 * @see astransformation.MappingRule#getWriteTraceStatement
	 * @model opposite="writeTraceStatement" required="true"
	 * @generated
	 */
	MappingRule getMappingRule();

	/**
	 * Sets the value of the '{@link astransformation.WriteTrace#getMappingRule <em>Mapping Rule</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Rule</em>' container reference.
	 * @see #getMappingRule()
	 * @generated
	 */
	void setMappingRule(MappingRule value);

	/**
	 * Returns the value of the '<em><b>Trace Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace Method Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace Method Name</em>' attribute.
	 * @see #setTraceMethodName(String)
	 * @see astransformation.AstransformationPackage#getWriteTrace_TraceMethodName()
	 * @model required="true"
	 * @generated
	 */
	String getTraceMethodName();

	/**
	 * Sets the value of the '{@link astransformation.WriteTrace#getTraceMethodName <em>Trace Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace Method Name</em>' attribute.
	 * @see #getTraceMethodName()
	 * @generated
	 */
	void setTraceMethodName(String value);

} // WriteTrace