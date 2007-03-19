/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransast;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link astransast.AttributeAS#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see astransast.AstransastPackage#getAttributeAS()
 * @model
 * @generated
 */
public interface AttributeAS extends StructuralFeatureAS {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(QualifiedName)
	 * @see astransast.AstransastPackage#getAttributeAS_Type()
	 * @model containment="true" required="true"
	 * @generated
	 */
	QualifiedName getType();

	/**
	 * Sets the value of the '{@link astransast.AttributeAS#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(QualifiedName value);

} // AttributeAS