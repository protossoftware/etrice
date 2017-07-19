/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.commands.handlers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.naming.RoomFragmentProvider;
import org.eclipse.etrice.ui.commands.RoomOpeningHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;

/**
 * Handler for outline menu item to open structure editor.
 * The handler will ask to save unsaved editor before opening the diagram.
 *
 * @author Henrik Rentz-Reichert initial contribution and API
 *
 */
public class EditStructureHandler extends AbstractEditHandler {

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.core.ui.outline.AbstractEditHandler#prepare(org.eclipse.xtext.ui.editor.XtextEditor, java.lang.String)
	 */
	@Override
	protected boolean prepare(XtextEditor xtextEditor, String fragment) {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.core.ui.outline.AbstractEditHandler#openEditor(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected void openEditor(EObject object) {
		RoomOpeningHelper.openStructure(object);
	}

	@Override
	protected boolean isEnabled(String fragment) {
		return RoomFragmentProvider.isStructureClass(fragment);
	}

}
