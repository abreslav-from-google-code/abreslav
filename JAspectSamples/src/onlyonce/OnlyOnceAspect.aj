package onlyonce;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.reflect.MethodSignature;

public aspect OnlyOnceAspect pertarget(onlyOnceMethod(*) && !target(OnlyOnceAspect)) {

	pointcut onlyOnceMethod(OnlyOnce ann) : execution(@OnlyOnce * *.*(..)) && @annotation(ann);
	
	public OnlyOnceAspect() {
		System.out.println("new aspect instance");
	}
	
	private static class MethodInvocation {
		private final Method method;
		private final Object[] arguments;
		
		public MethodInvocation(Method method, Object[] arguments) {
			assert method != null;
			this.method = method;
			this.arguments = arguments.clone();
		}
		
		@Override
		public boolean equals(Object obj) {
			if (false == obj instanceof MethodInvocation) {
				return false;
			}
			MethodInvocation other = (MethodInvocation) obj;
			return this.method.equals(other.method) 
				&& Arrays.equals(this.arguments, other.arguments);
		}
		
		@Override
		public int hashCode() {
			return method.hashCode() ^ Arrays.hashCode(arguments);
		}
	}
	
	private final Map<MethodInvocation, Object> cache = new HashMap<MethodInvocation, Object>();
	
	Object around(OnlyOnce ann) : onlyOnceMethod(ann) {
		Method method = (((MethodSignature) thisJoinPoint.getSignature())).getMethod();
		MethodInvocation inv = new MethodInvocation(method, thisJoinPoint.getArgs());
		if (cache.containsKey(inv)) {
			return cache.get(inv);
		}
		Object result = proceed(ann);
		if (result != null || ann.acceptNull()) {
			cache.put(inv, result);
		}
		return result;
	}
	
}
