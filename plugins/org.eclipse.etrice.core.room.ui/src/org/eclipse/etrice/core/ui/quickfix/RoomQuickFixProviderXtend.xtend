/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.core.ui.quickfix

import com.google.inject.Inject
import org.eclipse.emf.ecore.EClass
import org.eclipse.etrice.core.common.base.util.ImportHelpers
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue

class RoomQuickFixProviderXtend extends RoomQuickfixProvider {
	
	@Inject ImportHelpers importHelpers
	
	// override xtext linking issues
	override getResolutionsForLinkingIssue(Issue issue) {			
		val xtextDocument = modificationContextFactory.createModificationContext(issue).getXtextDocument	
		
		val resolutions = xtextDocument?.readOnly([ resource |
			val issueString = xtextDocument.get(issue.offset, issue.length)	
			val acceptor = issueResolutionAcceptorProvider.get
			createLinkingQuickFixes(issue, issueString, resource, acceptor)
			acceptor.issueResolutions
		])
		
		return (resolutions + super.getResolutionsForLinkingIssue(issue)).toList
	}
	
	// dispatch own linking issues
	protected def void createLinkingQuickFixes(Issue issue, String issueString, XtextResource resource, IssueResolutionAcceptor acceptor) {
		val target = resource.getEObject(issue.uriToProblem.fragment)
		val reference = getUnresolvedEReference(issue, target)		
		
		if(reference !== null) {
			createLinkingImports(issue, issueString, resource, reference.EReferenceType, false, acceptor);
		}
	}
	
	protected def void createLinkingImports(Issue issue, String issueString, XtextResource resource, EClass type, boolean wildcard, IssueResolutionAcceptor acceptor) {
		// try first import based on model path
		val elementImports = importHelpers.createModelPathImports(issueString, resource, type, false)
		elementImports.forEach[imp |
			acceptor.accept(issue, '''Import '«imp.importedNamespace»' ''', '', null) [elem, ctx |
				val model = EcoreUtil2.getContainerOfType(elem, RoomModel)
				model.imports += imp
			]
		]
		// fallback: old style imports with uri
		if(elementImports.empty) {
			importHelpers.createURIImports(issueString, type, resource.URI).forEach[imp |
				acceptor.accept(issue, '''Import namespace '«imp.importedNamespace»' from '«imp.importURI»' ''', '', null) [elem, ctx |
					val model = EcoreUtil2.getContainerOfType(elem, RoomModel)
					model.imports += imp
				]
			]
		}
	}
	
}