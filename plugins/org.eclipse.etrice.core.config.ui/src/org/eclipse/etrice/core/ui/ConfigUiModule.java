/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/
package org.eclipse.etrice.core.ui;

import org.eclipse.etrice.core.ui.linking.ConfigHyperlinkHelper;
import org.eclipse.etrice.core.ui.linking.GlobalNonPlatformURIEditorOpener;
import org.eclipse.ui.plugin.AbstractUIPlugin;
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
}
