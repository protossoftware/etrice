/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.messaging;

import java.util.LinkedList;
import java.util.HashMap;

/**
 * The message dispatcher class used by the MessageService.
 * 
 * @author Thomas Schuetz (initial contribution)
 * @author Henrik Rentz-Reichert (address management)
 *
 */
public class MessageDispatcher extends RTObject implements IMessageReceiver {

	private HashMap<Number, IMessageReceiver> local_map = new HashMap<Number, IMessageReceiver>();
	private LinkedList<Address> freeAdresses = new LinkedList<Address>();
	
	private Address address = null;
	private int nextFreeObjId;

	public MessageDispatcher(IRTObject parent, Address addr, String name){
		super(parent, name);
		address = addr;
		nextFreeObjId = addr.objectID+1;
	}
	
	public Address getFreeAddress() {
		if (freeAdresses.isEmpty()) {
			return new Address(getAddress().nodeID, getAddress().threadID, nextFreeObjId++);
		}
		else
			return freeAdresses.remove();
	}
	
	public void freeAddress(Address addr) {
		freeAdresses.add(addr);
	}
	
	public void addMessageReceiver(IMessageReceiver receiver){
		if (receiver.getAddress()==null)
			return;
		
		if (receiver.getAddress().nodeID == address.nodeID
				&& receiver.getAddress().threadID == address.threadID) {
			local_map.put(receiver.getAddress().objectID, receiver);
		}
	}
	
	public void removeMessageReceiver(IMessageReceiver receiver){
		if (receiver.getAddress()==null)
			return;
		
		if (receiver.getAddress().nodeID == address.nodeID
				&& receiver.getAddress().threadID == address.threadID) {
			local_map.remove(receiver.getAddress().objectID);
		}
	}
	
	@Override
	public void receive(Message msg) {
		if (msg.getAddress().nodeID == address.nodeID
				&& msg.getAddress().threadID == address.threadID) {
			IMessageReceiver receiver = local_map.get(msg.getAddress().objectID);
			if(receiver!=null) {
				receiver.receive(msg);
			}
			else {
				// TODO: error handling for not found addresses
			}
		}
	}
	
	@Override
	public Address getAddress() {
		return address;
	}
}
