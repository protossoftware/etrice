/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.ui.common.base.quickfix;

import java.util.List;

import org.eclipse.xtext.validation.FeatureBasedDiagnostic;

import com.google.common.collect.Lists;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class IssueResolutionAcceptor {

	private List<IssueResolution> issueResolutions = Lists.newArrayList();

	public void accept(FeatureBasedDiagnostic issue, String label, String description, String image, IDiagramModification modification) {
		issueResolutions.add(new IssueResolution(label, description, image, modification));
	}

	public List<IssueResolution> getIssueResolutions() {
		return issueResolutions;
	}

}
