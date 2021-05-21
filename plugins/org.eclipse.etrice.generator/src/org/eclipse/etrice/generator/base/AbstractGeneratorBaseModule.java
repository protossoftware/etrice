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
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.base;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider;
import org.eclipse.etrice.core.genmodel.fsm.ICommonDataCalculator;
import org.eclipse.etrice.core.genmodel.fsm.IDiagnostician;
import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.room.util.CommonDataCalculator;
import org.eclipse.etrice.generator.base.io.GeneratorFileIO;
import org.eclipse.etrice.generator.base.io.IGeneratorEMFSetup;
import org.eclipse.etrice.generator.base.logging.Logger;
import org.eclipse.etrice.generator.base.setup.GeneratorName;
import org.eclipse.etrice.generator.base.setup.GeneratorOptions;
import org.eclipse.etrice.generator.base.validation.IGeneratorResourceValidator;
import org.eclipse.etrice.generator.fsm.base.Diagnostician;
import org.eclipse.etrice.generator.fsm.generic.IDetailCodeTranslator;
import org.eclipse.etrice.generator.fsm.generic.IIfItemIdGenerator;
import org.eclipse.etrice.generator.fsm.generic.ILanguageExtensionBase;
import org.eclipse.etrice.generator.fsm.generic.IMessageIdGenerator;
import org.eclipse.etrice.generator.generic.GenericActorClassGenerator;
import org.eclipse.etrice.generator.generic.GenericProtocolClassGenerator;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

/**
 * An abstract Guice module which makes some sensible bindings.
 * Abstract methods are defined to force derived classes to create certain bindings.
 * 
 * @author Henrik Rentz-Reichert
 */
public abstract class AbstractGeneratorBaseModule implements Module {

	/**
	 * Configuration of
	 * <ul>
	 *   <li>ResourceSet to ResourceSetImpl</li>
	 *   <li>Logger as Singleton</li>
	 *   <li>ILineOutputLogger to Logger</li>
	 *   <li>ILogger to Logger</li>
	 *   <li>Diagnostician as Singleton</li>
	 *   <li>IDiagnostician to Diagnostician</li>
	 *   <li>IEncodingProvider to IEncodingProvider.Runtime</li>
	 * </ul>
	 * @see com.google.inject.Module#configure(com.google.inject.Binder)
	 */
	@Override
	public void configure(Binder binder) {
		binder.bind(ResourceSet.class).to(XtextResourceSet.class);

		// Logger and GeneratorFileIO objects should *not* be injected by dependency injection.
		// However, in order to avoid rewriting a lot of code we still provide these singletons.
		binder.bind(Logger.class).in(Singleton.class);
		binder.bind(GeneratorFileIO.class).in(Singleton.class);
		
		binder.bind(IGenerator.class).to(AbstractGenerator.class);
		if(bindIGeneratorEMFSetup() != null) {
			binder.bind(IGeneratorEMFSetup.class).to(bindIGeneratorEMFSetup());
		}
		binder.bind(String.class).annotatedWith(GeneratorName.class).toInstance(bindGeneratorName());
		binder.bind(GeneratorOptions.class).to(bindGeneratorOptions());
		binder.bind(IGeneratorResourceValidator.class).to(ModelValidator.class);
		binder.bind(Diagnostician.class).in(Singleton.class);
		binder.bind(IDiagnostician.class).to(Diagnostician.class);
		binder.bind(FSMNameProvider.class).to(RoomNameProvider.class);
		
		binder.bind(IEncodingProvider.class).to(IEncodingProvider.Runtime.class);

		binder.bind(IMessageIdGenerator.class).to(GenericProtocolClassGenerator.class);
		binder.bind(IIfItemIdGenerator.class).to(GenericActorClassGenerator.class);
		
		binder.bind(IDetailCodeTranslator.class).to(AbstractGenerator.class);
		binder.bind(ICommonDataCalculator.class).to(CommonDataCalculator.class);
		
		if(bindAbstractGenerator() != null)
			binder.bind(AbstractGenerator.class).to(bindAbstractGenerator());
		binder.bind(ILanguageExtensionBase.class).to(ILanguageExtension.class);
		
		if (bindILanguageExtension()!=null)
			binder.bind(ILanguageExtension.class).to(bindILanguageExtension());
		if (bindITranslationProvider()!=null)
			binder.bind(ITranslationProvider.class).to(bindITranslationProvider());
		if (bindIDataConfiguration()!=null)
			binder.bind(IDataConfiguration.class).to(bindIDataConfiguration());
		
		binder.bind(EValidator.Registry.class).toInstance(EValidator.Registry.INSTANCE);
		binder.bind(org.eclipse.emf.ecore.util.Diagnostician.class).to(GenerationEMFDiagnostician.class).asEagerSingleton();
	}
	
	/**
	 * Abstract method that retrieves a class to which {@link AbstractGenerator} is bound
	 * @return a Class extending {@link AbstractGenerator}
	 */
	public abstract Class<? extends AbstractGenerator> bindAbstractGenerator();
	
	
	/**
	 * Abstract method that retrieves a class to which {@link ILanguageExtension} is bound
	 * @return a Class extending {@link ILanguageExtension}
	 */
	public abstract Class<? extends ILanguageExtension> bindILanguageExtension();
	
	/**
	 * Abstract method that retrieves a class to which {@link ITranslationProvider} is bound
	 * @return a Class extending {@link ITranslationProvider}
	 */
	public abstract Class<? extends ITranslationProvider> bindITranslationProvider();
	
	/**
	 * Abstract method that retrieves a class to which {@link IDataConfiguration} is bound
	 * @return a Class extending {@link IDataConfiguration}
	 */
	public abstract Class<? extends IDataConfiguration> bindIDataConfiguration();
		
	public Class<? extends IGeneratorEMFSetup> bindIGeneratorEMFSetup() {
		return EMFSetup.class;
	}
	
	public String bindGeneratorName() {
		return "eTrice Generator";
	}

	public Class<? extends AbstractGeneratorOptions> bindGeneratorOptions() {
		return AbstractGeneratorOptions.class;
	}
	
}
