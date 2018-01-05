/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.ui.handlers

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.swt.widgets.Display
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.editor.utils.EditorUtils
import org.eclipse.xtext.util.concurrent.IUnitOfWork
import org.eclipse.etrice.core.fsm.fSM.DetailCode
import com.google.inject.Inject
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider

class MigrateActionCodes extends AbstractHandler {

	@Inject
	IWhitespaceInformationProvider whitespaceProvider;
	
	String lineSep
	int actionCodesChanged = 0
	
	override execute(ExecutionEvent event) throws ExecutionException {
		
		val proceed = MessageDialog.openQuestion(
			Display.current.activeShell,
			"Migrate action codes to smart strings",
			"This migration will convert all action codes to smart strings.\n\n"
			+ "Proceed?"
		)
		if (proceed) {
			val editor = EditorUtils.getActiveXtextEditor(event)
			if (editor!==null) {
				editor.getDocument().modify(new IUnitOfWork.Void<XtextResource>() {
						override void process(XtextResource state) throws Exception {
							lineSep = whitespaceProvider.getLineSeparatorInformation(state.URI).lineSeparator
							for (model : state.getContents()) {
								migrateModel(model)
							}
						}
					});
				MessageDialog.openInformation(
					Display.current.activeShell,
					"Migrate action codes to smart strings",
					"Changed " + actionCodesChanged + " action codes to smart strings.\n\n"
					+ "It might be necessary to format (ctrl+shift+F) the model."
				)
			}
		}
		return null;
	}

	private def void migrateModel(EObject model) {
		model.eAllContents.toIterable.filter(DetailCode).filter[used].forEach[
			val ccString = lines.join(whitespaceProvider.getLineSeparatorInformation(eResource.URI).lineSeparator)
			
			used = false
			lines.clear
			lines += ccString
			
			actionCodesChanged++
		]
	}
}