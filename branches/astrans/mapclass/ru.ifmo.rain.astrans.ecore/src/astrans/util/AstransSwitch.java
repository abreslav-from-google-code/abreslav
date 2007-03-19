/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astrans.util;

import astrans.*;

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
 * @see astrans.AstransPackage
 * @generated
 */
public class AstransSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AstransPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AstransSwitch() {
		if (modelPackage == null) {
			modelPackage = AstransPackage.eINSTANCE;
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
			case AstransPackage.ACTION: {
				Action action = (Action)theEObject;
				Object result = caseAction(action);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransPackage.ECLASSIFIER_REFERENCE: {
				EClassifierReference eClassifierReference = (EClassifierReference)theEObject;
				Object result = caseEClassifierReference(eClassifierReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransPackage.ECLASS_REFERENCE: {
				EClassReference eClassReference = (EClassReference)theEObject;
				Object result = caseEClassReference(eClassReference);
				if (result == null) result = caseEClassifierReference(eClassReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransPackage.CREATED_ECLASS: {
				CreatedEClass createdEClass = (CreatedEClass)theEObject;
				Object result = caseCreatedEClass(createdEClass);
				if (result == null) result = caseEClassReference(createdEClass);
				if (result == null) result = caseEClassifierReference(createdEClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransPackage.MAPPED_ECLASS: {
				MappedEClass mappedEClass = (MappedEClass)theEObject;
				Object result = caseMappedEClass(mappedEClass);
				if (result == null) result = caseEClassReference(mappedEClass);
				if (result == null) result = caseEClassifierReference(mappedEClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransPackage.EXISTING_ECLASS: {
				ExistingEClass existingEClass = (ExistingEClass)theEObject;
				Object result = caseExistingEClass(existingEClass);
				if (result == null) result = caseEClassReference(existingEClass);
				if (result == null) result = caseEClassifierReference(existingEClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransPackage.EXISTING_EDATA_TYPE: {
				ExistingEDataType existingEDataType = (ExistingEDataType)theEObject;
				Object result = caseExistingEDataType(existingEDataType);
				if (result == null) result = caseEClassifierReference(existingEDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransPackage.MAP_CLASS: {
				MapClass mapClass = (MapClass)theEObject;
				Object result = caseMapClass(mapClass);
				if (result == null) result = caseAction(mapClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransPackage.TRANSLATE_REFERENCES: {
				TranslateReferences translateReferences = (TranslateReferences)theEObject;
				Object result = caseTranslateReferences(translateReferences);
				if (result == null) result = caseAction(translateReferences);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransPackage.CREATE_CLASS: {
				CreateClass createClass = (CreateClass)theEObject;
				Object result = caseCreateClass(createClass);
				if (result == null) result = caseAction(createClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransPackage.STRUCTURAL_FEATURE: {
				StructuralFeature structuralFeature = (StructuralFeature)theEObject;
				Object result = caseStructuralFeature(structuralFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransPackage.ATTRIBUTE: {
				Attribute attribute = (Attribute)theEObject;
				Object result = caseAttribute(attribute);
				if (result == null) result = caseStructuralFeature(attribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransPackage.REFERENCE: {
				Reference reference = (Reference)theEObject;
				Object result = caseReference(reference);
				if (result == null) result = caseStructuralFeature(reference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransPackage.CHANGE_INHERITANCE: {
				ChangeInheritance changeInheritance = (ChangeInheritance)theEObject;
				Object result = caseChangeInheritance(changeInheritance);
				if (result == null) result = caseAction(changeInheritance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransPackage.SKIP_CLASS: {
				SkipClass skipClass = (SkipClass)theEObject;
				Object result = caseSkipClass(skipClass);
				if (result == null) result = caseAction(skipClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstransPackage.TRANSFORMATION: {
				Transformation transformation = (Transformation)theEObject;
				Object result = caseTransformation(transformation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAction(Action object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EClassifier Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EClassifier Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEClassifierReference(EClassifierReference object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EClass Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EClass Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEClassReference(EClassReference object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Created EClass</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Created EClass</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCreatedEClass(CreatedEClass object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Mapped EClass</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Mapped EClass</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMappedEClass(MappedEClass object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Existing EClass</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Existing EClass</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExistingEClass(ExistingEClass object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Existing EData Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Existing EData Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExistingEDataType(ExistingEDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Map Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Map Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMapClass(MapClass object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Translate References</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Translate References</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTranslateReferences(TranslateReferences object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Create Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Create Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCreateClass(CreateClass object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Structural Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Structural Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStructuralFeature(StructuralFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAttribute(Attribute object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseReference(Reference object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Change Inheritance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Change Inheritance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseChangeInheritance(ChangeInheritance object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Skip Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Skip Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSkipClass(SkipClass object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Transformation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTransformation(Transformation object) {
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

} //AstransSwitch
