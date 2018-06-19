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
import org.eclipse.etrice.dctools.fsm.ast.DCScanner
import org.junit.Before
import org.junit.Test

import static org.eclipse.etrice.dctools.tests.TestConstants.*
import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*
import org.eclipse.etrice.dctools.fsm.ast.tokens.DCToken.Kind
import org.eclipse.etrice.dctools.fsm.ast.tokens.DCBracketToken.BracketKind
import org.eclipse.etrice.dctools.fsm.ast.tokens.DCToken
import org.eclipse.etrice.dctools.fsm.ast.tokens.DCBracketToken

class TestDCScanner {
	
	DCScanner scanner
	
	@Before
	def void createScanner() {
		scanner = new DCScanner(DCLanguage.C_LANGUAGE)
	}
	
	@Test
	def void testString() {
		val tokens = scanner.scan(TEST_STRING)
		assertThat(tokens.size, is(1))
		assertThat(tokens.get(0).token.kind, is(Kind.STRING))
	}
	
	@Test
	def void testCComment() {
		val tokens = scanner.scan(TEST_C_COMMENT)
		assertThat(tokens.size, is(1))
		assertThat(tokens.get(0).token.kind, is(Kind.COMMENT))
	}
	
	@Test
	def void testCComment2() {
		val tokens = scanner.scan(TEST_C_COMMENT2)
		assertThat(tokens.size, is(1))
		assertThat(tokens.get(0).token.kind, is(Kind.COMMENT))
	}
	
	@Test
	def void testCppComment() {
		val tokens = scanner.scan(TEST_CPP_COMMENT)
		assertThat(tokens.size, is(1))
		assertThat(tokens.get(0).token.kind, is(Kind.COMMENT))
	}
	
	@Test
	def void testEmptyRoundBracket() {
		testBracketExpression(TEST_EMPTY_ROUND_BRACKET, BracketKind.LEFT_ROUND, BracketKind.RIGHT_ROUND)
	}
	
	@Test
	def void testEmptyCurlyBracket() {
		testBracketExpression(TEST_EMPTY_CURLY_BRACKET, BracketKind.LEFT_CURLY, BracketKind.RIGHT_CURLY)
	}
	
	@Test
	def void testEmptySquareBracket() {
		testBracketExpression(TEST_EMPTY_SQUARE_BRACKET, BracketKind.LEFT_SQUARE, BracketKind.RIGHT_SQUARE)
	}
	
	@Test
	def void testRoundBracketWithContents() {
		val tokens = testBracketExpression(TEST_EMPTY_ROUND_BRACKET_W_CONTENTS1, BracketKind.LEFT_ROUND, BracketKind.RIGHT_ROUND, 1)
		assertThat(tokens.get(1).token.kind, is(Kind.COMMENT))
	}
	
	@Test
	def void testNestedBrackets() {
		val tokens = scanner.scan(TEST_NESTED_BRACKETS)
		assertThat(tokens.size, is(7))
		testBracketToken(tokens.get(0).token, BracketKind.LEFT_ROUND)
		assertThat(tokens.get(1).token.kind, is(Kind.COMMENT))
		testBracketToken(tokens.get(2).token, BracketKind.LEFT_ROUND)
		assertThat(tokens.get(3).token.kind, is(Kind.COMMENT))
		testBracketToken(tokens.get(4).token, BracketKind.RIGHT_ROUND)
		assertThat(tokens.get(5).token.kind, is(Kind.COMMENT))
		testBracketToken(tokens.get(6).token, BracketKind.RIGHT_ROUND)
	}
	
	@Test
	def void testIdentifier() {
		val tokens = scanner.scan(TEST_IDENTIFIER)
		assertThat(tokens.size, is(1))
		assertThat(tokens.get(0).token.kind, is(Kind.IDENTIFIER))
	}
	
	@Test
	def void testArrayAccess() {
		val tokens = scanner.scan(TEST_ARRAY_ACCESS)
		assertThat(tokens.size, is(3))
		assertThat(tokens.get(0).token.kind, is(Kind.IDENTIFIER))
		testBracketToken(tokens.get(1).token, BracketKind.LEFT_SQUARE)
		testBracketToken(tokens.get(2).token, BracketKind.RIGHT_SQUARE)
	}
	
	@Test
	def void testOperationCall() {
		val tokens = scanner.scan(TEST_OPERATION_CALL)
		assertThat(tokens.size, is(3))
		assertThat(tokens.get(0).token.kind, is(Kind.IDENTIFIER))
		testBracketToken(tokens.get(1).token, BracketKind.LEFT_ROUND)
		testBracketToken(tokens.get(2).token, BracketKind.RIGHT_ROUND)
	}
	
