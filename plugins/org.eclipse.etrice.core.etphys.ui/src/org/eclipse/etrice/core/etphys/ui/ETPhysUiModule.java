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

package org.eclipse.etrice.core.etphys.ui;

import org.eclipse.etrice.core.common.ui.editor.folding.FoldingRegionProvider;
import org.eclipse.etrice.core.common.ui.hover.BaseHoverDocumentationProvider;
import org.eclipse.etrice.core.common.ui.linking.GlobalNonPlatformURIEditorOpener;
import org.eclipse.etrice.core.common.ui.linking.ImportAwareHyperlinkHelper;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.hover.html.IEObjectHoverDocumentationProvider;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper;

/**
 * Use this class to register components to be used within the IDE.
 */
public class ETPhysUiModule extends org.eclipse.etrice.core.etphys.ui.AbstractETPhysUiModule {
	
	public ETPhysUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	public Class<? extends org.eclipse.xtext.ui.editor.IURIEditorOpener> bindIURIEditorOpener() {
		return GlobalNonPlatformURIEditorOpener.class;
	}
	
	public Class<? extends IHyperlinkHelper> bindIHyperlinkHelper() {
		return ImportAwareHyperlinkHelper.class;
	}
	
	public Class<? extends IFoldingRegionProvider> bindIFoldingRegionProvider() {
		return FoldingRegionProvider.class;
	}
	
	public Class<? extends IEObjectHoverDocumentationProvider> bindIEObjectHoverDocumentationProvider() {
		return BaseHoverDocumentationProvider.class;
	}
	
}
