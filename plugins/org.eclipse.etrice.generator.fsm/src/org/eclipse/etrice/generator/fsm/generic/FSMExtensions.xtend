/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.fsm.generic

import org.eclipse.etrice.core.fsm.fSM.Transition
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent
import java.util.List
import org.eclipse.etrice.core.fsm.fSM.State
import java.util.ArrayList
import org.eclipse.etrice.core.fsm.fSM.StateGraph
import org.eclipse.etrice.core.fsm.fSM.TransitionPoint

/**
 * @author Henrik Rentz-Reichert
 *
 */
class FSMExtensions {
	
	//-------------------------------------------------------
	// union methods
	
	/**
	 * the template type is T
	 * @param l an iterable of type T
	 * @param e a single element of type T
	 * @return the union of the iterable and the element as new list
	 */
	def <T> List<T> union(Iterable<T> l, T e) {
		var ret = new ArrayList<T>()
		ret.addAll(l)
		ret.add(e)
		return ret
	}
	
	/**
	 * the template type is T
	 * @param l1 an iterable of type T
	 * @param l2 a second iterable of type T
	 * @return the union of the two iterables as new list
	 */
	def <T> List<T> union(Iterable<T> l1, Iterable<T> l2) {
		var ret = new ArrayList<T>()
		ret.addAll(l1)
		ret.addAll(l2)
		return ret
	}
	
	/**
	 * the template type is T
	 * @param l1 a list of elements of type T
	 * @param l2 a second list of elements of type T
	 * @return a new list with the contents of l1 
	 */
	def <T> List<T> minus(List<T> l1, List<T> l2){
		var ret = new ArrayList<T>(l1)
		ret.removeAll(l2)
		return ret;
	}

	/**
	 * @param ac an {@link ExpandedActorClass}
	 * @param s a {@link State}
	 * @return a list of {@link Transition}s starting at the state and going up in the hierarchy
	 * 		following the logic of evaluation of firing conditions
	 */
	def List<Transition> getOutgoingTransitionsHierarchical(ExpandedModelComponent ac, State s) {
		var result = new ArrayList<Transition>()
		
		// own transitions
		result.addAll(ac.getOutgoingTransitions(s))

		// transition points on same level
		var sg = s.eContainer() as StateGraph
		for (tp : sg.getTrPoints()) {
			if (tp instanceof TransitionPoint)
				result.addAll(ac.getOutgoingTransitions(tp))
		}
		
		// recurse to super states
		if (sg.eContainer() instanceof State) {
			result.addAll(getOutgoingTransitionsHierarchical(ac, sg.eContainer() as State))
		}
		
		return result;
	}
	
}