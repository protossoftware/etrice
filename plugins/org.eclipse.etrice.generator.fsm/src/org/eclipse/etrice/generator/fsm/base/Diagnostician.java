/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.fsm.base;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.IDiagnostician;

import com.google.inject.Inject;

/**
 * This class is an implementation of the {@link IDiagnostician} interface that
 * logs errors and warnings using the configured {@link ILineOutputLogger}.
 * 
 * @author Henrik Rentz-Reichert
 */
public class Diagnostician implements IDiagnostician {

	private boolean validationFailed = false;

	@Inject
	private ILineOutputLogger logger;
	
	@Inject
	private FSMNameProvider fsmNameProvider;
	
	public void warning(String msg, EObject source, EStructuralFeature feature) {
		logger.logInfo("Validation warning: " + getMsgTxt(msg, source, feature, INSIGNIFICANT_INDEX));
	}

	public void warning(String msg, EObject source, EStructuralFeature feature, int idx) {
		logger.logInfo("Validation warning: " + getMsgTxt(msg, source, feature, idx));
	}

	public void error(String msg, EObject source, EStructuralFeature feature) {
		validationFailed = true;
		logger.logError("Validation error: "+ getMsgTxt(msg, source, feature, INSIGNIFICANT_INDEX), source);
	}

	public void error(String msg, EObject source, EStructuralFeature feature, int idx) {
		validationFailed = true;
		logger.logError("Validation error: " + getMsgTxt(msg, source, feature, idx), source);
	}

	public boolean isFailed() {
		return validationFailed;
	}

	private String getMsgTxt(String msg, EObject source, EStructuralFeature feature, int idx) {
		if (source==null || feature==null)
			return msg;

		if (idx==INSIGNIFICANT_INDEX)
			return msg + " (" + fsmNameProvider.getName(source) + ", "
							+ feature.getName()+")";
		else
			return msg + " (" + fsmNameProvider.getName(source) + ", "
							+ feature.getName() + " at index "+idx+")";
	}

}
