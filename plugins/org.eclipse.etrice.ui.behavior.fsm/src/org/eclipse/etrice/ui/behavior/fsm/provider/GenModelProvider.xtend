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
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.fsm.provider

import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.fsm.fSM.ModelComponent
import org.eclipse.etrice.core.genmodel.fsm.BasicFsmGenBuilder
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node
import org.eclipse.etrice.ui.behavior.fsm.editor.AbstractFSMDiagramTypeProvider
import org.eclipse.graphiti.dt.IDiagramTypeProvider
import org.eclipse.graphiti.services.Graphiti
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.FSMGenElement

class GenModelProvider {

	val BasicFsmGenBuilder builder
	val IDiagramTypeProvider fsmDiagramProvider
	var Map<EObject, FSMGenElement> graphMap = newHashMap

	var GraphContainer modelInstance = null

	new(AbstractFSMDiagramTypeProvider fsmDiagramProvider) {
		this.fsmDiagramProvider = fsmDiagramProvider
		builder = new BasicFsmGenBuilder(fsmDiagramProvider.injector)
	}

	def updateModel() {
		Graphiti.linkService.getBusinessObjectForLinkedPictogramElement(fsmDiagramProvider.diagram) => [
			modelInstance = if(it instanceof ModelComponent) builder.createTransformedModel(it) else null
		]
		if (modelInstance !== null) {
			graphMap.clear
			modelInstance.eAllContents.forEach [
				switch (it) {
					Graph: graphMap.put(stateGraph, it)
					Node: graphMap.put(stateGraphNode, it)
					Link: graphMap.put(transition, it)
				}
			]
		}
	}

	def getModel() {
		if (modelInstance === null) {
			updateModel()
		}

		return modelInstance;
	}

	def <T extends FSMGenElement> getCasted(EObject roomObj) {
		return graphMap.get(roomObj) as T
	}
}
