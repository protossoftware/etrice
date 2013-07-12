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

import java.util.HashMap;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.etricegen.InstanceBase;
import org.eclipse.etrice.core.genmodel.etricegen.PortInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class TestCompoundProtocol extends TestInstanceModelBuilderBase {

	private Root root;
	private HashMap<String, InstanceBase> path2inst = new HashMap<String, InstanceBase>();

	@Before
	public void setUp() {
		prepare();
		
		root = buildInstanceModel("compound.room");
		
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
	
	@Test
	public void checkPeers() {
		PortInstance pi = getPort("/Main/appl/reg/p0");
		assertEquals("port peers of "+pi.getPath(), 1, pi.getPeers().size());
		
		pi = getPort("/Main/appl/conj/p0");
		assertEquals("port peers of "+pi.getPath(), 1, pi.getPeers().size());
		
		pi = getPort("/Main/appl/ref0/red");
		assertEquals("port peers of "+pi.getPath(), 1, pi.getPeers().size());
		
		pi = getPort("/Main/appl/ref0/green");
		assertEquals("port peers of "+pi.getPath(), 1, pi.getPeers().size());
		
		pi = getPort("/Main/appl/ref0/blue");
		assertEquals("port peers of "+pi.getPath(), 1, pi.getPeers().size());
		
		pi = getPort("/Main/appl/ref0/extra");
		assertEquals("port peers of "+pi.getPath(), 1, pi.getPeers().size());
		
		pi = getPort("/Main/appl/ref0/suppl");
		assertEquals("port peers of "+pi.getPath(), 1, pi.getPeers().size());
		
		pi = getPort("/Main/appl/wrap/ref0/ref0/red");
		assertEquals("port peers of "+pi.getPath(), 1, pi.getPeers().size());
		
		pi = getPort("/Main/appl/wrap/ref0/ref0/green");
		assertEquals("port peers of "+pi.getPath(), 1, pi.getPeers().size());
		
		pi = getPort("/Main/appl/wrap/ref0/ref0/blue");
		assertEquals("port peers of "+pi.getPath(), 1, pi.getPeers().size());
		
		pi = getPort("/Main/appl/wrap/ref0/ref0/extra");
		assertEquals("port peers of "+pi.getPath(), 1, pi.getPeers().size());
		
		pi = getPort("/Main/appl/wrap/ref0/ref0/suppl");
		assertEquals("port peers of "+pi.getPath(), 1, pi.getPeers().size());
	}
}
