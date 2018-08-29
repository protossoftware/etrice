/*******************************************************************************
* Copyright (c) 2018 protos software gmbh (http://www.protos.de).
* All rights reserved.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
*
* CONTRIBUTORS:
*           Jan Belle (initial contribution)
*
 *******************************************************************************/

package org.eclipse.etrice.generator.base;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.generator.base.args.Arguments;
import org.eclipse.etrice.generator.base.logging.ILogger;
import org.eclipse.etrice.generator.base.validation.GeneratorResourceValidator;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.Inject;

/**
 * Tries to validate all contents of the underlying resource set of the resources.
 */
public class ModelValidator extends GeneratorResourceValidator {
	
	@Inject
	public ModelValidator(IResourceValidator validator) {
		super(validator);
	}

	@Override
	public void validate(List<Resource> resources, Arguments arguments, ILogger logger) {
		logger.logInfo("-- validating models");
		
		if(!resources.isEmpty()) {
			ResourceSet rs = resources.get(0).getResourceSet();
			if(rs != null) {
				super.validate(rs.getResources(), arguments, logger);
				return;
			}
		}
		
		super.validate(resources, arguments, logger);
	}
	
}
