/*******************************************************************************
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.fsm.provider

import com.google.common.collect.ArrayListMultimap
import com.google.common.collect.Multimap
import java.util.Collection
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.etrice.core.fsm.fSM.ModelComponent
import org.eclipse.etrice.core.fsm.fSM.StateGraph
import org.eclipse.etrice.ui.behavior.fsm.editor.AbstractFSMDiagramTypeProvider
import org.eclipse.etrice.ui.behavior.fsm.support.util.FSMSupportUtil
import org.eclipse.etrice.ui.common.base.support.DiagramAccessBase
import org.eclipse.graphiti.mm.pictograms.PictogramElement
import org.eclipse.graphiti.mm.pictograms.PictogramLink
import org.eclipse.graphiti.services.Graphiti

/**
 *  Provides the {@linkplain PictogramElement} objects of the base class diagram.
 *  This is a reverse mapping from room business objects to linked base diagram pictograms.
 * 
 *  TODO: use fsmgenmodel instead
 */
class BaseDiagramProvider {

	val Multimap<EObject, PictogramElement> baseDiagramBusinessObjs = ArrayListMultimap.create
	val fsmHelpers = FSMSupportUtil.instance.FSMHelpers

	new(AbstractFSMDiagramTypeProvider diagramTypeProvider) {
		val diagramAccess = diagramTypeProvider.injector.getInstance(DiagramAccessBase)
		val mc = Graphiti.linkService.getBusinessObjectForLinkedPictogramElement(diagramTypeProvider.diagram) as ModelComponent
		val rs = diagramTypeProvider.diagram.eResource.resourceSet
		
		// open base diagrams => causes full recursive update or creation of all base diagrams
		// all base diagrams have to be considered because inherited subgraph could not exist yet
		val baseClasses = newArrayList => [
			var base = mc.base
			while(base !== null && it.add(base)) { 
				base = base.base
			}		
		]
		baseClasses.reverseView.forEach[ base |
			val baseDiagram = diagramAccess.getDiagram(base, rs)	
			if(baseDiagram !== null) {
				// create mapping from business object to pictogram elements
				EcoreUtil.ExternalCrossReferencer.find(baseDiagram).forEach [ targetEObj, eFeatureSetting |
					eFeatureSetting.map[getEObject].filter(PictogramLink).map[pictogramElement].forEach [ pe |
						put(mc, targetEObj, pe)
					]
				]
				
				// base diagram resource not needed anymore
				rs.resources.remove(baseDiagram.eResource)		
			}	
		]
	}
	
	private def put(ModelComponent mc, EObject obj, PictogramElement value) {
		if (obj instanceof StateGraph) {
			if (fsmHelpers.isTopLevel(obj)) {
				// to find the initial point of the TOP level we need the ModelComponent's stateMachine as a key
				baseDiagramBusinessObjs.put(mc.stateMachine, value)
			}
		}
		baseDiagramBusinessObjs.put(obj, value)
	}

	def Collection<PictogramElement> getPictograms(EObject roomObj) {
		if(roomObj === null) emptyList else baseDiagramBusinessObjs.get(roomObj)
	}

}
