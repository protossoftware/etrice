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

package org.eclipse.etrice.ui.structure.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URL;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.tests.base.TestBase;
import org.eclipse.etrice.ui.structure.DiagramAccess;
import org.eclipse.etrice.ui.structure.StructureTestActivator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestActorClass extends TestBase {

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
		return "ActorClass.room";
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
		 
		 assertEquals("diagram children", 1, diagram.getChildren().size());
		 
		 Shape shape = diagram.getChildren().get(0);
		 assertTrue("top level shape is container shape", shape instanceof ContainerShape);
		 
		 EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(shape);
		 assertTrue("top level business object is ActorClass", bo instanceof ActorClass);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.tests.base.TestBase#getModelsDirectoy()
	 */
	@Override
	protected URL getModelsDirectoy() {
		return StructureTestActivator.getInstance().getBundle().getEntry("models");
	}
}
