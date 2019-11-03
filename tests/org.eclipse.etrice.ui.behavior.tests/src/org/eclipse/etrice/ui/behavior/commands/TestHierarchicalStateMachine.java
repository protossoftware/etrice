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
public class TestHierarchicalStateMachine extends AbstractStateMachineTest {

	@Before
	public void setUp() {
		loadModelFile();
	}
	
	@After
	public void tearDown() {
		removeDiagramsDirectory();
	}
	
	@Override
	protected String getModelFileName() {
		return "HierarchicalStateMachine.room";
	}
	
	@Test
	public void checkModel() {
		assertEquals("models read", 1, getModels().size());
		assertEquals("actor classes in our model", 1, getActorClasses().count());
	}
	
	@Test
	public void testActorClass() {
		ActorClass ac = getActorClasses().findFirst().get();
		Diagram diagram = new DiagramAccess().getDiagram(ac);
		
		// top and one sub state graph
		assertEquals("diagram children", 2, diagram.getChildren().size());

		for (Shape shape : diagram.getChildren()) {
			assertTrue("top level shape is container shape", shape instanceof ContainerShape);
			
			EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(shape);
			assertTrue("top level business object is StateGraph", bo instanceof StateGraph);
		}
	}

	@Test
	public void testSGItems() {
		ActorClass ac = getActorClasses().findFirst().get();
		Diagram diagram = new DiagramAccess().getDiagram(ac);
		
		ac = (ActorClass) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diagram);
		StateGraph sg = ac.getStateMachine();
		testStateGraph(diagram, sg);
		
		for (State s : sg.getStates()) {
			if (s.getSubgraph()!=null)
				testStateGraph(diagram, s.getSubgraph());
		}
	}
}
