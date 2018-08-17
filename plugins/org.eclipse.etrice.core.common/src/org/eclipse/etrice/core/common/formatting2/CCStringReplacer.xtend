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
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.formatting2

import org.eclipse.etrice.core.common.converter.CCStringConverter
import org.eclipse.etrice.core.common.converter.CCStringIndentation
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.formatting2.ITextReplacerContext
import org.eclipse.xtext.formatting2.internal.AbstractTextReplacer

@FinalFieldsConstructor
class CCStringReplacer extends AbstractTextReplacer {

	val CCStringConverter converter

	override createReplacements(ITextReplacerContext context) {
		if (region.multiline) {
			val ccIndent = new CCStringIndentation(converter.stripDelim(region.text.trim))
			val endIndent = if(ccIndent.ignoreLast) context.indentationString else ''
			val indentInc = context.getIndentationString(context.indentation + 1)
			val replacement = ccIndent.replaceEditorIndentation(indentInc, context.getNewLinesString(1)) + endIndent
			context => [
				addReplacement(region.replaceWith(converter.delim + replacement + converter.delim))
			]
		}
		return context
	}
}
