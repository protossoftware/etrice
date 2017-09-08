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

package org.eclipse.etrice.core.ui;

import org.eclipse.etrice.core.common.ui.autoedit.BaseAutoEditStrategyProvider;
import org.eclipse.etrice.core.common.ui.editor.model.BaseTokenTypeToPartitionMapper;
import org.eclipse.etrice.core.common.ui.hover.IKeywordHoverContentProvider;
import org.eclipse.etrice.core.common.ui.hover.KeywordHoverProvider;
import org.eclipse.etrice.core.common.ui.linking.GlobalNonPlatformURIEditorOpener;
import org.eclipse.etrice.core.ui.highlight.RoomHighlightingConfiguration;
import org.eclipse.etrice.core.ui.highlight.RoomSemanticHighlightingCalculator;
import org.eclipse.etrice.core.ui.hover.RoomHoverProvider;
import org.eclipse.etrice.core.ui.internal.RoomActivator;
import org.eclipse.etrice.core.ui.linking.RoomHyperlinkHelper;
import org.eclipse.etrice.core.ui.outline.RoomOutlinePage;
import org.eclipse.etrice.doc.KeywordHoverContentProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
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
		binder.bind(IEObjectHoverProvider.class).to(KeywordHoverProvider.class);		
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
		return RoomHoverProvider.class;
	}

	public Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
		return BaseAutoEditStrategyProvider.class;
	}
	
	public Class<? extends ITokenTypeToPartitionTypeMapper> bindITokenTypeToPartitionTypeMapper(){
		return BaseTokenTypeToPartitionMapper.class;
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
