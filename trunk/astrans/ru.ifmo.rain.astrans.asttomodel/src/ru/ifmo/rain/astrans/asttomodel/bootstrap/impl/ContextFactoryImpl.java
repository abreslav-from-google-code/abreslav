package ru.ifmo.rain.astrans.asttomodel.bootstrap.impl;

import ru.ifmo.rain.astrans.asttomodel.IResolver;
import ru.ifmo.rain.astrans.asttomodel.ITrace;
import ru.ifmo.rain.astrans.asttomodel.ITransformationContextFactory;
import astrans.AstransPackage;

public class ContextFactoryImpl implements ITransformationContextFactory {

	private final IResolver resolver;
	private final ITrace trace;
	
	public ContextFactoryImpl(String rootPath) {
		TraceImpl traceImpl = new TraceImpl();
		trace = traceImpl; 
		resolver = new ResolverImpl(AstransPackage.eINSTANCE, traceImpl, new FileResolver(rootPath));
	}
	
	public IResolver createResolver() {
		return resolver;
	}

	public ITrace createTrace() {
		return trace;
	}

}
