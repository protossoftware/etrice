/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.messaging;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The message dispatcher class used by the MessageService.
 * 
 * @author Thomas Schuetz
 *
 */
public class MessageDispatcher extends RTObject implements IMessageReceiver {

	private HashMap<Number, IMessageReceiver> local_map = new HashMap<Number, IMessageReceiver>();
	private HashMap<Number, IMessageReceiver> thread_map = new HashMap<Number, IMessageReceiver>();
	private HashMap<Number, IMessageReceiver> node_map = new HashMap<Number, IMessageReceiver>();
	private ArrayList<Address> freeAdresses = new ArrayList<Address>();
	
	private Address address = null;
	private int nextFreeObjId = 1;

	public MessageDispatcher(IRTObject parent, Address addr, String name){
		super(parent, name);
		address = addr;
	}
	
	public Address getFreeAddress() {
		if (freeAdresses.isEmpty()) {
			return new Address(getAddress().nodeID, getAddress().threadID, nextFreeObjId++);
		}
		else
			return freeAdresses.remove(0);
	}
	
	public void freeAddress(Address addr) {
		freeAdresses.add(addr);
	}
	
	public void addMessageReceiver(IMessageReceiver receiver){
		if (receiver.getAddress()==null)
			return;
		
		// TODO: does only work same thread (else)
		if (receiver.getAddress().nodeID != address.nodeID){
			node_map.put(receiver.getAddress().objectID, receiver);
		}
		else if(receiver.getAddress().threadID != address.threadID){
			thread_map.put(receiver.getAddress().threadID, receiver);
		}
		else {
			local_map.put(receiver.getAddress().objectID, receiver);
		}
	}
	
	@Override
	public void receive(Message msg) {
		// TODO: does only work same thread (else)
		IMessageReceiver receiver = null;
		if (msg.getAddress().nodeID != address.nodeID){
			receiver = node_map.get(msg.getAddress().objectID);
		}
		else if(msg.getAddress().threadID != address.threadID){
			receiver = thread_map.get(msg.getAddress().threadID);
		}
		else {
			// Same node, same thread -> local call Dispatch Map
			receiver = local_map.get(msg.getAddress().objectID);
		}
		if(receiver!=null)
		{
			receiver.receive(msg);
			// TODO: error handling for not found addresses
		}
	}
	
	@Override
	public Address getAddress() {
		return address;
	}
}
