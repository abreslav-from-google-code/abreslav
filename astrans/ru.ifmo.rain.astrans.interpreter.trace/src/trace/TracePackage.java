/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package trace;

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
 * @see trace.TraceFactory
 * @model kind="package"
 * @generated
 */
public interface TracePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "trace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://rain.ifmo.ru/~breslav/2007/astrans/interperter/trace";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "trace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TracePackage eINSTANCE = trace.impl.TracePackageImpl.init();

	/**
	 * The meta object id for the '{@link trace.impl.TraceImpl <em>Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see trace.impl.TraceImpl
	 * @see trace.impl.TracePackageImpl#getTrace()
	 * @generated
	 */
	int TRACE = 0;

	/**
	 * The feature id for the '<em><b>Class Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__CLASS_MAPPINGS = 0;

	/**
	 * The feature id for the '<em><b>Attribute Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__ATTRIBUTE_MAPPINGS = 1;

	/**
	 * The feature id for the '<em><b>Reference Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__REFERENCE_MAPPINGS = 2;

	/**
	 * The number of structural features of the '<em>Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link trace.impl.ClassMappingImpl <em>Class Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see trace.impl.ClassMappingImpl
	 * @see trace.impl.TracePackageImpl#getClassMapping()
	 * @generated
	 */
	int CLASS_MAPPING = 1;

	/**
	 * The feature id for the '<em><b>Proto</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MAPPING__PROTO = 0;

	/**
	 * The feature id for the '<em><b>Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MAPPING__IMAGE = 1;

	/**
	 * The number of structural features of the '<em>Class Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MAPPING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link trace.impl.AttributeMappingImpl <em>Attribute Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see trace.impl.AttributeMappingImpl
	 * @see trace.impl.TracePackageImpl#getAttributeMapping()
	 * @generated
	 */
	int ATTRIBUTE_MAPPING = 2;

	/**
	 * The feature id for the '<em><b>Proto</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__PROTO = 0;

	/**
	 * The feature id for the '<em><b>Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__IMAGE = 1;

	/**
	 * The number of structural features of the '<em>Attribute Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link trace.impl.ReferenceMappingImpl <em>Reference Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see trace.impl.ReferenceMappingImpl
	 * @see trace.impl.TracePackageImpl#getReferenceMapping()
	 * @generated
	 */
	int REFERENCE_MAPPING = 3;

	/**
	 * The feature id for the '<em><b>Proto</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_MAPPING__PROTO = 0;

	/**
	 * The feature id for the '<em><b>Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_MAPPING__IMAGE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_MAPPING__TYPE = 2;

	/**
	 * The number of structural features of the '<em>Reference Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_MAPPING_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link trace.ReferenceMappingType <em>Reference Mapping Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see trace.ReferenceMappingType
	 * @see trace.impl.TracePackageImpl#getReferenceMappingType()
	 * @generated
	 */
	int REFERENCE_MAPPING_TYPE = 4;


	/**
	 * Returns the meta object for class '{@link trace.Trace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace</em>'.
	 * @see trace.Trace
	 * @generated
	 */
	EClass getTrace();

	/**
	 * Returns the meta object for the containment reference list '{@link trace.Trace#getClassMappings <em>Class Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Class Mappings</em>'.
	 * @see trace.Trace#getClassMappings()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_ClassMappings();

	/**
	 * Returns the meta object for the containment reference list '{@link trace.Trace#getAttributeMappings <em>Attribute Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attribute Mappings</em>'.
	 * @see trace.Trace#getAttributeMappings()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_AttributeMappings();

	/**
	 * Returns the meta object for the containment reference list '{@link trace.Trace#getReferenceMappings <em>Reference Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Reference Mappings</em>'.
	 * @see trace.Trace#getReferenceMappings()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_ReferenceMappings();

	/**
	 * Returns the meta object for class '{@link trace.ClassMapping <em>Class Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Mapping</em>'.
	 * @see trace.ClassMapping
	 * @generated
	 */
	EClass getClassMapping();

	/**
	 * Returns the meta object for the reference '{@link trace.ClassMapping#getProto <em>Proto</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Proto</em>'.
	 * @see trace.ClassMapping#getProto()
	 * @see #getClassMapping()
	 * @generated
	 */
	EReference getClassMapping_Proto();

	/**
	 * Returns the meta object for the reference '{@link trace.ClassMapping#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Image</em>'.
	 * @see trace.ClassMapping#getImage()
	 * @see #getClassMapping()
	 * @generated
	 */
	EReference getClassMapping_Image();

	/**
	 * Returns the meta object for class '{@link trace.AttributeMapping <em>Attribute Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Mapping</em>'.
	 * @see trace.AttributeMapping
	 * @generated
	 */
	EClass getAttributeMapping();

	/**
	 * Returns the meta object for the reference '{@link trace.AttributeMapping#getProto <em>Proto</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Proto</em>'.
	 * @see trace.AttributeMapping#getProto()
	 * @see #getAttributeMapping()
	 * @generated
	 */
	EReference getAttributeMapping_Proto();

	/**
	 * Returns the meta object for the reference '{@link trace.AttributeMapping#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Image</em>'.
	 * @see trace.AttributeMapping#getImage()
	 * @see #getAttributeMapping()
	 * @generated
	 */
	EReference getAttributeMapping_Image();

	/**
	 * Returns the meta object for class '{@link trace.ReferenceMapping <em>Reference Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Mapping</em>'.
	 * @see trace.ReferenceMapping
	 * @generated
	 */
	EClass getReferenceMapping();

	/**
	 * Returns the meta object for the reference '{@link trace.ReferenceMapping#getProto <em>Proto</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Proto</em>'.
	 * @see trace.ReferenceMapping#getProto()
	 * @see #getReferenceMapping()
	 * @generated
	 */
	EReference getReferenceMapping_Proto();

	/**
	 * Returns the meta object for the reference '{@link trace.ReferenceMapping#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Image</em>'.
	 * @see trace.ReferenceMapping#getImage()
	 * @see #getReferenceMapping()
	 * @generated
	 */
	EReference getReferenceMapping_Image();

	/**
	 * Returns the meta object for the attribute '{@link trace.ReferenceMapping#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see trace.ReferenceMapping#getType()
	 * @see #getReferenceMapping()
	 * @generated
	 */
	EAttribute getReferenceMapping_Type();

	/**
	 * Returns the meta object for enum '{@link trace.ReferenceMappingType <em>Reference Mapping Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Reference Mapping Type</em>'.
	 * @see trace.ReferenceMappingType
	 * @generated
	 */
	EEnum getReferenceMappingType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TraceFactory getTraceFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link trace.impl.TraceImpl <em>Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see trace.impl.TraceImpl
		 * @see trace.impl.TracePackageImpl#getTrace()
		 * @generated
		 */
		EClass TRACE = eINSTANCE.getTrace();

		/**
		 * The meta object literal for the '<em><b>Class Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__CLASS_MAPPINGS = eINSTANCE.getTrace_ClassMappings();

		/**
		 * The meta object literal for the '<em><b>Attribute Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__ATTRIBUTE_MAPPINGS = eINSTANCE.getTrace_AttributeMappings();

		/**
		 * The meta object literal for the '<em><b>Reference Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__REFERENCE_MAPPINGS = eINSTANCE.getTrace_ReferenceMappings();

		/**
		 * The meta object literal for the '{@link trace.impl.ClassMappingImpl <em>Class Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see trace.impl.ClassMappingImpl
		 * @see trace.impl.TracePackageImpl#getClassMapping()
		 * @generated
		 */
		EClass CLASS_MAPPING = eINSTANCE.getClassMapping();

		/**
		 * The meta object literal for the '<em><b>Proto</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_MAPPING__PROTO = eINSTANCE.getClassMapping_Proto();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_MAPPING__IMAGE = eINSTANCE.getClassMapping_Image();

		/**
		 * The meta object literal for the '{@link trace.impl.AttributeMappingImpl <em>Attribute Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see trace.impl.AttributeMappingImpl
		 * @see trace.impl.TracePackageImpl#getAttributeMapping()
		 * @generated
		 */
		EClass ATTRIBUTE_MAPPING = eINSTANCE.getAttributeMapping();

		/**
		 * The meta object literal for the '<em><b>Proto</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_MAPPING__PROTO = eINSTANCE.getAttributeMapping_Proto();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_MAPPING__IMAGE = eINSTANCE.getAttributeMapping_Image();

		/**
		 * The meta object literal for the '{@link trace.impl.ReferenceMappingImpl <em>Reference Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see trace.impl.ReferenceMappingImpl
		 * @see trace.impl.TracePackageImpl#getReferenceMapping()
		 * @generated
		 */
		EClass REFERENCE_MAPPING = eINSTANCE.getReferenceMapping();

		/**
		 * The meta object literal for the '<em><b>Proto</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_MAPPING__PROTO = eINSTANCE.getReferenceMapping_Proto();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_MAPPING__IMAGE = eINSTANCE.getReferenceMapping_Image();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_MAPPING__TYPE = eINSTANCE.getReferenceMapping_Type();

		/**
		 * The meta object literal for the '{@link trace.ReferenceMappingType <em>Reference Mapping Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see trace.ReferenceMappingType
		 * @see trace.impl.TracePackageImpl#getReferenceMappingType()
		 * @generated
		 */
		EEnum REFERENCE_MAPPING_TYPE = eINSTANCE.getReferenceMappingType();

	}

} //TracePackage
