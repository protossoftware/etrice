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

package org.eclipse.etrice.core.etphys.ui;

import org.eclipse.etrice.core.common.ui.linking.GlobalNonPlatformURIEditorOpener;
import org.eclipse.etrice.core.common.ui.linking.ImportAwareHyperlinkHelper;
import org.eclipse.ui.plugin.AbstractUIPlugin;
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
	
}
