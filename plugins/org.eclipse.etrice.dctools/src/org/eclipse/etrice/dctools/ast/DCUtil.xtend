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

package org.eclipse.etrice.dctools.ast

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.converter.RoomValueConverterService
import org.eclipse.etrice.core.fsm.fSM.DetailCode
import org.eclipse.etrice.core.fsm.fSM.TransitionBase
import org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.MessageData
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.dctools.GenModelAccess
import org.eclipse.etrice.dctools.ast.internal.DCProposalConfig
import org.eclipse.etrice.dctools.fsm.ast.CandidateMap
import org.eclipse.etrice.dctools.fsm.ast.DCLanguage
import org.eclipse.etrice.dctools.fsm.ast.DCNodeAtOffset
import org.eclipse.etrice.dctools.fsm.ast.DCParser
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstIdentifierNode
import org.eclipse.jface.text.contentassist.ICompletionProposal
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.INode

class DCUtil {
	
	@Accessors
	static class FindResult {
		val EObject object
		val int begin
		val int length
	}
	
	@Inject RoomValueConverterService converterService
	@Inject DCProposalConfig proposalConfig
	@Inject GenModelAccess genModelAccess
	
	DCLanguage language = DCLanguage.C_LANGUAGE
	
	new() {
	}
	
	def setLanguage(DCLanguage language) {
		this.language = language
	}
	
	def FindResult findAtOffset(ILeafNode textNode, int offset) {
		val ast = textNode.parseAndLink
		val astNode = DCNodeAtOffset.find(ast, offset - textNode.delimiterAdjustedOffset)
		if (astNode instanceof DCAstIdentifierNode) {
			val object = getLinkedObject(astNode)
			if (object !==null) {
				return new FindResult(object, astNode.begin + converterService.CC_StringConverter.delim.length, astNode.end-astNode.begin)
			}
		}
		return null
	}
	
	def getDelimiterAdjustedOffset(INode astNode) {
		astNode.offset + converterService.CC_StringConverter.delim.length
	}
	
	def parseAndLink(INode astNode) {
		val text = converterService.CC_StringConverter.stripDelim(astNode.getText());
		val parser = new DCParser(language)
		val ast = parser.parse(text)
		
		if (astNode.parent.semanticElement instanceof DetailCode) {
			val dc = astNode.parent.semanticElement as DetailCode
			
			var DCLinker linker = null;
			
			// lets check whether we have a transition and determine common data
			val transition = EcoreUtil2.getContainerOfType(dc, TransitionBase)
			if (transition!==null) {
				val roomClass = EcoreUtil2.getContainerOfType(dc, RoomClass)
				if (roomClass instanceof ActorClass) {
					genModelAccess.clearCache
					val gc = genModelAccess.get(roomClass)
					val link = FsmGenExtensions.getLinkFor(gc, transition)
					if (link!==null) {
						linker = new DCLinker(dc, link.commonData as MessageData)
					}
				}
			}
			
			// if we have no common data we use a plain linker
			if (linker===null) {
				linker = new DCLinker(dc)
			}
			
			ast.visit(linker)
			
			return ast
		}
		else {
			return null
		}
	}
	
	def List<ICompletionProposal> getProposals(INode textNode, int offset) {
		val ast = textNode.parseAndLink
		// note: we subtract 1 to get the token to the left of the caret
		val astNode = DCNodeAtOffset.find(ast, offset - textNode.delimiterAdjustedOffset - 1)
		if (astNode instanceof DCAstIdentifierNode) {
			val candidates = astNode.candidates
			if (candidates!==null) {
				val begin = astNode.begin + converterService.CC_StringConverter.delim.length
				val end = offset - textNode.offset
				val prefix = textNode.text.substring(begin, end)
				val matches = candidates.getMatches(prefix)
				return matches.entrySet.map[match | proposalConfig.doCreateProposal(prefix, match.key, match.value, offset)].toList
			}
		}
		
		newArrayList
	}
	
	static def EObject getLinkedObject(DCAstIdentifierNode astNode) {
		if (astNode.linkedObject!==null) {
			astNode.linkedObject
		}
		else if (astNode.parent!==null) {
			astNode.parent.linkedObject
		}
	}
	
	static def CandidateMap getCandidates(DCAstIdentifierNode astNode) {
		if (astNode.linkedData instanceof CandidateMap) {
			astNode.linkedData as CandidateMap
		}
		else if (astNode.parent!==null && astNode.parent.linkedData instanceof CandidateMap) {
			astNode.parent.linkedData as CandidateMap
		}
	}
}
