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

package org.eclipse.etrice.ui.behavior.fsm.dialogs;

import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public interface IFSMDialogFactory {

	ISelectionDialog createMemberSelectionDialog(Shell shell, ModelComponent mc);
	ISelectionDialog createMessageSelectionDialog(Shell shell, ModelComponent mc, boolean receiveOnly);
	IStatePropertyDialog createStatePropertyDialog(Shell shell, ModelComponent mc, State s, boolean edit);
	IChoicePointPropertyDialog createChoicePointPropertyDialog(Shell shell, ChoicePoint cp);
	ITransitionPropertyDialog createTransitionPropertyDialog(Shell shell, ModelComponent mc, Transition trans);
	ITrPointPropertyDialog createTrPointPropertyDialog(Shell shell, TrPoint tp, boolean subtp);
}
