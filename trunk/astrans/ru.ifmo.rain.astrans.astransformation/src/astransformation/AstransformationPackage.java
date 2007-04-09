/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransformation;

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
 * @see astransformation.AstransformationFactory
 * @model kind="package"
 * @generated
 */
public interface AstransformationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "astransformation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://rain.ifmo.ru/~breslav/2007/astransformation";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "astransformation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AstransformationPackage eINSTANCE = astransformation.impl.AstransformationPackageImpl.init();

	/**
	 * The meta object id for the '{@link astransformation.Named <em>Named</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see astransformation.Named
	 * @see astransformation.impl.AstransformationPackageImpl#getNamed()
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
	 * The meta object id for the '{@link astransformation.impl.TransformationImpl <em>Transformation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see astransformation.impl.TransformationImpl
	 * @see astransformation.impl.AstransformationPackageImpl#getTransformation()
	 * @generated
	 */
	int TRANSFORMATION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Mapping Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__MAPPING_RULES = NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Main</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__MAIN = NAMED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resolver Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__RESOLVER_CLASS_NAME = NAMED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Trace Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__TRACE_CLASS_NAME = NAMED_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_FEATURE_COUNT = NAMED_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link astransformation.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see astransformation.impl.ParameterImpl
	 * @see astransformation.impl.AstransformationPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = NAMED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = NAMED_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link astransformation.impl.MappingRuleImpl <em>Mapping Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see astransformation.impl.MappingRuleImpl
	 * @see astransformation.impl.AstransformationPackageImpl#getMappingRule()
	 * @generated
	 */
	int MAPPING_RULE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE__PARAMETER = NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE__RESULT = NAMED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Assign Attribute Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE__ASSIGN_ATTRIBUTE_STATEMENTS = NAMED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Assign Reference Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE__ASSIGN_REFERENCE_STATEMENTS = NAMED_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Write Trace Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE__WRITE_TRACE_STATEMENT = NAMED_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Resolve Object Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE__RESOLVE_OBJECT_STATEMENTS = NAMED_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Mapping Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE_FEATURE_COUNT = NAMED_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link astransformation.impl.AssignAttributeImpl <em>Assign Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see astransformation.impl.AssignAttributeImpl
	 * @see astransformation.impl.AstransformationPackageImpl#getAssignAttribute()
	 * @generated
	 */
	int ASSIGN_ATTRIBUTE = 4;

	/**
	 * The feature id for the '<em><b>Mapping Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_ATTRIBUTE__MAPPING_RULE = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_ATTRIBUTE__SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Dest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_ATTRIBUTE__DEST = 2;

	/**
	 * The number of structural features of the '<em>Assign Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_ATTRIBUTE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link astransformation.impl.AssignReferenceImpl <em>Assign Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see astransformation.impl.AssignReferenceImpl
	 * @see astransformation.impl.AstransformationPackageImpl#getAssignReference()
	 * @generated
	 */
	int ASSIGN_REFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Mapping Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_REFERENCE__MAPPING_RULE = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_REFERENCE__SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Dest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_REFERENCE__DEST = 2;

	/**
	 * The feature id for the '<em><b>Mapping Needed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_REFERENCE__MAPPING_NEEDED = 3;

	/**
	 * The number of structural features of the '<em>Assign Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_REFERENCE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link astransformation.impl.WriteTraceImpl <em>Write Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see astransformation.impl.WriteTraceImpl
	 * @see astransformation.impl.AstransformationPackageImpl#getWriteTrace()
	 * @generated
	 */
	int WRITE_TRACE = 6;

	/**
	 * The feature id for the '<em><b>Mapping Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_TRACE__MAPPING_RULE = 0;

	/**
	 * The feature id for the '<em><b>Trace Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_TRACE__TRACE_METHOD_NAME = 1;

	/**
	 * The number of structural features of the '<em>Write Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_TRACE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link astransformation.impl.ResolveObjectImpl <em>Resolve Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see astransformation.impl.ResolveObjectImpl
	 * @see astransformation.impl.AstransformationPackageImpl#getResolveObject()
	 * @generated
	 */
	int RESOLVE_OBJECT = 7;

	/**
	 * The feature id for the '<em><b>Mapping Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OBJECT__MAPPING_RULE = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OBJECT__SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Dest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OBJECT__DEST = 2;

	/**
	 * The feature id for the '<em><b>Resolver Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OBJECT__RESOLVER_METHOD_NAME = 3;

	/**
	 * The number of structural features of the '<em>Resolve Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OBJECT_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link astransformation.Named <em>Named</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named</em>'.
	 * @see astransformation.Named
	 * @generated
	 */
	EClass getNamed();

	/**
	 * Returns the meta object for the attribute '{@link astransformation.Named#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see astransformation.Named#getName()
	 * @see #getNamed()
	 * @generated
	 */
	EAttribute getNamed_Name();

	/**
	 * Returns the meta object for class '{@link astransformation.Transformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation</em>'.
	 * @see astransformation.Transformation
	 * @generated
	 */
	EClass getTransformation();

	/**
	 * Returns the meta object for the containment reference list '{@link astransformation.Transformation#getMappingRules <em>Mapping Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapping Rules</em>'.
	 * @see astransformation.Transformation#getMappingRules()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_MappingRules();

	/**
	 * Returns the meta object for the reference '{@link astransformation.Transformation#getMain <em>Main</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Main</em>'.
	 * @see astransformation.Transformation#getMain()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_Main();

	/**
	 * Returns the meta object for the attribute '{@link astransformation.Transformation#getResolverClassName <em>Resolver Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolver Class Name</em>'.
	 * @see astransformation.Transformation#getResolverClassName()
	 * @see #getTransformation()
	 * @generated
	 */
	EAttribute getTransformation_ResolverClassName();

	/**
	 * Returns the meta object for the attribute '{@link astransformation.Transformation#getTraceClassName <em>Trace Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trace Class Name</em>'.
	 * @see astransformation.Transformation#getTraceClassName()
	 * @see #getTransformation()
	 * @generated
	 */
	EAttribute getTransformation_TraceClassName();

	/**
	 * Returns the meta object for class '{@link astransformation.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see astransformation.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the reference '{@link astransformation.Parameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see astransformation.Parameter#getType()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Type();

	/**
	 * Returns the meta object for class '{@link astransformation.MappingRule <em>Mapping Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Rule</em>'.
	 * @see astransformation.MappingRule
	 * @generated
	 */
	EClass getMappingRule();

	/**
	 * Returns the meta object for the containment reference '{@link astransformation.MappingRule#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parameter</em>'.
	 * @see astransformation.MappingRule#getParameter()
	 * @see #getMappingRule()
	 * @generated
	 */
	EReference getMappingRule_Parameter();

	/**
	 * Returns the meta object for the containment reference '{@link astransformation.MappingRule#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result</em>'.
	 * @see astransformation.MappingRule#getResult()
	 * @see #getMappingRule()
	 * @generated
	 */
	EReference getMappingRule_Result();

	/**
	 * Returns the meta object for the containment reference list '{@link astransformation.MappingRule#getAssignAttributeStatements <em>Assign Attribute Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assign Attribute Statements</em>'.
	 * @see astransformation.MappingRule#getAssignAttributeStatements()
	 * @see #getMappingRule()
	 * @generated
	 */
	EReference getMappingRule_AssignAttributeStatements();

	/**
	 * Returns the meta object for the containment reference list '{@link astransformation.MappingRule#getAssignReferenceStatements <em>Assign Reference Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assign Reference Statements</em>'.
	 * @see astransformation.MappingRule#getAssignReferenceStatements()
	 * @see #getMappingRule()
	 * @generated
	 */
	EReference getMappingRule_AssignReferenceStatements();

	/**
	 * Returns the meta object for the containment reference '{@link astransformation.MappingRule#getWriteTraceStatement <em>Write Trace Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Write Trace Statement</em>'.
	 * @see astransformation.MappingRule#getWriteTraceStatement()
	 * @see #getMappingRule()
	 * @generated
	 */
	EReference getMappingRule_WriteTraceStatement();

	/**
	 * Returns the meta object for the containment reference list '{@link astransformation.MappingRule#getResolveObjectStatements <em>Resolve Object Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resolve Object Statements</em>'.
	 * @see astransformation.MappingRule#getResolveObjectStatements()
	 * @see #getMappingRule()
	 * @generated
	 */
	EReference getMappingRule_ResolveObjectStatements();

	/**
	 * Returns the meta object for class '{@link astransformation.AssignAttribute <em>Assign Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assign Attribute</em>'.
	 * @see astransformation.AssignAttribute
	 * @generated
	 */
	EClass getAssignAttribute();

	/**
	 * Returns the meta object for the container reference '{@link astransformation.AssignAttribute#getMappingRule <em>Mapping Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapping Rule</em>'.
	 * @see astransformation.AssignAttribute#getMappingRule()
	 * @see #getAssignAttribute()
	 * @generated
	 */
	EReference getAssignAttribute_MappingRule();

	/**
	 * Returns the meta object for the reference '{@link astransformation.AssignAttribute#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see astransformation.AssignAttribute#getSource()
	 * @see #getAssignAttribute()
	 * @generated
	 */
	EReference getAssignAttribute_Source();

	/**
	 * Returns the meta object for the reference '{@link astransformation.AssignAttribute#getDest <em>Dest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dest</em>'.
	 * @see astransformation.AssignAttribute#getDest()
	 * @see #getAssignAttribute()
	 * @generated
	 */
	EReference getAssignAttribute_Dest();

	/**
	 * Returns the meta object for class '{@link astransformation.AssignReference <em>Assign Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assign Reference</em>'.
	 * @see astransformation.AssignReference
	 * @generated
	 */
	EClass getAssignReference();

	/**
	 * Returns the meta object for the container reference '{@link astransformation.AssignReference#getMappingRule <em>Mapping Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapping Rule</em>'.
	 * @see astransformation.AssignReference#getMappingRule()
	 * @see #getAssignReference()
	 * @generated
	 */
	EReference getAssignReference_MappingRule();

	/**
	 * Returns the meta object for the reference '{@link astransformation.AssignReference#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see astransformation.AssignReference#getSource()
	 * @see #getAssignReference()
	 * @generated
	 */
	EReference getAssignReference_Source();

	/**
	 * Returns the meta object for the reference '{@link astransformation.AssignReference#getDest <em>Dest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dest</em>'.
	 * @see astransformation.AssignReference#getDest()
	 * @see #getAssignReference()
	 * @generated
	 */
	EReference getAssignReference_Dest();

	/**
	 * Returns the meta object for the attribute '{@link astransformation.AssignReference#isMappingNeeded <em>Mapping Needed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mapping Needed</em>'.
	 * @see astransformation.AssignReference#isMappingNeeded()
	 * @see #getAssignReference()
	 * @generated
	 */
	EAttribute getAssignReference_MappingNeeded();

	/**
	 * Returns the meta object for class '{@link astransformation.WriteTrace <em>Write Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Write Trace</em>'.
	 * @see astransformation.WriteTrace
	 * @generated
	 */
	EClass getWriteTrace();

	/**
	 * Returns the meta object for the container reference '{@link astransformation.WriteTrace#getMappingRule <em>Mapping Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapping Rule</em>'.
	 * @see astransformation.WriteTrace#getMappingRule()
	 * @see #getWriteTrace()
	 * @generated
	 */
	EReference getWriteTrace_MappingRule();

	/**
	 * Returns the meta object for the attribute '{@link astransformation.WriteTrace#getTraceMethodName <em>Trace Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trace Method Name</em>'.
	 * @see astransformation.WriteTrace#getTraceMethodName()
	 * @see #getWriteTrace()
	 * @generated
	 */
	EAttribute getWriteTrace_TraceMethodName();

	/**
	 * Returns the meta object for class '{@link astransformation.ResolveObject <em>Resolve Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resolve Object</em>'.
	 * @see astransformation.ResolveObject
	 * @generated
	 */
	EClass getResolveObject();

	/**
	 * Returns the meta object for the container reference '{@link astransformation.ResolveObject#getMappingRule <em>Mapping Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapping Rule</em>'.
	 * @see astransformation.ResolveObject#getMappingRule()
	 * @see #getResolveObject()
	 * @generated
	 */
	EReference getResolveObject_MappingRule();

	/**
	 * Returns the meta object for the reference '{@link astransformation.ResolveObject#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see astransformation.ResolveObject#getSource()
	 * @see #getResolveObject()
	 * @generated
	 */
	EReference getResolveObject_Source();

	/**
	 * Returns the meta object for the reference '{@link astransformation.ResolveObject#getDest <em>Dest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dest</em>'.
	 * @see astransformation.ResolveObject#getDest()
	 * @see #getResolveObject()
	 * @generated
	 */
	EReference getResolveObject_Dest();

	/**
	 * Returns the meta object for the attribute '{@link astransformation.ResolveObject#getResolverMethodName <em>Resolver Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolver Method Name</em>'.
	 * @see astransformation.ResolveObject#getResolverMethodName()
	 * @see #getResolveObject()
	 * @generated
	 */
	EAttribute getResolveObject_ResolverMethodName();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AstransformationFactory getAstransformationFactory();

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
		 * The meta object literal for the '{@link astransformation.Named <em>Named</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see astransformation.Named
		 * @see astransformation.impl.AstransformationPackageImpl#getNamed()
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
		 * The meta object literal for the '{@link astransformation.impl.TransformationImpl <em>Transformation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see astransformation.impl.TransformationImpl
		 * @see astransformation.impl.AstransformationPackageImpl#getTransformation()
		 * @generated
		 */
		EClass TRANSFORMATION = eINSTANCE.getTransformation();

		/**
		 * The meta object literal for the '<em><b>Mapping Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__MAPPING_RULES = eINSTANCE.getTransformation_MappingRules();

		/**
		 * The meta object literal for the '<em><b>Main</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__MAIN = eINSTANCE.getTransformation_Main();

		/**
		 * The meta object literal for the '<em><b>Resolver Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMATION__RESOLVER_CLASS_NAME = eINSTANCE.getTransformation_ResolverClassName();

		/**
		 * The meta object literal for the '<em><b>Trace Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMATION__TRACE_CLASS_NAME = eINSTANCE.getTransformation_TraceClassName();

		/**
		 * The meta object literal for the '{@link astransformation.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see astransformation.impl.ParameterImpl
		 * @see astransformation.impl.AstransformationPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__TYPE = eINSTANCE.getParameter_Type();

		/**
		 * The meta object literal for the '{@link astransformation.impl.MappingRuleImpl <em>Mapping Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see astransformation.impl.MappingRuleImpl
		 * @see astransformation.impl.AstransformationPackageImpl#getMappingRule()
		 * @generated
		 */
		EClass MAPPING_RULE = eINSTANCE.getMappingRule();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_RULE__PARAMETER = eINSTANCE.getMappingRule_Parameter();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_RULE__RESULT = eINSTANCE.getMappingRule_Result();

		/**
		 * The meta object literal for the '<em><b>Assign Attribute Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_RULE__ASSIGN_ATTRIBUTE_STATEMENTS = eINSTANCE.getMappingRule_AssignAttributeStatements();

		/**
		 * The meta object literal for the '<em><b>Assign Reference Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_RULE__ASSIGN_REFERENCE_STATEMENTS = eINSTANCE.getMappingRule_AssignReferenceStatements();

		/**
		 * The meta object literal for the '<em><b>Write Trace Statement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_RULE__WRITE_TRACE_STATEMENT = eINSTANCE.getMappingRule_WriteTraceStatement();

		/**
		 * The meta object literal for the '<em><b>Resolve Object Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_RULE__RESOLVE_OBJECT_STATEMENTS = eINSTANCE.getMappingRule_ResolveObjectStatements();

		/**
		 * The meta object literal for the '{@link astransformation.impl.AssignAttributeImpl <em>Assign Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see astransformation.impl.AssignAttributeImpl
		 * @see astransformation.impl.AstransformationPackageImpl#getAssignAttribute()
		 * @generated
		 */
		EClass ASSIGN_ATTRIBUTE = eINSTANCE.getAssignAttribute();

		/**
		 * The meta object literal for the '<em><b>Mapping Rule</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN_ATTRIBUTE__MAPPING_RULE = eINSTANCE.getAssignAttribute_MappingRule();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN_ATTRIBUTE__SOURCE = eINSTANCE.getAssignAttribute_Source();

		/**
		 * The meta object literal for the '<em><b>Dest</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN_ATTRIBUTE__DEST = eINSTANCE.getAssignAttribute_Dest();

		/**
		 * The meta object literal for the '{@link astransformation.impl.AssignReferenceImpl <em>Assign Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see astransformation.impl.AssignReferenceImpl
		 * @see astransformation.impl.AstransformationPackageImpl#getAssignReference()
		 * @generated
		 */
		EClass ASSIGN_REFERENCE = eINSTANCE.getAssignReference();

		/**
		 * The meta object literal for the '<em><b>Mapping Rule</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN_REFERENCE__MAPPING_RULE = eINSTANCE.getAssignReference_MappingRule();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN_REFERENCE__SOURCE = eINSTANCE.getAssignReference_Source();

		/**
		 * The meta object literal for the '<em><b>Dest</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN_REFERENCE__DEST = eINSTANCE.getAssignReference_Dest();

		/**
		 * The meta object literal for the '<em><b>Mapping Needed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGN_REFERENCE__MAPPING_NEEDED = eINSTANCE.getAssignReference_MappingNeeded();

		/**
		 * The meta object literal for the '{@link astransformation.impl.WriteTraceImpl <em>Write Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see astransformation.impl.WriteTraceImpl
		 * @see astransformation.impl.AstransformationPackageImpl#getWriteTrace()
		 * @generated
		 */
		EClass WRITE_TRACE = eINSTANCE.getWriteTrace();

		/**
		 * The meta object literal for the '<em><b>Mapping Rule</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WRITE_TRACE__MAPPING_RULE = eINSTANCE.getWriteTrace_MappingRule();

		/**
		 * The meta object literal for the '<em><b>Trace Method Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WRITE_TRACE__TRACE_METHOD_NAME = eINSTANCE.getWriteTrace_TraceMethodName();

		/**
		 * The meta object literal for the '{@link astransformation.impl.ResolveObjectImpl <em>Resolve Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see astransformation.impl.ResolveObjectImpl
		 * @see astransformation.impl.AstransformationPackageImpl#getResolveObject()
		 * @generated
		 */
		EClass RESOLVE_OBJECT = eINSTANCE.getResolveObject();

		/**
		 * The meta object literal for the '<em><b>Mapping Rule</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOLVE_OBJECT__MAPPING_RULE = eINSTANCE.getResolveObject_MappingRule();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOLVE_OBJECT__SOURCE = eINSTANCE.getResolveObject_Source();

		/**
		 * The meta object literal for the '<em><b>Dest</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOLVE_OBJECT__DEST = eINSTANCE.getResolveObject_Dest();

		/**
		 * The meta object literal for the '<em><b>Resolver Method Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOLVE_OBJECT__RESOLVER_METHOD_NAME = eINSTANCE.getResolveObject_ResolverMethodName();

	}

} //AstransformationPackage
