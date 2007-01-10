package msg.util;

import java.io.IOException;

import msg.BasicType;
import msg.MsgPackage;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import util.EMFHelper;

public class BasicTypeConstants {

	public static final BasicTypeConstants INSTANCE = new BasicTypeConstants();

	private final Resource.Factory XMI_FACTORY = new XMIResourceFactoryImpl();
	
	public final BasicType INT;
	public final BasicType VOID;
	public final BasicType BOOLEAN;

	private BasicTypeConstants() {
		Resource voidRes = EMFHelper.getResource(XMI_FACTORY, MsgPackage.eINSTANCE, "model/void.xmi");
		Resource booleanRes = EMFHelper.getResource(XMI_FACTORY, MsgPackage.eINSTANCE, "model/boolean.xmi");
		Resource intRes = EMFHelper.getResource(XMI_FACTORY, MsgPackage.eINSTANCE, "model/int.xmi");
		try {
			EMFHelper.loadResourceFromFile(voidRes, "model/void.xmi");
			EMFHelper.loadResourceFromFile(booleanRes, "model/boolean.xmi");
			EMFHelper.loadResourceFromFile(intRes, "model/int.xmi");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		INT = (BasicType) intRes.getContents().get(0);
		VOID = (BasicType) voidRes.getContents().get(0);
		BOOLEAN = (BasicType) booleanRes.getContents().get(0);
	}
	
}
