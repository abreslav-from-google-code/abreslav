/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransast;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Skip Class AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link astransast.SkipClassAS#isIncludeDescendants <em>Include Descendants</em>}</li>
 *   <li>{@link astransast.SkipClassAS#getTargetProto <em>Target Proto</em>}</li>
 * </ul>
 * </p>
 *
 * @see astransast.AstransastPackage#getSkipClassAS()
 * @model
 * @generated
 */
public interface SkipClassAS extends ActionAS {
	/**
	 * Returns the value of the '<em><b>Include Descendants</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Include Descendants</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Include Descendants</em>' attribute.
	 * @see #setIncludeDescendants(boolean)
	 * @see astransast.AstransastPackage#getSkipClassAS_IncludeDescendants()
	 * @model default="false"
	 * @generated
	 */
	boolean isIncludeDescendants();

	/**
	 * Sets the value of the '{@link astransast.SkipClassAS#isIncludeDescendants <em>Include Descendants</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Include Descendants</em>' attribute.
	 * @see #isIncludeDescendants()
	 * @generated
	 */
	void setIncludeDescendants(boolean value);

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
	 * @see astransast.AstransastPackage#getSkipClassAS_TargetProto()
	 * @model containment="true" required="true"
	 * @generated
	 */
	QualifiedName getTargetProto();

	/**
	 * Sets the value of the '{@link astransast.SkipClassAS#getTargetProto <em>Target Proto</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Proto</em>' containment reference.
	 * @see #getTargetProto()
	 * @generated
	 */
	void setTargetProto(QualifiedName value);

} // SkipClassAS