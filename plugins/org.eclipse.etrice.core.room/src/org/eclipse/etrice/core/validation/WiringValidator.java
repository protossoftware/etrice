/*******************************************************************************
 * Copyright (c) 2020 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Jan Belle (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.validation;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.BindingEndPoint;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.ReferenceType;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.util.Multiplicities;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;

/**
 * This validator enforces the constraints that are required by the wiring
 * algorithm. All relay ports must be implemented in the sense that they are
 * connected to as many end ports as their multiplicity implies. Further the
 * multiplicity of every end point must not be exceeded. The latter restriction
 * ensures that the wiring algorithm can act greedily while the former enables
 * the validation algorithm to consider every actor class individually.
 */
public class WiringValidator extends AbstractDeclarativeValidator {

	public static final String MULTIPLICITY_ANY_REQUIRES_OPTIONAL = "multiplicity any [*] requires optional";

	public static final String ACTOR_REF_CHANGE_REF_TYPE_TO_OPTIONAL = "MultiplicityValidator.ActorRefChangeRefTypeToOptional";

	@Check
	public void checkDataDrivenPortMultiplicity(Port port) {
		if (port.getProtocol() instanceof ProtocolClass
				&& ((ProtocolClass) port.getProtocol()).getCommType() == CommunicationType.DATA_DRIVEN
				&& port.getMultiplicity() != 1)
			error("multiplicity must be 1 for data driven ports", RoomPackage.eINSTANCE.getPort_Multiplicity());
	}

	@Check
	public void checkActorRefMultiplicity(ActorRef ref) {
		if (ref.getMultiplicity() == -1 && ref.getRefType() != ReferenceType.OPTIONAL)
			error(MULTIPLICITY_ANY_REQUIRES_OPTIONAL, RoomPackage.eINSTANCE.getActorRef_RefType(),
					ACTOR_REF_CHANGE_REF_TYPE_TO_OPTIONAL);
		if (ref.getMultiplicity() != 1) {
			ActorClass ac = ref.getType();
			if (getAll(ac, ActorClass::getInterfacePorts).anyMatch(port -> port.getMultiplicity() == -1))
				error("replicated actors must not have replicated ports with multiplicity any", null);
			if (getAll(ac, ActorClass::getServiceProvisionPoints).anyMatch(spp -> true))
				error("replicated actors must not have service provision points", null);
		}
	}

	@Check
	public void checkLayerConnectionTarget(LayerConnection lc) {
		if (lc.getTo().getRef() instanceof ActorRef)
			if (((ActorRef) lc.getTo().getRef()).getMultiplicity() > 1)
				error("layer connection must not connect to replicated actor", null);
	}

	@Check
	public void checkPortMultiplicities(LogicalSystem ls) {
		checkPortMultiplicities(ls.getBindings().stream(), Stream.empty());
	}

	@Check
	public void checkPortMultiplicities(SubSystemClass ssc) {
		checkPortMultiplicities(ssc.getBindings().stream(), ssc.getRelayPorts().stream());
	}

	@Check
	public void checkPortMultiplicities(ActorClass ac) {
		checkPortMultiplicities(getAll(ac, ActorClass::getBindings),
				ac.isAbstract() ? Stream.empty() : getAll(ac, ActorClass::getRelayPorts));
	}

