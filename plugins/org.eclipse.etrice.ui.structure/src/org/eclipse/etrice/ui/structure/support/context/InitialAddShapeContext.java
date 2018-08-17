/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.structure.support.context;

import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;

public class InitialAddShapeContext extends AddContext {

	public InitialAddShapeContext(Object newObject, ContainerShape targetContainer){
		setNewObject(newObject);
		setTargetContainer(targetContainer);
		
		setX(0);
		setY(0);
		setWidth(0);
		setHeight(0);
	}
}
