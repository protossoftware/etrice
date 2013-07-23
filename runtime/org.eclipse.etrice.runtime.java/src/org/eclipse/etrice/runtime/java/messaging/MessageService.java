/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/


package org.eclipse.etrice.runtime.java.messaging;


/**
 * The MessageService is the backbone of the asynchronous communication inside a SubSystem
 * It usually contains a thread a message queue and a dispatcher
 * 
 * @author Thomas Schuetz (initial contribution)
 * @author Henrik Rentz-Reichert (extending RTObject, implementing Runnable)
 *
 */
public class MessageService extends RTObject implements IMessageService {

	private boolean running = false;
	
	// TODO: add internal message queue for less locks (faster thread internal messaging)
	private MessageSeQueue messageQueue = null;
	private MessageDispatcher messageDispatcher = null;
	private Address address = null;
	private long lastMessageTimestamp;
	private Thread thread;
	private int priority;

	public MessageService(IRTObject parent, ExecMode mode, int node, int thread, String name) {
		this(parent, mode, 0, node, thread, name, Thread.NORM_PRIORITY);
	}
	
	public MessageService(IRTObject parent, ExecMode mode, int nsec, int node, int thread, String name) {
		this(parent, mode, nsec, node, thread, name, Thread.NORM_PRIORITY);
	}
	
	public MessageService(IRTObject parent, ExecMode mode, int nsec, int node, int thread, String name, int priority) {
		super(parent, "MessageService_"+name);
		
		address = new Address(node, thread, 0);
		this.priority = priority;

		assert priority >= Thread.MIN_PRIORITY : ("priority smaller than Thread.MIN_PRIORITY (1)"); 
		assert priority <= Thread.MAX_PRIORITY : ("priority bigger than Thread.MAX_PRIORITY (10)"); 

		// instantiate dispatcher and queue
		messageDispatcher = new MessageDispatcher(this, new Address(address.nodeID,address.threadID, address.objectID + 1), "Dispatcher");
		messageQueue = new MessageSeQueue(this, "Queue");
	}

	@Override
	public Address getAddress() {
		return address;
	}

	public synchronized void run() {
		running = true;
		while (running) {
			pollOneMessage();
		}
	}

	@Override
	public synchronized void receive(Message msg) {
		if (msg!=null) {
			messageQueue.push(msg);
			notifyAll(); // wake up thread to compute message
		}
	}

	private synchronized void pollOneMessage() {
		Message msg = messageQueue.pop(); // get next Message from Queue
		if (msg == null) {
			// no message in queue -> wait till Thread is notified
			try {
				wait();
			}
			catch (InterruptedException e) {
			}
		}
		else {
			lastMessageTimestamp = System.currentTimeMillis();
			messageDispatcher.receive(msg);
		}

	}

	public Address getFreeAddress() {
		return messageDispatcher.getFreeAddress();
	}
	
	public void freeAddress(Address addr) {
		messageDispatcher.freeAddress(addr);
	}
	
	// protected methods for sole use by test cases
	protected MessageSeQueue getMessageQueue() {
		return messageQueue;
	}

	public synchronized MessageDispatcher getMessageDispatcher() {
		return messageDispatcher;
	}

	protected synchronized long getLastMessageTimestamp() {
		return lastMessageTimestamp;
	}
	
	public synchronized void terminate() {
		if (running) {
			running = false;
			notifyAll();
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.messaging.IMessageService#setThread(java.lang.Thread)
	 */
	public void setThread(Thread thread) {
		this.thread = thread;
		
		thread.setPriority(priority);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.messaging.IMessageService#getThread()
	 */
	public Thread getThread() {
		return thread;
	}

}
