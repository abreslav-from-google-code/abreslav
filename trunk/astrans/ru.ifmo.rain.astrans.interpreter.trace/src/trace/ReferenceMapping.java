/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package trace;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link trace.ReferenceMapping#getProto <em>Proto</em>}</li>
 *   <li>{@link trace.ReferenceMapping#getImage <em>Image</em>}</li>
 *   <li>{@link trace.ReferenceMapping#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see trace.TracePackage#getReferenceMapping()
 * @model
 * @generated
 */
public interface ReferenceMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Proto</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proto</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proto</em>' reference.
	 * @see #setProto(EReference)
	 * @see trace.TracePackage#getReferenceMapping_Proto()
	 * @model required="true"
	 * @generated
	 */
	EReference getProto();

	/**
	 * Sets the value of the '{@link trace.ReferenceMapping#getProto <em>Proto</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proto</em>' reference.
	 * @see #getProto()
	 * @generated
	 */
	void setProto(EReference value);

	/**
	 * Returns the value of the '<em><b>Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image</em>' reference.
	 * @see #setImage(EStructuralFeature)
	 * @see trace.TracePackage#getReferenceMapping_Image()
	 * @model required="true"
	 * @generated
	 */
	EStructuralFeature getImage();

	/**
	 * Sets the value of the '{@link trace.ReferenceMapping#getImage <em>Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image</em>' reference.
	 * @see #getImage()
	 * @generated
	 */
	void setImage(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link trace.ReferenceMappingType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see trace.ReferenceMappingType
	 * @see #setType(ReferenceMappingType)
	 * @see trace.TracePackage#getReferenceMapping_Type()
	 * @model
	 * @generated
	 */
	ReferenceMappingType getType();

	/**
	 * Sets the value of the '{@link trace.ReferenceMapping#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see trace.ReferenceMappingType
	 * @see #getType()
	 * @generated
	 */
	void setType(ReferenceMappingType value);

} // ReferenceMapping