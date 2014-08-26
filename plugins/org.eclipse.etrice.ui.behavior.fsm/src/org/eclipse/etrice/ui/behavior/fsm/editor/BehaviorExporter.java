/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
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

import java.io.File;

import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.ui.behavior.fsm.support.FSMSupportUtil;
import org.eclipse.etrice.ui.common.base.editor.DiagramExporter;
import org.eclipse.etrice.ui.common.base.support.DiagramAccessBase;
import org.eclipse.ui.PlatformUI;

import com.google.inject.Inject;

public class BehaviorExporter {

	private static final String SUFFIX = "_behavior";
	
	@Inject
	private DiagramAccessBase da;

	public void export(ModelComponent mc, String folder) {

		boolean wasOpen = false;
		AbstractFSMEditor editor = (AbstractFSMEditor) da.findDiagramEditor(mc);
		if (editor!=null)
			wasOpen = true;
		else
			editor = (AbstractFSMEditor) da.openDiagramEditor(mc);

		if (editor!=null) {
			String filename = folder+File.separatorChar+mc.getComponentName()+SUFFIX;
			DiagramExporter.export(editor, filename);
			
			exportSubGraphsRecursively(mc.getStateMachine(), editor, folder+File.separatorChar+mc.getComponentName());
			
			if (!wasOpen)
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(editor, false);
		}
	}

	private void exportSubGraphsRecursively(StateGraph sg, AbstractFSMEditor editor, String basename) {
		if (sg==null)
			return;
		
		for (State state : sg.getStates()) {
			if (FSMSupportUtil.getInstance().getFSMHelpers().hasDirectSubStructure(state)) {
				if (editor.showStateGraph(state.getSubgraph())) {
					String filename = basename+"_"+FSMSupportUtil.getInstance().getFSMNameProvider().getStatePathName(state)+SUFFIX;
					DiagramExporter.export(editor, filename);
				}
				
				exportSubGraphsRecursively(state.getSubgraph(), editor, basename);
			}
		}
	}
}
