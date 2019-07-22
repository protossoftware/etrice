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
 * 		Juergen Haug (initial contribution)	
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.ui.contentassist;

import org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher.LastSegmentFinder;

/**
 * Finds last segment of FQN. Used for prefix matching in content proposals.
 */
public class FQNLastSegmentFinder implements LastSegmentFinder {

	@Override
	public String getLastSegment(String fqn, char delimiter) {
		if (fqn == null || fqn.length() == 0)
			return null;

		int idx = fqn.lastIndexOf(delimiter);
		if(idx > 0 && idx < fqn.length() - 2)
			return fqn.substring(idx + 1);
		return null;
	}
	
}