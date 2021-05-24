/*******************************************************************************
 * Copyright (c) 2021 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Jan Belle (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.ide.server;

import com.google.inject.Module;

public class SocketServerLauncher extends org.eclipse.xtext.ide.server.SocketServerLauncher {
	
	public static void main(String[] args) {
		new SocketServerLauncher().launch(args);
	}
	
	@Override
	protected Module getServerModule() {
		return new ServerModule();
	}
}
