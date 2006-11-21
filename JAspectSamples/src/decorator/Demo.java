package decorator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo {

	static aspect MyAspect extends TypeCheckAspect {
		pointcut methodToCheck(CheckReturnType crt) : execution(* Demo.*(..)) && @annotation(crt);
	}
	
	@CheckReturnType(ArrayList.class)
	List newList() {
		return new LinkedList();
	}
	
	public static void main(String[] args) {
		new Demo().newList();
		System.out.println("OK");
	}
	
}
