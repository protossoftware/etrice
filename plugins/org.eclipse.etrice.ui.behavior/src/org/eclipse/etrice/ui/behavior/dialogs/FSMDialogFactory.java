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

package org.eclipse.etrice.ui.behavior.dialogs;

import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.ui.behavior.fsm.dialogs.ChoicePointPropertyDialog;
import org.eclipse.etrice.ui.behavior.fsm.dialogs.IChoicePointPropertyDialog;
import org.eclipse.etrice.ui.behavior.fsm.dialogs.IFSMDialogFactory;
import org.eclipse.etrice.ui.behavior.fsm.dialogs.ISelectionDialog;
import org.eclipse.etrice.ui.behavior.fsm.dialogs.IStatePropertyDialog;
import org.eclipse.etrice.ui.behavior.fsm.dialogs.ITrPointPropertyDialog;
import org.eclipse.etrice.ui.behavior.fsm.dialogs.ITransitionPropertyDialog;
import org.eclipse.etrice.ui.behavior.fsm.dialogs.TrPointPropertyDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class FSMDialogFactory implements IFSMDialogFactory {

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.ui.behavior.fsm.dialogs.IFSMDialogFactory#createMemberSelectionDialog(org.eclipse.swt.widgets.Shell, org.eclipse.etrice.core.fsm.fSM.ModelComponent)
	 */
	@Override
	public ISelectionDialog createMemberSelectionDialog(Shell shell, ModelComponent mc) {
		return new MemberSelectionDialog(shell, (ActorClass) mc);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.ui.behavior.fsm.dialogs.IFSMDialogFactory#createMessageSelectionDialog(org.eclipse.swt.widgets.Shell, org.eclipse.etrice.core.fsm.fSM.ModelComponent, boolean)
	 */
	@Override
	public ISelectionDialog createMessageSelectionDialog(Shell shell, ModelComponent mc, boolean receiveOnly) {
		return new PortMessageSelectionDialog(shell, (ActorClass) mc, receiveOnly);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.ui.behavior.fsm.dialogs.IFSMDialogFactory#createStatePropertyDialog(org.eclipse.swt.widgets.Shell, org.eclipse.etrice.core.fsm.fSM.ModelComponent, org.eclipse.etrice.core.fsm.fSM.State, boolean)
	 */
	@Override
	public IStatePropertyDialog createStatePropertyDialog(Shell shell, ModelComponent mc, State s, boolean edit) {
		return new StatePropertyDialog(shell, (ActorClass) mc, s, edit);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.ui.behavior.fsm.dialogs.IFSMDialogFactory#createChoicePointPropertyDialog(org.eclipse.swt.widgets.Shell, org.eclipse.etrice.core.fsm.fSM.ChoicePoint)
	 */
	@Override
	public IChoicePointPropertyDialog createChoicePointPropertyDialog(Shell shell, ChoicePoint cp) {
		return new ChoicePointPropertyDialog(shell, cp);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.ui.behavior.fsm.dialogs.IFSMDialogFactory#createTransitionPropertyDialog(org.eclipse.swt.widgets.Shell, org.eclipse.etrice.core.fsm.fSM.ModelComponent, org.eclipse.etrice.core.fsm.fSM.Transition)
	 */
	@Override
	public ITransitionPropertyDialog createTransitionPropertyDialog(Shell shell, ModelComponent mc, Transition trans) {
		return new TransitionPropertyDialog(shell, (ActorClass) mc, trans);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.ui.behavior.fsm.dialogs.IFSMDialogFactory#createTrPointPropertyDialog(org.eclipse.swt.widgets.Shell, org.eclipse.etrice.core.fsm.fSM.TrPoint, boolean)
	 */
	@Override
	public ITrPointPropertyDialog createTrPointPropertyDialog(Shell shell, TrPoint tp, boolean subtp) {
		return new TrPointPropertyDialog(shell, tp, subtp);
	}

}
