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

import java.util.List
import org.eclipse.etrice.core.fsm.fSM.InitialTransition
import org.eclipse.etrice.core.fsm.fSM.ModelComponent
import org.eclipse.etrice.core.fsm.fSM.RefinedState
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition
import org.eclipse.etrice.core.fsm.fSM.State
import org.eclipse.etrice.core.fsm.fSM.StateGraph
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode
import org.eclipse.etrice.core.fsm.fSM.TrPoint
import org.eclipse.etrice.core.fsm.fSM.Transition
import org.eclipse.etrice.ui.behavior.fsm.provider.BaseDiagramProvider
import org.eclipse.graphiti.mm.algorithms.Text
import org.eclipse.graphiti.mm.pictograms.Connection
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection
import org.eclipse.graphiti.mm.pictograms.PictogramElement
import org.eclipse.graphiti.services.Graphiti
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

/**
 *  IPositionProvider based on {@linkplain BaseDiagramProvider}
 * 	Logic copied from DefaultPositionProvider
 */
@FinalFieldsConstructor
class BaseDiagramPositionProvider implements IPositionProvider {
	
	val BaseDiagramProvider baseDiagram
	
	// TODO: positions should not rely on graphics internals
	def getMargin(StateGraphNode node) {
		switch node {
			State: StateSupport.MARGIN
			TrPoint: TrPointSupport.MARGIN
			default: 0
		}
	}
	
	// TODO: positions should not rely on graphics internals
	def getMargin(StateGraph graph){
		return 0
	}
	
	def private toPosAndSize(PictogramElement pe, int margin){
		val borderGa = (pe.eContainer as PictogramElement).graphicsAlgorithm.graphicsAlgorithmChildren.head
		val ga = pe.graphicsAlgorithm
		
		val x = (ga.getX() / borderGa.width as double) * sx + margin
		val y = (ga.getY() / borderGa.height as double) * sy + margin
		val width = ((ga.getWidth() - 2 * margin) / borderGa.width as double) * sx
		val height = ((ga.getHeight() - 2 * margin) / borderGa.height as double) * sy
		
		new PosAndSize(x as int, y as int, width as int, height as int)
	}
	
	override getGraphPosAndSize(StateGraph sg) {
		// graph is child of border shape, see initial point
		val pe = baseDiagram.getPictograms(sg).findFirst[parentBo instanceof ModelComponent]
		if (pe !== null){
			val visibleGa = pe.graphicsAlgorithm.graphicsAlgorithmChildren.head
			new PosAndSize(pe.graphicsAlgorithm.x, pe.graphicsAlgorithm.y, visibleGa.width, visibleGa.height)
		}
	}
	
	override getPoints(Transition trans) {
		val pe = {
			if (trans instanceof RefinedTransition)
				baseDiagram.getPictograms(trans.target).head
			else
				baseDiagram.getPictograms(trans).head
		}
		newArrayList => [ pointList | 
			if (pe instanceof Connection){
				val graphPosAndSize = getGraphPosAndSize(trans.eContainer as StateGraph)
				val text = pe.connectionDecorators.map[graphicsAlgorithm].filter(Text).head
				if (text !== null){		
					pointList += new Pos(
						(((text.x / graphPosAndSize.width as double) * sx) as int), 
						(((text.y / graphPosAndSize.height as double) * sy) as int)
					)
					if (pe instanceof FreeFormConnection){
						pointList += pe.bendpoints.map[pt | new Pos(
							(((pt.x / graphPosAndSize.width as double) * sx + x) as int) - StateGraphSupport.MARGIN, 
							(((pt.y / graphPosAndSize.height as double) * sy + y) as int) - StateGraphSupport.MARGIN
						)]
					}
				}
			}
		]
	}
	
	override getPosition(StateGraphNode node) {
		val getBasePos = [baseDiagram.getPictograms(it).findFirst[parentBo instanceof StateGraph]?.toPosAndSize(node.margin)]
		
		return if(node instanceof RefinedState){
			// 1. RefinedState is base diagram
			// 2. RefinedState target is in base diagram
			getBasePos.apply(node)?:getBasePos.apply(node.target)
		} else { 
			getBasePos.apply(node)
		}
	}
	
	override getInitialPoint(StateGraph stateGraph) {
		val initTransPe = baseDiagram.getPictograms(stateGraph.transitions.filter(InitialTransition).head).head
		if(initTransPe instanceof Connection){
			val sourceAnchorBo = Graphiti.linkService.getBusinessObjectForLinkedPictogramElement(initTransPe.start)
			if(sourceAnchorBo instanceof StateGraph)
				return sourceAnchorBo
		}
	}
	
	// TODO: better naming, this is the initial point
	override getPosition(StateGraph graph) {
		// initial point bo is graph and it is child of border shape
		baseDiagram.getPictograms(graph).findFirst[parentBo instanceof StateGraph]?.toPosAndSize(graph.margin)
	}
	
	override <T extends StateGraphNode> getPositions(List<T> items) {
		items.map[baseDiagram.getPictograms(it).head?.toPosAndSize(it.margin)]
	}
	
	override getSubPosition(StateGraphNode subNode) {
		val pe = baseDiagram.getPictograms(subNode).findFirst[parentBo instanceof State]
		if (pe !== null){
			val parentPe = pe.eContainer as PictogramElement
			val relX = pe.graphicsAlgorithm.getX() as double / (parentPe.graphicsAlgorithm.getWidth() - 2 * StateSupport.MARGIN)
			val relY  = pe.graphicsAlgorithm.getY() as double / (parentPe.graphicsAlgorithm.getHeight() - 2 * StateSupport.MARGIN)
			return #[relX, relY]		
		}
	}
	
	var int x
	var int y
	
	override setPosition(int x, int y) {
		this.x = x
		this.y = y
	}
	
	var double sx
	var double sy
	
	override setScale(double sx, double sy) {
		this.sx = sx
		this.sy = sy
	}
	
	def private getParentBo(PictogramElement pe) {
		Graphiti.linkService.getBusinessObjectForLinkedPictogramElement(pe.eContainer as PictogramElement)
	}
	
}