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

import org.eclipse.etrice.core.fsm.fSM.NonInitialTransition
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node
import org.eclipse.etrice.core.fsm.fSM.TrPoint
import org.eclipse.etrice.core.fsm.fSM.State

class FsmGenChecker {
	
	static def check(GraphContainer gc, ILogger logger) {
		// graphs
		gc.eAllContents.filter(typeof(Graph)).forEach[checkGraph(it, logger)]
		
		// nodes
		gc.eAllContents.filter(typeof(Node)).forEach[checkNode(it, logger)]
		
		// links
		gc.eAllContents.filter(typeof(Link)).forEach[checkLink(it, logger)]
	}
	
	def static void checkLink(Link it, ILogger logger) {
		if (transition==null) {
			logger.logError("graph doesn't point to ROOM transition")
		}
		else if (transition.eIsProxy) {
			logger.logError("unresolved ROOM transition")
		}
		else if (transition.eContainer==null) {
			logger.logError("dangling ROOM transition")
		}
		else if (target==null) {
			logger.logError("link without target")
		}
		else if (source==null && transition instanceof NonInitialTransition) {
			logger.logError("non-initial link without source")
		}

		if (source!=null) {
			checkLinkEnd(it, it.source, logger)
		}
		checkLinkEnd(it, it.target, logger)
	}
	
	def static checkLinkEnd(Link link, Node node, ILogger logger) {
		if (node.eContainer == link.eContainer) {
			return;
		}
		else {
			if (!(node.stateGraphNode instanceof TrPoint)) {
				logger.logError("subgraph item is not transition point")
			}
			else if (!(node.eContainer.eContainer instanceof Node)) {
				logger.logError("subgraph item is in unexpected container")
			}
			else if (!((node.eContainer.eContainer as Node).stateGraphNode instanceof State)) {
				logger.logError("subgraph item is in unexpected container")
			}
			else if (node.eContainer.eContainer.eContainer != link.eContainer) {
				logger.logError("subgraph item is in unexpected container")
			}
		}
	}
	
	def static void checkNode(Node it, ILogger logger) {
		if (stateGraphNode==null) {
			logger.logError("graph doesn't point to ROOM state graph node")
		}
		else if (stateGraphNode.eIsProxy) {
			logger.logError("unresolved ROOM graph node")
		}
		else if (stateGraphNode.eContainer==null) {
			logger.logError("dangling ROOM graph node")
		}
		else if (stateGraphNode.getName()==null) {
			logger.logError("ROOM graph node without name")
		}
		
		// incoming transitions
		for (l : incoming) {
			if (l.target.stateGraphNode != it.stateGraphNode) {
				logger.logError("ROOM target node of an incoming transition must be myself")
			}
		}
		
		// outgoing transitions
		for (l : outgoing) {
			if (l.source.stateGraphNode != it.stateGraphNode) {
				logger.logError("ROOM source node of an outgoing transition must be myself")
			}
		}
	}
	
	def static void checkGraph(Graph it, ILogger logger) {
		if (stateGraph==null) {
			logger.logError("graph doesn't point to ROOM state graph")
		}
		else if (stateGraph.eIsProxy) {
			logger.logError("unresolved ROOM graph")
		}
		else if (stateGraph.eContainer==null) {
			logger.logError("dangling ROOM graph")
		}
	}
}