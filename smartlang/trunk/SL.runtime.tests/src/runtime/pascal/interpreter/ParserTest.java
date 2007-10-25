package runtime.pascal.interpreter;

import java.io.FileReader;
import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.stringtemplate.StringTemplateGroup;

import pascal.parser.PascalLexer;
import pascal.parser.PascalParser;
import pascal.parser.PascalTree;
import pascal.parser.PascalParser.program_return;

public class ParserTest {
	public static void main(String[] args) throws IOException, RecognitionException {
		FileReader groupFileR = new FileReader("Pascal.stg" );
		StringTemplateGroup templates =	new StringTemplateGroup(groupFileR);
		groupFileR.close();
		
		ANTLRFileStream stream = new ANTLRFileStream("sample.in");
		PascalLexer lexer = new PascalLexer(stream);
		PascalParser parser = new PascalParser(new CommonTokenStream(lexer));
		program_return program = parser.program();
//		System.out.println(program.getTemplate());
		
		// WALK RESULTING TREE
		CommonTree t = (CommonTree)program.getTree(); // get tree from parser
		// Create a tree node stream from resulting tree
		CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
		PascalTree walker = new PascalTree(nodes); // create a tree parser
		walker.setTemplateLib(templates);
		System.out.println(walker.program().getTemplate()); 
	}
}
