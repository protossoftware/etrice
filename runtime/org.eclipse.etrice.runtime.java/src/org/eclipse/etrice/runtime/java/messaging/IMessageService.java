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

package org.eclipse.etrice.runtime.java.messaging;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public interface IMessageService extends IRTObject, IMessageReceiver, Runnable {

	enum ExecMode {
		POLLED, BLOCKED, MIXED
	}
	
	void terminate();

	Address getFreeAddress();
	
	void freeAddress(Address addr);

	/**
	 * set the thread of this service
	 * (also sets the thread priority)
	 * 
	 * @param thread
	 */
	void setThread(Thread thread);

	/**
	 * @return the thread of this service
	 */
	Thread getThread();
}
