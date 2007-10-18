package core;

public class OverloadedMethod extends AbstractMethod {
	
	private final IFunction[] functions;

	public OverloadedMethod(IType declaringType, String name, IFunction... functions) {
		super(declaringType, name);
		
		this.functions = functions;
	}

	public IFunction lookupFunction(IType... argumentTypes) {
		for (IFunction function : functions) {
			if (OverloadSupport.INSTANCE.areTypesSuitable(
					function.getParameterTypes(), 
					argumentTypes)) {
				return function;
			}
		}
		return NoSuch.FUNCTION;
	}

}
