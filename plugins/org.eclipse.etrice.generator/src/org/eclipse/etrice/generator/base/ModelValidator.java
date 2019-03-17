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

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.generator.base.args.Arguments;
import org.eclipse.etrice.generator.base.logging.ILogger;
import org.eclipse.etrice.generator.base.validation.GeneratorResourceValidator;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.Inject;

/**
 * Validates all resources in the transitive closure of the input files.
 */
public class ModelValidator extends GeneratorResourceValidator {
	
	@Inject
	public ModelValidator(IResourceValidator validator) {
		super(validator);
	}

	@Override
	public void validate(List<Resource> resources, Arguments arguments, ILogger logger) {
		logger.logInfo("-- validating models");
		try {
			validateTransitiveClosure(resources, arguments, logger);
		}
		catch(Exception e) {
			logger.logInfo("validation failed");
			logger.logInfo("-- terminating");
			throw e;
		}
	}
	
	/**
	 * Validate all referenced models (including transitive references).
	 * 
	 * @param resources the resources to validate the transitive closure of
	 * @param arguments the generator arguments
	 * @param logger the logger to log issues
	 */
	private void validateTransitiveClosure(List<Resource> resources, Arguments arguments, ILogger logger) {
		Set<Resource> transitiveClosure = new LinkedHashSet<>();
		resources.forEach(r -> computeTransitiveClosure(r, transitiveClosure));
		List<Resource> toValidate = new ArrayList<>(transitiveClosure);
		
		super.validate(toValidate, arguments, logger);
	}
	
	/**
	 * Computes the transitive closure of a resource, i.e. all directly and indirectly referenced resources.
	 * 
	 * @param resource the resource to compute the closure of
	 * @praram closure the set to add referenced resources to
	 */
	private void computeTransitiveClosure(Resource resource, Set<Resource> closure) {
		if(closure.add(resource)) {
			EcoreUtil.ExternalCrossReferencer.find(resource).keySet().stream()
				.map(EObject::eResource)
				.filter(Objects::nonNull)
				.forEach(r -> computeTransitiveClosure(r, closure));
		}
	}
}
