/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

package org.eclipse.etrice.generator.cpp;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.etmap.util.ETMapUtil;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.base.args.Arguments;
import org.eclipse.etrice.generator.base.logging.Loglevel;
import org.eclipse.etrice.generator.cpp.gen.MainGen;
import org.eclipse.etrice.generator.cpp.gen.Validator;
import org.eclipse.etrice.generator.cpp.setup.GeneratorModule;
import org.eclipse.etrice.generator.cpp.setup.GeneratorOptions;

import com.google.inject.Inject;

public class Main extends AbstractGenerator {

	public static int run(String[] args) {
		return createAndRunGenerator(new GeneratorModule(), args);
	}
	
	public static void main(String[] args) {
		int ret = run(args);
		System.exit(ret);
	}

	@Inject
	private MainGen mainGenerator;

	@Inject
	protected org.eclipse.etrice.generator.doc.gen.MainGen mainDocGenerator;

	@Inject
	private Validator validator;

	@Inject
	protected IDataConfiguration dataConfig;

	protected int runGenerator(List<Resource> resources, Arguments arguments) {

		if (!dataConfig.setResources(getResourceSet(), logger)) {
			logger.logError("configuration errors");
			return GENERATOR_ERROR;
		}

		Root genModel = createGeneratorModel(resources, arguments);
		if (diagnostician.isFailed() || genModel==null) {
			logger.logError("errors during build of generator model");
			return GENERATOR_ERROR;
		}

		if (!validator.validate(genModel)) {
			logger.logError("validation failed during build of generator model");
			return GENERATOR_ERROR;
		}

		ETMapUtil.processModels(genModel, getResourceSet(), diagnostician);
		if (Loglevel.DEBUG.compareTo(logger.getLoglevel()) >= 0) {
			logger.logInfo("-- begin dump of mappings");
			logger.logInfo(ETMapUtil.dumpMappings());
			logger.logInfo("-- end dump of mappings");
		}
		if (diagnostician.isFailed() || genModel==null) {
			logger.logError("errors in mapping");
			return GENERATOR_ERROR;
		}

		logger.logInfo("-- starting code generation");
		mainGenerator.doGenerate(genModel.eResource());

		if (arguments.get(GeneratorOptions.DOCUMENTATION)) {
			mainDocGenerator.doGenerate(genModel.eResource());
		}

		if (diagnostician.isFailed()) {
			logger.logError("errors during code generation");
			return GENERATOR_ERROR;
		}

		return GENERATOR_OK;
	}
}
