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
import java.nio.file.Files
import java.nio.file.Paths
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Path
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.etrice.core.common.base.BaseFactory
import org.eclipse.etrice.core.common.scoping.RelativeFileURIHandler
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue

import static org.eclipse.xtext.EcoreUtil2.getContainerOfType
import static org.eclipse.etrice.core.room.RoomPackage.Literals.*

class RoomQuickFixProviderXtend extends RoomQuickfixProvider {
	
	@Inject IResourceDescriptions resourceDescriptions
	
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
			// import by namespace per default
			importQuickfixNamespace(issueString, reference.EReferenceType, issue, acceptor)		
			// import by element
			if(reference == ACTOR_CLASS) {
				importQuickfixElement(issueString, reference.EReferenceType, issue, acceptor)
			}
		}
	}
	
	protected def void importQuickfixNamespace(String issueString, EClass type, Issue issue, IssueResolutionAcceptor acceptor) {
		resourceDescriptions.getExportedObjectsByType(type).filter[name.lastSegment.equalsIgnoreCase(issueString)].forEach [ eObjDesc |
			acceptor.accept(issue, '''Import namespace '«eObjDesc.qualifiedName.skipLast(1)»' from '«eObjDesc.EObjectURI.lastSegment»' ''', '', null) [elem, ctx |
				val model = getContainerOfType(elem, RoomModel)
				model.imports += BaseFactory.eINSTANCE.createImport => [
					importedNamespace = eObjDesc.qualifiedName.skipLast(1) + '.*'
					importURI = computeImportURIString(model.eResource.URI, eObjDesc.EObjectURI)
				]
			]
		]
	}
	
	protected def void importQuickfixElement(String issueString, EClass type, Issue issue, IssueResolutionAcceptor acceptor) {
		resourceDescriptions.getExportedObjectsByType(type).filter[name.lastSegment.equalsIgnoreCase(issueString)].forEach [ eObjDesc |
			acceptor.accept(issue, '''Import '«eObjDesc.qualifiedName»' from '«eObjDesc.EObjectURI.lastSegment»' ''', '', null) [elem, ctx |
				val model = getContainerOfType(elem, RoomModel)
				model.imports += BaseFactory.eINSTANCE.createImport => [
					importedNamespace = eObjDesc.qualifiedName.toString
					importURI = computeImportURIString(model.eResource.URI, eObjDesc.EObjectURI)
				]
			]
		]
	}
	
	private def String computeImportURIString(URI base, URI toImport) {
		val trimmedBase = base.trimQuery.trimFragment
		val trimmedImport = toImport.trimQuery.trimFragment
		
		val fileHandler = new RelativeFileURIHandler => [baseURI = trimmedBase]
		val resolvedRelative= fileHandler.deresolve(trimmedImport)
		
		// same project => relative
		if(base.platformResource && toImport.platformResource && base.segment(1) == toImport.segment(1)) {
			// check if exists
			val baseLocation = ResourcesPlugin.workspace.root.getFile(new Path(base.trimSegments(1).toPlatformString(false))).location.toFile.absolutePath			
			if(resolvedRelative.isRelative && Files.exists(Paths.get(baseLocation, resolvedRelative.toString))) {
				return resolvedRelative.toString
			} else {
				return trimmedImport.toString
			}
		}
		
		// both in workspace => platform resource
		if(base.platformResource && toImport.platformResource) {
			trimmedImport.toString
		} else {	
			// else file 
			resolvedRelative.toString	
		}
	}
}