package msg.proxies.impl;
import msg.AccessModifier;
import msg.Field;
import msg.MsgFactory;
import msg.Type;
import msg.proxies.FieldProxy;
import proxy.ProxyImpl;

public class FieldProxyImpl extends ProxyImpl<Field> implements FieldProxy {

	public FieldProxyImpl(String name) {
		super(MsgFactory.eINSTANCE.createField());
		subject.setName(name);
	}

	public AccessModifier getAccessModifier() {
		return subject.getAccessModifier();
	}

	public String getName() {
		return subject.getName();
	}

	public Type getType() {
		return subject.getType();
	}

	public boolean isFinal() {
		return subject.isFinal();
	}

	public void setAccessModifier(AccessModifier value) {
		subject.setAccessModifier(value);
	}

	public void setFinal(boolean value) {
		subject.setFinal(value);
	}

	public void setName(String value) {
		subject.setName(value);
	}

	public void setType(Type value) {
		subject.setType(value);
	}
	
}
