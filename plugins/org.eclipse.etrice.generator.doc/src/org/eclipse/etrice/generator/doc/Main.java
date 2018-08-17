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
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.base.args.Arguments;
import org.eclipse.etrice.generator.doc.gen.InstanceDiagramGen;
import org.eclipse.etrice.generator.doc.gen.MainGen;
import org.eclipse.etrice.generator.doc.setup.GeneratorModule;
import org.eclipse.etrice.generator.doc.setup.GeneratorOptions;

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
	
	protected int runGenerator(List<Resource> resources, Arguments arguments) {

		Root genModel = createGeneratorModel(resources, arguments);
		if (diagnostician.isFailed() || genModel==null) {
			logger.logError("errors during build of generator model");
			return GENERATOR_ERROR;
		}
		
		logger.logInfo("-- starting code generation");
		mainGenerator.doGenerate(genModel.eResource());
		
		if (arguments.get(GeneratorOptions.GEN_INST_DIAG)) {
			instanceDiagramGenerator.doGenerate(genModel);
		}
		
		if (diagnostician.isFailed()) {
			logger.logError("errors during code generation");
			return GENERATOR_ERROR;
		}
		
		return GENERATOR_OK;
	}
}
