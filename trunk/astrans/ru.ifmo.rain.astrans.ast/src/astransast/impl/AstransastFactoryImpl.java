/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransast.impl;

import astransast.*;

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
public class AstransastFactoryImpl extends EFactoryImpl implements AstransastFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AstransastFactory init() {
		try {
			AstransastFactory theAstransastFactory = (AstransastFactory)EPackage.Registry.INSTANCE.getEFactory("http://rain.ifmo.ru/~breslav/2007/astransast"); 
			if (theAstransastFactory != null) {
				return theAstransastFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AstransastFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AstransastFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AstransastPackage.TRANSLATE_REFERENCES_AS: return createTranslateReferencesAS();
			case AstransastPackage.CREATE_CLASS_AS: return createCreateClassAS();
			case AstransastPackage.ATTRIBUTE_AS: return createAttributeAS();
			case AstransastPackage.REFERENCE_AS: return createReferenceAS();
			case AstransastPackage.CHANGE_INHERITANCE_AS: return createChangeInheritanceAS();
			case AstransastPackage.SKIP_CLASS_AS: return createSkipClassAS();
			case AstransastPackage.TRANSFORMATION_AS: return createTransformationAS();
			case AstransastPackage.MAPPED_ECLASS_AS: return createMappedEClassAS();
			case AstransastPackage.QUALIFIED_NAME: return createQualifiedName();
			case AstransastPackage.EPACKAGE_URI: return createEPackageUri();
			case AstransastPackage.EPACKAGE_PATH: return createEPackagePath();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TranslateReferencesAS createTranslateReferencesAS() {
		TranslateReferencesASImpl translateReferencesAS = new TranslateReferencesASImpl();
		return translateReferencesAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateClassAS createCreateClassAS() {
		CreateClassASImpl createClassAS = new CreateClassASImpl();
		return createClassAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeAS createAttributeAS() {
		AttributeASImpl attributeAS = new AttributeASImpl();
		return attributeAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceAS createReferenceAS() {
		ReferenceASImpl referenceAS = new ReferenceASImpl();
		return referenceAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeInheritanceAS createChangeInheritanceAS() {
		ChangeInheritanceASImpl changeInheritanceAS = new ChangeInheritanceASImpl();
		return changeInheritanceAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SkipClassAS createSkipClassAS() {
		SkipClassASImpl skipClassAS = new SkipClassASImpl();
		return skipClassAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationAS createTransformationAS() {
		TransformationASImpl transformationAS = new TransformationASImpl();
		return transformationAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappedEClassAS createMappedEClassAS() {
		MappedEClassASImpl mappedEClassAS = new MappedEClassASImpl();
		return mappedEClassAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName createQualifiedName() {
		QualifiedNameImpl qualifiedName = new QualifiedNameImpl();
		return qualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackageUri createEPackageUri() {
		EPackageUriImpl ePackageUri = new EPackageUriImpl();
		return ePackageUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackagePath createEPackagePath() {
		EPackagePathImpl ePackagePath = new EPackagePathImpl();
		return ePackagePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AstransastPackage getAstransastPackage() {
		return (AstransastPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static AstransastPackage getPackage() {
		return AstransastPackage.eINSTANCE;
	}

} //AstransastFactoryImpl
