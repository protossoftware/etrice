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

package org.eclipse.etrice.ui.behavior.fsm.support;

import java.util.List;

import org.eclipse.etrice.ui.common.base.quickfix.IssueResolution;
import org.eclipse.xtext.validation.FeatureBasedDiagnostic;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public interface IBehaviorQuickfixProvider {

	/**
	 * @param issue to resolve
	 * @return a list of proposed resolutions
	 */
	List<IssueResolution> getResolutions(FeatureBasedDiagnostic issue);

}
