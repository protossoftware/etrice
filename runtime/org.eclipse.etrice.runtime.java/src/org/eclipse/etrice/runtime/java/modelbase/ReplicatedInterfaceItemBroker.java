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


/**
 * @author Henrik Rentz-Reichert
 *
 */
public class ReplicatedInterfaceItemBroker extends ReplicatedInterfaceItemBase {

	/**
	 * @param parent
	 * @param name
	 * @param localId
	 */
	public ReplicatedInterfaceItemBroker(IInterfaceItemOwner parent, String name, int localId) {
		super(parent, name, localId);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.modelbase.ReplicatedInterfaceItemBase#createInterfaceItem(org.eclipse.etrice.runtime.java.messaging.IRTObject, java.lang.String, int, int)
	 */
	@Override
	protected InterfaceItemBase createInterfaceItem(IInterfaceItemOwner rcv, String name, int lid, int idx) {
		return new InterfaceItemBroker(this, name, lid, idx);
	}
}
