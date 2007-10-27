package pascal.types;

import core.FunctionWrapper;
import core.IGenericFunction;
import core.IMethod;
import core.Instance;
import core.NotOverloadedMethod;

public class BooleanType extends EnumeratedType {

	public static final BooleanType BOOLEAN = new BooleanType();
	public static final Instance FALSE = BOOLEAN.doCreate(0);
	public static final Instance TRUE = BOOLEAN.doCreate(1);
	
	public static final IGenericFunction.Binary AND = new IGenericFunction.Binary() {

		@Override
		public Instance run2(Instance thiz, Instance arg) {
			assert thiz.getType().conformsTo(BOOLEAN);
			assert arg.getType().conformsTo(BOOLEAN);
			
			return BOOLEAN.getValue(
					BOOLEAN.readBooleanValue(thiz)
					&& BOOLEAN.readBooleanValue(arg)
			);
		}
		
	};
	
	public static final IGenericFunction.Binary OR = new IGenericFunction.Binary() {

		@Override
		public Instance run2(Instance thiz, Instance arg) {
			assert thiz.getType().conformsTo(BOOLEAN);
			assert arg.getType().conformsTo(BOOLEAN);
			
			return BOOLEAN.getValue(
					BOOLEAN.readBooleanValue(thiz)
					|| BOOLEAN.readBooleanValue(arg)
			);
		}
		
	};
	
	public static final IGenericFunction.Binary XOR = new IGenericFunction.Binary() {

		@Override
		public Instance run2(Instance thiz, Instance arg) {
			assert thiz.getType().conformsTo(BOOLEAN);
			assert arg.getType().conformsTo(BOOLEAN);
			
			return BOOLEAN.getValue(
					BOOLEAN.readBooleanValue(thiz)
					^ BOOLEAN.readBooleanValue(arg)
			);
		}
		
	};
	
	public static final IGenericFunction.Unary NOT = new IGenericFunction.Unary() {

		@Override
		public Instance run1(Instance thiz) {
			assert thiz.getType().conformsTo(BOOLEAN);
			
			return BOOLEAN.getValue(
					!BOOLEAN.readBooleanValue(thiz));
		}
		
	};
	

	private BooleanType() {
		super("false", "true");
	}
	
	private Instance doCreate(int v) {
		return super.createInstance(v);
	}
	
	@Override
	public Instance createInstance(Integer data) {
		int value = ((Integer) data).intValue();
		return (value == 0) ? FALSE : TRUE;
	}
	
	@Override
	protected IMethod[] getExtraMethods() {
		return new IMethod[] {
			new NotOverloadedMethod(this, " and ", new FunctionWrapper(AND, this, this, this)),	
		};
	}
	
	public Instance getValue(boolean b) {
		return b ? TRUE : FALSE;
	}
	
	public boolean readBooleanValue(Instance b) {
		assert b.getType().conformsTo(this);
		
		return F_THIS.readValue(b) != 0;
	}
}
