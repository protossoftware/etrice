/*******************************************************************************
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		https://borisdevnotes.wordpress.com/2014/02/28/xtext-usability-hovers-on-keywords/
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.ui.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.inject.Inject;

public class KeywordEObjectTextHover extends DispatchingEObjectTextHover {

	@Inject
	protected IEObjectHoverProvider hoverProvider;

	@Override
	public Object getHoverInfo(EObject first, ITextViewer textViewer, IRegion hoverRegion) {
		if (first instanceof Keyword) {
			lastCreatorProvider = hoverProvider.getHoverInfo(first, textViewer, hoverRegion);
			return lastCreatorProvider == null ? null : lastCreatorProvider.getInfo();
		}
		lastCreatorProvider = null;
		return super.getHoverInfo(first, textViewer, hoverRegion);
	}

	@Override
	protected Pair<EObject, IRegion> getXtextElementAt(XtextResource resource, int offset) {
		Pair<EObject, IRegion> result = super.getXtextElementAt(resource, offset);
		if (result == null) {
			result = resolveKeywordAt(resource, offset);
		}
		return result;
	}

	public Pair<EObject, IRegion> resolveKeywordAt(XtextResource resource, int offset) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null) {
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
			if (leaf != null && leaf.isHidden() && leaf.getOffset() == offset) {
				leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset - 1);
			}
			if (leaf != null && leaf.getGrammarElement() instanceof Keyword) {
				Keyword keyword = (Keyword) leaf.getGrammarElement();
				return Tuples.create((EObject) keyword, (IRegion) new Region(leaf.getOffset(), leaf.getLength()));
			}
		}
		return null;
	}
}
