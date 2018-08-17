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
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.linking;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.xtext.linking.lazy.LazyLinker;

/**
 * Linker that uses concrete ROOM sub classes instead of FSM super classes.
 */
public class RoomConvertingLazyLinker extends LazyLinker {

	protected static FSMPackage fsm = FSMPackage.eINSTANCE;
	protected static RoomPackage room = RoomPackage.eINSTANCE;
		
	@Override
	protected EClass getProxyType(EObject obj, EReference eRef) {
		EClass orig = super.getProxyType(obj, eRef);
		
		// use concrete room classes
		if(orig == fsm.getModelComponent())
			return room.getActorClass();
		if(orig == fsm.getAbstractInterfaceItem())
			return room.getInterfaceItem();
		
		
//		if(orig == room.getGeneralProtocolClass())
//			return ? => cannot decide
		
		return orig;
	}
}
