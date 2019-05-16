/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.ui.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.ui.hover.KeywordHoverProvider;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.xtext.naming.IQualifiedNameProvider;

import com.google.inject.Inject;

public class RoomHoverProvider extends KeywordHoverProvider {
	
	@Inject protected IQualifiedNameProvider fqnProvider;
	
	@Override
	protected String getLabel(EObject o) {
		if(o instanceof RoomClass) {
			return fqnProvider.getFullyQualifiedName(o).toString();
		}
		return super.getLabel(o);
	}

}
