/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Christian Hilden (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.contractmonitor.util

import com.google.inject.Inject
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.ActorRef
import org.eclipse.etrice.core.room.Port
import org.eclipse.etrice.generator.base.logging.ILineOutputLogger
import org.eclipse.etrice.generator.contractmonitor.setup.GeneratorSettings

class ContractMonitorGeneratorHelpers {
	
	@Inject ILineOutputLogger logger;
	@Inject GeneratorSettings generatorSettings;
	
	def Port getPortByName(ExpandedActorClass expandedActorClass, String name)
	{
		return getPortByName(expandedActorClass.actorClass, name)
	}
	
	def Port getPortByName(ActorRef actorRef, String name)
	{
		return getPortByName(actorRef.type, name)
	}
	
	def Port getPortByName(ActorClass actorClass, String name)
	{
		var matchingPorts = actorClass.interfacePorts.filter[it.name == name]
		if (matchingPorts.size > 0)
		{
			return matchingPorts.get(0)
		}
		logger.logError("No " + name + " port found for: " + actorClass.name)
		return null
	}
	
	def getMonitorInPort(ExpandedActorClass monitor)
	{
		return getMonitorInPort(monitor.actorClass)
	}
	
	def getMonitorInPort(ActorRef monitor)
	{
		return getMonitorInPort(monitor.type)
	}
	
	def getMonitorInPort(ActorClass monitor)
	{
		var inPort = monitor.getPortByName(generatorSettings.toUnconjugatedPortName)
		if (!inPort.conjugated)
		{
			logger.logError("Port" + inPort.name + " in " + monitor.name + " port must be conjugated!")
		}
		return inPort
	}
	
	def getMonitorOutPort(ActorRef monitor)
	{
		return getMonitorOutPort(monitor.type)
	}
	
	def getMonitorOutPort(ExpandedActorClass monitor)
	{
		return getMonitorOutPort(monitor.actorClass)
	}
	
	def getMonitorOutPort(ActorClass monitor)
	{
		var outPort = monitor.getPortByName(generatorSettings.toConjugatedPortName)
		if (outPort.conjugated)
		{
			logger.logError("Port" + outPort.name + " in " + monitor.name + " must be UNconjugated!")
		}
		return outPort
	}
	
}
