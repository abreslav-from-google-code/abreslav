package core;

/**
 * A type
 * @author abreslav
 *
 */
public interface IType {

	/**
	 * Looks up for a method with the given name
	 * @param name - method name
	 * @return - method with the given name,
	 *           NoSuch.METHOD if none exists
	 */
	IMethod lookupMethod(String name);
	
	/**
	 * Looks up for a field with the given name
	 * @param name - field name
	 * @return - field with the given name,
	 *           NoSuch.FIELD if none exists
	 */
	IField lookupField(String name);

	/**
	 * @return a default value for this type (used for array initialization)
	 */
	Instance getDefaultValue();
	
	/**
	 * Type A conforms to B if they are the same or if a value of type A 
	 * doesn't require an explicit cast when assigned to a variable of type B.
	 * @param other - the type B
	 * @return true if this type conforms to B, false otherwise
	 */
	boolean conformsTo(IType other);
	
	/**
	 * @return A supertype for this type. NoSuch.TYPE if the type has no supertype
	 */
	IType getSupertype();
	
	/**
	 * Finds a cast function to cast an object of type to this type
	 * @param type - a type to cast from
	 * @return an UnaryFunction object, NoSuch.UNARY_FUNCTION if none
	 */
	// Maybe it's better to have this as an unary generic function
	IFunction getCastFrom(IType type);
	
	/**
	 * Convenience method: Must call getConstructor().create(data) !!!!
	 * @param data
	 * @return
	 */
	Instance create(Object data);
}
