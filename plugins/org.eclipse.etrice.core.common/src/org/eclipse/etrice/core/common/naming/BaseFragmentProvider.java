/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.core.common.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IFragmentProvider;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class BaseFragmentProvider implements IFragmentProvider {
	
	@Override
	public String getFragment(EObject obj, Fallback fallback) {
		return fallback.getFragment(obj);
	}

	@Override
	public EObject getEObject(Resource resource, String fragment, Fallback fallback) {
		return fallback.getEObject(fragment);
	}

}
