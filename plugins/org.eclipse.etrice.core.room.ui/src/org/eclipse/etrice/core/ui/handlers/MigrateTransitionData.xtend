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
import org.eclipse.etrice.core.fsm.fSM.FSMFactory
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.MessageData
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.swt.widgets.Display
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.editor.utils.EditorUtils
import org.eclipse.xtext.util.concurrent.IUnitOfWork
import org.eclipse.etrice.core.fsm.fSM.DetailCode
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.room.MessageHandler
import com.google.inject.Inject
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider

class MigrateTransitionData extends AbstractHandler {

	public static final String genericDataName = "transitionData"

	@Inject
	IWhitespaceInformationProvider whitespaceProvider;
	
	String lineSep
	int actionCodeReplacements = 0
	int messageNamesRemoved = 0
	
	override Object execute(ExecutionEvent event) throws ExecutionException {
		
		val proceed = MessageDialog.openQuestion(
			Display.current.activeShell,
			"Migrate to new style of transition data",
			"This migration will\n"
			+ "* remove all names of message data\n"
			+ "* replace textual occurrences of old data names with the generic name '" + genericDataName + "'\n\n"
			+ "Proceed?"
		)
		if (proceed) {
			val editor = EditorUtils.getActiveXtextEditor(event)
			if (editor!==null) {
				editor.getDocument().modify(new IUnitOfWork.Void<XtextResource>() {
						override void process(XtextResource state) throws Exception {
							lineSep = whitespaceProvider.getLineSeparatorInformation(state.URI).lineSeparator
							for (model : state.getContents()) {
								if (model instanceof RoomModel) {
									migrateModel(model)
								}
							}
						}
					});
				MessageDialog.openInformation(
					Display.current.activeShell,
					"Migrate to new style of transition data",
					"Did replacements in " + actionCodeReplacements + " action codes.\n"
					+ "In " + messageNamesRemoved + " messages the data names have been removed."
				)
			}
		}
		return null;
	}

	private def void migrateModel(RoomModel model) {
		// (1) parse detail code and make replacements (before names are nulled in (2))
		// consider only TriggeredTransition (which is not quite accurate)
		model.eAllContents.toIterable.filter(TriggeredTransition).forEach[action = makeActionCodeReplacements(triggers.head?.msgFromIfPairs.head?.message, action)]
		model.eAllContents.toIterable.filter(MessageHandler).forEach[detailCode = makeActionCodeReplacements(msg, detailCode)]
		
		// (2) remove names of message data
		model.eAllContents.toIterable.filter(MessageData).forEach[
			deprecatedName = null
			messageNamesRemoved++
		]
	}
	
	private def makeActionCodeReplacements(EObject msg, DetailCode action) {
		// inaccurate assumption: we can look at the first trigger message only
		if (msg instanceof Message) {
			if (msg.data!==null && msg.data.deprecatedName!==null && action!==null && !action.lines.empty) {
				// we turn a multiline detail code into a single line one. Otherwise the serializer will fail because of the CC_STRING
				if (action.lines.join.contains(msg.data.deprecatedName)) {
					actionCodeReplacements++
					return FSMFactory.eINSTANCE.createDetailCode => [
						val replaced = action.lines.map[replace(msg.data.deprecatedName, genericDataName)].join(lineSep)
						lines.add(replaced)
						used = false
					]
				}
			}
		}
		
		// return the unchanged code
		return action
	}
	
}