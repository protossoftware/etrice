/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
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

import java.util.Collection;
import java.util.concurrent.Semaphore;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class TestSemaphore extends Semaphore {

	private static final long serialVersionUID = -2067749220670716523L;
	
	/**
	 * @param permits
	 */
	public TestSemaphore(int permits) {
		super(permits);
	}

	public void printWaitingThreads() {
		System.out.println(">>> begin semaphore info >>>");
		System.out.println("current thread is "+Thread.currentThread().getName());
		Collection<Thread> threads = getQueuedThreads();
		if (threads.isEmpty())
			System.out.println(" no waiting threads");
		else
			for (Thread thread : threads) {
				System.out.println(" blocked: "+thread.getName());
			}
		System.out.println("<<< end semaphore info <<<");
	}
}
