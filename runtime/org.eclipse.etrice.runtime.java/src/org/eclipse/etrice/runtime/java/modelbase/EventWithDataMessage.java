/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;

import org.eclipse.etrice.runtime.java.messaging.Address;

/**
 * An event message carrying an arbitrary number of objects.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class EventWithDataMessage extends EventMessage {

	private Object data = null;

	public EventWithDataMessage(Address address, int evtId, Object data) {
		super(address, evtId);
		this.data = data;
	}

	public Object getData() {
		return data;
	}
	
	@Override
	public String toString() {
		return "EventWithDataMessage("+getAddress()+", evt="+getEvtId()+", data="+dataToString()+")";
	}
	
	public String dataToString() {
		if (data==null)
			return "()";
		
		return "("+data+")";
	}
}
