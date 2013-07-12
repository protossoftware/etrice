/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/


package org.eclipse.etrice.runtime.java.messaging;

/**
 * The message receiver interface.
 * 
 * @author Thomas Schuetz
 *
 */
public interface IMessageReceiver extends IRTObject {
	void receive(Message msg);
	Address getAddress();
}
