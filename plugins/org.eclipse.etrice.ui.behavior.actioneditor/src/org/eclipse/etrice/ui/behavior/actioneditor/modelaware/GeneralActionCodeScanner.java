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

import org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer.ActionCodeEditorConfiguration;
import org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer.ActionCodeScanner;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;

/**
 * Extends {@link ActionCodeScanner} with rules to identify general language
 * features.
 * 
 * @author jayant
 */
public class GeneralActionCodeScanner extends ActionCodeScanner {

	public GeneralActionCodeScanner(ActionCodeEditorConfiguration configuration) {
		super(configuration);
	}

	// general language keywords
	private static String[] fgKeywords = { "while", "for", "if", "else" };

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List<IRule> computeRules(
			ActionCodeEditorConfiguration configuration) {
		List<IRule> rules = super.computeRules(configuration);

		IToken keywordToken = new Token(new TextAttribute(configuration
				.getColorManager().getColor(
						GeneralActionCodeColorManager.KEYWORD)));
		IToken stringToken = new Token(new TextAttribute(configuration
				.getColorManager().getColor(
						GeneralActionCodeColorManager.STRING)));
		IToken commentToken = new Token(new TextAttribute(configuration
				.getColorManager().getColor(
						GeneralActionCodeColorManager.SINGLE_LINE_COMMENT)));

		// Add rule for single line comments.
		rules.add(new EndOfLineRule("//", commentToken));

		// Add rule for strings.
		rules.add(new SingleLineRule("\"", "\"", stringToken, '\\'));
		rules.add(new SingleLineRule("'", "'", stringToken, '\\'));

		// Add rule for language keywords.
		WordRule wordRule = getWordRule();
		for (int i = 0; i < fgKeywords.length; i++)
			wordRule.addWord(fgKeywords[i], keywordToken);

		return rules;
	}
}