package ru.ifmo.rain.astrans.asttomodel;

import java.io.File;

public class FileResolver implements IFileResolver {

	private final File root;
		
	public FileResolver(final File root) {
		this.root = root;
	}

	public FileResolver(final String rootPath) {
		this.root = new File(rootPath);
	}

	public File getFile(String fileName) {
		return new File(root, fileName);
	}

}
