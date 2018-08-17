/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.LinkedList;

import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.RTServices;

/**
 * This class serves as base class for generated classes.
 * It specializes {@link OptionalActorInterfaceBase} for replicated optional actors.
 * 
 * @see OptionalActorInterfaceBase
 * 
 * @author Henrik Rentz-Reichert
 */
public class ReplicatedOptionalActorInterfaceBase extends OptionalActorInterfaceBase implements IPersistable {

	/**
	 * A separator for the index part of the name.
	 */
	private static final char INDEX_SEP = ':';
	
	/**
	 * A list of freed indices.
	 */
	private LinkedList<Integer> releasedIndices = new LinkedList<Integer>();
	
	/**
	 * All actor instances currently alive.
	 */
	private ArrayList<ActorClassBase> actors = new ArrayList<ActorClassBase>();

	/**
	 * The only constructor.
	 * 
	 * @param parent the parent event receiver
	 * @param name the name of the actor reference
	 * @param clsname the actor class name of the reference
	 */
	protected ReplicatedOptionalActorInterfaceBase(IEventReceiver parent, String name, String clsname) {
		super(parent, name, clsname);
	}
	
	/**
	 * This method instantiates and starts an optional actor (together with its contained instances).
	 * 
	 * @param actorClass the name of the actor class to be instantiated
	 * @param thread the ID of the message service (and thus the thread) for the newly created instances
	 * @return the index of the newly create instance or {@code -1} on failure
	 */
	public int createOptionalActor(String actorClass, int thread) {
		return createOptionalActor(actorClass, thread, null);
	}
	
	/**
	 * This method instantiates and starts an optional actor (together with its contained instances).
	 * 
	 * @param actorClass the name of the actor class to be instantiated
	 * @param thread the ID of the message service (and thus the thread) for the newly created instances
	 * @param input an optional {@link ObjectInput}
	 * @return the index of the newly create instance or {@code -1} on failure
	 */
	public int createOptionalActor(String actorClass, int thread, ObjectInput input) {
		setSubtreeThread(thread);
		
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
	
		startupSubTree(actor, input);
		
		return index;
	}
	
	/**
	 * Destroys an actor instance of this array.
	 * Before actual destruction the instances are shut down properly.
	 * 
	 * @param idx the index of the instance to be destroyed
	 * @return {@code true} on success, {@code false} else
	 */
	public boolean destroyOptionalActor(int idx) {
		return destroyOptionalActor(idx, null);
	}
	
	/**
	 * Destroys an actor instance of this array.
	 * Before actual destruction the instances are shut down properly.
	 * 
	 * @param idx the index of the instance to be destroyed
	 * @param output an optional {@link ObjectOutput}
	 * @return {@code true} on success, {@code false} else
	 */
	public boolean destroyOptionalActor(int idx, ObjectOutput output) {
		String childName = getChildName(idx);
		logDeletion(childName);
		IRTObject child = getChild(childName);
		if (!(child instanceof ActorClassBase))
			return false;
		
		shutdownSubTree((ActorClassBase)child, output);
		
		((ActorClassBase)child).destroy();
		releasedIndices.push(idx);
		actors.remove(child);
		
		return true;
	}
	
	/**
	 * Destroys all instances in the array.
	 * Before actual destruction the instances are shut down properly.
	 */
	public void destroyAllOptionalActors() {
		destroyAllOptionalActors(null);
	}
	
	/**
	 * Destroys all instances in the array.
	 * Before actual destruction the instances are shut down properly.
	 * 
	 * @param output an optional {@link ObjectOutput}
	 */
	public void destroyAllOptionalActors(ObjectOutput output) {
		for (ActorClassBase actor : actors) {
			shutdownSubTree(actor, output);
			actor.destroy();
			int idx = Integer.parseInt(actor.getName().substring(getName().length()));
			releasedIndices.push(idx);
		}
		actors.clear();
	}
	
	/**
	 * Composes a name with an index for a child instance.
	 * 
	 * @param idx the index to be used
	 * @return the composed name of the form &lt;name>:&lt;idx>
	 */
	public String getChildName(int idx) {
		return getName()+INDEX_SEP+idx;
	}
	
	/**
	 * @return the next free index
	 */
	private int getFreeIndex() {
		if (releasedIndices.isEmpty())
			return actors.size();
		else
			return releasedIndices.pop();
	}

	public String toString(){
		return "ReplicatedOptionalActorInterface(className="+getClassName()+", instancePath="+getInterfaceInstancePath()+")";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.modelbase.IPersistable#saveObject(java.io.ObjectOutput)
	 */
	@Override
	public void saveObject(ObjectOutput output) throws IOException {
		output.writeInt(actors.size());
		for (ActorClassBase actor : actors) {
			output.writeUTF(actor.getClassName());
			output.writeInt(actor.getThread());
			int idx = Integer.parseInt(actor.getName().substring(actor.getName().indexOf(INDEX_SEP)+1));
			output.writeInt(idx);
			saveActor(actor, output);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.modelbase.IPersistable#loadObject(java.io.ObjectInput)
	 */
	@Override
	public void loadObject(ObjectInput input) throws IOException, ClassNotFoundException {
		int size = input.readInt();
		for (int i=0; i<size; ++i) {
			String className = input.readUTF();
			int thread = input.readInt();
			int idx = input.readInt();
			releasedIndices.add(idx);	// will be used as next index
			createOptionalActor(className, thread, input);
		}
	}

}
