package core;

/**
 * A generic function is a function that does not fix 
 * it's arguments' and return types. Such a function must be wrapped 
 * to conform to IFunction
 * 
 * @author abreslav
 *
 */
public interface IGenericFunction {
	
	/**
	 * Executes the function
	 * @param thiz - an object on which the function is being called
	 *               must be of the first (0-indexed) type on the argument type list
	 *               see getParameterTypes()
	 * @param arguments - function arguments
	 *                    must be of types having 1-end indices on argument type list
	 *                    number of arguments must be list length-1
	 *                    see getParameterTypes()
	 * @return function's result of type getReturnType(), 
	 *         NoSuch.OBJECT for 'void' function
	 */
	Instance run(Instance thiz, Instance... arguments);
	
	
	/**
	 * @return an unary implementation of this function. 
	 *         NoSuch.UNARY_FUNCTION if this function is not unary
	 */
	IGenericFunction.Unary asUnary();

	/**
	 * @return a binary implementation of this function. 
	 *         NoSuch.BINARY_FUNCTION if this function is not binary
	 */
	IGenericFunction.Binary asBinary();

	/**
	 * Unary function. Needed due to optimization purposes 
	 * 
	 * @author abreslav
	 *
	 */
	public static abstract class Unary implements IGenericFunction {
		public abstract Instance run1(Instance thiz);

		@Deprecated
		public Instance run(Instance thiz, Instance... arguments) {
			assert arguments.length == 0;
			
			return run1(thiz);
		}
		
		public Unary asUnary() {
			return this;
		}
		
		public Binary asBinary() {
			return NoSuch.BINARY_FUNCTION;
		}
	}
	
	
	/**
	 * Binary function. Needed due to optimization purposes 
	 * 
	 * @author abreslav
	 *
	 */
	public static abstract class Binary implements IGenericFunction {
		public abstract Instance run2(Instance thiz, Instance arg);

		@Deprecated
		public Instance run(Instance thiz, Instance... arguments) {
			assert arguments.length == 1;
			
			return run2(thiz, arguments[0]);
		}

		public Unary asUnary() {
			return NoSuch.UNARY_FUNCTION;
		}
		
		public Binary asBinary() {
			return this;
		}
	}
}
