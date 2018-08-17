/*******************************************************************************
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer

import org.eclipse.jface.text.IDocument
import org.eclipse.jface.text.contentassist.ICompletionProposal
import org.eclipse.swt.graphics.Point
import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

// Default implementation CompletionProposal is final, thus use as delegate
@FinalFieldsConstructor
class CustomCompletionProposal implements ICompletionProposal {

	@Delegate
	val ICompletionProposal delegate
	val Point selection
	
	override Point getSelection(IDocument document){
		if(selection !== null) selection else delegate.getSelection(document)
	}
}
