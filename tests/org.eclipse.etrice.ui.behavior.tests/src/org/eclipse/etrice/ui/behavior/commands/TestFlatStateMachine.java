/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.ui.behavior.DiagramAccess;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * unit test of a flat state machine (defined by FlatStateMachine.room)
 * 
 * @author Henrik Rentz-Reichert initial contribution and API
 *
 */
public class TestFlatStateMachine extends AbstractStateMachineTest {

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
		return "FlatStateMachine.room";
	}
	
	@Test
	public void checkModel() {
		assertEquals("models read", 1, getModels().size());
		assertEquals("actor classes in our model", 1, getModels().get(0).getActorClasses().size());
	}
	
	@Test
	public void testActorClass() {
		ActorClass ac = getModels().get(0).getActorClasses().get(0);
		Diagram diagram = new DiagramAccess().getDiagram(ac);
		
		assertEquals("diagram children", 1, diagram.getChildren().size());

		Shape shape = diagram.getChildren().get(0);
		assertTrue("top level shape is container shape", shape instanceof ContainerShape);

		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(shape);
		assertTrue("top level business object is StateGraph", bo instanceof StateGraph);
	}

	@Test
	public void testSGItems() {
		ActorClass ac = getModels().get(0).getActorClasses().get(0);
		Diagram diagram = new DiagramAccess().getDiagram(ac);
		
		Shape shape = diagram.getChildren().get(0);
		StateGraph sg = (StateGraph) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(shape);
		testStateGraph(diagram, sg);
	}
}
