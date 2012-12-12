/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;

import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.RTObject;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
import org.eclipse.etrice.runtime.java.messaging.RTSystemServicesProtocol.RTSystemServicesProtocolConjPortRepl;

/**
 * The base class for all SubSystems.
 * It and its derived classes take care of the instantiation, binding (connection) and complete lifecycle of all Actor Classes of a SubSystem
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class SubSystemClassBase extends RTObject implements IEventReceiver{

	//--------------------- ports
	protected RTSystemServicesProtocolConjPortRepl RTSystemPort = null;
	//--------------------- interface item IDs
	protected static final int IFITEM_RTSystemPort = 0;
	protected ActorClassBase[] instances = null;
	private TestSemaphore testSem=null;
	private int testErrorCode;
	
	public SubSystemClassBase(String name) {
		super(null, name);

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
		if (instances!=null)
			for (int i = 0; i < instances.length; i++) {
				instances[i].init();
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
		if (instances!=null)
			for (int i = 0; i < instances.length; i++) {
				instances[i].stop();
			}
		System.out.println("=== done stop actor instances");
	}
	
	public void destroy() {
		System.out.println("*** MainComponent "+getInstancePath()+"::destroy ***");
		if (instances!=null)
			for (int i = 0; i < instances.length; i++) {
				instances[i].destroy();
			}
		System.out.println("=== done destroy actor instances");

		DebuggingService.getInstance().getAsyncLogger().close();
		DebuggingService.getInstance().getSyncLogger().close();
		System.out.println("=== done close loggers");

		RTServices.getInstance().destroy();
		System.out.println("=== done destroy RTServices\n\n\n");
	}
	
	public MessageService getMsgService(int idx) {
		return RTServices.getInstance().getMsgSvcCtrl().getMsgSvc(idx);
	}
	
	public Address getFreeAddress(int msgSvcId) {
		return getMsgService(msgSvcId).getFreeAddress();
	}
	
	public ActorClassBase getInstance(int i) {
		if (instances==null || i<0 || i>= instances.length)
			return null;
		
		return instances[i];
	}
	
	public ActorClassBase getInstance(String path) {
		if (instances!=null)
			for (int i = 0; i < instances.length; i++) {
				if (instances[i].getInstancePath().equals(path))
					return instances[i];
			}
		
		return null;
	}
	
	// this is to run integration tests
	public synchronized void setTestSemaphore(TestSemaphore sem){
		testErrorCode = -1;
		testSem=sem;
	}
	
	public synchronized int getTestErrorCode(){
		return testErrorCode;
	}
	
	public void testFinished(int errorCode){
		if (testSem != null) {
			System.out.println("org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase.testFinished(int): before releasing semaphore");
			//testSem.printWaitingThreads();
			synchronized (this) {
				testErrorCode = errorCode;
				testSem.release(1);
			}
			System.out.println("org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase.testFinished(int): semaphore released");
			//testSem.printWaitingThreads();
			Thread.yield();
		}
	}
}
