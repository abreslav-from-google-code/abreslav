
@Marker
public class DemoClass {

	@Override
	@Marker
	public String toString() {
		return super.toString();
	}
	
	public static void main(String[] args) {
		new DemoClass().toString();
	}
}
