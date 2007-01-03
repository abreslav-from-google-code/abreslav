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
 * A representation of the literals of the enumeration '<em><b>Basic Types</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see msg.MsgPackage#getBasicTypes()
 * @model
 * @generated
 */
public final class BasicTypes extends AbstractEnumerator {
	/**
	 * The '<em><b>Int</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Int</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INT_LITERAL
	 * @model name="int"
	 * @generated
	 * @ordered
	 */
	public static final int INT = 1;

	/**
	 * The '<em><b>Void</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Void</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VOID_LITERAL
	 * @model name="void"
	 * @generated
	 * @ordered
	 */
	public static final int VOID = 2;

	/**
	 * The '<em><b>Boolean</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Boolean</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOOLEAN_LITERAL
	 * @model name="boolean"
	 * @generated
	 * @ordered
	 */
	public static final int BOOLEAN = 3;

	/**
	 * The '<em><b>Int</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT
	 * @generated
	 * @ordered
	 */
	public static final BasicTypes INT_LITERAL = new BasicTypes(INT, "int", "int");

	/**
	 * The '<em><b>Void</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VOID
	 * @generated
	 * @ordered
	 */
	public static final BasicTypes VOID_LITERAL = new BasicTypes(VOID, "void", "void");

	/**
	 * The '<em><b>Boolean</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOOLEAN
	 * @generated
	 * @ordered
	 */
	public static final BasicTypes BOOLEAN_LITERAL = new BasicTypes(BOOLEAN, "boolean", "boolean");

	/**
	 * An array of all the '<em><b>Basic Types</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final BasicTypes[] VALUES_ARRAY =
		new BasicTypes[] {
			INT_LITERAL,
			VOID_LITERAL,
			BOOLEAN_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Basic Types</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Basic Types</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BasicTypes get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BasicTypes result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Basic Types</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BasicTypes getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BasicTypes result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Basic Types</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BasicTypes get(int value) {
		switch (value) {
			case INT: return INT_LITERAL;
			case VOID: return VOID_LITERAL;
			case BOOLEAN: return BOOLEAN_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private BasicTypes(int value, String name, String literal) {
		super(value, name, literal);
	}

} //BasicTypes
