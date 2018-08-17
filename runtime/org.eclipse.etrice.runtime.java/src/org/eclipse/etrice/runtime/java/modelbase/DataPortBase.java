/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
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

	public static void connect(IRTObject obj, String path1, String path2) {
		IRTObject obj1 = obj.getObject(path1);
		IRTObject obj2 = obj.getObject(path2);
		if (obj1 instanceof DataSendPort && obj2 instanceof DataReceivePort) {
			((DataReceivePort)obj2).connect((DataSendPort) obj1);
		}
		else if (obj2 instanceof DataSendPort && obj1 instanceof DataReceivePort) {
			((DataReceivePort)obj1).connect((DataSendPort) obj2);
		}
	}
}
