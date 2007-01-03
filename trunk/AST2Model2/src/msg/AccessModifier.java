/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package msg;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Access Modifier</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see msg.MsgPackage#getAccessModifier()
 * @model
 * @generated
 */
public final class AccessModifier extends AbstractEnumerator {
	/**
	 * The '<em><b>Private</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Private</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRIVATE_LITERAL
	 * @model name="private"
	 * @generated
	 * @ordered
	 */
	public static final int PRIVATE = 1;

	/**
	 * The '<em><b>Protected</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Protected</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROTECTED_LITERAL
	 * @model name="protected"
	 * @generated
	 * @ordered
	 */
	public static final int PROTECTED = 2;

	/**
	 * The '<em><b>Public</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Public</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PUBLIC_LITERAL
	 * @model name="public"
	 * @generated
	 * @ordered
	 */
	public static final int PUBLIC = 3;

	/**
	 * The '<em><b>Private</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRIVATE
	 * @generated
	 * @ordered
	 */
	public static final AccessModifier PRIVATE_LITERAL = new AccessModifier(PRIVATE, "private", "private");

	/**
	 * The '<em><b>Protected</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROTECTED
	 * @generated
	 * @ordered
	 */
	public static final AccessModifier PROTECTED_LITERAL = new AccessModifier(PROTECTED, "protected", "protected");

	/**
	 * The '<em><b>Public</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PUBLIC
	 * @generated
	 * @ordered
	 */
	public static final AccessModifier PUBLIC_LITERAL = new AccessModifier(PUBLIC, "public", "public");

	/**
	 * An array of all the '<em><b>Access Modifier</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AccessModifier[] VALUES_ARRAY =
		new AccessModifier[] {
			PRIVATE_LITERAL,
			PROTECTED_LITERAL,
			PUBLIC_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Access Modifier</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Access Modifier</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AccessModifier get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AccessModifier result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Access Modifier</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AccessModifier getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AccessModifier result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Access Modifier</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AccessModifier get(int value) {
		switch (value) {
			case PRIVATE: return PRIVATE_LITERAL;
			case PROTECTED: return PROTECTED_LITERAL;
			case PUBLIC: return PUBLIC_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private AccessModifier(int value, String name, String literal) {
		super(value, name, literal);
	}

} //AccessModifier
