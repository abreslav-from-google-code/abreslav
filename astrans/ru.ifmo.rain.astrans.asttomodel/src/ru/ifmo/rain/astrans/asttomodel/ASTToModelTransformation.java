package ru.ifmo.rain.astrans.asttomodel;

import java.util.ArrayList;
import java.util.List;

public class ASTToModelTransformation {
	private final IResolver resolver;
	private final ITrace trace;
	
	private final List<Runnable> commands = new ArrayList<Runnable>();
	
	public ASTToModelTransformation(ITransformationContextFactory contextFactory) {
		trace = contextFactory.createTrace(); 
		resolver = contextFactory.createResolver();
	}

	protected void addCommand(Runnable command) {
		commands.add(command);
	}
	
	protected void performAllCommands() {
		for (Runnable command : commands) {
			command.run();			
		}
	}
	
	protected IResolver getResolver() {
		return resolver;
	}
	
	protected ITrace getTrace() {
		return trace;
	}
}
