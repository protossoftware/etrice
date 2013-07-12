/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.messaging;

import java.util.List;

/**
 * The runtime object interface
 * @author Thomas Schuetz
 * @author Henrik Rentz-Reichert
 *
 */
public interface IRTObject {

	static final char PATH_DELIM = '/';
	static final char PATHNAME_DELIM = '_';
	static final String NO_NAME = "<no name>";

	String getName();
	List<IRTObject> getChildren();
	IRTObject getParent();
	IRTObject getRoot();
	IRTObject getChild(String name);
	IRTObject getObject(String path);
	
	String getInstancePath(char delim);
	String getInstancePath();
	String getInstancePathName();
}
