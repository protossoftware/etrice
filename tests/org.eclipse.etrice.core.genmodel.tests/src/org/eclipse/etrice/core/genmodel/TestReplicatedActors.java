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
import org.eclipse.etrice.core.genmodel.builder.GenmodelConstants;
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
public class TestReplicatedActors extends TestInstanceModelBuilderBase {

	private Root root;
	private HashMap<String, InstanceBase> path2inst = new HashMap<String, InstanceBase>();

	@Before
	public void setUp() {
		prepare();
		
		root = buildInstanceModel("replicated_actors.room");
		
		TreeIterator<EObject> it = root.eAllContents();
		while (it.hasNext()) {
			EObject obj = it.next();
			if (obj instanceof InstanceBase) {
				String path = ((InstanceBase) obj).getPath();
				path2inst.put(path, (InstanceBase) obj);
				System.out.println(path);
			}
		}
	}

	private PortInstance getPort(String path) {
		return (PortInstance) path2inst.get(path);
	}
	
	// example 1: regular port of replicated actor connected to regular ports
	@Test
	public void checkExample1() {
		PortInstance intp1 = getPort("/Main/appl1/intp1");
		PortInstance intp2 = getPort("/Main/appl1/intp2");
		PortInstance intp3 = getPort("/Main/appl1/intp3");
		PortInstance ac1_0p = getPort("/Main/appl1/ac1repl"+GenmodelConstants.INDEX_SEP+"0/ac1p");
		PortInstance ac1_1p = getPort("/Main/appl1/ac1repl"+GenmodelConstants.INDEX_SEP+"1/ac1p");
		PortInstance ac1_2p = getPort("/Main/appl1/ac1repl"+GenmodelConstants.INDEX_SEP+"2/ac1p");

		assertEquals("number of peers of "+intp1.getName(), 1, intp1.getPeers().size());
		assertEquals("number of peers of "+intp2.getName(), 1, intp2.getPeers().size());
		assertEquals("number of peers of "+intp3.getName(), 1, intp3.getPeers().size());
		assertEquals("number of peers of "+ac1_0p.getName(), 1, ac1_0p.getPeers().size());
		assertEquals("number of peers of "+ac1_1p.getName(), 1, ac1_1p.getPeers().size());
		assertEquals("number of peers of "+ac1_2p.getName(), 1, ac1_2p.getPeers().size());

		HashSet<InterfaceItemInstance> peers = new HashSet<InterfaceItemInstance>();
		peers.add(intp1);
		peers.add(intp2);
		peers.add(intp3);
		
		assertTrue(ac1_0p.getPeers().get(0).getName()+" contained in peers ", peers.remove(ac1_0p.getPeers().get(0)));
		assertTrue(ac1_1p.getPeers().get(0).getName()+" contained in peers ", peers.remove(ac1_1p.getPeers().get(0)));
		assertTrue(ac1_2p.getPeers().get(0).getName()+" contained in peers ", peers.remove(ac1_2p.getPeers().get(0)));
		assertTrue("peers complete ", peers.isEmpty());
	}
	
	// example 2: regular port of replicated actor connected to regular port of replicated actor
	@Test
	public void checkExample2() {
		PortInstance ac1_0p = getPort("/Main/appl2/ac1repl"+GenmodelConstants.INDEX_SEP+"0/ac1p");
		PortInstance ac1_1p = getPort("/Main/appl2/ac1repl"+GenmodelConstants.INDEX_SEP+"1/ac1p");
		PortInstance ac1_2p = getPort("/Main/appl2/ac1repl"+GenmodelConstants.INDEX_SEP+"2/ac1p");
		PortInstance ac2_0p = getPort("/Main/appl2/ac2repl"+GenmodelConstants.INDEX_SEP+"0/ac2p");
		PortInstance ac2_1p = getPort("/Main/appl2/ac2repl"+GenmodelConstants.INDEX_SEP+"1/ac2p");
		PortInstance ac2_2p = getPort("/Main/appl2/ac2repl"+GenmodelConstants.INDEX_SEP+"2/ac2p");

		assertEquals("number of peers of "+ac1_0p.getName(), 1, ac1_0p.getPeers().size());
		assertEquals("number of peers of "+ac1_1p.getName(), 1, ac1_1p.getPeers().size());
		assertEquals("number of peers of "+ac1_2p.getName(), 1, ac1_2p.getPeers().size());
		assertEquals("number of peers of "+ac2_0p.getName(), 1, ac2_0p.getPeers().size());
		assertEquals("number of peers of "+ac2_1p.getName(), 1, ac2_1p.getPeers().size());
		assertEquals("number of peers of "+ac2_2p.getName(), 1, ac2_2p.getPeers().size());

		HashSet<InterfaceItemInstance> peers = new HashSet<InterfaceItemInstance>();
		peers.add(ac1_0p);
		peers.add(ac1_1p);
		peers.add(ac1_2p);
		
		assertTrue(ac2_0p.getPeers().get(0).getName()+" contained in peers ", peers.remove(ac2_0p.getPeers().get(0)));
		assertTrue(ac2_1p.getPeers().get(0).getName()+" contained in peers ", peers.remove(ac2_1p.getPeers().get(0)));
		assertTrue(ac2_2p.getPeers().get(0).getName()+" contained in peers ", peers.remove(ac2_2p.getPeers().get(0)));
		assertTrue("peers complete ", peers.isEmpty());
	}
	
