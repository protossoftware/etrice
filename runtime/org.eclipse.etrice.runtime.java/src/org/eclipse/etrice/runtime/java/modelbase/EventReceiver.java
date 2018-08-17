/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;

import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.RTObject;

/**
 * The abstract base class for event receivers.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class EventReceiver extends RTObject implements IEventReceiver {

	private int thread = -1;

	/**
	 * The only constructor for {@link EventReceiver} objects.
	 * 
	 * @param parent the parent object
	 * @param name the name of this object
	 */
	public EventReceiver(IRTObject parent, String name) {
		super(parent, name);
	}
	
	@Override
	public int getThread() {
		if (thread<0) {
			thread = getThreadForPath(getInstancePath());
			if (thread<0)
				if (getParent() instanceof EventReceiver)
					thread = ((EventReceiver)getParent()).getThread();
				else
					thread = 0;
		}
		return thread;
	}

}
