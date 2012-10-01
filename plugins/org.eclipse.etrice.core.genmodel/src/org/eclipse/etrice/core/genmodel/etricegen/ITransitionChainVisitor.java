/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.etricegen;

import org.eclipse.etrice.core.room.CPBranchTransition;
import org.eclipse.etrice.core.room.ContinuationTransition;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.Transition;

public interface ITransitionChainVisitor {
	String genTypedData(TransitionChain tc);
	String genActionOperationCall(Transition tr);
	String genEntryOperationCall(State state);
	String genExitOperationCall(State state);
	String genElseIfBranch(CPBranchTransition tr, boolean isFirst);
	String genElseBranch(ContinuationTransition tr);
	String genEndIf();
	String genReturnState(State state);

} // ITransitionChainVisitor