	@Test
	def void testMemberAccess() {
		val tokens = scanner.scan(TEST_MEMBER_ACCESS)
		assertThat(tokens.size, is(3))
		assertThat(tokens.get(0).token.kind, is(Kind.IDENTIFIER))
		assertThat(tokens.get(1).token.kind, is(Kind.PERIOD))
		assertThat(tokens.get(2).token.kind, is(Kind.IDENTIFIER))
	}
	
	@Test
	def void testArrayMemberAccess() {
		val tokens = scanner.scan(TEST_ARRAY_MEMBER_ACCESS)
		assertThat(tokens.size, is(8))
		assertThat(tokens.get(0).token.kind, is(Kind.IDENTIFIER))
		testBracketToken(tokens.get(1).token, BracketKind.LEFT_SQUARE)
		assertThat(tokens.get(2).token.kind, is(Kind.NUMBER))
		assertThat(tokens.get(3).token.kind, is(Kind.OTHER))
		assertThat(tokens.get(4).token.kind, is(Kind.NUMBER))
		testBracketToken(tokens.get(5).token, BracketKind.RIGHT_SQUARE)
		assertThat(tokens.get(6).token.kind, is(Kind.PERIOD))
		assertThat(tokens.get(7).token.kind, is(Kind.IDENTIFIER))
	}
	
	@Test
	def void testArrayMemberAccessAndCall() {
		val tokens = scanner.scan(TEST_ARRAY_MEMBER_ACCESS_AND_CALL)
		assertThat(tokens.size, is(12))
		
		var pos = 0
		assertThat(tokens.get(pos++).token.kind, is(Kind.IDENTIFIER))
		testBracketToken(tokens.get(pos++).token, BracketKind.LEFT_SQUARE)
		assertThat(tokens.get(pos++).token.kind, is(Kind.NUMBER))
		assertThat(tokens.get(pos++).token.kind, is(Kind.OTHER))
		assertThat(tokens.get(pos++).token.kind, is(Kind.NUMBER))
		testBracketToken(tokens.get(pos++).token, BracketKind.RIGHT_SQUARE)
		assertThat(tokens.get(pos++).token.kind, is(Kind.PERIOD))
		assertThat(tokens.get(pos++).token.kind, is(Kind.IDENTIFIER))
		
		assertThat(tokens.get(pos++).token.kind, is(Kind.PERIOD))
		assertThat(tokens.get(pos++).token.kind, is(Kind.IDENTIFIER))
		testBracketToken(tokens.get(pos++).token, BracketKind.LEFT_ROUND)
		testBracketToken(tokens.get(pos++).token, BracketKind.RIGHT_ROUND)
	}
	
	@Test
	def void testSpacyArrayMemberAccessAndCall() {
		val tokens = scanner.scan(TEST_SPACY_ARRAY_MEMBER_ACCESS_AND_CALL)
		assertThat(tokens.size, is(23))
		
		var pos = 0
		assertThat(tokens.get(pos++).token.kind, is(Kind.IDENTIFIER))
		assertThat(tokens.get(pos++).token.kind, is(Kind.WHITESPACE))
		testBracketToken(tokens.get(pos++).token, BracketKind.LEFT_SQUARE)
		assertThat(tokens.get(pos++).token.kind, is(Kind.WHITESPACE))
		assertThat(tokens.get(pos++).token.kind, is(Kind.NUMBER))
		assertThat(tokens.get(pos++).token.kind, is(Kind.WHITESPACE))
		assertThat(tokens.get(pos++).token.kind, is(Kind.OTHER))
		assertThat(tokens.get(pos++).token.kind, is(Kind.WHITESPACE))
		assertThat(tokens.get(pos++).token.kind, is(Kind.NUMBER))
		assertThat(tokens.get(pos++).token.kind, is(Kind.WHITESPACE))
		testBracketToken(tokens.get(pos++).token, BracketKind.RIGHT_SQUARE)
		assertThat(tokens.get(pos++).token.kind, is(Kind.WHITESPACE))
		assertThat(tokens.get(pos++).token.kind, is(Kind.PERIOD))
		assertThat(tokens.get(pos++).token.kind, is(Kind.WHITESPACE))
		assertThat(tokens.get(pos++).token.kind, is(Kind.IDENTIFIER))
		
		assertThat(tokens.get(pos++).token.kind, is(Kind.WHITESPACE))
		assertThat(tokens.get(pos++).token.kind, is(Kind.PERIOD))
		assertThat(tokens.get(pos++).token.kind, is(Kind.WHITESPACE))
		assertThat(tokens.get(pos++).token.kind, is(Kind.IDENTIFIER))
		assertThat(tokens.get(pos++).token.kind, is(Kind.WHITESPACE))
		testBracketToken(tokens.get(pos++).token, BracketKind.LEFT_ROUND)
		assertThat(tokens.get(pos++).token.kind, is(Kind.WHITESPACE))
		testBracketToken(tokens.get(pos++).token, BracketKind.RIGHT_ROUND)
	}
	
