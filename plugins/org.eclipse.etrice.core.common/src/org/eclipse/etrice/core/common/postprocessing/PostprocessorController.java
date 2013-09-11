/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Eyrak Paen (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.postprocessing;

import org.eclipse.xtext.GeneratedMetamodel;

public class PostprocessorController {
	public static void process(GeneratedMetamodel metamodel){
		new DocuPostprocessor().process(metamodel);
	}
}
