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
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
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
	
	@SuppressWarnings("serial")
	private static class PathToThread extends HashMap<String, Integer> {}
	@SuppressWarnings("serial")
	private static class PathToPeers extends HashMap<String, ArrayList<String>> {
		public void put(String key, String value) {
			ArrayList<String> list = get(key);
			if (list==null) {
				list = new ArrayList<String>();
				put(key, list);
			}
			list.add(value);
		}
		
		public void put(String key, Collection<String> values) {
			ArrayList<String> list = get(key);
			if (list==null) {
				list = new ArrayList<String>(values);
				put(key, list);
			}
			else
				list.addAll(values);
		}
		
		public void put(String key, String[] values) {
			List<String> list = Arrays.asList(values);
			put(key, list);
		}
	}
	
	private List<MessageService> messageServiceList = null;
	private PathToThread path2thread = new PathToThread();
	private PathToPeers path2peers = new PathToPeers();
	private boolean running = false;

	public MessageServiceController(/*IRTObject parent*/){
		// TODOTS: Who is parent of MessageServices and Controller?
		// this.parent = parent;
		messageServiceList = new ArrayList<MessageService>();
	}

	public void addMsgSvc(MessageService msgSvc){
		// TODOTS: Who is parent of MessageServices ?
		assert(msgSvc.getAddress().threadID == messageServiceList.size());
		messageServiceList.add(msgSvc);
	}
	
	public int getNMsgSvc() {
		return messageServiceList.size();
	}
	
	public MessageService getMsgSvc(int threadID){
		assert(threadID < messageServiceList.size());
		return messageServiceList.get(threadID);
	}
	
	public void start() {
		// start all message services
		for (MessageService msgSvc : messageServiceList){
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
		for (MessageService msgSvc : messageServiceList){
			msgSvc.terminate();
			// TODOTS: stop in order of priorities
		}
	}

	/**
	 * waitTerminate waits blocking for all MessageServices to terminate 
	 * ! not threadsafe !
	 */
	public void waitTerminate() {
		for (MessageService msgSvc : messageServiceList) {
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
	
	/**
	 * map a path to a thread id 
	 * @param path
	 * @param thread
	 */
	public void addPathToThread(String path, int thread) {
		path2thread.put(path, thread);
	}
	
	/**
	 * get thread for path
	 * @param path
	 * @return
	 */
	public int getThreadForPath(String path) {
		Integer thread = path2thread.get(path);
		if (thread==null)
			return 0;
		
		return thread;
	}
	
	/**
	 * add a peer for the given path
	 * @param path
	 * @param peer
	 */
	public void addPathToPeer(String path, String peer) {
		path2peers.put(path, peer);
	}
	
	/**
	 * add a collection of peers to the given path
	 * @param path
	 * @param peers
	 */
	public void addPathToPeers(String path, Collection<String> peers) {
		path2peers.put(path, peers);
	}
	
	/**
	 * add an array of peers to the given path
	 * @param path
	 * @param peers
	 */
	public void addPathToPeers(String path, String[] peers) {
		path2peers.put(path, peers);
	}
	
	/**
	 * @param path
	 * @return list of peer paths
	 */
	public List<String> getPeersForPath(String path) {
		return path2peers.get(path);
	}
	
	public void resetAll() {
		stop();
		messageServiceList.clear();
		path2peers.clear();
		path2thread.clear();
	}
}
