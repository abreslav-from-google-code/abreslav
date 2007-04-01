/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package astrans.util;

import astrans.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see astrans.AstransPackage
 * @generated
 */
public class AstransAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AstransPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AstransAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AstransPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AstransSwitch modelSwitch =
		new AstransSwitch() {
			public Object caseAction(Action object) {
				return createActionAdapter();
			}
			public Object caseEClassifierReference(EClassifierReference object) {
				return createEClassifierReferenceAdapter();
			}
			public Object caseEClassReference(EClassReference object) {
				return createEClassReferenceAdapter();
			}
			public Object caseCreatedEClass(CreatedEClass object) {
				return createCreatedEClassAdapter();
			}
			public Object caseMappedEClass(MappedEClass object) {
				return createMappedEClassAdapter();
			}
			public Object caseExistingEClass(ExistingEClass object) {
				return createExistingEClassAdapter();
			}
			public Object caseExistingEDataType(ExistingEDataType object) {
				return createExistingEDataTypeAdapter();
			}
			public Object caseTranslateReferences(TranslateReferences object) {
				return createTranslateReferencesAdapter();
			}
			public Object caseCreateClass(CreateClass object) {
				return createCreateClassAdapter();
			}
			public Object caseStructuralFeature(StructuralFeature object) {
				return createStructuralFeatureAdapter();
			}
			public Object caseAttribute(Attribute object) {
				return createAttributeAdapter();
			}
			public Object caseReference(Reference object) {
				return createReferenceAdapter();
			}
			public Object caseChangeInheritance(ChangeInheritance object) {
				return createChangeInheritanceAdapter();
			}
			public Object caseSkipClass(SkipClass object) {
				return createSkipClassAdapter();
			}
			public Object caseTransformation(Transformation object) {
				return createTransformationAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link astrans.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see astrans.Action
	 * @generated
	 */
	public Adapter createActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link astrans.EClassifierReference <em>EClassifier Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see astrans.EClassifierReference
	 * @generated
	 */
	public Adapter createEClassifierReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link astrans.EClassReference <em>EClass Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see astrans.EClassReference
	 * @generated
	 */
	public Adapter createEClassReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link astrans.CreatedEClass <em>Created EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see astrans.CreatedEClass
	 * @generated
	 */
	public Adapter createCreatedEClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link astrans.MappedEClass <em>Mapped EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see astrans.MappedEClass
	 * @generated
	 */
	public Adapter createMappedEClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link astrans.ExistingEClass <em>Existing EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see astrans.ExistingEClass
	 * @generated
	 */
	public Adapter createExistingEClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link astrans.ExistingEDataType <em>Existing EData Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see astrans.ExistingEDataType
	 * @generated
	 */
	public Adapter createExistingEDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link astrans.TranslateReferences <em>Translate References</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see astrans.TranslateReferences
	 * @generated
	 */
	public Adapter createTranslateReferencesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link astrans.CreateClass <em>Create Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see astrans.CreateClass
	 * @generated
	 */
	public Adapter createCreateClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link astrans.StructuralFeature <em>Structural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see astrans.StructuralFeature
	 * @generated
	 */
	public Adapter createStructuralFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link astrans.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see astrans.Attribute
	 * @generated
	 */
	public Adapter createAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link astrans.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see astrans.Reference
	 * @generated
	 */
	public Adapter createReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link astrans.ChangeInheritance <em>Change Inheritance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see astrans.ChangeInheritance
	 * @generated
	 */
	public Adapter createChangeInheritanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link astrans.SkipClass <em>Skip Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see astrans.SkipClass
	 * @generated
	 */
	public Adapter createSkipClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link astrans.Transformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see astrans.Transformation
	 * @generated
	 */
	public Adapter createTransformationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //AstransAdapterFactory
