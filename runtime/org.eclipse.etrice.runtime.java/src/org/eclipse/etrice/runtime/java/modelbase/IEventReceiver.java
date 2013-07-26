/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;

import org.eclipse.etrice.runtime.java.messaging.IRTObject;

/**
 * The event receiver interface.
 * An event receiver can {@link #receiveEvent(InterfaceItemBase, int, Object) receive events}
 * an he knows the {@link #getThread()} on which it is running.
 * 
 * @author Thomas Schuetz
 *
 */
public interface IEventReceiver extends IRTObject {

	/**
	 * This method is called by an {@link InterfaceItemBase}.
	 * 
	 * @param ifitem the calling interface item
	 * @param evt the event ID
	 * @param data optional data (may be {@code null}
	 */
	void receiveEvent(InterfaceItemBase ifitem, int evt, Object data);
	
	/**
	 * @return the thread of this event receiver
	 */
	int getThread();
}
