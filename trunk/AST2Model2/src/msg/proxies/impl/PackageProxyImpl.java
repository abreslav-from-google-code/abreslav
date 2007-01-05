package msg.proxies.impl;

import msg.Class;
import msg.MsgFactory;
import msg.Package;
import msg.proxies.ClassProxy;
import msg.proxies.PackageProxy;

import org.eclipse.emf.common.util.EList;

import proxy.Namespace;
import proxy.ProxyImpl;

public class PackageProxyImpl extends ProxyImpl<msg.Package> implements PackageProxy {

	private final Namespace<String, Package, PackageProxy> subpackages = new Namespace<String, msg.Package, PackageProxy>() {
		@Override
		protected PackageProxy createElement(String key) {
			System.out.println(getName() + "(" + System.identityHashCode(this) + ")" + " creates " + key);
			return new PackageProxyImpl(key);
		}
	}; 
	
	private final Namespace<String, Class, ClassProxy> classes = new Namespace<String, msg.Class, ClassProxy>() {
		@Override
		protected ClassProxy createElement(String key) {
			System.out.println(getName() + "(" + System.identityHashCode(this) + ")" + " creates " + key);
			return new ClassProxyImpl(key);
		}
		
		@Override
		protected String getKey(Class element) {
			return element.getName();
		}
		
	};
	
	public PackageProxyImpl(String name) {
		super(MsgFactory.eINSTANCE.createPackage());
		subject.setName(name);
	}


	public Namespace<String, Class, ClassProxy> getClassNS() {
		return classes;
	}
	
	public Namespace<String, Package, PackageProxy> getSubpackageNS() {
		return subpackages;
	}
	
	public EList getClasses() {
		return subject.getClasses();
	}

	public String getName() {
		return subject.getName();
	}

	public EList getSubpackages() {
		return subject.getSubpackages();
	}

	public void setName(String value) {
		subject.setName(value);
	}
}
