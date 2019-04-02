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
package org.eclipse.etrice.core.common.ui.quickfix

import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.etrice.core.common.validation.BaseJavaValidator
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.etrice.core.common.base.Import
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Path
import org.eclipse.etrice.core.common.ui.modelpath.ModelPathManager
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.ide.IDE
import org.eclipse.xtext.util.StringInputStream

//import org.eclipse.xtext.ui.editor.quickfix.Fix
//import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
//import org.eclipse.xtext.validation.Issue

/**
 * Custom quickfixes.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#quickfixes
 */
class BaseQuickfixProvider extends DefaultQuickfixProvider {

	@Fix(BaseJavaValidator.DEPRECATED_IMPORT_URI)
	def removeImportUri(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Remove import uri', 'Remove the import uri', null) [ element, context |
			val imp = element as Import
			imp.importURI = null
		]
	}
	
	@Fix(BaseJavaValidator.MODELPATH_DESCRIPTION_MISSING)
	@Fix(BaseJavaValidator.IMPORTED_NAMESPACE_MISSING)
	def editModelpathDescription(Issue issue, IssueResolutionAcceptor acceptor) {
		val resourceUri = issue.uriToProblem.trimFragment
		if(resourceUri.platform) {
			val path = new Path(resourceUri.toPlatformString(true))
			val project = ResourcesPlugin.workspace.root.getFile(path).project
			val file = project.getFile(ModelPathManager.MODELPATH_FILE)
			if(!file.exists) {
				acceptor.accept(issue, "Create modelpath description", "Create modelpath description file", null) [
					val input = new StringInputStream('''
						// modelpath description
						
						// HOWTO define source directory
						// srcDir <directory path>
						
						// HOWTO define project dependency
						// project <project name>
					''')
					file.create(input, false, null);
					IDE.openEditor(PlatformUI.workbench.activeWorkbenchWindow.activePage, file)
				]
			}
			else {
				acceptor.accept(issue, "Edit modelpath description", "Edit modelpath description file to configure modelpath definitions", null) [
					IDE.openEditor(PlatformUI.workbench.activeWorkbenchWindow.activePage, file)
				]
			}
			
		}
	}

//	@Fix(MyDslValidator::INVALID_NAME)
//	def capitalizeName(Issue issue, IssueResolutionAcceptor acceptor) {
//		acceptor.accept(issue, 'Capitalize name', 'Capitalize the name.', 'upcase.png') [
//			context |
//			val xtextDocument = context.xtextDocument
//			val firstLetter = xtextDocument.get(issue.offset, 1)
//			xtextDocument.replace(issue.offset, 1, firstLetter.toUpperCase)
//		]
//	}
	
//	@Fix(BaseJavaValidator::DUPLICATE_ANNOTATION_TARGETS)
//	def fixDuplicateAnnotationTarget(Issue issue, IssueResolutionAcceptor acceptor) {
//		acceptor.accept(issue, "Remove the duplicate target", "remove "+issue.data.get(0), "add.gif") [
//			element, context |
//				val at = element as AnnotationType
//				val it = at.getTargets().iterator();
//				while (it.hasNext()) {
//					val tgt = it.next()
//					if (tgt.equals(issue.data.get(0)))
//						it.remove()
//				}
//				at.getTargets().add(issue.data.get(0))
//		]
//	}
}
