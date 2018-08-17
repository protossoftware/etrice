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

package org.eclipse.etrice.dctools.ast.internal

import com.google.inject.Singleton
import com.google.inject.Inject
import org.eclipse.jface.viewers.ILabelProvider
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.viewers.StyledString
import org.eclipse.swt.graphics.Image
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher
import org.eclipse.jface.text.contentassist.ICompletionProposal
import org.eclipse.swt.graphics.Point
import org.eclipse.etrice.core.room.Operation
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.InterfaceItem
import org.eclipse.etrice.core.room.Port

@Singleton
class DCProposalConfig {

	@Inject
	protected ILabelProvider labelProvider

	@Inject
	protected RoomHelpers roomHelpers
	
	@Inject
	protected PrefixMatcher prefixMatcher
	
	def ICompletionProposal doCreateProposal(String prefix, String proposal, EObject object, int globalOffset) {
		new ConfigurableCompletionProposal(proposal, globalOffset - prefix.length, prefix.length, proposal.length, object.image, object.displayString, null, null) => [
			matcher = prefixMatcher
			autoInsertable = false
			// TODO adjust length to existing text
			replaceContextLength = proposal.length
		]
	}

	def Pair<String, Point> getPostfixReplacement(EObject object) {
		val brackets = switch object {
			Operation,
			Message:
				#['(', ')']
			
			Attribute case object.size>0,
			Port case object.multiplicity>0:
				#['[', ']']
		}
		
		if (brackets===null) {
			return "" -> null
		}
		
		val replacement = switch object {
			Operation:
				object.arguments.map[name].join(', ')
			
			Message case object.data !== null:
				object.data.refType.type.name
			
			Attribute, // fall through
			InterfaceItem:
				'0'
			
			default:
				''
		}

		replacement.wrap(brackets.head, brackets.last)
	}
	
	private def Pair<String, Point> wrap(String text, String left, String right) {
		val selection = if (!text.empty) new Point(1, text.length)
		left + text + right -> selection
	}
	
	private def StyledString getDisplayString(EObject object) {
		
	}	

	private def Image getImage(EObject object) {
		
	}	
}