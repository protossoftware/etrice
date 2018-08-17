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

/**
 * This is the abstract base class for {@link GenFile} and {@link GenDir} which are
 * used to form a hierarchical tree structure of (relative) paths.
 * 
 * @author Henrik Rentz-Reichert
 */
public abstract class GenItem {
	
	/**
	 * the path separator
	 */
	public static final String PATH_SEP = "/";

	private GenDir parent;
	private String name;
	
	/**
	 * @param parent the parent directory
	 * @param name the name of this item
	 */
	public GenItem(GenDir parent, String name) {
		super();
		this.parent = parent;
		this.name = name;
		
		if (parent!=null)
			parent.getContents().add(this);
	}

	/**
	 * @return the item's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the parent directory
	 */
	public GenDir getParent() {
		return parent;
	}
	
	/**
	 * @return the path of this item with a trailing / ({@link #PATH_SEP})
	 */
	public String getPath() {
		if (parent==null)
			return "";
		
		return parent.getPath()+name+PATH_SEP;
	}
	
	/**
	 * @return the path of this item
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getPath();
	}
}