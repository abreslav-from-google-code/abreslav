/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransast;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Change Inheritance AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link astransast.ChangeInheritanceAS#getTargetProto <em>Target Proto</em>}</li>
 *   <li>{@link astransast.ChangeInheritanceAS#getSuperclasses <em>Superclasses</em>}</li>
 * </ul>
 * </p>
 *
 * @see astransast.AstransastPackage#getChangeInheritanceAS()
 * @model
 * @generated
 */
public interface ChangeInheritanceAS extends ActionAS {
	/**
	 * Returns the value of the '<em><b>Target Proto</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Proto</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Proto</em>' containment reference.
	 * @see #setTargetProto(QualifiedName)
	 * @see astransast.AstransastPackage#getChangeInheritanceAS_TargetProto()
	 * @model containment="true" required="true"
	 * @generated
	 */
	QualifiedName getTargetProto();

	/**
	 * Sets the value of the '{@link astransast.ChangeInheritanceAS#getTargetProto <em>Target Proto</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Proto</em>' containment reference.
	 * @see #getTargetProto()
	 * @generated
	 */
	void setTargetProto(QualifiedName value);

	/**
	 * Returns the value of the '<em><b>Superclasses</b></em>' containment reference list.
	 * The list contents are of type {@link astransast.EClassifierReferenceAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Superclasses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Superclasses</em>' containment reference list.
	 * @see astransast.AstransastPackage#getChangeInheritanceAS_Superclasses()
	 * @model type="astransast.EClassifierReferenceAS" containment="true"
	 * @generated
	 */
	EList getSuperclasses();

} // ChangeInheritanceAS