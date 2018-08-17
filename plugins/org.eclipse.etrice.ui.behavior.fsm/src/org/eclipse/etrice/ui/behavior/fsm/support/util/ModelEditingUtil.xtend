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

import java.util.HashMap
import org.eclipse.etrice.core.fsm.fSM.FSMFactory
import org.eclipse.etrice.core.fsm.fSM.ModelComponent
import org.eclipse.etrice.core.fsm.fSM.RefinedState
import org.eclipse.etrice.core.fsm.fSM.State
import org.eclipse.etrice.core.fsm.fSM.StateGraph
import org.eclipse.graphiti.features.IFeatureProvider
import org.eclipse.graphiti.mm.pictograms.ContainerShape

/**
 *  Shared model editing
 */
class ModelEditingUtil {
	
	def static public RefinedState getOrCreateRefinedStateFor(State s, ModelComponent mc) {
		val target2rs = new HashMap<State, RefinedState>();
		for (State st : mc.getStateMachine().getStates()) {
			if (st instanceof RefinedState)
				target2rs.put((st as RefinedState).getTarget(), st as RefinedState);
		}
		
		var RefinedState rs = null;
		
		// do we already have a RefinedState pointing to s?
		if (target2rs.containsKey(s)) {
			rs = target2rs.get(s);
		}
		else {
			// we have to create one and place it in the best fitting context
			var StateGraph sg = null;
			var State parent = s;
			var break = false;
			while (parent.eContainer().eContainer() instanceof State && !break) {
				parent =  s.eContainer().eContainer() as State;
				if (target2rs.containsKey(parent)) {
					val bestFitting = target2rs.get(parent);
					if (bestFitting.getSubgraph()===null)
						bestFitting.setSubgraph(FSMFactory.eINSTANCE.createStateGraph());
					sg = bestFitting.getSubgraph();
					break = true;
				}
			}
			
			if (sg===null)
				sg = mc.getStateMachine();
			
			rs = FSMFactory.eINSTANCE.createRefinedState();
			rs.setTarget(s);
			sg.getStates().add(rs);
		}
		return rs;
	}
	
	
	
	def static public StateGraph getOrCreateSubGraphOfRefinedStateFor(State s, ModelComponent mc) {
		val rs = getOrCreateRefinedStateFor(s, mc);
		
		if (rs.getSubgraph()===null)
			rs.setSubgraph(FSMFactory.eINSTANCE.createStateGraph());
	
		return rs.getSubgraph();
	}
	
	def static public StateGraph insertRefinedState(StateGraph sg, ModelComponent mc, ContainerShape targetContainer, IFeatureProvider fp) {
		val sg2 = getOrCreateSubGraphOfRefinedStateFor(sg.eContainer() as State, mc);
		fp.link(targetContainer, sg2);
		return sg2;
	}
}