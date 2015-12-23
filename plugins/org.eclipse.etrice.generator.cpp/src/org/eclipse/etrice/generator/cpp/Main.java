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

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.etrice.core.etmap.ETMapStandaloneSetup;
import org.eclipse.etrice.core.etmap.util.ETMapUtil;
import org.eclipse.etrice.core.etphys.ETPhysStandaloneSetup;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.base.GlobalGeneratorSettings;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.cpp.gen.MainGen;
import org.eclipse.etrice.generator.cpp.gen.Validator;
import org.eclipse.etrice.generator.cpp.setup.GeneratorModule;
import org.eclipse.etrice.generator.doc.gen.GlobalSettings;

import com.google.inject.Inject;

public class Main extends AbstractGenerator {

	/**
	 * print usage message to output/console
	 */
	protected void printUsage() {
		output.println(this.getClass().getName()+getCommonOptions()
				+" <list of model file paths>");
		output.println(getCommonOptionDescriptions());
	}

	public static void main(String[] args) {
		int ret = createAndRunGenerator(new GeneratorModule(), args);
		if (isTerminateOnError() && ret!=GENERATOR_OK)
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

	/**
	 * @return the unique {@link GlobalSettings}
	 */
	public static GlobalGeneratorSettings getSettings() {
		return (GlobalGeneratorSettings) getInstance().getGeneratorSettings();
	}

	/**
	 * setup the eTrice mapping model plug-in
	 */
	protected void setupMappingModel() {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			ETMapStandaloneSetup.doSetup();
		}
	}

	/**
	 * setup the eTrice mapping model plug-in
	 */
	protected void setupPhysicalModel() {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING)
			ETPhysStandaloneSetup.doSetup();
	}

	protected int runGenerator() {
		setupRoomModel();
		dataConfig.doSetup();
		setupMappingModel();
		setupPhysicalModel();

		try {
			activateModelLocator();

			if (!loadModels(getSettings().getInputModelURIs())) {
				logger.logInfo("loading of models failed");
				logger.logError("-- terminating", null);
				return GENERATOR_ERROR;
			}

			if (!validateModels()) {
				logger.logInfo("validation failed");
				logger.logError("-- terminating", null);
				return GENERATOR_ERROR;
			}

			if (!dataConfig.setResources(getResourceSet(), logger)) {
				logger.logInfo("configuration errors");
				logger.logError("-- terminating", null);
				return GENERATOR_ERROR;
			}

			Root genModel = createGeneratorModel(getSettings().isGenerateAsLibrary(), getSettings().getGeneratorModelPath());
			if (diagnostician.isFailed() || genModel==null) {
				logger.logInfo("errors during build of generator model");
				logger.logError("-- terminating", null);
				return GENERATOR_ERROR;
			}

			if (!validator.validate(genModel)) {
				logger.logInfo("validation failed during build of generator model");
				logger.logError("-- terminating", null);
				return GENERATOR_ERROR;
			}

			ETMapUtil.processModels(genModel, getResourceSet(), diagnostician);
			if (getSettings().isDebugMode()) {
				logger.logInfo("-- begin dump of mappings");
				logger.logInfo(ETMapUtil.dumpMappings());
				logger.logInfo("-- end dump of mappings");
			}
			if (diagnostician.isFailed() || genModel==null) {
				logger.logInfo("errors in mapping");
				logger.logError("-- terminating", null);
				return GENERATOR_ERROR;
			}

			logger.logInfo("-- starting code generation");
			mainGenerator.doGenerate(genModel.eResource());

			if (getSettings().isGenerateDocumentation()) {
				mainDocGenerator.doGenerate(genModel.eResource());
			}

			if (diagnostician.isFailed()) {
				logger.logInfo("errors during code generation");
				logger.logError("-- terminating", null);
				return GENERATOR_ERROR;
			}
			logger.logInfo("-- finished code generation");
		}
		finally {
			deactivateModelLocator();
		}

		return GENERATOR_OK;
	}
}
