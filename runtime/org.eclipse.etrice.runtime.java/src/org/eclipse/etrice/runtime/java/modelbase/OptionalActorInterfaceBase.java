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
import java.util.List;

import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.modelbase.RTSystemProtocol.RTSystemConjPort;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class OptionalActorInterfaceBase extends SystemPortOwner implements IEventReceiver {

	protected static final int IFITEM_RTSystemPort = 0;
	
	private String className;
	private PathToPeers path2peers = null;
	private String ownPath;
	private int subtreeThread;
	
	private RTSystemConjPort RTSystemPort = null;
	
	/**
	 * @param parent
	 * @param name
	 */
	protected OptionalActorInterfaceBase(IEventReceiver parent, String name, String clsname) {
		super(parent, name);
		className = clsname;
		subtreeThread = parent.getThread();
		setOwnPath(getInstancePath()+IRTObject.PATH_DELIM+getName());
		
		RTSystemPort = new RTSystemConjPort(this, IFITEM_RTSystemPort);
	}
	
	/**
	 * Get list of peer paths
	 * 
	 * @param path
	 * @return list of peer paths or {@code null} if not mapped
	 */
	public List<String> getPeersForPath(String path) {
		if (getPath2peers()==null)
			return getParent().getPeersForPath(path);
		
		// remove own path + 
		int sep = path.indexOf(PATH_DELIM, getOwnPath().length()+1);
		if (sep<0 || sep>=path.length())
			return null;
		
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
	 * get thread for path
	 * @param path
	 * @return thread id or {@code -1} if not mapped
	 */
	public int getThreadForPath(String path) {
		return subtreeThread;
	}

	public void setPath2peers(PathToPeers path2peers) {
		this.path2peers = path2peers;
	}

	/**
	 * @return the path2peers
	 */
	protected PathToPeers getPath2peers() {
		return path2peers;
	}

	public String getClassName() {
		return className;
	}

	@Override
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data) {
		// nothing to do, never called
	}
	
	/**
	 * @return the ownPath
	 */
	public String getOwnPath() {
		return ownPath;
	}

	/**
	 * @param ownPath the ownPath to set
	 */
	public void setOwnPath(String ownPath) {
		this.ownPath = ownPath;
	}

	protected int getSubtreeThread() {
		return subtreeThread;
	}

	protected void setSubtreeThread(int subtreeThread) {
		this.subtreeThread = subtreeThread;
	}
	
	protected void startSubTree() {
		RTSystemPort.executeInitialTransition();
	}
	
	@Override
	public IReplicatedInterfaceItem getSystemPort() {
		return RTSystemPort;
	}

	protected void logCreation(String actorClass, String name) {
		// empty implementation, may be overridden by sub class
	}

	protected void logDeletion(String name) {
		// empty implementation, may be overridden by sub class
	}
}
