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
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.util.HashMap
import java.util.LinkedList
import java.util.List
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.etrice.core.common.base.BaseFactory
import org.eclipse.etrice.core.common.base.util.ImportHelpers
import org.eclipse.etrice.core.fsm.fSM.FSMFactory
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf
import org.eclipse.etrice.core.fsm.fSM.State
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition
import org.eclipse.etrice.core.genmodel.fsm.ExtendedFsmGenBuilderFactory
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.Port
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.core.room.RoomFactory
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.core.room.util.InterfaceContractHelpers
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.etrice.core.validation.InterfaceContractValidator
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.naming.QualifiedName

import static com.google.common.base.Verify.*
import static org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions.*
import static org.eclipse.etrice.core.room.RoomPackage.Literals.ACTOR_CLASS
import static org.eclipse.xtext.util.Strings.newLine

/** See validation {@link InterfaceContractValidator} */
class MonitorActorGen {
	
	static val MONITOR_BASE_FQN = QualifiedName.create('etrice', 'api', 'contracts', 'monitors', 'AContractMonitorBase')
	
	@Inject BaseFactory baseFactory	
	@Inject RoomFactory roomFactory	
 	@Inject FSMFactory fsmFactory
 	@Inject ExtendedFsmGenBuilderFactory fsmGenBuilderFactory
	
	@Inject InterfaceContractHelpers helpers
	@Inject RoomHelpers roomHelpers
	@Inject ImportHelpers importHelpers
	
	def String serializeMonitors(RoomModel generatedMonitors, ResourceSet rs) {
		val serializedModel = serialize(generatedMonitors, rs)
		
		// fallback to set contract base class with text replacement
		// see #generateMonitor
		serializedModel.replaceAll(
			'''(ActorClass\s+[\w_]+)\s*\{''', 
			'''$1 extends «MONITOR_BASE_FQN.toString» {'''
		)
	}
	
	private def String serialize(RoomModel model, ResourceSet rs) {
		val oos = new ByteArrayOutputStream
		
		val res = rs.createResource(URI.createURI('''tmp:/«model.name».room'''));
		res.contents.add(model);
		try {		
			res.save(oos, null);
		} catch (IOException e) {
			e.printStackTrace
			throw e
		} finally {
			rs.resources.remove(res)
		}
		
		'''
			/** generated */
			
			«oos»
		'''
	}
	
	def RoomModel generateMonitors(RoomModel model) {	
		roomFactory.createRoomModel => [
			it.name = model.name + '_monitors'
			it.imports += model.imports.map[EcoreUtil.copy(it)]
			it.imports += baseFactory.createImport => [
				it.importedNamespace = model.name + '.*'
			]
			it.roomClasses += model.roomClasses.filter(ActorClass).filter[helpers.isContract(it)].map[contract |
				generateMonitor(contract, verifyNotNull(helpers.getContractProtocol(contract)))
			]
		]
	}
	
	/** Generated monitor with extra information */
	@FinalFieldsConstructor
	protected static class MonitorDesc {	
		public val ActorClass contract	
		public val ProtocolClass contractProtocol
		public val ActorClass monitor // <-- generated monitor class
		public val Port regularPort
		public val Port conjugatedPort
	}
	
	protected def ActorClass generateMonitor(ActorClass contract, ProtocolClass contractProtocol) 
	{	
		// verify statements must be validated by room.InterfaceContractValidator
		
		// create monitor class - copy contract
		val monitor = EcoreUtil.copy(contract) => [
			it.name = helpers.getGeneratedMonitorName(contract)
			
			// remove obsolete annotation
			it.annotations.removeIf[it.type.name == InterfaceContractHelpers.InterfaceContractDefinition_NAME]
			
			// set default monitor base class if no base class is present
			// this only works if the class can be found on the model path
			// see above #serializeMonitors for fallback
			if(it.base === null) {				
				it.base = importHelpers.getVisibleScope(contract.eResource, ACTOR_CLASS)
					.getSingleElement(MONITOR_BASE_FQN)?.EObjectOrProxy as ActorClass
			}
		]
		// pair of regular and conjugated ports of contract protocol	
		val ports = helpers.getContractPorts(monitor, contractProtocol)
		val regularPort = verifyNotNull(ports.key.head)
		val conjugatedPort = verifyNotNull(ports.value.head)
		
		// transform state machine to implement monitor logic	
		val monitorDesc = new MonitorDesc(contract, contractProtocol, monitor, regularPort, conjugatedPort)
		verify(!monitorDesc.regularPort.conjugated)
		verify(monitorDesc.conjugatedPort.conjugated)
		
		monitorDesc.transformStateMachine
		
		return monitor
	}
	
