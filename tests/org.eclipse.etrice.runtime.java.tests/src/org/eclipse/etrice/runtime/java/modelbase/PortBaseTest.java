/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;

import junit.framework.TestCase;

import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.MessageServiceController;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
import org.eclipse.etrice.runtime.java.messaging.IMessageService.ExecMode;

public class PortBaseTest extends TestCase {
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testPortBase() {
		MessageServiceController msgSvcCtrl = RTServices.getInstance().getMsgSvcCtrl();
		msgSvcCtrl.resetAll();

		msgSvcCtrl.addMsgSvc(
				new MessageService(null, ExecMode.BLOCKED, 0, 0, msgSvcCtrl.getNewID(), "MessageService_0", Thread.NORM_PRIORITY));
		msgSvcCtrl.addMsgSvc(
				new MessageService(null, ExecMode.BLOCKED, 0, 0, msgSvcCtrl.getNewID(), "MessageService_1", Thread.NORM_PRIORITY));

		MockSubSystem top = new MockSubSystem(null, "TOP");
		RTServices.getInstance().setSubSystem(top);
		top.addPathToThread("/TOP/Rcv0", 0);
		top.addPathToThread("/TOP/Rcv1", 1);
		top.addPathToPeer("/TOP/Rcv0/Port0", "/TOP/Rcv1/Port1");
		top.addPathToPeer("/TOP/Rcv1/Port1", "/TOP/Rcv0/Port0");
		
		MockEventReceiver eventRcv0 = new MockEventReceiver(top, "Rcv0");
		MockEventReceiver eventRcv1 = new MockEventReceiver(top, "Rcv1");
		PortBase port0 = new MockPort(eventRcv0, "Port0", 33, 0);
		PortBase port1 = new MockPort(eventRcv1, "Port1", 44, 5);
		
		assertEquals(msgSvcCtrl.getMsgSvc(0), port0.getMsgReceiver());
		assertEquals(msgSvcCtrl.getMsgSvc(1), port1.getMsgReceiver());

		assertEquals(port1.getAddress(), port0.getPeerAddress());
		assertEquals(port0.getAddress(), port1.getPeerAddress());
		
		assertEquals("/TOP/Rcv0/Port0", port0.getInstancePath());
		assertEquals("_TOP_Rcv0_Port0", port0.getInstancePathName());
		assertEquals("/TOP/Rcv1/Port1", port1.getInstancePath());
		assertEquals("_TOP_Rcv1_Port1", port1.getInstancePathName());
		
		assertEquals(33, port0.getLocalId());
		assertEquals(44, port1.getLocalId());
		
		assertEquals(0, port0.getIdx());
		assertEquals(5, port1.getIdx());

		assertEquals(eventRcv0, port0.getActor());
		assertEquals(eventRcv1, port1.getActor());
	}


}
