import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class Main {

	public static int X = 100;
	public static int Y = 101;
	public static int TURN = 102;
	public static int OTHER = 103;
	
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 10000);

		DataInputStream inputStream = new DataInputStream(socket.getInputStream());
		DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
		
		byte role = inputStream.readByte();
		short w = translate(inputStream.readShort());
		short h = translate(inputStream.readShort());
		
		System.out.println(w + " x " + h);
		
		if (role == X) {
			System.out.println("I am X");
			byte command = inputStream.readByte();
			if (command != TURN) {
				throw new RuntimeException();
			}
			makeTurn(outputStream, (short) 1, (short) 1);
		} else if (role == Y) {
			System.out.println("I am Y");
		} else {
			throw new RuntimeException();
		}
		
		for (int i = 3; i < 10; i++) {
			byte b = inputStream.readByte();
			if (b != OTHER)
			{
				throw new RuntimeException();
			}
			short x = translate(inputStream.readShort());
			short y = translate(inputStream.readShort());
			System.out.println(x + ";" + y);
			makeTurn(outputStream, ++x, ++y);
		}
		
		inputStream.close();
		outputStream.close();
		socket.close();
	}


	private static short translate(short s) {
		return (short) (((s & 0xFF) << 8) | ((s & 0xFF00)) >> 8);
	}


	private static void makeTurn(DataOutputStream outputStream, short x, short y) throws IOException {
		outputStream.writeShort(translate(x));		
		outputStream.writeShort(translate(y));		
	}
}
