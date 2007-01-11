package msg.proxies;

import msg.Class;
import msg.Field;
import msg.Package;
import msg.proxies.impl.ClassProxyImpl;
import msg.proxies.impl.FieldProxyImpl;
import msg.proxies.impl.PackageProxyImpl;
import proxy.INamespace;
import proxy.Namespace;

public class MsgNamespaceFactory {
	
	public static final MsgNamespaceFactory INSTANCE = new MsgNamespaceFactory();
	
	private MsgNamespaceFactory() {
		
	}

	@SuppressWarnings("unchecked")
	public INamespace<String, Package> createSubpackageNS(msg.Package pack) {
		return new Namespace<String, msg.Package>(pack.getSubpackages()) {

			@Override
			protected Package createElement(String key) {
				return new PackageProxyImpl(key);
			}

			@Override
			protected String getKey(Package element) {
				return element.getName();
			}
			
		};
	}

	@SuppressWarnings("unchecked")
	public INamespace<String, Class> createClassesNS(msg.Package pack) {
		return new Namespace<String, msg.Class>(pack.getClasses()) {

			@Override
			protected Class createElement(String key) {
				return new ClassProxyImpl(key);
			}

			@Override
			protected String getKey(Class element) {
				return element.getName();
			}
			
		};
	}

	@SuppressWarnings("unchecked")
	public INamespace<String, Field> createFieldsNS(msg.Class cls) {
		return new Namespace<String, msg.Field>(cls.getMembers()) {

			@Override
			protected Field createElement(String key) {
				return new FieldProxyImpl(key);
			}

			@Override
			protected String getKey(Field element) {
				return element.getName();
			}
			
		};
	}
}
