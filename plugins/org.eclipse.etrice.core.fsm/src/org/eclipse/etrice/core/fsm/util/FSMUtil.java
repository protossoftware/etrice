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

package org.eclipse.etrice.core.fsm.util;

import java.util.Set;

import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.Transition;

import com.google.inject.Inject;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class FSMUtil {

	@Inject
	private FSMHelpers fsmHelpers;

	/**
	 * @param sg a {@link StateGraph} serving as name space
	 * @return a unique name for a new {@link Transition} (has to be unique among
	 * 		all {@link StateGraphItem}s of the state graph)
	 */
	public String getUniqueTransitionName(StateGraph sg) {
		Set<String> names = fsmHelpers.getAllNames(sg);
		
		for (int i = 0; i < 1000; i++) {
			String name = "tr"+i;
			if (!names.contains(name))
				return name;
		}
		
		return "not_unique";
	}

	/**
	 * @param sg a {@link StateGraph} serving as name space
	 * @return a unique name for a new {@link InitialTransition} (has to be unique among
	 * 		all {@link StateGraphItem}s of the state graph)
	 */
	public String getUniqueInitialTransitionName(StateGraph sg) {
		Set<String> names = fsmHelpers.getAllNames(sg);
		
		if (!names.contains("init"))
			return "init";
		
		for (int i = 0; i < 1000; i++) {
			String name = "init"+i;
			if (!names.contains(name))
				return name;
		}
		
		return "not_unique";
	}

	/**
	 * @param sg a {@link StateGraph} serving as name space
	 * @return a unique name for a new {@link ChoicePoint} (has to be unique among
	 * 		all {@link StateGraphItem}s of the state graph)
	 */
	public String getUniqueChoicePointName(StateGraph sg) {
		Set<String> names = fsmHelpers.getAllNames(sg);
		
		for (int i = 0; i < 1000; i++) {
			String name = "cp"+i;
			if (!names.contains(name))
				return name;
		}
		
		return "not_unique";
	}

	/**
	 * @param sg a {@link StateGraph} serving as name space
	 * @return a unique name for a new {@link TrPoint} (has to be unique among
	 * 		all {@link StateGraphItem}s of the state graph)
	 */
	public String getUniqueTrPointName(StateGraph sg) {
		Set<String> names = fsmHelpers.getAllNames(sg);
		
		for (int i = 0; i < 1000; i++) {
			String name = "tp"+i;
			if (!names.contains(name))
				return name;
		}
		
		return "not_unique";
	}

	/**
	 * @param sg a {@link StateGraph} serving as name space
	 * @return a unique name for a new {@link State} (has to be unique among
	 * 		all {@link StateGraphItem}s of the state graph)
	 */
	public String getUniqueStateName(StateGraph sg) {
		Set<String> names = fsmHelpers.getAllNames(sg);
		
		for (int i = 0; i < 1000; i++) {
			String name = "state"+i;
			if (!names.contains(name))
				return name;
		}
		
		return "not_unique";
	}

}
