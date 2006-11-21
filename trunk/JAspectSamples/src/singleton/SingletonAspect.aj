package singleton;

import java.util.HashMap;
import java.util.Map;

public aspect SingletonAspect {

	private Map<Class, Object> map = new HashMap<Class, Object>();
	
	declare warning : execution((@Singleton *).new(*+)) : "Non-default constructors are not recommended for singletons";
	declare warning : call((@Singleton *).new(*+)) : "This call of constructor might not provide a new object";
	
	Object around() : call((@Singleton *).new(..)) {
		Object result = map.get(thisJoinPoint.getSignature().getDeclaringType());
		if (result == null) {
			result = proceed();
			map.put(thisJoinPoint.getSignature().getDeclaringType(), result);
		}
		return result;
	}
}
