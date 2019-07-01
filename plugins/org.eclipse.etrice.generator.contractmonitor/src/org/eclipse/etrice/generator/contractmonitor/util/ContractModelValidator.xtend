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

package org.eclipse.etrice.generator.contractmonitor.util

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.generator.base.ModelValidator
import org.eclipse.etrice.generator.base.args.Arguments
import org.eclipse.etrice.generator.base.logging.ILogger
import org.eclipse.xtext.validation.IResourceValidator
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.etrice.core.room.util.InterfaceContractHelpers

class ContractModelValidator extends ModelValidator {
	
	@Inject InterfaceContractHelpers helpers
	
	@Inject
	new(IResourceValidator validator) {
		super(validator)
	}
	
	override validate(List<Resource> resources, Arguments arguments, ILogger logger) {
		super.validate(resources.relevantResources, arguments, logger)
	}
	
	def private List<Resource> getRelevantResources(Iterable<Resource> resources) {
		val contractProtocols = resources.map[contents].flatten.filter(RoomModel).map[model |
			model.protocolClasses.filter(ProtocolClass).filter[!annotations.empty].filter[ pc |
				// validate protocols with (unresolved) contract
				helpers.hasContract(pc) || !EcoreUtil.UnresolvedProxyCrossReferencer.find(pc.annotations).empty
			]	
		].flatten.toList		
		val contractMonitors = contractProtocols.map[protocol | helpers.getInterfaceContractActorClass(protocol)].filterNull.toList
		
		return (contractProtocols + contractMonitors).map[eResource].toSet.toList
	}
}