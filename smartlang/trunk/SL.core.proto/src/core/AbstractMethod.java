package core;

public abstract class AbstractMethod implements IMethod {

	private final IType declaringType;
	private final String name;

	public AbstractMethod(IType declaringType, String name) {
		this.declaringType = declaringType;
		this.name = name;
	}

	public IType getDeclaringType() {
		return declaringType;
	}

	public String getName() {
		return name;
	}

}