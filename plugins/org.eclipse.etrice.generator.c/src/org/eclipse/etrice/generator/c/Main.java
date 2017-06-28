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

package org.eclipse.etrice.generator.c;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.etrice.core.etmap.ETMapStandaloneSetup;
import org.eclipse.etrice.core.etmap.util.ETMapUtil;
import org.eclipse.etrice.core.etphys.ETPhysStandaloneSetup;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.base.GlobalGeneratorSettings;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.c.gen.MainGen;
import org.eclipse.etrice.generator.c.gen.Validator;
import org.eclipse.etrice.generator.c.setup.GeneratorModule;

import com.google.inject.Inject;

/**
 * This class is implementing the eTrice C generator.
 * 
 * <p>
 * It is based on the {@link org.eclipse.etrice.generator.base.AbstractGenerator AbstractGenerator}
 * and is a plain Java program with a main method and command line options.
 * </p>
 * <p>
 * It can be called using the launcher (see plug-in org.eclipse.etrice.generator.launch.c, i.e. using a
 * launch configuration (Run or Debug) which allows to configure command line options).
 * </p>
 * <p>
 * Alternatively it can be called from the command line as Java application. In this case the following jars
 * have to be on the class path:
 * <ul>
 *   <li>org.eclipse.etrice.core.room</li>
 *   <li>org.eclipse.etrice.core.genmodel</li>
 *   <li>org.eclipse.etrice.generator</li>
 *   <li>org.eclipse.emf.ecore</li>
 *   <li>org.eclipse.emf.common</li>
 *   <li>org.eclipse.emf.ecore.xmi</li>
 *   <li>org.eclipse.xtext</li>
 *   <li>org.eclipse.equinox.common</li>
 *   <li>org.eclipse.xtext.util</li>
 *   <li>org.eclipse.xtend.lib</li>
 *   <li>org.eclipse.xtext.xbase.lib</li>
 *   <li>org.apache.log4j</li>
 *   <li>org.antlr.runtime</li>
 *   <li>com.google.inject</li>
 *   <li>com.google.guava</li>
 *   <li>javax.inject</li>
 * </ul>
 * </p>
 *  
 * @author Henrik Rentz-Reichert
 *
 */
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
	
	/**
	 * @return the unique {@link GlobalSettings}
	 */
	public static GlobalGeneratorSettings getSettings() {
		return (GlobalGeneratorSettings) getInstance().getGeneratorSettings();
	}

	@Inject
	private MainGen mainGenerator;

	@Inject
	protected org.eclipse.etrice.generator.doc.gen.MainGen mainDocGenerator; 
	
	@Inject
	protected org.eclipse.etrice.generator.gnuplot.GnuplotScriptGenerator gnuPlotGenerator; 
	
	@Inject
	private Validator validator;
	
	@Inject
	protected IDataConfiguration dataConfig;

	private Root genModelResult = null;
	
	/**
	 *  The resulting genmodel of {@linkplain #Main.runGenerator} if available.
	 */
	public Root getGenModel() {
		return genModelResult;
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
			
			if(getSettings().isGenerateDataInstrumentation()){
				gnuPlotGenerator.doGenerate(genModel);
			}
			
			if (diagnostician.isFailed()) {
				logger.logInfo("errors during code generation");
				logger.logError("-- terminating", null);
				return GENERATOR_ERROR;
			}
			
			genModelResult = genModel;
			
			logger.logInfo("-- finished code generation");
		}
		finally {
			deactivateModelLocator();
		}
		
		return GENERATOR_OK;
	}
}
