package pascal.types;

import core.FunctionWrapper;
import core.IMethod;
import core.IType;
import core.Instance;
import core.OverloadedMethod;

public class CharType extends OrdinalType {

	public static final CharType CHAR = new CharType();
	
	private final Instance[] chars;
	
	private CharType() {
		chars = new Instance[256];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = super.createInstance(i);
		}
	}
	
	@Override
	public Instance createInstance(Integer data) {
		if ((data < 0) || (data >= chars.length)) {
			throw new RangeCheckException();
		}
		
		return chars[data];
	}
	
	public Instance getHigh() {
		return chars[chars.length - 1];
	}

	public Instance getLow() {
		return chars[0];
	}
	
	public char readCharValue(Instance c) {
		assert c.getType().conformsTo(this);
		
		return (char) F_THIS.readValue(c).intValue();
	}
	
	@Override
	protected IMethod[] getExtraMethods() {
		return new IMethod[] {
			new OverloadedMethod(this, " + ", 
					new FunctionWrapper(StringType.CONCAT_TWO_CHARS, StringType.STRING, this, this),	
					new FunctionWrapper(StringType.CONCAT_CHAR_WITH, StringType.STRING, this, StringType.STRING)),	
		};
	}
	
	@Override
	public boolean conformsTo(IType other) {
		return super.conformsTo(other) || other.conformsTo(StringType.STRING);
	}

}
