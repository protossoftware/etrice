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

	// CAUTION: must NOT initialize firstPeer with null since is set in base class constructor and
	// AFTERWARDS initialized ==> value is lost
	private IInterfaceItem firstPeer;
	private IInterfaceItem secondPeer;

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
	public IInterfaceItem connectWith(IInterfaceItem peer) {
		if (firstPeer!=null) {
			// we are already connected, lets connect our new peer with the previous one
			
			secondPeer = peer;
			
			// we don't want to change firstPeer, so make a copy
			IInterfaceItem first = firstPeer;
			
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
			
			return first.connectWith(peer);
		}
		else {
			firstPeer = peer;
			
			if (firstPeer instanceof InterfaceItemBroker) {
				// deal with the situation that two brokers aren't connected yet: make symmetrical and set also first peer
				// of neighbor
				InterfaceItemBroker neighbor = (InterfaceItemBroker) firstPeer;
				if (neighbor.firstPeer==null)
					neighbor.firstPeer = this;
			}
		
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
		String peer1 = (firstPeer instanceof InterfaceItemBase)? (((InterfaceItemBase)firstPeer).getAddress().toString()+"("+firstPeer.getClass().toString()+")")
				:(firstPeer instanceof ReplicatedInterfaceItemBase? (((ReplicatedInterfaceItemBase)firstPeer).toString()+"("+firstPeer.getClass().toString()+")"):"null");
		String peer2 = (secondPeer instanceof InterfaceItemBase)? (((InterfaceItemBase)secondPeer).getAddress().toString()+"("+secondPeer.getClass().toString()+")")
				:(secondPeer instanceof ReplicatedInterfaceItemBase? (((ReplicatedInterfaceItemBase)secondPeer).toString()+"("+secondPeer.getClass().toString()+")"):"null");
		return "interface broker port "+getName()+" - 1. peer "+peer1+" 2. peer "+peer2;
	}
}
