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
 * @author Henrik Rentz-Reichert
 *
 */
public class InterfaceItemBroker extends InterfaceItemBase {

	private InterfaceItemBase firstPeer = null;

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
	protected void connectWith(InterfaceItemBase peer) {
		if (firstPeer==null) {
			firstPeer = peer;
			super.connectWith(peer);
		}
		else {
			// we are already connected, lets connect our new peer with the previous one
			peer.peerAddress = firstPeer.getAddress();
			peer.peerMsgReceiver = firstPeer.ownMsgReceiver;
			firstPeer.peerAddress = peer.getAddress();
			firstPeer.peerMsgReceiver = peer.ownMsgReceiver;
			firstPeer = null;
		}
	}
}
