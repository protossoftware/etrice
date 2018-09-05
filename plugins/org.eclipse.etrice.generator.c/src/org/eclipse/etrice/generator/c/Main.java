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
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.c;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.etmap.util.ETMapUtil;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.base.args.Arguments;
import org.eclipse.etrice.generator.base.io.IGeneratorFileIO;
import org.eclipse.etrice.generator.base.logging.ILogger;
import org.eclipse.etrice.generator.base.logging.Loglevel;
import org.eclipse.etrice.generator.c.gen.MainGen;
import org.eclipse.etrice.generator.c.gen.Validator;
import org.eclipse.etrice.generator.c.setup.GeneratorModule;
import org.eclipse.etrice.generator.c.setup.GeneratorOptions;

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

	protected int runGenerator(List<Resource> resources, Arguments arguments, IGeneratorFileIO fileIO, ILogger logger) {
		
		if (!dataConfig.setResources(getResourceSet(), logger)) {
			logger.logError("configuration errors");
			return GENERATOR_ERROR;
		}
		
		Root genModel = createGeneratorModel(resources, arguments, logger);		
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
			logger.logDebug("-- begin dump of mappings");
			logger.logDebug(ETMapUtil.dumpMappings());
			logger.logDebug("-- end dump of mappings");
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
		
		if(arguments.get(GeneratorOptions.DATA_INSTR)){
			gnuPlotGenerator.doGenerate(genModel);
		}
		
		if (diagnostician.isFailed()) {
			logger.logError("errors during code generation");
			return GENERATOR_ERROR;
		}
		
		genModelResult = genModel;
		
		return GENERATOR_OK;
	}
}
