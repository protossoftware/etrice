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

import java.util.List;

import org.eclipse.etrice.runtime.java.messaging.IRTObject;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class DataSendPort extends DataPortBase {

	public DataSendPort(IRTObject parent, String name, int localId) {
		super(parent, name, localId);
		
		List<String> peerPaths = getParent().getPeersForPath(getInstancePath());
		if (peerPaths!=null) {
			for (String peerPath : peerPaths) {
				IRTObject object = getObject(peerPath);
				if (object instanceof DataReceivePort)
					((DataReceivePort)object).connect(this);
			}
		}
	}
}
