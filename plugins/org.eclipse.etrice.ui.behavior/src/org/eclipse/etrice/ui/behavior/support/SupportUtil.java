/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.support;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.core.ui.RoomUiModule;
import org.eclipse.etrice.ui.behavior.fsm.support.util.FSMSupportUtil;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Henrik Rentz-Reichert - Initial contribution and API
 *
 */
public class SupportUtil extends FSMSupportUtil {
	
	private static SupportUtil instance = null;

	/**
	 * @return the instance
	 */
	public static SupportUtil getInstance() {
		if (instance==null) {
			Injector injector = RoomUiModule.getInjector();
	        instance = injector.getInstance(SupportUtil.class);
		}
		return instance;
	}
	
	@Inject
	private RoomHelpers roomHelpers;
	@Inject
	private RoomNameProvider roomNameProvider;

	public RoomHelpers getRoomHelpers() {
		return roomHelpers;
	}
	
	public RoomNameProvider getRoomNameProvider() {
		return roomNameProvider;
	}
	
	public ActorClass getActorClass(Diagram diag) {
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diag);
		if (bo instanceof ActorClass)
			return (ActorClass) bo;
		return null;
	}

}
