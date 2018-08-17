/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.messaging;

import java.util.List;

/**
 * The runtime object interface for all runtime objects. Those objects form a tree with a single root.
 * Since each object has a name it also has a unique path in the tree.
 * 
 * @author Thomas Schuetz
 * @author Henrik Rentz-Reichert
 *
 */
/**
 * @author hrentz
 *
 */
public interface IRTObject {

	/**
	 * The delimiter character for path segments.
	 */
	static final char PATH_DELIM = '/';
	
	/**
	 * The delimiter character for path segments when the path should be used as name.
	 */
	static final char PATHNAME_DELIM = '_';
	
	/**
	 * An empty name.
	 */
	static final String NO_NAME = "<no name>";

	/**
	 * @return the name of the object (has to be unique among siblings)
	 */
	String getName();
	
	/**
	 * @return a list of all child objects
	 */
	List<IRTObject> getChildren();
	
	/**
	 * @return the parent object in the instance tree
	 */
	IRTObject getParent();
	
	/**
	 * @return the root object of the tree (that has no parent)
	 */
	IRTObject getRoot();
	
	/**
	 * @param name the name of a child
	 * @return the child with the given name or {@code null} if not found
	 */
	IRTObject getChild(String name);
	
	/**
	 * @param path a path with segments delimited by {@link #PATH_DELIM}. It can be relative or absolute.
	 * @return the object with this instance path or {@code null}
	 */
	IRTObject getObject(String path);
	
	/**
	 * @param delim a delimiter character
	 * @return the path with segments delimited by the given character
	 */
	String getInstancePath(char delim);
	
	/**
	 * @return the absolute instance path of this object using {@link #PATH_DELIM}
	 */
	String getInstancePath();
	
	/**
	 * @return the absolute instance path of this object using {@link #PATHNAME_DELIM}
	 */
	String getInstancePathName();
	
	/**
	 * @param path an absolute path
	 * @return the thread to which this path is mapped (used to query this path from the parent object or from the sub system)
	 */
	int getThreadForPath(String path);
}
