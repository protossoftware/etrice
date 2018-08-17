/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.formatting;

import org.eclipse.etrice.generator.services.FSMtestGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class FSMtestFormatter extends AbstractDeclarativeFormatter {
	
	@Override
	protected void configureFormatting(FormattingConfig c) {
		FSMtestGrammarAccess grammarAccess = (FSMtestGrammarAccess) getGrammarAccess();
		c.setLinewrap(0, 1, 2).before(grammarAccess.getSL_COMMENTRule());
		c.setLinewrap(0, 1, 2).before(grammarAccess.getML_COMMENTRule());
		c.setLinewrap(0, 1, 1).after(grammarAccess.getML_COMMENTRule());

		for (Keyword k: grammarAccess.findKeywords(";")) {
			c.setIndentationDecrement().before(k);
			c.setLinewrap().before(k);
		}
		
		for (Keyword k: grammarAccess.findKeywords("initial","state","constraints:", "condition", "transition", 
				"trigger:", "guards:", "fsm:", "loops:", "randseed:", "precondition", "postcondition", "randomtest")) {
			c.setLinewrap().before(k);
		}
		
		for (Keyword k: grammarAccess.findKeywords("randomtest", "fsmdefinition")) {
			c.setIndentationIncrement().after(k);
			c.setLinewrap(2).before(k);
		}
		
		for (Keyword k: grammarAccess.findKeywords("state", "transition")) {
			c.setIndentationIncrement().after(k);
		}

		for (Keyword k: grammarAccess.findKeywords(".")) {
			c.setNoSpace().around(k);
		}

		for (Keyword k: grammarAccess.findKeywords("initial")) {
			c.setNoLinewrap().after(k);
		}
		
		c.setIndentationIncrement().before(grammarAccess.getPostconditionDeclarationRule());
		c.setIndentationDecrement().after(grammarAccess.getPostconditionDeclarationRule());
		c.setLinewrap().before(grammarAccess.getPostconditionDeclarationRule());
		
		c.setIndentationIncrement().before(grammarAccess.getPreconditionDeclarationRule());
		c.setIndentationDecrement().after(grammarAccess.getPreconditionDeclarationRule());
		c.setLinewrap().before(grammarAccess.getPreconditionDeclarationRule());
		
		c.setIndentationIncrement().before(grammarAccess.getConditionDeclarationRule());
		c.setIndentationDecrement().after(grammarAccess.getConditionDeclarationRule());
		c.setLinewrap().before(grammarAccess.getConditionDeclarationRule());
		
		c.setIndentationIncrement().before(grammarAccess.getGuardDeclarationRule());
		c.setIndentationDecrement().after(grammarAccess.getGuardDeclarationRule());
		c.setLinewrap().before(grammarAccess.getGuardDeclarationRule());
	}
}
