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
 * 		Christian Hilden (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.contractmonitor.setup;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.core.common.base.BaseFactory;
import org.eclipse.etrice.core.common.scoping.ModelPathGlobalScopeProvider;
import org.eclipse.etrice.core.common.scoping.ModelPathGlobalScopeProvider.IModelPathFileFilter;
import org.eclipse.etrice.core.fsm.fSM.FSMFactory;
import org.eclipse.etrice.core.genmodel.fsm.ICommonDataCalculator;
import org.eclipse.etrice.core.genmodel.fsm.IDiagnostician;
import org.eclipse.etrice.core.naming.RoomQualifiedNameProvider;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.util.CommonDataCalculator;
import org.eclipse.etrice.core.scoping.RoomModelPathFileExtensionFilter;
import org.eclipse.etrice.generator.base.AbstractGeneratorOptions;
import org.eclipse.etrice.generator.base.DefaultTranslationProvider;
import org.eclipse.etrice.generator.base.EMFSetup;
import org.eclipse.etrice.generator.base.GenerationEMFDiagnostician;
import org.eclipse.etrice.generator.base.IGenerator;
import org.eclipse.etrice.generator.base.ITranslationProvider;
import org.eclipse.etrice.generator.base.io.IGeneratorEMFSetup;
import org.eclipse.etrice.generator.base.setup.GeneratorName;
import org.eclipse.etrice.generator.base.setup.GeneratorOptions;
import org.eclipse.etrice.generator.base.validation.IGeneratorResourceValidator;
import org.eclipse.etrice.generator.contractmonitor.Main;
import org.eclipse.etrice.generator.contractmonitor.util.ContractModelValidator;
import org.eclipse.etrice.generator.fsm.base.Diagnostician;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

public class GeneratorModule implements Module {
		
	public static final String GENERATOR_NAME = "Contract Monitor Generator";
	
	@Override
	public void configure(Binder binder) {
		
		// TODO this should be a common module in etrice
		binder.bind(IGeneratorEMFSetup.class).to(EMFSetup.class);
//		binder.bind(IGeneratorResourceValidator.class).to(ModelValidator.class);
		binder.bind(IGenerator.class).to(Main.class);	
		binder.bind(ResourceSet.class).to(XtextResourceSet.class);
		binder.bind(IDiagnostician.class).to(Diagnostician.class);
		binder.bind(Diagnostician.class).in(Singleton.class);
		binder.bind(ITranslationProvider.class).to(DefaultTranslationProvider.class);
		binder.bind(ICommonDataCalculator.class).to(CommonDataCalculator.class);	
		binder.bind(EValidator.Registry.class).toInstance(EValidator.Registry.INSTANCE);
		binder.bind(org.eclipse.emf.ecore.util.Diagnostician.class).to(GenerationEMFDiagnostician.class).asEagerSingleton();
		binder.bind(GeneratorOptions.class).to(AbstractGeneratorOptions.class);
		
		// contract monitor generator specific
		binder.bind(IGeneratorResourceValidator.class).to(ContractModelValidator.class);
		binder.bind(String.class).annotatedWith(GeneratorName.class).toInstance(GENERATOR_NAME);
		binder.bind(BaseFactory.class).toInstance(BaseFactory.eINSTANCE);
		binder.bind(RoomFactory.class).toInstance(RoomFactory.eINSTANCE);
		binder.bind(FSMFactory.class).toInstance(FSMFactory.eINSTANCE);
		binder.bind(FSMFactory.class).toInstance(FSMFactory.eINSTANCE);	
		
		binder.bind(IQualifiedNameProvider.class).to(RoomQualifiedNameProvider.class);
		binder.bind(IGlobalScopeProvider.class).to(ModelPathGlobalScopeProvider.class);
		binder.bind(IResourceDescriptions.class).to(ResourceSetBasedResourceDescriptions.class);
		binder.bind(IModelPathFileFilter.class).to(RoomModelPathFileExtensionFilter.class);
	}


}
