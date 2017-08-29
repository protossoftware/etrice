/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
			val replacement = ccIndent.replaceEditorIndentation(context.getIndentationString(context.indentation + 1)) +
				endIndent
			context => [
				addReplacement(region.replaceWith(converter.delim + replacement + converter.delim))
			]
		}
		return context
	}
}
