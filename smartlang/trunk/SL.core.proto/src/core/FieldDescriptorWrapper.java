package core;

public class FieldDescriptorWrapper extends FieldDescriptor {

	private final IFunction readFunction;
	private final IFunction writeFunction;
	
	public FieldDescriptorWrapper(final IGenericField impl, String name,
			IType declaringType) {
		super(impl.getFieldType(), name, declaringType);

		readFunction = new FunctionWrapper(new IGenericFunction.Unary() {
			@Override
			public Instance run1(Instance thiz) {
				return impl.readValue(thiz);
			}
		}, getFieldType(), getDeclaringType());
		
		if (impl.isMutable()) {
			writeFunction = new FunctionWrapper(new IGenericFunction.Binary() {
				@Override
				public Instance run2(Instance thiz, Instance arg) {
					impl.writeValue(thiz, arg);
					return NoSuch.OBJECT;
				}
			}, NoSuch.TYPE, getDeclaringType(), getFieldType());
		} else {
			writeFunction = NoSuch.FUNCTION;
		}
	}

	@Override
	public IFunction getReadFunction() {
		return readFunction;
	}

	@Override
	public IFunction getWriteFunction() {
		return writeFunction;
	}

}
