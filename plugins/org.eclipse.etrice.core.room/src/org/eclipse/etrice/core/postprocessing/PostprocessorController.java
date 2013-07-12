/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.postprocessing;

import org.eclipse.xtext.GeneratedMetamodel;

public class PostprocessorController {

	public static void process(GeneratedMetamodel metamodel){
		new DocuPostprocessor().process(metamodel);
		new ImplPostprocessor().process(metamodel);
	}
}
