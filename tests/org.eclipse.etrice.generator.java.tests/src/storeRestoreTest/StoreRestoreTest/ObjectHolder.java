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
 * 		hrentz (initial contribution)
 * 
 *******************************************************************************/

package StoreRestoreTest;

import org.eclipse.etrice.runtime.java.modelbase.IActorClassDataObject;

import StoreRestoreTest.ObjectHolder;

/**
 * @author hrentz
 *
 */
public class ObjectHolder {

	private static IActorClassDataObject object = null;

	public static IActorClassDataObject getObject() {
		return object;
	}

	public static void setObject(IActorClassDataObject object) {
		ObjectHolder.object = object;
	}
}
