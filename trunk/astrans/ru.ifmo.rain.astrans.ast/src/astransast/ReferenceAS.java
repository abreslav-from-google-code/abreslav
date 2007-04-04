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
 * A representation of the model object '<em><b>Reference AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link astransast.ReferenceAS#isContainment <em>Containment</em>}</li>
 *   <li>{@link astransast.ReferenceAS#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see astransast.AstransastPackage#getReferenceAS()
 * @model
 * @generated
 */
public interface ReferenceAS extends StructuralFeatureAS {
	/**
	 * Returns the value of the '<em><b>Containment</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containment</em>' attribute.
	 * @see #setContainment(boolean)
	 * @see astransast.AstransastPackage#getReferenceAS_Containment()
	 * @model default="false"
	 * @generated
	 */
	boolean isContainment();

	/**
	 * Sets the value of the '{@link astransast.ReferenceAS#isContainment <em>Containment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containment</em>' attribute.
	 * @see #isContainment()
	 * @generated
	 */
	void setContainment(boolean value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(EClassifierReferenceAS)
	 * @see astransast.AstransastPackage#getReferenceAS_Type()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EClassifierReferenceAS getType();

	/**
	 * Sets the value of the '{@link astransast.ReferenceAS#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EClassifierReferenceAS value);

} // ReferenceAS