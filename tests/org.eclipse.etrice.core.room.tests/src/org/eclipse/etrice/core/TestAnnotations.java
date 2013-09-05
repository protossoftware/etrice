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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Annotation;
import org.eclipse.etrice.core.room.AnnotationType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.junit.Before;
import org.junit.Test;

public class TestAnnotations extends TestBase {
	private Resource res = null;
	
	@Before
	public void SetUp() {
		prepare();
		res = getResource("AnnotationExample.room");
	}
	
	@Test
	public void AnnotationTypeWithAllFeatures() {
		EObject obj = res.getEObject("AnnotationType:ExampleAnnotation");
		AnnotationType at = (AnnotationType)obj;
		assertEquals(6,at.getAttributes().size());
		Diagnostic diag = getDiag(at);
		assertTrue(diag.getChildren().isEmpty());
	}
	
	@Test
	public void AnnotationWithAllFeatures() {
		EObject obj = res.getEObject("ActorClass:ActorClass1");
		ActorClass ac = (ActorClass)obj;
		Annotation anno = ac.getAnnotations().get(0);
		assertEquals(5,anno.getAttributes().size());
		Diagnostic diag = getDiag(anno);
		assertTrue(diag.getChildren().isEmpty());
	}
	
	@Test
	public void NonUniqueAnnotationTypeTargets() {
		EObject obj = res.getEObject("AnnotationType:NonUniqueTargets");
		AnnotationType at = (AnnotationType)obj;
		Diagnostic diag = getDiag(at);
		assertFalse(diag.getChildren().isEmpty());
		assertTrue(diag.getChildren().size() == 1);
		assertTrue(diag.getChildren().get(0).getMessage().contains("duplicate target ActorClass"));
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
	
	@Test
	public void UndefinedAttributeInAnnotation() {
		EObject obj = res.getEObject("ActorClass:UndefinedAttributeTestActor");
		ActorClass ac = (ActorClass)obj;
		Diagnostic diag = getDiag(ac);
		assertFalse(diag.getChildren().isEmpty());
		assertTrue(diag.getChildren().size() == 1);
		assertTrue(diag.getChildren().get(0).getMessage().contains("undefined attribute"));
	}
	
	@Test
	public void MandatoryAttributesMissingInAnnotation() {
		EObject obj = res.getEObject("ActorClass:MandatoryAttributeTestActor");
		ActorClass ac = (ActorClass)obj;
		Diagnostic diag = getDiag(ac);
		assertFalse(diag.getChildren().isEmpty());
		assertTrue(diag.getChildren().size() == 1);
		assertTrue(diag.getChildren().get(0).getMessage().contains("missing mandatory attributes"));
	}
	
	@Test
	public void InvalidEnumValue() {
		EObject obj = res.getEObject("ActorClass:InvalidEnumValue");
		ActorClass ac = (ActorClass)obj;
		Diagnostic diag = getDiag(ac);
		assertFalse(diag.getChildren().isEmpty());
		assertTrue(diag.getChildren().size() == 1);
		assertTrue(diag.getChildren().get(0).getMessage().contains("Invalid enum attribute value"));
	}
}
