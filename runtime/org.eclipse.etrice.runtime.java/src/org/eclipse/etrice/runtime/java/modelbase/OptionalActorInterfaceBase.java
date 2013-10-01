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

import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.modelbase.RTSystemProtocol.RTSystemConjPort;

/**
 * This is the abstract base class of all optional actor interfaces.
 * Concrete sub classes are {@link ScalarOptionalActorInterfaceBase} and {@link ReplicatedOptionalActorInterfaceBase}.
 * <p>
 * The code generator again derives from the concrete sub classes and adds {@link InterfaceItemBroker}s as members.
 * </p>
 * <p>
 * This generated class is instantiated as member of the containing actor (the one holding the associated optional
 * actor reference).
 * </p>
 * <p>
 * The broker items are responsible for the mediation of the port connections.
 * </p>
 * <p>
 * This interface represents a border in the instance tree. We call all direct and indirect children
 * the <i>interior</i> part of the instance tree and the remainder the <i>exterior</i> part.
 * In order to have natural path names of the interior we have to omit this interface's segment.
 * Because it is repeated by the instantiated optional actor. This is done by the overridden
 * {@link #getInstancePath(char)}. As a consequence we also have to override {@link #getObject(String)}.
 * This method turns the path into a relative one and then retrieves the object starting at this
 * instance.
 * </p>
 * 
 * @author Henrik Rentz-Reichert
 */
public abstract class OptionalActorInterfaceBase extends SystemPortOwner implements IEventReceiver {

	protected static final int IFITEM_RTSystemPort = 0;
	
	/**
	 * The name of the optional actor class. This and all sub classes of it are valid candidates
	 * for instantiation at this place.
	 */
	private String className;
	
	/**
	 * The thread (associated with the message service of this ID) that will be used by the
	 * optional actor instance.
	 */
	private int subtreeThread;
	
	/**
	 * This port is used to send system messages to the optional sub instance tree.
	 */
	private RTSystemConjPort RTSystemPort = null;
	
	/**
	 * The only constructor.
	 * 
	 * @param parent the containing {@link ActorClassBase}
	 * @param name the reference name
	 * @param clsname the class name of this reference
	 */
	protected OptionalActorInterfaceBase(IEventReceiver parent, String name, String clsname) {
		super(parent, name);
		className = clsname;
		subtreeThread = parent.getThread();
		
		RTSystemPort = new RTSystemConjPort(this, IFITEM_RTSystemPort);
	}
	
	/**
	 * The regular instance path is changed here by omitting our segment.
	 * 
	 * @see org.eclipse.etrice.runtime.java.messaging.RTObject#getInstancePath(char)
	 */
	@Override
	public String getInstancePath(char delim) {
		// the parent is never null for optional actors
		return getParent().getInstancePath(delim);
	}
	
	/**
	 * This is our regular instance path including our own name as last segment.
	 * 
	 * @return
	 */
	public String getInterfaceInstancePath() {
		return super.getInstancePath(PATH_DELIM);
	}

	/**
	 * Get thread for path. The thread is passed to the optional actor creation method.
	 * 
	 * @param path
	 * @return always the thread that was specified with the creation call
	 */
	@Override
	public int getThreadForPath(String path) {
		return subtreeThread;
	}

