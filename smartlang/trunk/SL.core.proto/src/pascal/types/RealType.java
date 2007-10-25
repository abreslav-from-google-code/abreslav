package pascal.types;

import core.FunctionWrapper;
import core.IFunction;
import core.IGenericFunction;
import core.IMethod;
import core.IType;
import core.Instance;
import core.NotOverloadedMethod;
import core.PrimitiveType;

public class RealType extends PrimitiveType<Double> {

	public static final Instance.DataField<Double> F_THIS = new Instance.DataField<Double>();
	
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
	
	public static final IGenericFunction.Binary ADD = new IGenericFunction.Binary() {

		@Override
		public Instance run2(Instance thiz, Instance arg) {
			return REAL.createInstance(
					F_THIS.readValue(thiz) + 
					F_THIS.readValue(arg));
		}
		
	};
	
	public static final IGenericFunction.Binary SUB = new IGenericFunction.Binary() {

		@Override
		public Instance run2(Instance thiz, Instance arg) {
			return REAL.createInstance(
					F_THIS.readValue(thiz)
					- F_THIS.readValue(arg));
		}
		
	};
	
	public static final IGenericFunction.Binary MUL = new IGenericFunction.Binary() {

		@Override
		public Instance run2(Instance thiz, Instance arg) {
			return REAL.createInstance(
					F_THIS.readValue(thiz) * 
					F_THIS.readValue(arg));
		}
		
	};
	
	public static final IGenericFunction.Binary DIV = new IGenericFunction.Binary() {

		@Override
		public Instance run2(Instance thiz, Instance arg) {
			return REAL.createInstance(
					F_THIS.readValue(thiz) / 
					F_THIS.readValue(arg));
		}
		
	};
	
	public static final IGenericFunction.Unary NEG = new IGenericFunction.Unary() {

		@Override
		public Instance run1(Instance thiz) {
			return REAL.createInstance(
					-F_THIS.readValue(thiz));
		}
		
	};

	public static final IGenericFunction.Unary CAST_FROM_INTEGER = new IGenericFunction.Unary() {

		@Override
		public Instance run1(Instance thiz) {
			return REAL.createInstance(
					Double.valueOf(IntegerType.F_THIS.readValue(thiz)));
		}
		
	};

	public static final RealType REAL = new RealType();

	public static final Instance ZERO = REAL.createInstance(0.0);
	public static final Instance NAN = REAL.createInstance(Double.NaN);
	public static final Instance POSITIVE_INFINITY = REAL.createInstance(Double.POSITIVE_INFINITY);
	public static final Instance NEGATIVE_INFINITY = REAL.createInstance(Double.NEGATIVE_INFINITY);
	
	public final FunctionWrapper LT_FN = new FunctionWrapper(LT, BooleanType.BOOLEAN, this, this);
	public final FunctionWrapper LE_FN = new FunctionWrapper(LE, BooleanType.BOOLEAN, this, this);
	public final FunctionWrapper EQ_FN = new FunctionWrapper(EQ, BooleanType.BOOLEAN, this, this);
	public final FunctionWrapper NE_FN = new FunctionWrapper(NE, BooleanType.BOOLEAN, this, this);
	public final FunctionWrapper GE_FN = new FunctionWrapper(GE, BooleanType.BOOLEAN, this, this);
	public final FunctionWrapper GT_FN = new FunctionWrapper(GT, BooleanType.BOOLEAN, this, this);
	
	public final FunctionWrapper ADD_FN = new FunctionWrapper(ADD, this, this, this);
	public final FunctionWrapper SUB_FN = new FunctionWrapper(SUB, this, this, this);
	public final FunctionWrapper MUL_FN = new FunctionWrapper(MUL, this, this, this);
	public final FunctionWrapper DIV_FN = new FunctionWrapper(DIV, this, this, this);
	public final FunctionWrapper NEG_FN = new FunctionWrapper(NEG, this, this);

	public final FunctionWrapper CAST_FROM_INTEGER_FN = new FunctionWrapper(CAST_FROM_INTEGER, this, IntegerType.INTEGER);

	private RealType() {		
	}
	
	@Override
	protected IMethod[] doGetMethods() {
		return new IMethod[] {
				new NotOverloadedMethod(this, " < ", LT_FN),
				new NotOverloadedMethod(this, " <= ", LE_FN),
				new NotOverloadedMethod(this, " = ", EQ_FN),
				new NotOverloadedMethod(this, " <> ", NE_FN),
				new NotOverloadedMethod(this, " >= ", GE_FN),
				new NotOverloadedMethod(this, " > ", GT_FN),
				new NotOverloadedMethod(this, " + ", ADD_FN),
				new NotOverloadedMethod(this, " - ", SUB_FN),
				new NotOverloadedMethod(this, " * ", MUL_FN),
				new NotOverloadedMethod(this, " / ", DIV_FN),
				new NotOverloadedMethod(this, "- ", NEG_FN),
			};
	}

	public Instance getDefaultValue() {
		return ZERO;
	}
	
	@Override
	public IFunction getCastFrom(IType type) {
		if (type == IntegerType.INTEGER || type.getSupertype() == IntegerType.INTEGER) {
			return CAST_FROM_INTEGER_FN;
		}
		return super.getCastFrom(type);
	}

}
