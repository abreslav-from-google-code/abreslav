/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransformation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link astransformation.Transformation#getMappingRules <em>Mapping Rules</em>}</li>
 *   <li>{@link astransformation.Transformation#getMain <em>Main</em>}</li>
 *   <li>{@link astransformation.Transformation#getResolverClassName <em>Resolver Class Name</em>}</li>
 *   <li>{@link astransformation.Transformation#getTraceClassName <em>Trace Class Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see astransformation.AstransformationPackage#getTransformation()
 * @model
 * @generated
 */
public interface Transformation extends Named {
	/**
	 * Returns the value of the '<em><b>Mapping Rules</b></em>' containment reference list.
	 * The list contents are of type {@link astransformation.MappingRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Rules</em>' containment reference list.
	 * @see astransformation.AstransformationPackage#getTransformation_MappingRules()
	 * @model type="astransformation.MappingRule" containment="true"
	 * @generated
	 */
	EList getMappingRules();

	/**
	 * Returns the value of the '<em><b>Main</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main</em>' reference.
	 * @see #setMain(MappingRule)
	 * @see astransformation.AstransformationPackage#getTransformation_Main()
	 * @model required="true"
	 * @generated
	 */
	MappingRule getMain();

	/**
	 * Sets the value of the '{@link astransformation.Transformation#getMain <em>Main</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main</em>' reference.
	 * @see #getMain()
	 * @generated
	 */
	void setMain(MappingRule value);

	/**
	 * Returns the value of the '<em><b>Resolver Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolver Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolver Class Name</em>' attribute.
	 * @see #setResolverClassName(String)
	 * @see astransformation.AstransformationPackage#getTransformation_ResolverClassName()
	 * @model required="true"
	 * @generated
	 */
	String getResolverClassName();

	/**
	 * Sets the value of the '{@link astransformation.Transformation#getResolverClassName <em>Resolver Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolver Class Name</em>' attribute.
	 * @see #getResolverClassName()
	 * @generated
	 */
	void setResolverClassName(String value);

	/**
	 * Returns the value of the '<em><b>Trace Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace Class Name</em>' attribute.
	 * @see #setTraceClassName(String)
	 * @see astransformation.AstransformationPackage#getTransformation_TraceClassName()
	 * @model required="true"
	 * @generated
	 */
	String getTraceClassName();

	/**
	 * Sets the value of the '{@link astransformation.Transformation#getTraceClassName <em>Trace Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace Class Name</em>' attribute.
	 * @see #getTraceClassName()
	 * @generated
	 */
	void setTraceClassName(String value);

} // Transformation