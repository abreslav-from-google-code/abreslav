package proxies;
import msg.AccessModifier;
import msg.Field;
import msg.Type;

public class FieldProxy extends Proxy<Field> implements Field {
	private final String name;
	
	public FieldProxy(String name) {
		this.name = name; 
	}

	public String getName() {
		return pResolved() ? pSubject().getName() : name;
	}
	
	public AccessModifier getAccessModifier() {
		assertResolved();
		return pSubject().getAccessModifier();
	}

	public Type getType() {
		assertResolved();
		return pSubject().getType();
	}

	public boolean isFinal() {
		assertResolved();
		return pSubject().isFinal();
	}

	public void setAccessModifier(AccessModifier value) {
		assertResolved();
		pSubject().setAccessModifier(value);
	}

	public void setFinal(boolean value) {
		assertResolved();
		pSubject().setFinal(value);
	}

	public void setName(String value) {
		assertResolved();
		pSubject().setName(value);
	}

	public void setType(Type value) {
		assertResolved();
		pSubject().setName(getName());
	}

}
