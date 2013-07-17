/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
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
import org.eclipse.etrice.runtime.java.messaging.RTObject;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class ReplicatedInterfaceItemBase extends RTObject implements IReplicatedInterfaceItem {

	private int localId;
	private ArrayList<InterfaceItemBase> items = new ArrayList<InterfaceItemBase>();

	/**
	 * @param parent
	 * @param name
	 * @param localId
	 */
	protected ReplicatedInterfaceItemBase(IEventReceiver parent, String name, int localId) {
		super(parent, name);
		
		this.localId = localId;
		
		List<String> peerPaths = getParent().getPeersForPath(getInstancePath());
		if (peerPaths!=null) {
			for (String path : peerPaths) {
				IRTObject object = getObject(path);
				InterfaceItemBase peer = null;
				if (object instanceof InterfaceItemBase) {
					peer = ((InterfaceItemBase) object);
				}
				else if (object instanceof IReplicatedInterfaceItem) {
					peer = ((IReplicatedInterfaceItem) object).createSubInterfaceItem();
				}
				if (peer!=null) {
					InterfaceItemBase item = createSubInterfaceItem();
					item.connectWith(peer);
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.modelbase.IReplicatedInterfaceItem#createSubInterfaceItem()
	 */
	@Override
	public InterfaceItemBase createSubInterfaceItem() {
		InterfaceItemBase item = createInterfaceItem((IEventReceiver)getParent(), getName()+items.size(), localId, items.size());
		items.add(item);
		return item;
	}
	
	public InterfaceItemBase getInterfaceItem(int idx) {
		if (0<=idx && idx<items.size())
			return items.get(idx);
		
		return null;
	}
	
	public int getNInterfaceItems() {
		return items.size();
	}
	
	public int getLocalId() {
		return localId;
	}
	
	protected abstract InterfaceItemBase createInterfaceItem(IEventReceiver rcv, String name, int lid, int idx);
}