	/**
	 * @return the class name for this optional actor
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * {@code null} implementation since never called
	 * @see org.eclipse.etrice.runtime.java.modelbase.IEventReceiver#receiveEvent(org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase, int, java.lang.Object)
	 */
	@Override
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data) {
		// nothing to do, never called
	}

	/**
	 * @return the thread for the optional actors to be created
	 */
	protected int getSubtreeThread() {
		return subtreeThread;
	}

	/**
	 * sets the thread for the optional actor to be created
	 * @param subtreeThread
	 */
	protected void setSubtreeThread(int subtreeThread) {
		this.subtreeThread = subtreeThread;
	}
	
	/**
	 * This method is responsible for the start-up part of the life cycle of the newly created
	 * instances:
	 * 
	 * <ul>
	 * <li>load from input (if not {@code null})</li>
	 * <li>recursively {@link ActorClassBase#init() initialize}</li>
	 * <li>send initialization messages</li>
	 * </ul>
	 * 
	 * @param actor the newly created actor (actually a whole tree)
	 * @param input an optional input source for the sub tree's data
	 */
	protected void startupSubTree(ActorClassBase actor, ObjectInput input) {
		if (input!=null)
			loadActor(actor, input);

		// recursive initialization
		actor.init();

		// send system messages for initialization (does nothing for persisted actors)
		RTSystemPort.executeInitialTransition();
	}
	
	/**
	 * This method is responsible for the shut-down part of the life cycle of the newly created
	 * instances:
	 * 
	 * <ul>
	 * <li>save to output (if not {@code null})</li>
	 * <li>recursively {@link ActorClassBase#stop() stop}</li>
	 * </ul>
	 * 
	 * @param actor
	 * @param output
	 */
	protected void shutdownSubTree(ActorClassBase actor, ObjectOutput output) {
		if (output!=null)
			saveActor(actor, output);
		
		// recursively stop
		actor.stop();
	}
	
	/**
	 * Other than the base class implementation this method doesn't delegate but
	 * returns our own {@link org.eclipse.etrice.runtime.java.modelbase.RTSystemProtocol.RTSystemPort RTSystemPort}.
	 * 
	 * @see org.eclipse.etrice.runtime.java.modelbase.SystemPortOwner#getSystemPort()
	 */
	@Override
	public IReplicatedInterfaceItem getSystemPort() {
		return RTSystemPort;
	}

	/**
	 * This is an empty implementation which can be overridden by the generator
	 * if MSC logging is enabled.
	 * 
	 * @param actorClass the name of the actor class to be instantiated
	 * @param name the name of the reference (eventually including an index for replicated actors)
	 */
	protected void logCreation(String actorClass, String name) {
		// empty implementation, may be overridden by sub class
	}

	/**
	 * This is an empty implementation which can be overridden by the generator
	 * if MSC logging is enabled.
	 * 
	 * @param name the name of the reference (eventually including an index for replicated actors)
	 */
	protected void logDeletion(String name) {
		// empty implementation, may be overridden by sub class
	}

	/**
	 * This method is called if an {@link ObjectInput} was passed to creation and after
	 * the actor instance sub tree is created and ports are bound.
	 * 
	 * <p>
	 * States, history and all attributes of the actor instances are restored.
	 * </p>
	 * 
	 * @param actor an actor class
	 * @param input the input stream
	 */
	protected void loadActor(ActorClassBase actor, ObjectInput input) {
		if (input==null || actor==null)
			return;
		
		try {
			recursivelyLoad(actor, input);
		}
		catch (Throwable e) {
		}
	}

	/**
	 * The recursive loading of an instance sub tree.
	 * 
	 * @param actor an actor class
	 * @param input the input stream
	 * @throws IOException
	 * @throws ClassNotFoundException 
	 */
	private void recursivelyLoad(ActorClassBase actor, ObjectInput input) throws IOException, ClassNotFoundException {
		if (actor instanceof IPersistable) {
			((IPersistable) actor).loadObject(input);
			
			for (IRTObject child : actor.getChildren()) {
				if (child instanceof ActorClassBase)
					recursivelyLoad((ActorClassBase) child, input);
				else if (child instanceof IPersistable) {
					((IPersistable) child).loadObject(input);
				}
			}
		}
	}
	
	/**
	 * This method is called when an {@link ObjectOutput} was passed to destruction
	 * and before the instance sub tree is destroyed.
	 * 
	 * <p>
	 * States, history and all attributes of the actor instances are stored.
	 * </p>
	 * 
	 * @param actor an actor class
	 * @param output the output stream
	 */
	protected void saveActor(ActorClassBase actor, ObjectOutput output) {
		if (output==null || actor==null)
			return;
		
		try {
			recursivelySave(actor, output);
		}
		catch (IOException e) {
		}
	}

	/**
	 * The recursive saving of an instance sub tree.
	 * 
	 * @param actor an actor class
	 * @param output the output stream
	 * @throws IOException 
	 */
	private void recursivelySave(ActorClassBase actor, ObjectOutput output) throws IOException {
		if (actor instanceof IPersistable) {
			((IPersistable) actor).saveObject(output);
			
			for (IRTObject child : actor.getChildren()) {
				if (child instanceof ActorClassBase)
					recursivelySave((ActorClassBase) child, output);
				else if (child instanceof IPersistable) {
					((IPersistable) child).saveObject(output);
				}
			}
		}
	}
}