	// example 3: regular port of replicated actor connected to replicated port
	@Test
	public void checkExample3() {
		PortInstance ac1_0p = getPort("/Main/appl3/ac1repl"+GenmodelConstants.INDEX_SEP+"0/ac1p");
		PortInstance ac1_1p = getPort("/Main/appl3/ac1repl"+GenmodelConstants.INDEX_SEP+"1/ac1p");
		PortInstance ac1_2p = getPort("/Main/appl3/ac1repl"+GenmodelConstants.INDEX_SEP+"2/ac1p");
		PortInstance intrep = getPort("/Main/appl3/intrep");
		
		assertEquals("number of peers of "+ac1_0p.getName(), 1, ac1_0p.getPeers().size());
		assertEquals("number of peers of "+ac1_1p.getName(), 1, ac1_1p.getPeers().size());
		assertEquals("number of peers of "+ac1_2p.getName(), 1, ac1_2p.getPeers().size());
		assertEquals("number of peers of "+intrep.getName(), 3, intrep.getPeers().size());
		
		assertEquals(ac1_0p.getName()+" peer is intrep ", ac1_0p.getPeers().get(0), intrep);
		assertEquals(ac1_1p.getName()+" peer is intrep ", ac1_1p.getPeers().get(0), intrep);
		assertEquals(ac1_2p.getName()+" peer is intrep ", ac1_2p.getPeers().get(0), intrep);
	}
	
	// example 4: regular port of replicated actor connected to replicated port of replicated actor
	@Test
	public void checkExample4() {
		PortInstance ac1_0p = getPort("/Main/appl4/ac1repl"+GenmodelConstants.INDEX_SEP+"0/ac1p");
		PortInstance ac1_1p = getPort("/Main/appl4/ac1repl"+GenmodelConstants.INDEX_SEP+"1/ac1p");
		PortInstance ac2_0p = getPort("/Main/appl4/ac2repl"+GenmodelConstants.INDEX_SEP+"0/ac2p");
		PortInstance ac2_1p = getPort("/Main/appl4/ac2repl"+GenmodelConstants.INDEX_SEP+"1/ac2p");
		PortInstance ac2_2p = getPort("/Main/appl4/ac2repl"+GenmodelConstants.INDEX_SEP+"2/ac2p");
		PortInstance ac2_3p = getPort("/Main/appl4/ac2repl"+GenmodelConstants.INDEX_SEP+"3/ac2p");

		assertEquals("number of peers of "+ac1_0p.getName(), 2, ac1_0p.getPeers().size());
		assertEquals("number of peers of "+ac1_1p.getName(), 2, ac1_1p.getPeers().size());
		assertEquals("number of peers of "+ac2_0p.getName(), 1, ac2_0p.getPeers().size());
		assertEquals("number of peers of "+ac2_1p.getName(), 1, ac2_1p.getPeers().size());
		assertEquals("number of peers of "+ac2_2p.getName(), 1, ac2_2p.getPeers().size());
		assertEquals("number of peers of "+ac2_3p.getName(), 1, ac2_3p.getPeers().size());

		HashSet<InterfaceItemInstance> peers = new HashSet<InterfaceItemInstance>();
		peers.add(ac2_0p);
		peers.add(ac2_1p);
		peers.add(ac2_2p);
		peers.add(ac2_3p);

		assertTrue(ac1_0p.getPeers().get(0).getName()+" contained in peers ", peers.remove(ac1_0p.getPeers().get(0)));
		assertTrue(ac1_0p.getPeers().get(1).getName()+" contained in peers ", peers.remove(ac1_0p.getPeers().get(1)));
		assertTrue(ac1_1p.getPeers().get(0).getName()+" contained in peers ", peers.remove(ac1_1p.getPeers().get(0)));
		assertTrue(ac1_1p.getPeers().get(1).getName()+" contained in peers ", peers.remove(ac1_1p.getPeers().get(1)));
		assertTrue("peers complete ", peers.isEmpty());
	}
	
