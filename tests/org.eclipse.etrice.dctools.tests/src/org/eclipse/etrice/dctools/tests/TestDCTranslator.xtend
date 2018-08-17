/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.dctools.tests

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.etrice.core.TestBase
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.junit.Before
import static org.junit.Assert.*
import static org.hamcrest.CoreMatchers.*
import org.junit.Test
import org.eclipse.etrice.dctools.fsm.ast.DCLanguage
import org.eclipse.etrice.dctools.ast.DCTranslator
import org.eclipse.etrice.core.fsm.fSM.DetailCode

class TestDCTranslator extends TestBase {
	
	Resource res = null;
	RoomModel model
	TranslationProviderForTests provider
	DCTranslator translator
	val extension RoomHelpers roomHelpers = new RoomHelpers
	
	@Before
	def void SetUp() {
		prepare(DCToolsTestsActivator.getInstance.bundle)
		res = getResource("DetailCodes.room")
		assertNotNull(res)
		assertFalse(res.contents.empty)
		assertTrue(res.contents.head instanceof RoomModel)
		model = res.contents.head as RoomModel
		provider = new TranslationProviderForTests
		translator = new DCTranslator(DCLanguage.C_LANGUAGE, provider)
	}
	
	@Test
	def void testPortMessage() {
		// we want to test the entry code of state 'first'
		val ac = model.actorClasses.filter[name=="AC"].head
		val st = ac.stateMachine.states.filter[name=="first"].head
		
		val translated = translator.getTranslatedCode(st.entryCode)
		printResult("testPortMessage", st.entryCode, translated)
		
		// check the translation count
		assertThat(provider.attributeCount, is(0))
		assertThat(provider.operationCount, is(0))
		assertThat(provider.messageTextCount, is(2))
		
		// check the two translated parts
		assertThat(translated, startsWith("PC_start(prt);"))
		assertThat(translated, containsString("\nPC_result(prt, lpt);"))
		
		// and the result should not contain a null string
		assertThat(translated, not(containsString("null")))
	}
	
	@Test
	def void testReplPortMessage() {
		// we want to test the exit code of state 'second'
		val ac = model.actorClasses.filter[name=="AC"].head
		val st = ac.stateMachine.states.filter[name=="second"].head
		
		val translated = translator.getTranslatedCode(st.exitCode)
		printResult("testReplPortMessage", st.exitCode, translated)
		
		// check the translation count
		assertThat(provider.attributeCount, is(0))
		assertThat(provider.operationCount, is(0))
		assertThat(provider.messageTextCount, is(2))
		
		// check the two translated parts
		assertThat(translated, startsWith("PC_start(replPrt, 0);"))
		assertThat(translated, containsString("\nPC_start_broadcast(replPrt);"))
		
		// and the result should not contain a null string
		assertThat(translated, not(containsString("null")))
	}
	
	@Test
	def void testActorClassAttributes() {
		// we want to test the entry code of state 'first'
		val ac = model.actorClasses.filter[name=="AC"].head
		val st = ac.stateMachine.states.filter[name=="second"].head
		
		val translated = translator.getTranslatedCode(st.entryCode)
		printResult("testActorClassAttributes", st.entryCode, translated)
		
		// check the translation count
		assertThat(provider.attributeCount, is(8))
		assertThat(provider.operationCount, is(3))
		assertThat(provider.messageTextCount, is(0))
		
		// check the translated parts
		assertThat(translated, startsWith("double d = diameter(c(globalScopeSelf));"))
		assertThat(translated, containsString("\nd = distance(p(globalScopeSelf, 0), p(globalScopeSelf, 1));"))
		assertThat(translated, containsString("\nd = distance(globalScopeSelf, p(globalScopeSelf, 0), p(globalScopeSelf, 1));"))
		assertThat(translated, containsString("\nd = x(c(c(globalScopeSelf)));"))
	}
	
	@Test
	def void testDataClassOperationWithAttributesAndVarDecl() {
		// we want to test the distance operation of data class Point
		val dc = model.dataClasses.filter[name=="Point"].head
		val op = dc.operations.filter[name=="distance"].head
		
		val translated = translator.getTranslatedCode(op.detailCode)
		printResult("testDataClassOperationWithAttributesAndVarDecl", op.detailCode, translated)
		
		// check the translation count
		assertThat(provider.attributeCount, is(4))
		assertThat(provider.operationCount, is(0))
		assertThat(provider.messageTextCount, is(0))
		
		// check the two translated parts
		assertThat(translated, startsWith("double dx = x(globalScopeSelf)- x(other);"))
		assertThat(translated, containsString("\ndouble dy = y(globalScopeSelf)- y(other);"))
		
		// and the result should not contain a null string
		assertThat(translated, not(containsString("null")))
	}
	
	@Test
	def void testDataClassOperationWithOperationCall() {
		// we want to test the isInside operation of data class Circle
		val dc = model.dataClasses.filter[name=="Circle"].head
		val op = dc.operations.filter[name=="isInside"].head
		
		val translated = translator.getTranslatedCode(op.detailCode)
		printResult("testDataClassOperationWithOperationCall", op.detailCode, translated)
		
		// check the translation count
		assertThat(provider.attributeCount, is(2))
		assertThat(provider.operationCount, is(1))
		assertThat(provider.messageTextCount, is(0))
		
		// check the translated part
		assertThat(translated, startsWith("return distance(c(globalScopeSelf), other)< r(globalScopeSelf);"))
		
		// and the result should not contain a null string
		assertThat(translated, not(containsString("null")))
	}
	
	private def printResult(String test, DetailCode dc, String translated) {
		println("<<<" + test)
		println("orig:")
		println(dc.detailCode)
		println("translated:")
		println(translated)
		println(test + ">>>")
	}
}