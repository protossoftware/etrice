/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;

import org.eclipse.etrice.runtime.java.messaging.IRTObject;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class MockSubSystem extends SubSystemClassBase {

	/**
	 * @param parent
	 * @param name
	 */
	public MockSubSystem(IRTObject parent, String name) {
		super(parent, name);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.modelbase.IEventReceiver#receiveEvent(org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase, int, java.lang.Object)
	 */
	@Override
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase#instantiateMessageServices()
	 */
	@Override
	public void instantiateMessageServices() {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase#instantiateActors()
	 */
	@Override
	public void instantiateActors() {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase#getFactory(java.lang.String, java.lang.String)
	 */
	@Override
	public IOptionalActorFactory getFactory(String optionalActorClass, String instanceActorClass) {
		return null;
	}

}
