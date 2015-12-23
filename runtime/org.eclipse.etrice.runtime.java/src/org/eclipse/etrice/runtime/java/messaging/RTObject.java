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

	@Override
	public String getName() {
		return name;
	}

	@Override
	public IRTObject getParent() {
		return parent;
	}

	@Override
	public ArrayList<IRTObject> getChildren() {
		return children;
	}

	protected void destroy() {
		while (!children.isEmpty()) {
			IRTObject child = children.get(0);
			if (child instanceof RTObject)
				((RTObject) child).destroy();
		}

		if (parent!=null) {
			parent.getChildren().remove(this);
			parent = null;
		}
	}

	@Override
	public IRTObject getRoot() {
		IRTObject root = this;
		while (root.getParent()!=null)
			root = root.getParent();

		return root;
	}

	@Override
	public IRTObject getChild(String name) {
		for (IRTObject child : children) {
			if (child.getName().equals(name))
				return child;
		}

		return null;
	}

	@Override
	public IRTObject getObject(String path) {
		boolean isAbsolute = path.charAt(0)==PATH_DELIM;
		if (isAbsolute && getParent()!=null)
			return getParent().getObject(path);

		if (isAbsolute)
			path = path.substring(1);

		String[] segments = path.split(Character.toString(PATH_DELIM));

		if (segments.length>0) {
			IRTObject current = this;

			String first = segments[0];
			for (String segment : segments) {
				if (isAbsolute && segment==first) {
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

	@Override
	public String getInstancePath(char delim) {
		String path = delim + name;

		if (parent!=null)
			path = parent.getInstancePath(delim)+path;

		return path;
	}

	@Override
	public String getInstancePath() {
		return getInstancePath(PATH_DELIM);
	}

	@Override
	public String getInstancePathName() {
		return getInstancePath(PATHNAME_DELIM);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.messaging.IRTObject#getThreadForPath(java.lang.String)
	 */
	@Override
	public int getThreadForPath(String path) {
		if (parent!=null)
			return parent.getThreadForPath(path);
		return -1;
	}

	private String toStringRecursive(String indent) {
		StringBuilder result = new StringBuilder(indent+toString()+"\n");

		indent = "  "+indent;
		for (IRTObject child : getChildren()) {
			if (child instanceof RTObject)
				result.append(((RTObject)child).toStringRecursive(indent));
			else
				result.append(child.toString()+"\n");
		}
		return result.toString();
	}

	public String toStringRecursive() {
		return toStringRecursive("");
	}

	@Override
	public String toString() {
		return getName();
	}
}
