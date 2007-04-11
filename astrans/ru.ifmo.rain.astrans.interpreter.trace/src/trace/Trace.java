/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package trace;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link trace.Trace#getClassMappings <em>Class Mappings</em>}</li>
 *   <li>{@link trace.Trace#getAttributeMappings <em>Attribute Mappings</em>}</li>
 *   <li>{@link trace.Trace#getReferenceMappings <em>Reference Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see trace.TracePackage#getTrace()
 * @model
 * @generated
 */
public interface Trace extends EObject {
	/**
	 * Returns the value of the '<em><b>Class Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link trace.ClassMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Mappings</em>' containment reference list.
	 * @see trace.TracePackage#getTrace_ClassMappings()
	 * @model type="trace.ClassMapping" containment="true"
	 * @generated
	 */
	EList getClassMappings();

	/**
	 * Returns the value of the '<em><b>Attribute Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link trace.AttributeMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Mappings</em>' containment reference list.
	 * @see trace.TracePackage#getTrace_AttributeMappings()
	 * @model type="trace.AttributeMapping" containment="true"
	 * @generated
	 */
	EList getAttributeMappings();

	/**
	 * Returns the value of the '<em><b>Reference Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link trace.ReferenceMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Mappings</em>' containment reference list.
	 * @see trace.TracePackage#getTrace_ReferenceMappings()
	 * @model type="trace.ReferenceMapping" containment="true"
	 * @generated
	 */
	EList getReferenceMappings();

} // Trace