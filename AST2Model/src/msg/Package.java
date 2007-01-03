/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package msg;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link msg.Package#getClasses <em>Classes</em>}</li>
 *   <li>{@link msg.Package#getSubpackages <em>Subpackages</em>}</li>
 * </ul>
 * </p>
 *
 * @see msg.MsgPackage#getPackage()
 * @model
 * @generated
 */
public interface Package extends Named {
	/**
	 * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
	 * The list contents are of type {@link msg.Class}.
	 * It is bidirectional and its opposite is '{@link msg.Class#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' containment reference list.
	 * @see msg.MsgPackage#getPackage_Classes()
	 * @see msg.Class#getPackage
	 * @model type="msg.Class" opposite="package" containment="true"
	 * @generated
	 */
	EList getClasses();

	/**
	 * Returns the value of the '<em><b>Subpackages</b></em>' containment reference list.
	 * The list contents are of type {@link msg.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subpackages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subpackages</em>' containment reference list.
	 * @see msg.MsgPackage#getPackage_Subpackages()
	 * @model type="msg.Package" containment="true"
	 * @generated
	 */
	EList getSubpackages();

} // Package