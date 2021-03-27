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
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.fsm.base;

import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider;
import org.eclipse.etrice.core.fsm.util.FSMHelpers;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class CodegenHelpers {
	
	private FSMHelpers fsmHelpers = new FSMHelpers();
	private FSMNameProvider fsmNameProvider = new FSMNameProvider();
	
	/**
	 * @param t a {@link Transition}
	 * @return a name for the action code operation the generator will generate
	 */
	public String getActionCodeOperationName(Transition t) {
		return "action_"+fsmNameProvider.getFullPath(t);
	}
	
	/**
	 * @param s a {@link State}
	 * @return a name for the entry code operation the generator will generate
	 */
	public String getEntryCodeOperationName(State s) {
		return "entry_"+getGenStatePathName(s);
	}
	
	/**
	 * @param s a {@link State}
	 * @return a name for the exit code operation the generator will generate
	 */
	public String getExitCodeOperationName(State s) {
		return "exit_"+getGenStatePathName(s);
	}
	
	/**
	 * @param s a {@link State}
	 * @return a name for the do code operation the generator will generate
	 */
	public String getDoCodeOperationName(State s) {
		return "do_"+getGenStatePathName(s);
	}
	
	/**
	 * @param tc a {@link Transition}
	 * @return a name for the constant transition chain ID the generator will generate
	 */
	public String getGenChainId(Transition tc) {
		return "CHAIN_"+fsmNameProvider.getFullPath(tc);
	}
	
	/**
	 * @param s a {@link State} (must not be <code>null</code>)
	 * @return the path of the state that may serve as a unique identifier
	 * 
	 * @see org.eclipse.etrice.core.naming.RoomNameProvider#getFullPath(StateGraphItem)
	 */
	public String getGenStatePathName(State s) {
		return fsmNameProvider.getFullPath(s);
	}
	
	/**
	 * @param s a {@link State} (may be <code>null</code>)
	 * @return a unique identifier used by the generator for state IDs
	 */
	public String getGenStateId(State s) {
		if (s==null)
			return "STATE_"+fsmNameProvider.getStateName(s);
		else
			return "STATE_"+fsmNameProvider.getFullPath(s);
	}
	
	/**
	 * @param s a {@link State} (may be <code>null</code>)
	 * @return an ID for the parent state of s
	 * @see #getGenStateId(State)
	 */
	public String getParentStateId(State s) {
		return getGenStateId(fsmHelpers.getParentState(s));
	}

}
