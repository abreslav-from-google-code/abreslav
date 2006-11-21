package tests;

public class DemoTest extends TestCase {

	@Override
	protected void setUp() {
		System.out.println("set up");
	}
	
	@Override
	protected void tearDown() {
		System.out.println("tear down");
	}
	
	public void testOne() throws Exception {
		System.out.println("test...");
	}
	
	public static void main(String[] args) {
		new DemoTest().runTests();
	}
	
}
