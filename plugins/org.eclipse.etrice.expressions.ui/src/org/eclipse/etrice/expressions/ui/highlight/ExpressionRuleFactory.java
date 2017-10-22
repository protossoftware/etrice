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

package org.eclipse.etrice.expressions.ui.highlight;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider;
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider.ExpressionFeature;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IWordDetector;
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
public class ExpressionRuleFactory {

	// terminal ID: '^'?('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
	protected static IWordDetector getIDWordDetector() {
		return new IWordDetector() {

			@Override
			public boolean isWordStart(char c) {
				return Character.isLowerCase(c) || Character.isUpperCase(c) || c == '_';
			}

			@Override
			public boolean isWordPart(char c) {
				return isWordStart(c) || Character.isDigit(c);
			}
		};
	}
	
	public static List<IRule> getInitialExpressionRules(IDetailExpressionProvider exprProvider, AbstractHighlightStyles highlightStyle) {		
		WordRule wordRule = new WordRule(getIDWordDetector());
		
		Set<String> ids = new HashSet<>();
		for(ExpressionFeature feature : exprProvider.getInitialFeatures()){
			if(ids.add(feature.getId()))
				wordRule.addWord(feature.getId(), new Token(highlightStyle.getStyle(feature)));
		}
		
		return Lists.newArrayList(wordRule);
	}
}