	protected def void transformStateMachine(extension MonitorDesc monitorDesc) 
	{
		// forward messages from existing transitions of contract
		monitorDesc.generateValidMessageForwarding
		
		// add catch transition for invalid messages
		val fsmGenBuilder = fsmGenBuilderFactory.create
		val graphContainer = fsmGenBuilder.createTransformedModel(monitor) => [ gc |
			fsmGenBuilder.withCommonData(gc)
			fsmGenBuilder.withTriggersInStates(gc)
		]
		// currently only state supported
		getAllNodes(graphContainer.graph).filter[it.stateGraphNode instanceof State].forEach[node | generateCatchAllTransitionToState(node, monitorDesc)]	
	}
	
	protected def void generateValidMessageForwarding(extension MonitorDesc monitorDesc) 
	{
		val targetPorts = #{regularPort, conjugatedPort}
		val allTransitions = roomHelpers.getAllTransitionsRecursive(roomHelpers.getActualStateMachine(monitor))
		val filteredTransition = allTransitions.filter(TriggeredTransition).filter[tr |
			tr.triggers.map[it.msgFromIfPairs.map[it.from]].flatten.forall[ifItem | targetPorts.contains(ifItem)]
		]
		
		filteredTransition.forEach[tr |
			generateMessageForwarding(tr, true, monitorDesc)
		]
	}
	
	protected def generateMessageForwarding(TriggeredTransition transition, boolean valid, extension MonitorDesc monitorDesc)
	{
		// TODO check if this is wrong - multiple forwards in single transition ???
		val forwards = transition.triggers.map[it.msgFromIfPairs].flatten.map[
			buildMessageForwardStatement(it, monitorDesc)
		].join(newLine)	
		
		if(valid) {
			addActionCodeToTriggeredTransition(transition, forwards)	
		} else {
			addActionCodeToTriggeredTransition(transition, '''
				if(forwardInvalidMessages) {
					«forwards»
				}
			''')	
		}
	}	
	
	protected def buildMessageForwardStatement(MessageFromIf msgFromInterface, extension MonitorDesc monitorDesc) 
	{
		val forwardPort = switch msgFromInterface.from {
			case regularPort: conjugatedPort
			case conjugatedPort: regularPort
			default: throw new IllegalArgumentException('')
		}
		var originalMessage = msgFromInterface.message as Message
		var messageName = originalMessage.name
		var parameterName = ""
		if (originalMessage.data !== null)
		{
			parameterName = "transitionData"
		}
		
		return forwardPort.name + "." + messageName + "(" + parameterName + ");"
	}
	
	protected def generateCatchAllTransitionToState(Node state, extension MonitorDesc monitorDesc) {
		val messageToTriggerMap = state.outgoingTriggersByMessage
		
		for (message : roomHelpers.getAllIncomingMessages(contractProtocol)) {
			message.generateCatchTransitionForMessageToState(regularPort, state, messageToTriggerMap, monitorDesc)
		}
		
		for (message : roomHelpers.getAllOutgoingMessages(contractProtocol)) {
			message.generateCatchTransitionForMessageToState(conjugatedPort, state, messageToTriggerMap, monitorDesc)
		}
	}
	
	protected def generateCatchTransitionForMessageToState(Message message, Port port, Node state, Map<Message, 
		List<CommonTrigger>> messageToTriggerMap, extension MonitorDesc monitorDesc
	)
	{
		val triggers = messageToTriggerMap.getOrDefault(message, emptyList)
		var noOfUnguardedTriggers = triggers.filter[!it.hasGuard].size
		if (noOfUnguardedTriggers == 0)
		{
			val inOutStr = "from_" + port.name
			var transitionName = state.stateGraphNode.name + "_catch_" + inOutStr + "_" + message.name
			var catchTransition = createTriggeredTransition(message, port, state, state, transitionName)
			
			addActionCodeToTriggeredTransition(catchTransition, '''onViolation("«buildProtocolErrorString(port, message, state)»");''')
			
			generateMessageForwarding(catchTransition, false, monitorDesc)
			
			state.graph.stateGraph.transitions.add(catchTransition)
		}
	}
	
	protected def buildProtocolErrorString(Port fromPort, Message message, Node fromState)
	{
		var protocolName = fromPort.protocol.name
		return "[Protocol ERROR] In protocol " + protocolName + " message " + message.name + " from port " + fromPort.name 
			+ " is not allowed in state " + fromState.stateGraphNode.name 
	}
	
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
	
	protected def Map<Message, List<CommonTrigger>> getOutgoingTriggersByMessage(Node state)
	{
		val map = new HashMap<Message, List<CommonTrigger>>
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
