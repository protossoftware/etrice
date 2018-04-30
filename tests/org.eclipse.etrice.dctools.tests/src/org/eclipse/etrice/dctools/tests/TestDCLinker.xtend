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

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.etrice.core.TestBase
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.MessageData
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.core.room.RoomPackage
import org.eclipse.etrice.core.room.StandardOperation
import org.eclipse.etrice.core.room.VarDecl
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.etrice.dctools.fsm.ast.DCLanguage
import org.eclipse.etrice.dctools.ast.DCLinker
import org.eclipse.etrice.dctools.fsm.ast.DCParser
import org.junit.Before
import org.junit.Test

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*
import org.eclipse.etrice.core.fsm.fSM.FSMPackage
import org.eclipse.etrice.core.room.Port
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.DataClass

class TestDCLinker extends TestBase {
	
	Resource res = null;
	RoomModel model
	val extension RoomHelpers roomHelpers = new RoomHelpers
	
	@Before
	def void SetUp() {
		prepare(DCToolsTestsActivator.getInstance.bundle)
		res = getResource("DetailCodes.room")
		assertNotNull(res)
		assertFalse(res.contents.empty)
		assertTrue(res.contents.head instanceof RoomModel)
		model = res.contents.head as RoomModel
	}

// detail code:
//			double dx = x - other.x;
//			double dy = y - other.y;
//			return Math.sqrt(dx*dx + dy*dy);

// AST:
//DCAstMatchNode
//  DCAstOtherNode 'double' KEYWORD
//  DCAstOtherNode ' ' WHITESPACE
//  DCAstFeatureCallNode
//    DCAstIdentifierNode 'dx'
//    DCAstWhitespaceNode ' '
//  DCAstOtherNode '=' OTHER
//  DCAstOtherNode ' ' WHITESPACE
//  DCAstFeatureCallNode
//    DCAstIdentifierNode 'x' --> Attribute
//    DCAstWhitespaceNode ' '
//  DCAstOtherNode '-' OTHER
//  DCAstOtherNode ' ' WHITESPACE
//  DCAstFeatureCallNode
//    DCAstIdentifierNode 'other' --> VarDecl
//    DCAstPeriodNode
//    DCAstIdentifierNode 'x' --> Attribute
//  DCAstOtherNode ';' STATEMENT_SEP
//  DCAstOtherNode '
//' WHITESPACE
//  DCAstOtherNode 'double' KEYWORD
//  DCAstOtherNode ' ' WHITESPACE
//  DCAstFeatureCallNode
//    DCAstIdentifierNode 'dy'
//    DCAstWhitespaceNode ' '
//  DCAstOtherNode '=' OTHER
//  DCAstOtherNode ' ' WHITESPACE
//  DCAstFeatureCallNode
//    DCAstIdentifierNode 'y' --> Attribute
//    DCAstWhitespaceNode ' '
//  DCAstOtherNode '-' OTHER
//  DCAstOtherNode ' ' WHITESPACE
//  DCAstFeatureCallNode
//    DCAstIdentifierNode 'other' --> VarDecl
//    DCAstPeriodNode
//    DCAstIdentifierNode 'y' --> Attribute
//  DCAstOtherNode ';' STATEMENT_SEP
//  DCAstOtherNode '
//' WHITESPACE
//  DCAstOtherNode 'return' KEYWORD
//  DCAstOtherNode ' ' WHITESPACE
//  DCAstFeatureCallNode
//    DCAstIdentifierNode 'Math'
//    DCAstPeriodNode
//    DCAstOperationCallNode 'sqrt()'
//      DCAstIdentifierNode 'sqrt'
//      DCAstBracketNode ()
//        DCAstMatchNode
//          DCAstFeatureCallNode
//            DCAstIdentifierNode 'dx'
//          DCAstOtherNode '*' OTHER
//          DCAstFeatureCallNode
//            DCAstIdentifierNode 'dx'
//            DCAstWhitespaceNode ' '
//          DCAstOtherNode '+' OTHER
//          DCAstOtherNode ' ' WHITESPACE
//          DCAstFeatureCallNode
//            DCAstIdentifierNode 'dy'
//          DCAstOtherNode '*' OTHER
//          DCAstFeatureCallNode
//            DCAstIdentifierNode 'dy'
//  DCAstOtherNode ';' STATEMENT_SEP
//  DCAstOtherNode '
//
//' WHITESPACE
	@Test
	def void testDataClassOperationWithAttributesAndVarDecl() {
		// we want to test the distance operation of data class Point
		val dc = model.dataClasses.filter[name=="Point"].head
		val op = dc.operations.filter[name=="distance"].head
		val code = op.detailCode.detailCode
		
		// parse
		val parser = new DCParser(DCLanguage.JAVA_LANGUAGE)
		val ast = parser.parse(code)
		
		// link
		val linker = new DCLinker(op.detailCode)
		ast.visit(linker)
		
		ast.print
		
		assertTrue(ast.c(5).c(0).linkedObject instanceof Attribute)
		var att = ast.c(5).c(0).linkedObject as Attribute
		assertThat(att.name, is("x"))
		
		assertTrue(ast.c(8).c(0).linkedObject instanceof VarDecl)
		val vd = ast.c(8).c(0).linkedObject as VarDecl
		assertThat(vd.name, is("other"))
		
		assertTrue(ast.c(8).c(2).linkedObject instanceof Attribute)
		att = ast.c(8).c(2).linkedObject as Attribute
		assertThat(att.name, is("x"))
	}

// detail code:
//			return c.distance(other) < r;

// AST:	
//DCAstMatchNode
//  DCAstOtherNode 'return' KEYWORD
//  DCAstOtherNode ' ' WHITESPACE
//  DCAstFeatureCallNode
//    DCAstIdentifierNode 'c' --> Attribute
//    DCAstPeriodNode
//    DCAstOperationCallNode 'distance()' --> StandardOperation
//      DCAstIdentifierNode 'distance'
//      DCAstBracketNode ()
//        DCAstMatchNode
//          DCAstFeatureCallNode
//            DCAstIdentifierNode 'other' --> VarDecl
//    DCAstWhitespaceNode ' '
//  DCAstOtherNode '<' OTHER
//  DCAstOtherNode ' ' WHITESPACE
//  DCAstFeatureCallNode
//    DCAstIdentifierNode 'r' --> Attribute
//  DCAstOtherNode ';' STATEMENT_SEP
//  DCAstOtherNode '
//
//' WHITESPACE
	@Test
	def void testDataClassOperationWithOperationCall() {
		// we want to test the isInside operation of data class Circle
		val dc = model.dataClasses.filter[name=="Circle"].head
		val op = dc.operations.filter[name=="isInside"].head
		val code = op.detailCode.detailCode
		
		// parse
		val parser = new DCParser(DCLanguage.JAVA_LANGUAGE)
		val ast = parser.parse(code)
		
		// link
		val linker = new DCLinker(op, RoomPackage.Literals.OPERATION__DETAIL_CODE)
		ast.visit(linker)
		
		ast.print
		
		var lo = ast.c(2).c(0).linkedObject
		assertTrue(lo instanceof Attribute)
		var att = lo as Attribute
		assertThat(att.name, is("c"))
		
		lo = ast.c(2).c(2).linkedObject
		assertTrue(lo instanceof StandardOperation)
		var sop = lo as StandardOperation
		assertThat(sop.name, is("distance"))
		
		lo = ast.c(2).c(2).c(1).c(0).c(0).c(0).linkedObject
		assertTrue(lo instanceof VarDecl)
		var vd = lo as VarDecl
		assertThat(vd.name, is("other"))
	}
	
// detail code:
//		transitionData.west().distance(transitionData.c);

// AST:
//DCAstMatchNode
//  DCAstFeatureCallNode
//    DCAstIdentifierNode 'transitionData' --> MessageData
//    DCAstPeriodNode
//    DCAstOperationCallNode 'west()' --> StandardOperation
//      DCAstIdentifierNode 'west'
//      DCAstBracketNode ()
//        DCAstMatchNode
//    DCAstPeriodNode
//    DCAstOperationCallNode 'distance()' --> StandardOperation
//      DCAstIdentifierNode 'distance'
//      DCAstBracketNode ()
//        DCAstMatchNode
//          DCAstFeatureCallNode
//            DCAstIdentifierNode 'transitionData' --> MessageData
//            DCAstPeriodNode
//            DCAstIdentifierNode 'c' --> Attribute
//  DCAstOtherNode ';' STATEMENT_SEP
//  DCAstOtherNode '
//' WHITESPACE
	@Test
	def void testTransitionData() {
		// we want to test the action code of tr0
		val ac = model.actorClasses.filter[name=="AC"].head
		val tr = ac.stateMachine.transitions.filter[name=="tr0"].head
		val code = tr.action.detailCode
		
		// parse
		val parser = new DCParser(DCLanguage.JAVA_LANGUAGE)
		val ast = parser.parse(code)
		
		// link
		val pc = model.protocolClasses.filter(ProtocolClass).filter[name=="PC"].head
		val msg = pc.incomingMessages.filter[name=="circle"].head
		val md = msg.data
		val linker = new DCLinker(tr.action, md)
		ast.visit(linker)
		
		ast.print
		
		var lo = ast.c(0).c(0).linkedObject
		assertTrue(lo instanceof MessageData)
		
		lo = ast.c(0).c(2).linkedObject
		assertTrue(lo instanceof StandardOperation)
		var sop = lo as StandardOperation
		assertThat(sop.name, is("west"))
		
		lo = ast.c(0).c(4).linkedObject
		assertTrue(lo instanceof StandardOperation)
		sop = lo as StandardOperation
		assertThat(sop.name, is("distance"))
		
		lo = ast.c(0).c(4).c(1).c(0).c(0).c(0).linkedObject
		assertTrue(lo instanceof MessageData)
		
		lo = ast.c(0).c(4).c(1).c(0).c(0).c(2).linkedObject
		assertTrue(lo instanceof Attribute)
		var att = lo as Attribute
		assertThat(att.name, is("c"))
	}

// detail code:
//						prt.start();
//						
//						Point pt = new Point(1,2);
//						prt.result(pt);'''

// AST:	
//DCAstMatchNode
//  DCAstFeatureCallNode
//    DCAstIdentifierNode 'prt' --> Port
//    DCAstPeriodNode
//    DCAstOperationCallNode 'start()' --> Message
//      DCAstIdentifierNode 'start'
//      DCAstBracketNode ()
//        DCAstMatchNode
//  DCAstOtherNode ';' STATEMENT_SEP
//  DCAstOtherNode '
//
//' WHITESPACE
//  DCAstFeatureCallNode
//    DCAstIdentifierNode 'Point'
//    DCAstWhitespaceNode ' '
//  DCAstFeatureCallNode
//    DCAstIdentifierNode 'pt'
//    DCAstWhitespaceNode ' '
//  DCAstOtherNode '=' OTHER
//  DCAstOtherNode ' ' WHITESPACE
//  DCAstOtherNode 'new' KEYWORD
//  DCAstOtherNode ' ' WHITESPACE
//  DCAstFeatureCallNode
//    DCAstOperationCallNode 'Point()'
//      DCAstIdentifierNode 'Point'
//      DCAstBracketNode ()
//        DCAstMatchNode
//          DCAstOtherNode '1' NUMBER
//          DCAstOtherNode ',' OTHER
//          DCAstOtherNode '2' NUMBER
//  DCAstOtherNode ';' STATEMENT_SEP
//  DCAstOtherNode '
//' WHITESPACE
//  DCAstFeatureCallNode
//    DCAstIdentifierNode 'prt' --> Port
//    DCAstPeriodNode
//    DCAstOperationCallNode 'result()' --> Message
//      DCAstIdentifierNode 'result'
//      DCAstBracketNode ()
//        DCAstMatchNode
//          DCAstFeatureCallNode
//            DCAstIdentifierNode 'pt'
//  DCAstOtherNode ';' STATEMENT_SEP
//  DCAstOtherNode '
//' WHITESPACE
	@Test
	def void testPortMessage() {
		// we want to test the entry code of state 'first'
		val ac = model.actorClasses.filter[name=="AC"].head
		val st = ac.stateMachine.states.filter[name=="first"].head
		val code = st.entryCode.detailCode
		
		// parse
		val parser = new DCParser(DCLanguage.JAVA_LANGUAGE)
		val ast = parser.parse(code)
		
		// link
		val linker = new DCLinker(st.entryCode)
		ast.visit(linker)
		
		ast.print
		
		var lo = ast.c(0).c(0).linkedObject
		assertTrue(lo instanceof Port)
		var p = lo as Port
		assertThat(p.name, is("prt"))
		
		lo = ast.c(0).c(2).linkedObject
		assertTrue(lo instanceof Message)
		var m = lo as Message
		assertThat(m.name, is("start"))
		
		lo = ast.c(12).c(0).linkedObject
		assertTrue(lo instanceof Port)
		p = lo as Port
		assertThat(p.name, is("prt"))
		
		lo = ast.c(12).c(2).linkedObject
		assertTrue(lo instanceof Message)
		m = lo as Message
		assertThat(m.name, is("result"))
	}
	
// detail code:
//						double d = c.diameter();
//						d = p[0].distance(p[1]);
//						d = distance(p[0], p[1]);
//						d = c.c.x;

// AST:
//DCAstMatchNode
//  DCAstOtherNode 'double' KEYWORD
//  DCAstOtherNode ' ' WHITESPACE
//  DCAstFeatureCallNode
//    DCAstIdentifierNode 'd'
//    DCAstWhitespaceNode ' '
//  DCAstOtherNode '=' OTHER
//  DCAstOtherNode ' ' WHITESPACE
//  DCAstFeatureCallNode
//    DCAstIdentifierNode 'c' --> Attribute
//    DCAstPeriodNode
//    DCAstOperationCallNode 'diameter()' --> StandardOperation
//      DCAstIdentifierNode 'diameter'
//      DCAstBracketNode ()
//        DCAstMatchNode
//  DCAstOtherNode ';' STATEMENT_SEP
//  DCAstOtherNode '
//' WHITESPACE
//  DCAstFeatureCallNode
//    DCAstIdentifierNode 'd'
//    DCAstWhitespaceNode ' '
//  DCAstOtherNode '=' OTHER
//  DCAstOtherNode ' ' WHITESPACE
//  DCAstFeatureCallNode
//    DCAstArrayAccessNode 'p[]' --> Attribute
//      DCAstIdentifierNode 'p'
//      DCAstBracketNode []
//        DCAstMatchNode
//          DCAstOtherNode '0' NUMBER
//    DCAstPeriodNode
//    DCAstOperationCallNode 'distance()' --> StandardOperation
//      DCAstIdentifierNode 'distance'
//      DCAstBracketNode ()
//        DCAstMatchNode
//          DCAstFeatureCallNode
//            DCAstArrayAccessNode 'p[]' --> Attribute
//              DCAstIdentifierNode 'p'
//              DCAstBracketNode []
//                DCAstMatchNode
//                  DCAstOtherNode '1' NUMBER
//  DCAstOtherNode ';' STATEMENT_SEP
//  DCAstOtherNode '
//' WHITESPACE
//  DCAstFeatureCallNode
//    DCAstIdentifierNode 'd'
//    DCAstWhitespaceNode ' '
//  DCAstOtherNode '=' OTHER
//  DCAstOtherNode ' ' WHITESPACE
//  DCAstFeatureCallNode
//    DCAstOperationCallNode 'distance()' --> StandardOperation
//      DCAstIdentifierNode 'distance'
//      DCAstBracketNode ()
//        DCAstMatchNode
//          DCAstFeatureCallNode
//            DCAstArrayAccessNode 'p[]' --> Attribute
//              DCAstIdentifierNode 'p'
//              DCAstBracketNode []
//                DCAstMatchNode
//                  DCAstOtherNode '0' NUMBER
//          DCAstOtherNode ',' OTHER
//          DCAstOtherNode ' ' WHITESPACE
//          DCAstFeatureCallNode
//            DCAstArrayAccessNode 'p[]' --> Attribute
//              DCAstIdentifierNode 'p'
//              DCAstBracketNode []
//                DCAstMatchNode
//                  DCAstOtherNode '1' NUMBER
//  DCAstOtherNode ';' STATEMENT_SEP
//  DCAstOtherNode '
//' WHITESPACE
//  DCAstFeatureCallNode
//    DCAstIdentifierNode 'd'
//    DCAstWhitespaceNode ' '
//  DCAstOtherNode '=' OTHER
//  DCAstOtherNode ' ' WHITESPACE
//  DCAstFeatureCallNode
//    DCAstIdentifierNode 'c' --> Attribute
//    DCAstPeriodNode
//    DCAstIdentifierNode 'c' --> Attribute
//    DCAstPeriodNode
//    DCAstIdentifierNode 'x' --> Attribute
//    DCAstWhitespaceNode '
//
//'
	@Test
	def void testActorClassAttributes() {
		// we want to test the entry code of state 'first'
		val ac = model.actorClasses.filter[name=="AC"].head
		val st = ac.stateMachine.states.filter[name=="second"].head
		val code = st.entryCode.detailCode
		
		// parse
		val parser = new DCParser(DCLanguage.JAVA_LANGUAGE)
		val ast = parser.parse(code)
		
		// link
		val linker = new DCLinker(st, FSMPackage.Literals.STATE__ENTRY_CODE)
		ast.visit(linker)
		
		ast.print
		
		var lo = ast.c(5).c(0).linkedObject
		assertTrue(lo instanceof Attribute)
		var a = lo as Attribute
		assertThat(a.name, is("c"))
		
		lo = ast.c(5).c(2).linkedObject
		assertTrue(lo instanceof StandardOperation)
		var op = lo as StandardOperation
		assertThat(op.name, is("diameter"))
		var dc = model.dataClasses.filter[name=="Circle"].head
		val circleOp = dc.operations.filter[name=="diameter"].head
		assertThat(op, is(circleOp))
		
		lo = ast.c(11).c(0).linkedObject
		assertTrue(lo instanceof Attribute)
		a = lo as Attribute
		assertThat(a.name, is("p"))
		
		lo = ast.c(11).c(2).linkedObject
		assertTrue(lo instanceof StandardOperation)
		op = lo as StandardOperation
		assertThat(op.name, is("distance"))
		dc = model.dataClasses.filter[name=="Point"].head
		val pointOp = dc.operations.filter[name=="distance"].head
		assertThat(op, is(pointOp))
		
		lo = ast.c(17).c(0).linkedObject
		assertTrue(lo instanceof StandardOperation)
		op = lo as StandardOperation
		assertThat(op.name, is("distance"))
		val actorOp = ac.operations.filter[name=="distance"].head
		assertThat(op, is(actorOp))
		
		lo = ast.c(23).c(0).linkedObject
		assertTrue(lo instanceof Attribute)
		a = lo as Attribute
		assertThat(a.name, is("c"))
		assertTrue(a.eContainer instanceof ActorClass)
		
		lo = ast.c(23).c(2).linkedObject
		assertTrue(lo instanceof Attribute)
		a = lo as Attribute
		assertThat(a.name, is("c"))
		assertTrue(a.eContainer instanceof DataClass)
		assertThat((a.eContainer as DataClass).name, is("Circle"))
		
		lo = ast.c(23).c(4).linkedObject
		assertTrue(lo instanceof Attribute)
		a = lo as Attribute
		assertThat(a.name, is("x"))
		assertTrue(a.eContainer instanceof DataClass)
		assertThat((a.eContainer as DataClass).name, is("Point"))
	}

// detail code:
//						replPrt[0].start();
//						replPrt.start();
//						prt[0].start();

// AST:	
//DCAstMatchNode
//  DCAstFeatureCallNode
//    DCAstArrayAccessNode 'replPrt[]' --> Port
//      DCAstIdentifierNode 'replPrt'
//      DCAstBracketNode []
//        DCAstMatchNode
//          DCAstOtherNode '0' NUMBER
//    DCAstPeriodNode
//    DCAstOperationCallNode 'start()' --> Message
//      DCAstIdentifierNode 'start'
//      DCAstBracketNode ()
//        DCAstMatchNode
//  DCAstOtherNode ';' STATEMENT_SEP
//  DCAstOtherNode '
//' WHITESPACE
//  DCAstFeatureCallNode
//    DCAstIdentifierNode 'replPrt' --> Port
//    DCAstPeriodNode
//    DCAstOperationCallNode 'start()' --> Message
//      DCAstIdentifierNode 'start'
//      DCAstBracketNode ()
//        DCAstMatchNode
//  DCAstOtherNode ';' STATEMENT_SEP
//  DCAstOtherNode '
//' WHITESPACE
//  DCAstFeatureCallNode
//    DCAstArrayAccessNode 'prt[]'
//      DCAstIdentifierNode 'prt'
//      DCAstBracketNode []
//        DCAstMatchNode
//          DCAstOtherNode '0' NUMBER
//    DCAstPeriodNode
//    DCAstOperationCallNode 'start()'
//      DCAstIdentifierNode 'start'
//      DCAstBracketNode ()
//        DCAstMatchNode
//  DCAstOtherNode ';' STATEMENT_SEP
//  DCAstOtherNode '
//
//' WHITESPACE
	@Test
	def void testReplPortMessage() {
		// we want to test the exit code of state 'second'
		val ac = model.actorClasses.filter[name=="AC"].head
		val st = ac.stateMachine.states.filter[name=="second"].head
		val code = st.exitCode.detailCode
		
		// parse
		val parser = new DCParser(DCLanguage.JAVA_LANGUAGE)
		val ast = parser.parse(code)
		
		// link
		val linker = new DCLinker(st, FSMPackage.Literals.STATE__ENTRY_CODE)
		ast.visit(linker)
		
		ast.print
		
		// array access to replicated port
		var lo = ast.c(0).c(0).linkedObject
		assertTrue(lo instanceof Port)
		var p = lo as Port
		assertThat(p.name, is("replPrt"))
		
		lo = ast.c(0).c(2).linkedObject
		assertTrue(lo instanceof Message)
		var m = lo as Message
		assertThat(m.name, is("start"))
		
		// broadcast through replicated port (scalar access)
		lo = ast.c(3).c(0).linkedObject
		assertTrue(lo instanceof Port)
		p = lo as Port
		assertThat(p.name, is("replPrt"))
		
		lo = ast.c(3).c(2).linkedObject
		assertTrue(lo instanceof Message)
		m = lo as Message
		assertThat(m.name, is("start"))
		
		// a non replicated port with array access shouldn't be linked
		lo = ast.c(6).c(0).linkedObject
		assertThat(lo, is(nullValue))
	}
	
	@Test
	def void testDataPortGetterAndAttributeSetter() {
		// we want to test the action code of tr1
		val ac = model.actorClasses.filter[name=="AC"].head
		val tr = ac.stateMachine.transitions.filter[name=="tr1"].head
		val code = tr.action.detailCode
		
		// parse
		val parser = new DCParser(DCLanguage.JAVA_LANGUAGE)
		val ast = parser.parse(code)
		
		// link
		val pc = model.protocolClasses.filter(ProtocolClass).filter[name=="PCData"].head
		val msg = pc.incomingMessages.filter[name=="point"].head
		val md = msg.data
		val linker = new DCLinker(tr.action, md)
		ast.visit(linker)
		
		ast.print
	}
}