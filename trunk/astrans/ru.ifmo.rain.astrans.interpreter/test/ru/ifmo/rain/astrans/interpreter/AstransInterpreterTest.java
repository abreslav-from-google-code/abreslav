package ru.ifmo.rain.astrans.interpreter;


import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ru.ifmo.rain.astrans.utils.Difference;
import ru.ifmo.rain.astrans.utils.EMFComparator;
import ru.ifmo.rain.astrans.utils.EMFHelper;
import astrans.AstransPackage;
import astrans.Transformation;

@RunWith(Parameterized.class)
public class AstransInterpreterTest {

	private String inputFileName;
	private String transformationFileName;
	private String outputFileName;
	private String expectedFileName;
	
	@Parameters
	public static Collection<Object[]> parameters() {
		Collection<Object[]> result = new ArrayList<Object[]>();
		String testDirName = "test_data";
		File testDir = new File(testDirName);
		File[] files = testDir.listFiles();
		for (File file : files) {
			if (file.isDirectory() && !file.isHidden()) {
				String path = file.getPath();
				result.add(new Object[] {
					path + "/input.ecore",
					path + "/Transformation.xmi",
					path + "/output.ecore",
					path + "/expected.ecore",
				});
			}
		}
		return result;
	}
	
	public AstransInterpreterTest(final String inputFileName, final String transformationFileName, final String outputFileName, final String expectedFileName) {
		this.inputFileName = inputFileName;
		this.transformationFileName = transformationFileName;
		this.outputFileName = outputFileName;
		this.expectedFileName = expectedFileName;
	}

	@Test
	public void testRun() throws IOException {
		Resource transfomationResource = EMFHelper.getXMIResource(AstransPackage.eINSTANCE, "Transformation.xmi");
		EMFHelper.loadResourceFromFile(transfomationResource, transformationFileName);
		Transformation transformation = (Transformation) transfomationResource.getContents().get(0);
		
		Resource expectedResource = EMFHelper.getXMIResource(EcorePackage.eINSTANCE, "expected.ecore");
		EMFHelper.loadResourceFromFile(expectedResource, expectedFileName);
		EPackage expected = (EPackage) expectedResource.getContents().get(0);

		Resource inputResource = EMFHelper.getXMIResource(EcorePackage.eINSTANCE, "input.ecore");
		EMFHelper.loadResourceFromFile(inputResource, inputFileName);

		ResourceSetImpl resourceSet = new ResourceSetImpl();
		resourceSet.getResources().add(transfomationResource);
		resourceSet.getResources().add(inputResource);
		
		EcoreUtil.resolve(transformation.getInput(), resourceSet);
		
		EPackage output = AstransInterpreter.run(transformation);
		
		EMFHelper.saveEObjectToFile(output, outputFileName);

		Difference diagnostic = EMFComparator.comapre(expected, output);
		
		assertTrue(diagnostic.toString(), diagnostic.areEqual());
	}
	
}
