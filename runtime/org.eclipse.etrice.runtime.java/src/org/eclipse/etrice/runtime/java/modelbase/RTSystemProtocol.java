/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
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
import org.eclipse.etrice.runtime.java.modelbase.RTSystemServicesProtocol.RTSystemServicesProtocolConjReplPort;
import org.eclipse.etrice.runtime.java.modelbase.RTSystemServicesProtocol.RTSystemServicesProtocolPort;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class RTSystemProtocol {
	
	private static final String RT_SYSTEM_PORT_NAME = "RTSystemPort";
	
	public static class RTSystemPort extends RTSystemServicesProtocolPort {
	
		public RTSystemPort(IEventReceiver actor, int localId) {
			super(actor, RT_SYSTEM_PORT_NAME, localId);
			
			// since we have no mapping for the system ports we connect them directly here
			IRTObject root = getRoot();
			IRTObject sysport = root.getChild(RT_SYSTEM_PORT_NAME);
			if (sysport!=null) {
				InterfaceItemBase peer = ((IReplicatedInterfaceItem) sysport).createSubInterfaceItem();
				connectWith(peer);
			}
		}
	
	}
	
	public static class RTSystemConjPort extends RTSystemServicesProtocolConjReplPort {

		public RTSystemConjPort(IEventReceiver actor, int localId) {
			super(actor, RT_SYSTEM_PORT_NAME, localId);
		}
		
	}
}
