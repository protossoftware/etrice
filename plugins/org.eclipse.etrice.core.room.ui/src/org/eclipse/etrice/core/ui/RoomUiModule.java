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
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.ui;

import org.eclipse.etrice.core.common.ui.autoedit.BaseAutoEditStrategyProvider;
import org.eclipse.etrice.core.common.ui.contentassist.FQNLastSegmentFinder;
import org.eclipse.etrice.core.common.ui.editor.BaseDoubleClickStrategyProvider;
import org.eclipse.etrice.core.common.ui.editor.folding.FoldingRegionProvider;
import org.eclipse.etrice.core.common.ui.editor.model.BaseTokenTypeToPartitionMapper;
import org.eclipse.etrice.core.common.ui.hover.BaseHoverDocumentationProvider;
import org.eclipse.etrice.core.common.ui.hover.IKeywordHoverContentProvider;
import org.eclipse.etrice.core.common.ui.imports.IOrganizeImportHelper;
import org.eclipse.etrice.core.common.ui.linking.GlobalNonPlatformURIEditorOpener;
import org.eclipse.etrice.core.room.ui.internal.RoomActivator;
import org.eclipse.etrice.core.ui.highlight.RoomHighlightingConfiguration;
import org.eclipse.etrice.core.ui.highlight.RoomSemanticHighlightingCalculator;
import org.eclipse.etrice.core.ui.hover.RoomEObjectHover;
import org.eclipse.etrice.core.ui.hover.RoomHoverProvider;
import org.eclipse.etrice.core.ui.imports.RoomOrganizeImportHelper;
import org.eclipse.etrice.core.ui.linking.RoomHyperlinkHelper;
import org.eclipse.etrice.core.ui.outline.RoomOutlinePage;
import org.eclipse.etrice.core.ui.quickfix.RoomQuickFixProviderXtend;
import org.eclipse.etrice.doc.KeywordHoverContentProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.documentation.IEObjectDocumentationProviderExtension;
import org.eclipse.xtext.documentation.impl.MultiLineCommentDocumentationProvider;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher;
import org.eclipse.xtext.ui.editor.doubleClicking.DoubleClickStrategyProvider;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.html.IEObjectHoverDocumentationProvider;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper;
import org.eclipse.xtext.ui.editor.model.ITokenTypeToPartitionTypeMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;

import com.google.inject.Binder;
import com.google.inject.Injector;

/**
 * Use this class to register components to be used within the IDE.
 */
public class RoomUiModule extends org.eclipse.etrice.core.ui.AbstractRoomUiModule {
	public RoomUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
			
		// keyword hover stuff
		binder.bind(IKeywordHoverContentProvider.class).to(KeywordHoverContentProvider.class);
		binder.bind(IEObjectHoverProvider.class).to(RoomHoverProvider.class);	
		binder.bind(IEObjectDocumentationProviderExtension.class).to(MultiLineCommentDocumentationProvider.class);
	
		binder.bind(FQNPrefixMatcher.LastSegmentFinder.class).to(FQNLastSegmentFinder.class);
		
		// namespace provider for OrganizeImports
		binder.bind(IOrganizeImportHelper.class).to(RoomOrganizeImportHelper.class);
	}

	@Override
	public Class<? extends IContentOutlinePage> bindIContentOutlinePage() {
		return RoomOutlinePage.class;
	}

	public static Injector getInjector() {
		return RoomActivator.getInstance().getInjector(RoomActivator.ORG_ECLIPSE_ETRICE_CORE_ROOM);
	}

	// HOWTO: use URI imports - need special editor opener
	public Class<? extends org.eclipse.xtext.ui.editor.IURIEditorOpener> bindIURIEditorOpener() {
		return GlobalNonPlatformURIEditorOpener.class;
	}

	// HOWTO: use URI imports - need special class for creating hyper links for
	// imports
	public Class<? extends IHyperlinkHelper> bindIHyperlinkHelper() {
		return RoomHyperlinkHelper.class;
	}

	// HOWTO: inject own highlighting configuration
	public Class<? extends IHighlightingConfiguration> bindSemanticConfig() {
		return RoomHighlightingConfiguration.class;
	}

	// HOWTO: inject own semantic highlighting
	public Class<? extends ISemanticHighlightingCalculator> bindSemanticHighlightingCalculator() {
		return RoomSemanticHighlightingCalculator.class;
	}

	@Override
	public Class<? extends IEObjectHover> bindIEObjectHover() {
		return RoomEObjectHover.class;
	}

	public Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
		return BaseAutoEditStrategyProvider.class;
	}
	
	public Class<? extends ITokenTypeToPartitionTypeMapper> bindITokenTypeToPartitionTypeMapper() {
		return BaseTokenTypeToPartitionMapper.class;
	}
	
	public Class<? extends DoubleClickStrategyProvider> bindDoubleClickStrategyProvider() {
		return BaseDoubleClickStrategyProvider.class;
	}
	
	public Class<? extends IFoldingRegionProvider> bindIFoldingRegionProvider() {
		return FoldingRegionProvider.class;
	}
	
	public Class<? extends IEObjectHoverDocumentationProvider> bindIEObjectHoverDocumentationProvider() {
		return BaseHoverDocumentationProvider.class;
	}
	
	@Override
	public Class<? extends org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider> bindIssueResolutionProvider() {
		return RoomQuickFixProviderXtend.class;
	}
	
	// auto format for quick fix
	/*
    public Class<? extends ITextEditComposer> bindITextEditComposer() {
        return AutoFormatTextEditComposer.class;
    }
	
	public static class AutoFormatTextEditComposer extends DefaultTextEditComposer {

	    @Override
	    protected SaveOptions getSaveOptions() {
	        return SaveOptions.newBuilder().format().getOptions();
	    }

	}
	*/
	
}
