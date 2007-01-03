/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package msg;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link msg.Class#getPackage <em>Package</em>}</li>
 *   <li>{@link msg.Class#getSuper <em>Super</em>}</li>
 *   <li>{@link msg.Class#getMembers <em>Members</em>}</li>
 * </ul>
 * </p>
 *
 * @see msg.MsgPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends Type, Named {
	/**
	 * Returns the value of the '<em><b>Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link msg.Package#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' container reference.
	 * @see #setPackage(msg.Package)
	 * @see msg.MsgPackage#getClass_Package()
	 * @see msg.Package#getClasses
	 * @model opposite="classes"
	 * @generated
	 */
	msg.Package getPackage();

	/**
	 * Sets the value of the '{@link msg.Class#getPackage <em>Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' container reference.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(msg.Package value);

	/**
	 * Returns the value of the '<em><b>Super</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super</em>' reference.
	 * @see #setSuper(Class)
	 * @see msg.MsgPackage#getClass_Super()
	 * @model
	 * @generated
	 */
	Class getSuper();

	/**
	 * Sets the value of the '{@link msg.Class#getSuper <em>Super</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super</em>' reference.
	 * @see #getSuper()
	 * @generated
	 */
	void setSuper(Class value);

	/**
	 * Returns the value of the '<em><b>Members</b></em>' containment reference list.
	 * The list contents are of type {@link msg.Member}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' containment reference list.
	 * @see msg.MsgPackage#getClass_Members()
	 * @model type="msg.Member" containment="true"
	 * @generated
	 */
	EList getMembers();

} // Class