	// example 5: regular port of replicated actor connected to replicated port of sub actor
	// TODO: testee [8] works fine but testee [*] will be connected only with the first port
	@Test
	public void checkExample5() {
		PortInstance testee = getPort("/Main/appl5/testDriver/testee");
		PortInstance ref0_0p = getPort("/Main/appl5/ref0"+GenmodelConstants.INDEX_SEP+"0/tester/test");
		PortInstance ref0_1p = getPort("/Main/appl5/ref0"+GenmodelConstants.INDEX_SEP+"1/tester/test");
		PortInstance ref0_2p = getPort("/Main/appl5/ref0"+GenmodelConstants.INDEX_SEP+"2/tester/test");
		PortInstance ref0_3p = getPort("/Main/appl5/ref0"+GenmodelConstants.INDEX_SEP+"3/tester/test");
		PortInstance ref0_4p = getPort("/Main/appl5/ref0"+GenmodelConstants.INDEX_SEP+"4/tester/test");
		PortInstance ref0_5p = getPort("/Main/appl5/ref0"+GenmodelConstants.INDEX_SEP+"5/tester/test");
		PortInstance ref0_6p = getPort("/Main/appl5/ref0"+GenmodelConstants.INDEX_SEP+"6/tester/test");
		PortInstance ref0_7p = getPort("/Main/appl5/ref0"+GenmodelConstants.INDEX_SEP+"7/tester/test");

		assertEquals("number of peers of "+testee.getName(), 8, testee.getPeers().size());
		assertEquals("number of peers of "+ref0_0p.getName(), 1, ref0_0p.getPeers().size());
		assertEquals("number of peers of "+ref0_1p.getName(), 1, ref0_1p.getPeers().size());
		assertEquals("number of peers of "+ref0_2p.getName(), 1, ref0_2p.getPeers().size());
		assertEquals("number of peers of "+ref0_3p.getName(), 1, ref0_3p.getPeers().size());
		assertEquals("number of peers of "+ref0_4p.getName(), 1, ref0_4p.getPeers().size());
		assertEquals("number of peers of "+ref0_5p.getName(), 1, ref0_5p.getPeers().size());
		assertEquals("number of peers of "+ref0_6p.getName(), 1, ref0_6p.getPeers().size());
		assertEquals("number of peers of "+ref0_7p.getName(), 1, ref0_7p.getPeers().size());

		HashSet<InterfaceItemInstance> peers = new HashSet<InterfaceItemInstance>();
		peers.add(ref0_0p);
		peers.add(ref0_1p);
		peers.add(ref0_2p);
		peers.add(ref0_3p);
		peers.add(ref0_4p);
		peers.add(ref0_5p);
		peers.add(ref0_6p);
		peers.add(ref0_7p);

		assertTrue(testee.getPeers().get(0).getName()+" contained in peers ", peers.remove(testee.getPeers().get(0)));
		assertTrue(testee.getPeers().get(1).getName()+" contained in peers ", peers.remove(testee.getPeers().get(1)));
		assertTrue(testee.getPeers().get(2).getName()+" contained in peers ", peers.remove(testee.getPeers().get(2)));
		assertTrue(testee.getPeers().get(3).getName()+" contained in peers ", peers.remove(testee.getPeers().get(3)));
		assertTrue(testee.getPeers().get(4).getName()+" contained in peers ", peers.remove(testee.getPeers().get(4)));
		assertTrue(testee.getPeers().get(5).getName()+" contained in peers ", peers.remove(testee.getPeers().get(5)));
		assertTrue(testee.getPeers().get(6).getName()+" contained in peers ", peers.remove(testee.getPeers().get(6)));
		assertTrue(testee.getPeers().get(7).getName()+" contained in peers ", peers.remove(testee.getPeers().get(7)));
		assertTrue("peers complete ", peers.isEmpty());
	}

}
