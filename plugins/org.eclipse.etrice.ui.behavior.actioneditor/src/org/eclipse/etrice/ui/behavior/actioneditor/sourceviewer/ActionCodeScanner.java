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

package org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;

/**
 * A extension of the {@link RuleBasedScanner} for
 * {@link ActionCodeEditorConfiguration}. Sets up rules for identifying and
 * associating tokens with Members and InterfaceItems.
 * <p>
 * Sub-classes may override {@link #computeRules(ActionCodeEditorConfiguration)}
 * to supply new rules or add to the given rules.
 * </p>
 * 
 * @author jayant
 * 
 */
public class ActionCodeScanner extends RuleBasedScanner {

	/** the default word rule for the scanner */
	WordRule wordRule;

	public ActionCodeScanner(ActionCodeEditorConfiguration configuration) {
		// form an instance of the WordRule
		IToken defaultToken = new Token(new TextAttribute(configuration
				.getColorManager().getColor(ActionCodeColorManager.DEFAULT)));
		wordRule = formWordRule(defaultToken);

		List<IRule> rules = computeRules(configuration);
		setRules(rules.toArray(new IRule[rules.size()]));
	}

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
		IToken memberToken = new Token(new TextAttribute(configuration
				.getColorManager().getColor(ActionCodeColorManager.MEMBER)));
		IToken interfaceItemToken = new Token(new TextAttribute(configuration
				.getColorManager().getColor(
						ActionCodeColorManager.INTERFACE_ITEM), null, SWT.BOLD));

		List<IRule> rules = new ArrayList<IRule>();

		// Add words to wordRule for each Interface Item names.
		if (configuration.isMessageAware())
			for (String item : configuration.getActionCodeParser()
					.getAllInterfaceItemNames())
				wordRule.addWord(item, interfaceItemToken);

		// Add word to wordRule rule for each Member names.
		if (configuration.isMemberAware())
			for (String member : configuration.getActionCodeParser()
					.getAllAttributeNames())
				wordRule.addWord(member, memberToken);

		// Add wordRule to the list of rules.
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

	/**
	 * Get the default {@link WordRule}.
	 * 
	 * @return the default word rule.
	 */
	public WordRule getWordRule() {
		return wordRule;
	}
}