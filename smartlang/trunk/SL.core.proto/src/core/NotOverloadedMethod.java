package core;

public class NotOverloadedMethod extends AbstractMethod {

	private final IFunction impl;

	public NotOverloadedMethod(IType declaringType, String name, IFunction impl) {
		super(declaringType, name);
		this.impl = impl;
	}

	public IFunction lookupFunction(IType... argumentTypes) {
		return OverloadSupport.INSTANCE.areTypesSuitable(impl.getParameterTypes(), argumentTypes)
		 	? impl
		 	: NoSuch.FUNCTION;
	}

}
