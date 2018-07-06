/*******************************************************************************
 * Copyright (c) 2018 protos software gmbh (http://www.protos.de).
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

import org.eclipse.etrice.dctools.fsm.ast.DCLanguage
import org.eclipse.etrice.dctools.fsm.ast.DCParser
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstArrayAccessNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstBracketNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstFeatureCallNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstIdentifierNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstMatchNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstOperationCallNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstOtherNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstPeriodNode
import org.eclipse.etrice.dctools.fsm.ast.util.DCAstPrinter
import org.junit.Before
import org.junit.Test

import static org.eclipse.etrice.dctools.tests.TestConstants.*
import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

class TestDCParser {
		
	DCParser parser
	
	@Before
	def void createParser() {
		parser = new DCParser(DCLanguage.C_LANGUAGE)
	}
	
	@Test
	def void testString() {
		testSingleOther("testString", TEST_STRING)
	}
	
	@Test
	def void testCComment() {
		testSingleOther("testCComment", TEST_C_COMMENT)
	}
	
	@Test
	def void testCComment2() {
		testSingleOther("testCComment2", TEST_C_COMMENT2)
	}
	
	@Test
	def void testCppComment() {
		testSingleOther("testCppComment", TEST_CPP_COMMENT)
	}
	
	@Test
	def void testEmptyRoundBracket() {
		testBracketExpression(TEST_EMPTY_ROUND_BRACKET, DCAstBracketNode.BracketType.ROUND)
	}
	
	@Test
	def void testEmptyCurlyBracket() {
		testBracketExpression(TEST_EMPTY_CURLY_BRACKET, DCAstBracketNode.BracketType.CURLY)
	}
	
	@Test
	def void testEmptySquareBracket() {
		testBracketExpression(TEST_EMPTY_SQUARE_BRACKET, DCAstBracketNode.BracketType.SQUARE)
	}
	
	@Test
	def void testRoundBracketWithContents() {
		testBracketExpression(TEST_EMPTY_ROUND_BRACKET_W_CONTENTS1, DCAstBracketNode.BracketType.ROUND, CONTENTS1)
	}
	
	@Test
	def void testNestedBrackets() {
		val result = parser.parse(TEST_NESTED_BRACKETS)
		assertNotNull(result)
		
		// we have a single bracket expression
		assertThat(result.children.size, is(1))
		var node = result.children.get(0)
		
		// it is a bracket node
		assertTrue(node instanceof DCAstBracketNode)
		assertTrue((node as DCAstBracketNode).type==DCAstBracketNode.BracketType.ROUND)
		
		// which has one child
		assertThat(node.children.size, is(1))
		node = node.children.get(0)
		
		// which is a match node
		assertTrue(node instanceof DCAstMatchNode)
		
		// which has three children
		assertThat(node.children.size, is(3))
		
		// first child is a comment
		node = node.children.get(0)
		assertTrue(node instanceof DCAstOtherNode)
		assertEquals((node as DCAstOtherNode).text, CONTENTS1)
		
		// third child is a comment
		node = node.parent.children.get(2)
		assertTrue(node instanceof DCAstOtherNode)
		assertEquals((node as DCAstOtherNode).text, CONTENTS3)
		
		// middle child is a bracket
		node = node.parent.children.get(1)
		assertTrue(node instanceof DCAstBracketNode)
		assertTrue((node as DCAstBracketNode).type==DCAstBracketNode.BracketType.ROUND)
		
		// which has one child
		assertThat(node.children.size, is(1))
		node = node.children.get(0)
		
		// which is a match node
		assertTrue(node instanceof DCAstMatchNode)
		
		// which has one child
		assertThat(node.children.size, is(1))
		node = node.children.get(0)
		
		// which is a comment
		assertTrue(node instanceof DCAstOtherNode)
		assertEquals((node as DCAstOtherNode).text, CONTENTS2)
		
		prettyPrint("testNestedBrackets", TEST_NESTED_BRACKETS, result, 7, 8)
	}
	
	@Test
	def void testIdentifier() {
		val result = parser.parse(TEST_IDENTIFIER)
		assertNotNull(result)
		
		// we have a feature
		assertThat(result.children.size, is(1))
		var node = result.children.get(0)
		assertTrue(node instanceof DCAstFeatureCallNode)
		
		// it is an identifier node
		node = node.children.get(0)
		assertTrue(node instanceof DCAstIdentifierNode)
		assertThat((node as DCAstIdentifierNode).id, is(TEST_IDENTIFIER))
		
		prettyPrint("testIdentifier", TEST_IDENTIFIER, result, 1, 3)
	}
	
	@Test
	def void testArrayAccess() {
		val result = parser.parse(TEST_ARRAY_ACCESS)
		assertNotNull(result)
		
		// we have a feature
		assertThat(result.children.size, is(1))
		var node = result.children.get(0)
		assertTrue(node instanceof DCAstFeatureCallNode)
		
		// with an array access
		assertThat(node.children.size, is(1))
		node = node.children.get(0)
		assertTrue(node instanceof DCAstArrayAccessNode)

		// with two children		
		assertThat(node.children.size, is(2))
		
		// an identifier
		node = node.children.get(0)
		assertTrue(node instanceof DCAstIdentifierNode)
		
		// and a bracket
		node = node.parent.children.get(1)
		assertTrue(node instanceof DCAstBracketNode)
		
		prettyPrint("testArrayAccess", TEST_ARRAY_ACCESS, result, 3, 6)
	}
	
	@Test
	def void testOperationCall() {
		val result = parser.parse(TEST_OPERATION_CALL)
		assertNotNull(result)
		
		// we have a feature
		assertThat(result.children.size, is(1))
		var node = result.children.get(0)
		assertTrue(node instanceof DCAstFeatureCallNode)
		
		// with an operation call
		assertThat(node.children.size, is(1))
		node = node.children.get(0)
		assertTrue(node instanceof DCAstOperationCallNode)

		// with two children		
		assertThat(node.children.size, is(2))
		
		// an identifier
		node = node.children.get(0)
		assertTrue(node instanceof DCAstIdentifierNode)
		
		// and a bracket
		node = node.parent.children.get(1)
		assertTrue(node instanceof DCAstBracketNode)
		
		prettyPrint("testOperationCall", TEST_OPERATION_CALL, result, 3, 6)
	}
	
	@Test
	def void testMemberAccess() {
		val result = parser.parse(TEST_MEMBER_ACCESS)
		assertNotNull(result)
		
		// we have a feature
		assertThat(result.children.size, is(1))
		var node = result.children.get(0)
		assertTrue(node instanceof DCAstFeatureCallNode)
		
		// with identifier period identifier
		assertThat(node.children.size, is(3))
		
		// identifier node
		node = node.children.get(0)
		assertTrue(node instanceof DCAstIdentifierNode)
		
		// period node
		node = node.parent.children.get(1)
		assertTrue(node instanceof DCAstPeriodNode)
		
		// identifier node
		node = node.parent.children.get(2)
		assertTrue(node instanceof DCAstIdentifierNode)
		
		prettyPrint("testMemberAccess", TEST_MEMBER_ACCESS, result, 3, 5)
	}
	
	@Test
	def void testArrayMemberAccess() {
		val result = parser.parse(TEST_ARRAY_MEMBER_ACCESS)
		assertNotNull(result)
		
		prettyPrint("testArrayMemberAccess", TEST_ARRAY_MEMBER_ACCESS, result, 8, 11)
	}
	
	@Test
	def void testArrayMemberAccessAndCall() {
		val result = parser.parse(TEST_ARRAY_MEMBER_ACCESS_AND_CALL)
		assertNotNull(result)
		
		prettyPrint("testArrayMemberAccessAndCall", TEST_ARRAY_MEMBER_ACCESS_AND_CALL, result, 12, 16)
	}
	
	@Test
	def void testSpaciousArrayMemberAccessAndCall() {
		val result = parser.parse(TEST_SPACIOUS_ARRAY_MEMBER_ACCESS_AND_CALL)
		assertNotNull(result)
		
		prettyPrint("testSpacyArrayMemberAccessAndCall", TEST_SPACIOUS_ARRAY_MEMBER_ACCESS_AND_CALL, result, 23, 27)
	}
	
	@Test
	def void testCode() {
		val result = parser.parse(TEST_CODE)
		assertNotNull(result)
		
		prettyPrint("testCode", TEST_CODE, result, 20, 29)
	}
	
	@Test
	def void testCode1() {
		val result = parser.parse(TEST_CODE1)
		assertNotNull(result)
		
		prettyPrint("testCode", TEST_CODE1, result, 15, 20)
	}
	
	@Test
	def void testCode2() {
		val result = parser.parse(TEST_CODE2)
		assertNotNull(result)
		
		prettyPrint("testCode2", TEST_CODE2, result, 59, 76)
	}
	
	@Test
	def void testCode3() {
		val result = parser.parse(TEST_CODE3)
		assertNotNull(result)
		
		prettyPrint("testCode3", TEST_CODE3, result, 69, 81)
	}
	
	@Test
	def void testUnclosedString() {
		val result = parser.parse(TEST_UNCLOSED_STRING)
		assertNotNull(result)
		
		prettyPrint("testUnclosedString", TEST_UNCLOSED_STRING, result, 1, 2)
	}
	
	@Test
	def void testUnclosedNestedBrackets() {
		val result = parser.parse(TEST_UNCLOSED_NESTED_BRACKETS)
		assertNotNull(result)
		
		prettyPrint("testUnclosedNestedBrackets", TEST_UNCLOSED_NESTED_BRACKETS, result, 6, 7)
	}
	
	@Test
	def void testIncompleteFeatureCall() {
		val result = parser.parse(TEST_INCOMPLETE_FEATURE_CALL)
		assertNotNull(result)
		
		prettyPrint("testIncompleteFeatureCall", TEST_INCOMPLETE_FEATURE_CALL, result, 4, 6)
	}
	
	/*
	 * helper methods
	 */
	private def prettyPrint(String method, String orig, DCAstMatchNode node, int nTokes, int nNodes) {
		val printer = new DCAstPrinter
		node.visit(printer)
		
		println("<<<" + method)
		println("tree: ")
		node.print
		println(nNodes + " nodes, " + nTokes + " tokens")
		println("orig: '" + orig + "'")
		println("ast:  '" + printer.text + "'")
		println(method + ">>>")
		
		assertEquals(orig, printer.text)
		assertThat(node.totallyReadTokens, is(nTokes))
		assertThat(node.countNodes, is(nNodes))
	}
	
	private def void testBracketExpression(String test, DCAstBracketNode.BracketType bt) {
		testBracketExpression(test, bt, null)
	}
	
	private def void testBracketExpression(String test, DCAstBracketNode.BracketType bt, String contents) {
		val result = parser.parse(test)
		assertNotNull(result)
		
		// we have only a bracket expression
		assertThat(result.children.size, is(1))
		var node = result.children.get(0)
		
		// it is a bracket node
		assertTrue(node instanceof DCAstBracketNode)
		assertTrue((node as DCAstBracketNode).type==bt)
		
		// which has one child
		assertThat(node.children.size, is(1))
		node = node.children.get(0)
		
		// which is a match node
		assertTrue(node instanceof DCAstMatchNode)
		
		if (contents===null) {
			// which is empty
			assertThat(node.children.size, is(0))
		}
		else {
			// which has a single sub node
			assertThat(node.children.size, is(1))
			
			// which is Other with contents
			testOther(node.children.get(0), contents)
		}
	}
	
	private def testSingleOther(String method, String test) {
		val result = parser.parse(test)
		assertNotNull(result)
		
		prettyPrint(method, test, result, 1, 2)
		
		// only one Other expression
		assertThat(result.children.size, is(1))
		
		testOther(result.children.get(0), test)
	}
	
	private def testOther(DCAstNode node, String contents) {
		// which is an Other node
		assertTrue(node instanceof DCAstOtherNode)
		
		// with the test text as contents
		assertEquals((node as DCAstOtherNode).text, contents)
	}
	
	private def int countNodes(DCAstNode node) {
		var sum = 1
		
		for (child : node.children) {
			sum += child.countNodes
		}
		
		return sum
	}
}