/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.dctools.tests

import org.eclipse.etrice.dctools.fsm.ast.DCParser
import org.junit.Before
import org.eclipse.etrice.dctools.fsm.ast.DCLanguage
import static org.eclipse.etrice.dctools.tests.TestConstants.*
import org.junit.Test
import org.eclipse.etrice.dctools.fsm.ast.DCNodeAtOffset
import static org.junit.Assert.*
import static org.hamcrest.CoreMatchers.*
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstOtherNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstIdentifierNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstBracketNode

class TestDCNodeAtOffset {
		
	DCParser parser
	
	@Before
	def void createParser() {
		parser = new DCParser(DCLanguage.C_LANGUAGE)
	}
	
	@Test
	def void testString() {
		val ast = parser.parse(TEST_STRING)
		val result = DCNodeAtOffset.find(ast, 3)
		assertNotNull(result)
		assertTrue(result instanceof DCAstOtherNode)
		assertThat(result.text, is(TEST_STRING))
	}
	
	@Test
	def void testMemberAccess() {
		val ast = parser.parse(TEST_MEMBER_ACCESS)
		var result = DCNodeAtOffset.find(ast, 8)
		assertNotNull(result)
		assertTrue(result instanceof DCAstIdentifierNode)
		assertThat(result.text, is("member"))

		result = DCNodeAtOffset.find(ast, 4)
		assertNotNull(result)
		assertTrue(result instanceof DCAstIdentifierNode)
		assertThat(result.text, is("field"))
	}
	
	@Test
	def void testArrayMemberAccess() {
		val ast = parser.parse(TEST_ARRAY_MEMBER_ACCESS)
		var result = DCNodeAtOffset.find(ast, 14)
		assertNotNull(result)
		assertTrue(result instanceof DCAstIdentifierNode)
		assertThat(result.text, is("member"))

		result = DCNodeAtOffset.find(ast, 4)
		assertNotNull(result)
		assertTrue(result instanceof DCAstIdentifierNode)
		assertThat(result.text, is("field"))

		result = DCNodeAtOffset.find(ast, 7)
		assertNotNull(result)
		assertTrue(result instanceof DCAstOtherNode)
		assertThat(result.text, is("+"))
	}
	
	@Test
	def void testCode() {
		val ast = parser.parse(TEST_CODE)
		var result = DCNodeAtOffset.find(ast, 16)
		assertNotNull(result)
		assertTrue(result instanceof DCAstBracketNode)
		if (result instanceof DCAstBracketNode) {
			assertThat(result.text, is("()"))
			assertThat(result.begin, is(15))
			assertThat(result.end, is(16))
			assertThat(result.posClose, is(16))
		}
	}
	
	@Test
	def void testCode2() {
		val ast = parser.parse(TEST_CODE2)
		
		// note: because line breaks differ on UNIX and Windows we can't use a constant offset here
		val pos = TEST_CODE2.indexOf("456")+2
		
		var result = DCNodeAtOffset.find(ast, pos)
		assertNotNull(result)
		assertTrue(result instanceof DCAstOtherNode)
		assertThat(result.text, is("456"))
	}
}
