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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.scoping.PlatformRelativeUriResolver;
import org.eclipse.etrice.core.genmodel.builder.GeneratorModelBuilder;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.IDiagnostician;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
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
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class AbstractGenerator {

	public static final int GENERATOR_OK = 0;
	public static final int GENERATOR_ERROR = 1;
	
	private static boolean terminateOnError = true;
	private static AbstractGenerator instance = null;

	protected static ILineOutput output = new StdLineOutput();
	private static Injector injector;
	
	private HashMap<DetailCode, String> detailcode2string = new HashMap<DetailCode, String>();
	
	public static void setTerminateOnError(boolean terminateOnError) {
		AbstractGenerator.terminateOnError = terminateOnError;
	}
	
	public static boolean isTerminateOnError() {
		return terminateOnError;
	}

	public static void setOutput(ILineOutput out) {
		if (out!=null)
			output = out;
	}
	
	public static AbstractGenerator getInstance() {
		return instance;
	}
	
	protected AbstractGenerator() {
		instance = this;
	}

	/**
	 * creates an instance of the generator and invokes the {@link #runGenerator(String[])} method
	 * @param generatorModule a Guice module from which the {@link Injector} is created
	 * @return
	 */
	protected static int createAndRunGenerator(Module generatorModule, String[] args) {
		injector = Guice.createInjector(generatorModule);
		AbstractGenerator generator = injector.getInstance(AbstractGenerator.class);
		generator.logger.setOutput(output);
		return generator.runGenerator(args);
	}

	public static Injector getInjector() {
		return injector;
	}
	
	@Inject
	protected Provider<ResourceSet> resourceSetProvider;

	@Inject
	protected ILineOutputLogger logger;
	@Inject
	protected IDiagnostician diagnostician;
	
	@Inject
	protected JavaIoFileSystemAccess fileAccess;
	
	@Inject
	protected PlatformRelativeUriResolver uriResolver;
	
	@Inject
	protected ITranslationProvider translationProvider;
	
	protected IResourceValidator validator;

	/**
	 * setup the ROOM core model plug-in and create a validator using injection
	 */
	protected void setupRoomModel() {
		Injector roomInjector = new org.eclipse.etrice.core.RoomStandaloneSetup().createInjectorAndDoEMFRegistration();
		validator = roomInjector.getInstance(IResourceValidator.class);
		org.eclipse.etrice.core.genmodel.SetupGenmodel.doSetup();
	}

	/**
	 * @param rs the {@link ResourceSet} to which the generator model should be added
	 * @param genModelPath path to store the generator model (not stored if {@code null})
	 * 
	 * @return the {@link Root} object of the generator model (is added to a new Resource also)
	 */
	protected Root createGeneratorModel(ResourceSet rs, boolean asLibrary, String genModelPath) {
		// create a list of ROOM models
		List<RoomModel> rml = new ArrayList<RoomModel>();
		for (Resource resource : rs.getResources()) {
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
				logger.logInfo("validation failed during build of generator model");
				logger.logError("-- terminating", null);
				return null;
			}
			
			translateDetailCodes(gmRoot);
			
			URI genModelURI = genModelPath!=null? URI.createFileURI(genModelPath) : URI.createFileURI("tmp.rim");
			Resource genResource = rs.createResource(genModelURI);
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

	/**
	 * validate the models
	 * 
	 * @param rs
	 */
	protected boolean validateModels(ResourceSet rs) {
		logger.logInfo("-- validating models");
		
		int errors = 0;
		int warnings = 0;
		for (Resource resource : rs.getResources()) {
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

	protected boolean loadModel(String uriString, ResourceSet rs)
			throws RuntimeException, IOException {
		String can = URI.createFileURI(uriString).toFileString();
		File f = new File(can);
		can = f.getCanonicalPath();	// e.g. remove embedded ../
		if (rs.getResource(URI.createFileURI(can), false) != null)
			// already loaded
			return false;
		
		logger.logInfo("Loading " + can);
		rs.getResource(URI.createFileURI(can), true);	// Could throw an exception...
		return true;
	}	
	
	
	/**
	 * load all models into a {@link ResourceSet}
	 * 
	 * @param uriList a list of {@link URI}s as Strings
	 * @param rs the {@link ResourceSet}
	 */
	protected boolean loadModels(List<String> uriList, ResourceSet rs) {
		logger.logInfo("-- reading models");
		boolean ok = true;
		for (String uriString : uriList) {
			//logger.logInfo("Loading " + uriString);
			try {
				loadModel(uriString,rs);
			}
			catch (Exception e) {
				ok = false;
				logger.logError("couldn't load '"+uriString+"'", null);
			}
		}
		
		EcoreUtil.resolveAll(rs);
		
		return ok;
	}

	/**
	 * create detail code translations once and for all
	 * @param gmRoot
	 */
	protected void translateDetailCodes(Root gmRoot) {
		for (ExpandedActorClass xpac : gmRoot.getXpActorClasses()) {
			DetailCodeTranslator dct = new DetailCodeTranslator(xpac.getActorClass(), translationProvider);
			translateDetailCodesOfTree(xpac.getActorClass(), dct);
			translateDetailCodesOfTree(xpac.getStateMachine(), dct);
		}
		
		for (DataClass dc : gmRoot.getUsedDataClasses()) {
			DetailCodeTranslator dct = new DetailCodeTranslator(dc, translationProvider);
			translateDetailCodesOfTree(dc, dct);
		}
		
		for (ProtocolClass pc : gmRoot.getUsedProtocolClasses()) {
			if (pc.getConjugate()!=null) {
				DetailCodeTranslator dct = new DetailCodeTranslator(pc.getConjugate(), translationProvider);
				translateDetailCodesOfTree(pc.getConjugate(), dct);
			}
			if (pc.getRegular()!=null) {
				DetailCodeTranslator dct = new DetailCodeTranslator(pc.getRegular(), translationProvider);
				translateDetailCodesOfTree(pc.getRegular(), dct);
			}
			
			DetailCodeTranslator dct = new DetailCodeTranslator(pc, translationProvider);
			translateDetailCodesOfTree(pc.getUserCode1(), dct);
			translateDetailCodesOfTree(pc.getUserCode2(), dct);
			translateDetailCodesOfTree(pc.getUserCode3(), dct);
		}
	}
	
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

	public String getTranslatedCode(DetailCode dc) {
		String code = detailcode2string.get(dc);
		if (code==null)
			return "";
		return code;
	}
	
	/**
	 * abstract method which is finally called by {@link #createAndRunGenerator(Module, String[])}
	 * @param args
	 * @return GENERATOR_OK or GENERATOR_ERROR
	 */
	protected abstract int runGenerator(String[] args);

}
