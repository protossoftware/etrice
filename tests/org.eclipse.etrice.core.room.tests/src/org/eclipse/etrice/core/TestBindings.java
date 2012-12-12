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
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SubSystemClass;
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
		RoomModel mdl = (RoomModel) resource.getContents().get(0);
		SubSystemClass ssc = mdl.getSubSystemClasses().get(0);
		Binding bind = ssc.getBindings().get(0);
		Diagnostic diag = getDiag(bind).getChildren().get(0);
		assertEquals("expect error message", "no self connection allowed, ports are indentical", diag.getMessage());
		
		bind = ssc.getBindings().get(1);
		diag = getDiag(bind).getChildren().get(0);
		assertEquals("expect error message", "port with multiplicity 1 is already connected", diag.getMessage());
		
		bind = ssc.getBindings().get(2);
		diag = getDiag(bind).getChildren().get(0);
		assertEquals("expect error message", "port with multiplicity 1 is already connected", diag.getMessage());
		
		bind = ssc.getBindings().get(3);
		diag = getDiag(bind).getChildren().get(0);
		assertEquals("protocols don't match", diag.getMessage());
		
		bind = ssc.getBindings().get(4);
		diag = getDiag(bind).getChildren().get(0);
		assertEquals("protocol extends incoming", diag.getMessage());
		
		bind = ssc.getBindings().get(6);
		diag = getDiag(bind).getChildren().get(0);
		assertEquals("protocol extends outgoing", diag.getMessage());
		
		bind = ssc.getBindings().get(7);
		diag = getDiag(bind).getChildren().get(0);
		assertEquals("derived protocols not connectable (both directions extended)", diag.getMessage());
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
}
