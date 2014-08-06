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

import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.core.ui.RoomUiModule;
import org.eclipse.etrice.core.validation.ValidationUtil;

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
			Injector injector = RoomUiModule.getInjector();
	        instance = injector.getInstance(AbstractExecutionUtil.class);
	    }
		return instance;
	}
	
	@Inject
	private ValidationUtil validationUtil;
	
	@Inject
	private RoomHelpers roomHelpers;
	
	@Inject
	private RoomNameProvider roomNameProvider;

	/**
	 * @return the validationUtil
	 */
	public ValidationUtil getValidationUtil() {
		return validationUtil;
	}

	/**
	 * @return the roomHelpers
	 */
	public RoomHelpers getRoomHelpers() {
		return roomHelpers;
	}

	/**
	 * @return the roomNameProvider
	 */
	public RoomNameProvider getRoomNameProvider() {
		return roomNameProvider;
	}
}
