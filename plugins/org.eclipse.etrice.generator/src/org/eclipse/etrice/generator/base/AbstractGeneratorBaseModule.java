/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.base;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.IDiagnostician;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.xtext.parser.IEncodingProvider;

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
		binder.bind(ResourceSet.class).to(ResourceSetImpl.class);

		binder.bind(Logger.class).in(Singleton.class);
		binder.bind(ILineOutputLogger.class).to(Logger.class);
		binder.bind(ILogger.class).to(Logger.class);
		
		binder.bind(Diagnostician.class).in(Singleton.class);
		binder.bind(IDiagnostician.class).to(Diagnostician.class);
		
		binder.bind(IEncodingProvider.class).to(IEncodingProvider.Runtime.class);

		if (bindILanguageExtension()!=null)
			binder.bind(ILanguageExtension.class).to(bindILanguageExtension());
		if (bindITranslationProvider()!=null)
			binder.bind(ITranslationProvider.class).to(bindITranslationProvider());
		if (bindIDataConfiguration()!=null)
			binder.bind(IDataConfiguration.class).to(bindIDataConfiguration());
	}
	
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

}
