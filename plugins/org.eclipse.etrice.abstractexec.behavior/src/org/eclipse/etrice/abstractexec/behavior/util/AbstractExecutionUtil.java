/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
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
	private FSMHelpers fsmHelpers;
	
	@Inject
	private FSMNameProvider fsmNameProvider;

	/**
	 * @return the validationUtil
	 */
	public FSMValidationUtil getValidationUtil() {
		return validationUtil;
	}

	/**
	 * @return the fsmHelpers
	 */
	public FSMHelpers getRoomHelpers() {
		return fsmHelpers;
	}

	/**
	 * @return the fsmNameProvider
	 */
	public FSMNameProvider getRoomNameProvider() {
		return fsmNameProvider;
	}
}
