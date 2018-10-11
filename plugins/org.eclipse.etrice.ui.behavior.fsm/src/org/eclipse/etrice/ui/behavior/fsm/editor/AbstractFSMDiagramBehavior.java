/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Eyrak Paen (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.fsm.editor;

import org.eclipse.etrice.ui.common.base.editor.CustomDiagramBehavior;
import org.eclipse.etrice.ui.common.base.editor.CustomUpdateBehavior;
import org.eclipse.gef.EditPart;
import org.eclipse.graphiti.ui.editor.DefaultRefreshBehavior;
import org.eclipse.graphiti.ui.editor.DefaultUpdateBehavior;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;

/**
 * Customizes the DiagramBehavior to help manage BehaviorEditor-specific
 * functionality. This subclass influences the state of the 
 * DiagnosingModelObserver and ensures that the validation image decorators are 
 * in sync with the diagram.
 * @author Eyrak Paen
 *
 */
public class AbstractFSMDiagramBehavior extends CustomDiagramBehavior {
	/**
	 * @param diagramContainer
	 */
	public AbstractFSMDiagramBehavior(AbstractFSMEditor diagramContainer) {
		super(diagramContainer);
	}

	/**
	 * Add the DiagnosingModelObserver to the diagram business model when enabling adapters 
	 */
	@Override
	public void enableAdapters() {
		AbstractFSMEditor editor = (AbstractFSMEditor)getDiagramContainer();
		DiagnosingModelObserver dmObserver = editor.getDiagnosingModelObserver();
		if(dmObserver != null) dmObserver.enable();
		super.enableAdapters();
	}
	
	/**
	 * Remove the DiagnosingModelObserver explicitly from the diagram business model when 
	 * disabling adapters 
	 */
	@Override
	public void disableAdapters() {
		AbstractFSMEditor editor = (AbstractFSMEditor)getDiagramContainer();
		DiagnosingModelObserver dmObserver = editor.getDiagnosingModelObserver();
		if(dmObserver != null) dmObserver.disable();
		super.disableAdapters();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.ui.common.editor.CustomDiagramBehavior#createUpdateBehavior()
	 */
	@Override
	protected DefaultUpdateBehavior createUpdateBehavior() {
		return new UpdateBehavior(this);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.ui.editor.DiagramBehavior#getRefreshBehavior()
	 */
	@Override
	public DefaultRefreshBehavior createRefreshBehavior() {
		return new RefreshBehavior(this);
	}
	
	static class UpdateBehavior extends CustomUpdateBehavior {
		public UpdateBehavior(DiagramBehavior diagramBehavior) {
			super(diagramBehavior);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.graphiti.ui.editor.DefaultUpdateBehavior#handleChangedResources()
		 */
		@Override
		protected void handleChangedResources() {
			// Remove DiagnosticModelObserver from diagram's business model before invoking default handleChangedResources
			((AbstractFSMEditor)diagramBehavior.getDiagramContainer()).detachDiagnosingModelObserver();
			super.handleChangedResources();
		}
	}
	
	static class RefreshBehavior extends DefaultRefreshBehavior {
		public RefreshBehavior(DiagramBehavior diagramBehavior) {
			super(diagramBehavior);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.graphiti.ui.editor.DefaultRefreshBehavior#internalRefreshEditPart(org.eclipse.gef.EditPart)
		 */
		@Override
		public void internalRefreshEditPart(EditPart editPart) {
			// JH: deactivated due https://bugs.eclipse.org/bugs/show_bug.cgi?id=464014
			// TODO find another solution
			// Explicitly deactivate and reactivate EditPart to force call to removeDecorators
			//editPart.deactivate();
			//editPart.activate();
			super.internalRefreshEditPart(editPart);
		}
	}
}
