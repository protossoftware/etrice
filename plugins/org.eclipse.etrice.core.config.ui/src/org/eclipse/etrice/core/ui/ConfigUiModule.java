/*******************************************************************************
 * Copyright (c) 2012 Juergen Haug
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.ui;

import org.eclipse.etrice.core.common.ui.editor.folding.FoldingRegionProvider;
import org.eclipse.etrice.core.common.ui.hover.BaseHoverDocumentationProvider;
import org.eclipse.etrice.core.common.ui.linking.GlobalNonPlatformURIEditorOpener;
import org.eclipse.etrice.core.ui.linking.ConfigHyperlinkHelper;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.hover.html.IEObjectHoverDocumentationProvider;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper;

/**
 * Use this class to register components to be used within the IDE.
 */
public class ConfigUiModule extends
		org.eclipse.etrice.core.ui.AbstractConfigUiModule {
	public ConfigUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	// HOWTO: use URI imports - need special editor opener
	public Class<? extends org.eclipse.xtext.ui.editor.IURIEditorOpener> bindIURIEditorOpener() {
		return GlobalNonPlatformURIEditorOpener.class;
	}

	// HOWTO: use URI imports - need special class for creating hyper links for
	// imports
	public Class<? extends IHyperlinkHelper> bindIHyperlinkHelper() {
		return ConfigHyperlinkHelper.class;
	}
	
	public Class<? extends IFoldingRegionProvider> bindIFoldingRegionProvider() {
		return FoldingRegionProvider.class;
	}
	
	public Class<? extends IEObjectHoverDocumentationProvider> bindIEObjectHoverDocumentationProvider() {
		return BaseHoverDocumentationProvider.class;
	}
}
