/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.debugging;

import org.eclipse.etrice.runtime.java.debugging.MSCLogger;

import junit.framework.TestCase;

public class MSCLoggerTest extends TestCase {

	public void testMSCLogger() {
		MSCLogger logger = new MSCLogger();
		logger.setMSC("MSC1", "./");
		logger.open();
		logger.addMessageAsyncOut("Inst1", "Inst2", "msg1");
		logger.addMessageAsyncIn("Inst1", "Inst2", "msg1");
		logger.addMessageSyncCall("Inst1", "Inst2", "msg1");
		logger.addMessageSyncReturn("Inst1", "Inst2", "msg1");
		logger.addActorState("Actor1", "State1");
		logger.close();

		assertEquals("\tInst1 >-- Inst2 msg1", logger.getCommandList().get(0));
		assertEquals("\tInst1 --> Inst2 msg1", logger.getCommandList().get(1));
		assertEquals("\tInst1 ==> Inst2 msg1", logger.getCommandList().get(2));
		assertEquals("\tInst1 <== Inst2 msg1", logger.getCommandList().get(3));
		assertEquals("\tActor1 >>> State1", logger.getCommandList().get(4));

		//TODO: how should we check generated files?

	}
}
