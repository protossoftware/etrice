/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/


package org.eclipse.etrice.core.etmap.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.etrice.core.etmap.eTMap.ActorInstanceMapping;
import org.eclipse.etrice.core.etmap.eTMap.RefPath;
import org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.util.RoomHelpers;

/**
 * @author Henrik Rentz-Reichert (initial contribution)
 *
 */
public class ETMapUtil {

	/**
	 * @param aim
	 * @return
	 */
	public static ActorContainerClass getParentContainer(ActorInstanceMapping aim) {
		ActorContainerClass root = null;
		if (aim.eContainer() instanceof ActorInstanceMapping) {
			ActorInstanceMapping parent = (ActorInstanceMapping) aim.eContainer();
			root = ETMapUtil.getActorContainerClass(parent);
		}
		else if (aim.eContainer() instanceof SubSystemMapping) {
			root = ((SubSystemMapping)aim.eContainer()).getLogicalSubSys().getType();
		}
		return root;
	}

	public static ActorContainerClass getActorContainerClass(ActorInstanceMapping aim) {
		// follow segments
		ActorContainerClass result = getParentContainer(aim);
		for (String ref : aim.getPath().getRefs()) {
			ActorRef match = null;
			for (ActorContainerRef actor : RoomHelpers.getRefs(result, true)) {
				if (actor instanceof ActorRef && actor.getName().equals(ref)) {
					match = (ActorRef) actor;
					break;
				}
			}

			if (match == null)
				return null;
			result = match.getType();
		}

		return result;
	}
	
	public static ActorRef getLastActorRef(ActorContainerClass root, RefPath path) {
		if (path.getRefs().isEmpty())
			return null;
		
		ActorRef lastMatch = null;
		ActorContainerClass result = root;
		for (String ref : path.getRefs()) {
			ActorRef match = null;
			for (ActorContainerRef actor : RoomHelpers.getRefs(result, true)) {
				if (actor instanceof ActorRef && actor.getName().equals(ref)) {
					match = (ActorRef) actor;
					break;
				}
			}

			if (match == null)
				return null;
			
			result = match.getType();
			lastMatch = match;
		}

		return lastMatch;
	}

	/**
	 * returns first invalid path segment else null
	 * 
	 * @param root
	 * @param path
	 * @return
	 */
	public static String checkPath(ActorContainerClass root, RefPath path) {
		if (path == null)
			return null;

		ActorContainerClass last = root;
		Iterator<String> it = path.getRefs().iterator();
		String ref;
		while (it.hasNext()) {
			ref = it.next();
			// actor
			ActorRef match = null;
			for (ActorRef actor : last.getActorRefs()) {
				if (actor.getName().equals(ref)) {
					match = actor;
					break;
				}
			}
			// port
			List<InterfaceItem> ifs = new ArrayList<InterfaceItem>();
			ifs.addAll(last.getIfSPPs());
			if (last instanceof ActorClass) {
				ActorClass actor = (ActorClass) last;
				ifs.addAll(actor.getIfPorts());
				ifs.addAll(actor.getIntPorts());
			}
			if (last instanceof SubSystemClass)
				ifs.addAll(((SubSystemClass) last).getRelayPorts());
			for (InterfaceItem item : ifs) {
				// not nested, quit if last segment
				if (item.getName().equals(ref) && !it.hasNext())
					return null;
			}
			if (match == null)
				return ref;
			last = match.getType();
		}

		return null;
	}
}
