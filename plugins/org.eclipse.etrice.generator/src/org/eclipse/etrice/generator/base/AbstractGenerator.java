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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.core.common.scoping.ModelLocator;
import org.eclipse.etrice.core.common.scoping.ModelLocatorUriResolver;
import org.eclipse.etrice.core.common.scoping.StandardModelLocator;
import org.eclipse.etrice.core.genmodel.builder.GeneratorModelBuilder;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.IDiagnostician;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provider;

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
public abstract class AbstractGenerator {
	
	public static final String OPTION_LIB = "-lib";
	public static final String OPTION_NOEXIT = "-noexit";
	public static final String OPTION_DOCUMENTATION = "-genDocu";
	public static final String OPTION_SAVE_GEN_MODEL = "-saveGenModel";
	public static final String OPTION_GEN_INCREMENTAL = "-inc";
	public static final String OPTION_GEN_DIR = "-genDir";
	public static final String OPTION_GEN_INFO_DIR = "-genInfoDir";
	public static final String OPTION_GEN_DOC_DIR = "-genDocDir";
	public static final String OPTION_MSC = "-msc_instr";
	public static final String OPTION_VERBOSE_RT = "-gen_as_verbose";
	public static final String OPTION_DEBUG = "-debug";
	public static final String OPTION_NOTRANSLATE = "-notranslate";

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
	
	private static boolean terminateOnError = true;
	private static AbstractGenerator instance = null;

	protected static ILineOutput output = new StdLineOutput();
	private static Injector injector;
	
	private HashMap<DetailCode, String> detailcode2string = new HashMap<DetailCode, String>();

	/**
	 * determines the behavior of the generator on exit
	 * 
	 * @param terminateOnError a flag that determines shut down behavior
	 * (this behavior is implemented in the concrete generator defining <code>main()</code>)
	 * 
	 * @see #isTerminateOnError()
	 */
	public static void setTerminateOnError(boolean terminateOnError) {
		AbstractGenerator.terminateOnError = terminateOnError;
	}
	
	/**
	 * If ran in stand alone mode in a separate JVM e.g. in a makefile then it is desirable to terminate
	 * the JVM with an error code to let the make program fail.
	 * 
	 * <p>
	 * If ran inside Eclipse we better don't terminate the JVM in case of an error because this
	 * would also shut down Eclipse.
	 * </p>
	 * 
	 * @return <code>true</code> if the JVM should be terminated on exit with an error code.
	 */
	public static boolean isTerminateOnError() {
		return terminateOnError;
	}

	/**
	 * This method can be used to achieve different output behavior: in stand alone mode this might
	 * be just the console, inside Eclipse this rather would be the console view
	 * 
	 * @param out an {@link ILineOutput}
	 */
	public static void setOutput(ILineOutput out) {
		if (out!=null)
			output = out;
	}
	
	/**
	 * It is assumed (though not enforced) that the generator is a singleton.
	 * 
	 * @return the singleton {@link AbstractGenerator}
	 */
	public static AbstractGenerator getInstance() {
		return instance;
	}
	
	/**
	 * The protected constructor is setting the {@link #instance} static member
	 */
	protected AbstractGenerator() {
		instance = this;
	}

	/**
	 * creates an instance of the generator and invokes the {@link #runGenerator(String[])} method
	 * @param generatorModule a Guice module from which the {@link com.google.inject.Injector Injector} is created
	 * @param args the command line arguments
	 * @return GENERATOR_OK or GENERATOR_ERROR
	 */
	protected static int createAndRunGenerator(Module generatorModule, String[] args) {
		injector = Guice.createInjector(generatorModule);
		AbstractGenerator generator = injector.getInstance(AbstractGenerator.class);
		generator.logger.setOutput(output);
		
		if (!generator.parseOptions(args))
			return GENERATOR_ERROR;
		
		return generator.runGenerator();
	}

	/**
	 * Initialize {@link GlobalGeneratorSettings} and parse all options by calling
	 * {@link #parseOption(String, Iterator)}.
	 * 
	 * @param args the command line arguments
	 * @return {@code true} if all options could be parsed successfully
	 */
	protected boolean parseOptions(String[] args) {
		if (args.length == 0) {
			return usageError("no arguments!");
		}
		
		// default settings
		RoomExtensions.setDefaultGenDir();
		RoomExtensions.setDefaultGenInfoDir();
		RoomExtensions.setDefaultGenDocDir();
		IncrementalGenerationFileIo.setGenerateIncremental(false);
		
		List<String> argList = Arrays.asList(args);
		for (Iterator<String> it = argList.iterator(); it.hasNext();) {
			if (!parseOption(it.next(), it))
				return false;
		}
		
		return true;
	}

