/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransformation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see astransformation.AstransformationPackage
 * @generated
 */
public interface AstransformationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AstransformationFactory eINSTANCE = astransformation.impl.AstransformationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transformation</em>'.
	 * @generated
	 */
	Transformation createTransformation();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns a new object of class '<em>Mapping Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Rule</em>'.
	 * @generated
	 */
	MappingRule createMappingRule();

	/**
	 * Returns a new object of class '<em>Assign Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assign Attribute</em>'.
	 * @generated
	 */
	AssignAttribute createAssignAttribute();

	/**
	 * Returns a new object of class '<em>Assign Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assign Reference</em>'.
	 * @generated
	 */
	AssignReference createAssignReference();

	/**
	 * Returns a new object of class '<em>Write Trace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Write Trace</em>'.
	 * @generated
	 */
	WriteTrace createWriteTrace();

	/**
	 * Returns a new object of class '<em>Resolve Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resolve Object</em>'.
	 * @generated
	 */
	ResolveObject createResolveObject();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AstransformationPackage getAstransformationPackage();

} //AstransformationFactory
