/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astrans;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Change Inheritance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link astrans.ChangeInheritance#getTargetProto <em>Target Proto</em>}</li>
 *   <li>{@link astrans.ChangeInheritance#getSuperclasses <em>Superclasses</em>}</li>
 * </ul>
 * </p>
 *
 * @see astrans.AstransPackage#getChangeInheritance()
 * @model
 * @generated
 */
public interface ChangeInheritance extends Action {
	/**
	 * Returns the value of the '<em><b>Target Proto</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Proto</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Proto</em>' reference.
	 * @see #setTargetProto(EClass)
	 * @see astrans.AstransPackage#getChangeInheritance_TargetProto()
	 * @model required="true"
	 * @generated
	 */
	EClass getTargetProto();

	/**
	 * Sets the value of the '{@link astrans.ChangeInheritance#getTargetProto <em>Target Proto</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Proto</em>' reference.
	 * @see #getTargetProto()
	 * @generated
	 */
	void setTargetProto(EClass value);

	/**
	 * Returns the value of the '<em><b>Superclasses</b></em>' containment reference list.
	 * The list contents are of type {@link astrans.EClassReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Superclasses</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Superclasses</em>' containment reference list.
	 * @see astrans.AstransPackage#getChangeInheritance_Superclasses()
	 * @model type="astrans.EClassReference" containment="true"
	 * @generated
	 */
	EList getSuperclasses();

} // ChangeInheritance