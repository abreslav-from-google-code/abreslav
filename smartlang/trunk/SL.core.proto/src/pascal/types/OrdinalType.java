package pascal.types;

import java.util.Arrays;

import core.FunctionWrapper;
import core.IFunction;
import core.IGenericFunction;
import core.IMethod;
import core.IType;
import core.Instance;
import core.NoSuch;
import core.NotOverloadedMethod;
import core.PrimitiveType;

public abstract class OrdinalType extends PrimitiveType<Integer> implements IOrdinalType {

	public static final Instance.DataField<Integer> F_THIS = new Instance.DataField<Integer>();
	
	public static final IGenericFunction.Binary LT = new IGenericFunction.Binary() {

		@Override
		public Instance run2(Instance thiz, Instance arg) {
			return BooleanType.BOOLEAN.getValue(
					F_THIS.readValue(thiz) < 
					F_THIS.readValue(arg));
		}
		
	};
	
	public static final IGenericFunction.Binary LE = new IGenericFunction.Binary() {

		@Override
		public Instance run2(Instance thiz, Instance arg) {
			return BooleanType.BOOLEAN.getValue(
					F_THIS.readValue(thiz) <= 
					F_THIS.readValue(arg));
		}
		
	};
	
	public static final IGenericFunction.Binary EQ = new IGenericFunction.Binary() {

		@Override
		public Instance run2(Instance thiz, Instance arg) {
			return BooleanType.BOOLEAN.getValue(
					F_THIS.readValue(thiz) == 
					F_THIS.readValue(arg));
		}
		
	};
	
	public static final IGenericFunction.Binary NE = new IGenericFunction.Binary() {

		@Override
		public Instance run2(Instance thiz, Instance arg) {
			return BooleanType.BOOLEAN.getValue(
					F_THIS.readValue(thiz) != 
					F_THIS.readValue(arg));
		}
		
	};
	
	public static  final IGenericFunction.Binary GE = new IGenericFunction.Binary() {

		@Override
		public Instance run2(Instance thiz, Instance arg) {
			return BooleanType.BOOLEAN.getValue(
					F_THIS.readValue(thiz) >= 
					F_THIS.readValue(arg));
		}
		
	};
	
	public static final IGenericFunction.Binary GT = new IGenericFunction.Binary() {

		@Override
		public Instance run2(Instance thiz, Instance arg) {
			return BooleanType.BOOLEAN.getValue(
					F_THIS.readValue(thiz) > 
					F_THIS.readValue(arg));
		}
		
	};
	
	public static final IGenericFunction.Unary SUCC = new IGenericFunction.Unary() {

		@Override
		public Instance run1(Instance thiz) {
			return thiz.getType().create(F_THIS.readValue(thiz) + 1);
		}
		
	};
	
	public static final IGenericFunction.Unary PRED = new IGenericFunction.Unary() {

		@Override
		public Instance run1(Instance thiz) {
			return thiz.getType().create(F_THIS.readValue(thiz) - 1);
		}
		
	};

	public final FunctionWrapper LT_FN = new FunctionWrapper(LT, BooleanType.BOOLEAN, this, this);
	public final FunctionWrapper LE_FN = new FunctionWrapper(LE, BooleanType.BOOLEAN, this, this);
	public final FunctionWrapper EQ_FN = new FunctionWrapper(EQ, BooleanType.BOOLEAN, this, this);
	public final FunctionWrapper NE_FN = new FunctionWrapper(NE, BooleanType.BOOLEAN, this, this);
	public final FunctionWrapper GE_FN = new FunctionWrapper(GE, BooleanType.BOOLEAN, this, this);
	public final FunctionWrapper GT_FN = new FunctionWrapper(GT, BooleanType.BOOLEAN, this, this);

	private final OrdinalCastSupport castSupport = new OrdinalCastSupport(this);
	
	protected OrdinalType() {
	}

	@Override
	protected final IMethod[] doGetMethods() {
		IMethod[] ordinalMethods = new IMethod[] {
				new NotOverloadedMethod(this, " < ", LT_FN),
				new NotOverloadedMethod(this, " <= ", LE_FN),
				new NotOverloadedMethod(this, " = ", EQ_FN),
				new NotOverloadedMethod(this, " <> ", NE_FN),
				new NotOverloadedMethod(this, " >= ", GE_FN),
				new NotOverloadedMethod(this, " > ", GT_FN),
		};
		IMethod[] extraMethods = getExtraMethods();
		IMethod[] result = Arrays.copyOf(ordinalMethods, ordinalMethods.length + extraMethods.length);
		int j = 0;
		for (int i = ordinalMethods.length; i < result.length; i++) {
			result[i] = extraMethods[j];
			j++;
		}
		return result;
	}

	protected IMethod[] getExtraMethods() {
		return new IMethod[] {};
	}

	public Instance getDefaultValue() {
		return createInstance(0);
	}
	
	@Override
	public boolean conformsTo(IType other) {
		return (other == this)
			|| (other == this.getSupertype()) && (this.getSupertype() != NoSuch.TYPE)
			|| other.getSupertype() == this
			|| other.getSupertype().conformsTo(this);
	}
	
	@Override
	public IFunction getCastFrom(IType type) {
		return castSupport.getCastFrom(type);
	}
}
