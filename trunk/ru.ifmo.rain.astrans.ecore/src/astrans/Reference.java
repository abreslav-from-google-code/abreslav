/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astrans;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link astrans.Reference#getType <em>Type</em>}</li>
 *   <li>{@link astrans.Reference#isContainment <em>Containment</em>}</li>
 * </ul>
 * </p>
 *
 * @see astrans.AstransPackage#getReference()
 * @model
 * @generated
 */
public interface Reference extends StructuralFeature {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(EClassReference)
	 * @see astrans.AstransPackage#getReference_Type()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EClassReference getType();

	/**
	 * Sets the value of the '{@link astrans.Reference#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EClassReference value);

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
	 * @see astrans.AstransPackage#getReference_Containment()
	 * @model default="false"
	 * @generated
	 */
	boolean isContainment();

	/**
	 * Sets the value of the '{@link astrans.Reference#isContainment <em>Containment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containment</em>' attribute.
	 * @see #isContainment()
	 * @generated
	 */
	void setContainment(boolean value);

} // Reference