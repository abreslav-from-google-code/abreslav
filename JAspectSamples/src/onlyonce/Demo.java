package onlyonce;


@Cacheable 
public class Demo {

	/**
	 * @return
	 */
	@OnlyOnce(acceptNull = false)
	Integer cached() {
		System.out.println("cached()");
		return null;
	}
	
	@OnlyOnce
	Integer cached1() {
		System.out.println("cached1()");
		return 1;
	}
	
	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.cached();
		demo.cached1();
		demo.cached();
		demo.cached1();
		Demo demo1 = new Demo();
		demo1.cached();
		demo1.cached1();
	}
}
