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

package org.eclipse.etrice.core.genmodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.etricegen.InstanceBase;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.PortInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class TestFanningRelayPorts extends TestInstanceModelBuilderBase {

	private Root root;
	private HashMap<String, InstanceBase> path2inst = new HashMap<String, InstanceBase>();

	@Before
	public void setUp() {
		prepare();
		
		root = buildInstanceModel("fanning_relay.room");
		
		TreeIterator<EObject> it = root.eAllContents();
		while (it.hasNext()) {
			EObject obj = it.next();
			if (obj instanceof InstanceBase)
				path2inst.put(((InstanceBase) obj).getPath(), (InstanceBase) obj);
		}
	}

	private PortInstance getPort(String path) {
		return (PortInstance) path2inst.get(path);
	}

	/*
	 * TODO: investigate port connection algorithm for fanning relay ports
	 * 
	 * CAUTION: it is crucial that the relay port of ActorClass Cont has multiplicity>=4.
	 * Otherwise not all ports will be connected/connected wrong.
	 */
	@Test
	public void checkConnections() {
		PortInstance pil1 = getPort("/Main/c1/port");
		PortInstance pil2 = getPort("/Main/c2/port");
		PortInstance pil3 = getPort("/Main/c3/port");
		PortInstance pil4 = getPort("/Main/c4/port");
		
		assertEquals("number of peers of "+pil1.getPath(), 1, pil1.getPeers().size());
		assertEquals("number of peers of "+pil2.getPath(), 1, pil2.getPeers().size());
		assertEquals("number of peers of "+pil3.getPath(), 1, pil3.getPeers().size());
		assertEquals("number of peers of "+pil4.getPath(), 1, pil4.getPeers().size());
		
		HashSet<InterfaceItemInstance> peers = new HashSet<InterfaceItemInstance>();
		peers.add(pil1.getPeers().get(0));
		peers.add(pil2.getPeers().get(0));
		peers.add(pil3.getPeers().get(0));
		peers.add(pil4.getPeers().get(0));
		
		PortInstance pir1 = getPort("/Main/cont/s1/port");
		PortInstance pir2 = getPort("/Main/cont/s2/port");
		PortInstance pir3 = getPort("/Main/cont/c1/ss1/port");
		PortInstance pir4 = getPort("/Main/cont/c1/ss2/port");
		
		assertTrue("connected "+pir1.getPath(), peers.contains(pir1));
		assertTrue("connected "+pir2.getPath(), peers.contains(pir2));
		assertTrue("connected "+pir3.getPath(), peers.contains(pir3));
		assertTrue("connected "+pir4.getPath(), peers.contains(pir4));
	}
}
