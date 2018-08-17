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
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.fsm

import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph
import org.eclipse.etrice.core.fsm.fSM.State
import org.eclipse.etrice.core.fsm.fSM.ChoicePoint
import org.eclipse.etrice.core.fsm.fSM.TrPoint
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link

class FsmGenExtensions {
	
	public static def getName(Node nd) {
		nd.stateGraphNode.name
	}
	
	public static def getStateNodes(Graph g) {
		g.nodes.filter[stateGraphNode instanceof State]
	}
	
	public static def getAllNodes(Graph g) {
		g.eAllContents.filter(typeof(Node))
	}
	
	public static def getAllStateNodes(Graph g) {
		g.allNodes.filter[stateGraphNode instanceof State]
	}
	
	public static def getChoicePointNodes(Graph g) {
		g.nodes.filter[stateGraphNode instanceof ChoicePoint]
	}
	
	public static def getAllChoicePointNodes(Graph g) {
		g.allNodes.filter[stateGraphNode instanceof ChoicePoint]
	}
	
	public static def getTrPointNodes(Graph g) {
		g.nodes.filter[stateGraphNode instanceof TrPoint]
	}
	
	public static def getAllTrPointNodes(Graph g) {
		g.allNodes.filter[stateGraphNode instanceof TrPoint]
	}
	
	public static def getStates(Graph g) {
		g.stateNodes.map[stateGraphNode].filter(typeof(State))
	}
	
	public static def getChoicePoints(Graph g) {
		g.choicePointNodes.map[stateGraphNode].filter(typeof(ChoicePoint))
	}
	
	public static def getTransitionPoints(Graph g) {
		g.trPointNodes.map[stateGraphNode].filter(typeof(TrPoint))
	}
	
	public static def getAllLinks(Graph g) {
		g.eAllContents.filter(typeof(Link))
	}
}