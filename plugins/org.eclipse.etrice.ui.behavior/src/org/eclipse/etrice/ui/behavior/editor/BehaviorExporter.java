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

package org.eclipse.etrice.ui.behavior.editor;

import java.io.File;

import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.ui.behavior.DiagramAccess;
import org.eclipse.etrice.ui.behavior.fsm.support.FSMSupportUtil;
import org.eclipse.etrice.ui.common.base.editor.DiagramExporter;
import org.eclipse.ui.PlatformUI;

public class BehaviorExporter {

	private static final String SUFFIX = "_behavior";

	public static void export(ModelComponent ac, String folder) {
		DiagramAccess da = new DiagramAccess();

		boolean wasOpen = false;
		BehaviorEditor editor = (BehaviorEditor) da.findDiagramEditor(ac);
		if (editor!=null)
			wasOpen = true;
		else
			editor = (BehaviorEditor) da.openDiagramEditor(ac);

		if (editor!=null) {
			String filename = folder+File.separatorChar+ac.getComponentName()+SUFFIX;
			DiagramExporter.export(editor, filename);
			
			exportSubGraphsRecursively(ac.getStateMachine(), editor, folder+File.separatorChar+ac.getComponentName());
			
			if (!wasOpen)
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(editor, false);
		}
	}

	private static void exportSubGraphsRecursively(StateGraph sg, BehaviorEditor editor, String basename) {
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
