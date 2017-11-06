/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Eyrak Paen (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.common.base.AnnotationType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.junit.Before;
import org.junit.Test;

public class TestAnnotations extends TestBase {
	private Resource res = null;
	
	@Before
	public void SetUp() {
		prepare(CoreTestsActivator.getInstance().getBundle());
		res = getResource("AnnotationExample.room");
	}
	
	@Test
	public void AnnotationTypeWithAllPossibleTargets() {
		EObject obj = res.getEObject("AnnotationType:AllPossibleTargets");
		AnnotationType at = (AnnotationType)obj;
		Diagnostic diag = getDiag(at);
		assertTrue(diag.getChildren().isEmpty());
	}
	
	@Test
	public void WrongAnnotationTarget() {
		EObject obj = res.getEObject("ProtocolClass:WrongTargetTestProtocol");
		ProtocolClass pc = (ProtocolClass)obj;
		Diagnostic diag = getDiag(pc);
		assertFalse(diag.getChildren().isEmpty());
		assertTrue(diag.getChildren().size() == 1);
		assertTrue(diag.getChildren().get(0).getMessage().contains("not allowed for target ProtocolClass"));
	}
}