	/**
	 * Computes the required multiplicity for each end point using the given
	 * bindings and then compares them to the actual multiplicity of the end points.
	 * 
	 * @param bindings
	 *            all bindings to consider when computing the required
	 *            multiplicities
	 * @param relays
	 *            all relay ports to check for implementation
	 */
	private void checkPortMultiplicities(Stream<Binding> bindings, Stream<Port> relays) {
		// Compute the required multiplicity for each end point.
		Map<EndPoint, Integer> multiplicities = new HashMap<>();
		bindings.forEach(binding -> {
			EndPoint ep1 = new EndPoint(binding.getEndpoint1());
			EndPoint ep2 = new EndPoint(binding.getEndpoint2());
			int multiplicity = Multiplicities.minimum(getMultiplicity(ep1), getMultiplicity(ep2));
			multiplicities.merge(ep1, multiplicity, Multiplicities::plus);
			multiplicities.merge(ep2, multiplicity, Multiplicities::plus);
		});

		// Check whether the multiplicity of any end point is exceeded.
		multiplicities.entrySet().forEach(entry -> {
			EndPoint ep = entry.getKey();
			int multiplicity = getMultiplicity(ep);
			int calculated = entry.getValue();
			if (Multiplicities.compare(calculated, multiplicity) > 0) {
				if (multiplicity == 1)
					warning("port \"" + ep.toString() + "\" is connected to more than one peer",
							RoomPackage.eINSTANCE.getRoomClass_Name());
				else
					warning("port \"" + ep.toString() + "\" is connected to " + Multiplicities.toString(calculated)
							+ " peers but its multiplicity is only " + Multiplicities.toString(multiplicity),
							RoomPackage.eINSTANCE.getRoomClass_Name());
			}
		});

		// Check whether every relay port is implemented.
		relays.map(EndPoint::new).forEach(ep -> {
			int multiplicity = getMultiplicity(ep);
			int calculated = multiplicities.getOrDefault(ep, 0);
			if (Multiplicities.compare(calculated, multiplicity) < 0) {
				if (multiplicity == 1)
					warning("relay port \"" + ep.toString() + "\" is not connected",
							RoomPackage.eINSTANCE.getRoomClass_Name());
				else
					warning("relay port \"" + ep.toString() + "\" is only connected to "
							+ Multiplicities.toString(calculated) + " peers but its multiplicity is "
							+ Multiplicities.toString(multiplicity), RoomPackage.eINSTANCE.getRoomClass_Name());
			}
		});
	}

	/**
	 * Computes the multiplicity of an end point. If the end point is part of a
	 * replicated actor reference, the multiplicity of the end point is the product
	 * of the multiplicity of the port and the actor reference. Otherwise the
	 * multiplicity of the end point is just the multiplicity of the port.
	 * 
	 * @param ep
	 *            the end point to compute the multiplicity of
	 * @return the multiplicity of the end point
	 */
	private int getMultiplicity(EndPoint ep) {
		int multiplicator = ep.ref != null && ep.ref instanceof ActorRef ? ((ActorRef) ep.ref).getMultiplicity() : 1;
		return Multiplicities.times(multiplicator, ep.port.getMultiplicity());
	}

	/**
	 * Collects all specified items of an actor class including inherited ones. This
	 * function terminates even if the class hierarchy is circular.
	 * 
	 * @param <T>
	 *            the type of the items
	 * @param ac
	 *            the actor class to collect the items of
	 * @param getter
	 *            a method reference to the getter of the items to be collected
	 * @return the collected items
	 */
	private <T> Stream<T> getAll(ActorClass ac, Function<ActorClass, Collection<? extends T>> getter) {
		return getClassHierarchy(ac).stream().flatMap(getter.andThen(Collection::stream));
	}

	/**
	 * Compute the class hierarchy ordering the classes from super classes to sub
	 * classes. This function terminates even if the class hierarchy is circular in
	 * contrast to {@link RoomHelpers#getClassHierarchy(ActorClass)}.
	 * 
	 * @param ac
	 *            the class to compute the hierarchy of
	 * @return the class hierarchy
	 */
	private Collection<ActorClass> getClassHierarchy(ActorClass ac) {
		if (ac.getActorBase() == null)
			return Collections.singletonList(ac);

		ArrayDeque<ActorClass> result = new ArrayDeque<>();
		do {
			result.addFirst(ac);
			ac = ac.getActorBase();
		} while (ac != null && !result.contains(ac));
		return result;
	}

	/**
	 * This class allows to use end points as keys in a {@link Map}.
	 * 
	 * @see BindingEndPoint
	 */
	private static class EndPoint {
		public final ActorContainerRef ref; // nullable
		public final Port port;

		public EndPoint(Port port) {
			this.ref = null;
			this.port = port;
		}

		public EndPoint(ActorContainerRef ref, Port port) {
			this.ref = ref;
			this.port = port;
		}

		public EndPoint(BindingEndPoint ep) {
			this(ep.getActorRef(), ep.getPort());
		}

		@Override
		public String toString() {
			return ref == null ? port.getName() : ref.getName() + "." + port.getName();
		}

		@Override
		public int hashCode() {
			return Objects.hash(port, ref);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			EndPoint other = (EndPoint) obj;
			return Objects.equals(port, other.port) && Objects.equals(ref, other.ref);
		}
	}

	@Override
	public void register(EValidatorRegistrar registrar) {
		// library validator is not registered for a specific language
	}
}