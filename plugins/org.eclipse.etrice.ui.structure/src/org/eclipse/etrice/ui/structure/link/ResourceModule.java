/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

package org.eclipse.etrice.ui.structure.link;


import org.eclipse.etrice.ui.common.base.refactoring.DiagramReferenceUpdater;
import org.eclipse.etrice.ui.common.base.support.DiagramAccessBase;
import org.eclipse.etrice.ui.structure.DiagramAccess;
import org.eclipse.xtext.resource.generic.AbstractGenericResourceRuntimeModule;
import org.eclipse.xtext.ui.refactoring.IReferenceUpdater;

/**
 * @author Henrik Rentz-Reichert - initial contribution and API
 *
 */
public class ResourceModule extends AbstractGenericResourceRuntimeModule {

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.resource.generic.AbstractGenericResourceRuntimeModule#getLanguageName()
	 */
	@Override
	protected String getLanguageName() {
		return "org.eclipse.etrice.ui.structure.editor.StructureEditor";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.resource.generic.AbstractGenericResourceRuntimeModule#getFileExtensions()
	 */
	@Override
	protected String getFileExtensions() {
		return "structure";
	}
	
	public Class<? extends IReferenceUpdater> bindIReferenceUpdater() {
		return DiagramReferenceUpdater.class;
	}
	
	public Class<? extends DiagramAccessBase> bindDiagramAccess() {
		return DiagramAccess.class;
	}

}
