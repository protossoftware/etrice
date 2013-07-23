/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;

import java.util.List;

import org.eclipse.etrice.runtime.java.messaging.AbstractMessageReceiver;
import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.RTServices;

/**
 * The abstract base class for actor class interface items like ports and saps.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class InterfaceItemBase extends AbstractMessageReceiver {
	
	private IMessageReceiver ownMsgReceiver;
	private IMessageReceiver peerMsgReceiver;
	private int localId;
	private int idx;
	private Address peerAddress = null;

	public InterfaceItemBase (IEventReceiver actor, String name, int localId, int idx) {
		super(actor, name);
		
		this.localId = localId;
		this.idx = idx;
		
		int thread = RTServices.getInstance().getMsgSvcCtrl().getThreadForPath(getParent().getInstancePath());
		if (thread>=0) {
			MessageService msgSvc = RTServices.getInstance().getMsgSvcCtrl().getMsgSvc(thread);
			Address addr = msgSvc.getFreeAddress();
			setAddress(addr);
			
			this.ownMsgReceiver = msgSvc;
			
			if (this.ownMsgReceiver instanceof MessageService) {
				MessageService ms = (MessageService) this.ownMsgReceiver;
				// register at the own dispatcher to receive messages
				ms.getMessageDispatcher().addMessageReceiver(this);
			}
		}
		
		List<String> peerPaths = RTServices.getInstance().getMsgSvcCtrl().getPeersForPath(getInstancePath());
		if (peerPaths!=null && !peerPaths.isEmpty()) {
			IRTObject object = getObject(peerPaths.get(0));
			InterfaceItemBase peer = null;
			if (object instanceof InterfaceItemBase) {
				peer = ((InterfaceItemBase) object);
			}
			else if (object instanceof IReplicatedInterfaceItem) {
				peer = ((IReplicatedInterfaceItem) object).createSubInterfaceItem();
			}
			connectWith(peer);
		}
		
	}

	protected void connectWith(InterfaceItemBase peer) {
		if (peer!=null) {
			// connect with each other
			peerAddress = peer.getAddress();
			peer.peerAddress = getAddress();
			this.peerMsgReceiver = peer.ownMsgReceiver;
			peer.peerMsgReceiver = ownMsgReceiver;
		}
	}

	protected IMessageReceiver getMsgReceiver() {
		return ownMsgReceiver;
	}

	protected IMessageReceiver getPeerMsgReceiver() {
		return peerMsgReceiver;
	}

	public void setMsgReceiver(IMessageReceiver msgReceiver) {
		this.ownMsgReceiver = msgReceiver;
	}
	
	public IEventReceiver getActor() {
		return (IEventReceiver) getParent();
	}

	public int getLocalId() {
		return localId;
	}

	public int getIdx() {
		return idx;
	}

	protected Address getPeerAddress() {
		return peerAddress;
	}
}