	/**
	 * This method may be overridden by the concrete generator. After checking options super should be called
	 * and its return value should be returned.
	 * 
	 * <p>
	 * The following options are recognized
	 * <ul>
	 * <li>{@value #OPTION_DEBUG}</li>
	 * <li>{@value #OPTION_NOTRANSLATE}</li>
	 * <li>{@value #OPTION_DOCUMENTATION}</li>
	 * <li>{@value #OPTION_GEN_DIR}</li>
	 * <li>{@value #OPTION_GEN_DOC_DIR}</li>
	 * <li>{@value #OPTION_GEN_INCREMENTAL}</li>
	 * <li>{@value #OPTION_GEN_INFO_DIR}</li>
	 * <li>{@value #OPTION_LIB}</li>
	 * <li>{@value #OPTION_MSC}</li>
	 * <li>{@value #OPTION_NOEXIT}</li>
	 * <li>{@value #OPTION_SAVE_GEN_MODEL}</li>
	 * <li>{@value #OPTION_VERBOSE_RT}</li>
	 * </ul>
	 * </p>
	 * 
	 * @param arg the current argument
	 * @param it an iterator to retrieve subsequent arguments
	 * @return {@code true} if the option was parsed successfully
	 */
	protected boolean parseOption(String arg, Iterator<String> it) {
		if (arg.equals(OPTION_SAVE_GEN_MODEL)) {
			if (it.hasNext()) {
				generatorSettings.setGeneratorModelPath(it.next()+"/genmodel.egm");
			}
			else {
				return usageError(OPTION_SAVE_GEN_MODEL+" needs path");
			}
		}
		else if (arg.equals(OPTION_GEN_DIR)) {
			if (it.hasNext()) {
				RoomExtensions.setGenDir(it.next());
			}
			else {
				return usageError(OPTION_GEN_DIR+" needs directory");
			}
		}
		else if (arg.equals(OPTION_GEN_INFO_DIR)) {
			if (it.hasNext()) {
				RoomExtensions.setGenInfoDir(it.next());
			}
			else {
				return usageError(OPTION_GEN_INFO_DIR+" needs directory");
			}
		}
		else if (arg.equals(OPTION_GEN_DOC_DIR)) {
			if (it.hasNext()) {
				RoomExtensions.setGenDocDir(it.next());
			}
			else {
				return usageError(OPTION_GEN_DOC_DIR+" needs directory");
			}
		}
		else if (arg.equals(OPTION_GEN_INCREMENTAL)) {
			IncrementalGenerationFileIo.setGenerateIncremental(true);
		}
		else if (arg.equals(OPTION_DOCUMENTATION)) {
			generatorSettings.setGenerateDocumentation(true);
		}
		else if (arg.equals(OPTION_LIB)) {
			generatorSettings.setGenerateAsLibrary(true);
		}
		else if (arg.equals(OPTION_NOEXIT)) {
			setTerminateOnError(false);
		}
		else if (arg.equals(OPTION_MSC)) {
			generatorSettings.setGenerateMSCInstrumentation(true);
		}
		else if (arg.equals(OPTION_NOTRANSLATE)) {
			generatorSettings.setNoTranslation(true);
		}
		else if (arg.equals(OPTION_VERBOSE_RT)) {
			generatorSettings.setGenerateWithVerboseOutput(true);
		}
		else if (arg.equals(OPTION_DEBUG)) {
			generatorSettings.setDebugMode(true);
		}
		else {
			generatorSettings.getInputModelURIs().add(arg);
		}
		
		return true;
	}

	/**
	 * This method logs an error followed by a call to {@link #printUsage()}.
	 * 
	 * @param text the error text to be shown
	 * @return {@code false}
	 */
	protected boolean usageError(String text) {
		logger.logError(this.getClass().getName() + " - aborting: " + text, null);
		printUsage();
		return false;
	}

