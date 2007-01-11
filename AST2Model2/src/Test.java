import java.io.IOException;
import java.util.Collections;

import msg.MsgPackage;
import msg.Package;
import msjast.CompilationUnitAS;
import msjast.MsjastPackage;
import msjast.util.MsjastResourceFactoryImpl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import proxy.ProxyUtil;
import util.EMFHelper;

public class Test {
	public static void main(String[] args) throws IOException {
		Resource resource = EMFHelper.getResource(new MsjastResourceFactoryImpl(), MsjastPackage.eINSTANCE, "/test.xmi");
		EMFHelper.loadResourceFromFile(resource, "tests/test12.xmi");
		
		CompilationUnitAS unitAS = (CompilationUnitAS) resource.getContents().get(0);
		
		AST2MsgTransformation transformation = new AST2MsgTransformation();
		transformation.caseCompilationUnitAS(unitAS);
		Package defaultPackage = transformation.getDefaultPackage();

		resource = EMFHelper.getResource(new XMIResourceFactoryImpl(), MsgPackage.eINSTANCE, "res.xmi");
		@SuppressWarnings({"unchecked", "unused"})
		boolean b = resource.getContents().add(ProxyUtil.copyFilteringProxies(defaultPackage, transformation.getNoncontainedProxies()));

		resource.save(System.out, Collections.singletonMap(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_THROW));
	}
}
