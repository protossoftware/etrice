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
import java.util.List;

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
		IRTObject child = getChild(getChildName(idx));
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
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.modelbase.OptionalActorInterfaceBase#getPeersForPath(java.lang.String)
	 */
	@Override
	public List<String> getPeersForPath(String path) {
//		if (getPath2peers()==null)
//			return null;
//		
//		path = path.substring(getOwnPath().length(), path.lastIndexOf(INDEX_SEP));
//		return getPath2peers().get(path);
		return super.getPeersForPath(path);
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
