/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astrans;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Translate References</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link astrans.TranslateReferences#getModelReferenceTypeProto <em>Model Reference Type Proto</em>}</li>
 *   <li>{@link astrans.TranslateReferences#getTextualReferenceType <em>Textual Reference Type</em>}</li>
 *   <li>{@link astrans.TranslateReferences#isIncludeDescendants <em>Include Descendants</em>}</li>
 * </ul>
 * </p>
 *
 * @see astrans.AstransPackage#getTranslateReferences()
 * @model
 * @generated
 */
public interface TranslateReferences extends Action {
	/**
	 * Returns the value of the '<em><b>Model Reference Type Proto</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Reference Type Proto</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Reference Type Proto</em>' reference.
	 * @see #setModelReferenceTypeProto(EClass)
	 * @see astrans.AstransPackage#getTranslateReferences_ModelReferenceTypeProto()
	 * @model required="true"
	 * @generated
	 */
	EClass getModelReferenceTypeProto();

	/**
	 * Sets the value of the '{@link astrans.TranslateReferences#getModelReferenceTypeProto <em>Model Reference Type Proto</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Reference Type Proto</em>' reference.
	 * @see #getModelReferenceTypeProto()
	 * @generated
	 */
	void setModelReferenceTypeProto(EClass value);

	/**
	 * Returns the value of the '<em><b>Textual Reference Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Textual Reference Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Textual Reference Type</em>' containment reference.
	 * @see #setTextualReferenceType(EClassifierReference)
	 * @see astrans.AstransPackage#getTranslateReferences_TextualReferenceType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EClassifierReference getTextualReferenceType();

	/**
	 * Sets the value of the '{@link astrans.TranslateReferences#getTextualReferenceType <em>Textual Reference Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Textual Reference Type</em>' containment reference.
	 * @see #getTextualReferenceType()
	 * @generated
	 */
	void setTextualReferenceType(EClassifierReference value);

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
	 * @see astrans.AstransPackage#getTranslateReferences_IncludeDescendants()
	 * @model default="false"
	 * @generated
	 */
	boolean isIncludeDescendants();

	/**
	 * Sets the value of the '{@link astrans.TranslateReferences#isIncludeDescendants <em>Include Descendants</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Include Descendants</em>' attribute.
	 * @see #isIncludeDescendants()
	 * @generated
	 */
	void setIncludeDescendants(boolean value);

} // TranslateReferences