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

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;


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

	private long pollingInterval = -1;
	private ScheduledExecutorService pollingScheduler = null;

	public MessageService(IRTObject parent, ExecMode mode, int node, int thread, String name) {
		this(parent, mode, 0, node, thread, name, Thread.NORM_PRIORITY);
	}

	public MessageService(IRTObject parent, ExecMode mode, long nsec, int node, int thread, String name) {
		this(parent, mode, nsec, node, thread, name, Thread.NORM_PRIORITY);
	}

	public MessageService(IRTObject parent, ExecMode mode, long nsec, int node, int thread, String name, int priority) {
		super(parent, "MessageService_"+name, node, thread);

		// Java thread priority is limited to 1-10 and cannot be changed
		// thus priorities from physical mapping are not generated
		// priority = Thread.NORM_PRIORITY generated fixed
		this.priority = priority;

		assert priority >= Thread.MIN_PRIORITY : ("priority smaller than Thread.MIN_PRIORITY (" + "Thread.MIN_PRIORITY" + ")");
		assert priority <= Thread.MAX_PRIORITY : ("priority bigger than Thread.MAX_PRIORITY (" + "Thread.MAX_PRIORITY" + ")");

		if(mode == ExecMode.MIXED || mode == ExecMode.POLLED){
			pollingInterval = nsec;
			pollingScheduler = Executors.newScheduledThreadPool(1, new PollingThreadFactory());

			assert pollingInterval > 0 : ("polling interval is 0 or negative");
		}
	}

	public void run() {
		running = true;

		if(pollingScheduler != null) {
			pollingScheduler.scheduleAtFixedRate(new PollingTask(), pollingInterval, pollingInterval, TimeUnit.NANOSECONDS);
		}

		while(true) {
			Message msg = null;
			
			synchronized(this) {
				while(getMessageQueue().isEmpty() && running) {
					// no message in queue -> wait until Thread is notified
					try {
						wait();
					}
					catch (InterruptedException e) {}
				}
				if(!running) {
					return;
				}
				else {
					// get next Message from Queue
					msg = getMessageQueue().pop();
				}
			}
			
			// process message
			lastMessageTimestamp = System.currentTimeMillis();
			getMessageDispatcher().receive(msg);
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

	@Override
	public synchronized void addPollingMessageReceiver(IMessageReceiver receiver) {
		super.addPollingMessageReceiver(receiver);
	}

	@Override
	public synchronized void removePollingMessageReceiver(IMessageReceiver receiver) {
		super.removePollingMessageReceiver(receiver);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.messaging.AbstractMessageService#freeAddress(org.eclipse.etrice.runtime.java.messaging.Address)
	 */
	@Override
	public synchronized void freeAddress(Address addr) {
		super.freeAddress(addr);
	}

	public synchronized void terminate() {
		if(pollingScheduler != null)
			pollingScheduler.shutdown();

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

	private class PollingTask implements Runnable{

		@Override
		public void run() {
			if(running){
				Message msg = new Message(getMessageDispatcher().getAddress());
				receive(msg);
			}
		}

	}

	private class PollingThreadFactory implements ThreadFactory{

		@Override
		public Thread newThread(Runnable arg0) {
			Thread thread = new Thread(arg0, getName()+"_PollingThread");
			thread.setPriority(priority);

			return thread;
		}

	}

}
