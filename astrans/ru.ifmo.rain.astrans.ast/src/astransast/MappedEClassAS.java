/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransast;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapped EClass AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link astransast.MappedEClassAS#getProto <em>Proto</em>}</li>
 * </ul>
 * </p>
 *
 * @see astransast.AstransastPackage#getMappedEClassAS()
 * @model
 * @generated
 */
public interface MappedEClassAS extends EClassifierReferenceAS {
	/**
	 * Returns the value of the '<em><b>Proto</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proto</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proto</em>' containment reference.
	 * @see #setProto(QualifiedName)
	 * @see astransast.AstransastPackage#getMappedEClassAS_Proto()
	 * @model containment="true" required="true"
	 * @generated
	 */
	QualifiedName getProto();

	/**
	 * Sets the value of the '{@link astransast.MappedEClassAS#getProto <em>Proto</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proto</em>' containment reference.
	 * @see #getProto()
	 * @generated
	 */
	void setProto(QualifiedName value);

} // MappedEClassAS