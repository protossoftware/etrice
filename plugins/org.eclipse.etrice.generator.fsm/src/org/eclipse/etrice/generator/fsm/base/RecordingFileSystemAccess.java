/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.fsm.base;

import java.io.File;
import java.util.ArrayList;

import org.eclipse.xtext.generator.JavaIoFileSystemAccess;

/**
 * a {@link JavaIoFileSystemAccess} which is recording the generated files
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class RecordingFileSystemAccess extends JavaIoFileSystemAccess {

	private ArrayList<String> files = new ArrayList<String>();
	
	@Override
	public void generateFile(String fileName, String slot, CharSequence contents) {
		String outlet = getPathes().get(slot);
		if (outlet!=null) {
			String pathName = toSystemFileName(outlet + "/" + fileName);
			files.add(pathName);
		}
		super.generateFile(fileName, slot, contents);
	}
	
	/**
	 * @return a list of the generated files (their paths relative to the output)
	 */
	public ArrayList<String> getFiles() {
		return files;
	}
	
	/**
	 * @param path a folder path
	 * @param extension a file extension
	 * @return a list of files contained in the specified folder and
	 * 		its sub folders filtered by extension
	 */
	public ArrayList<String> getFiles(String path, String extension) {
		ArrayList<String> result = new ArrayList<String>();
		
		path = toSystemFileName(path);
		getFilesRecursively(path, result, extension);
		
		return result;
	}

	private void getFilesRecursively(String path, ArrayList<String> result, String extension) {
		File file = new File(path);
		if (file.isDirectory()) {
			if (!file.getName().equals(".svn")) {
				String[] contents = file.list();
				for (String sub : contents) {
					getFilesRecursively(path+File.separator+sub, result, extension);
				}
			}
		}
		else {
			if (file.getName().endsWith(extension))
				result.add(file.getAbsolutePath());
		}
	}
}
