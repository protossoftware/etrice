/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.link;

import org.eclipse.xtext.resource.generic.AbstractGenericResourceRuntimeModule;

/**
 * @author Henrik Rentz-Reichert - initial contribution and API
 *
 */
public class ResourceModule extends
		AbstractGenericResourceRuntimeModule {

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.resource.generic.AbstractGenericResourceRuntimeModule#getLanguageName()
	 */
	@Override
	protected String getLanguageName() {
		return "org.eclipse.etrice.ui.behavior.editor.BehaviorEditor";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.resource.generic.AbstractGenericResourceRuntimeModule#getFileExtensions()
	 */
	@Override
	protected String getFileExtensions() {
		return "behavior";
	}

}
