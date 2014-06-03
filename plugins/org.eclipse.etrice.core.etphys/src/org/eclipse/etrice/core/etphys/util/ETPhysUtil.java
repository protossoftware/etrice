/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.etphys.util;

import org.eclipse.etrice.core.etphys.eTPhys.ETPhysFactory;
import org.eclipse.etrice.core.etphys.eTPhys.ExecMode;
import org.eclipse.etrice.core.etphys.eTPhys.NodeClass;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread;
import org.eclipse.etrice.core.etphys.eTPhys.RuntimeClass;
import org.eclipse.etrice.core.etphys.eTPhys.ThreadModel;

public class ETPhysUtil {

	public static NodeClass createDefaultNodeClass() {
		NodeClass nodeClass = ETPhysFactory.eINSTANCE.createNodeClass();
		nodeClass.setName("NodeClass1");
		nodeClass.setPriomin(-10);
		nodeClass.setPriomax(10);

		PhysicalThread defaultThread = createDefaultPhysicalThread();
		nodeClass.getThreads().add(defaultThread);

		return nodeClass;
	}

	public static PhysicalThread createDefaultPhysicalThread() {
		PhysicalThread defaultThread = ETPhysFactory.eINSTANCE.createPhysicalThread();
		defaultThread.setDefault(true);
		defaultThread.setName("PhysicalThread1");
		defaultThread.setExecmode(ExecMode.MIXED);
		defaultThread.setTime(100000000); // 100ms
		defaultThread.setPrio(0);
		defaultThread.setStacksize(1024);
		defaultThread.setMsgblocksize(32);
		defaultThread.setMsgpoolsize(10);

		return defaultThread;
	}

	public static RuntimeClass createDefaultRuntimeClass() {
		RuntimeClass runtimeClass = ETPhysFactory.eINSTANCE.createRuntimeClass();
		runtimeClass.setName("RuntimeClass1");
		runtimeClass.setThreadModel(ThreadModel.MULTI_THREADED);

		return runtimeClass;
	}
}
