/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransast;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see astransast.AstransastPackage
 * @generated
 */
public interface AstransastFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AstransastFactory eINSTANCE = astransast.impl.AstransastFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Translate References AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Translate References AS</em>'.
	 * @generated
	 */
	TranslateReferencesAS createTranslateReferencesAS();

	/**
	 * Returns a new object of class '<em>Create Class AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Class AS</em>'.
	 * @generated
	 */
	CreateClassAS createCreateClassAS();

	/**
	 * Returns a new object of class '<em>Attribute AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute AS</em>'.
	 * @generated
	 */
	AttributeAS createAttributeAS();

	/**
	 * Returns a new object of class '<em>Reference AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference AS</em>'.
	 * @generated
	 */
	ReferenceAS createReferenceAS();

	/**
	 * Returns a new object of class '<em>Change Inheritance AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Change Inheritance AS</em>'.
	 * @generated
	 */
	ChangeInheritanceAS createChangeInheritanceAS();

	/**
	 * Returns a new object of class '<em>Skip Class AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Skip Class AS</em>'.
	 * @generated
	 */
	SkipClassAS createSkipClassAS();

	/**
	 * Returns a new object of class '<em>Transformation AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transformation AS</em>'.
	 * @generated
	 */
	TransformationAS createTransformationAS();

	/**
	 * Returns a new object of class '<em>Mapped EClass AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapped EClass AS</em>'.
	 * @generated
	 */
	MappedEClassAS createMappedEClassAS();

	/**
	 * Returns a new object of class '<em>Qualified Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Qualified Name</em>'.
	 * @generated
	 */
	QualifiedName createQualifiedName();

	/**
	 * Returns a new object of class '<em>EPackage Uri</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EPackage Uri</em>'.
	 * @generated
	 */
	EPackageUri createEPackageUri();

	/**
	 * Returns a new object of class '<em>EPackage Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EPackage Path</em>'.
	 * @generated
	 */
	EPackagePath createEPackagePath();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AstransastPackage getAstransastPackage();

} //AstransastFactory
