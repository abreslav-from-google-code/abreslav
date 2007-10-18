package core;

/**
 * Represents a method - a type member having a name and one or more
 * implementations of type IFunction
 * 
 * @author abreslav
 *
 */
public interface IMethod {
	/**
	 * @return method name
	 */
	String getName();
	
	/**
	 * @return the type which the method belongs to
	 */
	IType getDeclaringType();
	
	/**
	 * Looks up for a certain (overloaded) implementation
	 * @param argumentTypes - types of actual arguments
	 * @return an implementation that could be called with parameters of
	 *         given types, NoSuch.FUNCTION if none exists
	 */
	IFunction lookupFunction(IType... argumentTypes);
}
