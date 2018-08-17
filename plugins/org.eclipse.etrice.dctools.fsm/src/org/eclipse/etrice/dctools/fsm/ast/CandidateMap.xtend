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

package org.eclipse.etrice.dctools.fsm.ast

import java.util.HashMap
import org.eclipse.emf.ecore.EObject

class CandidateMap extends HashMap<String, EObject> {
	
	def CandidateMap getMatches(String prefix) {
		val result = new CandidateMap
		
		for (entry : entrySet) {
			if (entry.key.startsWith(prefix)) {
				result.put(entry.key, entry.value)
			}
		}
		
		return result
	}
}