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

package org.eclipse.etrice.generator.cpp.setup;

import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.base.GeneratorBaseModule;
import org.eclipse.etrice.generator.base.ITranslationProvider;
import org.eclipse.etrice.generator.cpp.Main;
import org.eclipse.etrice.generator.cpp.gen.CppTranslationProvider;
import org.eclipse.etrice.generator.cpp.gen.MainGen;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.etrice.generator.cpp.gen.CppExtensions;

import com.google.inject.Binder;

public class GeneratorModule extends GeneratorBaseModule {

//	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		
		binder.bind(AbstractGenerator.class).to(Main.class);
		binder.bind(IGenerator.class).to(MainGen.class);

		// bind language specific code to generic Interfaces
		binder.bind(ILanguageExtension.class).to(CppExtensions.class);

		binder.bind(ITranslationProvider.class).to(CppTranslationProvider.class);
		
		
		
	}

}
