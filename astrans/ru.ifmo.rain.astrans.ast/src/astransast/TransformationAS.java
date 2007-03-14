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
 * A representation of the model object '<em><b>Transformation AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link astransast.TransformationAS#getActions <em>Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @see astransast.AstransastPackage#getTransformationAS()
 * @model
 * @generated
 */
public interface TransformationAS extends EObject {
	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link astransast.ActionAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see astransast.AstransastPackage#getTransformationAS_Actions()
	 * @model type="astransast.ActionAS" containment="true"
	 * @generated
	 */
	EList getActions();

} // TransformationAS