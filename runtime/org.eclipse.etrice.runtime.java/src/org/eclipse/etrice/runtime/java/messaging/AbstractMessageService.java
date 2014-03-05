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

package org.eclipse.etrice.runtime.java.messaging;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class AbstractMessageService extends RTObject implements IMessageService {

	private MessageSeQueue messageQueue = null;
	private MessageDispatcher messageDispatcher = null;
	private Address address = null;

	/**
	 * @param parent
	 * @param name
	 * @param node
	 * @param thread
	 */
	public AbstractMessageService(IRTObject parent, String name, int node, int thread) {
		super(parent, name);

		address = new Address(node, thread, 0);
		
		// instantiate dispatcher and queue
		messageDispatcher = new MessageDispatcher(this, new Address(address.nodeID,address.threadID, address.objectID + 1), "Dispatcher");
		messageQueue = new MessageSeQueue(this, "Queue");
	}

	@Override
	public Address getAddress() {
		return address;
	}

	public Address getFreeAddress() {
		return messageDispatcher.getFreeAddress();
	}

	public void freeAddress(Address addr) {
		messageDispatcher.freeAddress(addr);
	}

	@Override
	public void addMessageReceiver(IMessageReceiver receiver) {
		messageDispatcher.addMessageReceiver(receiver);
	}

	@Override
	public void removeMessageReceiver(IMessageReceiver receiver) {
		messageDispatcher.removeMessageReceiver(receiver);
	}
	
	@Override
	public void addPollingMessageReceiver(IMessageReceiver receiver) {
		messageDispatcher.addPollingMessageReceiver(receiver);
	}

	@Override
	public void removePollingMessageReceiver(IMessageReceiver receiver) {
		messageDispatcher.removePollingMessageReceiver(receiver);
	}

	protected MessageSeQueue getMessageQueue() {
		return messageQueue;
	}

	protected MessageDispatcher getMessageDispatcher() {
		return messageDispatcher;
	}

	@Override
	public void receive(Message msg) {
		if (msg!=null) {
			messageQueue.push(msg);
		}
	}

}
