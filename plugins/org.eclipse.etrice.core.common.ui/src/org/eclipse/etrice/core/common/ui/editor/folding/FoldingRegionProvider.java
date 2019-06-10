/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.ui.editor.folding;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.core.common.base.Import;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.editor.folding.DefaultFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionAcceptor;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionAcceptorExtension;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.ITextRegion;

import com.google.inject.Inject;

public class FoldingRegionProvider extends DefaultFoldingRegionProvider {
	
	@Inject
	private ILocationInFileProvider locationInFileProvider;
	
	@Override
	protected void computeCommentFolding(IXtextDocument xtextDocument,
			IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor, ITypedRegion typedRegion,
			boolean initiallyFolded) throws BadLocationException {
		
		// auto fold copyright
		boolean isFolded = initiallyFolded;
		int offset = typedRegion.getOffset();
		int length = typedRegion.getLength();
		if(offset == 0) {
			String text = xtextDocument.get(offset, length);
			isFolded |= text.trim().toLowerCase().contains("copyright");
		}
		
		super.computeCommentFolding(xtextDocument, foldingRegionAcceptor, typedRegion, isFolded);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void computeObjectFolding(EObject eObject, IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor,
			boolean initiallyFolded) {
		
		if(eObject instanceof Import) {
			// fold imports
			EStructuralFeature importsFeature = eObject.eContainmentFeature();
			if(importsFeature.isMany()) {
				List<Import> imports = (List<Import>) eObject.eContainer().eGet(importsFeature);
				if(imports.size() >= 2 && imports.get(0) == eObject) {
					// assuming imports syntax is a single block
					ITextRegion region = imports.stream().map(imp -> locationInFileProvider.getFullTextRegion(imp)).reduce((first, second) -> first.merge(second)).get();
					ITextRegion significant = locationInFileProvider.getSignificantTextRegion(eObject);
					((IFoldingRegionAcceptorExtension<ITextRegion>)foldingRegionAcceptor).accept(region.getOffset(), region.getLength(), true, significant);	
				}
			}		
		}
		
		super.computeObjectFolding(eObject, foldingRegionAcceptor, initiallyFolded);
	}

}
