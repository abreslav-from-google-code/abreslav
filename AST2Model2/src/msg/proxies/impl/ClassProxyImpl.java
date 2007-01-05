package msg.proxies.impl;
import msg.Class;
import msg.Field;
import msg.MsgFactory;
import msg.Package;
import msg.proxies.ClassProxy;
import msg.proxies.FieldProxy;

import org.eclipse.emf.common.util.EList;

import proxy.Namespace;
import proxy.ProxyImpl;

public class ClassProxyImpl extends ProxyImpl<msg.Class> implements ClassProxy {

	private final Namespace<String, Field, FieldProxy> fields = new Namespace<String, Field, FieldProxy>() {
		@Override
		protected FieldProxy createElement(String key) {
			return new FieldProxyImpl(key);
		}
	};

	public ClassProxyImpl(String key) {
		super(MsgFactory.eINSTANCE.createClass());
		subject.setName(key);
	}
	
	public Namespace<String, Field, FieldProxy> getFieldNS() {
		return fields;
	}
	
	/* Delegation part */
	
	public EList getMembers() {
		return subject.getMembers();
	}

	public String getName() {
		return subject.getName();
	}

	public Package getPackage() {
		return subject.getPackage();
	}

	public Class getSuper() {
		return subject.getSuper();
	}

	public void setName(String value) {
		subject.setName(value);
	}

	public void setPackage(Package value) {
		subject.setPackage(value);
	}

	public void setSuper(Class value) {
		subject.setSuper(value);
	}

}
