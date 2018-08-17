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
package org.eclipse.etrice.generator.base;

import java.util.Map;

import org.eclipse.etrice.core.common.validation.CustomValidatorManager;
import org.eclipse.xtext.validation.CancelableDiagnostician;

import com.google.inject.Inject;

/**
 * Diagnostician that adds the ValidationContext to validation calls.
 *
 */
public class GenerationEMFDiagnostician extends CancelableDiagnostician {

	@Inject
	public GenerationEMFDiagnostician(Registry registry) {
		super(registry);
	}

	@Override
	public Map<Object, Object> createDefaultContext() {
		Map<Object, Object> context = super.createDefaultContext();
		context.put(CustomValidatorManager.VAL_CONTEXT_SETUP_STANDALONE,
				CustomValidatorManager.VAL_CONTEXT_SETUP_STANDALONE);
		context.put(CustomValidatorManager.VAL_CONTEXT_TARGET_KEY,
				CustomValidatorManager.VAL_CONTEXT_TARGET_GENERATION);

		return context;
	}

}