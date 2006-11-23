import ru.ifmo.rain.breslav.deferred.DObject;
import ru.ifmo.rain.breslav.deferred.ResolveFailedException;

public class Main {

	public static void main(String[] args) {
		DeferredBytes bytes = new DeferredBytes(5);
		DObject<Byte> b4 = bytes.get(4);
		bytes.add((byte) 1);
		System.out.println(b4);
		bytes.add((byte) 2);
		System.out.println(b4);
		bytes.add((byte) 3);
		System.out.println(b4);
		bytes.add((byte) 4);
		System.out.println(b4);
		bytes.add((byte) 5);
		System.out.println(b4);
		try {
			System.out.println(b4.resolve());
		} catch (ResolveFailedException e) {
			System.err.println("not resolved!!!");
		}
	}
	
}
