/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.etphys.postprocessing

import org.eclipse.xtext.GeneratedMetamodel
import static extension org.eclipse.etrice.core.postprocessing.PostprocessingHelpers.*

class ImplPostprocessor {
	def process(GeneratedMetamodel metamodel) {
		val pckg = metamodel.EPackage
		
		var pt = pckg.getClass("PhysicalThread")
		var tm = pt.getAttribute("time")
		tm.setUnsettable(true)
	}
}