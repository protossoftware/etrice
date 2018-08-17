/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior;

import org.eclipse.etrice.ui.behavior.dialogs.FSMDialogFactory;
import org.eclipse.etrice.ui.behavior.fsm.dialogs.IFSMDialogFactory;
import org.eclipse.etrice.ui.behavior.fsm.support.IBehaviorQuickfixProvider;
import org.eclipse.etrice.ui.behavior.quickfix.BehaviorQuickfixProvider;
import org.eclipse.etrice.ui.common.base.support.DiagramAccessBase;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class BehaviorModule implements Module {

	/* (non-Javadoc)
	 * @see com.google.inject.Module#configure(com.google.inject.Binder)
	 */
	@Override
	public void configure(Binder binder) {
		binder.bind(IFSMDialogFactory.class).to(FSMDialogFactory.class);
		binder.bind(DiagramAccessBase.class).to(DiagramAccess.class);
		binder.bind(IBehaviorQuickfixProvider.class).to(BehaviorQuickfixProvider.class);
		binder.bind(IResourceSetProvider.class).to(XtextResourceSetProvider.class);
	}

}
