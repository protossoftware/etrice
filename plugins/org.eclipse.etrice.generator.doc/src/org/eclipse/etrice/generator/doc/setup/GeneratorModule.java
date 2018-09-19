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

package org.eclipse.etrice.generator.doc.setup;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.etrice.core.genmodel.fsm.IDiagnostician;
import org.eclipse.etrice.generator.base.EMFSetup;
import org.eclipse.etrice.generator.base.GenerationEMFDiagnostician;
import org.eclipse.etrice.generator.base.IGenerator;
import org.eclipse.etrice.generator.base.ITranslationProvider;
import org.eclipse.etrice.generator.base.ModelLoader;
import org.eclipse.etrice.generator.base.ModelValidator;
import org.eclipse.etrice.generator.base.io.GeneratorFileIO;
import org.eclipse.etrice.generator.base.io.IGeneratorEMFSetup;
import org.eclipse.etrice.generator.base.io.IGeneratorResourceLoader;
import org.eclipse.etrice.generator.base.logging.Logger;
import org.eclipse.etrice.generator.base.setup.GeneratorName;
import org.eclipse.etrice.generator.base.setup.GeneratorOptions;
import org.eclipse.etrice.generator.base.validation.IGeneratorResourceValidator;
import org.eclipse.etrice.generator.doc.Main;
import org.eclipse.etrice.generator.doc.gen.DocTranslationProvider;
import org.eclipse.etrice.generator.fsm.base.Diagnostician;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

public class GeneratorModule implements Module {

	public static final String GENERATOR_NAME = "eTrice Documentation Generator";
	
	@Override
	public void configure(Binder binder) {
		binder.bind(String.class).annotatedWith(GeneratorName.class).toInstance(GENERATOR_NAME);
		binder.bind(GeneratorOptions.class).to(DocGeneratorOptions.class);
		binder.bind(IGeneratorResourceLoader.class).to(ModelLoader.class);
		binder.bind(IGeneratorEMFSetup.class).to(EMFSetup.class);
		binder.bind(IGeneratorResourceValidator.class).to(ModelValidator.class);
		binder.bind(IGenerator.class).to(Main.class);
		
		binder.bind(ResourceSet.class).to(ResourceSetImpl.class);
		binder.bind(Logger.class).in(Singleton.class);
		binder.bind(GeneratorFileIO.class).in(Singleton.class);
		binder.bind(IDiagnostician.class).to(Diagnostician.class);
		binder.bind(Diagnostician.class).in(Singleton.class);
		binder.bind(ITranslationProvider.class).to(DocTranslationProvider.class);
		
		binder.bind(EValidator.Registry.class).toInstance(EValidator.Registry.INSTANCE);
		binder.bind(org.eclipse.emf.ecore.util.Diagnostician.class).to(GenerationEMFDiagnostician.class).asEagerSingleton();
	}

}
