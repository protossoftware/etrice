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

package org.eclipse.etrice.generator.java;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.etmap.ETMapStandaloneSetup;
import org.eclipse.etrice.core.etmap.eTMap.MappingModel;
import org.eclipse.etrice.core.etmap.util.ETMapUtil;
import org.eclipse.etrice.core.etphys.ETPhysStandaloneSetup;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.base.IResourceURIAcceptor;
import org.eclipse.etrice.generator.base.IncrementalGenerationFileIo;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.java.gen.GlobalSettings;
import org.eclipse.etrice.generator.java.gen.Validator;
import org.eclipse.etrice.generator.java.setup.GeneratorModule;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;

import com.google.inject.Inject;

public class Main extends AbstractGenerator {
	
	public static final String OPTION_LIB = "-lib";
	public static final String OPTION_NOEXIT = "-noexit";
	public static final String OPTION_DOCUMENTATION = "-genDocu";
	public static final String OPTION_SAVE_GEN_MODEL = "-saveGenModel";
	public static final String OPTION_GEN_INCREMENTAL = "-inc";
	public static final String OPTION_GEN_DIR = "-genDir";
	public static final String OPTION_GEN_INFO_DIR = "-genInfoDir";
	public static final String OPTION_GEN_DOC_DIR = "-genDocDir";
	public static final String OPTION_DEBUG = "-debug";
	public static final String OPTION_MSC = "-msc_instr";
	public static final String OPTION_VERBOSE_RT = "-gen_as_verbose";
	
	/**
	 * print usage message to stderr
	 */
	private static void printUsage() {
		output.println(Main.class.getName()+" ["+OPTION_SAVE_GEN_MODEL+" <genmodel path>]"
				+" ["+OPTION_DOCUMENTATION+"]"
				+" ["+OPTION_LIB+"]"
				+" ["+OPTION_NOEXIT+"]"
				+" ["+OPTION_SAVE_GEN_MODEL+" <genmodel path>]"
				+" ["+OPTION_GEN_INCREMENTAL
				+" ["+OPTION_GEN_DIR+" <generation directory>]"
				+" ["+OPTION_GEN_INFO_DIR+" <generation info directory>]"
				+" ["+OPTION_GEN_DOC_DIR+" <gen documentation directory>]"
				+" ["+OPTION_DEBUG+"]"
				+" ["+OPTION_MSC+"]"
				+" ["+OPTION_VERBOSE_RT+"]"
				+" <list of model file paths>");
		output.println("      <list of model file paths>         # model file paths may be specified as");
		output.println("                                         # e.g. C:\\path\\to\\model\\mymodel.room");
		output.println("      -genDocu                           # if specified documentation is created");
		output.println("      -lib                               # if specified all classes are generated and no instances");
		output.println("      -noexit                            # if specified the JVM is not exited");
		output.println("      -saveGenModel <genmodel path>      # if specified the generator model will be saved to this location");
		output.println("      -inc                               # if specified the generation is incremental");
		output.println("      -genDir <generation directory>     # the directory for generated files");
		output.println("      -genInfoDir <generation info dir>  # the directory for generated info files");
		output.println("      -genDocDir <gen documentation dir> # the directory for generated documentation files");
		output.println("      -debug                             # if specified create debug output");
		output.println("      -msc_instr                         # generate instrumentation for MSC generation");
		output.println("      -gen_as_verbose                    # generate instrumentation for verbose console output");
	}

	public static void main(String[] args) {
		int ret = createAndRunGenerator(new GeneratorModule(), args);
		if (isTerminateOnError() && ret!=GENERATOR_OK)
			System.exit(ret);
	}

	@Inject
	private IGenerator mainGenerator;

	@Inject
	protected org.eclipse.etrice.generator.doc.gen.MainGen mainDocGenerator; 
	
	@Inject
	private Validator validator;
	
	@Inject
	protected IDataConfiguration dataConfig;
	
	@Inject
	protected ImportUriResolver uriResolver;
	
