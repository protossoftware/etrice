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

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.Message;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class SystemMessage extends Message {

	enum Reason {
		DISCONNECT
	}

	private Reason reason;

	/**
	 * @param address
	 */
	public SystemMessage(Address address, Reason reason) {
		super(address);
		this.reason = reason;
	}
	
	/**
	 * @return the reason
	 */
	public Reason getReason() {
		return reason;
	}

}
