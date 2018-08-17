/*******************************************************************************
 * Copyright (c) 2012 Juergen Haug
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.config;

/**
 * Protect an attribute against dynamic configuration
 */
public class DynConfigLock {

	private boolean update = true;

	public synchronized void allowUpdate() {
		update = true;
	}

	public synchronized void forbidUpdate() {
		update = false;
	}
	
	public synchronized boolean isUpdate(){
		return update;
	}

}
