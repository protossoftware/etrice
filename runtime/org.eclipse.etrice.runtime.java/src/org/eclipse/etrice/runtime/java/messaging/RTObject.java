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
		
		if (parent!=null)
			parent.getChildren().add(this);
	}

	public String getName() {
		return name;
	}
	
	public IRTObject getParent() {
		return parent;
	}

	public ArrayList<IRTObject> getChildren() {
		return children;
	}

	protected void destroy() {
		for (IRTObject child : children) {
			if (child instanceof RTObject)
				((RTObject) child).destroy();
		}
		
		parent.getChildren().remove(this);
		
		parent = null;
	}
	
	public IRTObject getRoot() {
		IRTObject root = parent;
		while (root.getParent()!=null)
			root = root.getParent();
		
		return root;
	}
	
	public IRTObject getChild(String name) {
		for (IRTObject child : children) {
			if (child.getName().equals(name))
				return child;
		}
		
		return null;
	}
	
	public IRTObject getObject(String path) {
		boolean isAbsolute = path.charAt(0)==PATH_DELIM;
		if (isAbsolute)
			path = path.substring(1);
		String[] segments = path.split(Character.toString(PATH_DELIM));

		if (segments.length>0) {
			IRTObject current = isAbsolute? getRoot() : this;
			
			
			String first = segments[0];
			for (String segment : segments) {
				if (segment==first) {
					if (!segment.equals(current.getName()))
						return null;
				}
				else {
					current = current.getChild(segment);
					if (current==null)
						return null;
				}
			}
			return current;
		}
		
		return null;
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
