/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;

import org.eclipse.etrice.runtime.java.config.IVariableService;
import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.RTSystemProtocol.RTSystemPort;


/**
 * The base class for model actor classes.
 * 
 * @author Thomas Schuetz
 *
 */
public abstract class ActorClassBase extends EventReceiver implements IMessageReceiver {

	protected static final int EVT_SHIFT = 1000;	// TODOHRR: use 256 or shift operation later

	protected static final int NO_STATE = 0;
	protected static final int STATE_TOP = 1;

	protected static final int NOT_CAUGHT = 0;

	protected static final int IFITEM_RTSystemPort = 0;
	
	private String className = "noname";

	/**
	 * the current state
	 */
	protected int state;

	protected RTSystemPort rtSystemPort = null;
	
	public ActorClassBase(IRTObject parent, String name) {
		super(parent, name);
		
		// own ports
		rtSystemPort = new RTSystemPort(this, IFITEM_RTSystemPort);
	}

	public String toString(){
		return "ActorClass(className="+className+", instancePath="+getInstancePath()+")";
	}
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public Address getAddress() {
		// TODO: Actor should have its own address for services and debugging
		return null;
	}
	
	public SubSystemClassBase getSubSystem() {
		// the sub system could be cached
		// but it is rarely used so we just compute it every time
		IRTObject p = getParent();
		while (p!=null) {
			if (p instanceof SubSystemClassBase)
				return (SubSystemClassBase) p;
			p = p.getParent();
		}
		return null;
	}
	
	public IVariableService getVariableService() {
		// the variable service could be cached
		// but variable service operations are costly so it doesn't hurt if we compute it every time
		SubSystemClassBase ssc = getSubSystem();
		if (ssc==null)
			return null;
		
		return ssc.getVariableService();
	}
	
	//--------------------- lifecycle functions
	public void init() {
		for (IRTObject child : getChildren()) {
			if (child instanceof ActorClassBase)
				((ActorClassBase) child).init();
		}
		
		initUser();
	}

	public void start() {
		for (IRTObject child : getChildren()) {
			if (child instanceof ActorClassBase)
				((ActorClassBase) child).start();
		}

		startUser();
	}
	
	public void stop() {
		stopUser();

		for (IRTObject child : getChildren()) {
			if (child instanceof ActorClassBase)
				((ActorClassBase) child).stop();
		}
	}
	
	public void destroy() {
		for (IRTObject child : getChildren()) {
			if (child instanceof ActorClassBase)
				((ActorClassBase) child).destroy();
		}
	}
	
	public abstract void executeInitTransition();

	// not automatically generated lifecycle functions
	// are called, but with empty implementation -> can be overridden by user
	public void initUser(){}
	public void startUser(){}
	public void stopUser(){}

	@Override
	public void receive(Message msg) {
	}
	
	public int getState() {
		return state;
	}
	
	protected boolean handleSystemEvent(InterfaceItemBase ifitem, int evt, Object generic_data){
		if (ifitem.getLocalId()!=0){
			return false;
		}
		
		switch (evt){
		case RTSystemServicesProtocol.IN_executeInitialTransition :
			executeInitTransition();
			break;
		case RTSystemServicesProtocol.IN_startDebugging :
			break;
		case RTSystemServicesProtocol.IN_stopDebugging :
			break;		
		}
		return true;
	}
}
