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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.ui.structure.DiagramAccess;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.junit.Test;

public class TestActorClassWithPorts extends TestActorClass {

	@Test
	public void checkPorts() {
		ActorClass ac = getModels().get(0).getActorClasses().get(0);
		Diagram diagram = new DiagramAccess().getDiagram(ac);
		ContainerShape shape = (ContainerShape) diagram.getChildren().get(0);
		assertEquals("actor class child shapes", 3, shape.getChildren().size());

		for (Shape childShape : shape.getChildren()) {
			EObject[] bos = Graphiti.getLinkService()
					.getAllBusinessObjectsForLinkedPictogramElement(childShape);
			assertEquals("business objects", 1, bos.length);
			assertTrue("bo is port", bos[0] instanceof Port);
		}
	}
	
	@Override
	protected String getModelFileName() {
		return "ActorClassWithPorts.room";
	}
}
