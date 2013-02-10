/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.base;

/**
 * this object represents a (generated) file in a file system
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class GenFile extends GenItem {

	/**
	 * @param parent the parent directory
	 * @param name the name of this file
	 */
	public GenFile(GenDir parent, String name) {
		super(parent, name);
	}
	
	/**
	 * @return the file name with the extension stripped of (if there)
	 */
	public String getBaseName() {
		int pos = getName().lastIndexOf('.');
		if (pos>=0)
			return getName().substring(0, pos);
		else
			return getName();
	}
	
	@Override
	public String getPath() {
		String path = super.getPath();
		return path.substring(0, path.length()-1);
	}
	
	/**
	 * @return the extension of this file or an empty string if no extensions exists
	 */
	public String getExtension() {
		int pos = getName().lastIndexOf('.');
		if (pos>=0)
			return getName().substring(pos+1);
		else
			return "";
	}
}