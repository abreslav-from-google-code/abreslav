/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astrans;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapped EClass</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link astrans.MappedEClass#getMapping <em>Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see astrans.AstransPackage#getMappedEClass()
 * @model
 * @generated
 */
public interface MappedEClass extends EClassReference {
	/**
	 * Returns the value of the '<em><b>Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping</em>' reference.
	 * @see #setMapping(MapClass)
	 * @see astrans.AstransPackage#getMappedEClass_Mapping()
	 * @model required="true"
	 * @generated
	 */
	MapClass getMapping();

	/**
	 * Sets the value of the '{@link astrans.MappedEClass#getMapping <em>Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping</em>' reference.
	 * @see #getMapping()
	 * @generated
	 */
	void setMapping(MapClass value);

} // MappedEClass