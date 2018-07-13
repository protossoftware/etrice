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

package org.eclipse.etrice.dctools

import java.util.Map
import org.eclipse.etrice.core.RoomStandaloneSetup
import org.eclipse.etrice.core.fsm.fSM.ModelComponent
import org.eclipse.etrice.core.genmodel.fsm.ExtendedFsmGenBuilder
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer

class GenModelAccess {
	
		Map<ModelComponent, GraphContainer> cache = newHashMap
		
		def public clearCache() {
			cache.clear
		}
		
		def public GraphContainer get(ModelComponent mc) {
			if(!cache.containsKey(mc)) {
				val injector = new RoomStandaloneSetup().createInjector
				val builder = new ExtendedFsmGenBuilder(injector);
				val gc = builder.createTransformedModel(mc)
				builder.withCommonData(gc)
				cache.put(mc, gc)
			}
			
			return cache.get(mc)
		}
}