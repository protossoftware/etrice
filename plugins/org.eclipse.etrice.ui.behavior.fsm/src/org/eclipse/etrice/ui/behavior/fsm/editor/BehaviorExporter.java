/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.ui.behavior.fsm.editor;

import java.io.File;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.ui.behavior.fsm.support.util.FSMSupportUtil;
import org.eclipse.etrice.ui.common.base.export.DiagramExporter;
import org.eclipse.etrice.ui.common.base.export.IBulkDiagramExporter;
import org.eclipse.etrice.ui.common.base.support.DiagramAccessBase;
import org.eclipse.ui.PlatformUI;

public class BehaviorExporter implements IBulkDiagramExporter {

	private static final String SUFFIX = "_behavior";
	
	private DiagramAccessBase da;
	
	public BehaviorExporter(DiagramAccessBase da) {
		this.da = da;
	}

	public void export(EObject roomClass, String folder) {

		boolean wasOpen = false;
		AbstractFSMEditor editor = (AbstractFSMEditor) da.findDiagramEditor(roomClass);
		if (editor!=null)
			wasOpen = true;
		else
			editor = (AbstractFSMEditor) da.openDiagramEditor(roomClass);
		ModelComponent mc = editor.getModelComponent();

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
