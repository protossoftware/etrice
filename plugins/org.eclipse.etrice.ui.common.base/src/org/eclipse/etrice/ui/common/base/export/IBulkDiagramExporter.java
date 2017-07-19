/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		juergen.haug@protos.de (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common.base.export;

import org.eclipse.emf.ecore.EObject;

public interface IBulkDiagramExporter {

	void export(EObject mc, String folder);
	
}
