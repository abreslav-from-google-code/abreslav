import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import ru.amse.sd.visitor.model.Mult;
import ru.amse.sd.visitor.model.Number;
import ru.amse.sd.visitor.model.Sum;
import ru.amse.sd.visitor.model.Value;
import ru.amse.sd.visitor.visitors.Loader;
import ru.amse.sd.visitor.visitors.PhraseGenerator;
import ru.amse.sd.visitor.visitors.SaveVisitor;
import ru.amse.sd.visitor.visitors.ToExpressionVisitor;
import ru.amse.sd.visitor.visitors.ToRPNVisitor;


public class Main {
	public static void main(String[] args) throws IOException {
		Value a = new Sum(new Number(2), new Number(5));
		Value b = new Mult(a, new Number(23));
		Value c = new Sum(b, a);

		System.out.println(
				a.accept(ToExpressionVisitor.INSTANCE, null)
				+ "=" + a.getValue()
		);
		System.out.println(
				b.accept(ToExpressionVisitor.INSTANCE, null)
				+ "=" + b.getValue()
		);
		System.out.println(
				ToExpressionVisitor.INSTANCE.dispatch(c)
				+ "=" + c.getValue()
		);

		System.out.println(ToRPNVisitor.dispatch(a));
		System.out.println(ToRPNVisitor.dispatch(b));
		System.out.println(ToRPNVisitor.dispatch(c));
		
		System.out.println(PhraseGenerator.getPhrase(a));
		System.out.println(PhraseGenerator.getPhrase(b));
		System.out.println(PhraseGenerator.getPhrase(c));		
		
		ByteArrayOutputStream bytes = new ByteArrayOutputStream(100);
		DataOutputStream stream = new DataOutputStream(bytes);
		SaveVisitor.save(c, stream);
		stream.close();

		byte[] byteArr = bytes.toByteArray();
		for (byte v : byteArr) {
			System.out.print(v + " ");
		}
		System.out.println();
		
		DataInputStream in = new DataInputStream(new ByteArrayInputStream(byteArr));
		Value value = Loader.readValue(in);
		System.out.println(PhraseGenerator.getPhrase(value));
	}
}
