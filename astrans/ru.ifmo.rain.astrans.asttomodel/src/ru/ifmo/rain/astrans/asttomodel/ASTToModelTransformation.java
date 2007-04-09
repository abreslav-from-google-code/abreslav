package ru.ifmo.rain.astrans.asttomodel;

import java.util.ArrayList;
import java.util.List;

public abstract class ASTToModelTransformation<R, T> {
	private final R resolver;
	private final T trace;
	
	private final List<Runnable> commands = new ArrayList<Runnable>();
	
	protected ASTToModelTransformation(ITransformationContextFactory<R, T> contextFactory) {
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
	
	protected R getResolver() {
		return resolver;
	}
	
	protected T getTrace() {
		return trace;
	}
}
