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
