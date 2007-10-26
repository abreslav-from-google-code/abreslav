package pascal.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

import pascal.parser.PascalParser.program_return;

public class InterpreterTestGenerator {
	private static final String TEST_PROJECT_ROOT = "../SL.runtime.tests/";
	private static final String GENERATED_TESTS_FOLDER = TEST_PROJECT_ROOT + "generated_tests/";
	private static final String SOURCE_TESTS_FOLDER = TEST_PROJECT_ROOT + "tests/";

	public static void main(String[] args) throws IOException,
			RecognitionException {
		String packageName = "runtime.pascal.interpreter";

		File tests = new File(SOURCE_TESTS_FOLDER);
		for (File file : tests.listFiles()) {
			if (file.isDirectory()) {
				continue;
			}
			String fileName = file.getName();
			String testCaseName = uppercaseFirstLetter(fileName);
			String classFileName = testCaseName + "Test.java";
			
			generateTestFile(file.getAbsolutePath(), testCaseName, packageName, classFileName);
		}
		
	}

	private static void generateTestFile(String fileName, String testCaseName,
			String packageName, String classFileName) throws IOException,
			RecognitionException, FileNotFoundException {
		ANTLRFileStream stream = new ANTLRFileStream(fileName);
		PascalLexer lexer = new PascalLexer(stream);
		PascalParser parser = new PascalParser(new CommonTokenStream(lexer));
		program_return program = parser.program();
		
		CommonTree t = (CommonTree) program.getTree();
		
		String testClass = generateTestClass(t, testCaseName, packageName);
		String path = GENERATED_TESTS_FOLDER + packageToFolder(packageName);
		new File(path).mkdirs();
		FileWriter writer = new FileWriter(path + classFileName);
		writer.write(testClass);
		writer.close();
	}

	private static String packageToFolder(String packageName) {		
		return packageName.replace('.', '/') + "/";
	}

	private static String uppercaseFirstLetter(String fileName) {
		return Character.toUpperCase(fileName.charAt(0)) + fileName.substring(1);
	}

	private static String generateTestClass(CommonTree t, String name, String pack)
			throws FileNotFoundException, IOException, RecognitionException {
		CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
		PascalUnitTypeGenerator walker = new PascalUnitTypeGenerator(nodes);
		pascal.parser.PascalUnitTypeGenerator.program_return program = walker.program();

		StringTemplateGroup templates = readTemplateGroup("TestClass.stg");
		
		StringTemplate testClassTemp = templates.getInstanceOf("testClass");
		testClassTemp.setAttribute("variables", program.variables);
		testClassTemp.setAttribute("constants", program.constants);
		testClassTemp.setAttribute("name", name);
		testClassTemp.setAttribute("tree", generateRuntimeTree(t).toString());
		testClassTemp.setAttribute("package", pack);
		return testClassTemp.toString();
	}

	private static Object generateRuntimeTree(CommonTree t)
			throws FileNotFoundException, IOException, RecognitionException {
		CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
		PascalRuntimeTreeGenerator walker = new PascalRuntimeTreeGenerator(nodes);
		StringTemplateGroup templates = readTemplateGroup("Pascal.stg");
		walker.setTemplateLib(templates);
		return walker.program().getTemplate();
	}

	private static StringTemplateGroup readTemplateGroup(String fileName)
			throws FileNotFoundException, IOException {
		FileReader groupFileR = new FileReader(fileName);
		StringTemplateGroup templates = new StringTemplateGroup(groupFileR);
		groupFileR.close();
		return templates;
	}

}
