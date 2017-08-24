/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;

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
public abstract class SubSystemClassBase extends RTObject implements IEventReceiver, IInterfaceItemOwner {
	
	// variable service (is only instantiated if needed)
	protected IVariableService variableService = null;

	//--------------------- ports
	protected RTSystemConjPort RTSystemPort = null;
	
	//--------------------- interface item IDs
	protected static final int IFITEM_RTSystemPort = 0;
	
	private PathToThread path2thread = new PathToThread();
	
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
		// execute initial transition of all actor instances
		RTSystemPort.executeInitialTransition();
		
		// start all message services
		RTServices.getInstance().getMsgSvcCtrl().start();
		
		// start all actors
		for(IRTObject child : getChildren()) {
			if(child instanceof ActorClassBase)
				((ActorClassBase) child).start();
		}
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
		super.destroy();
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
	 * @return the thread ID for the given instance path
	 */
	public int getThreadForPath(String path) {
		Integer thread = path2thread.get(path);
		if (thread==null)
			return -1;
		
		return thread;
	}
	
	/**
	 * Clears thread and peer mappings.
	 */
	public void resetAll() {
		path2thread.clear();
	}
	
	/**
	 * @param optionalActorClass the name of the container class
	 * @param instanceActorClass the name of the instance class to be created
	 * @return the matching {@link IOptionalActorFactory} or {@code null}
	 */
	abstract public IOptionalActorFactory getFactory(String optionalActorClass, String instanceActorClass);
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.modelbase.IInterfaceItemOwner#getEventReceiver()
	 */
	@Override
	public IEventReceiver getEventReceiver() {
		return this;
	}
	
	@Override
	public int getThread() {
		return 0;
	}
	
	@Override
	public IReplicatedInterfaceItem getSystemPort() {
		return RTSystemPort;
	}

	public boolean hasGeneratedMSCInstrumentation() {
		return false;
	}
}
