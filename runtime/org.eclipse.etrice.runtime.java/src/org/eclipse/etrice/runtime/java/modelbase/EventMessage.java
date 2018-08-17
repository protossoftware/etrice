/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
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
