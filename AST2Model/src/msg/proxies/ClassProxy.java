package msg.proxies;

import proxies.Proxy;

public interface ClassProxy extends msg.Class, Proxy {
	FieldProxy lookupField(String name);
}
