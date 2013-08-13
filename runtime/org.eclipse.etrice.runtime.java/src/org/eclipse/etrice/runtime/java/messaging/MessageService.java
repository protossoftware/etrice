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
public class MessageService extends AbstractMessageService {

	private boolean running = false;
	
	private Thread thread;
	private int priority;
	private long lastMessageTimestamp;

	public MessageService(IRTObject parent, ExecMode mode, int node, int thread, String name) {
		this(parent, mode, 0, node, thread, name, Thread.NORM_PRIORITY);
	}
	
	public MessageService(IRTObject parent, ExecMode mode, int nsec, int node, int thread, String name) {
		this(parent, mode, nsec, node, thread, name, Thread.NORM_PRIORITY);
	}
	
	public MessageService(IRTObject parent, ExecMode mode, int nsec, int node, int thread, String name, int priority) {
		super(parent, "MessageService_"+name, node, thread);
		
		this.priority = priority;

		assert priority >= Thread.MIN_PRIORITY : ("priority smaller than Thread.MIN_PRIORITY (1)"); 
		assert priority <= Thread.MAX_PRIORITY : ("priority bigger than Thread.MAX_PRIORITY (10)"); 
	}

	public void run() {
		running = true;
		
		while (running) {
			Message msg = null;
			
			// get next Message from Queue
			synchronized(this) {
				msg = getMessageQueue().pop();
			}
			
			if (msg == null) {
				// no message in queue -> wait until Thread is notified
				try {
					synchronized(this) {
						if (!running)
							return;
						wait();
					}
				}
				catch (InterruptedException e) {
				}
			}
			else {
				// process message
				lastMessageTimestamp = System.currentTimeMillis();
				getMessageDispatcher().receive(msg);
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.messaging.AbstractMessageService#receive(org.eclipse.etrice.runtime.java.messaging.Message)
	 */
	@Override
	public synchronized void receive(Message msg) {
		super.receive(msg);
		
		// wake up thread to process message
		notifyAll();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.messaging.AbstractMessageService#getFreeAddress()
	 */
	@Override
	public synchronized Address getFreeAddress() {
		return super.getFreeAddress();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.messaging.AbstractMessageService#addMessageReceiver(org.eclipse.etrice.runtime.java.messaging.IMessageReceiver)
	 */
	@Override
	public synchronized void addMessageReceiver(IMessageReceiver receiver) {
		super.addMessageReceiver(receiver);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.messaging.AbstractMessageService#removeMessageReceiver(org.eclipse.etrice.runtime.java.messaging.IMessageReceiver)
	 */
	@Override
	public synchronized void removeMessageReceiver(IMessageReceiver receiver) {
		super.removeMessageReceiver(receiver);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.messaging.AbstractMessageService#freeAddress(org.eclipse.etrice.runtime.java.messaging.Address)
	 */
	@Override
	public synchronized void freeAddress(Address addr) {
		super.freeAddress(addr);
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

	protected long getLastMessageTimestamp() {
		return lastMessageTimestamp;
	}

}
