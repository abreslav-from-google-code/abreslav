/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransformation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assign Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link astransformation.AssignReference#getMappingRule <em>Mapping Rule</em>}</li>
 *   <li>{@link astransformation.AssignReference#getSource <em>Source</em>}</li>
 *   <li>{@link astransformation.AssignReference#getDest <em>Dest</em>}</li>
 *   <li>{@link astransformation.AssignReference#isMappingNeeded <em>Mapping Needed</em>}</li>
 * </ul>
 * </p>
 *
 * @see astransformation.AstransformationPackage#getAssignReference()
 * @model
 * @generated
 */
public interface AssignReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Mapping Rule</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link astransformation.MappingRule#getAssignReferenceStatements <em>Assign Reference Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Rule</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Rule</em>' container reference.
	 * @see #setMappingRule(MappingRule)
	 * @see astransformation.AstransformationPackage#getAssignReference_MappingRule()
	 * @see astransformation.MappingRule#getAssignReferenceStatements
	 * @model opposite="assignReferenceStatements" required="true"
	 * @generated
	 */
	MappingRule getMappingRule();

	/**
	 * Sets the value of the '{@link astransformation.AssignReference#getMappingRule <em>Mapping Rule</em>}' container reference.
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
	 * @see #setSource(EReference)
	 * @see astransformation.AstransformationPackage#getAssignReference_Source()
	 * @model required="true"
	 * @generated
	 */
	EReference getSource();

	/**
	 * Sets the value of the '{@link astransformation.AssignReference#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(EReference value);

	/**
	 * Returns the value of the '<em><b>Dest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dest</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dest</em>' reference.
	 * @see #setDest(EReference)
	 * @see astransformation.AstransformationPackage#getAssignReference_Dest()
	 * @model required="true"
	 * @generated
	 */
	EReference getDest();

	/**
	 * Sets the value of the '{@link astransformation.AssignReference#getDest <em>Dest</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dest</em>' reference.
	 * @see #getDest()
	 * @generated
	 */
	void setDest(EReference value);

	/**
	 * Returns the value of the '<em><b>Mapping Needed</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Needed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Needed</em>' attribute.
	 * @see #setMappingNeeded(boolean)
	 * @see astransformation.AstransformationPackage#getAssignReference_MappingNeeded()
	 * @model default="true"
	 * @generated
	 */
	boolean isMappingNeeded();

	/**
	 * Sets the value of the '{@link astransformation.AssignReference#isMappingNeeded <em>Mapping Needed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Needed</em>' attribute.
	 * @see #isMappingNeeded()
	 * @generated
	 */
	void setMappingNeeded(boolean value);

} // AssignReference