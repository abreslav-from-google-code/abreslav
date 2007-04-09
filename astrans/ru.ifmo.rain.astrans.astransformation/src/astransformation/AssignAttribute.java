/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransformation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assign Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link astransformation.AssignAttribute#getMappingRule <em>Mapping Rule</em>}</li>
 *   <li>{@link astransformation.AssignAttribute#getSource <em>Source</em>}</li>
 *   <li>{@link astransformation.AssignAttribute#getDest <em>Dest</em>}</li>
 * </ul>
 * </p>
 *
 * @see astransformation.AstransformationPackage#getAssignAttribute()
 * @model
 * @generated
 */
public interface AssignAttribute extends EObject {
	/**
	 * Returns the value of the '<em><b>Mapping Rule</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link astransformation.MappingRule#getAssignAttributeStatements <em>Assign Attribute Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Rule</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Rule</em>' container reference.
	 * @see #setMappingRule(MappingRule)
	 * @see astransformation.AstransformationPackage#getAssignAttribute_MappingRule()
	 * @see astransformation.MappingRule#getAssignAttributeStatements
	 * @model opposite="assignAttributeStatements" required="true"
	 * @generated
	 */
	MappingRule getMappingRule();

	/**
	 * Sets the value of the '{@link astransformation.AssignAttribute#getMappingRule <em>Mapping Rule</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Rule</em>' container reference.
	 * @see #getMappingRule()
	 * @generated
	 */
	void setMappingRule(MappingRule value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(EAttribute)
	 * @see astransformation.AstransformationPackage#getAssignAttribute_Source()
	 * @model required="true"
	 * @generated
	 */
	EAttribute getSource();

	/**
	 * Sets the value of the '{@link astransformation.AssignAttribute#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(EAttribute value);

	/**
	 * Returns the value of the '<em><b>Dest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dest</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dest</em>' reference.
	 * @see #setDest(EAttribute)
	 * @see astransformation.AstransformationPackage#getAssignAttribute_Dest()
	 * @model required="true"
	 * @generated
	 */
	EAttribute getDest();

	/**
	 * Sets the value of the '{@link astransformation.AssignAttribute#getDest <em>Dest</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dest</em>' reference.
	 * @see #getDest()
	 * @generated
	 */
	void setDest(EAttribute value);

} // AssignAttribute