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
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.commands.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.ui.commands.RoomOpeningHelper;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GraphitiConnectionEditPart;
import org.eclipse.graphiti.ui.platform.GraphitiShapeEditPart;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 *  Single diagram selection + F3 => jump to declaration in textual editor
 */
public class OpenDeclaration extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection selection = HandlerUtil.getCurrentStructuredSelection(event);
		if(selection.size() != 1) {
			return null;
		}
		
		PictogramElement pe = null;
		if(selection.getFirstElement() instanceof GraphitiShapeEditPart) {
			pe = ((GraphitiShapeEditPart) selection.getFirstElement()).getPictogramElement();
		} 
		else if (selection.getFirstElement() instanceof GraphitiConnectionEditPart) {
			pe = ((GraphitiConnectionEditPart) selection.getFirstElement()).getPictogramElement();
		}
		
		if(pe != null) {
			EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			if(bo != null) {
				RoomOpeningHelper.showInTextualEditor(bo);
			}
		}
		
		return null;
	}

}
