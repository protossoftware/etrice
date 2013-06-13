/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.formatting;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.util.Pair;


/**
 * @author Herward Ahlheit 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class RoomFormatter extends AbstractDeclarativeFormatter {
	
	@Override
	protected void configureFormatting(FormattingConfig c) {
		org.eclipse.etrice.core.services.RoomGrammarAccess f = (org.eclipse.etrice.core.services.RoomGrammarAccess) getGrammarAccess();

		// general
//		Set<String> keywords = GrammarUtil.getAllKeywords(grammar.getGrammar());
//		for (String kw : keywords) {
//			System.out.println(kw+",");
//		}
		 
		c.setAutoLinewrap(120);
		c.setLinewrap(2).before(f.getSL_COMMENTRule());
		c.setLinewrap(2).before(f.getML_COMMENTRule());
		
		for (Pair<Keyword, Keyword> pair : f.findKeywordPairs("{", "}")) {
			c.setLinewrap().after(pair.getFirst());
			c.setIndentationIncrement().after(pair.getFirst());
			c.setLinewrap().before(pair.getSecond());
			c.setIndentationDecrement().before(pair.getSecond());
			c.setSpace(" ").between(pair.getFirst(), pair.getSecond());
		}		
	
		for (Keyword k: f.findKeywords("(", "|", ".", "*", "/")) {
			c.setNoSpace().around(k);
		}
		
		for (Keyword k: f.findKeywords("<", "~")) {
			c.setNoSpace().after(k);
		}
		for (Keyword k: f.findKeywords(")", ">", ",", ":")) {
			c.setNoSpace().before(k);
		}
		
		for (Keyword k: f.findKeywords("entry", "exit", "StateMachine", "subgraph", "action", "cond", "regular", "conjugated",
				"incoming", "outgoing", "ServiceImplementation", "SubProtocol", "Structure", "Behavior", "Interface", "usercode", "usercode1", "usercode2")) {
			c.setLinewrap().before(k);
		}
		
		c.setLinewrap(2).around(f.getImportRule());
		
		
		// classes
		c.setLinewrap(2).around(f.getLogicalSystemRule());
		c.setLinewrap(2).around(f.getSubSystemClassRule());
		c.setLinewrap(2).around(f.getActorClassRule());
		c.setLinewrap(2).around(f.getDataClassRule());
		c.setLinewrap().around(f.getPrimitiveTypeRule());
		c.setLinewrap().around(f.getExternalTypeRule());
		c.setLinewrap(2).around(f.getProtocolClassRule());
		
		c.setLinewrap().around(f.getActorInstanceMappingRule());
		
		// structure classes
		c.setLinewrap().around(f.getActorRefRule());
		c.setLinewrap().around(f.getSubSystemRefRule());
		c.setLinewrap().around(f.getLayerConnectionRule());
		
		//"Interface"
		//c.setLinewrap().before(f.getActorClassAccess().getInterfaceKeyword_5_0());
		
		c.setLinewrap().around(f.getPortRule());
		c.setLinewrap().around(f.getExternalPortRule());
		c.setLinewrap().around(f.getLogicalThreadRule());
		c.setLinewrap().around(f.getDetailCodeAccess().getCommandsAssignment_1());
		c.setLinewrap().around(f.getBindingRule());
		c.setLinewrap().around(f.getSAPRefRule());
		c.setLinewrap().around(f.getSPPRefRule());
		c.setLinewrap().around(f.getAttributeRule());
		c.setLinewrap().around(f.getStandardOperationRule());
		c.setLinewrap().around(f.getPortOperationRule());

		// state graph items
		c.setLinewrap().around(f.getStateRule());
		c.setLinewrap().around(f.getTrPointRule());
		c.setLinewrap().around(f.getChoicePointRule());
		c.setLinewrap().around(f.getTransitionRule());
		c.setLinewrap().around(f.getRefinedTransitionRule());
		c.setLinewrap().around(f.getTriggerRule());

		// protocol
		c.setLinewrap().around(f.getPortClassRule());
		c.setLinewrap().around(f.getMessageRule());
		c.setLinewrap().around(f.getMessageHandlerRule());
		c.setLinewrap().around(f.getProtocolSemanticsRule());
		c.setLinewrap().around(f.getSemanticsRuleRule());
	}
}
