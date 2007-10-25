package core;

import java.util.HashMap;
import java.util.Map;

public abstract class TypeImpl<D> implements IType {

	private Map<String, IMethod> methods;
	
	protected TypeImpl() {
	}

	protected final Map<String, IMethod> getMethods() {
		if (methods == null) {
			methods = new HashMap<String, IMethod>();
			IMethod[] _methods = doGetMethods();
			for (IMethod method : _methods) {
				methods.put(method.getName(), method);
			}
		}
		return methods;
	}

	protected abstract IMethod[] doGetMethods();

	public IMethod lookupMethod(String name) {
		IMethod method = getMethods().get(name);
		return (method != null) 
			? method
			: NoSuch.METHOD;
	}
 
	public boolean conformsTo(IType other) {
		return other == this;
	}
	
	public IType getSupertype() {
		return NoSuch.TYPE;
	}
	
	public IFunction getCastFrom(IType type) {
		return NoSuch.FUNCTION;
	}
	
	@SuppressWarnings("unchecked")
	@Deprecated
	public final Instance create(Object data) {
		return createInstance((D) data);
	}
	
	public Instance createInstance(D data) {
		return new Instance(this, data);
	}	
}
