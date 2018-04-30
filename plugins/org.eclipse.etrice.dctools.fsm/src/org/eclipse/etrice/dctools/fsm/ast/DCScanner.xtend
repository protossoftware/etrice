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

package org.eclipse.etrice.dctools.fsm.ast

import com.google.common.collect.Iterables
import org.eclipse.etrice.dctools.fsm.ast.internal.DCKeywordRule
import org.eclipse.etrice.dctools.fsm.ast.internal.DCToken
import org.eclipse.etrice.dctools.fsm.ast.internal.DCToken.Kind
import org.eclipse.etrice.dctools.fsm.ast.internal.DCWhitespaceDetector
import org.eclipse.jface.text.rules.EndOfLineRule
import org.eclipse.jface.text.rules.IRule
import org.eclipse.jface.text.rules.MultiLineRule
import org.eclipse.jface.text.rules.NumberRule
import org.eclipse.jface.text.rules.RuleBasedScanner
import org.eclipse.jface.text.rules.SingleLineRule
import org.eclipse.jface.text.rules.WhitespaceRule
import org.eclipse.etrice.dctools.fsm.ast.internal.DCIdentifierRule
import org.eclipse.etrice.dctools.fsm.ast.internal.DCBracketRule
import org.eclipse.etrice.dctools.fsm.ast.internal.DCSpecialCharRule
import org.eclipse.jface.text.rules.IToken
import org.eclipse.jface.text.rules.Token
import org.eclipse.etrice.dctools.fsm.ast.internal.DCTextToken
import org.eclipse.jface.text.Document

class DCScanner {
	
	val RuleBasedScanner scanner = new RuleBasedScanner
	DCLanguage language
	
	new(DCLanguage language) {
		this.language = language
		
		// initialize scanner with rules
		scanner.rules = rules
	}
	
	def scan(String text) {
		val result = newArrayList
		
		scanner.setRange(new Document(text), 0, text.length())
		
		var IToken lastToken = null 
		while (lastToken !== Token.EOF) {
			lastToken = scanner.nextToken() 
			if (lastToken !== null) {
				val begin = scanner.tokenOffset
				val end = begin + scanner.tokenLength
				if (begin >= 0 && begin < end) {
					if (lastToken instanceof DCToken) {
						result.add(new DCTextToken(begin, scanner.tokenLength, lastToken))
					}
					else {
						result.add(new DCTextToken(begin, scanner.tokenLength, new DCToken(Kind.OTHER)))
					}
				}
			}
		}
		
		return result
	}
	
	private def getRules() {
		val rules = newArrayList
		
		// rules for comments (also unclosed C-comments)
		rules.add(new EndOfLineRule("//", new DCToken(Kind.COMMENT)))
		rules.add(new MultiLineRule("/*", "*/", new DCToken(Kind.COMMENT), 0 as char, true))
		
		// rules for strings
		rules.add(new SingleLineRule("\"", "\"", new DCToken(Kind.STRING), '\\'))
		rules.add(new SingleLineRule("'", "'", new DCToken(Kind.STRING), '\\'))
		// multiline or unclosed strings (which may occur during editing)
		rules.add(new MultiLineRule("\"", "\"", new DCToken(Kind.STRING), '\\', true))
		rules.add(new MultiLineRule("'", "'", new DCToken(Kind.STRING), '\\', true))
		
		// keywords, numbers and IDs
		rules.add(new NumberRule(new DCToken(Kind.NUMBER)))
		if (language!==DCLanguage.OTHER_LANGUAGE) {
			rules.add(new DCKeywordRule(language))
		}
		rules.add(new DCIdentifierRule)
		
		// whitespace, brackets and special characters
		rules.add(new WhitespaceRule(new DCWhitespaceDetector, new DCToken(Kind.WHITESPACE)))
		rules.add(new DCBracketRule)
		rules.add(new DCSpecialCharRule)
		
		Iterables.toArray(rules, IRule)
	}
}