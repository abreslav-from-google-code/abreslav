package pascal.parser;

import java.util.ArrayList;
import java.util.Collection;

public class Subroutine {
	String returnType;
	String name;
	final Collection<Variable> args = new ArrayList<Variable>(); 
	final Collection<Variable> locals = new ArrayList<Variable>();
	String body;
}
