/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package trace;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Reference Mapping Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see trace.TracePackage#getReferenceMappingType()
 * @model
 * @generated
 */
public final class ReferenceMappingType extends AbstractEnumerator {
	/**
	 * The '<em><b>NONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NONE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NONE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NONE = 0;

	/**
	 * The '<em><b>TRANSLATED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRANSLATED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRANSLATED_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRANSLATED = 1;

	/**
	 * The '<em><b>MAPPED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MAPPED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAPPED_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MAPPED = 2;

	/**
	 * The '<em><b>NONE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE
	 * @generated
	 * @ordered
	 */
	public static final ReferenceMappingType NONE_LITERAL = new ReferenceMappingType(NONE, "NONE", "NONE");

	/**
	 * The '<em><b>TRANSLATED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSLATED
	 * @generated
	 * @ordered
	 */
	public static final ReferenceMappingType TRANSLATED_LITERAL = new ReferenceMappingType(TRANSLATED, "TRANSLATED", "TRANSLATED");

	/**
	 * The '<em><b>MAPPED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAPPED
	 * @generated
	 * @ordered
	 */
	public static final ReferenceMappingType MAPPED_LITERAL = new ReferenceMappingType(MAPPED, "MAPPED", "MAPPED");

	/**
	 * An array of all the '<em><b>Reference Mapping Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ReferenceMappingType[] VALUES_ARRAY =
		new ReferenceMappingType[] {
			NONE_LITERAL,
			TRANSLATED_LITERAL,
			MAPPED_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Reference Mapping Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Reference Mapping Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ReferenceMappingType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ReferenceMappingType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Reference Mapping Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ReferenceMappingType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ReferenceMappingType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Reference Mapping Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ReferenceMappingType get(int value) {
		switch (value) {
			case NONE: return NONE_LITERAL;
			case TRANSLATED: return TRANSLATED_LITERAL;
			case MAPPED: return MAPPED_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ReferenceMappingType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //ReferenceMappingType
