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

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.eclipse.etrice.runtime.java.messaging.RTServices;

/**
 * This class serves as base class for generated classes.
 * It specializes {@link OptionalActorInterfaceBase} for scalar optional actors.
 * 
 * @see OptionalActorInterfaceBase
 * 
 * @author Henrik Rentz-Reichert
 */
public class ScalarOptionalActorInterfaceBase extends OptionalActorInterfaceBase implements IPersistable {

	/**
	 * Our single actor instance or {@code null} if not instantiated or destroyed.
	 */
	private ActorClassBase actor = null;

	/**
	 * The only constructor.
	 * 
	 * @param parent the parent event receiver
	 * @param name the name of the actor reference
	 * @param clsname the actor class name of the reference
	 */
	protected ScalarOptionalActorInterfaceBase(IEventReceiver parent, String name, String clsname) {
		super(parent, name, clsname);
	}

	/**
	 * This method instantiates and starts an optional actor (together with its contained instances).
	 * 
	 * @param actorClass the name of the actor class to be instantiated
	 * @param thread the ID of the message service (and thus the thread) for the newly created instances
	 * @return {@code true} on success or {@code false} on failure
	 */
	public boolean createOptionalActor(String actorClass, int thread) {
		return createOptionalActor(actorClass, thread, null);
	}
	
	/**
	 * This method instantiates and starts an optional actor (together with its contained instances).
	 * 
	 * @param actorClass the name of the actor class to be instantiated
	 * @param thread the ID of the message service (and thus the thread) for the newly created instances
	 * @param input an optional {@link ObjectInput}
	 * @return {@code true} on success or {@code false} on failure
	 */
	public boolean createOptionalActor(String actorClass, int thread, ObjectInput input) {
		if (actor!=null)
			return false;
		
		setSubtreeThread(thread);
		
		// SubSystemClass.createOptionalActor() will set our PathTo* maps
		IOptionalActorFactory factory = RTServices.getInstance().getSubSystem().getFactory(getClassName(), actorClass);
		if (factory==null)
			return false;
		
		// the factory will set our path2peers map
		logCreation(actorClass, getName());
		actor = factory.create(this, getName());
	
		startupSubTree(actor, input);
		
		return actor!=null;
	}
	
	/**
	 * Destroys our actor instance.
	 * Before actual destruction the instances are shut down properly.
	 * 
	 * @return {@code true} on success, {@code false} else
	 */
	public boolean destroyOptionalActor() {
		return destroyOptionalActor(null);
	}
	
	/**
	 * Destroys our actor instance.
	 * Before actual destruction the instances are shut down properly.
	 * 
	 * @param output an optional {@link ObjectOutput}
	 * @return {@code true} on success, {@code false} else
	 */
	public boolean destroyOptionalActor(ObjectOutput output) {
		if (actor==null)
			return false;
		
		logDeletion(getName());
		
		shutdownSubTree(actor, output);
		
		actor.destroy();
		actor = null;
		
		return true;
	}

	public String toString(){
		return "ScalarOptionalActorInterface(className="+getClassName()+", instancePath="+getInterfaceInstancePath()+")";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.modelbase.IPersistable#saveObject(java.io.ObjectOutput)
	 */
	@Override
	public void saveObject(ObjectOutput output) throws IOException {
		output.writeBoolean(actor!=null);
		if (actor!=null) {
			output.writeUTF(actor.getClassName());
			output.writeInt(actor.getThread());
			saveActor(actor, output);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.modelbase.IPersistable#loadObject(java.io.ObjectInput)
	 */
	@Override
	public void loadObject(ObjectInput input) throws IOException, ClassNotFoundException {
		boolean haveActor = input.readBoolean();
		if (haveActor) {
			String className = input.readUTF();
			int thread = input.readInt();
			createOptionalActor(className, thread, input);
		}
	}

}
