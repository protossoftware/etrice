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
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/
package org.eclipse.etrice.core.common.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

/**
 *  Abstract manager for custom validators. <br>
 *  By default to be added through xtexts ComposedCheck and executes custom validators for current language from registry.
 *
 */
public class CustomValidatorManager extends AbstractDeclarativeValidator {
	
	public static final String VAL_CONTEXT_SETUP_KEY = CustomValidatorManager.class.getName() + ".contextSetup";
	public static final String VAL_CONTEXT_SETUP_ECLIPSE = "eclipse";
	public static final String VAL_CONTEXT_SETUP_STANDALONE = "standalone";
	
	public static final String VAL_CONTEXT_TARGET_KEY = CustomValidatorManager.class.getName() + ".contextTarget";
	public static final String VAL_CONTEXT_TARGET_RESOURCE = "resource";
	public static final String VAL_CONTEXT_TARGET_GENERATION = "generation";
	
	public static class RegistryImpl implements ICustomValidator.Registry{

		private Map<String, List<ICustomValidator>> map = Maps.newHashMap();
		
		@Override
		public void add(String language, ICustomValidator validator) {
			if(!map.containsKey(language))
				map.put(language, new ArrayList<ICustomValidator>());
			
			List<ICustomValidator> registered = map.get(language);
			boolean alreadyRegistered = false;
			for(ICustomValidator v : registered)
				alreadyRegistered |= v.getClass().equals(validator.getClass());
			
			if(!alreadyRegistered)
				registered.add(validator);
		}

		@Override
		public List<ICustomValidator> get(String language) {
			if(map.containsKey(language))
				return map.get(language);
			
			return new ArrayList<ICustomValidator>();
		}
		
	}
	
	public static class ValidationContextImpl implements ICustomValidator.ValidationContext{

		private boolean isStandalone;
		private boolean isGeneration;
		private CheckMode mode;
		
		public ValidationContextImpl(boolean isStandalone, boolean isGeneration, CheckMode mode){
			this.isStandalone = isStandalone;
			this.isGeneration = isGeneration;
			this.mode = mode;
		}
		
		@Override
		public boolean isStandalone() {
			return isStandalone;
		}

		@Override
		public boolean isGeneration() {
			return isGeneration;
		}

		@Override
		public CheckMode getCheckMode() {
			return mode;
		}
		
	}
	
	@SuppressWarnings("serial")
	public static class StandaloneValidatorExtension extends ArrayList<String>{}
	
	@Inject@Named(Constants.LANGUAGE_NAME) 
	protected String languageName;
	
	@Inject
	public void registerStandaloneValidators(StandaloneValidatorExtension extension, Injector injector){
		for(String className : extension)
			instanceAndRegisterValidator(injector, className);		
	}
	
	private void instanceAndRegisterValidator(Injector injector, String className) {
		try {
			Class<?> clazz = Class.forName(className);
			ICustomValidator instance = (ICustomValidator) injector.getInstance(clazz);
			ICustomValidator.Registry.INSTANCE.add(languageName, instance);
		}
		catch (Throwable e) {
			System.out.println("Failed to load custom validator " + className);
		}
	}
	
	@Check
	public void checkObjectsStandalone(EObject object) {
		ICustomValidator.ValidationContext context = new ValidationContextImpl(isStandalone(), isGeneration(), getCheckMode());
		Set<EClass> checkTypes = new HashSet<EClass>(object.eClass().getEAllSuperTypes());
		checkTypes.add(object.eClass());
		
		for(ICustomValidator val : getCustomValidators())
			executeValidator(val, object, checkTypes, this, context);
	}
	
	protected void executeValidator(
			final ICustomValidator validator,
			final EObject object,
			final Set<EClass> checkTypes,
			final ValidationMessageAcceptor messageAcceptor,
			final ICustomValidator.ValidationContext context) {
		
		ISafeRunnable runnable = new ISafeRunnable() {
			@Override
			public void handleException(Throwable exception) {
				System.out.println("Exception in ICustomValidator " + validator.getName());
				exception.printStackTrace();
			}

			@Override
			public void run() throws Exception {
				if(checkTypes == null || !Sets.intersection(checkTypes, validator.getClassesToCheck()).isEmpty())
					validator.validate(object, messageAcceptor, context);
			}
		};
		SafeRunner.run(runnable);
	}
	
	protected boolean isStandalone(){
		String contextSetup = (String) getContext().get(VAL_CONTEXT_SETUP_KEY);

		// !EMFPlugin.IS_ECLIPSE_RUNNING
		return VAL_CONTEXT_SETUP_STANDALONE.equals(contextSetup);
	}
	
	protected boolean isGeneration(){
		String target = (String) getContext().get(VAL_CONTEXT_TARGET_KEY);
		
		return VAL_CONTEXT_TARGET_GENERATION.equals(target);
	}
	
	protected List<ICustomValidator> getCustomValidators(){
		return ICustomValidator.Registry.INSTANCE.get(languageName);
	}
	
	@Override
	public void register(EValidatorRegistrar registrar) {
		// as separate validator do register
		// super.register(registrar);
		// if added throught org.eclipse.xtext.validation.ComposedCheck, not necessary
	}
	
	@Override
	protected List<EPackage> getEPackages() {
		// as separate validator define an ePackage
		// if added through org.eclipse.xtext.validation.ComposedCheck, not necessary
		return super.getEPackages();
	}
	
	/**
	 * resource check from xtext
	 */
	protected boolean acceptResource(EObject source) {
		// from #checkIsFromCurrentlyCheckedResource(source)
		if (source != null && getCurrentObject() != null && source.eResource() != getCurrentObject().eResource())
			return false;

		return true;
	}
	
	//
	// ValidationMessageAcceptor
	//
	
	@Override
	public void acceptError(String message, EObject object, EStructuralFeature feature, int index, String code,
			String... issueData) {
		if(acceptResource(object))
			super.acceptError(message, object, feature, index, code, issueData);
	}
	@Override
	public void acceptInfo(String message, EObject object, EStructuralFeature feature, int index, String code,
			String... issueData) {
		if(acceptResource(object))
			super.acceptInfo(message, object, feature, index, code, issueData);
	}
	@Override
	public void acceptError(String message, EObject object, int offset, int length, String code, String... issueData) {
		if(acceptResource(object))
			super.acceptError(message, object, offset, length, code, issueData);
	}
	@Override
	public void acceptInfo(String message, EObject object, int offset, int length, String code, String... issueData) {
		if(acceptResource(object))
			super.acceptInfo(message, object, offset, length, code, issueData);
	}
	@Override
	public void acceptWarning(String message, EObject object, EStructuralFeature feature, int index, String code,
			String... issueData) {
		if(acceptResource(object))
			super.acceptWarning(message, object, feature, index, code, issueData);
	}
	@Override
	public void acceptWarning(String message, EObject object, int offset, int length, String code, String... issueData) {
		if(acceptResource(object))
			super.acceptWarning(message, object, offset, length, code, issueData);
	}
	
}
