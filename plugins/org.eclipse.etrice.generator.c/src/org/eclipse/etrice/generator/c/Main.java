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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.c.gen.Validator;
import org.eclipse.etrice.generator.c.setup.GeneratorModule;
import org.eclipse.xtext.generator.IGenerator;

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
 *   <li></li>
 *   <li></li>
 *   <li></li>
 *   <li></li>
 *   <li></li>
 *   <li></li>
 *   <li></li>
 *   <li></li>
 * </ul>
 * </p>
 *  
 * @author Henrik Rentz-Reichert
 *
 */
public class Main extends AbstractGenerator {
	
	public static final String OPTION_LIB = "-lib";
	public static final String OPTION_NOEXIT = "-noexit";
	public static final String OPTION_GEN_INST_DIAG = "-genInstDiag";
	public static final String OPTION_SAVE_GEN_MODEL = "-saveGenModel";

	/**
	 * print usage message to stderr
	 */
	private static void printUsage() {
		output.println(Main.class.getName()+" [-saveGenModel <genmodel path>] [-genInstDiag] [-lib] <list of model file paths>");
		output.println("      <list of model file paths>        # model file paths may be specified as");
		output.println("                                        # e.g. C:\\path\\to\\model\\mymodel.room");
		output.println("      -saveGenModel <genmodel path>     # if specified the generator model will be saved to this location");
		output.println("      -genInstDiag                      # if specified an instance diagram is created for each subsystem");
		output.println("      -lib                              # if specified all classes are generated and no instances");
		output.println("      -noexit                           # if specified the JVM is not exited");
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
	
	
	public int runGenerator(String[] args) {
		if (args.length == 0) {
			logger.logError(Main.class.getName()+" - aborting: no arguments!", null);
			printUsage();
			return GENERATOR_ERROR;
		}

		// parsing arguments
		String genModelPath = null;
		List<String> uriList = new ArrayList<String>();
		boolean genInstDiag = false;
		boolean asLibrary = false;
		for (int i=0; i<args.length; ++i) {
			if (args[i].equals(OPTION_SAVE_GEN_MODEL)) {
				if (++i<args.length) {
					genModelPath = args[i]+"/genmodel.egm";
				}
			}
			else if (args[i].equals(OPTION_GEN_INST_DIAG)) {
				genInstDiag = true;
			}
			else if (args[i].equals(OPTION_LIB)) {
				asLibrary = true;
			}
			else if (args[i].equals(OPTION_NOEXIT)) {
				setTerminateOnError(false);
			}
			else {
				uriList.add(args[i]);
			}
		}

		setupRoomModel();
		dataConfig.doSetup();

		if (!runGenerator(uriList, genModelPath, genInstDiag, asLibrary))
			return GENERATOR_ERROR;
		
		return GENERATOR_OK;
	}

	protected boolean runGenerator(List<String> uriList, String genModelPath, boolean genInstDiag, boolean asLibrary) {
		loadModels(uriList);

		if (!validateModels())
			return false;

		if(!dataConfig.setResources(getResourceSet(), logger))
			return false;
		
		Root genModel = createGeneratorModel(asLibrary, genModelPath);
		if (genModel==null)
			return false;
		
		if (!validator.validate(genModel))
			return false;
		
		logger.logInfo("-- starting code generation");
		fileAccess.setOutputPath("src-gen/");
		mainGenerator.doGenerate(genModel.eResource(), fileAccess);
		
		if (genInstDiag) {
			mainDocGenerator.doGenerate(genModel);
		}
		
		if (diagnostician.isFailed()) {
			logger.logInfo("validation failed during build of generator model");
			logger.logError("-- terminating", null);
			return false;
		}
		logger.logInfo("-- finished code generation");
		
		return true;
	}
}
