/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astrans;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see astrans.AstransFactory
 * @model kind="package"
 * @generated
 */
public interface AstransPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "astrans";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://rain.ifmo.ru/~breslav/2007/astrans";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "astrans";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AstransPackage eINSTANCE = astrans.impl.AstransPackageImpl.init();

	/**
	 * The meta object id for the '{@link astrans.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see astrans.impl.ActionImpl
	 * @see astrans.impl.AstransPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 0;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link astrans.impl.EClassifierReferenceImpl <em>EClassifier Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see astrans.impl.EClassifierReferenceImpl
	 * @see astrans.impl.AstransPackageImpl#getEClassifierReference()
	 * @generated
	 */
	int ECLASSIFIER_REFERENCE = 1;

	/**
	 * The number of structural features of the '<em>EClassifier Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASSIFIER_REFERENCE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link astrans.impl.EClassReferenceImpl <em>EClass Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see astrans.impl.EClassReferenceImpl
	 * @see astrans.impl.AstransPackageImpl#getEClassReference()
	 * @generated
	 */
	int ECLASS_REFERENCE = 2;

	/**
	 * The number of structural features of the '<em>EClass Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_REFERENCE_FEATURE_COUNT = ECLASSIFIER_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link astrans.impl.CreatedEClassImpl <em>Created EClass</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see astrans.impl.CreatedEClassImpl
	 * @see astrans.impl.AstransPackageImpl#getCreatedEClass()
	 * @generated
	 */
	int CREATED_ECLASS = 3;

	/**
	 * The feature id for the '<em><b>Create</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATED_ECLASS__CREATE = ECLASS_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Created EClass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATED_ECLASS_FEATURE_COUNT = ECLASS_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link astrans.impl.MappedEClassImpl <em>Mapped EClass</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see astrans.impl.MappedEClassImpl
	 * @see astrans.impl.AstransPackageImpl#getMappedEClass()
	 * @generated
	 */
	int MAPPED_ECLASS = 4;

	/**
	 * The feature id for the '<em><b>Proto</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ECLASS__PROTO = ECLASS_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mapped EClass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ECLASS_FEATURE_COUNT = ECLASS_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link astrans.impl.ExistingEClassImpl <em>Existing EClass</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see astrans.impl.ExistingEClassImpl
	 * @see astrans.impl.AstransPackageImpl#getExistingEClass()
	 * @generated
	 */
	int EXISTING_ECLASS = 5;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTING_ECLASS__ECLASS = ECLASS_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Existing EClass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTING_ECLASS_FEATURE_COUNT = ECLASS_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link astrans.impl.ExistingEDataTypeImpl <em>Existing EData Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see astrans.impl.ExistingEDataTypeImpl
	 * @see astrans.impl.AstransPackageImpl#getExistingEDataType()
	 * @generated
	 */
	int EXISTING_EDATA_TYPE = 6;

	/**
	 * The feature id for the '<em><b>EData Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTING_EDATA_TYPE__EDATA_TYPE = ECLASSIFIER_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Existing EData Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTING_EDATA_TYPE_FEATURE_COUNT = ECLASSIFIER_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link astrans.impl.TranslateReferencesImpl <em>Translate References</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see astrans.impl.TranslateReferencesImpl
	 * @see astrans.impl.AstransPackageImpl#getTranslateReferences()
	 * @generated
	 */
	int TRANSLATE_REFERENCES = 7;

	/**
	 * The feature id for the '<em><b>Model Reference Type Proto</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSLATE_REFERENCES__MODEL_REFERENCE_TYPE_PROTO = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Textual Reference Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSLATE_REFERENCES__TEXTUAL_REFERENCE_TYPE = ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Include Descendants</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSLATE_REFERENCES__INCLUDE_DESCENDANTS = ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Translate References</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSLATE_REFERENCES_FEATURE_COUNT = ACTION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link astrans.impl.CreateClassImpl <em>Create Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see astrans.impl.CreateClassImpl
	 * @see astrans.impl.AstransPackageImpl#getCreateClass()
	 * @generated
	 */
	int CREATE_CLASS = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_CLASS__NAME = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_CLASS__ABSTRACT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Superclasses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_CLASS__SUPERCLASSES = ACTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Structural Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_CLASS__STRUCTURAL_FEATURES = ACTION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Create Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_CLASS_FEATURE_COUNT = ACTION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link astrans.impl.StructuralFeatureImpl <em>Structural Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see astrans.impl.StructuralFeatureImpl
	 * @see astrans.impl.AstransPackageImpl#getStructuralFeature()
	 * @generated
	 */
	int STRUCTURAL_FEATURE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE__LOWER_BOUND = 1;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE__UPPER_BOUND = 2;

	/**
	 * The number of structural features of the '<em>Structural Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link astrans.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see astrans.impl.AttributeImpl
	 * @see astrans.impl.AstransPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = STRUCTURAL_FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__LOWER_BOUND = STRUCTURAL_FEATURE__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__UPPER_BOUND = STRUCTURAL_FEATURE__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__TYPE = STRUCTURAL_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = STRUCTURAL_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link astrans.impl.ReferenceImpl <em>Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see astrans.impl.ReferenceImpl
	 * @see astrans.impl.AstransPackageImpl#getReference()
	 * @generated
	 */
	int REFERENCE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__NAME = STRUCTURAL_FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__LOWER_BOUND = STRUCTURAL_FEATURE__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__UPPER_BOUND = STRUCTURAL_FEATURE__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__TYPE = STRUCTURAL_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Containment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__CONTAINMENT = STRUCTURAL_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_FEATURE_COUNT = STRUCTURAL_FEATURE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link astrans.impl.ChangeInheritanceImpl <em>Change Inheritance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see astrans.impl.ChangeInheritanceImpl
	 * @see astrans.impl.AstransPackageImpl#getChangeInheritance()
	 * @generated
	 */
	int CHANGE_INHERITANCE = 12;

	/**
	 * The feature id for the '<em><b>Target Proto</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_INHERITANCE__TARGET_PROTO = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Superclasses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_INHERITANCE__SUPERCLASSES = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Change Inheritance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_INHERITANCE_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link astrans.impl.SkipClassImpl <em>Skip Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see astrans.impl.SkipClassImpl
	 * @see astrans.impl.AstransPackageImpl#getSkipClass()
	 * @generated
	 */
	int SKIP_CLASS = 13;

	/**
	 * The feature id for the '<em><b>Target Proto</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_CLASS__TARGET_PROTO = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Include Descendants</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_CLASS__INCLUDE_DESCENDANTS = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Skip Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_CLASS_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link astrans.impl.TransformationImpl <em>Transformation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see astrans.impl.TransformationImpl
	 * @see astrans.impl.AstransPackageImpl#getTransformation()
	 * @generated
	 */
	int TRANSFORMATION = 14;

	/**
	 * The feature id for the '<em><b>Create Class Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__CREATE_CLASS_ACTIONS = 0;

	/**
	 * The feature id for the '<em><b>Translate References Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__TRANSLATE_REFERENCES_ACTIONS = 1;

	/**
	 * The feature id for the '<em><b>Change Inheritance Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__CHANGE_INHERITANCE_ACTIONS = 2;

	/**
	 * The feature id for the '<em><b>Skip Class Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__SKIP_CLASS_ACTIONS = 3;

	/**
	 * The feature id for the '<em><b>Input</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__INPUT = 4;

	/**
	 * The feature id for the '<em><b>Output Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__OUTPUT_NAME = 5;

	/**
	 * The feature id for the '<em><b>Output Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__OUTPUT_NS_URI = 6;

	/**
	 * The number of structural features of the '<em>Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_FEATURE_COUNT = 7;


	/**
	 * Returns the meta object for class '{@link astrans.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see astrans.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for class '{@link astrans.EClassifierReference <em>EClassifier Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EClassifier Reference</em>'.
	 * @see astrans.EClassifierReference
	 * @generated
	 */
	EClass getEClassifierReference();

	/**
	 * Returns the meta object for class '{@link astrans.EClassReference <em>EClass Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EClass Reference</em>'.
	 * @see astrans.EClassReference
	 * @generated
	 */
	EClass getEClassReference();

	/**
	 * Returns the meta object for class '{@link astrans.CreatedEClass <em>Created EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Created EClass</em>'.
	 * @see astrans.CreatedEClass
	 * @generated
	 */
	EClass getCreatedEClass();

	/**
	 * Returns the meta object for the reference '{@link astrans.CreatedEClass#getCreate <em>Create</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Create</em>'.
	 * @see astrans.CreatedEClass#getCreate()
	 * @see #getCreatedEClass()
	 * @generated
	 */
	EReference getCreatedEClass_Create();

	/**
	 * Returns the meta object for class '{@link astrans.MappedEClass <em>Mapped EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapped EClass</em>'.
	 * @see astrans.MappedEClass
	 * @generated
	 */
	EClass getMappedEClass();

	/**
	 * Returns the meta object for the reference '{@link astrans.MappedEClass#getProto <em>Proto</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Proto</em>'.
	 * @see astrans.MappedEClass#getProto()
	 * @see #getMappedEClass()
	 * @generated
	 */
	EReference getMappedEClass_Proto();

	/**
	 * Returns the meta object for class '{@link astrans.ExistingEClass <em>Existing EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Existing EClass</em>'.
	 * @see astrans.ExistingEClass
	 * @generated
	 */
	EClass getExistingEClass();

	/**
	 * Returns the meta object for the reference '{@link astrans.ExistingEClass#getEClass <em>EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EClass</em>'.
	 * @see astrans.ExistingEClass#getEClass()
	 * @see #getExistingEClass()
	 * @generated
	 */
	EReference getExistingEClass_EClass();

	/**
	 * Returns the meta object for class '{@link astrans.ExistingEDataType <em>Existing EData Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Existing EData Type</em>'.
	 * @see astrans.ExistingEDataType
	 * @generated
	 */
	EClass getExistingEDataType();

	/**
	 * Returns the meta object for the reference '{@link astrans.ExistingEDataType#getEDataType <em>EData Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EData Type</em>'.
	 * @see astrans.ExistingEDataType#getEDataType()
	 * @see #getExistingEDataType()
	 * @generated
	 */
	EReference getExistingEDataType_EDataType();

	/**
	 * Returns the meta object for class '{@link astrans.TranslateReferences <em>Translate References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Translate References</em>'.
	 * @see astrans.TranslateReferences
	 * @generated
	 */
	EClass getTranslateReferences();

	/**
	 * Returns the meta object for the reference '{@link astrans.TranslateReferences#getModelReferenceTypeProto <em>Model Reference Type Proto</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Reference Type Proto</em>'.
	 * @see astrans.TranslateReferences#getModelReferenceTypeProto()
	 * @see #getTranslateReferences()
	 * @generated
	 */
	EReference getTranslateReferences_ModelReferenceTypeProto();

	/**
	 * Returns the meta object for the containment reference '{@link astrans.TranslateReferences#getTextualReferenceType <em>Textual Reference Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Textual Reference Type</em>'.
	 * @see astrans.TranslateReferences#getTextualReferenceType()
	 * @see #getTranslateReferences()
	 * @generated
	 */
	EReference getTranslateReferences_TextualReferenceType();

	/**
	 * Returns the meta object for the attribute '{@link astrans.TranslateReferences#isIncludeDescendants <em>Include Descendants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Include Descendants</em>'.
	 * @see astrans.TranslateReferences#isIncludeDescendants()
	 * @see #getTranslateReferences()
	 * @generated
	 */
	EAttribute getTranslateReferences_IncludeDescendants();

	/**
	 * Returns the meta object for class '{@link astrans.CreateClass <em>Create Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Class</em>'.
	 * @see astrans.CreateClass
	 * @generated
	 */
	EClass getCreateClass();

	/**
	 * Returns the meta object for the attribute '{@link astrans.CreateClass#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see astrans.CreateClass#getName()
	 * @see #getCreateClass()
	 * @generated
	 */
	EAttribute getCreateClass_Name();

	/**
	 * Returns the meta object for the attribute '{@link astrans.CreateClass#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see astrans.CreateClass#isAbstract()
	 * @see #getCreateClass()
	 * @generated
	 */
	EAttribute getCreateClass_Abstract();

	/**
	 * Returns the meta object for the containment reference list '{@link astrans.CreateClass#getSuperclasses <em>Superclasses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Superclasses</em>'.
	 * @see astrans.CreateClass#getSuperclasses()
	 * @see #getCreateClass()
	 * @generated
	 */
	EReference getCreateClass_Superclasses();

	/**
	 * Returns the meta object for the containment reference list '{@link astrans.CreateClass#getStructuralFeatures <em>Structural Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Structural Features</em>'.
	 * @see astrans.CreateClass#getStructuralFeatures()
	 * @see #getCreateClass()
	 * @generated
	 */
	EReference getCreateClass_StructuralFeatures();

	/**
	 * Returns the meta object for class '{@link astrans.StructuralFeature <em>Structural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structural Feature</em>'.
	 * @see astrans.StructuralFeature
	 * @generated
	 */
	EClass getStructuralFeature();

	/**
	 * Returns the meta object for the attribute '{@link astrans.StructuralFeature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see astrans.StructuralFeature#getName()
	 * @see #getStructuralFeature()
	 * @generated
	 */
	EAttribute getStructuralFeature_Name();

	/**
	 * Returns the meta object for the attribute '{@link astrans.StructuralFeature#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see astrans.StructuralFeature#getLowerBound()
	 * @see #getStructuralFeature()
	 * @generated
	 */
	EAttribute getStructuralFeature_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link astrans.StructuralFeature#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see astrans.StructuralFeature#getUpperBound()
	 * @see #getStructuralFeature()
	 * @generated
	 */
	EAttribute getStructuralFeature_UpperBound();

	/**
	 * Returns the meta object for class '{@link astrans.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see astrans.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the reference '{@link astrans.Attribute#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see astrans.Attribute#getType()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Type();

	/**
	 * Returns the meta object for class '{@link astrans.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference</em>'.
	 * @see astrans.Reference
	 * @generated
	 */
	EClass getReference();

	/**
	 * Returns the meta object for the containment reference '{@link astrans.Reference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see astrans.Reference#getType()
	 * @see #getReference()
	 * @generated
	 */
	EReference getReference_Type();

	/**
	 * Returns the meta object for the attribute '{@link astrans.Reference#isContainment <em>Containment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Containment</em>'.
	 * @see astrans.Reference#isContainment()
	 * @see #getReference()
	 * @generated
	 */
	EAttribute getReference_Containment();

	/**
	 * Returns the meta object for class '{@link astrans.ChangeInheritance <em>Change Inheritance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Change Inheritance</em>'.
	 * @see astrans.ChangeInheritance
	 * @generated
	 */
	EClass getChangeInheritance();

	/**
	 * Returns the meta object for the reference '{@link astrans.ChangeInheritance#getTargetProto <em>Target Proto</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Proto</em>'.
	 * @see astrans.ChangeInheritance#getTargetProto()
	 * @see #getChangeInheritance()
	 * @generated
	 */
	EReference getChangeInheritance_TargetProto();

	/**
	 * Returns the meta object for the containment reference list '{@link astrans.ChangeInheritance#getSuperclasses <em>Superclasses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Superclasses</em>'.
	 * @see astrans.ChangeInheritance#getSuperclasses()
	 * @see #getChangeInheritance()
	 * @generated
	 */
	EReference getChangeInheritance_Superclasses();

	/**
	 * Returns the meta object for class '{@link astrans.SkipClass <em>Skip Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Skip Class</em>'.
	 * @see astrans.SkipClass
	 * @generated
	 */
	EClass getSkipClass();

	/**
	 * Returns the meta object for the reference '{@link astrans.SkipClass#getTargetProto <em>Target Proto</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Proto</em>'.
	 * @see astrans.SkipClass#getTargetProto()
	 * @see #getSkipClass()
	 * @generated
	 */
	EReference getSkipClass_TargetProto();

	/**
	 * Returns the meta object for the attribute '{@link astrans.SkipClass#isIncludeDescendants <em>Include Descendants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Include Descendants</em>'.
	 * @see astrans.SkipClass#isIncludeDescendants()
	 * @see #getSkipClass()
	 * @generated
	 */
	EAttribute getSkipClass_IncludeDescendants();

	/**
	 * Returns the meta object for class '{@link astrans.Transformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation</em>'.
	 * @see astrans.Transformation
	 * @generated
	 */
	EClass getTransformation();

	/**
	 * Returns the meta object for the containment reference list '{@link astrans.Transformation#getCreateClassActions <em>Create Class Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Create Class Actions</em>'.
	 * @see astrans.Transformation#getCreateClassActions()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_CreateClassActions();

	/**
	 * Returns the meta object for the containment reference list '{@link astrans.Transformation#getTranslateReferencesActions <em>Translate References Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Translate References Actions</em>'.
	 * @see astrans.Transformation#getTranslateReferencesActions()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_TranslateReferencesActions();

	/**
	 * Returns the meta object for the containment reference list '{@link astrans.Transformation#getChangeInheritanceActions <em>Change Inheritance Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Change Inheritance Actions</em>'.
	 * @see astrans.Transformation#getChangeInheritanceActions()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_ChangeInheritanceActions();

	/**
	 * Returns the meta object for the containment reference list '{@link astrans.Transformation#getSkipClassActions <em>Skip Class Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Skip Class Actions</em>'.
	 * @see astrans.Transformation#getSkipClassActions()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_SkipClassActions();

	/**
	 * Returns the meta object for the reference '{@link astrans.Transformation#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input</em>'.
	 * @see astrans.Transformation#getInput()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_Input();

	/**
	 * Returns the meta object for the attribute '{@link astrans.Transformation#getOutputName <em>Output Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output Name</em>'.
	 * @see astrans.Transformation#getOutputName()
	 * @see #getTransformation()
	 * @generated
	 */
	EAttribute getTransformation_OutputName();

	/**
	 * Returns the meta object for the attribute '{@link astrans.Transformation#getOutputNsURI <em>Output Ns URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output Ns URI</em>'.
	 * @see astrans.Transformation#getOutputNsURI()
	 * @see #getTransformation()
	 * @generated
	 */
	EAttribute getTransformation_OutputNsURI();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AstransFactory getAstransFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals  {
		/**
		 * The meta object literal for the '{@link astrans.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see astrans.impl.ActionImpl
		 * @see astrans.impl.AstransPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '{@link astrans.impl.EClassifierReferenceImpl <em>EClassifier Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see astrans.impl.EClassifierReferenceImpl
		 * @see astrans.impl.AstransPackageImpl#getEClassifierReference()
		 * @generated
		 */
		EClass ECLASSIFIER_REFERENCE = eINSTANCE.getEClassifierReference();

		/**
		 * The meta object literal for the '{@link astrans.impl.EClassReferenceImpl <em>EClass Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see astrans.impl.EClassReferenceImpl
		 * @see astrans.impl.AstransPackageImpl#getEClassReference()
		 * @generated
		 */
		EClass ECLASS_REFERENCE = eINSTANCE.getEClassReference();

		/**
		 * The meta object literal for the '{@link astrans.impl.CreatedEClassImpl <em>Created EClass</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see astrans.impl.CreatedEClassImpl
		 * @see astrans.impl.AstransPackageImpl#getCreatedEClass()
		 * @generated
		 */
		EClass CREATED_ECLASS = eINSTANCE.getCreatedEClass();

		/**
		 * The meta object literal for the '<em><b>Create</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATED_ECLASS__CREATE = eINSTANCE.getCreatedEClass_Create();

		/**
		 * The meta object literal for the '{@link astrans.impl.MappedEClassImpl <em>Mapped EClass</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see astrans.impl.MappedEClassImpl
		 * @see astrans.impl.AstransPackageImpl#getMappedEClass()
		 * @generated
		 */
		EClass MAPPED_ECLASS = eINSTANCE.getMappedEClass();

		/**
		 * The meta object literal for the '<em><b>Proto</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_ECLASS__PROTO = eINSTANCE.getMappedEClass_Proto();

		/**
		 * The meta object literal for the '{@link astrans.impl.ExistingEClassImpl <em>Existing EClass</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see astrans.impl.ExistingEClassImpl
		 * @see astrans.impl.AstransPackageImpl#getExistingEClass()
		 * @generated
		 */
		EClass EXISTING_ECLASS = eINSTANCE.getExistingEClass();

		/**
		 * The meta object literal for the '<em><b>EClass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXISTING_ECLASS__ECLASS = eINSTANCE.getExistingEClass_EClass();

		/**
		 * The meta object literal for the '{@link astrans.impl.ExistingEDataTypeImpl <em>Existing EData Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see astrans.impl.ExistingEDataTypeImpl
		 * @see astrans.impl.AstransPackageImpl#getExistingEDataType()
		 * @generated
		 */
		EClass EXISTING_EDATA_TYPE = eINSTANCE.getExistingEDataType();

		/**
		 * The meta object literal for the '<em><b>EData Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXISTING_EDATA_TYPE__EDATA_TYPE = eINSTANCE.getExistingEDataType_EDataType();

		/**
		 * The meta object literal for the '{@link astrans.impl.TranslateReferencesImpl <em>Translate References</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see astrans.impl.TranslateReferencesImpl
		 * @see astrans.impl.AstransPackageImpl#getTranslateReferences()
		 * @generated
		 */
		EClass TRANSLATE_REFERENCES = eINSTANCE.getTranslateReferences();

		/**
		 * The meta object literal for the '<em><b>Model Reference Type Proto</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSLATE_REFERENCES__MODEL_REFERENCE_TYPE_PROTO = eINSTANCE.getTranslateReferences_ModelReferenceTypeProto();

		/**
		 * The meta object literal for the '<em><b>Textual Reference Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSLATE_REFERENCES__TEXTUAL_REFERENCE_TYPE = eINSTANCE.getTranslateReferences_TextualReferenceType();

		/**
		 * The meta object literal for the '<em><b>Include Descendants</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSLATE_REFERENCES__INCLUDE_DESCENDANTS = eINSTANCE.getTranslateReferences_IncludeDescendants();

		/**
		 * The meta object literal for the '{@link astrans.impl.CreateClassImpl <em>Create Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see astrans.impl.CreateClassImpl
		 * @see astrans.impl.AstransPackageImpl#getCreateClass()
		 * @generated
		 */
		EClass CREATE_CLASS = eINSTANCE.getCreateClass();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_CLASS__NAME = eINSTANCE.getCreateClass_Name();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_CLASS__ABSTRACT = eINSTANCE.getCreateClass_Abstract();

		/**
		 * The meta object literal for the '<em><b>Superclasses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_CLASS__SUPERCLASSES = eINSTANCE.getCreateClass_Superclasses();

		/**
		 * The meta object literal for the '<em><b>Structural Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_CLASS__STRUCTURAL_FEATURES = eINSTANCE.getCreateClass_StructuralFeatures();

		/**
		 * The meta object literal for the '{@link astrans.impl.StructuralFeatureImpl <em>Structural Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see astrans.impl.StructuralFeatureImpl
		 * @see astrans.impl.AstransPackageImpl#getStructuralFeature()
		 * @generated
		 */
		EClass STRUCTURAL_FEATURE = eINSTANCE.getStructuralFeature();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURAL_FEATURE__NAME = eINSTANCE.getStructuralFeature_Name();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURAL_FEATURE__LOWER_BOUND = eINSTANCE.getStructuralFeature_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURAL_FEATURE__UPPER_BOUND = eINSTANCE.getStructuralFeature_UpperBound();

		/**
		 * The meta object literal for the '{@link astrans.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see astrans.impl.AttributeImpl
		 * @see astrans.impl.AstransPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__TYPE = eINSTANCE.getAttribute_Type();

		/**
		 * The meta object literal for the '{@link astrans.impl.ReferenceImpl <em>Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see astrans.impl.ReferenceImpl
		 * @see astrans.impl.AstransPackageImpl#getReference()
		 * @generated
		 */
		EClass REFERENCE = eINSTANCE.getReference();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE__TYPE = eINSTANCE.getReference_Type();

		/**
		 * The meta object literal for the '<em><b>Containment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE__CONTAINMENT = eINSTANCE.getReference_Containment();

		/**
		 * The meta object literal for the '{@link astrans.impl.ChangeInheritanceImpl <em>Change Inheritance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see astrans.impl.ChangeInheritanceImpl
		 * @see astrans.impl.AstransPackageImpl#getChangeInheritance()
		 * @generated
		 */
		EClass CHANGE_INHERITANCE = eINSTANCE.getChangeInheritance();

		/**
		 * The meta object literal for the '<em><b>Target Proto</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANGE_INHERITANCE__TARGET_PROTO = eINSTANCE.getChangeInheritance_TargetProto();

		/**
		 * The meta object literal for the '<em><b>Superclasses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANGE_INHERITANCE__SUPERCLASSES = eINSTANCE.getChangeInheritance_Superclasses();

		/**
		 * The meta object literal for the '{@link astrans.impl.SkipClassImpl <em>Skip Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see astrans.impl.SkipClassImpl
		 * @see astrans.impl.AstransPackageImpl#getSkipClass()
		 * @generated
		 */
		EClass SKIP_CLASS = eINSTANCE.getSkipClass();

		/**
		 * The meta object literal for the '<em><b>Target Proto</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SKIP_CLASS__TARGET_PROTO = eINSTANCE.getSkipClass_TargetProto();

		/**
		 * The meta object literal for the '<em><b>Include Descendants</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SKIP_CLASS__INCLUDE_DESCENDANTS = eINSTANCE.getSkipClass_IncludeDescendants();

		/**
		 * The meta object literal for the '{@link astrans.impl.TransformationImpl <em>Transformation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see astrans.impl.TransformationImpl
		 * @see astrans.impl.AstransPackageImpl#getTransformation()
		 * @generated
		 */
		EClass TRANSFORMATION = eINSTANCE.getTransformation();

		/**
		 * The meta object literal for the '<em><b>Create Class Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__CREATE_CLASS_ACTIONS = eINSTANCE.getTransformation_CreateClassActions();

		/**
		 * The meta object literal for the '<em><b>Translate References Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__TRANSLATE_REFERENCES_ACTIONS = eINSTANCE.getTransformation_TranslateReferencesActions();

		/**
		 * The meta object literal for the '<em><b>Change Inheritance Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__CHANGE_INHERITANCE_ACTIONS = eINSTANCE.getTransformation_ChangeInheritanceActions();

		/**
		 * The meta object literal for the '<em><b>Skip Class Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__SKIP_CLASS_ACTIONS = eINSTANCE.getTransformation_SkipClassActions();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__INPUT = eINSTANCE.getTransformation_Input();

		/**
		 * The meta object literal for the '<em><b>Output Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMATION__OUTPUT_NAME = eINSTANCE.getTransformation_OutputName();

		/**
		 * The meta object literal for the '<em><b>Output Ns URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMATION__OUTPUT_NS_URI = eINSTANCE.getTransformation_OutputNsURI();

	}

} //AstransPackage
