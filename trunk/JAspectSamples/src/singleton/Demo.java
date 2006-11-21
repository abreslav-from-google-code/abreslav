package singleton;

@Singleton
public class Demo {
	
	private Demo(int i) {
		
	}

	private Demo() {
		
	}

	public static void main(String[] args) {
		Demo d  = new Demo();
		System.out.println(d);
		System.out.println(new Demo());
		System.out.println(new Demo(1));
		System.out.println(new Demo());
		System.out.println(new Demo());
		System.out.println(new Demo());
		System.out.println(d);
	}
}
