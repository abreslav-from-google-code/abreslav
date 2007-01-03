/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package msg;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link msg.BasicType#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see msg.MsgPackage#getBasicType()
 * @model
 * @generated
 */
public interface BasicType extends Type {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link msg.BasicTypes}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see msg.BasicTypes
	 * @see #setType(BasicTypes)
	 * @see msg.MsgPackage#getBasicType_Type()
	 * @model
	 * @generated
	 */
	BasicTypes getType();

	/**
	 * Sets the value of the '{@link msg.BasicType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see msg.BasicTypes
	 * @see #getType()
	 * @generated
	 */
	void setType(BasicTypes value);

} // BasicType