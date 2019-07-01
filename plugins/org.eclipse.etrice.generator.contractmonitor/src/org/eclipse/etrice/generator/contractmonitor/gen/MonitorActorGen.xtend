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

package org.eclipse.etrice.generator.contractmonitor.gen

import com.google.inject.Inject
import java.util.ArrayList
import java.util.HashMap
import java.util.LinkedList
import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.etrice.core.common.base.BaseFactory
import org.eclipse.etrice.core.fsm.fSM.FSMFactory
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf
import org.eclipse.etrice.core.fsm.fSM.State
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition
import org.eclipse.etrice.core.genmodel.fsm.ExtendedFsmGenBuilderFactory
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.Port
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.core.room.RoomFactory
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.generator.contractmonitor.setup.GeneratorSettings
import org.eclipse.etrice.generator.contractmonitor.util.ContractMonitorGeneratorHelpers
import org.eclipse.xtext.util.Strings
import org.eclipse.etrice.core.room.util.InterfaceContractHelpers

class MonitorActorGen {
	
	@Inject BaseFactory baseFactory	
	@Inject RoomFactory roomFactory	
 	@Inject FSMFactory fsmFactory
 	@Inject ExtendedFsmGenBuilderFactory fsmGenBuilderFactory
	
	@Inject InterfaceContractHelpers helpers
	@Inject ContractMonitorGeneratorHelpers genHelpers	
	@Inject GeneratorSettings generatorSettings
	
	// requires target language options
	public val detailCodeGen = new DetailCodeGen
	
	def RoomModel generateMonitors(RoomModel model) {
		val pc2Contract = model.protocolClasses.filter(ProtocolClass).toMap([it], [helpers.getInterfaceContractActorClass(it)])
		roomFactory.createRoomModel => [
			name = model.name + '_monitors'
			imports += model.imports.map[EcoreUtil.copy(it)]
			imports += baseFactory.createImport => [
				importedNamespace = model.name + '.*'
			]
			actorClasses += pc2Contract.values.filterNull.map[generateMonitor]
		]
	}
	
	protected def ActorClass generateMonitor(ActorClass contract) {	
		val monitor = EcoreUtil.copy(contract) => [
			name = name + '_GeneratedMonitor'
		]
		monitor.generateMessageForwardingCodeToMonitorActorClass
		
		val fsmGenBuilder = fsmGenBuilderFactory.create
		val graphContainer = fsmGenBuilder.createTransformedModel(monitor) => [ gc |
			fsmGenBuilder.withCommonData(gc)
			fsmGenBuilder.withTriggersInStates(gc)
		]
		generateCatchAllTranstionsToActorClass(graphContainer, monitor)
		
		return monitor
	}
	
	protected def generateMessageForwardingCodeToMonitorActorClass(ActorClass monitorActorClass)
	{
		for (transition : monitorActorClass.stateMachine.transitions.filter[it instanceof TriggeredTransition])
		{
			generateMessageForwardingCodeToTransition(transition as TriggeredTransition)
		}
	}
	
	protected def generateMessageForwardingCodeToTransition(TriggeredTransition transition)
	{
		var sendMessageDetailCodeLines = new LinkedList<String>
		for (trigger : transition.triggers)
		{
			for (msgFromInterface : trigger.msgFromIfPairs)
			{
				var sendMessageStatement = buildMessageForwardStatement(msgFromInterface)
				if (sendMessageStatement !== null)
				{
					sendMessageDetailCodeLines.add(sendMessageStatement)
				}
			}
		}
		
		if(generatorSettings.forwardInvalidMessages) {
			addActionCodeToTriggeredTransition(transition, sendMessageDetailCodeLines.join(Strings.newLine))
		}
	}
	
	
	
	protected def buildMessageForwardStatement(MessageFromIf msgFromInterface)
	{
		
		if (msgFromInterface.from instanceof Port && msgFromInterface.message instanceof Message)
		{
			var forwardPortName = generatorSettings.toConjugatedPortName
			if (msgFromInterface.from.name == generatorSettings.toConjugatedPortName)
			{
				forwardPortName = generatorSettings.toUnconjugatedPortName
			}
			var originalMessage = msgFromInterface.message as Message
			var messageName = originalMessage.name
			var parameterName = ""
			if (originalMessage.data !== null)
			{
				parameterName = "transitionData"
			}
			
			return forwardPortName + "." + messageName + "(" + parameterName + ");"
		}
		return null
	}
	
