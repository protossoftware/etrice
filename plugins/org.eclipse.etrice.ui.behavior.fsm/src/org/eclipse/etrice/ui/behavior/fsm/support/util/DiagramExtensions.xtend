/*******************************************************************************
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.fsm.support.util

import org.eclipse.graphiti.mm.pictograms.PictogramElement
import org.eclipse.graphiti.services.Graphiti
import org.eclipse.graphiti.features.context.IPictogramElementContext
import org.eclipse.emf.ecore.EObject

class DiagramExtensions {
	
	def static <T extends PictogramElement> getCastedPe(IPictogramElementContext ctx){
		ctx.pictogramElement as T
	}
	
	def static <T extends EObject> getCastedBo(PictogramElement pe) {
		Graphiti.linkService.getBusinessObjectForLinkedPictogramElement(pe) as T
	}
}