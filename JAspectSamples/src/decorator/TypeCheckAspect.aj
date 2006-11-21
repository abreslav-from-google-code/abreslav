package decorator;

public abstract aspect TypeCheckAspect {
	
	abstract pointcut methodToCheck(CheckReturnType crt);
	
	after(CheckReturnType crt) returning(Object result) : methodToCheck(crt) {
		if (!crt.value().isInstance(result)) {
			throw new RuntimeException ("assertion failed"); 
		}
	}
	
}
