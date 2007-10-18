package core;

public class FunctionWrapper extends Function {

	private final IGenericFunction impl;

	public FunctionWrapper(IGenericFunction impl, IType returnType, IType... parameterTypes) {
		super(returnType, parameterTypes);
		this.impl = impl;
	}

	public Instance run(Instance thiz, Instance... arguments) {
		return impl.run(thiz, arguments);
	}

	public Binary asBinary() {
		return impl.asBinary();
	}

	public Unary asUnary() {
		return impl.asUnary();
	}
}