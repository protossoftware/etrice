/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
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

package my.etrice.generator.setup;

import my.etrice.generator.DerivedGenerator;
import my.etrice.generator.gen.DerivedTranslationProvider;

import org.eclipse.etrice.generator.base.ITranslationProvider;
import org.eclipse.etrice.generator.java.Main;
import org.eclipse.etrice.generator.java.setup.GeneratorModule;

import com.google.inject.Binder;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class DerivedGeneratorModule extends GeneratorModule {

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.java.setup.GeneratorModule#configure(com.google.inject.Binder)
	 */
	@Override
	public void configure(Binder binder) {
		// EXAMPLE: invoke base class configuration
		super.configure(binder);
		
		// EXAMPLE: override already bound AbstractGenerator -> Main
		binder.bind(Main.class).to(DerivedGenerator.class);
	}

	/**
	 * EXAMPLE: override the translation provider
	 * NOTE: in the minimal setting not necessary
	 * 
	 * @see org.eclipse.etrice.generator.java.setup.GeneratorModule#bindITranslationProvider()
	 */
	@Override
	public Class<? extends ITranslationProvider> bindITranslationProvider() {
		return DerivedTranslationProvider.class;
	}
}
