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

import org.eclipse.etrice.core.ui.internal.RoomActivator;
import org.eclipse.etrice.core.ui.linking.GlobalNonPlatformURIEditorOpener;
import org.eclipse.etrice.core.ui.linking.RoomHyperlinkHelper;
import org.eclipse.etrice.core.ui.outline.RoomOutlinePage;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper;

import com.google.inject.Injector;

/**
 * Use this class to register components to be used within the IDE.
 */
public class RoomUiModule extends org.eclipse.etrice.core.ui.AbstractRoomUiModule {
	public RoomUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	@org.eclipse.xtext.service.SingletonBinding(eager=true)
	public Class<? extends org.eclipse.etrice.core.validation.RoomJavaValidator> bindRoomJavaValidator() {
		return org.eclipse.etrice.core.ui.RoomModelValidator.class;
	}

	@Override
	public Class<? extends IContentOutlinePage> bindIContentOutlinePage() {
		return RoomOutlinePage.class;
	}
	
	public static Injector getInjector() {
		return RoomActivator.getInstance().getInjector("org.eclipse.etrice.core.Room");
	}

	// HOWTO: use URI imports - need special editor opener
	public Class<? extends org.eclipse.xtext.ui.editor.IURIEditorOpener> bindIURIEditorOpener() {
		return GlobalNonPlatformURIEditorOpener.class;
	}

	// HOWTO: use URI imports - need special class for creating hyper links for imports
	public Class<? extends IHyperlinkHelper> bindIHyperlinkHelper() {
		return RoomHyperlinkHelper.class;
	}
}
