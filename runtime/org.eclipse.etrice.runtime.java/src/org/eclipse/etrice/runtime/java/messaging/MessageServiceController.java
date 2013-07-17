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
	
	private List<IMessageService> messageServiceList = null;
	private boolean running = false;

	public MessageServiceController(/*IRTObject parent*/){
		// TODOTS: Who is parent of MessageServices and Controller?
		// this.parent = parent;
		messageServiceList = new ArrayList<IMessageService>();
	}

	public void addMsgSvc(IMessageService msgSvc){
		// TODOTS: Who is parent of MessageServices ?
		assert(msgSvc.getAddress().threadID == messageServiceList.size());
		messageServiceList.add(msgSvc);
	}
	
	public int getNMsgSvc() {
		return messageServiceList.size();
	}
	
	public IMessageService getMsgSvc(int threadID){
		assert(threadID < messageServiceList.size());
		return messageServiceList.get(threadID);
	}
	
	public void start() {
		// start all message services
		for (IMessageService msgSvc : messageServiceList){
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
		for (IMessageService msgSvc : messageServiceList){
			msgSvc.terminate();
			// TODOTS: stop in order of priorities
		}
	}

	/**
	 * waitTerminate waits blocking for all MessageServices to terminate 
	 * ! not threadsafe !
	 */
	public void waitTerminate() {
		for (IMessageService msgSvc : messageServiceList) {
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
	
	public void resetAll() {
		stop();
		messageServiceList.clear();
}
}
