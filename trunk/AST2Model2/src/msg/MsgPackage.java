/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package msg;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see msg.MsgFactory
 * @model kind="package"
 * @generated
 */
public interface MsgPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "msg";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://rain.ifmo.ru/~breslav/2006/msj";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "msj";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MsgPackage eINSTANCE = msg.impl.MsgPackageImpl.init();

	/**
	 * The meta object id for the '{@link msg.impl.NamedImpl <em>Named</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see msg.impl.NamedImpl
	 * @see msg.impl.MsgPackageImpl#getNamed()
	 * @generated
	 */
	int NAMED = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link msg.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see msg.impl.TypeImpl
	 * @see msg.impl.MsgPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 1;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link msg.impl.BasicTypeImpl <em>Basic Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see msg.impl.BasicTypeImpl
	 * @see msg.impl.MsgPackageImpl#getBasicType()
	 * @generated
	 */
	int BASIC_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_TYPE__TYPE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Basic Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link msg.impl.ArrayTypeImpl <em>Array Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see msg.impl.ArrayTypeImpl
	 * @see msg.impl.MsgPackageImpl#getArrayType()
	 * @generated
	 */
	int ARRAY_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__ELEMENT_TYPE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Array Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link msg.impl.MemberImpl <em>Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see msg.impl.MemberImpl
	 * @see msg.impl.MsgPackageImpl#getMember()
	 * @generated
	 */
	int MEMBER = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Access Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER__ACCESS_MODIFIER = NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER__TYPE = NAMED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER__FINAL = NAMED_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_FEATURE_COUNT = NAMED_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link msg.impl.FieldImpl <em>Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see msg.impl.FieldImpl
	 * @see msg.impl.MsgPackageImpl#getField()
	 * @generated
	 */
	int FIELD = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__NAME = MEMBER__NAME;

	/**
	 * The feature id for the '<em><b>Access Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__ACCESS_MODIFIER = MEMBER__ACCESS_MODIFIER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__TYPE = MEMBER__TYPE;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__FINAL = MEMBER__FINAL;

	/**
	 * The number of structural features of the '<em>Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_FEATURE_COUNT = MEMBER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link msg.impl.FormalParameterImpl <em>Formal Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see msg.impl.FormalParameterImpl
	 * @see msg.impl.MsgPackageImpl#getFormalParameter()
	 * @generated
	 */
	int FORMAL_PARAMETER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAMETER__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAMETER__TYPE = NAMED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Formal Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAMETER_FEATURE_COUNT = NAMED_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link msg.impl.PackageImpl <em>Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see msg.impl.PackageImpl
	 * @see msg.impl.MsgPackageImpl#getPackage()
	 * @generated
	 */
	int PACKAGE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__CLASSES = NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Subpackages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__SUBPACKAGES = NAMED_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FEATURE_COUNT = NAMED_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link msg.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see msg.impl.ClassImpl
	 * @see msg.impl.MsgPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__PACKAGE = TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Super</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__SUPER = TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__MEMBERS = TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = TYPE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link msg.impl.MethodImpl <em>Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see msg.impl.MethodImpl
	 * @see msg.impl.MsgPackageImpl#getMethod()
	 * @generated
	 */
	int METHOD = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__NAME = MEMBER__NAME;

	/**
	 * The feature id for the '<em><b>Access Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__ACCESS_MODIFIER = MEMBER__ACCESS_MODIFIER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__TYPE = MEMBER__TYPE;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__FINAL = MEMBER__FINAL;

	/**
	 * The feature id for the '<em><b>Throws</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__THROWS = MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Formal Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__FORMAL_PARAMETERS = MEMBER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_FEATURE_COUNT = MEMBER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link msg.BasicTypes <em>Basic Types</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see msg.BasicTypes
	 * @see msg.impl.MsgPackageImpl#getBasicTypes()
	 * @generated
	 */
	int BASIC_TYPES = 10;

	/**
	 * The meta object id for the '{@link msg.AccessModifier <em>Access Modifier</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see msg.AccessModifier
	 * @see msg.impl.MsgPackageImpl#getAccessModifier()
	 * @generated
	 */
	int ACCESS_MODIFIER = 11;


	/**
	 * Returns the meta object for class '{@link msg.Named <em>Named</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named</em>'.
	 * @see msg.Named
	 * @generated
	 */
	EClass getNamed();

	/**
	 * Returns the meta object for the attribute '{@link msg.Named#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see msg.Named#getName()
	 * @see #getNamed()
	 * @generated
	 */
	EAttribute getNamed_Name();

	/**
	 * Returns the meta object for class '{@link msg.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see msg.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for class '{@link msg.BasicType <em>Basic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Type</em>'.
	 * @see msg.BasicType
	 * @generated
	 */
	EClass getBasicType();

	/**
	 * Returns the meta object for the attribute '{@link msg.BasicType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see msg.BasicType#getType()
	 * @see #getBasicType()
	 * @generated
	 */
	EAttribute getBasicType_Type();

	/**
	 * Returns the meta object for class '{@link msg.ArrayType <em>Array Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Type</em>'.
	 * @see msg.ArrayType
	 * @generated
	 */
	EClass getArrayType();

	/**
	 * Returns the meta object for the reference '{@link msg.ArrayType#getElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element Type</em>'.
	 * @see msg.ArrayType#getElementType()
	 * @see #getArrayType()
	 * @generated
	 */
	EReference getArrayType_ElementType();

	/**
	 * Returns the meta object for class '{@link msg.Field <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Field</em>'.
	 * @see msg.Field
	 * @generated
	 */
	EClass getField();

	/**
	 * Returns the meta object for class '{@link msg.FormalParameter <em>Formal Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Formal Parameter</em>'.
	 * @see msg.FormalParameter
	 * @generated
	 */
	EClass getFormalParameter();

	/**
	 * Returns the meta object for the reference '{@link msg.FormalParameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see msg.FormalParameter#getType()
	 * @see #getFormalParameter()
	 * @generated
	 */
	EReference getFormalParameter_Type();

	/**
	 * Returns the meta object for class '{@link msg.Package <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package</em>'.
	 * @see msg.Package
	 * @generated
	 */
	EClass getPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link msg.Package#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see msg.Package#getClasses()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_Classes();

	/**
	 * Returns the meta object for the containment reference list '{@link msg.Package#getSubpackages <em>Subpackages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subpackages</em>'.
	 * @see msg.Package#getSubpackages()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_Subpackages();

	/**
	 * Returns the meta object for class '{@link msg.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see msg.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the container reference '{@link msg.Class#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Package</em>'.
	 * @see msg.Class#getPackage()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Package();

	/**
	 * Returns the meta object for the reference '{@link msg.Class#getSuper <em>Super</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Super</em>'.
	 * @see msg.Class#getSuper()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Super();

	/**
	 * Returns the meta object for the containment reference list '{@link msg.Class#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Members</em>'.
	 * @see msg.Class#getMembers()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Members();

	/**
	 * Returns the meta object for class '{@link msg.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method</em>'.
	 * @see msg.Method
	 * @generated
	 */
	EClass getMethod();

	/**
	 * Returns the meta object for the reference list '{@link msg.Method#getThrows <em>Throws</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Throws</em>'.
	 * @see msg.Method#getThrows()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_Throws();

	/**
	 * Returns the meta object for the containment reference list '{@link msg.Method#getFormalParameters <em>Formal Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Formal Parameters</em>'.
	 * @see msg.Method#getFormalParameters()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_FormalParameters();

	/**
	 * Returns the meta object for class '{@link msg.Member <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Member</em>'.
	 * @see msg.Member
	 * @generated
	 */
	EClass getMember();

	/**
	 * Returns the meta object for the attribute '{@link msg.Member#getAccessModifier <em>Access Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Access Modifier</em>'.
	 * @see msg.Member#getAccessModifier()
	 * @see #getMember()
	 * @generated
	 */
	EAttribute getMember_AccessModifier();

	/**
	 * Returns the meta object for the reference '{@link msg.Member#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see msg.Member#getType()
	 * @see #getMember()
	 * @generated
	 */
	EReference getMember_Type();

	/**
	 * Returns the meta object for the attribute '{@link msg.Member#isFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final</em>'.
	 * @see msg.Member#isFinal()
	 * @see #getMember()
	 * @generated
	 */
	EAttribute getMember_Final();

	/**
	 * Returns the meta object for enum '{@link msg.BasicTypes <em>Basic Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Basic Types</em>'.
	 * @see msg.BasicTypes
	 * @generated
	 */
	EEnum getBasicTypes();

	/**
	 * Returns the meta object for enum '{@link msg.AccessModifier <em>Access Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Access Modifier</em>'.
	 * @see msg.AccessModifier
	 * @generated
	 */
	EEnum getAccessModifier();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MsgFactory getMsgFactory();

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
		 * The meta object literal for the '{@link msg.impl.NamedImpl <em>Named</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see msg.impl.NamedImpl
		 * @see msg.impl.MsgPackageImpl#getNamed()
		 * @generated
		 */
		EClass NAMED = eINSTANCE.getNamed();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED__NAME = eINSTANCE.getNamed_Name();

		/**
		 * The meta object literal for the '{@link msg.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see msg.impl.TypeImpl
		 * @see msg.impl.MsgPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '{@link msg.impl.BasicTypeImpl <em>Basic Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see msg.impl.BasicTypeImpl
		 * @see msg.impl.MsgPackageImpl#getBasicType()
		 * @generated
		 */
		EClass BASIC_TYPE = eINSTANCE.getBasicType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_TYPE__TYPE = eINSTANCE.getBasicType_Type();

		/**
		 * The meta object literal for the '{@link msg.impl.ArrayTypeImpl <em>Array Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see msg.impl.ArrayTypeImpl
		 * @see msg.impl.MsgPackageImpl#getArrayType()
		 * @generated
		 */
		EClass ARRAY_TYPE = eINSTANCE.getArrayType();

		/**
		 * The meta object literal for the '<em><b>Element Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_TYPE__ELEMENT_TYPE = eINSTANCE.getArrayType_ElementType();

		/**
		 * The meta object literal for the '{@link msg.impl.FieldImpl <em>Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see msg.impl.FieldImpl
		 * @see msg.impl.MsgPackageImpl#getField()
		 * @generated
		 */
		EClass FIELD = eINSTANCE.getField();

		/**
		 * The meta object literal for the '{@link msg.impl.FormalParameterImpl <em>Formal Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see msg.impl.FormalParameterImpl
		 * @see msg.impl.MsgPackageImpl#getFormalParameter()
		 * @generated
		 */
		EClass FORMAL_PARAMETER = eINSTANCE.getFormalParameter();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORMAL_PARAMETER__TYPE = eINSTANCE.getFormalParameter_Type();

		/**
		 * The meta object literal for the '{@link msg.impl.PackageImpl <em>Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see msg.impl.PackageImpl
		 * @see msg.impl.MsgPackageImpl#getPackage()
		 * @generated
		 */
		EClass PACKAGE = eINSTANCE.getPackage();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__CLASSES = eINSTANCE.getPackage_Classes();

		/**
		 * The meta object literal for the '<em><b>Subpackages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__SUBPACKAGES = eINSTANCE.getPackage_Subpackages();

		/**
		 * The meta object literal for the '{@link msg.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see msg.impl.ClassImpl
		 * @see msg.impl.MsgPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__PACKAGE = eINSTANCE.getClass_Package();

		/**
		 * The meta object literal for the '<em><b>Super</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__SUPER = eINSTANCE.getClass_Super();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__MEMBERS = eINSTANCE.getClass_Members();

		/**
		 * The meta object literal for the '{@link msg.impl.MethodImpl <em>Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see msg.impl.MethodImpl
		 * @see msg.impl.MsgPackageImpl#getMethod()
		 * @generated
		 */
		EClass METHOD = eINSTANCE.getMethod();

		/**
		 * The meta object literal for the '<em><b>Throws</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__THROWS = eINSTANCE.getMethod_Throws();

		/**
		 * The meta object literal for the '<em><b>Formal Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__FORMAL_PARAMETERS = eINSTANCE.getMethod_FormalParameters();

		/**
		 * The meta object literal for the '{@link msg.impl.MemberImpl <em>Member</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see msg.impl.MemberImpl
		 * @see msg.impl.MsgPackageImpl#getMember()
		 * @generated
		 */
		EClass MEMBER = eINSTANCE.getMember();

		/**
		 * The meta object literal for the '<em><b>Access Modifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMBER__ACCESS_MODIFIER = eINSTANCE.getMember_AccessModifier();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMBER__TYPE = eINSTANCE.getMember_Type();

		/**
		 * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMBER__FINAL = eINSTANCE.getMember_Final();

		/**
		 * The meta object literal for the '{@link msg.BasicTypes <em>Basic Types</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see msg.BasicTypes
		 * @see msg.impl.MsgPackageImpl#getBasicTypes()
		 * @generated
		 */
		EEnum BASIC_TYPES = eINSTANCE.getBasicTypes();

		/**
		 * The meta object literal for the '{@link msg.AccessModifier <em>Access Modifier</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see msg.AccessModifier
		 * @see msg.impl.MsgPackageImpl#getAccessModifier()
		 * @generated
		 */
		EEnum ACCESS_MODIFIER = eINSTANCE.getAccessModifier();

	}

} //MsgPackage
