package composite;

public class Demo implements Composite<Demo> {
	
	@Override
	public String toString() {
		return "Demo";
	}
	
	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.addChild(new Demo());
		for (Demo demo2 : demo) {
			System.out.println(demo2);
		}
	}
}
