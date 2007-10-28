package core;

public class FieldDescriptorWrapper extends FieldDescriptor {

	private final IGenericField myImpl;
	
	public FieldDescriptorWrapper(final IGenericField impl, String name,
			IType fieldType, IType declaringType) {
		super(fieldType, name, declaringType);
		myImpl = impl;
	}

	public Instance readValue(Instance host) {
		return myImpl.readValue(host);
	}

	public void writeValue(Instance host, Instance value) {
		myImpl.writeValue(host, value);
	}

}