	/**
	 * This method should show all possible command line options together with a
	 * description. It is supposed to use {@link #getCommonOptions()} and
	 * {@link #getCommonOptionDescriptions()}.
	 */
	protected abstract void printUsage();

	protected String getCommonOptions() {
		return " ["+OPTION_SAVE_GEN_MODEL+" <genmodel path>]"
				+" ["+OPTION_DOCUMENTATION+"]"
				+" ["+OPTION_LIB+"]"
				+" ["+OPTION_NOEXIT+"]"
				+" ["+OPTION_SAVE_GEN_MODEL+" <genmodel path>]"
				+" ["+OPTION_GEN_INCREMENTAL
				+" ["+OPTION_GEN_DIR+" <generation directory>]"
				+" ["+OPTION_GEN_INFO_DIR+" <generation info directory>]"
				+" ["+OPTION_GEN_DOC_DIR+" <gen documentation directory>]"
				+" ["+OPTION_DEBUG+"]"
				+" ["+OPTION_MSC+"]"
				+" ["+OPTION_VERBOSE_RT+"]";
	}
	
	protected String getCommonOptionDescriptions() {
		return
			 "      <list of model file paths>         # model file paths may be specified as\n"
			+"                                         # e.g. C:\\path\\to\\model\\mymodel.room\n"
			+"      -genDocu                           # if specified documentation is created\n"
			+"      -lib                               # if specified all classes are generated and no instances\n"
			+"      -noexit                            # if specified the JVM is not exited\n"
			+"      -saveGenModel <genmodel path>      # if specified the generator model will be saved to this location\n"
			+"      -inc                               # if specified the generation is incremental\n"
			+"      -genDir <generation directory>     # the directory for generated files\n"
			+"      -genInfoDir <generation info dir>  # the directory for generated info files\n"
			+"      -genDocDir <gen documentation dir> # the directory for generated documentation files\n"
			+"      -debug                             # if specified create debug output\n"
			+"      -msc_instr                         # generate instrumentation for MSC generation\n"
			+"      -gen_as_verbose                    # generate instrumentation for verbose console output";
	}
	
	/**
	 * Provides access to the Guice injector of the generator.
	 * This is useful if classes with injected dependencies are instantiated manually.
	 * 
	 * @return the Guice {@link com.google.inject.Injector Injector}
	 */
	public static Injector getInjector() {
		return injector;
	}
	
	/**
	 * The injected resource set provider
	 */
	@Inject
	protected Provider<ResourceSet> resourceSetProvider;

	/**
	 * The injected logger
	 */
	@Inject
	protected ILineOutputLogger logger;
	
	/**
	 * The injected diagnostician
	 */
	@Inject
	protected IDiagnostician diagnostician;
	
	/**
	 * The injected platform relative URI resolver
	 */
	@Inject
	protected ModelLocatorUriResolver uriResolver;
	
	private StandardModelLocator modelLocator = null;
	
	/**
	 * The injected translation provider
	 */
	@Inject
	protected ITranslationProvider translationProvider;
	
	@Inject
	protected GlobalGeneratorSettings generatorSettings;
	
	@Inject
	private ModelLoader modelLoader;
	
	/**
	 * The rsource validator which is injected using the ROOM DSL injector
	 */
	protected IResourceValidator validator;

	/**
	 * This resource set combines all resources processed by the generator
	 * @return the resource set for the input models
	 */
	protected ResourceSet getResourceSet() {
		return modelLoader.getResourceSet();
	}

	/**
	 * setup the ROOM core model plug-in and create a validator using injection
	 */
	protected void setupRoomModel() {
		Injector roomInjector;
		if (EMFPlugin.IS_ECLIPSE_RUNNING)
			roomInjector = new org.eclipse.etrice.core.RoomStandaloneSetup().createInjector();
		else
			roomInjector = new org.eclipse.etrice.core.RoomStandaloneSetup().createInjectorAndDoEMFRegistration();
		validator = roomInjector.getInstance(IResourceValidator.class);
		org.eclipse.etrice.core.genmodel.SetupGenmodel.doSetup();
	}

