package msg.proxies;

import proxy.Namespace;
import proxy.Proxy;

public interface PackageProxy extends msg.Package, Proxy<msg.Package> {
	Namespace<String, msg.Package, PackageProxy> getSubpackageNS();
	Namespace<String, msg.Class, ClassProxy> getClassNS();
}
