/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astrans;


import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapped EClass</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link astrans.MappedEClass#getProto <em>Proto</em>}</li>
 * </ul>
 * </p>
 *
 * @see astrans.AstransPackage#getMappedEClass()
 * @model
 * @generated
 */
public interface MappedEClass extends EClassReference {
	/**
	 * Returns the value of the '<em><b>Proto</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proto</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proto</em>' reference.
	 * @see #setProto(EClass)
	 * @see astrans.AstransPackage#getMappedEClass_Proto()
	 * @model required="true"
	 * @generated
	 */
	EClass getProto();

	/**
	 * Sets the value of the '{@link astrans.MappedEClass#getProto <em>Proto</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proto</em>' reference.
	 * @see #getProto()
	 * @generated
	 */
	void setProto(EClass value);

} // MappedEClass