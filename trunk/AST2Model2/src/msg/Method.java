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
 * A representation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link msg.Method#getThrows <em>Throws</em>}</li>
 *   <li>{@link msg.Method#getFormalParameters <em>Formal Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see msg.MsgPackage#getMethod()
 * @model
 * @generated
 */
public interface Method extends Member {
	/**
	 * Returns the value of the '<em><b>Throws</b></em>' reference list.
	 * The list contents are of type {@link msg.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Throws</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Throws</em>' reference list.
	 * @see msg.MsgPackage#getMethod_Throws()
	 * @model type="msg.Class"
	 * @generated
	 */
	EList getThrows();

	/**
	 * Returns the value of the '<em><b>Formal Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link msg.FormalParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formal Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formal Parameters</em>' containment reference list.
	 * @see msg.MsgPackage#getMethod_FormalParameters()
	 * @model type="msg.FormalParameter" containment="true"
	 * @generated
	 */
	EList getFormalParameters();

} // Method