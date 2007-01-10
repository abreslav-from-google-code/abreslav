package msg.proxies.impl;

import msg.MsgFactory;
import msg.proxies.PackageProxy;

import org.eclipse.emf.common.util.EList;

import proxy.ProxyImpl;

public class PackageProxyImpl extends ProxyImpl<msg.Package> implements PackageProxy {

	public PackageProxyImpl(String name) {
		super(MsgFactory.eINSTANCE.createPackage());
		subject.setName(name);
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
