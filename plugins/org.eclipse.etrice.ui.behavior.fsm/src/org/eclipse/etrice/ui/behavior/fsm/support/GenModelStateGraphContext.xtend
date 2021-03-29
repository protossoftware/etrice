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

package org.eclipse.etrice.ui.behavior.fsm.support

import org.eclipse.etrice.core.fsm.fSM.ChoicePoint
import org.eclipse.etrice.core.fsm.fSM.InitialTransition
import org.eclipse.etrice.core.fsm.fSM.State
import org.eclipse.etrice.core.fsm.fSM.TrPoint
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph
import org.eclipse.etrice.ui.behavior.fsm.editor.AbstractFSMDiagramTypeProvider
import org.eclipse.etrice.ui.behavior.fsm.provider.BaseDiagramProvider
import org.eclipse.etrice.ui.behavior.fsm.provider.GenModelProvider

/**
 *  StateGraphContext based on newfsmgen.
 */
class GenModelStateGraphContext implements IStateGraphContext {

	val GenModelProvider genModel
	val BaseDiagramPositionProvider baseDiagram
	val Graph graph

	new(AbstractFSMDiagramTypeProvider diagramTypeProvider){
		this.genModel = diagramTypeProvider.genModelProvider
		this.baseDiagram = new BaseDiagramPositionProvider(new BaseDiagramProvider(diagramTypeProvider))
		this.graph = genModel.model.graph
	}
	
	new(Graph graph, GenModelStateGraphContext other){
		this.genModel = other.genModel
		this.baseDiagram = other.baseDiagram
		this.graph = graph
	}
	
	//
	// IStateGraphContext
	//
	
	override getChPoints() {
		graph.nodes.map[it.stateGraphNode].filter(ChoicePoint).toList
	}
	
	override getChildren() {
		graph.nodes.filter[it.subgraph !== null].map[new GenModelStateGraphContext(it.subgraph, this) as IStateGraphContext].toList
	}
	
	override getInitialPoint() {
		// return a Graph as initial point ?!?
		if(!graph.links.map[transition].filter(InitialTransition).empty) graph.stateGraph
	}
	
	override getParentState() {
		graph.node.stateGraphNode as State
	}
	
	override getPositionProvider() {
		return baseDiagram
	}
	
	override getStateGraph() {
		graph.stateGraph
	}
	
	override getStates() {
		graph.nodes.map[it.stateGraphNode].filter(State).toList
	}
	
	override getTrPoints() {
		graph.nodes.map[it.stateGraphNode].filter(TrPoint).toList
	}
	
	override getTransitions() {
		graph.links.map[transition]
	}
	
}