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

package org.eclipse.etrice.runtime.java.modelbase;

import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.MessageServiceController;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
import org.eclipse.etrice.runtime.java.messaging.IMessageService.ExecMode;

import junit.framework.TestCase;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class BrokerTest extends TestCase {
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		MessageServiceController msgSvcCtrl = RTServices.getInstance().getMsgSvcCtrl();
		msgSvcCtrl.resetAll();
		
		msgSvcCtrl.addMsgSvc(
				new MessageService(null, ExecMode.BLOCKED, 0, 0, msgSvcCtrl.getNewID(), "MessageService_0", Thread.NORM_PRIORITY));
		msgSvcCtrl.addMsgSvc(
				new MessageService(null, ExecMode.BLOCKED, 0, 0, msgSvcCtrl.getNewID(), "MessageService_1", Thread.NORM_PRIORITY));
		msgSvcCtrl.addMsgSvc(
				new MessageService(null, ExecMode.BLOCKED, 0, 0, msgSvcCtrl.getNewID(), "MessageService_2", Thread.NORM_PRIORITY));
	}
	
	public void testBroker() {
		MockSubSystem top = new MockSubSystem(null, "TOP");
		RTServices.getInstance().setSubSystem(top);
		top.addPathToThread("/TOP/Rcv0", 0);
		top.addPathToThread("/TOP/Rcv1", 1);
		top.addPathToThread("/TOP/Rcv2", 2);
		top.addPathToPeer("/TOP/Rcv0/Port0", "/TOP/Rcv2/Broker");
		top.addPathToPeer("/TOP/Rcv2/Broker", "/TOP/Rcv0/Port0");
		top.addPathToPeer("/TOP/Rcv1/Port1", "/TOP/Rcv2/Broker");
		top.addPathToPeer("/TOP/Rcv2/Broker", "/TOP/Rcv1/Port1");
		
		MockEventReceiver eventRcv0 = new MockEventReceiver(top, "Rcv0");
		MockEventReceiver eventRcv1 = new MockEventReceiver(top, "Rcv1");
		MockEventReceiver eventRcv2 = new MockEventReceiver(top, "Rcv2");
		
		// caution: the order is relevant
		PortBase port0 = new MockPort(eventRcv0, "Port0", 33, 0);
		InterfaceItemBroker broker = new InterfaceItemBroker(eventRcv2, "Broker", 55, 10);
		PortBase port1 = new MockPort(eventRcv1, "Port1", 44, 5);
		
		MessageServiceController msgSvcCtrl = RTServices.getInstance().getMsgSvcCtrl();
		assertEquals(msgSvcCtrl.getMsgSvc(0), port0.getMsgReceiver());
		assertEquals(msgSvcCtrl.getMsgSvc(1), port1.getMsgReceiver());
		assertEquals(msgSvcCtrl.getMsgSvc(2), broker.getMsgReceiver());

		assertEquals(port1.getAddress(), port0.getPeerAddress());
		assertEquals(port0.getAddress(), port1.getPeerAddress());

		assertEquals("/TOP/Rcv2/Broker", broker.getInstancePath());
		
		assertEquals(55, broker.getLocalId());
		assertEquals(10, broker.getIdx());
		assertEquals(eventRcv2, broker.getActor());
	}
	
	public void testBrokerChain() {
		MockSubSystem top = new MockSubSystem(null, "TOP");
		RTServices.getInstance().setSubSystem(top);
		top.addPathToThread("/TOP/Rcv0", 0);
		top.addPathToThread("/TOP/Rcv1", 1);
		top.addPathToThread("/TOP/Rcv2", 2);
		top.addPathToThread("/TOP/Rcv3", 2);
		top.addPathToPeer("/TOP/Rcv0/Port0", "/TOP/Rcv2/Broker");
		top.addPathToPeer("/TOP/Rcv2/Broker", "/TOP/Rcv0/Port0");
		top.addPathToPeer("/TOP/Rcv2/Broker", "/TOP/Rcv3/Broker");
		top.addPathToPeer("/TOP/Rcv3/Broker", "/TOP/Rcv2/Broker");
		top.addPathToPeer("/TOP/Rcv1/Port1", "/TOP/Rcv3/Broker");
		top.addPathToPeer("/TOP/Rcv3/Broker", "/TOP/Rcv1/Port1");
		
		MockEventReceiver eventRcv0 = new MockEventReceiver(top, "Rcv0");
		MockEventReceiver eventRcv1 = new MockEventReceiver(top, "Rcv1");
		MockEventReceiver eventRcv2 = new MockEventReceiver(top, "Rcv2");
		MockEventReceiver eventRcv3 = new MockEventReceiver(top, "Rcv3");
		
		// caution: the order is relevant
		PortBase port0 = new MockPort(eventRcv0, "Port0", 33, 0);
		new InterfaceItemBroker(eventRcv2, "Broker", 55, 10);
		new InterfaceItemBroker(eventRcv3, "Broker", 66, 20);
		PortBase port1 = new MockPort(eventRcv1, "Port1", 44, 5);
		
		assertEquals(port1.getAddress(), port0.getPeerAddress());
		assertEquals(port0.getAddress(), port1.getPeerAddress());
	}
	
	public void testBrokerUChain() {
		MockSubSystem top = new MockSubSystem(null, "TOP");
		RTServices.getInstance().setSubSystem(top);
		top.addPathToThread("/TOP/Rcv0", 0);
		top.addPathToThread("/TOP/Rcv1", 1);
		top.addPathToThread("/TOP/Rcv2", 2);
		top.addPathToThread("/TOP/Rcv3", 2);
		top.addPathToThread("/TOP/Rcv4", 2);
		top.addPathToPeer("/TOP/Rcv0/Port0", "/TOP/Rcv2/Broker");
		top.addPathToPeer("/TOP/Rcv2/Broker", "/TOP/Rcv0/Port0");
		top.addPathToPeer("/TOP/Rcv2/Broker", "/TOP/Rcv3/Broker");
		top.addPathToPeer("/TOP/Rcv3/Broker", "/TOP/Rcv2/Broker");
		top.addPathToPeer("/TOP/Rcv3/Broker", "/TOP/Rcv4/Broker");
		top.addPathToPeer("/TOP/Rcv4/Broker", "/TOP/Rcv3/Broker");
		top.addPathToPeer("/TOP/Rcv1/Port1", "/TOP/Rcv4/Broker");
		top.addPathToPeer("/TOP/Rcv4/Broker", "/TOP/Rcv1/Port1");
		
		MockEventReceiver eventRcv0 = new MockEventReceiver(top, "Rcv0");
		MockEventReceiver eventRcv1 = new MockEventReceiver(top, "Rcv1");
		MockEventReceiver eventRcv2 = new MockEventReceiver(top, "Rcv2");
		MockEventReceiver eventRcv3 = new MockEventReceiver(top, "Rcv3");
		MockEventReceiver eventRcv4 = new MockEventReceiver(top, "Rcv4");
		
		// caution: the order is relevant
		new InterfaceItemBroker(eventRcv2, "Broker", 55, 10);
		new InterfaceItemBroker(eventRcv3, "Broker", 66, 20);
		new InterfaceItemBroker(eventRcv4, "Broker", 77, 30);
		PortBase port0 = new MockPort(eventRcv0, "Port0", 33, 0);
		PortBase port1 = new MockPort(eventRcv1, "Port1", 44, 5);
		
		assertEquals(port1.getAddress(), port0.getPeerAddress());
		assertEquals(port0.getAddress(), port1.getPeerAddress());
	}

}
