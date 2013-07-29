/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;

import org.eclipse.etrice.runtime.java.messaging.RTServices;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class ScalarOptionalActorInterfaceBase extends OptionalActorInterfaceBase {

	private ActorClassBase actor = null;

	/**
	 * @param parent
	 * @param name
	 * @param clsname
	 */
	public ScalarOptionalActorInterfaceBase(IEventReceiver parent, String name, String clsname) {
		super(parent, name, clsname);
	}

	public boolean createOptionalActor(String actorClass, int thread) {
		if (actor!=null)
			return false;
		
		setSubtreeThread(thread);
		
		// make sure the path is up to date
		setOwnPath(getInstancePath());
		
		// SubSystemClass.createOptionalActor() will set our PathTo* maps
		IOptionalActorFactory factory = RTServices.getInstance().getSubSystem().getFactory(getClassName(), actorClass);
		if (factory==null)
			return false;
		
		// the factory will set our path2peers map
		logCreation(actorClass, getName());
		actor = factory.create(this, getName());
	
		startSubTree();
		
		return actor!=null;
	}
	
	/**
	 * @param idx
	 * @return
	 */
	public boolean destroyOptionalActor() {
		if (actor==null)
			return false;
		
		logDeletion(getName());
		
		actor.destroy();
		actor = null;
		
		return true;
	}

	public String toString(){
		return "ScalarOptionalActorInterface(className="+getClassName()+", instancePath="+getInstancePath()+")";
	}

}
