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

import java.util.List;

import org.eclipse.etrice.runtime.java.messaging.RTObject;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class OptionalActorInterfaceBase extends RTObject implements IInterfaceItemOwner {

	private String className;
	private PathToPeers path2peers = null;
	private String ownPath;
	private int subtreeThread = -1;
	
	/**
	 * @param parent
	 * @param name
	 */
	protected OptionalActorInterfaceBase(IEventReceiver parent, String name, String clsname) {
		super(parent, name);
		className = clsname;
		setOwnPath(getInstancePath());
	}
	
	/**
	 * Get list of peer paths
	 * 
	 * @param path
	 * @return list of peer paths or {@code null} if not mapped
	 */
	public List<String> getPeersForPath(String path) {
		if (getPath2peers()==null)
			return null;
		
		path = path.substring(getOwnPath().length());
		return getPath2peers().get(path);
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

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.modelbase.IInterfaceItemOwner#getEventReceiver()
	 */
	@Override
	public IEventReceiver getEventReceiver() {
		return (IEventReceiver) getParent();
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
}
