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

import java.util.ArrayList;
import java.util.LinkedList;

import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.RTServices;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class ReplicatedOptionalActorInterfaceBase extends OptionalActorInterfaceBase {

	private static final char INDEX_SEP = ':';
	private LinkedList<Integer> releasedIndices = new LinkedList<Integer>();
	private ArrayList<ActorClassBase> actors = new ArrayList<ActorClassBase>();

	/**
	 * @param parent
	 * @param name
	 * @param clsname
	 */
	public ReplicatedOptionalActorInterfaceBase(IEventReceiver parent, String name, String clsname) {
		super(parent, name, clsname);
	}
	
	public int createOptionalActor(String actorClass, int thread) {
		setSubtreeThread(thread);
		
		// make sure the path is up to date
		setOwnPath(getInstancePath());
		
		IOptionalActorFactory factory = RTServices.getInstance().getSubSystem().getFactory(getClassName(), actorClass);
		if (factory==null)
			return -1;
		
		// the factory will set our path2peers map
		int index = getFreeIndex();
		String name = getChildName(index);
		logCreation(actorClass, name);
		ActorClassBase actor = factory.create(this, name);
		if (actor==null)
			return -1;
		
		actors.add(actor);
		
		startSubTree();
		
		return index;
	}
	
	/**
	 * @param idx
	 * @return
	 */
	public boolean destroyOptionalActor(int idx) {
		String childName = getChildName(idx);
		logDeletion(childName);
		IRTObject child = getChild(childName);
		if (!(child instanceof ActorClassBase))
			return false;
		
		((ActorClassBase)child).destroy();
		releasedIndices.push(idx);
		actors.remove(child);
		
		return true;
	}
	
	public void destroyAllOptionalActors() {
		for (ActorClassBase actor : actors) {
			actor.destroy();
			int idx = Integer.parseInt(actor.getName().substring(getName().length()));
			releasedIndices.push(idx);
		}
		actors.clear();
	}
	
	public String getChildName(int idx) {
		return getName()+INDEX_SEP+idx;
	}
	
	private int getFreeIndex() {
		if (releasedIndices.isEmpty())
			return actors.size();
		else
			return releasedIndices.pop();
	}

	public String toString(){
		return "ReplicatedOptionalActorInterface(className="+getClassName()+", instancePath="+getInstancePath()+")";
	}

}
