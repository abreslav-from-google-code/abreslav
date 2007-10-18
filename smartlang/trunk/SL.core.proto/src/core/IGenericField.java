package core;

/**
 * A generic field represents only a part of Instance structure.
 * It does not store any information about particular types
 * 
 * @author abreslav
 *
 */
public interface IGenericField {

	/**
	 * @return this field's type
	 */
	IType getFieldType();
	
	/**
	 * Reads this field's value from the given instance
	 * @param thiz - an instance to read field from
	 * @return field's value
	 * @throws WrongTypeException if the given instance does not 
	 *         have such a field
	 */
	Instance readValue(Instance thiz);

	/**
	 * Write this field to the given instance
	 * @param thiz - an instance to read field from
	 * @param value - a value to be written
	 * @throws WrongTypeException if the given instance does not 
	 *         have such a field
	 *         UnsupportedOperationException if this field is not mutable
	 */
	void writeValue(Instance thiz, Instance value);
	
	/**
	 * @return true if this field is mutable, false - otherwise
	 */
	boolean isMutable();
}
