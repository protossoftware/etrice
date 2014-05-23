/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/
package org.eclipse.etrice.core.common.validation;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

/**
 * Interface for plug-in/extensible model validators.
 */
public interface ICustomValidator {
	
	String getName();
	String getDescription();
	Set<EClass> getClassesToCheck();

	void validate(EObject object, ValidationMessageAcceptor messageAcceptor, ValidationContext context);
	
	/**
	 * Provides information for the current context or environment.
	 */
	interface ValidationContext{
		/**
		 * If current setup is standalone, then eclipse may not be running
		 * or validator should behave like in non-eclipse mode.
		 * <p> Can be ignored for now.
		 */
		boolean isStandalone();
		
		/**
		 * Whether validaton should be tailored to generation.
		 */
		boolean isGeneration();
		
		/**
		 * @see org.eclipse.xtext.validation.CheckMode
		 */
		CheckMode getCheckMode();
	}
	
	/**
	 * Global (standalone) registry for custom validators. 
	 */
	interface Registry{
		
		Registry INSTANCE = new CustomValidatorManager.RegistryImpl();
		
		void add(String language, ICustomValidator validator);
		
		List<ICustomValidator> get(String language);
	}
}
