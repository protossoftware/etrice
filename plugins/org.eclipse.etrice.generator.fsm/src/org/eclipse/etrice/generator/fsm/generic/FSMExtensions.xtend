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

import com.google.inject.Inject
import java.util.ArrayList
import java.util.List
import org.eclipse.etrice.core.fsm.fSM.CPBranchTransition
import org.eclipse.etrice.core.fsm.fSM.DetailCode
import org.eclipse.etrice.core.fsm.fSM.Guard
import org.eclipse.etrice.core.fsm.fSM.ModelComponent
import org.eclipse.etrice.core.fsm.fSM.State
import org.eclipse.etrice.core.fsm.util.FSMHelpers

/**
 * @author Henrik Rentz-Reichert
 *
 */
class FSMExtensions {
	
	@Inject protected extension FSMHelpers
	
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
     * @param states a list of {@link State}s
     * @return a list ordered such that leaf states are last
     */
    def getLeafStatesLast(List<State> states) {
        val leaf = states.filter(s|s.leaf)
        val nonLeaf = states.filter(s|!s.leaf)
        
        nonLeaf + leaf
    }

    /**
     * @param ac an {@link ActorClass}
     * @return a list of all leaf states
     */
    def List<State> getAllLeafStates(ModelComponent mc) {
        mc.stateMachine.leafStateList
    }

    /**
     * @param ac an {@link ActorClass}
     * @return a list of simple states with leaf states last
     */
    def List<State> getAllBaseStatesLeavesLast(ModelComponent mc) {
        mc.allBaseStates.getLeafStatesLast.toList
    }

    /**
     * @param ac an {@link ModelComponent}
     * @return the number of all inherited states
     */
    def int getNumberOfInheritedStates(ModelComponent mc) {
        if (mc.base===null)
            return 0
        else
            return mc.base.stateMachine.stateList.size+mc.base.numberOfInheritedStates
    }
    
    /**
     * @param ac an {@link ModelComponent}
     * @return the number of all inherited base (or simple) states
     */
    def int getNumberOfInheritedBaseStates(ModelComponent ac) {
        if (ac.base===null)
            return 0
        else
            return ac.base.stateMachine.baseStateList.size+ac.base.numberOfInheritedBaseStates
    }
	
	def boolean isConditionOrGuard(DetailCode dc) {
        val parent = dc.eContainer
        switch (parent) {
            Guard: true
            CPBranchTransition: parent.condition==dc
            default:
                false
        }
	}
}