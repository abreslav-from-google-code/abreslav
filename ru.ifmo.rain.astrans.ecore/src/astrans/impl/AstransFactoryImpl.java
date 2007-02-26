/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astrans.impl;

import astrans.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AstransFactoryImpl extends EFactoryImpl implements AstransFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AstransFactory init() {
		try {
			AstransFactory theAstransFactory = (AstransFactory)EPackage.Registry.INSTANCE.getEFactory("http://rain.ifmo.ru/~breslav/2007/astrans"); 
			if (theAstransFactory != null) {
				return theAstransFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AstransFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AstransFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AstransPackage.CREATED_ECLASS: return createCreatedEClass();
			case AstransPackage.MAPPED_ECLASS: return createMappedEClass();
			case AstransPackage.EXISTING_ECLASS: return createExistingEClass();
			case AstransPackage.EXISTING_EDATA_TYPE: return createExistingEDataType();
			case AstransPackage.MAP_CLASS: return createMapClass();
			case AstransPackage.TRANSLATE_REFERENCES: return createTranslateReferences();
			case AstransPackage.CREATE_CLASS: return createCreateClass();
			case AstransPackage.ATTRIBUTE: return createAttribute();
			case AstransPackage.REFERENCE: return createReference();
			case AstransPackage.CHANGE_INHERITANCE: return createChangeInheritance();
			case AstransPackage.SKIP_CLASS: return createSkipClass();
			case AstransPackage.TRANSFORMATION: return createTransformation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreatedEClass createCreatedEClass() {
		CreatedEClassImpl createdEClass = new CreatedEClassImpl();
		return createdEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappedEClass createMappedEClass() {
		MappedEClassImpl mappedEClass = new MappedEClassImpl();
		return mappedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExistingEClass createExistingEClass() {
		ExistingEClassImpl existingEClass = new ExistingEClassImpl();
		return existingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExistingEDataType createExistingEDataType() {
		ExistingEDataTypeImpl existingEDataType = new ExistingEDataTypeImpl();
		return existingEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MapClass createMapClass() {
		MapClassImpl mapClass = new MapClassImpl();
		return mapClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TranslateReferences createTranslateReferences() {
		TranslateReferencesImpl translateReferences = new TranslateReferencesImpl();
		return translateReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateClass createCreateClass() {
		CreateClassImpl createClass = new CreateClassImpl();
		return createClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference createReference() {
		ReferenceImpl reference = new ReferenceImpl();
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeInheritance createChangeInheritance() {
		ChangeInheritanceImpl changeInheritance = new ChangeInheritanceImpl();
		return changeInheritance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SkipClass createSkipClass() {
		SkipClassImpl skipClass = new SkipClassImpl();
		return skipClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transformation createTransformation() {
		TransformationImpl transformation = new TransformationImpl();
		return transformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AstransPackage getAstransPackage() {
		return (AstransPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static AstransPackage getPackage() {
		return AstransPackage.eINSTANCE;
	}

} //AstransFactoryImpl
