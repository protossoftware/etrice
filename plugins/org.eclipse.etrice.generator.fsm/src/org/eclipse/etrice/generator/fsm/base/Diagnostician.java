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
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.fsm.base;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider;
import org.eclipse.etrice.core.genmodel.fsm.IDiagnostician;
import org.eclipse.etrice.generator.base.logging.ILogger;

import com.google.inject.Inject;

/**
 * This class is an implementation of the {@link IDiagnostician} interface that
 * logs errors and warnings using the configured {@link ILineOutputLogger}.
 * 
 * @author Henrik Rentz-Reichert
 */
public class Diagnostician implements IDiagnostician {

	private boolean validationFailed = false;

	private ILogger logger;
	
	private FSMNameProvider fsmNameProvider;
	
	@Inject
	public Diagnostician(ILogger logger, FSMNameProvider fsmNameProvider) {
		this.logger = logger;
		this.fsmNameProvider = fsmNameProvider;
	}
	
	public void warning(String msg, EObject source, EStructuralFeature feature) {
		logger.logInfo("Validation warning: " + getMsgTxt(msg, source, feature, INSIGNIFICANT_INDEX));
	}

	public void warning(String msg, EObject source, EStructuralFeature feature, int idx) {
		logger.logInfo("Validation warning: " + getMsgTxt(msg, source, feature, idx));
	}

	public void error(String msg, EObject source, EStructuralFeature feature) {
		validationFailed = true;
		logger.logError("Validation error: "+ getMsgTxt(msg, source, feature, INSIGNIFICANT_INDEX));
	}

	public void error(String msg, EObject source, EStructuralFeature feature, int idx) {
		validationFailed = true;
		logger.logError("Validation error: " + getMsgTxt(msg, source, feature, idx));
	}

	public boolean isFailed() {
		return validationFailed;
	}
	
	public void setFailed(boolean failed) {
		validationFailed = failed;
	}

	private String getMsgTxt(String msg, EObject source, EStructuralFeature feature, int idx) {
		StringBuilder result = new StringBuilder(msg);
		
		if(source != null) {
			result.append(" ");
			
			if(feature != null) {
				result.append("(" + fsmNameProvider.getName(source) + ", " + feature.getName());
				if(idx != INSIGNIFICANT_INDEX) {
					result.append(" at index " + idx);
				}
				result.append(")");
			}
			
			// prefer location to toString()
			URI uri = EcoreUtil.getURI(source);
			String objInfo = (uri != null && !source.eIsProxy()) ? uri.toString() : source.toString();
			result.append(objInfo);
		}
		
		return result.toString();
	}

}
