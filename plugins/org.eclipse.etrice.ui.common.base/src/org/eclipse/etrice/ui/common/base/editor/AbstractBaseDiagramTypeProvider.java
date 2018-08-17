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
 * 		juergen.haug@protos.de (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common.base.editor;

import org.eclipse.etrice.ui.common.base.support.DiagramAccessBase;
import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;

public abstract class AbstractBaseDiagramTypeProvider extends AbstractDiagramTypeProvider {

	public abstract DiagramAccessBase getDiagramAccess();
	
}
