package msg.proxies;

import msg.Field;
import proxy.Namespace;
import proxy.Proxy;

public interface ClassProxy extends msg.Class, Proxy<msg.Class> {
	Namespace<String, Field, FieldProxy> getFieldNS();
}
