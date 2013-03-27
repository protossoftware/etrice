/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;

import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.RTObject;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class DataPortBase extends RTObject {

	private int localId;
	
	/**
	 * @param parent
	 * @param name
	 */
	protected DataPortBase(IRTObject parent, String name, int localId) {
		super(parent, name);
	}

	public int getLocalId() {
		return localId;
	}

}
