/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;

import static org.junit.Assert.assertEquals;

import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.MessageServiceController;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
import org.eclipse.etrice.runtime.java.messaging.IMessageService.ExecMode;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class ReplicatedPortBaseTest {

	private static class MockReplicatedPort extends ReplicatedPortBase {

		public MockReplicatedPort(IInterfaceItemOwner parent, String name, int localId) {
			super(parent, name, localId);
		}

		@Override
		protected InterfaceItemBase createInterfaceItem(IInterfaceItemOwner rcv, String name, int lid, int idx) {
			return new MockPort(rcv, name, lid, idx);
		}
		
	}
	
	@Before
	public void setUp() {
		MessageServiceController msgSvcCtrl = RTServices.getInstance().getMsgSvcCtrl();
		msgSvcCtrl.resetAll();

		msgSvcCtrl.addMsgSvc(
				new MessageService(null, ExecMode.BLOCKED, 0, 0, msgSvcCtrl.getNewID(), "MessageService_0", Thread.NORM_PRIORITY));
		msgSvcCtrl.addMsgSvc(
				new MessageService(null, ExecMode.BLOCKED, 0, 0, msgSvcCtrl.getNewID(), "MessageService_1", Thread.NORM_PRIORITY));

	}

	private IRTObject createTopWithMappings() {
		MockSubSystem top = new MockSubSystem(null, "TOP");
		RTServices.getInstance().setSubSystem(top);
		top.addPathToThread("/TOP/Rcv0", 0);
		top.addPathToThread("/TOP/Rcv1", 1);
		top.addPathToThread("/TOP/Rcv2", 1);
		top.addPathToPeer("/TOP/Rcv0/Port0", "/TOP/Rcv2/Port2");
		top.addPathToPeer("/TOP/Rcv1/Port1", "/TOP/Rcv2/Port2");
		top.addPathToPeer("/TOP/Rcv2/Port2", "/TOP/Rcv0/Port0");
		top.addPathToPeer("/TOP/Rcv2/Port2", "/TOP/Rcv1/Port1");
		return top;
	}
	
	@Test
	public void testPort2Repl() {
		MessageServiceController msgSvcCtrl = RTServices.getInstance().getMsgSvcCtrl();
		
		IRTObject top = createTopWithMappings();
		MockEventReceiver eventRcv0 = new MockEventReceiver(top, "Rcv0");
		MockEventReceiver eventRcv1 = new MockEventReceiver(top, "Rcv1");
		MockEventReceiver eventRcv2 = new MockEventReceiver(top, "Rcv2");
		PortBase port0 = new MockPort(eventRcv0, "Port0", 33, 0);
		PortBase port1 = new MockPort(eventRcv1, "Port1", 44, 5);
		MockReplicatedPort port2 = new MockReplicatedPort(eventRcv2, "Port2", 55);
		
		assertEquals(2, port2.getNInterfaceItems());
		
		assertEquals(msgSvcCtrl.getMsgSvc(0), port0.getMsgReceiver());
		assertEquals(msgSvcCtrl.getMsgSvc(1), port1.getMsgReceiver());
		assertEquals(msgSvcCtrl.getMsgSvc(1), port2.getInterfaceItem(0).getMsgReceiver());
		assertEquals(msgSvcCtrl.getMsgSvc(1), port2.getInterfaceItem(1).getMsgReceiver());

		assertEquals(port0.getAddress(), port2.getInterfaceItem(0).getPeerAddress());
		assertEquals(port1.getAddress(), port2.getInterfaceItem(1).getPeerAddress());
		
		assertEquals("/TOP/Rcv0/Port0", port0.getInstancePath());
		assertEquals("_TOP_Rcv0_Port0", port0.getInstancePathName());
		assertEquals("/TOP/Rcv1/Port1", port1.getInstancePath());
		assertEquals("_TOP_Rcv1_Port1", port1.getInstancePathName());
		assertEquals("/TOP/Rcv2/Port2", port2.getInstancePath());
		assertEquals("/TOP/Rcv2/Port2:0", port2.getInterfaceItem(0).getInstancePath());
		assertEquals("/TOP/Rcv2/Port2:1", port2.getInterfaceItem(1).getInstancePath());
		
		assertEquals(33, port0.getLocalId());
		assertEquals(44, port1.getLocalId());
		assertEquals(55, port2.getLocalId());
		
		assertEquals(0, port0.getIdx());
		assertEquals(5, port1.getIdx());
		assertEquals(0, port2.getInterfaceItem(0).getIdx());
		assertEquals(1, port2.getInterfaceItem(1).getIdx());

		assertEquals(eventRcv0, port0.getActor());
		assertEquals(eventRcv1, port1.getActor());
		assertEquals(eventRcv2, port2.getInterfaceItem(0).getActor());
		assertEquals(eventRcv2, port2.getInterfaceItem(1).getActor());
	}

	@Test
	public void testRepl2Port() {
		MessageServiceController msgSvcCtrl = RTServices.getInstance().getMsgSvcCtrl();
		
		IRTObject top = createTopWithMappings();
		MockEventReceiver eventRcv0 = new MockEventReceiver(top, "Rcv0");
		MockEventReceiver eventRcv1 = new MockEventReceiver(top, "Rcv1");
		MockEventReceiver eventRcv2 = new MockEventReceiver(top, "Rcv2");
		MockReplicatedPort port2 = new MockReplicatedPort(eventRcv2, "Port2", 55);
		PortBase port0 = new MockPort(eventRcv0, "Port0", 33, 0);
		PortBase port1 = new MockPort(eventRcv1, "Port1", 44, 5);
		
		assertEquals(2, port2.getNInterfaceItems());
		
		assertEquals(msgSvcCtrl.getMsgSvc(0), port0.getMsgReceiver());
		assertEquals(msgSvcCtrl.getMsgSvc(1), port1.getMsgReceiver());
		assertEquals(msgSvcCtrl.getMsgSvc(1), port2.getInterfaceItem(0).getMsgReceiver());
		assertEquals(msgSvcCtrl.getMsgSvc(1), port2.getInterfaceItem(1).getMsgReceiver());

		assertEquals(port0.getAddress(), port2.getInterfaceItem(0).getPeerAddress());
		assertEquals(port1.getAddress(), port2.getInterfaceItem(1).getPeerAddress());
		
		assertEquals("/TOP/Rcv0/Port0", port0.getInstancePath());
		assertEquals("_TOP_Rcv0_Port0", port0.getInstancePathName());
		assertEquals("/TOP/Rcv1/Port1", port1.getInstancePath());
		assertEquals("_TOP_Rcv1_Port1", port1.getInstancePathName());
		assertEquals("/TOP/Rcv2/Port2", port2.getInstancePath());
		assertEquals("/TOP/Rcv2/Port2:0", port2.getInterfaceItem(0).getInstancePath());
		assertEquals("/TOP/Rcv2/Port2:1", port2.getInterfaceItem(1).getInstancePath());
		
		assertEquals(33, port0.getLocalId());
		assertEquals(44, port1.getLocalId());
		assertEquals(55, port2.getLocalId());
		
		assertEquals(0, port0.getIdx());
		assertEquals(5, port1.getIdx());
		assertEquals(0, port2.getInterfaceItem(0).getIdx());
		assertEquals(1, port2.getInterfaceItem(1).getIdx());

		assertEquals(eventRcv0, port0.getActor());
		assertEquals(eventRcv1, port1.getActor());
		assertEquals(eventRcv2, port2.getInterfaceItem(0).getActor());
		assertEquals(eventRcv2, port2.getInterfaceItem(1).getActor());
	}

	@Test
	public void testRepl2Repl() {
		MessageServiceController msgSvcCtrl = RTServices.getInstance().getMsgSvcCtrl();
		
		IRTObject top = createTopWithMappings();
		MockEventReceiver eventRcv0 = new MockEventReceiver(top, "Rcv0");
		MockEventReceiver eventRcv1 = new MockEventReceiver(top, "Rcv1");
		MockEventReceiver eventRcv2 = new MockEventReceiver(top, "Rcv2");
		MockReplicatedPort port0 = new MockReplicatedPort(eventRcv0, "Port0", 33);
		PortBase port1 = new MockPort(eventRcv1, "Port1", 44, 5);
		MockReplicatedPort port2 = new MockReplicatedPort(eventRcv2, "Port2", 55);
		
		assertEquals(1, port0.getNInterfaceItems());
		assertEquals(2, port2.getNInterfaceItems());
		
		assertEquals(msgSvcCtrl.getMsgSvc(0), port0.getInterfaceItem(0).getMsgReceiver());
		assertEquals(msgSvcCtrl.getMsgSvc(1), port1.getMsgReceiver());
		assertEquals(msgSvcCtrl.getMsgSvc(1), port2.getInterfaceItem(0).getMsgReceiver());
		assertEquals(msgSvcCtrl.getMsgSvc(1), port2.getInterfaceItem(1).getMsgReceiver());

		assertEquals(port0.getInterfaceItem(0).getAddress(), port2.getInterfaceItem(0).getPeerAddress());
		assertEquals(port1.getAddress(), port2.getInterfaceItem(1).getPeerAddress());
		
		assertEquals("/TOP/Rcv0/Port0", port0.getInstancePath());
		assertEquals("_TOP_Rcv0_Port0", port0.getInstancePathName());
		assertEquals("/TOP/Rcv1/Port1", port1.getInstancePath());
		assertEquals("_TOP_Rcv1_Port1", port1.getInstancePathName());
		assertEquals("/TOP/Rcv2/Port2", port2.getInstancePath());
		assertEquals("/TOP/Rcv2/Port2:0", port2.getInterfaceItem(0).getInstancePath());
		assertEquals("/TOP/Rcv2/Port2:1", port2.getInterfaceItem(1).getInstancePath());
		
		assertEquals(33, port0.getLocalId());
		assertEquals(44, port1.getLocalId());
		assertEquals(55, port2.getLocalId());
		
		assertEquals(0, port0.getInterfaceItem(0).getIdx());
		assertEquals(5, port1.getIdx());
		assertEquals(0, port2.getInterfaceItem(0).getIdx());
		assertEquals(1, port2.getInterfaceItem(1).getIdx());

		assertEquals(eventRcv0, port0.getInterfaceItem(0).getActor());
		assertEquals(eventRcv1, port1.getActor());
		assertEquals(eventRcv2, port2.getInterfaceItem(0).getActor());
		assertEquals(eventRcv2, port2.getInterfaceItem(1).getActor());
	}

}
