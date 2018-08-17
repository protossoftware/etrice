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
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Predicate;
import com.google.inject.Inject;


public class ActorRefFilter implements Predicate<IEObjectDescription> {

	@Inject
	private RoomHelpers roomHelpers;

	private ActorClass ac;

	public ActorRefFilter(ActorClass ac) {
		this.ac = ac;
	}
	
	@Override
	public boolean apply(IEObjectDescription input) {
		if (input==null)
			return false;
		
		if (ac==null)
			return true;
		
		EObject obj = input.getEObjectOrProxy();
		if (obj instanceof ActorClass) {
			ActorClass ref = (ActorClass) obj;
			if (ref.getName()==null)
				return true;
			
			return !roomHelpers.isReferencing(ref, ac);
		}
		
		return true;
	}

}
