/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.ui.common.base.resource;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.etrice.core.common.scoping.RelativeFileURIHandler;

import com.google.common.collect.Maps;

/**
 *  Customize load/save of diagram resources, e.g. serialized URIs to .room.
 */
public class DiagramResource extends XMIResourceImpl {

	public DiagramResource() {
		super();
	}

	public DiagramResource(URI uri) {
		super(uri);
	}

	@Override
	public void load(Map<?, ?> options) throws IOException {
		// force RelativeFileURIHandler
		Map<Object, Object> optionsCopy = (options == null) ? getDefaultLoadOptions() : Maps.newHashMap(options);
		super.load(RelativeFileURIHandler.addToOptions(optionsCopy));
	}

	@Override
	public void save(Map<?, ?> options) throws IOException {
		// force RelativeFileURIHandler
		Map<Object, Object> optionsCopy = (options == null) ? getDefaultSaveOptions() : Maps.newHashMap(options);
		super.save(RelativeFileURIHandler.addToOptions(optionsCopy));
	}

	@Override
	public Map<Object, Object> getDefaultSaveOptions() {
		if (defaultSaveOptions == null) {
			return RelativeFileURIHandler.addToOptions(super.getDefaultLoadOptions());
		}

		return super.getDefaultSaveOptions();
	}

	@Override
	public Map<Object, Object> getDefaultLoadOptions() {
		if (defaultLoadOptions == null) { 
			return RelativeFileURIHandler.addToOptions(super.getDefaultLoadOptions());
		}

		return super.getDefaultLoadOptions();
	}
}
