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

package org.eclipse.etrice.ui.behavior.fsm.editor;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.etrice.ui.behavior.fsm.support.ContextSwitcher;
import org.eclipse.etrice.ui.common.base.editor.DiagramEditorBase;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class AbstractFSMEditor extends DiagramEditorBase {

	protected DiagnosingModelObserver diagnosingModelObserver;

	/**
	 * @param textEditorClass
	 */
	public AbstractFSMEditor(Object textEditorClass) {
		super(textEditorClass);
	}

	public DiagnosingModelObserver getDiagnosingModelObserver() {
		return diagnosingModelObserver;
	}

	@Override
	public void initializeGraphicalViewer() {
		// Start observing the Room Model for rendering Markers
		diagnosingModelObserver = new DiagnosingModelObserver();
		diagnosingModelObserver.observeModel(getModel());
		
		super.initializeGraphicalViewer();
		
		Command cmd = new RecordingCommand(getEditingDomain()) {
			@Override
			protected void doExecute() {
				ContextSwitcher.switchTop(getDiagramTypeProvider().getDiagram());
			}
		};
		getEditingDomain().getCommandStack().execute(cmd);
		getEditingDomain().getCommandStack().flush();
	}
}
