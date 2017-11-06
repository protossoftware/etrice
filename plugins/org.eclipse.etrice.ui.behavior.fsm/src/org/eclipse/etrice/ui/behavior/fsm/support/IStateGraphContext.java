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

package org.eclipse.etrice.ui.behavior.fsm.support;

import java.util.List;

import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.Transition;

/**
 *  Interface to change implementation of StateGraphContext (newfsmgen)
 */
public interface IStateGraphContext {
	
	public State getParentState();

	public List<IStateGraphContext> getChildren();

	public List<State> getStates();

	public List<ChoicePoint> getChPoints();

	public StateGraph getStateGraph();

	public List<TrPoint> getTrPoints();

	public List<Transition> getTransitions();

	public IPositionProvider getPositionProvider();
	
	public StateGraph getInitialPoint();
}
