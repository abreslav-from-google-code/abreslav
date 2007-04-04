package ru.ifmo.rain.astrans.asttomodel;

import java.io.File;

/**
 * Use to maintin relative paths when resolving files
 */
public interface IFileResolver {
	File getFile(String fileName);
}
