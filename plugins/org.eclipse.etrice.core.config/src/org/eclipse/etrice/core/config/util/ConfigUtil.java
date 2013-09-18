/*******************************************************************************
 * Copyright (c) 2012 Juergen Haug
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.config.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.etrice.core.config.ActorInstanceConfig;
import org.eclipse.etrice.core.config.PortInstanceConfig;
import org.eclipse.etrice.core.config.RefPath;
import org.eclipse.etrice.core.config.SubSystemConfig;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.common.base.LiteralType;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.util.RoomHelpers;

public class ConfigUtil {

	public static LiteralType getLiteralType(Attribute attr) {
		if (attr == null)
			return null;

		if (attr.getType() != null) {
			DataType type = attr.getType().getType();
			if (type instanceof PrimitiveType) {
				return ((PrimitiveType) type).getType();
			}
		}

		return null;
	}

	public static ActorClass resolve(ActorContainerClass root, RefPath path) {
		if (path.getRefs().isEmpty())
			return null;

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
		}

		return (ActorClass) result;
	}

	public static ActorRef getLastActorRef(ActorContainerClass root,
			RefPath path) {
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
			ifs.addAll(last.getServiceProvisionPoints());
			if (last instanceof ActorClass) {
				ActorClass actor = (ActorClass) last;
				ifs.addAll(actor.getInterfacePorts());
				ifs.addAll(actor.getInternalPorts());
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

	public static PortClass getPortClass(PortInstanceConfig config) {
		InterfaceItem item = config.getItem();
		PortClass portClass = null;
		if (item instanceof Port) {
			Port port = (Port) item;
			if (port.getProtocol() instanceof ProtocolClass) {
				ProtocolClass protocol = (ProtocolClass) port.getProtocol();
				if (port.isConjugated())
					portClass = protocol.getConjugated();
				else
					portClass = protocol.getRegular();
			}
		} else if (item instanceof SAP) {
			ProtocolClass protocol = ((SAP) item).getProtocol();
			if (protocol.getConjugated() != null)
				portClass = protocol.getConjugated();
		}

		return portClass;
	}

	public static List<InterfaceItem> getConfigurableInterfaceItems(
			ActorContainerClass acc, boolean includeInherited) {
		ArrayList<InterfaceItem> result = new ArrayList<InterfaceItem>();

		if (acc instanceof ActorClass) {
			ActorClass ac = (ActorClass) acc;
			do {
				result.addAll(ac.getInternalPorts());
				result.addAll(ac.getServiceAccessPoints());
				for (ExternalPort ext : ac.getExternalPorts())
					result.add(ext.getInterfacePort());
				ac = ac.getBase();
			} while (includeInherited && ac != null);
		} else if (acc instanceof SubSystemClass) {
			// nothing
		}

		return result;
	}

	public static String getPath(ActorInstanceConfig config) {
		String path = "/" + config.getRoot().getName() + "/"
				+ config.getSubSystem().getName();
		for (String s : config.getPath().getRefs())
			path += "/" + s;

		return path;
	}

	public static String getPath(SubSystemConfig config) {
		return "/" + config.getRoot().getName() + "/"
				+ config.getSubSystem().getName();
	}

	public static List<Attribute> filterConfigurableAttributes(
			List<Attribute> attributes) {
		List<Attribute> result = new ArrayList<Attribute>();
		for (Attribute a : attributes) {
			if (!a.getType().isRef())
				if (a.getType().getType() instanceof PrimitiveType
						|| (a.getType().getType() instanceof DataClass && a
								.getSize() == 0))
					result.add(a);
		}

		return result;
	}
}
