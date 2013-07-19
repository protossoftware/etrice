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

import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.RTObject;

class MockEventReceiver extends RTObject implements IEventReceiver, IInterfaceItemOwner {

	protected MockEventReceiver(IRTObject parent, String name) {
		super(parent, name);
	}

	@Override
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.modelbase.IInterfaceItemOwner#getEventReceiver()
	 */
	@Override
	public IEventReceiver getEventReceiver() {
		return this;
	}

}