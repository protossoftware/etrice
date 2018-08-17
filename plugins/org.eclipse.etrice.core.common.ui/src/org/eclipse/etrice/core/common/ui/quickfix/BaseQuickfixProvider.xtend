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

//import org.eclipse.xtext.ui.editor.quickfix.Fix
//import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
//import org.eclipse.xtext.validation.Issue

/**
 * Custom quickfixes.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#quickfixes
 */
class BaseQuickfixProvider extends DefaultQuickfixProvider {

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
