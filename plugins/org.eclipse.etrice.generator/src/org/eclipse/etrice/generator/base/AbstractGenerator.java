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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.genmodel.builder.GeneratorModelBuilder;
import org.eclipse.etrice.core.genmodel.builder.GeneratorModelBuilderFactory;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.generator.base.args.Arguments;
import org.eclipse.etrice.generator.base.io.IGeneratorFileIO;
import org.eclipse.etrice.generator.base.io.ILineOutput;
import org.eclipse.etrice.generator.base.io.LineOutput;
import org.eclipse.etrice.generator.base.logging.ILogger;
import org.eclipse.etrice.generator.fsm.base.Diagnostician;
import org.eclipse.etrice.generator.fsm.generic.IDetailCodeTranslator;
import org.eclipse.etrice.generator.generic.TestInstanceCreator;

import com.google.inject.Inject;
import com.google.inject.Module;

/**
 * A base class for generators of ROOM models.
 * 
 * <p>
 * As examples see
 * <ul>
 *   <li>the {@link org.eclipse.etrice.generator.c.Main C generator}</li>
 *   <li>the {@link org.eclipse.etrice.generator.cpp.Main C++ generator}</li>
 *   <li>the {@link org.eclipse.etrice.generator.java.Main Java generator}</li>
 * </ul>
 * </p>
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class AbstractGenerator implements IGenerator, IDetailCodeTranslator {

	/**
	 * constant used as return value of {@link #runGenerator())}
	 * @see #GENERATOR_ERROR
	 */
	public static final int GENERATOR_OK = 0;
	
	/**
	 * constant used as return value of {@link #runGenerator()}
	 * @see #GENERATOR_OK
	 */
	public static final int GENERATOR_ERROR = 1;
	
	@Deprecated
	protected static ILineOutput output = new LineOutput();
	private static Arguments settings = null;
	
	/**
	 * The generator settings can also be statically accessed using {@link #getInstance()} followed
	 * by a call to this method.
	 * 
	 * @return the {@link #generatorSettings}
	 */
	public static Arguments getSettings() {
		return settings;
	}
	
	/**
	 * This method can be used to achieve different output behavior: in stand alone mode this might
	 * be just the console, inside Eclipse this rather would be the console view
	 * 
	 * @param out an {@link ILineOutput}
	 * @deprecated
	 */
	public static void setOutput(ILineOutput out) {
		if (out != null)
			output = out;
	}
	
	/**
	 * creates an instance of the generator and invokes the {@link #runGenerator(String[])} method
	 * @param generatorModule a Guice module from which the {@link com.google.inject.Injector Injector} is created
	 * @param args the command line arguments
	 * @return GENERATOR_OK or GENERATOR_ERROR
	 */
	public static int createAndRunGenerator(Module generatorModule, String[] args) {
		int ret = GENERATOR_OK;
		GeneratorApplication genAppl = GeneratorApplication.create(generatorModule);
		try {
			genAppl.run(args, output);
		}
		catch(GeneratorException e) {
			ret = GENERATOR_ERROR;
		}
		return ret;
	}
	
	/**
	 * The injected diagnostician
	 */
	@Inject
	protected Diagnostician diagnostician;
	
	/**
	 * The injected translation provider
	 */
	@Inject
	protected ITranslationProvider translationProvider;
	
	@Inject
	private GeneratorModelBuilderFactory genModelBuilderFactory;
	
	private HashMap<DetailCode, String> detailcode2string = new HashMap<DetailCode, String>();
	private ResourceSet resourceSet = null;
	
	@Override
	public void generate(List<Resource> resources, Arguments arguments, IGeneratorFileIO fileIO, ILogger logger) {
		AbstractGenerator.settings = arguments;
		diagnostician.setFailed(false);
		
		if(resources.isEmpty()) {
			logger.logError("no input files");
			logger.logInfo("-- terminating");
			throw new GeneratorException("can't determine resource set without input files");
		}
		resourceSet = resources.get(0).getResourceSet();
		
		int ret = runGenerator(resources, arguments, fileIO, logger);
		if(ret == GENERATOR_OK) {
			logger.logInfo("-- finished");
		}
		else {
			logger.logInfo("-- terminating");
			throw new GeneratorException("generator error");
		}
		
		detailcode2string.clear();
	}
	
	/**
	 * abstract method which is finally called by {@link #createAndRunGenerator(Module, String[])}
	 * @param resources a list of the main models
	 * @param arguments the generator arguments
	 * @param fileIO the generator file io
	 * @param logger the logger
	 * @return GENERATOR_OK or GENERATOR_ERROR
	 */
	protected abstract int runGenerator(List<Resource> resources, Arguments arguments, IGeneratorFileIO fileIO, ILogger logger);

	/**
	 * This resource set combines all resources processed by the generator
	 * @return the resource set for the input models
	 */
	protected ResourceSet getResourceSet() {
		return resourceSet;
	}
	
	/**
	 * 
	 * Use {@link #createGeneratorModel(List, Arguments, IGeneratorFileIO, ILogger)}
	 * 
	 * @param resources the list of models
	 * @param arguments the generator arguments
	 * @return the {@link Root} object of the generator model (is added to a new Resource also)
	 * 
	 */
	@Deprecated
	protected Root createGeneratorModel(List<Resource> resources, Arguments arguments, ILogger logger) {
		return createGeneratorModel(resources, arguments, null, logger);
	}

	/**
	 * @param resources the list of models
	 * @param arguments the generator arguments
	 * @return the {@link Root} object of the generator model (is added to a new Resource also)
	 */
	protected Root createGeneratorModel(List<Resource> resources, Arguments arguments, IGeneratorFileIO fileIO, ILogger logger) {
		boolean doTranslate = !arguments.get(AbstractGeneratorOptions.NOTRANSLATE);
		boolean asLibrary = arguments.get(AbstractGeneratorOptions.LIB);
		String genModelPath = arguments.get(AbstractGeneratorOptions.SAVE_GEN_MODEL);
		Set<URI> mainModelURIs = resources.stream().map(m -> m.getURI()).collect(Collectors.toSet());
		
		// create instance and mapping for test instances
		List<Resource> testInstanceResources = new TestInstanceCreator(logger, diagnostician).createInstancesAndMapping(
				mainModelURIs, getResourceSet());
		if (testInstanceResources==null) {
			return null;
		}
		
		// create a list of ROOM models
		List<RoomModel> mainModels = new ArrayList<RoomModel>();
		List<RoomModel> importedModels = new ArrayList<RoomModel>();
		for (Resource resource : getResourceSet().getResources()) {
			boolean isMainModel = mainModelURIs.contains(resource.getURI());
			for (EObject content : resource.getContents()){
				if (content instanceof RoomModel) {
					if (isMainModel) {
						mainModels.add((RoomModel) content);
					}
					else {
						importedModels.add((RoomModel) content);
					}
				}
			}
		}
		if (!testInstanceResources.isEmpty()) {
			for (Resource resource : testInstanceResources) {
				for (EObject content : resource.getContents()){
					if (content instanceof RoomModel) {
						mainModels.add((RoomModel) content);
					}
				}
			}
		}
		if (importedModels.isEmpty() && mainModels.isEmpty()) {
			logger.logError("no ROOM models found");
			return null;
		}
		else {			
			logger.logInfo("-- creating generator model");
			GeneratorModelBuilder gmb = genModelBuilderFactory.create(logger, diagnostician);
			Root gmRoot = gmb.createGeneratorModel(mainModels, importedModels, asLibrary);
			if (diagnostician.isFailed()) {
				logger.logError("validation failed during build of generator model");
				return null;
			}
			
			translateDetailCodes(gmRoot, doTranslate);
			
			URI genModelURI = !genModelPath.isEmpty() ? URI.createFileURI(genModelPath) : URI.createFileURI("tmp.rim");
			Resource genResource = getResourceSet().createResource(genModelURI);
			genResource.getContents().add(gmRoot);
			if (!genModelPath.isEmpty()) {
				try {
					logger.logInfo("saving genmodel to "+genModelPath);
					if(fileIO != null) {
						// use fileIO with cleanDirectory
						ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
						genResource.save(outputStream, Collections.EMPTY_MAP);
						fileIO.generateFile(genModelURI.toFileString(), outputStream.toString());
					} else {
						// fallback
						genResource.save(Collections.EMPTY_MAP);
					}
				}
				catch (IOException e) {
					logger.logError(e.getMessage());
					return null;
				}
			}
			return gmRoot;
		}
	}

	/**
	 * Create detail code translations once and for all.
	 * This method is called by {@link #createGeneratorModel(boolean, String)} after all models
	 * have been read and validated and the transformation into a generator model succeeded.
	 * 
	 * <p>
	 * The translation of a detail code can be looked up from a map by a call to
	 * {@link #getTranslatedCode(DetailCode)}.
	 * </p>
	 * 
	 * @param gmRoot
	 */
	protected void translateDetailCodes(Root gmRoot, boolean doTranslate) {
		
		for (ExpandedActorClass xpac : gmRoot.getXpActorClasses()) {
			DetailCodeTranslator dct = new DetailCodeTranslator(xpac.getActorClass(), translationProvider, doTranslate);
			translateDetailCodesOfTree(xpac.getActorClass(), dct);
			List<DetailCode> allDetailCodes = FsmGenExtensions.getAllDetailCodes(xpac.getGraphContainer().getGraph());
			for (DetailCode dc : allDetailCodes) {
				detailcode2string.put(dc, dct.translateDetailCode(dc));
			}
		}
		
		for (DataClass dc : gmRoot.getDataClasses()) {
			DetailCodeTranslator dct = new DetailCodeTranslator(dc, translationProvider, doTranslate);
			translateDetailCodesOfTree(dc, dct);
		}
		
		for (ProtocolClass pc : gmRoot.getProtocolClasses()) {
			if (pc.getConjugated()!=null) {
				DetailCodeTranslator dct = new DetailCodeTranslator(pc.getConjugated(), translationProvider, doTranslate);
				translateDetailCodesOfTree(pc.getConjugated(), dct);
			}
			if (pc.getRegular()!=null) {
				DetailCodeTranslator dct = new DetailCodeTranslator(pc.getRegular(), translationProvider, doTranslate);
				translateDetailCodesOfTree(pc.getRegular(), dct);
			}
			
			DetailCodeTranslator dct = new DetailCodeTranslator(pc, translationProvider, doTranslate);
			translateDetailCodesOfTree(pc.getUserCode1(), dct);
			translateDetailCodesOfTree(pc.getUserCode2(), dct);
			translateDetailCodesOfTree(pc.getUserCode3(), dct);
		}
	}
	
	/**
	 * Creates translations for all {@link DetailCode}s found in the {@link EObject#eAllContents()}.
	 * 
	 * @param container the root of an {@link EObject} containment tree that should be translated
	 * @param dct the {@link DetailCodeTranslator} to apply
	 */
	protected void translateDetailCodesOfTree(EObject container, DetailCodeTranslator dct) {
		if (container==null)
			return;
		if (container instanceof DetailCode) {
			DetailCode dc = (DetailCode) container;
			detailcode2string.put(dc, dct.translateDetailCode(dc));
			return;
		}
		
		TreeIterator<EObject> it = container.eAllContents();
		while (it.hasNext()) {
			EObject obj = it.next();
			if (obj instanceof DetailCode) {
				DetailCode dc = (DetailCode) obj;
				detailcode2string.put(dc, dct.translateDetailCode(dc));
			}
		}
	}

	/**
	 * @param dc a {@link DetailCode}
	 * @return the mapped result of the translation or an empty string
	 */
	public String getTranslatedCode(DetailCode dc) {
		String code = detailcode2string.get(dc);
		if (code==null)
			return "";
		return code;
	}

}