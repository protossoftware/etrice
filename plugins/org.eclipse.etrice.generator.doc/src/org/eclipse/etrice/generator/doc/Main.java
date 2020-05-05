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

package org.eclipse.etrice.generator.doc;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.etmap.util.ETMapUtil;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.base.args.Arguments;
import org.eclipse.etrice.generator.base.io.IGeneratorFileIO;
import org.eclipse.etrice.generator.base.logging.ILogger;
import org.eclipse.etrice.generator.doc.gen.InstanceDiagramGen;
import org.eclipse.etrice.generator.doc.gen.MainGen;
import org.eclipse.etrice.generator.doc.setup.GeneratorModule;

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
	protected InstanceDiagramGen instanceDiagramGenerator;
	
	protected int runGenerator(List<Resource> resources, Arguments arguments, IGeneratorFileIO fileIO, ILogger logger) {
		Root genModel = createGeneratorModel(resources, arguments, logger);
		if (diagnostician.isFailed() || genModel==null) {
			logger.logError("errors during build of generator model");
			return GENERATOR_ERROR;
		}
		
		ETMapUtil.processModels(genModel, getResourceSet(), diagnostician);
		
		mainGenerator.doGenerate(genModel, arguments, fileIO);
		
		return GENERATOR_OK;
	}
}
