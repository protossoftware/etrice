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
import org.eclipse.etrice.runtime.java.messaging.RTServices;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class DataReceivePort extends DataPortBase {

	/**
	 * @param parent
	 * @param name
	 */
	protected DataReceivePort(IRTObject parent, String name, int localId) {
		super(parent, name, localId);

		List<String> peerPaths = RTServices.getInstance().getMsgSvcCtrl().getPeersForPath(getInstancePath());
		if (peerPaths!=null && !peerPaths.isEmpty()) {
			IRTObject object = getObject(peerPaths.get(0));
			connect((DataSendPort) object);
		}
	}

	/**
	 * @param dataSendPort
	 */
	abstract protected void connect(DataSendPort dataSendPort);

}
