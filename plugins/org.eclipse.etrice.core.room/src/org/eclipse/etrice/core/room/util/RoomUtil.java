/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.room.util;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.ChoicePoint;
import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.SubSystemRef;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.Transition;

import com.google.inject.Inject;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class RoomUtil {

	@Inject
	private RoomHelpers roomHelpers;

	/**
	 * @param sg a {@link StateGraph} serving as name space
	 * @return a unique name for a new {@link Transition} (has to be unique among
	 * 		all {@link StateGraphItem}s of the state graph)
	 */
	public String getUniqueTransitionName(StateGraph sg) {
		Set<String> names = roomHelpers.getAllNames(sg);
		
		for (int i = 0; i < 1000; i++) {
			String name = "tr"+i;
			if (!names.contains(name))
				return name;
		}
		
		return "not_unique";
	}

	/**
	 * @param sg a {@link StateGraph} serving as name space
	 * @return a unique name for a new {@link InitialTransition} (has to be unique among
	 * 		all {@link StateGraphItem}s of the state graph)
	 */
	public String getUniqueInitialTransitionName(StateGraph sg) {
		Set<String> names = roomHelpers.getAllNames(sg);
		
		if (!names.contains("init"))
			return "init";
		
		for (int i = 0; i < 1000; i++) {
			String name = "init"+i;
			if (!names.contains(name))
				return name;
		}
		
		return "not_unique";
	}

	/**
	 * @param sg a {@link StateGraph} serving as name space
	 * @return a unique name for a new {@link ChoicePoint} (has to be unique among
	 * 		all {@link StateGraphItem}s of the state graph)
	 */
	public String getUniqueChoicePointName(StateGraph sg) {
		Set<String> names = roomHelpers.getAllNames(sg);
		
		for (int i = 0; i < 1000; i++) {
			String name = "cp"+i;
			if (!names.contains(name))
				return name;
		}
		
		return "not_unique";
	}

	/**
	 * @param sg a {@link StateGraph} serving as name space
	 * @return a unique name for a new {@link TrPoint} (has to be unique among
	 * 		all {@link StateGraphItem}s of the state graph)
	 */
	public String getUniqueTrPointName(StateGraph sg) {
		Set<String> names = roomHelpers.getAllNames(sg);
		
		for (int i = 0; i < 1000; i++) {
			String name = "tp"+i;
			if (!names.contains(name))
				return name;
		}
		
		return "not_unique";
	}

	/**
	 * @param sg a {@link StateGraph} serving as name space
	 * @return a unique name for a new {@link State} (has to be unique among
	 * 		all {@link StateGraphItem}s of the state graph)
	 */
	public String getUniqueStateName(StateGraph sg) {
		Set<String> names = roomHelpers.getAllNames(sg);
		
		for (int i = 0; i < 1000; i++) {
			String name = "state"+i;
			if (!names.contains(name))
				return name;
		}
		
		return "not_unique";
	}

	/**
	 * @param sc a {@link StructureClass}
	 * @return a unique name for a new {@link ActorContainerRef}
	 */
	public String getUniqueActorContainerRefName(StructureClass sc) {
		HashSet<String> names = new HashSet<String>();
		if (sc instanceof ActorContainerClass) {
			for (ActorRef ar : ((ActorContainerClass) sc).getActorRefs()) {
				names.add(ar.getName());
			}
		}
		else if (sc instanceof LogicalSystem) {
			for (SubSystemRef ar : ((LogicalSystem) sc).getSubSystems()) {
				names.add(ar.getName());
			}
		}
		
		for (int i = 0; i < 1000; i++) {
			String name = "ref"+i;
			if (!names.contains(name))
				return name;
		}
		
		return "not_unique";
	}

	/**
	 * @param prefix a prefix (e.g. to distinguish ports, SAPs, SPPs)
	 * @param acc a {@link ActorContainerClass}
	 * @return a unique name for a new {@link InterfaceItem} of the actor container class
	 */
	public String getUniqueInterfaceItemName(String prefix, ActorContainerClass acc) {
		HashSet<String> names = new HashSet<String>();
		if (acc instanceof ActorClass) {
			ActorClass ac = (ActorClass) acc;
			do {
				for (Port p : ac.getInterfacePorts()) {
					names.add(p.getName());
				}
				for (Port p : ac.getInternalPorts()) {
					names.add(p.getName());
				}
				for (SAP sap : ac.getServiceAccessPoints()) {
					names.add(sap.getName());
				}
				for (SPP spp : ac.getServiceProvisionPoints()) {
					names.add(spp.getName());
				}
				
				ac = ac.getBase();
			}
			while (ac!=null);
		}
		else if (acc instanceof SubSystemClass) {
			for (Port p : ((SubSystemClass) acc).getRelayPorts()) {
				names.add(p.getName());
			}
			for (SPP spp : ((SubSystemClass) acc).getServiceProvisionPoints()) {
				names.add(spp.getName());
			}
		}
		
		for (int i = 0; i < 1000; i++) {
			String name = prefix+i;
			if (!names.contains(name))
				return name;
		}
		
		return "not_unique";
	}

}
