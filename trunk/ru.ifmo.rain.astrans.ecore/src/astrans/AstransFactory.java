/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astrans;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see astrans.AstransPackage
 * @generated
 */
public interface AstransFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AstransFactory eINSTANCE = astrans.impl.AstransFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Created EClass</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Created EClass</em>'.
	 * @generated
	 */
	CreatedEClass createCreatedEClass();

	/**
	 * Returns a new object of class '<em>Mapped EClass</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapped EClass</em>'.
	 * @generated
	 */
	MappedEClass createMappedEClass();

	/**
	 * Returns a new object of class '<em>Existing EClass</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Existing EClass</em>'.
	 * @generated
	 */
	ExistingEClass createExistingEClass();

	/**
	 * Returns a new object of class '<em>Existing EData Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Existing EData Type</em>'.
	 * @generated
	 */
	ExistingEDataType createExistingEDataType();

	/**
	 * Returns a new object of class '<em>Translate References</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Translate References</em>'.
	 * @generated
	 */
	TranslateReferences createTranslateReferences();

	/**
	 * Returns a new object of class '<em>Create Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Class</em>'.
	 * @generated
	 */
	CreateClass createCreateClass();

	/**
	 * Returns a new object of class '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute</em>'.
	 * @generated
	 */
	Attribute createAttribute();

	/**
	 * Returns a new object of class '<em>Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference</em>'.
	 * @generated
	 */
	Reference createReference();

	/**
	 * Returns a new object of class '<em>Change Inheritance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Change Inheritance</em>'.
	 * @generated
	 */
	ChangeInheritance createChangeInheritance();

	/**
	 * Returns a new object of class '<em>Skip Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Skip Class</em>'.
	 * @generated
	 */
	SkipClass createSkipClass();

	/**
	 * Returns a new object of class '<em>Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transformation</em>'.
	 * @generated
	 */
	Transformation createTransformation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AstransPackage getAstransPackage();

} //AstransFactory
