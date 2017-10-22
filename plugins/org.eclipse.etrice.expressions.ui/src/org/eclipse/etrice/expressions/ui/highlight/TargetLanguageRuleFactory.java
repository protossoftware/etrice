/*******************************************************************************
 * Copyright (c) 2014 Jayant Gupta
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Jayant Gupta (initial contribution)
 * 		Juergen Haug
 *
 *******************************************************************************/

package org.eclipse.etrice.expressions.ui.highlight;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.NumberRule;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;

import com.google.common.collect.Lists;

/**
 * Rules for a {@link org.eclipse.jface.text.rules.RuleBasedScanner}. Beware of order of rules, when applying them, first wins.
 * <br>
 * 	<pre>
 *	tokenScanner = new RuleBasedScanner();
 *	tokenScanner.setRules(Iterables.toArray(
 *		Iterables.concat(
 *			TargetLanguageRuleFactory.getGeneralLiteralRules(styles),
 *			ExpressionRuleFactory.getInitialExpressionRules(exprProvider, styles),
 *			TargetLanguageRuleFactory.getGeneralKeywordRules(styles)
 *		)
 *	, IRule.class));
 *	</pre>
 */
public class TargetLanguageRuleFactory {

	// TODO split into different languages
	// general language keywords
	private static String[] fgKeywords = { "while", "do", "for", "if", "else",
		"break", "continue", "switch", "case", "default", "static", "return",
		"struct", "union", "sizeof", "explicit", "export", "extern", "goto",
		"this", "throw", "try", "catch", "new", "delete",
		"public", "private", "protected", "sizeof",
		"typedef", "virtual", "class", "using", "template", "volatile", "mutable", "friend", "inline",
		"typeid", "typename", "namespace",
		"const", "int", "float", "double", "short", "char", "long", "unsigned", "signed", "void", "true", "false"};
	
	protected static IWordDetector getKeywordDetector() {
		return new IWordDetector() {

			@Override
			public boolean isWordStart(char c) {
				return Character.isJavaIdentifierStart(c);
			}
	
			@Override
			public boolean isWordPart(char c) {
				return Character.isJavaIdentifierPart(c);
			}
		};
	}
	
	// TODO split into different languages
	public static List<IRule> getGeneralKeywordRules(AbstractHighlightStyles highlightStyle) {
		IToken defaultToken = new Token(highlightStyle.getDefault());
		WordRule wordRule = new WordRule(getKeywordDetector(), defaultToken);
		
		// Add rule for language keywords.
		List<IRule> rules = new ArrayList<IRule>();
		
		IToken keywordToken = new Token(highlightStyle.getTargetKeyword());
		for (int i = 0; i < fgKeywords.length; i++)
			wordRule.addWord(fgKeywords[i], keywordToken);
		rules.add(wordRule);
		
		return rules;
	}
	
	public static List<IRule> getGeneralLiteralRules(AbstractHighlightStyles highlightStyle) {
		List<IRule> rules = Lists.newArrayList();

		IToken stringToken = new Token(highlightStyle.getString());
		IToken commentToken = new Token(highlightStyle.getComment());
		IToken numberToken = new Token(highlightStyle.getNumber());

		// Add rule for single line comments.
		rules.add(new EndOfLineRule("//", commentToken));
		rules.add(new MultiLineRule("/*", "*/", commentToken));
		
		// Add rule for strings.
		rules.add(new SingleLineRule("\"", "\"", stringToken, '\\'));
		rules.add(new SingleLineRule("'", "'", stringToken, '\\'));
		
		rules.add(new NumberRule(numberToken));

		return rules;
	}
}
