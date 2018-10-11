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

package org.eclipse.etrice.dctools

import java.util.Map
import org.eclipse.etrice.core.fsm.fSM.ModelComponent
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import com.google.inject.Inject
import org.eclipse.etrice.core.genmodel.fsm.ExtendedFsmGenBuilderFactory
import org.eclipse.etrice.core.genmodel.fsm.NullDiagnostician

class GenModelAccess {
	
	private ExtendedFsmGenBuilderFactory fsmGenBuilderFactory
	
	Map<ModelComponent, GraphContainer> cache = newHashMap
	
	@Inject
	new(ExtendedFsmGenBuilderFactory fsmGenBuilderFactory) {
		this.fsmGenBuilderFactory = fsmGenBuilderFactory
	}
	
	def public clearCache() {
		cache.clear
	}
	
	def public GraphContainer get(ModelComponent mc) {
		if(!cache.containsKey(mc)) {
			val builder = fsmGenBuilderFactory.create(new NullDiagnostician)
			val gc = builder.createTransformedModel(mc)
			builder.withCommonData(gc)
			cache.put(mc, gc)
		}
		
		return cache.get(mc)
	}
}