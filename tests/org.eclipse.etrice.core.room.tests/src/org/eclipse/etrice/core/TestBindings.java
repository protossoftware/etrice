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

package org.eclipse.etrice.core;

import static org.junit.Assert.*;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.validation.RoomJavaValidator;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class TestBindings extends TestBase {
	private Resource resource;

	@Before
	public void setUp() {
		prepare();
		
		resource = getResource("TestBindings.room");
	}

	@Test
	public void testBindingValidation() {
		Binding bind = getBinding("Example1", 0);
		Diagnostic diag = getDiag(bind).getChildren().get(0);
		assertEquals("expect error message", "no self connection allowed, ports are identical", diag.getMessage());
		
		bind = getBinding("Example1a", 0);
		diag = getDiag(bind).getChildren().get(0);
		assertEquals("expect error message", "ports are already bound", diag.getMessage());
		
		bind = getBinding("Example1a", 1);
		diag = getDiag(bind).getChildren().get(0);
		assertEquals("expect error message", "ports are already bound", diag.getMessage());
		
		bind = getBinding("Example2", 0);
		diag = getDiag(bind).getChildren().get(0);
		assertEquals("expect error message", "port with multiplicity 1 is already connected", diag.getMessage());
		
		bind = getBinding("Example2", 0);
		diag = getDiag(bind).getChildren().get(0);
		assertEquals("expect error message", "port with multiplicity 1 is already connected", diag.getMessage());
		
		bind = getBinding("Example3", 0);
		diag = getDiag(bind).getChildren().get(0);
		assertEquals("protocols don't match", diag.getMessage());
		
		bind = getBinding("Example4", 0);
		diag = getDiag(bind).getChildren().get(0);
		assertEquals("protocol extends incoming", diag.getMessage());
		
		bind = getBinding("Example5", 0);
		diag = getDiag(bind);
		assertTrue("binding is ok", diag.getChildren().isEmpty());
		
		bind = getBinding("Example6", 0);
		diag = getDiag(bind).getChildren().get(0);
		assertEquals("protocol extends outgoing", diag.getMessage());
		
		bind = getBinding("Example7", 0);
		diag = getDiag(bind).getChildren().get(0);
		assertEquals("derived protocols not connectable (both directions extended)", diag.getMessage());
		
		diag = getDiag(resource.getEObject("ActorClass:Example8"));
		assertEquals(2, diag.getChildren().size());
		Diagnostic childDiag = diag.getChildren().get(0);
		assertEquals(RoomJavaValidator.A_REPLICATED_PORT_MUST_HAVE_AT_MOST_ONE_REPLICATED_PEER, childDiag.getMessage());
		childDiag = diag.getChildren().get(1);
		assertEquals(RoomJavaValidator.A_REPLICATED_PORT_MUST_HAVE_AT_MOST_ONE_REPLICATED_PEER, childDiag.getMessage());
	}
	
	@Test
	public void testProtocolValidation() {
		RoomModel mdl = (RoomModel) resource.getContents().get(0);
		for (GeneralProtocolClass pc : mdl.getProtocolClasses()) {
			if (pc.getName().equals("PCExtendInOut")) {
				Diagnostic diag = getDiag(pc).getChildren().get(0);
				assertEquals("a derived protocol should add either incoming or outgoing messages, not both", diag.getMessage());
			}
		}
	}
	
	private Binding getBinding(String acname, int idx) {
		ActorClass ac = (ActorClass) resource.getEObject("ActorClass:"+acname);
		return ac.getBindings().get(idx);
	}
}
