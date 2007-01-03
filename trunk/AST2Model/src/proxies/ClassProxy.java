package proxies;
import java.util.Collection;

import msg.Class;
import msg.Field;
import msg.Package;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.validation.util.FilteredCollection;

public class ClassProxy extends Proxy<msg.Class> implements msg.Class {

	private final String name;
	private final Namespace<Field> fields = new Namespace<Field>() {
		@Override
		protected Collection getNamedElements() {
			return pResolved() ? getFC() : null;
		}				

		private Collection getFC() {
			FilteredCollection fc = new FilteredCollection(getMembers(), new FilteredCollection.Filter() {
				public boolean accept(Object obj) {
					return obj instanceof Field;
				}
			});
			return fc;
		}
		
		@Override
		protected Field createNSObjectWithKey(String key) {
			return new FieldProxy(key);
		}
	}; 
	
	public ClassProxy(String name) {
		this.name = name;
	}

	public ClassProxy(msg.Class subject) {
		this(subject.getName());
		pSetSubject(subject);
	}

	public String getName() {
		return pResolved() ? pSubject().getName() : name;
	}

	public EList getMembers() {
		assertResolved();
		return pSubject().getMembers();
	}

	public Package getPackage() {
		assertResolved();
		return pSubject().getPackage();
	}

	public void setName(String value) {
		assertResolved();
		pSubject().setName(value);
	}

	public void setPackage(Package value) {
		assertResolved();
		pSubject().setPackage(value);
	}

	public Class getSuper() {
		assertResolved();
		return pSubject().getSuper();
	}

	public void setSuper(Class value) {
		assertResolved();
		pSubject().setSuper(value);
	}
	
	public Field lookupField(String name) {
		return fields.get(name);
	}
}
