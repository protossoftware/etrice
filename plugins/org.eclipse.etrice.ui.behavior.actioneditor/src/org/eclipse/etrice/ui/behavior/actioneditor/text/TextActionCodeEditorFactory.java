/*******************************************************************************
 * Copyright (c) 2014 Jayant Gupta
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Jayant Gupta (initial contribution)
 *
 *
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.actioneditor.text;

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.ui.behavior.actioneditor.Activator;
import org.eclipse.etrice.ui.behavior.fsm.actioneditor.IActionCodeEditor;
import org.eclipse.etrice.ui.behavior.fsm.actioneditor.IActionCodeEditorFactory;
import org.eclipse.swt.widgets.Composite;

/**
 * Factory for creation of {@link TextActionCodeEditor}.
 * 
 * @author jayant
 */
public class TextActionCodeEditorFactory implements IActionCodeEditorFactory {

	/** List of constructed editors */
	ArrayList<TextActionCodeEditor> constructedEditors = new ArrayList<TextActionCodeEditor>();

	@Override
	public IActionCodeEditor createActionCodeEditor(DetailCode detailCode,
			Composite parent, ModelComponent mc, boolean useMembers,
			boolean useMessages, boolean useRecvMessagesOnly) {

		TextActionCodeEditor textActionCodeEditor = null;

		if (mc instanceof ActorClass) {
			textActionCodeEditor = new TextActionCodeEditor();
			try {
				textActionCodeEditor.init(detailCode);
			} catch (CoreException e) {
				Activator.getDefault().getLog().log(e.getStatus());
				System.out.println("Cannot Initialize editor");
			}
			textActionCodeEditor.createControl(parent);
		} else {
			Activator
					.getDefault()
					.getLog()
					.log(new Status(Status.ERROR, Activator.PLUGIN_ID,
							"Model Componenent " + mc.getComponentName()
									+ " is not an instance of ActorClass"));
		}

		return textActionCodeEditor;
	}

	@Override
	public void dispose() {
		for (TextActionCodeEditor constructedEditor : constructedEditors) {
			constructedEditor.dispose();
		}
		constructedEditors.clear();
	}
}