	protected def generateCatchAllTranstionsToActorClass(GraphContainer gc, ActorClass ac)
	{
		for (state : gc.graph.nodes)
		{
			state.generateCatchAllTransitionToState(gc, ac)
		}
	}
	
	protected def generateCatchAllTransitionToState(Node state, GraphContainer gc, ActorClass ac)
	{
		var messageToTriggerMap = state.outgoingTriggersByMessage
		var inPort = genHelpers.getMonitorInPort(ac)
		var outPort = genHelpers.getMonitorOutPort(ac)
				
		for (message : (inPort.protocol as ProtocolClass).incomingMessages)
		{
			message.generateCatchTransitionForMessageToState(outPort, state, messageToTriggerMap)
		}
		
		for (message : (inPort.protocol as ProtocolClass).outgoingMessages)
		{
			message.generateCatchTransitionForMessageToState(inPort, state, messageToTriggerMap)
		}
	}
	
	protected def generateCatchTransitionForMessageToState(Message message, Port port, Node state, Map<Message, List<CommonTrigger>> messageToTriggerMap)
	{
		var triggers = messageToTriggerMap.getOrDefault(message, new ArrayList(0))
		var noOfUnguardedTriggers = triggers.filter[!it.hasGuard].size
		if (noOfUnguardedTriggers == 0)
		{
			var inOutStr = "from_" + generatorSettings.toConjugatedPortName
			if (port.conjugated)
			{
				inOutStr = "from_" + generatorSettings.toUnconjugatedPortName
			}
			var transitionName = state.stateGraphNode.name + "_catch_" + inOutStr + "_" + message.name
			var catchTransition = createTriggeredTransition(message, port, state, state, transitionName)
			
			// TODO status and control protocol
//			addActionCodeToTriggeredTransition(catchTransition, "_violations++;")
			addMSCCommentToTriggeredTransition(catchTransition, buildProtocolErrorString(port, message, state), true)
			
			generateMessageForwardingCodeToTransition(catchTransition)
			
			state.graph.stateGraph.transitions.add(catchTransition)
		}
	}
	
	protected def buildProtocolErrorString(Port fromPort, Message message, Node fromState)
	{
		var protocolName = fromPort.protocol.name
		return "[Protocol ERROR] In protocol " + protocolName + " message " + message.name + " from port " + fromPort.name 
			+ " is not allowed in state " + fromState.stateGraphNode.name }
	
	protected def createTriggeredTransition(Message message, Port port, Node from, Node to, String transitionName)
	{
		var fromTerminal = fsmFactory.createStateTerminal
		fromTerminal.state = from.stateGraphNode as State
		
		var toTerminal = fsmFactory.createStateTerminal
		toTerminal.state = to.stateGraphNode as State
		
		var messageFromIf = fsmFactory.createMessageFromIf
		messageFromIf.from = port
		messageFromIf.message = message
		var trigger = fsmFactory.createTrigger
		trigger.msgFromIfPairs.add(messageFromIf)
		var triggeredTransition = fsmFactory.createTriggeredTransition
		triggeredTransition.triggers.add(trigger)
		triggeredTransition.from = fromTerminal
		triggeredTransition.to = toTerminal
		triggeredTransition.name = transitionName
		
		return triggeredTransition
	}
	
	protected def addMSCCommentToTriggeredTransition(TriggeredTransition transition, String mscComment, boolean addLocation)
	{
		var mscActionCode = detailCodeGen.mscComment(mscComment, addLocation)
		addActionCodeToTriggeredTransition(transition, mscActionCode)
	}
	
	protected def addActionCodeToTriggeredTransition(TriggeredTransition transition, String actionCode)
	{
		if (transition.action === null)
		{
			transition.action = fsmFactory.createDetailCode
		}
		if (transition.action.lines.size > 0)
		{
			transition.action.lines.set(0, '''
				«transition.action.lines.get(0)»
				«actionCode»
			''')
		} else 
		{
			transition.action.lines.add(actionCode)
		}
	}
	
	protected def getOutgoingTriggersByMessage(Node state)
	{
		var map = new HashMap<Message, List<CommonTrigger>>
		for (trigger : state.caughtTriggers)
		{
			if (!map.containsKey(trigger.msg))
			{
				map.put(trigger.msg as Message, new LinkedList)
			}
			map.get(trigger.msg as Message).add(trigger)
		}
		return map
	}
		
}
