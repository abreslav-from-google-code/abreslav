/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransformation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resolve Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link astransformation.ResolveObject#getMappingRule <em>Mapping Rule</em>}</li>
 *   <li>{@link astransformation.ResolveObject#getSource <em>Source</em>}</li>
 *   <li>{@link astransformation.ResolveObject#getDest <em>Dest</em>}</li>
 *   <li>{@link astransformation.ResolveObject#getResolverMethodName <em>Resolver Method Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see astransformation.AstransformationPackage#getResolveObject()
 * @model
 * @generated
 */
public interface ResolveObject extends EObject {
	/**
	 * Returns the value of the '<em><b>Mapping Rule</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link astransformation.MappingRule#getResolveObjectStatements <em>Resolve Object Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Rule</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Rule</em>' container reference.
	 * @see #setMappingRule(MappingRule)
	 * @see astransformation.AstransformationPackage#getResolveObject_MappingRule()
	 * @see astransformation.MappingRule#getResolveObjectStatements
	 * @model opposite="resolveObjectStatements" required="true"
	 * @generated
	 */
	MappingRule getMappingRule();

	/**
	 * Sets the value of the '{@link astransformation.ResolveObject#getMappingRule <em>Mapping Rule</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Rule</em>' container reference.
	 * @see #getMappingRule()
	 * @generated
	 */
	void setMappingRule(MappingRule value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(EStructuralFeature)
	 * @see astransformation.AstransformationPackage#getResolveObject_Source()
	 * @model required="true"
	 * @generated
	 */
	EStructuralFeature getSource();

	/**
	 * Sets the value of the '{@link astransformation.ResolveObject#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Dest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dest</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dest</em>' reference.
	 * @see #setDest(EReference)
	 * @see astransformation.AstransformationPackage#getResolveObject_Dest()
	 * @model required="true"
	 * @generated
	 */
	EReference getDest();

	/**
	 * Sets the value of the '{@link astransformation.ResolveObject#getDest <em>Dest</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dest</em>' reference.
	 * @see #getDest()
	 * @generated
	 */
	void setDest(EReference value);

	/**
	 * Returns the value of the '<em><b>Resolver Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolver Method Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolver Method Name</em>' attribute.
	 * @see #setResolverMethodName(String)
	 * @see astransformation.AstransformationPackage#getResolveObject_ResolverMethodName()
	 * @model required="true"
	 * @generated
	 */
	String getResolverMethodName();

	/**
	 * Sets the value of the '{@link astransformation.ResolveObject#getResolverMethodName <em>Resolver Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolver Method Name</em>' attribute.
	 * @see #getResolverMethodName()
	 * @generated
	 */
	void setResolverMethodName(String value);

} // ResolveObject