	public int runGenerator(String[] args) {
		if (args.length == 0) {
			return usageError("no arguments!");
		}

		// setting defaults
		String genModelPath = null;
		List<String> uriList = new ArrayList<String>();
		boolean genDocumentation = false;
		boolean asLibrary = false;
		boolean debug = false;
		IncrementalGenerationFileIo.setGenerateIncremental(false);
		RoomExtensions.setDefaultGenDir();
		RoomExtensions.setDefaultGenInfoDir();
		RoomExtensions.setDefaultGenDocDir();

		// parsing arguments
		for (int i=0; i<args.length; ++i) {
			if (args[i].equals(OPTION_SAVE_GEN_MODEL)) {
				if (++i<args.length) {
					genModelPath = args[i]+"/genmodel.egm";
				}
				else {
					return usageError(OPTION_SAVE_GEN_MODEL+" needs path");
				}
			}
			else if (args[i].equals(OPTION_GEN_DIR)) {
				if (++i<args.length) {
					RoomExtensions.setGenDir(args[i]);
				}
				else {
					return usageError(OPTION_GEN_DIR+" needs directory");
				}
			}
			else if (args[i].equals(OPTION_GEN_INFO_DIR)) {
				if (++i<args.length) {
					RoomExtensions.setGenInfoDir(args[i]);
				}
				else {
					return usageError(OPTION_GEN_INFO_DIR+" needs directory");
				}
			}
			else if (args[i].equals(OPTION_GEN_DOC_DIR)) {
				if (++i<args.length) {
					RoomExtensions.setGenDocDir(args[i]);
				}
				else {
					return usageError(OPTION_GEN_DOC_DIR+" needs directory");
				}
			}
			else if (args[i].equals(OPTION_GEN_INCREMENTAL)) {
				IncrementalGenerationFileIo.setGenerateIncremental(true);
			}
			else if (args[i].equals(OPTION_DOCUMENTATION)) {
				genDocumentation = true;
			}
			else if (args[i].equals(OPTION_LIB)) {
				asLibrary = true;
			}
			else if (args[i].equals(OPTION_NOEXIT)) {
				setTerminateOnError(false);
			}
			else if (args[i].equals(OPTION_MSC)) {
				GlobalSettings.setGenerateMSCInstrumentation(true);
			}
			else if (args[i].equals(OPTION_VERBOSE_RT)) {
				GlobalSettings.setGenerateWithVerboseOutput(true);
			}
			else if (args[i].equals(OPTION_DEBUG)) {
				debug = true;
			}
			else {
				uriList.add(args[i]);
			}
		}

		setupRoomModel();
		dataConfig.doSetup();
		setupMappingModel();
		setupPhysicalModel();

		if (!runGenerator(uriList, genModelPath, genDocumentation, asLibrary, debug))
			return GENERATOR_ERROR;
		
		return GENERATOR_OK;
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

	protected int usageError(String text) {
		logger.logError(Main.class.getName() + " - aborting: " + text, null);
		printUsage();
		return GENERATOR_ERROR;
	}

	protected boolean runGenerator(List<String> uriList, String genModelPath, boolean genDocumentation, boolean asLibrary, boolean debug) {
		if (!loadModels(uriList)) {
			logger.logInfo("loading of models failed");
			logger.logError("-- terminating", null);
			return false;
		}

		if (!validateModels()) {
			logger.logInfo("validation failed");
			logger.logError("-- terminating", null);
			return false;
		}

		if (!dataConfig.setResources(getResourceSet(), logger)) {
			logger.logInfo("configuration errors");
			logger.logError("-- terminating", null);
			return false;
		}
		
		Root genModel = createGeneratorModel(asLibrary, genModelPath);
		if (diagnostician.isFailed() || genModel==null) {
			logger.logInfo("errors during build of generator model");
			logger.logError("-- terminating", null);
			return false;
		}
		
		if (!validator.validate(genModel)) {
			logger.logInfo("validation failed during build of generator model");
			logger.logError("-- terminating", null);
			return false;
		}
		
		ETMapUtil.processModels(genModel, getResourceSet(), diagnostician);
		if (debug) {
			logger.logInfo("-- begin dump of mappings");
			logger.logInfo(ETMapUtil.dumpMappings());
			logger.logInfo("-- end dump of mappings");
		}
		if (diagnostician.isFailed() || genModel==null) {
			logger.logInfo("errors in mapping");
			logger.logError("-- terminating", null);
			return false;
		}
		
		logger.logInfo("-- starting code generation");
		fileAccess.setOutputPath("src-gen/");
		mainGenerator.doGenerate(genModel.eResource(), fileAccess);
		
		if (genDocumentation) {
			mainDocGenerator.doGenerate(genModel);
		}
		
		if (diagnostician.isFailed()) {
			logger.logInfo("errors during code generation");
			logger.logError("-- terminating", null);
			return false;
		}
		logger.logInfo("-- finished code generation");
		
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.base.AbstractGenerator#addReferencedModels(org.eclipse.emf.ecore.resource.Resource, java.util.List)
	 */
	@Override
	protected void addReferencedModels(EObject root, IResourceURIAcceptor acceptor) {
		super.addReferencedModels(root, acceptor);
		
		if (root instanceof PhysicalModel) {
			for (org.eclipse.etrice.core.etphys.eTPhys.Import imp : ((PhysicalModel)root).getImports()) {
				String importURI = uriResolver.resolve(imp);
				acceptor.addResourceURI(importURI);
			}
		}
		else if (root instanceof MappingModel) {
			for (org.eclipse.etrice.core.etmap.eTMap.Import imp : ((MappingModel)root).getImports()) {
				String importURI = uriResolver.resolve(imp);
				acceptor.addResourceURI(importURI);
			}
		}
		else {
			dataConfig.addReferencedModels(acceptor, root);
		}
	}
}
