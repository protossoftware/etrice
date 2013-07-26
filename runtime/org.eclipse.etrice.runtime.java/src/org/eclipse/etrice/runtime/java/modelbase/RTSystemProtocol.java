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

import org.eclipse.etrice.runtime.java.modelbase.RTSystemServicesProtocol.RTSystemServicesProtocolConjReplPort;
import org.eclipse.etrice.runtime.java.modelbase.RTSystemServicesProtocol.RTSystemServicesProtocolPort;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class RTSystemProtocol {
	
	private static final String RT_SYSTEM_PORT_NAME = "RTSystemPort";
	
	public static class RTSystemPort extends RTSystemServicesProtocolPort {
	
		public RTSystemPort(IInterfaceItemOwner actor, int localId) {
			super(actor, RT_SYSTEM_PORT_NAME, localId);
			
			// since we have no mapping for the system ports we connect them directly here
			IReplicatedInterfaceItem systemPort = actor.getSystemPort();
			if (systemPort!=null) {
				InterfaceItemBase peer = systemPort.createSubInterfaceItem();
				connectWith(peer);
			}
		}
		
		@Override
		protected void destroy() {
			super.destroy();
		}
	
	}
	
	public static class RTSystemConjPort extends RTSystemServicesProtocolConjReplPort {

		public RTSystemConjPort(IInterfaceItemOwner actor, int localId) {
			super(actor, RT_SYSTEM_PORT_NAME, localId);
		}
		
	}
}
