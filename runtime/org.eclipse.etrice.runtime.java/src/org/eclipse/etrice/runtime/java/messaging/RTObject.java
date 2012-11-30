/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.messaging;

import java.util.ArrayList;

/**
 * An implementation of the IRTObject interface using a hierarchical structure
 * to assemble paths.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class RTObject implements IRTObject	{

	private String name = NO_NAME;
	private IRTObject parent = null;
	ArrayList<IRTObject> children = new ArrayList<IRTObject>();
	
	protected RTObject(IRTObject parent, String name){
		this.parent = parent;
		this.name = name;
		if (parent instanceof RTObject)
			((RTObject) parent).children.add(this);
	}

	protected void destroy() {
		for (IRTObject child : children) {
			if (child instanceof RTObject)
				((RTObject) child).destroy();
		}
		
		if (parent instanceof RTObject)
			((RTObject) parent).children.remove(this);
		
		parent = null;
	}
	
	public IRTObject getParent() {
		return parent;
	}
	
	public String getInstancePath(char delim) {
		String path = delim + name;
		
		if (parent!=null)
			path = parent.getInstancePath(delim)+path;
		
		return path;
	}
	
	public String getInstancePath() {
		return getInstancePath(PATH_DELIM);
	}

	public String getInstancePathName() {
		return getInstancePath(PATHNAME_DELIM);
	}
}
