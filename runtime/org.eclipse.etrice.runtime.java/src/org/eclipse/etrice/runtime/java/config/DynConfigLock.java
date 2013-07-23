/*******************************************************************************
 * Copyright (c) 2012 Juergen Haug
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
