/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.ui.behavior.DiagramAccess;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * unit test of a hierarchical state machine (defined by HierarchicalStateMachine.room)
 * 
 * @author Henrik Rentz-Reichert initial contribution and API
 *
 */
public class TestInheritedStateMachine extends AbstractStateMachineTest {

	@Before
	public void setUp() {
		loadModelFile();
	}
	
	@After
	public void tearDown() {
//		removeDiagramsDirectory();
	}
	
	@Override
	protected String getModelFileName() {
		return "InheritedStateMachine.room";
	}
	
	@Test
	public void checkModel() {
		assertEquals("models read", 1, getModels().size());
		assertEquals("actor classes in our model", 5, getActorClasses().count());
	}
	
	@Test
	public void testBaseClass() {
		ActorClass ac = getActorClass("Base");
		assertTrue("actor class Base present in model", ac!=null);
		Diagram diagram = new DiagramAccess().getDiagram(ac);
		
		// have to use the actor class from the diagram since this is another instance
		ac = (ActorClass) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diagram);
		
		testSGItems(ac.getStateMachine(), diagram);
		
		// top and one sub state graph
		assertEquals("diagram children", 2, diagram.getChildren().size());

		for (Shape shape : diagram.getChildren()) {
			assertTrue("top level shape is container shape", shape instanceof ContainerShape);
			
			EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(shape);
			assertTrue("top level business object is StateGraph", bo instanceof StateGraph);
		}
	}
	
	@Test
	public void testDerivedClass() {
		ActorClass ac = getActorClass("Derived");
		assertTrue("actor class Derived present in model", ac!=null);
		Diagram diagram = new DiagramAccess().getDiagram(ac);
		
		// have to use the actor class from the diagram since this is another instance
		ac = (ActorClass) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diagram);
		assertTrue("is derived", ac.getActorBase()!=null);
		assertTrue("extends Base", ac.getActorBase().getName().equals("Base"));
		
		testSGItems(ac.getStateMachine(), diagram);
		
		// top and two sub state graph
		assertEquals("diagram children", 3, diagram.getChildren().size());

		for (Shape shape : diagram.getChildren()) {
			assertTrue("top level shape is container shape", shape instanceof ContainerShape);
			
			EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(shape);
			assertTrue("top level business object is StateGraph", bo instanceof StateGraph);
		}
	}
	
	@Test
	public void testDoubleDerivedClass() {
		ActorClass ac = getActorClass("DoubleDerived");
		assertTrue("actor class DoubleDerived present in model", ac!=null);
		Diagram diagram = new DiagramAccess().getDiagram(ac);
		
		// have to use the actor class from the diagram since this is another instance
		ac = (ActorClass) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diagram);
		assertTrue("is derived", ac.getActorBase()!=null);
		assertTrue("extends Base", ac.getActorBase().getName().equals("Derived"));
		
		testSGItems(ac.getStateMachine(), diagram);
		
		// top and four sub state graph
		assertEquals("diagram children", 5, diagram.getChildren().size());

		for (Shape shape : diagram.getChildren()) {
			assertTrue("top level shape is container shape", shape instanceof ContainerShape);
			
			EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(shape);
			assertTrue("top level business object is StateGraph", bo instanceof StateGraph);
		}
	}
	
	@Test
	public void testBase2Class() {
		ActorClass ac = getActorClass("Base2");
		assertTrue("actor class Base2 present in model", ac!=null);
		Diagram diagram = new DiagramAccess().getDiagram(ac);
		
		// have to use the actor class from the diagram since this is another instance
		ac = (ActorClass) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diagram);
		
		testSGItems(ac.getStateMachine(), diagram);
		
		// top and one sub state graph
		assertEquals("diagram children", 2, diagram.getChildren().size());

		for (Shape shape : diagram.getChildren()) {
			assertTrue("top level shape is container shape", shape instanceof ContainerShape);
			
			EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(shape);
			assertTrue("top level business object is StateGraph", bo instanceof StateGraph);
		}
	}
	
	@Test
	public void testDerived2Class() {
		ActorClass ac = getActorClass("Derived2");
		assertTrue("actor class Derived2 present in model", ac!=null);
		Diagram diagram = new DiagramAccess().getDiagram(ac);
		
		// have to use the actor class from the diagram since this is another instance
		ac = (ActorClass) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diagram);
		assertTrue("is derived", ac.getActorBase()!=null);
		assertTrue("extends Base2", ac.getActorBase().getName().equals("Base2"));
		
		testSGItems(ac.getStateMachine(), diagram);
		
		// top and one sub state graph
		assertEquals("diagram children", 2, diagram.getChildren().size());

		for (Shape shape : diagram.getChildren()) {
			assertTrue("top level shape is container shape", shape instanceof ContainerShape);
			
			EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(shape);
			assertTrue("top level business object is StateGraph", bo instanceof StateGraph);
		}
	}

	public void testSGItems(StateGraph sg, Diagram diagram) {
		
		testStateGraph(diagram, sg);
		
		for (State s : sg.getStates()) {
			if (s.getSubgraph()!=null)
				testSGItems(s.getSubgraph(), diagram);
		}
	}
}
