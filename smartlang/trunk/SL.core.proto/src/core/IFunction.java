package core;

/**
 * A function is an implementation of a method.
 * Several functions might be joined into one (overloaded) method
 * 
 * @author abreslav
 */
public interface IFunction extends IGenericFunction {
	
	/**
	 * Function's return type
	 * @return type object, NoSuch.TYPE for a 'void' function (procedure)
	 */
	IType getReturnType();
	
	/**
	 * Function's parameter types
	 * @return array of type objects, 
	 *         empty array if the function has no arguments
	 */
	IType[] getParameterTypes();
}
