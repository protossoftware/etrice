/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.core.ui.handlers

import com.google.inject.Inject
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.fsm.fSM.DetailCode
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.swt.widgets.Display
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.editor.utils.EditorUtils
import org.eclipse.xtext.util.concurrent.IUnitOfWork

class MigrateActionCodes extends AbstractHandler {

	@Inject
	IWhitespaceInformationProvider whitespaceProvider;
	
	static class MigrateContext {
		var String lineSep
		var int actionCodesChanged = 0
	}
	
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
					val ctx = editor.getDocument().modify(new IUnitOfWork<MigrateContext, XtextResource>() {
					
					override exec(XtextResource state) throws Exception {
						val ctx = new MigrateContext => [
							lineSep = whitespaceProvider.getLineSeparatorInformation(state.URI).lineSeparator
						]
						for (model : state.getContents()) {
							migrateModel(model, ctx)				
						}
						return ctx
					}
					
						
					});
				MessageDialog.openInformation(
					Display.current.activeShell,
					"Migrate action codes to smart strings",
					"Changed " + ctx.actionCodesChanged + " action codes to smart strings.\n\n"
					+ "It might be necessary to format (ctrl+shift+F) the model."
				)
			}
		}
		return null;
	}

	private def void migrateModel(EObject model, MigrateContext ctx) {
		model.eAllContents.toIterable.filter(DetailCode).filter[used].forEach[
			val ccString = lines.join(ctx.lineSep)
			
			used = false
			lines.clear
			lines += ccString
			
			ctx.actionCodesChanged++
		]
	}
}