package tests;

import java.lang.reflect.Method;

public class TestCase {

	protected void setUp() {
		
	}

	protected void tearDown() {
		
	}

	private static aspect TestCaseAspect {
		
		before(TestCase tc) : execution(* TestCase+.test*()) && target(tc) {
			tc.setUp();
		}
		
		after(TestCase tc) : execution(* TestCase+.test*()) && target(tc) {
			tc.tearDown();
		}
	}

	public void runTests() {
		Method[] methods = this.getClass().getMethods();
		for (Method method : methods) {
			if (method.getName().startsWith("test")) {
				try {
					method.invoke(this);
				} catch (Exception e) {
					System.out.println("Unable to run a test: " + e);
				}
			}
		}
	}
	
}
