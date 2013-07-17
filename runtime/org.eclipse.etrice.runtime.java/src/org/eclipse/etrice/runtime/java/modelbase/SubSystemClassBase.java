/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.etrice.runtime.java.config.IVariableService;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IMessageService;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.RTObject;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
import org.eclipse.etrice.runtime.java.modelbase.RTSystemProtocol.RTSystemConjPort;

/**
 * The base class for all SubSystems.
 * It and its derived classes take care of the instantiation, binding (connection) and complete lifecycle of all Actor Classes of a SubSystem
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class SubSystemClassBase extends RTObject implements IEventReceiver{
	
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
	
	// variable service (is only instantiated if needed)
	protected IVariableService variableService = null;

	//--------------------- ports
	protected RTSystemConjPort RTSystemPort = null;
	
	//--------------------- interface item IDs
	protected static final int IFITEM_RTSystemPort = 0;
	
	private PathToThread path2thread = new PathToThread();
	private PathToPeers path2peers = new PathToPeers();
	
	// for tests only
	private TestSemaphore terminateSem=null;
	private int terminateCode;
	
	public SubSystemClassBase(IRTObject parent, String name) {
		super(parent, name);
		
		RTSystemPort = new RTSystemConjPort(this, IFITEM_RTSystemPort);

		DebuggingService.getInstance().getAsyncLogger()
				.setMSC(name + "_Async", "");
		DebuggingService.getInstance().getAsyncLogger().open();
		DebuggingService.getInstance().getSyncLogger()
				.setMSC(name + "_Sync", "");
		DebuggingService.getInstance().getSyncLogger().open();
		
		RTServices.getInstance().setSubSystem(this);
		
	}

	public void init() {

		System.out.println("*** MainComponent "+getInstancePath()+"::init ***");

		// MessageService
		instantiateMessageServices();
		
		// this is the place to connect the message services if necessary
		// normaly the ports will address the correct target message service directly
		// it is just for test purposes 
		// RTServices.getInstance().getMsgSvcCtrl().connectAll();
		
		instantiateActors();

		// initialize all actor instances
		for (IRTObject child : getChildren()) {
			if (child instanceof ActorClassBase)
				((ActorClassBase) child).init();
		}
	}

	public abstract void instantiateMessageServices();
	public abstract void instantiateActors();
	
	
	public void start() {
		// start all actors instances
		RTSystemPort.executeInitialTransition();
		
		// start all message services
		RTServices.getInstance().getMsgSvcCtrl().start();
		
	}
	
	public void stop() {
		System.out.println("*** MainComponent "+getInstancePath()+"::stop ***");
		
		RTServices.getInstance().getMsgSvcCtrl().stop();
		System.out.println("=== done stop MsgSvcCtrl");

		// stop all actor instances
		for (IRTObject child : getChildren()) {
			if (child instanceof ActorClassBase)
				((ActorClassBase) child).stop();
		}
		System.out.println("=== done stop actor instances");
	}
	
	public void destroy() {
		System.out.println("*** MainComponent "+getInstancePath()+"::destroy ***");
		for (IRTObject child : getChildren()) {
			if (child instanceof ActorClassBase)
				((ActorClassBase) child).destroy();
		}
		System.out.println("=== done destroy actor instances");

		DebuggingService.getInstance().getAsyncLogger().close();
		DebuggingService.getInstance().getSyncLogger().close();
		System.out.println("=== done close loggers");

		RTServices.getInstance().destroy();
		System.out.println("=== done destroy RTServices\n\n\n");
	}
	
	public IMessageService getMsgService(int idx) {
		return RTServices.getInstance().getMsgSvcCtrl().getMsgSvc(idx);
	}
	
	public Address getFreeAddress(int msgSvcId) {
		return getMsgService(msgSvcId).getFreeAddress();
	}

	public ActorClassBase getInstance(String path) {
		IRTObject object = getObject(path);
		
		if (object instanceof ActorClassBase)
			return (ActorClassBase) object;
		
		return null;
	}
	
	// this is to run integration tests
	public synchronized void setTerminateSemaphore(TestSemaphore sem){
		terminateCode = -1;
		terminateSem=sem;
	}
	
	public synchronized int getTerminateCode(){
		return terminateCode;
	}
	
	public void terminate(int errorCode){
		if (terminateSem != null) {
			//System.out.println("org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase.testFinished(int): before releasing semaphore");
			//testSem.printWaitingThreads();
			synchronized (this) {
				terminateCode = errorCode;
				terminateSem.release(1);
			}
			//System.out.println("org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase.testFinished(int): semaphore released");
			//testSem.printWaitingThreads();
			Thread.yield();
		}
	}

	public IVariableService getVariableService() {
		return variableService;
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
			return -1;
		
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
	 * add several peers to the given path
	 * @param path
	 * @param peers
	 */
	public void addPathToPeers(String path, String... peers) {
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
		path2peers.clear();
		path2thread.clear();
	}
}
