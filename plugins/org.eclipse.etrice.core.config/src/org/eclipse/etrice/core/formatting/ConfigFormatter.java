/*******************************************************************************
 * Copyright (c) 2012 Juergen Haug
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.formatting;

import org.eclipse.etrice.core.services.ConfigGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.util.Pair;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class ConfigFormatter extends AbstractDeclarativeFormatter {
	
	@Override
	protected void configureFormatting(FormattingConfig c) {
		ConfigGrammarAccess f = (ConfigGrammarAccess) getGrammarAccess();

		// general
		
		c.setAutoLinewrap(120);
		c.setLinewrap(1).before(f.getSL_COMMENTRule());
		c.setLinewrap(2).before(f.getML_COMMENTRule());
		
		for (Pair<Keyword, Keyword> pair : f.findKeywordPairs("{", "}")) {
			c.setLinewrap().after(pair.getFirst());
			c.setIndentationIncrement().after(pair.getFirst());
			c.setLinewrap().before(pair.getSecond());
			c.setIndentationDecrement().before(pair.getSecond());
			c.setSpace(" ").between(pair.getFirst(), pair.getSecond());
		}		
	
		for (Keyword k: f.findKeywords("(", "|", ".", "*")) {
			c.setNoSpace().around(k);
		}
		
		for (Keyword k: f.findKeywords("<", "~")) {
			c.setNoSpace().after(k);
		}
		for (Keyword k: f.findKeywords(")", ">", ",", ":")) {
			c.setNoSpace().before(k);
		}
		
		for (Keyword k: f.findKeywords("regular","conjugate")) {
			c.setLinewrap().before(k);
		}
		
		c.setLinewrap(1).after(f.getImportRule());
		
		c.setLinewrap(2).around(f.getActorClassConfigRule());
		c.setLinewrap(2).around(f.getProtocolClassConfigRule());
		c.setLinewrap(2).around(f.getActorInstanceConfigRule());
		
		c.setLinewrap(1).around(f.getAttrClassConfigRule());
		c.setLinewrap(1).around(f.getAttrInstanceConfigRule());
		c.setLinewrap(1).around(f.getPortInstanceConfigRule());
	}
}
