/*******************************************************************************
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer

import org.eclipse.etrice.ui.behavior.fsm.detailcode.IDetailExpressionProvider
import org.eclipse.etrice.ui.behavior.fsm.detailcode.IDetailExpressionProvider.ExpressionFeature
import org.eclipse.etrice.ui.behavior.fsm.detailcode.IDetailExpressionProvider.ExpressionPostfix
import org.eclipse.jface.text.BadLocationException
import org.eclipse.jface.text.IDocument
import org.eclipse.jface.text.rules.IWordDetector
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.util.Strings

@FinalFieldsConstructor
class DetailExpressionAssistParser {

	val IDocument document
	val int invocationOffset
	val IDetailExpressionProvider provider

	val IWordDetector anyIdScanner = new IWordDetector() {

		override isWordPart(char c) {
			Character.isJavaIdentifierPart(c)
		}

		override isWordStart(char c) {
			Character.isJavaIdentifierStart(c)
		}

	}

	def String computeIdentifierPrefix(int offset) throws BadLocationException {
		var start = offset - 1
		while (start >= 0 && anyIdScanner.isWordPart(document.getChar(start)))
			start--

		start++
		return document.get(start, offset - start)
	}

	def ExpressionFeature computeExpressionFeature(int offset) throws BadLocationException{
		var ExpressionPostfix postfixResult
		var char openingChar
		var char closingChar
		switch document.getChar(offset-1).toString {
			case ')': {
				postfixResult = ExpressionPostfix.PARENTHESES
				openingChar = '('
				closingChar = ')'
			}
			case ']': {
				postfixResult = ExpressionPostfix.BRACKETS
				openingChar = '['
				closingChar = ']'
			}
			default:
				postfixResult = ExpressionPostfix.NONE
		}

		var start = offset
		if (postfixResult != ExpressionPostfix.NONE) {
			start--
			var counter = 1
			while (start > 0 && counter > 0) {
				start--
				switch document.getChar(start) {
					case openingChar: counter--
					case closingChar: counter++
				}
			}
			if (counter > 0)
				postfixResult = null
		}

		var String idResult
		try {
			idResult = computeIdentifierPrefix(start)
		} catch (BadLocationException e) {
		}

		return new ExpressionFeature(idResult, postfixResult)
	}

	/**
	 *  Try to resolve latest complete ExpressionFeature, e.g.:
	 *  <ul>
	 * 	 <li>port0.m_ => port0</li>
	 *	<li> port0. => port0 </li>
	 * 	 <li>port0 => null</li>
	 *  </ul>
	 */
	def ExpressionFeature resolveLatestCompleted() {
		var lastSeparatorPos = invocationOffset - 1

		// skip invocationPrefix
		try {
			val invocationPrefix = computeIdentifierPrefix(invocationOffset)
			lastSeparatorPos -= invocationPrefix.length
		} catch (BadLocationException e) {
		}

		// backward parsing
		val parsedFeatures = newLinkedList
		try {
			while (document.getChar(lastSeparatorPos) == IDetailExpressionProvider.SEPARATOR) {
				val parseResult = computeExpressionFeature(lastSeparatorPos)
				if (!parseResult.isValid)
					return null
				parsedFeatures.push(parseResult)
				lastSeparatorPos -= (parseResult.id.length() + 1)

			}
		} catch (BadLocationException e) {
		}

		if (parsedFeatures.empty)
			return null

		// forward matching
		val firstParseResult = parsedFeatures.pop
		var lastMatch = provider.initialFeatures.findFirst[matches(firstParseResult)]
		while (lastMatch != null && !parsedFeatures.isEmpty()) {
			val nextParseResult = parsedFeatures.pop
			lastMatch = provider.getContextFeatures(lastMatch).findFirst[matches(nextParseResult)]
		}

		return lastMatch
	}

	/**
	 * non-empty id + not-null suffix
	 */
	private def boolean isValid(ExpressionFeature feature) {
		!Strings.isEmpty(feature.id) && feature.postfix != null
	}

	private def boolean matches(ExpressionFeature f1, ExpressionFeature f2) {
		f1.id == f2.id && f1.postfix == f2.postfix
	}

}
