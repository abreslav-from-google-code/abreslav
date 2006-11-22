import java.io.IOException;
import java.io.StringReader;

import evaluator.Evaluator;


public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println(Evaluator.evaluate(new StringReader("2+3")));
	}
}
