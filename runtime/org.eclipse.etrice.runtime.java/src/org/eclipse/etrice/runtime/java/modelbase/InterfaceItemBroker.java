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

	private InterfaceItemBase firstPeer;

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
	 * @see org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase#connectWith(org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase)
	 */
	@Override
	public void connectWith(InterfaceItemBase peer) {
		if (firstPeer==null) {
			firstPeer = peer;
			super.connectWith(peer);
		}
		else {
			// we are already connected, lets connect our new peer with the previous one
			
			InterfaceItemBase peer1 = firstPeer;
			InterfaceItemBase peer2 = peer;
			
			// get a new replicated sub port if appropriate
			if (peer1 instanceof IReplicatedInterfaceItem) {
				peer1 = ((IReplicatedInterfaceItem) peer1).createSubInterfaceItem();
			}
			if (peer2 instanceof IReplicatedInterfaceItem) {
				peer2 = ((IReplicatedInterfaceItem) peer2).createSubInterfaceItem();
			}
			
			peer2.peerAddress = peer1.getAddress();
			peer2.peerMsgReceiver = peer1.ownMsgReceiver;
			peer1.peerAddress = peer2.getAddress();
			peer1.peerMsgReceiver = peer2.ownMsgReceiver;
		}
	}
}
