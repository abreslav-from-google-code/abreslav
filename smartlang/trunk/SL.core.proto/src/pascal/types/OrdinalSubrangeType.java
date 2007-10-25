package pascal.types;

import core.DelegatingType;
import core.IFunction;
import core.IType;
import core.Instance;

public class OrdinalSubrangeType extends DelegatingType<Integer, IOrdinalType> implements IOrdinalType {

	private final OrdinalType delegate;
	private final Instance low;
	private final Instance high;
	private final int lowInt;
	private final int highInt;
	private final Instance defaultValue;
	
	private final OrdinalCastSupport castSupport = new OrdinalCastSupport(this);
	
	public OrdinalSubrangeType(OrdinalType delegate, Instance low, Instance high) {
		super(delegate);
		
		assert low.getType().conformsTo(delegate);
		assert high.getType().conformsTo(delegate);
		
		this.delegate = delegate;
		this.low = low;
		this.high = high;
		
		this.lowInt = OrdinalType.F_THIS.readValue(low);
		this.highInt = OrdinalType.F_THIS.readValue(high);

		assert lowInt <= highInt;
		
		if (lowInt <= 0 && 0 <= highInt) {
			this.defaultValue = createInstance(0);
		} else {
			this.defaultValue = low;
		}
	}

	public Instance getLow() {
		return low;
	}
	
	public Instance getHigh() {
		return high;
	}
	
	public Instance createInstance(Integer value) {
		if (value < lowInt || value > highInt) {
			throw new RangeCheckException();
		}
		return delegate.createInstance(value);
	}
	
	@Override
	public Instance getDefaultValue() {
		return defaultValue;
	}	
	
	@Override
	public IFunction getCastFrom(IType type) {
		return castSupport.getCastFrom(type);
	}
}
