package core;


public abstract class NoSuch {

	public static final IMethod METHOD = new IMethod() {
		public IType getDeclaringType() {
			return NoSuch.TYPE;
		}

		public String getName() {
			return "";
		}

		public IFunction lookupFunction(IType... argumentTypes) {
			return NoSuch.FUNCTION;
		}
	};
	
	public static final IType TYPE = new ObjectType<Void>() {

		@Override
		protected IField[] doGetFields() {
			return new IField[] {};
		}

		@Override
		protected IMethod[] doGetMethods() {
			return new IMethod[] {};
		}

		public Instance getDefaultValue() {
			return NoSuch.INSTANCE;
		}

		public boolean conformsTo(IType other) {
			return false;
		}

		public IFunction getCastFrom(IType type) {
			return NoSuch.FUNCTION;
		}
		
		@Override
		public Instance createInstance(Void data) {
			return INSTANCE;
		}
		
	};

	public static final Instance INSTANCE = new Instance(TYPE, new Object());
	
	public static final IField FIELD = new FieldDescriptor(NoSuch.TYPE, "", NoSuch.TYPE) {
		public Instance readValue(Instance host) {
			return INSTANCE;
		}

		public void writeValue(Instance host, Instance value) {
			throw new UnsupportedOperationException();
		}
	};
	
	public static final IFunction FUNCTION = new Function(TYPE) {
		public Instance run(Instance thiz, Instance... arguments) {
			throw new UnsupportedOperationException();
		}
	};
	
	public static final IGenericFunction.Binary BINARY_FUNCTION = new IGenericFunction.Binary() {
		
		@Override
		public Instance run2(Instance thiz, Instance arg) {
			throw new UnsupportedOperationException();
		}
		
	};
	
	public static final IGenericFunction.Unary UNARY_FUNCTION = new IGenericFunction.Unary() {
	
		@Override
		public Instance run1(Instance thiz) {
			throw new UnsupportedOperationException();
		}
		
	};

	private NoSuch() {
	}

}
