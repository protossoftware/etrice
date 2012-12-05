/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.etphys.formatting;

import org.eclipse.etrice.core.etphys.services.ETPhysGrammarAccess;
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
public class ETPhysFormatter extends AbstractDeclarativeFormatter {
	
	@Override
	protected void configureFormatting(FormattingConfig c) {
		ETPhysGrammarAccess f = (ETPhysGrammarAccess) getGrammarAccess();

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
		
		for (Keyword k: f.findKeywords("runtime","execmode", "prio", "stacksize")) {
			c.setLinewrap().before(k);
		}
		
		c.setLinewrap(1).after(f.getImportRule());

		c.setLinewrap(2).after(f.getPhysicalSystemRule());
		c.setLinewrap(2).after(f.getNodeClassRule());
		c.setLinewrap(2).after(f.getRuntimeClassRule());
		
		c.setLinewrap(1).after(f.getNodeRefRule());
		c.setLinewrap(1).around(f.getPhysicalThreadRule());
	}
}
