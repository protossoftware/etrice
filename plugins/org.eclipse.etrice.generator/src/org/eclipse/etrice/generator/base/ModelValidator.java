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
import org.eclipse.etrice.generator.base.validation.IGeneratorResourceValidator;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;

/**
 * Validates all resources in the transitive closure of the input files.
 */
public class ModelValidator implements IGeneratorResourceValidator {
	
	private IResourceValidator resourceValidator;
	
	@Inject
	public ModelValidator(IResourceValidator validator) {
		this.resourceValidator = validator;
	}

	@Override
	public void validate(List<Resource> resources, Arguments arguments, ILogger logger) {
		validateTransitiveClosure(resources, arguments, logger);
	}
	
	/**
	 * Validate all referenced models (including transitive references).
	 * Only errors are reported for imported resources.
	 * 
	 * @param resources the resources to validate the transitive closure of
	 * @param arguments the generator arguments
	 * @param logger the logger to log issues
	 */
	private void validateTransitiveClosure(List<Resource> resources, Arguments arguments, ILogger logger) {
		logger.logInfo("-- validating models");
		
		int errors = 0;
		int warnings = 0;
		List<Resource> importedResources = computeImportedResources(resources);
		
		// Validate imported resources, only report errors (see Bug 546145)
		for(Resource resource : importedResources) {
			List<Issue> list = resourceValidator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
			for(Issue issue: list) {
				if(issue.getSeverity() == Severity.ERROR) {
					++errors;
					logger.logError(issue.toString());
				}
			}
		}
		
		// Validate resources
		for (Resource resource : resources) {
			List<Issue> list = resourceValidator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
			for (Issue issue : list) {
				if (issue.getSeverity() == Severity.ERROR) {
					++errors;
					logger.logError(issue.toString());
				}
				else if(issue.getSeverity() == Severity.WARNING) {
					++warnings;
					logger.logWarning(issue.toString());
				}
				else {
					logger.logInfo(issue.toString());
				}
			}
		}
		
		if(warnings > 0) {
			logger.logWarning(warnings + " warnings");
		}
		if(errors > 0) {
			logger.logError(errors + " errors");
			logger.logInfo("validation failed");
			logger.logInfo("-- terminating");
			throw new GeneratorException("validation failed");
		}
	}
	
	/**
	 * Computes a list of imported resources.
	 * 
	 * @param the resources to compute the imported resources of
	 * @return list of imported resources
	 */
	private List<Resource> computeImportedResources(List<Resource> resources) {
		Set<Resource> closure = new LinkedHashSet<>();
		resources.forEach(r -> computeTransitiveClosure(r, closure));
		closure.removeAll(resources);
		return new ArrayList<>(closure);
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
