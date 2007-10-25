package core;


public abstract class Function implements IFunction {
	
	private final IType[] parameterTypes;
	private final IType returnType;

	public Function(IType returnType, IType... parameterTypes) {
		this.parameterTypes = parameterTypes.clone();
		this.returnType = returnType;
	}

	public final IType[] getParameterTypes() {
		return parameterTypes;
	}

	public final IType getReturnType() {
		return returnType;
	}
	
	public Binary asBinary() {
		return NoSuch.BINARY_FUNCTION;
	}
	
	public Unary asUnary() {
		return NoSuch.UNARY_FUNCTION;
	}
}
