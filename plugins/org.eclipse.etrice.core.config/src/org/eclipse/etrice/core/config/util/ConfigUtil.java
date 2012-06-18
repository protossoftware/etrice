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

package org.eclipse.etrice.core.config.util;

import org.eclipse.etrice.core.config.IntLiteral;
import org.eclipse.etrice.core.config.NumberLiteral;
import org.eclipse.etrice.core.config.RealLiteral;
import org.eclipse.etrice.core.config.RefPath;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.LiteralType;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.util.RoomHelpers;

public class ConfigUtil {

	public static LiteralType getLiteralType(Attribute attr) {
		if (attr == null)
			return null;

		if (attr.getRefType() != null) {
			DataType type = attr.getRefType().getType();
			if (type instanceof PrimitiveType) {
				return ((PrimitiveType) type).getType();
			}
		}

		return null;
	}

	public static ActorContainerClass resolve(ActorContainerClass root,
			RefPath path) {
		if (path == null)
			return root;

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

		return result;
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
		for (String ref : path.getRefs()) {
			ActorRef match = null;
			for (ActorRef actor : last.getActorRefs()) {
				if (actor.getName().equals(ref)) {
					match = actor;
					break;
				}
			}
			if (match == null)
				return ref;
			last = match.getType();
		}

		return null;
	}

	public static double literalToDouble(NumberLiteral number) {
		double dValue = 0;
		if (number instanceof IntLiteral)
			dValue = ((IntLiteral) number).getValue();
		else if (number instanceof RealLiteral)
			dValue = ((RealLiteral) number).getValue();
		else
			assert (false) : "unexpected type";

		return dValue;
	}
}
