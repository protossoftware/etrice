/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz
 * 
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.messaging;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * The MessageServiceController controls life cycle of and access to all MessageServices in one SubSystem.
 * 
 * @author Thomas Schuetz
 * @author Thomas Jung
 * @author Henrik Rentz-Reichert
 *
 */

public class MessageServiceController {
	
	private HashMap<Integer, IMessageService> messageServices = new HashMap<Integer, IMessageService>();
	private LinkedList<Integer> freeIDs = new LinkedList<Integer>();
	private boolean running = false;
	private int nextFreeID = 0;

	public synchronized int getNewID() {
		if (freeIDs.isEmpty())
			return nextFreeID++;
		else
			return freeIDs.remove();
	}
	
	public synchronized void freeID(int id) {
		freeIDs.add(id);
	}
	
	public synchronized void addMsgSvc(IMessageService msgSvc){
		if (nextFreeID<=msgSvc.getAddress().threadID)
			nextFreeID = msgSvc.getAddress().threadID+1;
		
		messageServices.put(msgSvc.getAddress().threadID, msgSvc);
	}

	public synchronized void removeMsgSvc(IMessageService msgSvc){
		messageServices.remove(msgSvc.getAddress().threadID);
	}
	
	public synchronized IMessageService getMsgSvc(int id){
		return messageServices.get(id);
	}
	
	public void start() {
		// start all message services
		for (IMessageService msgSvc : messageServices.values()){
			Thread thread = new Thread(msgSvc, msgSvc.getName());
			msgSvc.setThread(thread);
			thread.start();
			// TODOTS: start in order of priorities
		}
		running = true;
	}

	public void stop() {
		if (!running)
			return;
		
		//dumpThreads("org.eclipse.etrice.runtime.java.messaging.MessageServiceController.stop()");
		terminate();
		waitTerminate();
		
		running = false;
	}

	/**
	 * @param msg 
	 * 
	 */
	protected void dumpThreads(String msg) {
		System.out.println("<<< begin dump threads <<<");
		System.out.println("=== "+msg);
		Map<Thread, StackTraceElement[]> traces = Thread.getAllStackTraces();
		for (Thread thread : traces.keySet()) {
			System.out.println("thread "+thread.getName());
			StackTraceElement[] elements = traces.get(thread);
			int n = 2;
			if (elements.length<n)
				n = elements.length;
			for (int i = 0; i < n; i++) {
				System.out.println(" "+elements[i].toString());
			}
		}
		System.out.println(">>> end dump threads >>>");
	}

	private void terminate() {
		// terminate all message services
		for (IMessageService msgSvc : messageServices.values()){
			msgSvc.terminate();
			// TODOTS: stop in order of priorities
		}
	}

	/**
	 * waitTerminate waits blocking for all MessageServices to terminate 
	 * ! not thread safe !
	 */
	public void waitTerminate() {
		for (IMessageService msgSvc : messageServices.values()) {
			try {
				msgSvc.getThread().join(1000);	// wait at most 1000ms
				if (msgSvc.getThread().isAlive())
					System.out.println("### Message Service "
							+ msgSvc.getName() + " could not be stopped");
			}
			catch (InterruptedException e1) {
			}
		}
	}
	
	public synchronized void resetAll() {
		stop();
		messageServices.clear();
		freeIDs.clear();
		nextFreeID = 0;
	}
}
