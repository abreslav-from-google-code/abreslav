package nulls;

public class Demo {

	private static aspect DemoAspect {
		
		after() returning(Object obj) : execution(@NotNull * *(..)) {
			assert obj != null : "@NotNull method returns null";
		}
		
		before(Object obj) : set(@NotNull * *) && args(obj) {
			assert obj != null : "Null assigned to a @NotNull field";
		}
		
		after() returning(Object obj) : get(@NotNull * *) {
			assert obj != null : "@NotNull field has null value";
		}
		
		after(Throws th) throwing(Throwable e) : execution(@Throws * *(..)) && @annotation(th) {
			Class[] allowedClasses = th.value();
			for (Class allowedClass : allowedClasses) {
				if (e.getClass() == allowedClass) {
					return;
				}
			}
			e.printStackTrace();
			assert false : "Not allowed exception is thrown: " + e;
		}
		
	}
	
	@NotNull
	private Object field;
	
	@NotNull
	Object demo(Object in) {
		return in;
	}	
	
	@Throws(Exception.class)
	void th() {
		throw new RuntimeException();
	}
	
	public static void main(String[] args) {
		new Demo().th();
		new Demo().field = args;
		Object field2 = new Demo().field;
		System.out.println(field2);
	}
}
