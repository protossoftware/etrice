/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.abstractexec.behavior.util;

import org.eclipse.etrice.core.fsm.FSMStandaloneSetupGenerated;
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider;
import org.eclipse.etrice.core.fsm.util.FSMHelpers;
import org.eclipse.etrice.core.fsm.validation.FSMValidationUtil;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class AbstractExecutionUtil {

	private static AbstractExecutionUtil instance = null;

	/**
	 * @return the instance
	 */
	public static AbstractExecutionUtil getInstance() {
		if (instance==null) {
			Injector injector = new FSMStandaloneSetupGenerated().createInjector();
	        instance = injector.getInstance(AbstractExecutionUtil.class);
	    }
		return instance;
	}
	
	@Inject
	private FSMValidationUtil validationUtil;
	
	@Inject
	private FSMHelpers roomHelpers;
	
	@Inject
	private FSMNameProvider roomNameProvider;

	/**
	 * @return the validationUtil
	 */
	public FSMValidationUtil getValidationUtil() {
		return validationUtil;
	}

	/**
	 * @return the roomHelpers
	 */
	public FSMHelpers getRoomHelpers() {
		return roomHelpers;
	}

	/**
	 * @return the roomNameProvider
	 */
	public FSMNameProvider getRoomNameProvider() {
		return roomNameProvider;
	}
}
