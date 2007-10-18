package pascal.types;

import core.FunctionWrapper;
import core.IGenericFunction;
import core.IMethod;
import core.IType;
import core.Instance;
import core.NotOverloadedMethod;
import core.OverloadedMethod;

public class IntegerType extends OrdinalType {

	public static final IntegerType INTEGER = new IntegerType();
	
	public static final IOrdinalType BYTE = new OrdinalSubrangeType(INTEGER, 
			INTEGER.createInstance(0), INTEGER.createInstance(0xFF));
	public static final IOrdinalType WORD = new OrdinalSubrangeType(INTEGER, 
			INTEGER.createInstance(0), INTEGER.createInstance(0xFFFF));
	public static final IOrdinalType SHORTINT = new OrdinalSubrangeType(INTEGER, 
			INTEGER.createInstance(-128), INTEGER.createInstance(127));
	public static final IOrdinalType SMALLINT = new OrdinalSubrangeType(INTEGER, 
			INTEGER.createInstance(-32768), INTEGER.createInstance(32767));

	public static final IGenericFunction.Binary ADD = new IGenericFunction.Binary() {

		@Override
		public Instance run2(Instance thiz, Instance arg) {

			return INTEGER.createInstance(
					F_THIS.readValue(thiz) + 
					F_THIS.readValue(arg));
		}
		
	};
	
	public static final IGenericFunction.Binary SUB = new IGenericFunction.Binary() {

		@Override
		public Instance run2(Instance thiz, Instance arg) {
			return INTEGER.createInstance(
					F_THIS.readValue(thiz)
					 - F_THIS.readValue(arg));
		}
		
	};
	
	public static final IGenericFunction.Binary MUL = new IGenericFunction.Binary() {

		@Override
		public Instance run2(Instance thiz, Instance arg) {
			assert thiz.getType() == INTEGER;
			assert arg.getType() == INTEGER;
			
			return INTEGER.createInstance(
					F_THIS.readValue(thiz) * 
					F_THIS.readValue(arg));
		}
		
	};
	
	public static final IGenericFunction.Binary DIV = new IGenericFunction.Binary() {

		@Override
		public Instance run2(Instance thiz, Instance arg) {
			assert thiz.getType() == INTEGER;
			assert arg.getType() == INTEGER;
			
			return INTEGER.createInstance(
					F_THIS.readValue(thiz) / 
					F_THIS.readValue(arg));
		}
		
	};
	
	public static final IGenericFunction.Binary MOD = new IGenericFunction.Binary() {

		@Override
		public Instance run2(Instance thiz, Instance arg) {
			assert thiz.getType() == INTEGER;
			assert arg.getType() == INTEGER;
			
			return INTEGER.createInstance(
					F_THIS.readValue(thiz) % 
					F_THIS.readValue(arg));
		}
		
	};
	
	public static final IGenericFunction.Unary NEG = new IGenericFunction.Unary() {

		@Override
		public Instance run1(Instance thiz) {
			assert thiz.getType() == INTEGER;
			
			return INTEGER.createInstance(
					-F_THIS.readValue(thiz));
		}
		
	};
	
	private IntegerType() {
	}
	
	@Override
	protected IMethod[] getExtraMethods() {
		return new IMethod[] {
				new OverloadedMethod(this, " < ", LT_FN, RealType.REAL.LT_FN),
				new OverloadedMethod(this, " <= ", LE_FN, RealType.REAL.LE_FN),
				new OverloadedMethod(this, " = ", EQ_FN, RealType.REAL.EQ_FN),
				new OverloadedMethod(this, " <> ", NE_FN, RealType.REAL.NE_FN),
				new OverloadedMethod(this, " >= ", GE_FN, RealType.REAL.GE_FN),
				new OverloadedMethod(this, " > ", GT_FN, RealType.REAL.GT_FN),

				new OverloadedMethod(this, " + ", new FunctionWrapper(ADD, this, this, this), RealType.REAL.ADD_FN),
				new OverloadedMethod(this, " - ", new FunctionWrapper(SUB, this, this, this), RealType.REAL.SUB_FN),
				new OverloadedMethod(this, " * ", new FunctionWrapper(MUL, this, this, this), RealType.REAL.MUL_FN),
				new NotOverloadedMethod(this, " / ", RealType.REAL.DIV_FN),
				new NotOverloadedMethod(this, " div ", new FunctionWrapper(DIV, this, this, this)),
				new NotOverloadedMethod(this, " mod ", new FunctionWrapper(MOD, this, this, this)),
				new NotOverloadedMethod(this, "- ", new FunctionWrapper(NEG, this, this, this)),
			};
	}
	
	private static final int CACHE_SIZE = 512;
	private static final int CACHE_BASE = 256;
	private final Instance[] cache = new Instance[CACHE_SIZE];
	private Instance low;
	private Instance high;
	
	@Override
	public Instance createInstance(Integer value) {
		int i = value + CACHE_BASE;
		if ((i >= 0) && (i < CACHE_SIZE)) {
			if (cache[i] == null) {
				cache[i] = super.createInstance(value);
			}
			return cache[i];
		}
		return super.createInstance(value);
	}

	public Instance getHigh() {
		if (high == null) {
			high = createInstance(Integer.MAX_VALUE);
		}
		return high;
	}

	public Instance getLow() {
		if (low == null) {
			low = createInstance(Integer.MIN_VALUE);
		}
		return low;
	}

	@Override
	public boolean conformsTo(IType other) {
		return (other.conformsTo(RealType.REAL)) 
		|| super.conformsTo(other);
	}
}
