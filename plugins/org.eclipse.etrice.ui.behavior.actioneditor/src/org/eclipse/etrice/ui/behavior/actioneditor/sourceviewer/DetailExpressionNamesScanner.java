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

package org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider.ExpressionFeature;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class DetailExpressionNamesScanner extends RuleBasedScanner {
	
	// terminal ID: '^'?('a'..'z'|'A'..'Z'|'_')
	// ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
	public static IWordDetector getIDWordDetector() {
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

	private final WordRule wordRule;

	public DetailExpressionNamesScanner(ActionCodeEditorConfiguration configuration) {
		wordRule = new WordRule(getIDWordDetector());
		
		DetailExpressionUIProvider detailExprProv = configuration.getDetailExpressionProvider();
		ActionCodeColorManager colorMngr = configuration.getColorManager();
		Map<TextAttribute, TextAttribute> textAttributes = Maps.newHashMap();
		for(ExpressionFeature feature : detailExprProv.getInitialFeatures()){
			TextAttribute attr = new TextAttribute(colorMngr.getColor(detailExprProv.getColor(feature)));
			if(!textAttributes.containsKey(attr))
				textAttributes.put(attr, attr);
			IToken token = new Token(textAttributes.get(attr));
			wordRule.addWord(feature.getId(), token);
		}
		addRules(Lists.newArrayList((IRule)wordRule));
	}

	
	protected void addRules(List<IRule> rules){
		List<IRule> newRules = Lists.newArrayList();
		if(fRules != null)
			newRules.addAll(Arrays.asList(fRules));
		newRules.addAll(rules);
		setRules(newRules.toArray(new IRule[0]));
	}

}
