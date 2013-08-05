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

	// CAUTION: must NOT initialize firstPeer with null since is set in base class constructor and
	// AFTERWARDS initialized ==> value is lost
	private IRTObject firstPeer;
	private InterfaceItemBase secondPeer;

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
				if (((InterfaceItemBroker) firstPeer).firstPeer==null)
					((InterfaceItemBroker) firstPeer).firstPeer = this;
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase#connectWith(org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase)
	 */
	@Override
	public InterfaceItemBase connectWith(InterfaceItemBase peer) {
		if (firstPeer!=null) {
			// we are already connected, lets connect our new peer with the previous one
			
			secondPeer = peer;
			
			// we don't want to change firstPeer, so make a copy
			IRTObject first = firstPeer;
			
			{
				InterfaceItemBroker broker = this;
				while (true) {
					if (broker.firstPeer instanceof InterfaceItemBroker) {
						InterfaceItemBroker neighbor = (InterfaceItemBroker) broker.firstPeer;
						if (neighbor.firstPeer==broker) {
							// neighbor points back
							if (neighbor.secondPeer!=null) {
								first = neighbor.secondPeer;
								break;
							}
							else {
								// we can't connect all the way to the final peer: deposit peer and wait for other side being ready
								broker.secondPeer = peer;
								return this;
							}
						}
						broker = neighbor;
					}
					else {
						first = broker.firstPeer;
						break;
					}
				}
			}
			
			InterfaceItemBase peer1 = null;
			InterfaceItemBase peer2 = peer;
			
			if (first instanceof IReplicatedInterfaceItem) {
				// get a new replicated sub port
				peer1 = ((IReplicatedInterfaceItem) first).createSubInterfaceItem();
			}
			else if (first instanceof InterfaceItemBase) {
				peer1 = (InterfaceItemBase) first;
			}
			else {
				assert(false): "unexpected peer kind";
				return null;
			}
			
			peer2.peerAddress = peer1.getAddress();
			peer2.peerMsgReceiver = peer1.ownMsgReceiver;
			peer1.peerAddress = peer2.getAddress();
			peer1.peerMsgReceiver = peer2.ownMsgReceiver;
			
			return peer1;
		}
		else {
			firstPeer = peer;
		
			return this;
		}
	}
	
	@Override
	public String getInstancePath(char delim) {
		if (getParent() instanceof OptionalActorInterfaceBase)
			return ((OptionalActorInterfaceBase)getParent()).getInterfaceInstancePath()+PATH_DELIM+getName();
		
		return super.getInstancePath(delim);
	}
	
	@Override
	public String toString() {
		return "interface broker "+super.toString();
	}
}
