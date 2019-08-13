/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.core.validation;

import static org.eclipse.etrice.core.room.util.InterfaceContractHelpers.ContractClass_KEY;
import static org.eclipse.etrice.core.room.util.InterfaceContractHelpers.GeneratedMonitorName_KEY;
import static org.eclipse.etrice.core.room.util.InterfaceContractHelpers.InterfaceContractDefinition_NAME;
import static org.eclipse.etrice.core.room.util.InterfaceContractHelpers.Protocol_KEY;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.eclipse.etrice.core.common.base.Annotation;
import org.eclipse.etrice.core.common.base.KeyValue;
import org.eclipse.etrice.core.common.base.Literal;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.SimpleState;
import org.eclipse.etrice.core.fsm.fSM.TransitionPoint;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.util.InterfaceContractHelpers;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.xbase.lib.Pair;

import com.google.inject.Inject;

/**
 * Validator for interface contracts. See modellib etrice.api.contracts.*
 */
public class InterfaceContractValidator extends AbstractDeclarativeValidator {

	@Inject RoomHelpers roomHelpers;
	@Inject InterfaceContractHelpers contractMonitorHelpers;
	
	@Check
	public void checkProtocolContract(ProtocolClass pc) {
		if(!contractMonitorHelpers.hasContract(pc)) return;
		
		// resolve contract class from annotation
		ActorClass contract = contractMonitorHelpers.getInterfaceContractActorClass(pc);
		Optional<KeyValue> attr = pc.getAnnotations().stream().map((anno) -> anno.getAttributes())
				.flatMap(Collection::stream).filter((anno) -> ContractClass_KEY.equals(anno.getKey())).findFirst();
		if(contract == null || contract.eIsProxy()) {
			if(attr.isPresent()) {
				error("Couldn't resolve ActorClass '" + toSafeString(attr.get().getValue()) + "' - try with fully qualified name", attr.get(), null);
			}
		}
		else if(!contractMonitorHelpers.isContract(contract) && attr.isPresent()) {		
			error("ActorClass '" + contract.getName() + "' is missing annotation '@InterfaceContractDefinition'", attr.get(), null);
		}
	}
	
	@Check
	public void checkContract(ActorClass ac) {
		if(!contractMonitorHelpers.isContract(ac)) return;
		Annotation annotation = ac.getAnnotations().stream()
				.filter((anno) -> InterfaceContractDefinition_NAME.equals(anno.getType().getName())).findFirst().get();
		
		// resolve contract class from annotation
		ProtocolClass protocol = contractMonitorHelpers.getContractProtocol(ac);
		if(protocol == null || protocol.eIsProxy()) {
			Optional<KeyValue> attr = ac.getAnnotations().stream().map((anno) -> anno.getAttributes())
					.flatMap(Collection::stream).filter((anno) -> Protocol_KEY.equals(anno.getKey())).findFirst();
			if(attr.isPresent()) {
				error("Couldn't resolve ProtocolClass '" + toSafeString(attr.get().getValue()) + "' - try with fully qualified name", attr.get(), null);
			}
		} 
		
		// validate ports
		Pair<List<Port>, List<Port>> ports = contractMonitorHelpers.getContractPorts(ac, protocol);
		boolean portsOk = false;
		if(protocol != null && !protocol.eIsProxy()) {		
			if(ports.getKey().size() != 1 && ports.getValue().size() != 1) {
				error("ActorClass '" + ac.getName() + "' must have exactly one regular and conjugated end-port for '" + protocol.getName() + "'", annotation, null);
			} else {
				portsOk = true;
			}
		}
		
		// validate generated monitor name
		Optional<KeyValue> genNameAttr = ac.getAnnotations().stream().map((anno) -> anno.getAttributes())
				.flatMap(Collection::stream).filter((anno) -> GeneratedMonitorName_KEY.equals(anno.getKey())).findFirst();
		if(genNameAttr.isPresent()) {
			String name = toSafeString(genNameAttr.get().getValue());
			if(name.contains(".")) {
				error("monitor name must be without namespace", genNameAttr.get(), null);
			} 
			else if(name.isEmpty() || !name.matches("[a-zA-Z_]([\\w_])*")) {
				error("not a valid ID", genNameAttr.get(), null);
			}
		}
		
		// validate state machine
		if(portsOk && ac.getStateMachine() != null) {
			ac.getStateMachine().eContents().stream().forEach((elem) -> {
				if(elem instanceof TriggeredTransition) {
					TriggeredTransition tr = (TriggeredTransition) elem;
					if(tr.getTriggers().size() > 1) {
						error("For contracts multiple triggers are not supported", elem, FSMPackage.Literals.TRIGGERED_TRANSITION__TRIGGERS);
					} 
					else if(tr.getTriggers().size() == 1 && tr.getTriggers().get(0).getMsgFromIfPairs().size() > 1) {
						error("For contracts trigger can have only single message", tr.getTriggers().get(0), null);
					}
				} 
				else if(elem instanceof InitialTransition) {
					// ok
				} 
				else if(elem instanceof SimpleState) {
					SimpleState state = (SimpleState) elem;
					if(state.getSubgraph() != null) {
						error("For contracts sub graphs are not supported", state.getSubgraph(), null);
					}
				}
				else if(elem instanceof TransitionPoint) {
					if(!((TransitionPoint) elem).isHandler()) {
						error("For contracts transition point must be handler", elem, null);
					}
				}
				else {
					error("For contracts not supported", elem, null);
				}
			});
		}
	}
	
	private String toSafeString(Literal literal) {
		return (literal != null) ? roomHelpers.literalToString(literal) : "null";
	}
	
	@Override
	public void register(EValidatorRegistrar registrar) {
		// library validator is not registered for a specific language
	}
	
	
}
