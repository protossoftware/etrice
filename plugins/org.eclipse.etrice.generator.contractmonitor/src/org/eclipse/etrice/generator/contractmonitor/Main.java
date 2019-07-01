/*******************************************************************************

 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Christian Hilden (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.contractmonitor;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.base.args.Arguments;
import org.eclipse.etrice.generator.base.io.IGeneratorFileIO;
import org.eclipse.etrice.generator.base.logging.ILogger;
import org.eclipse.etrice.generator.contractmonitor.gen.MainGen;
import org.eclipse.etrice.generator.contractmonitor.setup.GeneratorModule;

import com.google.inject.Inject;

public class Main extends AbstractGenerator {

	public static int run(String[] args) {
		return createAndRunGenerator(new GeneratorModule(), args);
	}
	
	public static void main(String[] args) {
		int ret = run(args);
		System.exit(ret);
	}
	
	@Inject MainGen mainGen;

	@Override
	protected int runGenerator(List<Resource> resources, Arguments arguments, IGeneratorFileIO fileIO, ILogger logger) {
		
		resources.forEach(res -> {
			mainGen.doGenerate(res, arguments, fileIO, logger);
		});
		
		return GENERATOR_OK;
	}
}
