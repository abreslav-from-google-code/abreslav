/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransast;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EPackage Uri</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link astransast.EPackageUri#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see astransast.AstransastPackage#getEPackageUri()
 * @model
 * @generated
 */
public interface EPackageUri extends EPackageReference {
	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see astransast.AstransastPackage#getEPackageUri_Uri()
	 * @model required="true"
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link astransast.EPackageUri#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

} // EPackageUri