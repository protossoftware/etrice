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
import org.eclipse.etrice.core.config.RefSegment;
import org.eclipse.etrice.core.config.SubSystemConfig;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.EnumerationType;
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

import com.google.inject.Inject;

public class ConfigUtil {

	@Inject
	private RoomHelpers roomHelpers;
	
	public LiteralType getLiteralType(Attribute attr) {
		if (attr == null)
			return null;

		if (attr.getType() != null) {
			DataType type = attr.getType().getType();
			if (type instanceof PrimitiveType)
				return ((PrimitiveType) type).getType();
		}

		return null;
	}

	public ActorClass resolve(ActorContainerClass root, RefPath path) {
		if (path.getRefs().isEmpty())
			return null;

		ActorContainerClass result = root;
		for (RefSegment ref : path.getRefs()) {
			ActorRef match = null;
			for (ActorContainerRef actor : roomHelpers.getRefs(result, true)) {
				if (actor instanceof ActorRef
						&& actor.getName().equals(ref.getRef())) {
					match = (ActorRef) actor;
					if (match.getMultiplicity() == 1) {
						if (ref.getIdx() != -1)
							return null;
					} else {
						if (ref.getIdx() < 0
								|| ref.getIdx() >= match.getMultiplicity())
							return null;
					}
					break;
				}
			}

			if (match == null)
				return null;
			result = match.getType();
		}

		return (ActorClass) result;
	}

	public ActorRef getLastActorRef(ActorContainerClass root,
			RefPath path) {
		if (path.getRefs().isEmpty())
			return null;

		ActorRef lastMatch = null;
		ActorContainerClass result = root;
		for (RefSegment ref : path.getRefs()) {
			ActorRef match = null;
			for (ActorContainerRef actor : roomHelpers.getRefs(result, true)) {
				if (actor instanceof ActorRef
						&& actor.getName().equals(ref.getRef())) {
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
	 * returns first invalid path segment else {@code null}
	 * 
	 * @param root
	 * @param path
	 * @return the first invalid path segment else {@code null}
	 */
	public String checkPath(ActorContainerClass root, RefPath path) {
		if (path == null)
			return null;

		ActorContainerClass last = root;
		Iterator<RefSegment> it = path.getRefs().iterator();
		RefSegment ref;
		while (it.hasNext()) {
			ref = it.next();
			// actor
			ActorRef match = null;
			for (ActorRef actor : last.getActorRefs()) {
				if (actor.getName().equals(ref.getRef())) {
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
				if (item.getName().equals(ref.getRef()) && !it.hasNext())
					return null;
			}
			if (match == null)
				return ref.getRef();

			if (match.getMultiplicity() == 1) {
				if (ref.getIdx() != -1)
					return ref.toString() + " (ref not indexed )";
			} else {
				if (ref.getIdx() < 0)
					return ref.toString() + " (ref needs index)";
				if (ref.getIdx() >= match.getMultiplicity())
					return ref.toString() + " (index out of bounds)";
			}

			last = match.getType();
		}

		return null;
	}

	public PortClass getPortClass(PortInstanceConfig config) {
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

	public List<InterfaceItem> getConfigurableInterfaceItems(
			ActorContainerClass acc, boolean includeInherited) {
		ArrayList<InterfaceItem> result = new ArrayList<InterfaceItem>();

		if (acc instanceof ActorClass) {
			ActorClass ac = (ActorClass) acc;
			do {
				result.addAll(ac.getInternalPorts());
				result.addAll(ac.getServiceAccessPoints());
				for (ExternalPort ext : ac.getExternalPorts())
					result.add(ext.getInterfacePort());
				ac = ac.getActorBase();
			} while (includeInherited && ac != null);
		} else if (acc instanceof SubSystemClass) {
			// nothing
		}

		return result;
	}

	public String getPath(ActorInstanceConfig config) {
		String path = "/" + config.getRoot().getName() + "/"
				+ config.getSubSystem().getName();
		for (RefSegment s : config.getPath().getRefs())
			path += "/" + s;

		return path;
	}

	public String getPath(SubSystemConfig config) {
		return "/" + config.getRoot().getName() + "/"
				+ config.getSubSystem().getName();
	}

	public List<Attribute> filterConfigurableAttributes(
			List<Attribute> attributes) {
		List<Attribute> result = new ArrayList<Attribute>();
		for (Attribute a : attributes) {
			if (a.getType().isRef())
				continue;
			DataType type = a.getType().getType();
			if (type instanceof PrimitiveType
					|| type instanceof EnumerationType
					|| (type instanceof DataClass && a.getSize() == 0))
				result.add(a);
		}

		return result;
	}
}
