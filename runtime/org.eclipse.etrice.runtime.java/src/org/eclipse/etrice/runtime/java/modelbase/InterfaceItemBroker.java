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

import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.Message;

/**
 * The purpose of this class is to mediate the connection of two end ports which
 * are separated by an {@link OptionalActorInterfaceBase}.
 * The first peer that will connect is that one from the 'outside'.
 * As soon as the second (somewhere in the dynamically created sub tree)
 * will connect, the two peers will be connected with each other.
 * 
 * <p>
 * <b>Assumption</b>: The first (outside) peer will stay fixed.<br/>
 * 
 * When the second (dynamic)
 * peer will disconnect from its peer (the outside one) then nothing happens.
 * When a new dynamic peer is instantiated then it again contacts this broker
 * an it will be connected to the {@link #firstPeer} of this broker.
 * </p>
 * 
 * @author Henrik Rentz-Reichert
 */
public class InterfaceItemBroker extends InterfaceItemBase implements IInterfaceItemBroker {

	private IRTObject firstPeer;

	public InterfaceItemBroker(IInterfaceItemOwner parent, String name, int localId) {
		this(parent, name, localId, 0);
	}

	/**
	 * @param actor
	 * @param name
	 * @param localId
	 * @param idx
	 */
	public InterfaceItemBroker(IInterfaceItemOwner parent, String name, int localId, int idx) {
		super(parent, name, localId, idx);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.messaging.IMessageReceiver#receive(org.eclipse.etrice.runtime.java.messaging.Message)
	 */
	@Override
	public void receive(Message msg) {
		// ignore this, will never receive a message
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase#connectWithPeer()
	 */
	protected void connectWithPeer() {
		List<String> peerPaths = getParent().getPeersForPath(getInstancePath());
		if (peerPaths!=null && !peerPaths.isEmpty()) {
			firstPeer = getObject(peerPaths.get(0));
			if (firstPeer instanceof InterfaceItemBroker) {
				firstPeer = ((InterfaceItemBroker) firstPeer).connectWith(this);
			}
		}
	}
	
	@Override
	public String getInstancePath(char delim) {
		if (getParent() instanceof OptionalActorInterfaceBase)
			return ((OptionalActorInterfaceBase)getParent()).getInterfaceInstancePath()+PATH_DELIM+getName();
		
		return super.getInstancePath(delim);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase#connectWith(org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase)
	 */
	@Override
	public InterfaceItemBase connectWith(InterfaceItemBase peer) {
		if (firstPeer!=null) {
			// we are already connected, lets connect our new peer with the previous one
			
			InterfaceItemBase peer1 = null;
			InterfaceItemBase peer2 = peer;
			
			// get a new replicated sub port if appropriate
			if (firstPeer instanceof IReplicatedInterfaceItem) {
				peer1 = ((IReplicatedInterfaceItem) firstPeer).createSubInterfaceItem();
			}
			else if (firstPeer instanceof InterfaceItemBase) {
				peer1 = (InterfaceItemBase) firstPeer;
			}
			
			peer2.peerAddress = peer1.getAddress();
			peer2.peerMsgReceiver = peer1.ownMsgReceiver;
			peer1.peerAddress = peer2.getAddress();
			peer1.peerMsgReceiver = peer2.ownMsgReceiver;
			
			return peer1;
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		return "interface broker "+super.toString();
	}
}
