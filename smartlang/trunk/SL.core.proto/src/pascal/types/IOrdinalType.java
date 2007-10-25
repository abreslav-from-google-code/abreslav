package pascal.types;

import core.IType;
import core.Instance;

public interface IOrdinalType extends IType {
	Instance getLow();
	Instance getHigh();
	
	Instance createInstance(Integer value);
}
