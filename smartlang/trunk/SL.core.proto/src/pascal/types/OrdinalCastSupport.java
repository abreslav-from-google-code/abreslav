package pascal.types;

import core.IFunction;
import core.IGenericFunction;
import core.IType;
import core.Instance;
import core.NoSuch;

public class OrdinalCastSupport {

	public final IGenericFunction.Unary CAST_FROM_ORDINAL = new IGenericFunction.Unary() {

		@Override
		public Instance run1(Instance thiz) {
			return type.create(OrdinalType.F_THIS.readValue(thiz));
		}
		
	};

	private final IOrdinalType type;
	private final UnaryFunctionFactory castFromOrdinalFactory;
	
	public OrdinalCastSupport(IOrdinalType type) {
		this.type = type;
		this.castFromOrdinalFactory = new UnaryFunctionFactory(type) {

				@Override
				protected IGenericFunction.Unary createFunction(IType argType) {
					return CAST_FROM_ORDINAL;
				}
				
			};
	}


	public IFunction getCastFrom(IType from) {
		if ((from == type) || (from.getSupertype() == type)) {
			return NoSuch.FUNCTION;
		} else if (from instanceof IOrdinalType) {
			return castFromOrdinalFactory.getFunction(from);
		}
		return NoSuch.FUNCTION;
	}

}
