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

package org.eclipse.etrice.core.common.ui.linking;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.scoping.ModelLocatorUriResolver;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;
import org.eclipse.xtext.ui.editor.hyperlinking.XtextHyperlink;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Henrik Rentz-Reichert (initial contribution)
 *
 */
public class ImportAwareHyperlinkHelper extends HyperlinkHelper {

	@Inject
	protected Provider<XtextHyperlink> hyperlinkProvider;

	@Inject
	protected ModelLocatorUriResolver uriResolver;
	
	public ImportAwareHyperlinkHelper() {
		super();
	}
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper#createHyperlinksByOffset(org.eclipse.xtext.resource.XtextResource, int, org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor)
	 */
	@Override
	public void createHyperlinksByOffset(XtextResource resource, int offset, IHyperlinkAcceptor acceptor) {

		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null && parseResult.getRootNode() != null) {
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
			EObject grammarElement = leaf.getParent().getGrammarElement();
			if (grammarElement instanceof RuleCall) {
				RuleCall rc = (RuleCall) grammarElement;
				AbstractRule rule = rc.getRule();
				if (rule.getName().equals("Import")) {
					String text = leaf.getText().substring(1, leaf.getText().length()-1);
					
					XtextHyperlink result = hyperlinkProvider.get();
					result.setHyperlinkRegion(new Region(leaf.getOffset()+1, leaf.getLength()-2)); // omit ""
					String uritext = uriResolver.resolve(text, resource);
					URI uri = URI.createURI(uritext);
					result.setURI(uri);
					result.setHyperlinkText(uritext);
					acceptor.accept(result);
				}
			}
		}
		
		super.createHyperlinksByOffset(resource, offset, acceptor);
	}
}
