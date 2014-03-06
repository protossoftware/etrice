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

package org.eclipse.etrice.generator.doc;

import java.util.Iterator;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.doc.gen.GlobalSettings;
import org.eclipse.etrice.generator.doc.gen.InstanceDiagramGen;
import org.eclipse.etrice.generator.doc.setup.GeneratorModule;
import org.eclipse.xtext.generator.IGenerator;

import com.google.inject.Inject;

public class Main extends AbstractGenerator {
	
	public static final String OPTION_GEN_INST_DIAG = "-genInstDiag";

	/**
	 * print usage message to output/console
	 */
	protected void printUsage() {
		output.println(this.getClass().getName()+getCommonOptions()
				+" <list of model file paths>");
		output.println(getCommonOptionDescriptions());
		output.println("      -genInstDiag                      # if specified then an instance diagram is created for each subsystem");
	}

	public static void main(String[] args) {
		int ret = createAndRunGenerator(new GeneratorModule(), args);
		if (isTerminateOnError() && ret!=GENERATOR_OK)
			System.exit(ret);
	}

	/**
	 * @return the unique {@link GlobalSettings}
	 */
	public static GlobalSettings getSettings() {
		return (GlobalSettings) getInstance().getGeneratorSettings();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.base.AbstractGenerator#parseOption(java.lang.String, java.util.Iterator)
	 */
	@Override
	protected boolean parseOption(String arg, Iterator<String> it) {
		if (arg.equals(OPTION_GEN_INST_DIAG)) {
			getSettings().setGenerateInstanceDiagram(true);
			return true;
		}
		
		return super.parseOption(arg, it);
	}
	
	@Inject
	private IGenerator mainGenerator;

	@Inject
	protected InstanceDiagramGen instanceDiagramGenerator;
	
	protected int runGenerator() {
		setupRoomModel();

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
			
			Root genModel = createGeneratorModel(getSettings().isGenerateAsLibrary(), getSettings().getGeneratorModelPath());
			if (diagnostician.isFailed() || genModel==null) {
				logger.logInfo("errors during build of generator model");
				logger.logError("-- terminating", null);
				return GENERATOR_ERROR;
			}
			
			logger.logInfo("-- starting code generation");
			fileAccess.setOutputPath("doc-gen/");
			mainGenerator.doGenerate(genModel.eResource(), fileAccess);
			
			if (getSettings().isGenerateInstanceDiagram()) {
				instanceDiagramGenerator.doGenerate(genModel);
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
