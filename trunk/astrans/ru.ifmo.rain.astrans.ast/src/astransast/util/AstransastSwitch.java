/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astransast.util;

import astransast.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see astransast.AstransastPackage
 * @generated
 */
public class AstransastSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AstransastPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AstransastSwitch() {
		if (modelPackage == null) {
			modelPackage = AstransastPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case AstransastPackage.ACTION_AS: {
				ActionAS actionAS = (ActionAS)theEObject;
				Object result = caseActionAS(actionAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransastPackage.TRANSLATE_REFERENCES_AS: {
				TranslateReferencesAS translateReferencesAS = (TranslateReferencesAS)theEObject;
				Object result = caseTranslateReferencesAS(translateReferencesAS);
				if (result == null) result = caseActionAS(translateReferencesAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransastPackage.CREATE_CLASS_AS: {
				CreateClassAS createClassAS = (CreateClassAS)theEObject;
				Object result = caseCreateClassAS(createClassAS);
				if (result == null) result = caseActionAS(createClassAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransastPackage.STRUCTURAL_FEATURE_AS: {
				StructuralFeatureAS structuralFeatureAS = (StructuralFeatureAS)theEObject;
				Object result = caseStructuralFeatureAS(structuralFeatureAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransastPackage.ATTRIBUTE_AS: {
				AttributeAS attributeAS = (AttributeAS)theEObject;
				Object result = caseAttributeAS(attributeAS);
				if (result == null) result = caseStructuralFeatureAS(attributeAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransastPackage.REFERENCE_AS: {
				ReferenceAS referenceAS = (ReferenceAS)theEObject;
				Object result = caseReferenceAS(referenceAS);
				if (result == null) result = caseStructuralFeatureAS(referenceAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransastPackage.CHANGE_INHERITANCE_AS: {
				ChangeInheritanceAS changeInheritanceAS = (ChangeInheritanceAS)theEObject;
				Object result = caseChangeInheritanceAS(changeInheritanceAS);
				if (result == null) result = caseActionAS(changeInheritanceAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransastPackage.SKIP_CLASS_AS: {
				SkipClassAS skipClassAS = (SkipClassAS)theEObject;
				Object result = caseSkipClassAS(skipClassAS);
				if (result == null) result = caseActionAS(skipClassAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransastPackage.TRANSFORMATION_AS: {
				TransformationAS transformationAS = (TransformationAS)theEObject;
				Object result = caseTransformationAS(transformationAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransastPackage.QUALIFIED_NAME: {
				QualifiedName qualifiedName = (QualifiedName)theEObject;
				Object result = caseQualifiedName(qualifiedName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransastPackage.EPACKAGE_REFERENCE: {
				EPackageReference ePackageReference = (EPackageReference)theEObject;
				Object result = caseEPackageReference(ePackageReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransastPackage.EPACKAGE_URI: {
				EPackageUri ePackageUri = (EPackageUri)theEObject;
				Object result = caseEPackageUri(ePackageUri);
				if (result == null) result = caseEPackageReference(ePackageUri);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransastPackage.EPACKAGE_PATH: {
				EPackagePath ePackagePath = (EPackagePath)theEObject;
				Object result = caseEPackagePath(ePackagePath);
				if (result == null) result = caseEPackageReference(ePackagePath);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Action AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Action AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseActionAS(ActionAS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Translate References AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Translate References AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTranslateReferencesAS(TranslateReferencesAS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Create Class AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Create Class AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCreateClassAS(CreateClassAS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Structural Feature AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Structural Feature AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStructuralFeatureAS(StructuralFeatureAS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Attribute AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Attribute AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAttributeAS(AttributeAS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Reference AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Reference AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseReferenceAS(ReferenceAS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Change Inheritance AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Change Inheritance AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseChangeInheritanceAS(ChangeInheritanceAS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Skip Class AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Skip Class AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSkipClassAS(SkipClassAS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Transformation AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Transformation AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTransformationAS(TransformationAS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Qualified Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Qualified Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseQualifiedName(QualifiedName object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EPackage Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EPackage Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEPackageReference(EPackageReference object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EPackage Uri</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EPackage Uri</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEPackageUri(EPackageUri object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EPackage Path</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EPackage Path</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEPackagePath(EPackagePath object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //AstransastSwitch
