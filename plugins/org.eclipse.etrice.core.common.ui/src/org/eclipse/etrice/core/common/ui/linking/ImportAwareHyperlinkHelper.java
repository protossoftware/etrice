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
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.ui.linking;

import org.eclipse.emf.common.util.URI;
import org.eclipse.etrice.core.common.base.util.ImportHelpers;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;
import org.eclipse.xtext.ui.editor.hyperlinking.XtextHyperlink;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class ImportAwareHyperlinkHelper extends HyperlinkHelper {

	@Inject ImportHelpers importHelpers;
	@Inject Provider<XtextHyperlink> hyperlinkProvider;

	@SuppressWarnings("deprecation")
	@Override
	public void createHyperlinksByOffset(XtextResource resource, int offset, IHyperlinkAcceptor acceptor) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null && parseResult.getRootNode() != null) {
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
			Region region = new Region(leaf.getOffset(), leaf.getLength());
			
			AbstractRule leafRule = null;
			if(leaf.getGrammarElement() instanceof RuleCall) {
				leafRule = ((RuleCall) leaf.getGrammarElement()).getRule();
			}
			
			AbstractRule parentRule = null;
			if(leaf.getParent().getGrammarElement() instanceof RuleCall) {
				parentRule = ((RuleCall) leaf.getParent().getGrammarElement()).getRule();
			}	
			
			// FQN and ImportedFQN => create link on fqn
			if (parentRule != null && (parentRule.getName().equals("FQN") || parentRule.getName().equals("ImportedFQN"))) {
				QualifiedName fqn = importHelpers.toFQN(leaf.getParent().getText().trim());
				// query global scope, that is how elements are actually resolved
				IScope scope = importHelpers.getVisibleScope(resource, null);
				IEObjectDescription candidate = scope.getSingleElement(fqn); // take first
				if (candidate != null) {
					createHyperlinksTo(resource, region, candidate.getEObjectOrProxy(), acceptor);
				}
			}
			// Import-importURI => create link on uri text
			else if (parentRule != null && leafRule != null && parentRule.getName().equals("Import")
					&& leafRule.getName().equals("STRING")) {
				String text = leaf.getText().substring(1, leaf.getText().length() - 1);

				String uritext = importHelpers.getUriResolver().resolve(text, resource);
				if (uritext != null) {
					try {
						XtextHyperlink result = hyperlinkProvider.get();
						result.setHyperlinkText(uritext);
						result.setHyperlinkRegion(region); // ignore: deprecated since Xtext 2.18
						result.setURI(URI.createURI(uritext));
						acceptor.accept(result);
					} catch (IllegalArgumentException e) {
					}
				}
			}
		}
		
		super.createHyperlinksByOffset(resource, offset, acceptor);
	}
}
