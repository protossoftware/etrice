/*******************************************************************************
 * Copyright (c) 2014 Jayant Gupta
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Jayant Gupta (initial contribution)
 *
 *
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.actioneditor.modelaware;

import java.util.List;

import org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer.ActionCodeColorManager;
import org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer.ActionCodeEditorConfiguration;
import org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer.DetailExpressionNamesScanner;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.NumberRule;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;

import com.google.common.collect.Lists;

/**
 * Extends {@link ActionCodeScanner} with rules to identify general language
 * features.
 * 
 * @author jayant
 */
public class GeneralActionCodeScanner extends DetailExpressionNamesScanner {

	protected ActionCodeEditorConfiguration configuration;
	private WordRule wordRule;
	
	public GeneralActionCodeScanner(ActionCodeEditorConfiguration configuration) {
		super(configuration);
		this.configuration = configuration;
		
		// form an instance of the WordRule
		IToken defaultToken = new Token(new TextAttribute(configuration
				.getColorManager().getColor(ActionCodeColorManager.DEFAULT)));
		wordRule = formWordRule(defaultToken);
		
		addRules(computeRules(configuration));
	}

	// general language keywords
	private static String[] fgKeywords = { "while", "do", "for", "if", "else",
		"break", "continue", "switch", "case", "default", "static", "return",
		"struct", "union", "sizeof", "explicit", "export", "extern", "goto",
		"this", "throw", "try", "catch", "new", "delete",
		"public", "private", "protected", "sizeof",
		"typedef", "virtual", "class", "using", "template", "volatile", "mutable", "friend", "inline",
		"typeid", "typename", "namespace",
		"const", "int", "float", "double", "short", "long", "unsigned", "signed", "void", "true", "false"};

	/**
	 * Computes and returns a list({@code not null}) of rules for this scanner.
	 * <p>
	 * Sub-classes may override. To add new rules, append the list supplied by
	 * the superclass. To add new words to the default {@link WordRule}, the
	 * reference of the wordRule could be obtained with {@link #getWordRule()}
	 * method.
	 * </p>
	 * 
	 * @param configuration
	 *            the {@link ActionCodeEditorConfiguration} for this scanner
	 * @return the list of rules formed
	 */
	protected List<IRule> computeRules(
			ActionCodeEditorConfiguration configuration) {
		List<IRule> rules = Lists.newArrayList();

		IToken keywordToken = new Token(new TextAttribute(configuration
				.getColorManager().getColor(
						GeneralActionCodeColorManager.TARGET_KEYWORD), null, SWT.BOLD));
		IToken stringToken = new Token(new TextAttribute(configuration
				.getColorManager().getColor(
						GeneralActionCodeColorManager.STRING)));
		IToken commentToken = new Token(new TextAttribute(configuration
				.getColorManager().getColor(
						GeneralActionCodeColorManager.COMMENT)));
		IToken numberToken = new Token(new TextAttribute(configuration
				.getColorManager().getColor(
						GeneralActionCodeColorManager.NUMBER)));

		// Add rule for single line comments.
		rules.add(new EndOfLineRule("//", commentToken));

		// TODO adjust Damager and Repairer for multi line support
		//rules.add(new MultiLineRule("/*", "*/", commentToken));
		
		// Add rule for strings.
		rules.add(new SingleLineRule("\"", "\"", stringToken, '\\'));
		rules.add(new SingleLineRule("'", "'", stringToken, '\\'));
		
		rules.add(new NumberRule(numberToken));

		// Add rule for language keywords.
		for (int i = 0; i < fgKeywords.length; i++)
			wordRule.addWord(fgKeywords[i], keywordToken);
		rules.add(wordRule);

		return rules;
	}
	
	/**
	 * Forms the default {@link WordRule} given the defaultToken.
	 * <p>
	 * Subclasses may override to customize the formation of the default Word
	 * Rule.
	 * </p>
	 * 
	 * @param defaultToken
	 *            the default token to be associated with the word rule
	 * @return the constructed WordRule instance.
	 */
	protected WordRule formWordRule(IToken defaultToken) {
		WordRule wordRule = new WordRule(new IWordDetector() {

			@Override
			public boolean isWordStart(char c) {
				return Character.isJavaIdentifierStart(c);
			}

			@Override
			public boolean isWordPart(char c) {
				return Character.isJavaIdentifierPart(c);
			}
		}, defaultToken);

		return wordRule;
	}
}
