/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.messaging;

/**
 * A message sent by the messaging.
 * Messages can by linked together.
 * 
 * @author Thomas Schuetz
 *
 */
public class Message {
	private Address address = null;
	private Message next = null;
	
	public Message(Address address){
		setAddress(address);
	}
	
	public void setNext(Message msg){this.next = msg;}
	public Message getNext() {return next;}
	
	public void setAddress(Address address){
		this.address = address;
	}
	public Address getAddress(){
		return this.address;
	}

	public String toString(){
		return "Message("+address+")";
	}
}
