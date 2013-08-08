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
import org.eclipse.etrice.runtime.java.messaging.IMessageService;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.RTServices;

/**
 * The abstract base class for actor class interface items like {@link PortBase}
 * and {@link InterfaceItemBroker}s.
 * 
 * @author Henrik Rentz-Reichert
 */
public abstract class InterfaceItemBase extends AbstractMessageReceiver {
	
	/**
	 * If this is part of an {@link IReplicatedInterfaceItem} then the
	 * owner of this item is stored in this field.
	 * It is used for sub ports of a replicated ports. When of of this is
	 * disconnected then it is also removed from its parent and destroyed.
	 */
	private IReplicatedInterfaceItem replicator = null;
	
	protected IMessageService ownMsgReceiver;
	protected IMessageReceiver peerMsgReceiver;
	private int localId;
	private int idx;
	protected Address peerAddress = null;
	private InterfaceItemBase peer;


	/**
	 * The constructor determines the thread of its {@link IEventReceiver}
	 * 
	 * @param owner
	 * @param name
	 * @param localId
	 * @param idx
	 */
	public InterfaceItemBase (IInterfaceItemOwner owner, String name, int localId, int idx) {
		super(owner.getEventReceiver(), name);
		
		this.localId = localId;
		this.idx = idx;
		
		if (owner instanceof IReplicatedInterfaceItem)
			replicator = (IReplicatedInterfaceItem) owner;
		
		int thread = owner.getEventReceiver().getThread();
		if (thread>=0) {
			IMessageService msgSvc = RTServices.getInstance().getMsgSvcCtrl().getMsgSvc(thread);
			Address addr = msgSvc.getFreeAddress();
			setAddress(addr);
			msgSvc.addMessageReceiver(this);
			
			this.ownMsgReceiver = msgSvc;
		}
		
		connectWithPeer();
	}

	protected void connectWithPeer() {
		List<String> peerPaths = getParent().getPeersForPath(getInstancePath());
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

	protected synchronized InterfaceItemBase connectWith(InterfaceItemBase peer) {
		if (peer!=null) {
			this.peer = peer;
			
			if (peer instanceof IInterfaceItemBroker) {
				this.peer = peer.connectWith(this);
				return this.peer;
			}
			
			// connect with each other
			peerAddress = peer.getAddress();
			peer.peerAddress = getAddress();
			this.peerMsgReceiver = peer.ownMsgReceiver;
			peer.peerMsgReceiver = ownMsgReceiver;
			
		}
		
		return peer;
	}
	
	protected synchronized void disconnect() {
		disconnectInternal();
		if (peer!=null) {
			peer.disconnectInternal();
			peer = null;
		}
	}

	private void disconnectInternal() {
		peerAddress = null;
		peerMsgReceiver = null;
		
		if (replicator!=null)
			destroy();
	}
	
	protected IMessageReceiver getMsgReceiver() {
		return ownMsgReceiver;
	}

	protected synchronized Address getPeerAddress() {
		return peerAddress;
	}

	protected synchronized IMessageReceiver getPeerMsgReceiver() {
		return peerMsgReceiver;
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
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.messaging.RTObject#destroy()
	 */
	@Override
	protected void destroy() {
		if (peerAddress!=null) {
			disconnect();
		}
		
		if (replicator!=null) {
			replicator.removeItem(this);
		}
		
		ownMsgReceiver.removeMessageReceiver(this);
		ownMsgReceiver.freeAddress(getAddress());
		
		super.destroy();
	}
	
	@Override
	public String toString() {
		return ((replicator!=null)?"sub ":"")+"port "+getName()+" "+getAddress()+" <-> "+getPeerAddress();
	}
}
