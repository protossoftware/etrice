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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
	private LinkedList<IMessageService> orderedMessageServices = new LinkedList<IMessageService>();
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
		orderedMessageServices.add(msgSvc);
	}

	public synchronized void removeMsgSvc(IMessageService msgSvc){
		messageServices.remove(msgSvc.getAddress().threadID);
		orderedMessageServices.remove(msgSvc);
	}
	
	public synchronized IMessageService getMsgSvc(int id){
		return messageServices.get(id);
	}
	
	public void start() {
		Comparator<Thread> descendingPrioComparator = new Comparator<Thread>(){

			@Override
			public int compare(Thread o1, Thread o2) {
				if(o1.getPriority() > o2.getPriority())
					return -1;
				if(o1.getPriority() < o2.getPriority())
					return 1;
				return 0;
			}
		};
		
		// start all message services
		List<Thread> threads = new ArrayList<Thread>(messageServices.size());
		for (IMessageService msgSvc : orderedMessageServices){
			Thread thread = new Thread(msgSvc, msgSvc.getName());
			msgSvc.setThread(thread);
			threads.add(thread);
		}
		
		Collections.sort(threads, descendingPrioComparator);
		for(Thread thread : threads){
			thread.start();
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
		for (Iterator<IMessageService> it = orderedMessageServices.descendingIterator(); it.hasNext(); ) {
			it.next().terminate();
		}
	}

	/**
	 * waitTerminate waits blocking for all MessageServices to terminate 
	 * ! not thread safe !
	 */
	public void waitTerminate() {
		for (Iterator<IMessageService> it = orderedMessageServices.descendingIterator(); it.hasNext(); ) {
			try {
				IMessageService msgSvc = it.next();
				if (msgSvc.getThread()==null)
					continue;
				
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
		orderedMessageServices.clear();
		freeIDs.clear();
		nextFreeID = 0;
	}
}
