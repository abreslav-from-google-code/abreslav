/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransast.impl;

import astransast.ActionAS;
import astransast.AstransastFactory;
import astransast.AstransastPackage;
import astransast.AttributeAS;
import astransast.ChangeInheritanceAS;
import astransast.CreateClassAS;
import astransast.EPackagePath;
import astransast.EPackageReference;
import astransast.EPackageUri;
import astransast.QualifiedName;
import astransast.ReferenceAS;
import astransast.SkipClassAS;
import astransast.StructuralFeatureAS;
import astransast.TransformationAS;
import astransast.TranslateReferencesAS;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AstransastPackageImpl extends EPackageImpl implements AstransastPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass translateReferencesASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createClassASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuralFeatureASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass changeInheritanceASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass skipClassASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformationASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualifiedNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ePackageReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ePackageUriEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ePackagePathEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see astransast.AstransastPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AstransastPackageImpl() {
		super(eNS_URI, AstransastFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AstransastPackage init() {
		if (isInited) return (AstransastPackage)EPackage.Registry.INSTANCE.getEPackage(AstransastPackage.eNS_URI);

		// Obtain or create and register package
		AstransastPackageImpl theAstransastPackage = (AstransastPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof AstransastPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new AstransastPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theAstransastPackage.createPackageContents();

		// Initialize created meta-data
		theAstransastPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAstransastPackage.freeze();

		return theAstransastPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionAS() {
		return actionASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTranslateReferencesAS() {
		return translateReferencesASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTranslateReferencesAS_IncludeDescendants() {
		return (EAttribute)translateReferencesASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTranslateReferencesAS_ModelReferenceTypeProto() {
		return (EReference)translateReferencesASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTranslateReferencesAS_TextualReferenceType() {
		return (EReference)translateReferencesASEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateClassAS() {
		return createClassASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateClassAS_Name() {
		return (EAttribute)createClassASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateClassAS_Abstract() {
		return (EAttribute)createClassASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateClassAS_Superclasses() {
		return (EReference)createClassASEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateClassAS_StructuralFeatures() {
		return (EReference)createClassASEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructuralFeatureAS() {
		return structuralFeatureASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructuralFeatureAS_Name() {
		return (EAttribute)structuralFeatureASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructuralFeatureAS_LowerBound() {
		return (EAttribute)structuralFeatureASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructuralFeatureAS_UpperBound() {
		return (EAttribute)structuralFeatureASEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeAS() {
		return attributeASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeAS_Type() {
		return (EReference)attributeASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceAS() {
		return referenceASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceAS_Containment() {
		return (EAttribute)referenceASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceAS_Type() {
		return (EReference)referenceASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChangeInheritanceAS() {
		return changeInheritanceASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChangeInheritanceAS_TargetProto() {
		return (EReference)changeInheritanceASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChangeInheritanceAS_Superclasses() {
		return (EReference)changeInheritanceASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSkipClassAS() {
		return skipClassASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSkipClassAS_IncludeDescendants() {
		return (EAttribute)skipClassASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSkipClassAS_TargetProto() {
		return (EReference)skipClassASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransformationAS() {
		return transformationASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformationAS_OutputName() {
		return (EAttribute)transformationASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformationAS_OutputNsURI() {
		return (EAttribute)transformationASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationAS_CreateClassActions() {
		return (EReference)transformationASEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationAS_TranslateReferencesActions() {
		return (EReference)transformationASEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationAS_ChangeInheritanceActions() {
		return (EReference)transformationASEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationAS_SkipClassActions() {
		return (EReference)transformationASEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationAS_Input() {
		return (EReference)transformationASEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQualifiedName() {
		return qualifiedNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQualifiedName_Name() {
		return (EAttribute)qualifiedNameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQualifiedName_SubQN() {
		return (EReference)qualifiedNameEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEPackageReference() {
		return ePackageReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEPackageUri() {
		return ePackageUriEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPackageUri_Uri() {
		return (EAttribute)ePackageUriEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEPackagePath() {
		return ePackagePathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPackagePath_Path() {
		return (EAttribute)ePackagePathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AstransastFactory getAstransastFactory() {
		return (AstransastFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		actionASEClass = createEClass(ACTION_AS);

		translateReferencesASEClass = createEClass(TRANSLATE_REFERENCES_AS);
		createEAttribute(translateReferencesASEClass, TRANSLATE_REFERENCES_AS__INCLUDE_DESCENDANTS);
		createEReference(translateReferencesASEClass, TRANSLATE_REFERENCES_AS__MODEL_REFERENCE_TYPE_PROTO);
		createEReference(translateReferencesASEClass, TRANSLATE_REFERENCES_AS__TEXTUAL_REFERENCE_TYPE);

		createClassASEClass = createEClass(CREATE_CLASS_AS);
		createEAttribute(createClassASEClass, CREATE_CLASS_AS__NAME);
		createEAttribute(createClassASEClass, CREATE_CLASS_AS__ABSTRACT);
		createEReference(createClassASEClass, CREATE_CLASS_AS__SUPERCLASSES);
		createEReference(createClassASEClass, CREATE_CLASS_AS__STRUCTURAL_FEATURES);

		structuralFeatureASEClass = createEClass(STRUCTURAL_FEATURE_AS);
		createEAttribute(structuralFeatureASEClass, STRUCTURAL_FEATURE_AS__NAME);
		createEAttribute(structuralFeatureASEClass, STRUCTURAL_FEATURE_AS__LOWER_BOUND);
		createEAttribute(structuralFeatureASEClass, STRUCTURAL_FEATURE_AS__UPPER_BOUND);

		attributeASEClass = createEClass(ATTRIBUTE_AS);
		createEReference(attributeASEClass, ATTRIBUTE_AS__TYPE);

		referenceASEClass = createEClass(REFERENCE_AS);
		createEAttribute(referenceASEClass, REFERENCE_AS__CONTAINMENT);
		createEReference(referenceASEClass, REFERENCE_AS__TYPE);

		changeInheritanceASEClass = createEClass(CHANGE_INHERITANCE_AS);
		createEReference(changeInheritanceASEClass, CHANGE_INHERITANCE_AS__TARGET_PROTO);
		createEReference(changeInheritanceASEClass, CHANGE_INHERITANCE_AS__SUPERCLASSES);

		skipClassASEClass = createEClass(SKIP_CLASS_AS);
		createEAttribute(skipClassASEClass, SKIP_CLASS_AS__INCLUDE_DESCENDANTS);
		createEReference(skipClassASEClass, SKIP_CLASS_AS__TARGET_PROTO);

		transformationASEClass = createEClass(TRANSFORMATION_AS);
		createEAttribute(transformationASEClass, TRANSFORMATION_AS__OUTPUT_NAME);
		createEAttribute(transformationASEClass, TRANSFORMATION_AS__OUTPUT_NS_URI);
		createEReference(transformationASEClass, TRANSFORMATION_AS__CREATE_CLASS_ACTIONS);
		createEReference(transformationASEClass, TRANSFORMATION_AS__TRANSLATE_REFERENCES_ACTIONS);
		createEReference(transformationASEClass, TRANSFORMATION_AS__CHANGE_INHERITANCE_ACTIONS);
		createEReference(transformationASEClass, TRANSFORMATION_AS__SKIP_CLASS_ACTIONS);
		createEReference(transformationASEClass, TRANSFORMATION_AS__INPUT);

		qualifiedNameEClass = createEClass(QUALIFIED_NAME);
		createEAttribute(qualifiedNameEClass, QUALIFIED_NAME__NAME);
		createEReference(qualifiedNameEClass, QUALIFIED_NAME__SUB_QN);

		ePackageReferenceEClass = createEClass(EPACKAGE_REFERENCE);

		ePackageUriEClass = createEClass(EPACKAGE_URI);
		createEAttribute(ePackageUriEClass, EPACKAGE_URI__URI);

		ePackagePathEClass = createEClass(EPACKAGE_PATH);
		createEAttribute(ePackagePathEClass, EPACKAGE_PATH__PATH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Add supertypes to classes
		translateReferencesASEClass.getESuperTypes().add(this.getActionAS());
		createClassASEClass.getESuperTypes().add(this.getActionAS());
		attributeASEClass.getESuperTypes().add(this.getStructuralFeatureAS());
		referenceASEClass.getESuperTypes().add(this.getStructuralFeatureAS());
		changeInheritanceASEClass.getESuperTypes().add(this.getActionAS());
		skipClassASEClass.getESuperTypes().add(this.getActionAS());
		ePackageUriEClass.getESuperTypes().add(this.getEPackageReference());
		ePackagePathEClass.getESuperTypes().add(this.getEPackageReference());

		// Initialize classes and features; add operations and parameters
		initEClass(actionASEClass, ActionAS.class, "ActionAS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(translateReferencesASEClass, TranslateReferencesAS.class, "TranslateReferencesAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTranslateReferencesAS_IncludeDescendants(), ecorePackage.getEBoolean(), "includeDescendants", "false", 0, 1, TranslateReferencesAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTranslateReferencesAS_ModelReferenceTypeProto(), this.getQualifiedName(), null, "modelReferenceTypeProto", null, 1, 1, TranslateReferencesAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTranslateReferencesAS_TextualReferenceType(), this.getQualifiedName(), null, "textualReferenceType", null, 1, 1, TranslateReferencesAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createClassASEClass, CreateClassAS.class, "CreateClassAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCreateClassAS_Name(), ecorePackage.getEString(), "name", null, 1, 1, CreateClassAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCreateClassAS_Abstract(), ecorePackage.getEBoolean(), "abstract", "false", 0, 1, CreateClassAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCreateClassAS_Superclasses(), this.getQualifiedName(), null, "superclasses", null, 0, -1, CreateClassAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCreateClassAS_StructuralFeatures(), this.getStructuralFeatureAS(), null, "structuralFeatures", null, 0, -1, CreateClassAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structuralFeatureASEClass, StructuralFeatureAS.class, "StructuralFeatureAS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStructuralFeatureAS_Name(), ecorePackage.getEString(), "name", null, 1, 1, StructuralFeatureAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStructuralFeatureAS_LowerBound(), ecorePackage.getEInt(), "lowerBound", "0", 0, 1, StructuralFeatureAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStructuralFeatureAS_UpperBound(), ecorePackage.getEInt(), "upperBound", "1", 0, 1, StructuralFeatureAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeASEClass, AttributeAS.class, "AttributeAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeAS_Type(), this.getQualifiedName(), null, "type", null, 1, 1, AttributeAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceASEClass, ReferenceAS.class, "ReferenceAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReferenceAS_Containment(), ecorePackage.getEBoolean(), "containment", "false", 0, 1, ReferenceAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceAS_Type(), this.getQualifiedName(), null, "type", null, 1, 1, ReferenceAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(changeInheritanceASEClass, ChangeInheritanceAS.class, "ChangeInheritanceAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChangeInheritanceAS_TargetProto(), this.getQualifiedName(), null, "targetProto", null, 1, 1, ChangeInheritanceAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChangeInheritanceAS_Superclasses(), this.getQualifiedName(), null, "superclasses", null, 0, -1, ChangeInheritanceAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(skipClassASEClass, SkipClassAS.class, "SkipClassAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSkipClassAS_IncludeDescendants(), ecorePackage.getEBoolean(), "includeDescendants", "false", 0, 1, SkipClassAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSkipClassAS_TargetProto(), this.getQualifiedName(), null, "targetProto", null, 1, 1, SkipClassAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformationASEClass, TransformationAS.class, "TransformationAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTransformationAS_OutputName(), ecorePackage.getEString(), "outputName", null, 0, 1, TransformationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformationAS_OutputNsURI(), ecorePackage.getEString(), "outputNsURI", null, 0, 1, TransformationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationAS_CreateClassActions(), this.getCreateClassAS(), null, "createClassActions", null, 0, -1, TransformationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationAS_TranslateReferencesActions(), this.getTranslateReferencesAS(), null, "translateReferencesActions", null, 0, -1, TransformationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationAS_ChangeInheritanceActions(), this.getChangeInheritanceAS(), null, "changeInheritanceActions", null, 0, -1, TransformationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationAS_SkipClassActions(), this.getSkipClassAS(), null, "skipClassActions", null, 0, -1, TransformationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationAS_Input(), this.getEPackageReference(), null, "input", null, 0, 1, TransformationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(qualifiedNameEClass, QualifiedName.class, "QualifiedName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQualifiedName_Name(), ecorePackage.getEString(), "name", null, 1, 1, QualifiedName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQualifiedName_SubQN(), this.getQualifiedName(), null, "subQN", null, 0, 1, QualifiedName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ePackageReferenceEClass, EPackageReference.class, "EPackageReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ePackageUriEClass, EPackageUri.class, "EPackageUri", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEPackageUri_Uri(), ecorePackage.getEString(), "uri", null, 1, 1, EPackageUri.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ePackagePathEClass, EPackagePath.class, "EPackagePath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEPackagePath_Path(), ecorePackage.getEString(), "path", null, 1, 1, EPackagePath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //AstransastPackageImpl
