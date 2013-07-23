/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.base;

import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.core.genmodel.etricegen.TransitionChain;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class CodegenHelpers {
	
	/**
	 * @param t a {@link Transition}
	 * @return a name for the action code operation the generator will generate
	 */
	public static String getActionCodeOperationName(Transition t) {
		return "action_"+RoomNameProvider.getFullPath(t);
	}
	
	/**
	 * @param s a {@link State}
	 * @return a name for the entry code operation the generator will generate
	 */
	public static String getEntryCodeOperationName(State s) {
		return "entry_"+getGenStatePathName(s);
	}
	
	/**
	 * @param s a {@link State}
	 * @return a name for the exit code operation the generator will generate
	 */
	public static String getExitCodeOperationName(State s) {
		return "exit_"+getGenStatePathName(s);
	}
	
	/**
	 * @param s a {@link State}
	 * @return a name for the do code operation the generator will generate
	 */
	public static String getDoCodeOperationName(State s) {
		return "do_"+getGenStatePathName(s);
	}
	
	/**
	 * @param tc a {@link TransitionChain}
	 * @return a name for the constant transition chain ID the generator will generate
	 */
	public static String getGenChainId(TransitionChain tc) {
		return "CHAIN_"+RoomNameProvider.getFullPath(tc.getTransition());
	}
	
	/**
	 * @param s a {@link State} (must not be <code>null</code>)
	 * @return the path of the state that may serve as a unique identifier
	 * 
	 * @see {@link org.eclipse.etrice.core.naming.RoomNameProvider#getFullPath(StateGraphItem)}
	 */
	public static String getGenStatePathName(State s) {
		return RoomNameProvider.getFullPath(s);
	}
	
	/**
	 * @param s a {@link State} (may be <code>null</code>)
	 * @return a unique identifier used by the generator for state IDs
	 */
	public static String getGenStateId(State s) {
		if (s==null)
			return "STATE_"+RoomNameProvider.getStateName(s);
		else
			return "STATE_"+RoomNameProvider.getFullPath(s);
	}
	
	/**
	 * @param s a {@link State} (may be <code>null</code>)
	 * @return an ID for the parent state of s
	 * @see {@link #getGenStateId(State)}
	 */
	public static String getParentStateId(State s) {
		return getGenStateId(RoomHelpers.getParentState(s));
	}

}
