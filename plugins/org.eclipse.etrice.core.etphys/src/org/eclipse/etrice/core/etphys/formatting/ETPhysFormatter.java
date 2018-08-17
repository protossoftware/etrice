/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
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
//		Set<String> keywords = GrammarUtil.getAllKeywords(grammar.getGrammar());
//		System.out.println("etPhys keywords:");
//		for (String kw : keywords) {
//			System.out.println(kw+",");
//		}
		
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
		
		for (Keyword k: f.findKeywords("runtime","priomin", "priomax", "execmode", "interval", "prio", "stacksize", "msgblocksize", "msgpoolsize")) {
			c.setLinewrap().before(k);
		}
		
		c.setLinewrap(1).around(f.getImportRule());

		
		c.setLinewrap(2).around(f.getPhysicalSystemRule());
		c.setLinewrap(2).around(f.getNodeClassRule());
		c.setLinewrap(2).around(f.getRuntimeClassRule());
		
		c.setLinewrap(1).around(f.getNodeRefRule());
		c.setLinewrap(1).around(f.getPhysicalThreadRule());
	}
}