	@Test
	def void testCode() {
		val tokens = scanner.scan(TEST_CODE)
		assertThat(tokens.size, is(20))
		
		var pos = 0
		assertThat(tokens.get(pos++).token.kind, is(Kind.IDENTIFIER))
	}
	
	@Test
	def void testCode1() {
		val tokens = scanner.scan(TEST_CODE1)
		assertThat(tokens.size, is(15))
		
		var pos = 0
		assertThat(tokens.get(pos++).token.kind, is(Kind.IDENTIFIER))
	}
	
	@Test
	def void testCode2() {
		val tokens = scanner.scan(TEST_CODE2)
		assertThat(tokens.size, is(59))
		
		assertThat(tokens.get(19).token.kind, is(Kind.KEYWORD))
		assertThat(tokens.get(34).token.kind, is(Kind.NUMBER))
	}
	
	@Test
	def void testCode3() {
		val tokens = scanner.scan(TEST_CODE3)
		assertThat(tokens.size, is(69))
		
		assertThat(tokens.get(6).token.kind, is(Kind.NUMBER))
		assertThat(tokens.get(7).token.kind, is(Kind.STATEMENT_SEP))
		assertThat(tokens.get(19).token.kind, is(Kind.IDENTIFIER))
		assertThat(tokens.get(29).token.kind, is(Kind.BRACKET))
		assertThat(tokens.get(34).token.kind, is(Kind.IDENTIFIER))
	}
	
	@Test
	def void testUnclosedString() {
		val tokens = scanner.scan(TEST_UNCLOSED_STRING)
		assertThat(tokens.size, is(1))
		assertThat(tokens.get(0).token.kind, is(Kind.STRING))
	}
	
	@Test
	def void testUnclosedBrackets() {
		val tokens = scanner.scan(TEST_UNCLOSED_BRACKETS)
		assertThat(tokens.size, is(2))
		
		var pos = 0
		testBracketToken(tokens.get(pos++).token, BracketKind.LEFT_ROUND)
		assertThat(tokens.get(pos++).token.kind, is(Kind.COMMENT))
	}
	
	@Test
	def void testUnclosedNestedBrackets() {
		val tokens = scanner.scan(TEST_UNCLOSED_NESTED_BRACKETS)
		assertThat(tokens.size, is(5))
		
		var pos = 0
		testBracketToken(tokens.get(pos++).token, BracketKind.LEFT_ROUND)
		testBracketToken(tokens.get(pos++).token, BracketKind.LEFT_ROUND)
		assertThat(tokens.get(pos++).token.kind, is(Kind.COMMENT))
		testBracketToken(tokens.get(pos++).token, BracketKind.RIGHT_ROUND)
		assertThat(tokens.get(pos++).token.kind, is(Kind.COMMENT))
	}
	
	@Test
	def void testIncompleteFeatureCall() {
		val tokens = scanner.scan(TEST_INCOMPLETE_FEATURE_CALL)
		assertThat(tokens.size, is(4))
		
		var pos = 0
		assertThat(tokens.get(pos++).token.kind, is(Kind.IDENTIFIER))
		assertThat(tokens.get(pos++).token.kind, is(Kind.PERIOD))
		assertThat(tokens.get(pos++).token.kind, is(Kind.IDENTIFIER))
		assertThat(tokens.get(pos++).token.kind, is(Kind.PERIOD))
	}
	
	/*
	 * helper methods
	 */
	private def testBracketExpression(String test, BracketKind left, BracketKind right) {
		testBracketExpression(test, left, right, 0)
	}
	
	private def testBracketExpression(String test, BracketKind left, BracketKind right, int nInnerTokens) {
		val tokens = scanner.scan(test)
		
		assertThat(tokens.size, is(2+nInnerTokens))
		testBracketToken(tokens.get(0).token, left)
		testBracketToken(tokens.get(1+nInnerTokens).token, right)
		
		return tokens
	}
	
	private def testBracketToken(DCToken t, BracketKind k) {
		assertThat(t.kind, is(Kind.BRACKET))
		assertTrue(t instanceof DCBracketToken)
		var bt = t as DCBracketToken
		assertThat(bt.bracketKind, is(k))
	}
}