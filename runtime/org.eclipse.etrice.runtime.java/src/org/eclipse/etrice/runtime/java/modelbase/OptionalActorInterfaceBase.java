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
import java.util.ArrayList;
import java.util.List;

import org.eclipse.etrice.runtime.java.modelbase.RTSystemProtocol.RTSystemConjPort;

/**
 * This is the abstract base class of all optional actor interfaces.
 * Concrete sub classes are {@link ScalarOptionalActorInterfaceBase} and {@link ReplicatedOptionalActorInterfaceBase}.
 * <p>
 * The code generator again derives from the concrete sub classes and adds {@link InterfaceItemBroker}s as members.
 * </p><p>
 * This generated class is instantiated as member of the containing actor (the one holding the associated optional
 * actor reference).
 * </p><p>
 * The broker items are responsible for the mediation of the port connections.
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
	 * This map is set during optional actor creation by the factory.
	 */
	private PathToPeers path2peers = null;
	
	/**
	 * The path of this instance is used to determine correct mappings.
	 * It is subtracted from incoming paths, then (relative) peer paths are looked up and
	 * the result paths are turned into absolute ones by adding this again.
	 * 
	 * @see #getPeersForPath(String)
	 */
	private String ownPath;
	
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
		setOwnPath(getInstancePath());
		
		RTSystemPort = new RTSystemConjPort(this, IFITEM_RTSystemPort);
	}
	
	/**
	 * Get list of peer paths.
	 * <p>
	 * This method delegates to its parent if {@link #getPath2peers()}{@code ==null}.
	 * </p>
	 * <p>
	 * If an optional actor instance is created the used factory will set
	 * its own path-to-peer mapping. Then the incoming path is made relative to
	 * the created actor and the paths looked up in the map are made absolute again.
	 * 
	 * @param path an absolute path
	 * @return a list of absolute peer paths or {@code null} if not mapped
	 */
	public List<String> getPeersForPath(String path) {
		if (getPath2peers()==null)
			return getParent().getPeersForPath(path);
		
		/*  remove own path + following segment (which is a second time
		 *  the name of the optional ref (+ maybe a replication index)
		 *  e.g.
		 *  incoming path = /LS/appl/cont/opt/opt/path/to/port
		 *  rel path = /path/to/port
		 *  result of lookup (to interface port) = /port
		 *  returned = /LS/appl/cont/opt/port (one of the interface port brokers)
		 */
		int sep = path.indexOf(PATH_DELIM, getOwnPath().length()+1);
		if (sep<0 || sep>=path.length())
			return null;
		
		// The optInstPath for scalar optional actors ownPath/<name>.
		// However, for replicated actors it is ownPath/<name>:<idx>
		String optInstPath = path.substring(0, sep);
		path = path.substring(sep);
		
		ArrayList<String> paths = getPath2peers().get(path);
		if (paths!=null) {
			ArrayList<String> result = new ArrayList<String>();
			for (String p : paths) {
				if (p.indexOf('/', 1)>=0)
					// it's a path nested in the optional instance
					p = optInstPath+p;
				else
					// its a path to one of my brokers
					p = getOwnPath()+p;
				result.add(p);
			}
			return result;
		}
		return paths;
	}
	
	/**
	 * Get thread for path. The thread is passed to the optional actor creation method.
	 * 
	 * @param path
	 * @return always the thread that was specified with the creation call
	 */
	public int getThreadForPath(String path) {
		return subtreeThread;
	}

	/**
	 * This method is called by the optional actor factory to set the relative path mappings
	 * for the created instance sub tree
	 * 
	 * @param path2peers
	 */
	public void setPath2peers(PathToPeers path2peers) {
		this.path2peers = path2peers;
	}

	/**
	 * Returns the locally set path-to-peer mapping
	 * @return the path2peers
	 */
	protected PathToPeers getPath2peers() {
		return path2peers;
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
	 * Returns the cached own path to avoid multiple re-computation
	 * @return the ownPath
	 */
	private String getOwnPath() {
		return ownPath;
	}

	/**
	 * @param ownPath the ownPath to set
	 */
	private void setOwnPath(String ownPath) {
		this.ownPath = ownPath;
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
	 * TODO: persistence not implemented yet
	 * 
	 * @param actor
	 * @param input
	 */
	protected void loadActor(ActorClassBase actor, ObjectInput input) {
		if (input==null || actor==null)
			return;
		
		try {
			input.close();
		}
		catch (IOException e) {
		}
	}

	/**
	 * TODO: persistence not implemented yet
	 * 
	 * @param actor
	 * @param output
	 */
	protected void saveActor(ActorClassBase actor, ObjectOutput output) {
		if (output==null || actor==null)
			return;
		
		try {
			output.close();
		}
		catch (IOException e) {
		}
	}
}
