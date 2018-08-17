/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.room.EnumLiteral;
import org.eclipse.etrice.core.room.EnumerationType;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Henrik Rentz-Reichert
 * 
 */
public class TestEnumerations extends TestBase {
	private Resource res = null;

	@Before
	public void SetUp() {
		prepare(CoreTestsActivator.getInstance().getBundle());
		res = getResource("EnumExample.room");
	}

	@Test
	public void testImplicitEnumValues() {
		EObject obj = res.getEObject("EnumerationType:FirstEnum");
		EnumerationType et = (EnumerationType) obj;
		Diagnostic diag = getDiag(et);
		assertTrue(diag.getChildren().isEmpty());
		
		int i = 0;
		for (EnumLiteral lit : et.getLiterals()) {
			assertEquals("literal value", i++, lit.getLiteralValue());
		}
	}

	@Test
	public void testImplicitEnumValuesWithStart() {
		EObject obj = res.getEObject("EnumerationType:SecondEnum");
		EnumerationType et = (EnumerationType) obj;
		Diagnostic diag = getDiag(et);
		assertTrue(diag.getChildren().isEmpty());
		
		int i = 1;
		for (EnumLiteral lit : et.getLiterals()) {
			assertEquals("literal value", i++, lit.getLiteralValue());
		}
	}

	@Test
	public void testPartialExplicitValues() {
		EObject obj = res.getEObject("EnumerationType:ThirdEnum");
		EnumerationType et = (EnumerationType) obj;
		Diagnostic diag = getDiag(et);
		assertTrue(diag.getChildren().isEmpty());
		
		for (EnumLiteral lit : et.getLiterals()) {
			if (lit.getName().equals("one"))
				assertEquals("literal value", 1, lit.getLiteralValue());
			else if (lit.getName().equals("two"))
				assertEquals("literal value", 2, lit.getLiteralValue());
			else if (lit.getName().equals("five"))
				assertEquals("literal value", 5, lit.getLiteralValue());
		}
	}

	@Test
	public void testExplicitValuesWithHex() {
		EObject obj = res.getEObject("EnumerationType:FourthEnum");
		EnumerationType et = (EnumerationType) obj;
		Diagnostic diag = getDiag(et);
		assertTrue(diag.getChildren().isEmpty());
		
		for (EnumLiteral lit : et.getLiterals()) {
			if (lit.getName().equals("one"))
				assertEquals("literal value", 1, lit.getLiteralValue());
			else if (lit.getName().equals("three"))
				assertEquals("literal value", 3, lit.getLiteralValue());
			else if (lit.getName().equals("sixtyfive"))
				assertEquals("literal value", 0x41, lit.getLiteralValue());
		}
	}

	@Test
	public void testExplicitValuesWithHexOnly() {
		EObject obj = res.getEObject("EnumerationType:FourthEnum");
		EnumerationType et = (EnumerationType) obj;
		Diagnostic diag = getDiag(et);
		assertTrue(diag.getChildren().isEmpty());
		
		for (EnumLiteral lit : et.getLiterals()) {
			if (lit.getName().equals("f1"))
				assertEquals("literal value", 0x1, lit.getLiteralValue());
			else if (lit.getName().equals("f2"))
				assertEquals("literal value", 0x2, lit.getLiteralValue());
			else if (lit.getName().equals("f3"))
				assertEquals("literal value", 0x4, lit.getLiteralValue());
			else if (lit.getName().equals("f4"))
				assertEquals("literal value", 0x8, lit.getLiteralValue());
		}
	}

	@Test
	public void testWrongEnumType() {
		EObject obj = res.getEObject("EnumerationType:WrongType");
		EnumerationType et = (EnumerationType) obj;
		Diagnostic diag = getDiag(et);
		assertTrue(diag.getChildren().size() == 1);
		assertTrue(diag.getChildren().get(0).getMessage().contains("enumerations must be of integer type"));
	}

	@Test
	public void testEmptyEnum() {
		EObject obj = res.getEObject("EnumerationType:EmptyEnum");
		EnumerationType et = (EnumerationType) obj;
		Diagnostic diag = getDiag(et);
		assertTrue(diag.getChildren().size() == 1);
		assertTrue(diag.getChildren().get(0).getMessage().contains("at least one literal has to be specified"));
	}

}
