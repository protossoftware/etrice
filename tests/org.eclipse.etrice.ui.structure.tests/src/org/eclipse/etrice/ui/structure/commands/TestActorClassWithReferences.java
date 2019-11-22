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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URL;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.tests.base.TestBase;
import org.eclipse.etrice.ui.structure.DiagramAccess;
import org.eclipse.etrice.ui.structure.StructureTestActivator;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestActorClassWithReferences extends TestBase {

	private ActorClass ac = null;

	@Before
	public void setUp() {
		loadModelFile();

		assertEquals("models read", 1, getModels().size());
		assertEquals("actor classes in our model", 2, getActorClasses().count());

		ac = getActorClass("MyActorClass");
		assertNotNull("ActorClass expected", ac);
	}
	
	@After
	public void tearDown() {
		removeDiagramsDirectory();
	}
	
	@Override
	protected String getModelFileName() {
		return "ActorClassWithReferences.room";
	}
	
	@Test
	public void checkReferences() {
		Diagram diagram = new DiagramAccess().getDiagram(ac);
		ContainerShape shape = (ContainerShape) diagram.getChildren().get(0);
		assertEquals("actor class child shapes", 5, shape.getChildren().size());

		int nRefs = 0;
		for (Shape childShape : shape.getChildren()) {
			EObject[] bos = Graphiti.getLinkService()
					.getAllBusinessObjectsForLinkedPictogramElement(childShape);
			assertEquals("business objects", 1, bos.length);
			if (!(bos[0] instanceof Port)) {
				assertTrue("bo is actor ref", bos[0] instanceof ActorRef);
				nRefs++;
				
				// ports of actor refs
				assertEquals("grand child shapes", 3, ((ContainerShape)childShape).getChildren().size());
				for (Shape grandChildShape : ((ContainerShape)childShape).getChildren()) {
					// skip the actor ref label
					if (grandChildShape.getGraphicsAlgorithm() instanceof Text)
						continue;
					
					bos = Graphiti.getLinkService()
						.getAllBusinessObjectsForLinkedPictogramElement(grandChildShape);
					assertEquals("business objects", 1, bos.length);
					assertTrue("bo is port", bos[0] instanceof Port);
				}
			}
		}
		assertEquals("number of actor references", 2, nRefs);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.tests.base.TestBase#getModelsDirectoy()
	 */
	@Override
	protected URL getModelsDirectoy() {
		return StructureTestActivator.getInstance().getBundle().getEntry("models");
	}

}
