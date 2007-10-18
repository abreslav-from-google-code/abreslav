package pascal.types;

import java.util.HashMap;
import java.util.Map;

import core.FunctionWrapper;
import core.IFunction;
import core.IGenericFunction;
import core.IType;

public abstract class UnaryFunctionFactory {

	private final Map<IType, IFunction> cache = new HashMap<IType, IFunction>();
	private final IType resultType;
	
	public UnaryFunctionFactory(IType resultType) {
		this.resultType = resultType;
	}

	public IFunction getFunction(IType argType) {
		IFunction result = cache.get(argType);
		if (result == null) {
			result = new FunctionWrapper(createFunction(argType), resultType, argType);
			cache.put(argType, result);
		}
		return result;
	}

	protected abstract IGenericFunction.Unary createFunction(IType argType);
}
