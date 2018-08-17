/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.room.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.CompoundProtocolClass;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubProtocol;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class CompoundProtocolHelpers {

	public static class Match {
		private SubProtocol left;
		private SubProtocol right;
		
		public Match(SubProtocol left, SubProtocol right) {
			super();
			this.left = left;
			this.right = right;
		}

		public SubProtocol getLeft() {
			return left;
		}

		public SubProtocol getRight() {
			return right;
		}
		
		protected void swap() {
			SubProtocol tmp = left;
			left = right;
			right = tmp;
		}
	}
	
	public static List<Match> getMatches(Port left, ActorContainerRef leftRef, Port right, ActorContainerRef rightRef, StructureClass sc, Binding exclude) {
		List<Match> matches = getMatches(left.getProtocol(), right.getProtocol());
		
		boolean leftCompound = left.getProtocol() instanceof CompoundProtocolClass;
		boolean rightCompound = right.getProtocol() instanceof CompoundProtocolClass;
		
		boolean isBound = false;
		for (Binding bind : sc.getBindings()) {
			if (bind==exclude)
				continue;
			
			if (!(bind.getEndpoint1().getPort()==left && bind.getEndpoint1().getActorRef()==leftRef
					&& bind.getEndpoint2().getPort()==right && bind.getEndpoint2().getActorRef()==rightRef))
				continue;
			if (!(bind.getEndpoint2().getPort()==left && bind.getEndpoint2().getActorRef()==leftRef
					&& bind.getEndpoint1().getPort()==right && bind.getEndpoint1().getActorRef()==rightRef))
				continue;
			
			isBound = true;
			
			if (bind.getEndpoint1().getSub()==null && bind.getEndpoint2().getSub()==null) {
				// all subs bound globally, no sub match left
				matches.clear();
				return matches;
			}
			
			ArrayList<Match> copy = new ArrayList<Match>(matches);
			for (Match match : copy) {
				if ((leftCompound && match.getLeft()==bind.getEndpoint1().getSub())
						|| (rightCompound  && match.getRight()==bind.getEndpoint2().getSub())) {
					matches.remove(match);
				}
			}
		}
		
		if (isBound) {
			// remove the global match
			for (Match match : matches) {
				if (match.getLeft()==null && match.getRight()==null) {
					matches.remove(match);
					break;
				}
			}
		}
		
		return matches;
	}
	
	private static List<Match> getMatches(GeneralProtocolClass left, GeneralProtocolClass right) {
		ProtocolClass regular = null;
		CompoundProtocolClass compound = null;
		if (left instanceof ProtocolClass)
			regular = (ProtocolClass) left;
		else
			compound = (CompoundProtocolClass) left;
		if (right instanceof ProtocolClass) {
			if (regular!=null) {
				throw new IllegalArgumentException("not both arguments must be of type ProtocolClass");
			}
			regular = (ProtocolClass) right;
		}
		else {
			if (compound!=null) {
				return getCompound2CompoundMatches((CompoundProtocolClass) left, (CompoundProtocolClass) right);
			}
			compound = (CompoundProtocolClass) right;
		}
		
		List<Match> result = getCompound2RegularMatches(compound, regular);
		if (compound==right) {
			// we have to swap the result
			for (Match match : result) {
				match.swap();
			}
		}
		
		return result;
	}

	/**
	 * @param compound
	 * @param regular
	 * @return
	 */
	private static List<Match> getCompound2RegularMatches(
			CompoundProtocolClass compound, ProtocolClass regular) {
		ArrayList<Match> result = new ArrayList<Match>();
		
		for (SubProtocol sub : compound.getSubProtocols()) {
			if (sub.getProtocol()==regular)
				result.add(new Match(sub, null));
		}
		
		return result;
	}

	/**
	 * @param left
	 * @param right
	 * @return
	 */
	private static List<Match> getCompound2CompoundMatches(
			CompoundProtocolClass left, CompoundProtocolClass right) {
		ArrayList<Match> result = new ArrayList<Match>();
		
		if (left==right)
			result.add(new Match(null, null));
		
		for (SubProtocol lsub : left.getSubProtocols()) {
			for (SubProtocol rsub : right.getSubProtocols()) {
				if (lsub.getProtocol()==rsub.getProtocol())
					result.add(new Match(lsub, rsub));
			}
		}
		
		return result;
	}
}
