/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.messaging;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.messaging.Message;

// this class is purely for testing purposes
// it remembers the last receive message
public class DummyMessageReceiver extends RTObject implements IMessageReceiver {

	DummyMessageReceiver (Address address){
		super(null, "dummy");
		this.address = address;
	}
	
	public void receive(Message msg) {
		last_received_message = msg;
	}

	public Address getAddress() {
		// TODO Auto-generated method stub
		return this.address;
	}
	
	public Message getLastReceivedMessage(){
		return last_received_message;
	}
	
	private Message last_received_message = null;
	private Address address = null;
	
	@Override
	public String getInstancePath(char delim) {
		return null;
	}
	
	@Override
	public String getInstancePath() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getInstancePathName() {
		// TODO Auto-generated method stub
		return null;
	}

}
