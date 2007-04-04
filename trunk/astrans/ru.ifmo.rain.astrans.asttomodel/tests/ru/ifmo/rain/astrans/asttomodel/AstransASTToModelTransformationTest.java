package ru.ifmo.rain.astrans.asttomodel;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ru.ifmo.rain.astrans.utils.Difference;
import ru.ifmo.rain.astrans.utils.EMFComparator;
import ru.ifmo.rain.astrans.utils.EMFHelper;
import astrans.AstransPackage;
import astrans.Transformation;
import astransast.AstransastPackage;
import astransast.TransformationAS;

@RunWith(Parameterized.class)
public class AstransASTToModelTransformationTest {

	private TransformationAS input;
	private Transformation expectedResult;
	private AstransASTToModelTransformation transformation;
	private String expectedResultFileName;
	private String inputFileName;
	private String resultFileName;
	private String testDir;
	

	@Parameters
	public static Collection<String[]> parameters() {
		String dataDir = "testdata/xmi";
		File dir = new File(dataDir);
		File[] files = dir.listFiles();
		Collection<String[]> result = new ArrayList<String[]>();
		for (File file : files) {
			if (file.isDirectory() && !file.isHidden()) {
				result.add(new String[] {
						file.getPath() + "/input.xmi",
						file.getPath() + "/expected.xmi",
						file.getPath() + "/result.xmi",
						file.getPath()
				});
			}
		}
		return result;
	}
	
	
	public AstransASTToModelTransformationTest(String inputFN, String expectedFN, String resultFN, String testD) {
		inputFileName = inputFN;
		expectedResultFileName = expectedFN;
		resultFileName = resultFN;
		testDir = testD;
		
	}	
	
	@Before
	public void setUp() throws Exception {
		Resource resource = EMFHelper.getXMIResource(AstransastPackage.eINSTANCE, inputFileName);
		EMFHelper.loadResourceFromFile(resource, inputFileName);
		input = (TransformationAS) resource.getContents().get(0);
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResources().add(resource);
		resourceSet.setPackageRegistry(EPackage.Registry.INSTANCE);
		EcoreUtil.resolve(input, resourceSet);
		
		resource = EMFHelper.getXMIResource(AstransPackage.eINSTANCE, expectedResultFileName);
		EMFHelper.loadResourceFromFile(resource, expectedResultFileName);
		expectedResult = (Transformation) resource.getContents().get(0);
		
		transformation = new AstransASTToModelTransformation(new FileResolver(testDir));
	}
	

	@Test
	public final void testRun() throws IOException {
		Transformation result = transformation.run(input);
		EMFHelper.saveEObjectToFile(result, resultFileName);
		Difference difference = EMFComparator.comapre(result, expectedResult);
		assertTrue(difference.toString(), difference.areEqual());
	}

}