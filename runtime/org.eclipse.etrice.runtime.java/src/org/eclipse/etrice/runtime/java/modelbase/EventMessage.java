/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.Message;

/**
 * A message carrying an event id.
 * 
 * @author Thomas Schuetz
 *
 */
public class EventMessage extends Message {

	private int evtId;

	public EventMessage(Address address, int evtId) {
		super(address);
		this.evtId = evtId;
	}

	public int getEvtId() {
		return evtId;
	}
	
	@Override
	public String toString() {
		return "EventMessage("+getAddress()+", evt="+evtId+")";
	}
}
