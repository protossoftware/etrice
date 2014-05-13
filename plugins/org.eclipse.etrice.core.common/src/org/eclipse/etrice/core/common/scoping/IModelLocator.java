/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.scoping;

import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.ImplementedBy;

/**
 * @author Henrik Rentz-Reichert
 *
 */
@ImplementedBy(StandardModelLocator.class)
public interface IModelLocator {
	String resolve(String resolve, Resource resource);
}
