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
 * The event reciver interface.
 * 
 * @author Thomas Schuetz
 *
 */
public interface IEventReceiver extends IRTObject {

	void receiveEvent(InterfaceItemBase ifitem, int evt, Object data);
}
