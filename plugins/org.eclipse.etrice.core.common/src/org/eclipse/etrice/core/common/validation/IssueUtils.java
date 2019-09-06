/*******************************************************************************
 * Copyright (c) 2019 protos software gmbh (http://www.protos.de).
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
package org.eclipse.etrice.core.common.validation;

import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.Issue;

/**
 * handle special data for issues blocking opening a diagram editor
 *
 */
public class IssueUtils {

	public static final String DUMMY_CODE = "no_special_code";
	public static final String BLOCKING_MARKER = "blocking_marker";
	
	private IssueUtils() {
		// static methods only
	}
	
	public static boolean isBlocking(Issue issue) {
		if (issue.getSeverity()==Severity.ERROR) {
			if(Diagnostic.LINKING_DIAGNOSTIC.equals(issue.getCode())) {
				return true;
			}
			for (String data : issue.getData()) {
				if (BLOCKING_MARKER.equals(data)) {
					return true;
				}
			}
		}
		return false;
	}
}