	/**
	 * @param genModelPath path to store the generator model (not stored if {@code null})
	 * 
	 * @return the {@link Root} object of the generator model (is added to a new Resource also)
	 */
	protected Root createGeneratorModel(boolean asLibrary, String genModelPath) {
		// create a list of ROOM models
		List<RoomModel> rml = new ArrayList<RoomModel>();
		for (Resource resource : getResourceSet().getResources()) {
			List<EObject> contents = resource.getContents();
			if (!contents.isEmpty() && contents.get(0) instanceof RoomModel) {
				rml.add((RoomModel)contents.get(0));
			}
		}
		if (rml.isEmpty()) {
			logger.logError("no ROOM models found", null);
			logger.logError("-- terminating", null);
			return null;
		}
		else {
			logger.logInfo("-- creating generator model");
			GeneratorModelBuilder gmb = new GeneratorModelBuilder(logger, diagnostician);
			Root gmRoot = gmb.createGeneratorModel(rml, asLibrary);
			if (diagnostician.isFailed()) {
				logger.logError("validation failed during build of generator model", null);
				logger.logError("-- terminating", null);
				return null;
			}
			
			translateDetailCodes(gmRoot);
			
			URI genModelURI = genModelPath!=null? URI.createFileURI(genModelPath) : URI.createFileURI("tmp.rim");
			Resource genResource = getResourceSet().createResource(genModelURI);
			genResource.getContents().add(gmRoot);
			if (genModelPath!=null) {
				try {
					logger.logInfo("saving genmodel to "+genModelPath);
					genResource.save(Collections.EMPTY_MAP);
				}
				catch (IOException e) {
					logger.logError(e.getMessage(), null);
					logger.logError("-- terminating", null);
					return null;
				}
			}
			return gmRoot;
		}
	}

	protected void activateModelLocator() {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			modelLocator = new StandardModelLocator();
			ModelLocator.getInstance().addLocator(modelLocator);
		}
		// else: if Eclipse is running the locator is active via the extension point
	}
	
	/**
	 * validate the models
	 * 
	 */
	protected boolean validateModels() {
		logger.logInfo("-- validating models");
		
		int errors = 0;
		int warnings = 0;
		ArrayList<Resource> resources = new ArrayList<Resource>(getResourceSet().getResources());
		for (Resource resource : resources) {
			List<Issue> list = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
			if (!list.isEmpty()) {
				for (Issue issue : list) {
					if (issue.getSeverity()==Severity.ERROR) {
						++errors;
						logger.logError(issue.toString(), null);
					}
					else {
						++warnings;
						logger.logInfo(issue.toString());
					}
				}
			}
		}
		logger.logInfo("validation finished with "+errors+" errors and "+warnings+" warnings");
		if (errors>0) {
			logger.logError("-- terminating", null);
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * load all models into a {@link ResourceSet} which is created by this method and
	 * maintained in this object (cf. {@link #getResourceSet()})
	 * 
	 * @param uriList a list of {@link URI}s as Strings
	 * 
	 */
	protected boolean loadModels(List<String> uriList) {
		logger.logInfo("-- reading models");
		
		return modelLoader.loadModels(uriList, logger);
	}
	
	protected void deactivateModelLocator() {
		if (modelLocator!=null) {
			ModelLocator.getInstance().removeLocator(modelLocator);
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
	protected void translateDetailCodes(Root gmRoot) {
		boolean doTranslate = !generatorSettings.isNoTranslation();
		
		for (ExpandedActorClass xpac : gmRoot.getXpActorClasses()) {
			DetailCodeTranslator dct = new DetailCodeTranslator(xpac.getActorClass(), translationProvider, doTranslate);
			translateDetailCodesOfTree(xpac.getActorClass(), dct);
			translateDetailCodesOfTree(xpac.getStateMachine(), dct);
		}
		
		for (DataClass dc : gmRoot.getUsedDataClasses()) {
			DetailCodeTranslator dct = new DetailCodeTranslator(dc, translationProvider, doTranslate);
			translateDetailCodesOfTree(dc, dct);
		}
		
		for (ProtocolClass pc : gmRoot.getUsedProtocolClasses()) {
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
	
	/**
	 * abstract method which is finally called by {@link #createAndRunGenerator(Module, String[])}
	 * @return GENERATOR_OK or GENERATOR_ERROR
	 */
	protected abstract int runGenerator();

	/**
	 * The generator settings can also be statically accessed using {@link #getInstance()} followed
	 * by a call to this method.
	 * 
	 * @return the {@link #generatorSettings}
	 */
	public GlobalGeneratorSettings getGeneratorSettings() {
		return generatorSettings;
	}	

}
