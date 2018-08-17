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
 * 		Henrik Rentz-Reichert
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.fsm.postprocessing;

import org.eclipse.xtext.GeneratedMetamodel;

public class PostprocessorController {

	public static void process(GeneratedMetamodel metamodel){
		// first tweak the model
		new ImplPostprocessor().process(metamodel);
		
		// then add documentation (also to the new elements)
		new DocuPostprocessor().process(metamodel);
	}
}
