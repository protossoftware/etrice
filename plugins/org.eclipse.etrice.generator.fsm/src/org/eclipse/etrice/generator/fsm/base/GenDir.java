package org.eclipse.etrice.generator.fsm.base;

import java.util.ArrayList;

/**
 * This class is derived from {@link GenItem} and represents a directory which can have
 * {@link GenItem}s as children.
 * 
 * @author Henrik Rentz-Reichert
 */
public class GenDir extends GenItem {
	private ArrayList<GenItem> contents = new ArrayList<GenItem>();
	
	/**
	 * @param parent the parent directory
	 * @param name this directory's name
	 */
	public GenDir(GenDir parent, String name) {
		super(parent, name);
	}
	
	/**
	 * @return a list of all child {@link GenItem}s
	 */
	public ArrayList<GenItem> getContents() {
		return contents;
	}
	
	/**
	 * @return a list of all child {@link GenFile}s
	 */
	public ArrayList<GenFile> getFiles() {
		ArrayList<GenFile> sources = new ArrayList<GenFile>();
		for (GenItem item : contents) {
			if (item instanceof GenFile)
				sources.add((GenFile) item);
		}
		return sources;
	}
	
	/**
	 * @return a list of all child {@link GenDir}s
	 */
	public ArrayList<GenDir> getDirs() {
		ArrayList<GenDir> dirs = new ArrayList<GenDir>();
		for (GenItem item : contents) {
			if (item instanceof GenDir)
				dirs.add((GenDir) item);
		}
		return dirs;
	}
	
	/**
	 * @param ext a file extension
	 * @return a list of paths relative to this directory of directories that contain files
	 * with the given extension 
	 */
	public ArrayList<String> getNestedRelativePathsWithExtension(String ext) {
		ArrayList<String> dirs = new ArrayList<String>();
		for (GenItem item : contents) {
			if (item instanceof GenDir)
				if (((GenDir)item).hasFilesWithExtension(ext))
					dirs.add(item.getName());
				else {
					ArrayList<String> nested = ((GenDir)item).getNestedRelativePathsWithExtension(ext);
					for (String ndir : nested) {
						dirs.add(((GenDir)item).getName()+"/"+ndir);
					}
				}
		}
		return dirs;
	}
	
	/**
	 * @param ext
	 * @return <code>true</code> if this directory contains files with the given extension
	 */
	public boolean hasFilesWithExtension(String ext) {
		ArrayList<GenFile> sources = getFiles();
		for (GenFile source : sources) {
			if (source.getExtension().equals(ext))
				return true;
		}
		return false;
	}
}