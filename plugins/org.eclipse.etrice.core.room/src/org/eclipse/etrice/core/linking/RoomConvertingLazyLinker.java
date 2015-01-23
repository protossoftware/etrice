/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.linking;

import org.eclipse.xtext.linking.lazy.LazyLinker;

/**
 * Linker that converts incompatible super classes to corresponding room sub classes
 */
public class RoomConvertingLazyLinker extends LazyLinker {

//	protected static FSMPackage fsm = FSMPackage.eINSTANCE;
//	protected static RoomPackage room = RoomPackage.eINSTANCE;
//		
//	@Override
//	protected EClass getProxyType(EObject obj, EReference eRef) {
//		EClass orig = super.getProxyType(obj, eRef);
//		
//		if(orig == fsm.getModelComponent())
//			return room.getActorClass();
//		if(orig == fsm.getAbstractInterfaceItem())
//			return room.getInterfaceItem();
////		if(orig == room.getGeneralProtocolClass())
////			return ? => cannot decide, bad
//		
//		return orig;
//	}
}
