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

import com.google.inject.Inject
import java.util.regex.Pattern
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.fsm.fSM.DetailCode
import org.eclipse.etrice.core.fsm.fSM.FSMFactory
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.MessageHandler
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.swt.widgets.Display
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.editor.utils.EditorUtils
import org.eclipse.xtext.util.concurrent.IUnitOfWork

class MigrateTransitionData extends AbstractHandler {

	public static final String genericDataName = "transitionData"

	@Inject
	IWhitespaceInformationProvider whitespaceProvider;
	
	static class MigrateContext {
		var String lineSep
		var int actionCodeReplacements = 0
	}
	
	override Object execute(ExecutionEvent event) throws ExecutionException {
		
		val proceed = MessageDialog.openQuestion(
			Display.current.activeShell,
			"Migrate to new style of transition data",
			"This migration will replace textual occurrences of old data names with the generic name '" + genericDataName + "'\n\n"
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
							if (model instanceof RoomModel) {
								migrateModel(model, ctx)
							}
						}
						return ctx
					}
					
						
					});
				MessageDialog.openInformation(
					Display.current.activeShell,
					"Migrate to new style of transition data",
					"Did replacements in " + ctx.actionCodeReplacements + " action codes."
				)
			}
		}
		return null;
	}

	private def void migrateModel(RoomModel model, MigrateContext ctx) {
		// parse detail code and make replacements
		// consider only TriggeredTransition (which is not quite accurate)
		model.eAllContents.toIterable.filter(TriggeredTransition).forEach[
			val msg = triggers.head?.msgFromIfPairs?.head?.message
			if(triggers.head?.guard !== null) {
				triggers.head.guard.guard = makeActionCodeReplacements(msg, triggers.head.guard.guard, ctx)
			}
			action = makeActionCodeReplacements(msg, action, ctx)
		]
		model.eAllContents.toIterable.filter(MessageHandler).forEach[
			detailCode = makeActionCodeReplacements(msg, detailCode, ctx)
		]
	}
	
	private def makeActionCodeReplacements(EObject msg, DetailCode action, MigrateContext ctx) {
		// inaccurate assumption: we can look at the first trigger message only
		if (msg instanceof Message) {
			if (msg.data!==null && msg.data.deprecatedName!==null && action!==null && !action.lines.empty) {
				// we turn a multiline detail code into a single line one. Otherwise the serializer will fail because of the CC_STRING				
				val detailCode = action.lines.join(ctx.lineSep)
				// only full name matches
				val matcher = Pattern.compile('''(?<![\d\w_])«msg.data.deprecatedName»(?![\d\w_])''').matcher(detailCode)
				if(matcher.find) {
					ctx.actionCodeReplacements += 1
					return FSMFactory.eINSTANCE.createDetailCode => [
						lines += matcher.replaceAll(genericDataName)
						used = false
					]
				}
			}
		}
		
		// return the unchanged code
		return action
	}
	
}