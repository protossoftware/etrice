/*******************************************************************************
 * Copyright (c) 2018 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.dctools.ast

import org.eclipse.etrice.generator.fsm.generic.IDetailCodeTranslator
import org.eclipse.etrice.core.fsm.fSM.DetailCode
import org.eclipse.etrice.dctools.ast.internal.DCTranslatorVisitor
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.etrice.generator.fsm.base.IFSMTranslationProvider
import org.eclipse.etrice.dctools.fsm.ast.DCLanguage
import org.eclipse.etrice.dctools.fsm.ast.DCParser
import org.eclipse.etrice.core.room.MessageData

class DCTranslator implements IDetailCodeTranslator {
	
	DCLanguage language
	ITranslationProvider translationProvider
	
	val extension RoomHelpers roomHelpers = new RoomHelpers
	
	new(DCLanguage language, ITranslationProvider translationProvider) {
		this.language = language
		this.translationProvider = translationProvider
	}
	
	override getTranslatedCode(DetailCode dc) {
		return getTranslatedCode(dc, null)
	}
	
	def getTranslatedCode(DetailCode dc, MessageData transitionData) {
		var code = dc.detailCode

		// before the actual parsing is done we translate tags
		if (translationProvider.translateTags) {
			code = translateTags(code, dc)
		}
		
		// parse
		val parser = new DCParser(language)
		val ast = parser.parse(code)
		
		// link
		val linker = new DCLinker(dc, transitionData)
		ast.visit(linker)
		
		// translate
		val visitor = new DCTranslatorVisitor(translationProvider)
		ast.visit(visitor)
		
		return visitor.translatedCode
	}
	
	def translateTags(String text, DetailCode dc) {
		val result = new StringBuilder
		
		var int last = 0
		var int next = text.indexOf(IFSMTranslationProvider.TAG_START, last)
		while (next >= 0) {
			result.append(text.substring(last, next))
			last = next + IFSMTranslationProvider.TAG_START.length()
			next = text.indexOf(IFSMTranslationProvider.TAG_END, last)
			if (next >= 0) {
				val String tag = text.substring(last, next)
				result.append(translationProvider.translateTag(tag, dc))
				last = next + IFSMTranslationProvider.TAG_END.length()
				next = text.indexOf(IFSMTranslationProvider.TAG_START, last)
			}
		}
		result.append(text.substring(last))

		return result.toString
	}
	
}