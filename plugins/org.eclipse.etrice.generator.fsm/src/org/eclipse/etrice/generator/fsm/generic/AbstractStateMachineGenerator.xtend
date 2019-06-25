/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.generator.fsm.generic

import com.google.inject.Inject
import org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType
import org.eclipse.etrice.core.fsm.fSM.GuardedTransition
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf
import org.eclipse.etrice.core.fsm.fSM.ModelComponent
import org.eclipse.etrice.core.fsm.fSM.State
import org.eclipse.etrice.core.fsm.fSM.Transition
import org.eclipse.etrice.core.fsm.fSM.TransitionPoint
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider
import org.eclipse.etrice.core.fsm.util.FSMHelpers
import org.eclipse.etrice.core.genmodel.fsm.TriggerExtensions
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node
import org.eclipse.etrice.generator.fsm.base.CodegenHelpers
import org.eclipse.xtext.util.Pair

import static org.eclipse.xtext.util.Tuples.*

import static extension org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions.*
import java.util.ArrayList

/**
 * @author Henrik Rentz-Reichert
 *
 */
abstract class AbstractStateMachineGenerator {

	protected static val NUM_PREDEF_STATE_CONSTANTS = 2
	
	@Inject public extension FSMHelpers
	@Inject public extension CodegenHelpers
	@Inject public extension FSMExtensions
	@Inject public ILanguageExtensionBase langExt
	@Inject public IMessageIdGenerator msgIdGen
	@Inject public IIfItemIdGenerator itemIdGen
	@Inject public TransitionChainGenerator transitionChainGenerator
	@Inject public IDetailCodeTranslator translator
	@Inject public FSMNameProvider fsmNameProvider

	/**
	 * generates trigger IDs.
	 * Inheritance (if available) is used for base class IDs.
	 *
	 * @param gc the {@link GraphContainer}
	 * @return the generated code
	 */
	def String genTriggerConstants(GraphContainer gc) {
		gc.genTriggerConstants(langExt.usesInheritance)
	}

	/**
	 * generates trigger IDs.
	 * Inheritance (if available) is used for base class IDs.
	 *
	 * @param gc the {@link GraphContainer}
	 * @param omitBase use <code>true</code> if no base class trigger constants are needed
	 *
	 * @return the generated code
	 */
	def String genTriggerConstants(GraphContainer gc, boolean omitBase) {
		val triggers = if (omitBase)
					gc.component.ownMessagesFromInterfaces
					else gc.component.allMessagesFromInterfaces

		val list = <Pair<String, String>>newArrayList
		list.add(pair("POLLING", "0"));
		for (mif : triggers) {
			if (mif.from.eventDriven) {
				list.add(pair(mif.triggerCodeName, itemIdGen.getIfItemId(mif.from)+" + EVT_SHIFT*"+msgIdGen.getMessageID(mif)))
			}
		}

		return langExt.genEnumeration("triggers", list)
	}
	
	def String getTriggerCodeName(MessageFromIf mif) {
		return "TRIG_"+mif.from.name+"__"+fsmNameProvider.getMessageName(mif.message);
	}

	/**
	 * generates state ID constants.
	 * Inheritance (if available) is used for base class IDs.
	 *
	 * @param gc the {@link GraphContainer}
	 * @return the generated code
	 */
	def genStateIdConstants(GraphContainer gc) {
		gc.genStateIdConstants(langExt.usesInheritance)
	}

	/**
	 * generates state ID constants.
	 * Inheritance (if available) is used for base class IDs.
	 *
	 * @param gc the {@link GraphContainer}
	 * @param omitBase use <code>true</code> if no base class state constants are needed
	 *
	 * @return the generated code
	 */
	def genStateIdConstants(GraphContainer gc, boolean omitBase) {
		// with inheritance we exclude inherited states
		val allStateNodes = gc.graph.allStateNodes.toList // TODO: without toList this didn't work - why?
		
		// omitBase: base class constants are inherited, so we start at an offset of
		//         NUM_PREDEF_STATE_CONSTANTS + #(inherited states)
		// !omitBase: nothing is inherited, offset is just NUM_PREDEF_STATE_CONSTANTS
		var offset = NUM_PREDEF_STATE_CONSTANTS + if (omitBase)
			allStateNodes.filter[inherited].size else 0
		
		// considered are all states (case of !omitBase) or just the ones which are not inherited (case of omitBase)
		var consideredStates = (if (omitBase)
			allStateNodes.filter[!inherited] else allStateNodes).map[stateGraphNode].filter(typeof(State)).toList

		// we sort them with the non leaf states last to have the history as short as possible
		consideredStates = consideredStates.leafStatesLast.toList

		var list = <Pair<String, String>>newArrayList
		if (!omitBase) {
			list.add(pair("NO_STATE","0"))
			list.add(pair("STATE_TOP","1"))
		}
		for (state : consideredStates) {
			list.add(pair(state.getGenStateId, offset.toString))
			offset = offset+1;
		}
		list.add(pair("STATE_MAX", offset.toString))

		return langExt.genEnumeration("state_ids", list)
	}

	/**
	 * generates transition chain ID constants.
	 * Inheritance can't be used used for base class IDs because of corner cases
	 * where base class and derived class chain IDs deviate (see bug 501354).
	 *
	 * @param gc the {@link GraphContainer}
	 *
	 * @return the generated code
	 */
	def genTransitionChainConstants(GraphContainer gc) {
		gc.genTransitionChainConstants(false/*langExt.usesInheritance*/)
	}

	/**
	 * generates transition chain ID constants.<br/><br/>
	 * 
	 * <b>Note:</b> Inheritance can't be used used for base class IDs because of corner cases
	 * where base class and derived class chain IDs deviate.
	 *
	 * @param gc the {@link GraphContainer}
	 * @param omitBase use <code>true</code> if no base class transition chain constants are needed
	 *
	 * @return the generated code
	 */
	def genTransitionChainConstants(GraphContainer gc, boolean omitBase) {
		val chains = (if (omitBase)
			gc.graph.allLinks.filter[!inherited] else gc.graph.allLinks).map[transition].filter[isChainHead].filter(typeof(Transition)).toList
		var offset = if (omitBase)
			gc.graph.allLinks.filter[inherited].size else 0

		var list = <Pair<String, String>>newArrayList
		for (chain : chains) {
			offset = offset+1;
			list.add(pair(chain.genChainId, offset.toString))
		}

		return langExt.genEnumeration("ChainIDs", list)
	}

	/**
	 * generates entry and exit code for states
	 *
	 * @param gc the {@link GraphContainer}
	 * @param generateImplementation if <code>true</code> the implementation is generated, else the declaration
	 *
	 * @return the generated code
	 */
	def String genEntryAndExitCodes(GraphContainer gc, boolean generateImplementation) {
		gc.genEntryAndExitCodes(generateImplementation, langExt.usesInheritance)
	}

	/**
	 * generates entry and exit code for states
	 *
	 * @param gc the {@link GraphContainer}
	 * @param generateImplementation if <code>true</code> the implementation is generated, else the declaration
	 * @param omitBase use <code>true</code> if no base class entry and exit codes are needed
	 *
	 * @return the generated code
	 */
	def String genEntryAndExitCodes(GraphContainer gc, boolean generateImplementation, boolean omitBase) {
		val states = gc.graph.allStateNodes.filter[!omitBase || !inherited].toList
		'''
		«FOR state : states»
			«gc.genActionCodeMethods(state, generateImplementation)»
		«ENDFOR»
		'''
	}

	/**
	 * generates transition action codes
	 *
	 * @param gc the {@link GraphContainer}
	 * @param generateImplementation if <code>true</code> the implementation is generated, else the declaration
	 *
	 * @return the generated code
	 */
	def String genActionCodes(GraphContainer gc, boolean generateImplementation) {
		gc.genActionCodes(generateImplementation, langExt.usesInheritance)
	}

	/**
	 * generates transition action codes
	 *
	 * @param gc the {@link GraphContainer}
	 * @param generateImplementation if <code>true</code> the implementation is generated, else the declaration
	 * @param omitBase use <code>true</code> if no base class action codes are needed
	 *
	 * @return the generated code
	 */
	def String genActionCodes(GraphContainer gc, boolean generateImplementation, boolean omitBase) {
		val transitions = gc.graph.allLinks.filter[!omitBase || !inherited].filter[transition.action.hasDetailCode].toList
		'''
		«FOR tr : transitions»
			«gc.genActionCodeMethod(tr, generateImplementation)»
		«ENDFOR»
		'''
	}

	def String genStateSwitchMethods(GraphContainer gc, boolean generateImplementation) {
		val mc = gc.component
		val async = mc.commType==ComponentCommunicationType::ASYNCHRONOUS
		val eventDriven = mc.commType==ComponentCommunicationType::EVENT_DRIVEN
		val ifItemPtr = interfaceItemType + langExt.pointerLiteral
		val handleEvents = async || eventDriven
		val chainIDScope = if (langExt.usesInheritance) mc.className+langExt.scopeSeparator else ""
		val opScope = langExt.operationScope(mc.className, !generateImplementation)
		val opScopePriv = if (langExt.usesInheritance)
							opScope
						else
							""
		val publicIf = if (langExt.usesInheritance)
				langExt.accessLevelPublic
			else
				langExt.accessLevelPrivate
		val privAccess = langExt.accessLevelPrivate
		val selfPtr = langExt.selfPointer(mc.className, true)
		val selfOnly = langExt.selfPointer(mc.className, false)
		val getLocalId = 	if (langExt.usesInheritance) {
								if (langExt.usesPointers)
									"->getLocalId()"
								else
									".getLocalId()"
							}
							else
								"->localId"
		val constIfItemPtr = if (langExt.usesPointers)
								"const "+ifItemPtr
							else
								ifItemPtr
		val usesHdlr = usesHandlerTrPoints(gc)
		val nodes = gc.graph.allStateNodes.toList.sortBy[(stateGraphNode as State).genStateId]
		val state2node = newHashMap
		nodes.forEach[state2node.put(stateGraphNode as State, it)]
		val states = nodes.map[stateGraphNode].filter(typeof(State)).toList
		val transitionChains = gc.graph.allLinks.filter[isChainHead].toList.sortBy[transition.genChainId]
		'''
		/**
		 * calls exit codes while exiting from the current state to one of its
		 * parent states while remembering the history
		 * @param current__et - the current state
		 * @param to - the final parent state
		«IF usesHdlr»
			 * @param handler__et - entry and exit codes are called only if not handler (for handler TransitionPoints)
		«ENDIF»
		 */
		«IF generateImplementation»
			«privAccess»void «opScopePriv»exitTo(«selfPtr»«stateType» current__et, «stateType» to«IF usesHdlr», «boolType» handler__et«ENDIF») {
				while (current__et!=to) {
					switch (current__et) {
						«FOR state : states»
							case «state.getGenStateId»:
								«IF state.hasExitCode(true)»«IF usesHdlr»if (!handler__et) «ENDIF»«state.exitCodeOperationName»(«langExt.selfPointer(false)»);«ENDIF»
								«setHistory(state.parentStateId, state.genStateId)»;
								current__et = «state.parentStateId»;
								break;
						«ENDFOR»
						default:
							/* should not occur */
							break;
					}
				}
			}
		«ELSE»
			void exitTo(«selfPtr»«stateType» current__et, «stateType» to«IF usesHdlr», «boolType» handler__et«ENDIF»);
		«ENDIF»

		/**
		 * calls action, entry and exit codes along a transition chain. The generic data are cast to typed data
		 * matching the trigger of this chain. The ID of the final state is returned
		 * @param chain__et - the chain ID
		 * @param generic_data__et - the generic data pointer
		 * @return the +/- ID of the final state either with a positive sign, that indicates to execute the state's entry code, or a negative sign vice versa
		 */
		«IF generateImplementation»
			«privAccess»«stateType» «opScopePriv»executeTransitionChain(«selfPtr»int chain__et«IF handleEvents», «constIfItemPtr» ifitem, «langExt.voidPointer» generic_data__et«ENDIF») {
				switch (chain__et) {
					«FOR tc : transitionChains»
						case «chainIDScope»«tc.transition.genChainId»:
						{
							«transitionChainGenerator.generateExecuteChain(gc, tc)»
						}
					«ENDFOR»
						default:
							/* should not occur */
							break;
				}
				return NO_STATE;
			}
		«ELSE»
			«stateType» executeTransitionChain(«selfPtr»int chain__et«IF handleEvents», «constIfItemPtr» ifitem, «langExt.voidPointer» generic_data__et«ENDIF»);
		«ENDIF»

		/**
		 * calls entry codes while entering a state's history. The ID of the final leaf state is returned
		 * @param state__et - the state which is entered
		«IF usesHdlr»
			 * @param handler__et - entry code is executed if not handler
		«ENDIF»
		 * @return - the ID of the final leaf state
		 */
		«IF generateImplementation»
			«privAccess»«stateType» «opScopePriv»enterHistory(«selfPtr»«stateType» state__et«IF usesHdlr», «boolType» handler__et«ENDIF») {
				«val needsSkipVar = !states.filter(s|s.hasEntryCode(true)).empty»
				«IF needsSkipVar»
					«boolType» skip_entry__et = «langExt.booleanConstant(false)»;
				«ENDIF»
				if (state__et >= STATE_MAX) {
					state__et = «IF !langExt.usesInheritance»(«stateType»)«ENDIF» (state__et - STATE_MAX);
					«IF needsSkipVar»
						skip_entry__et = «langExt.booleanConstant(true)»;
					«ENDIF»
				}
				while («langExt.booleanConstant(true)») {
					switch (state__et) {
						«FOR state : states»
						case «state.genStateId»:
							«IF state.hasEntryCode(true)»if (!(skip_entry__et«IF usesHdlr» || handler__et«ENDIF»)) «state.entryCodeOperationName»(«langExt.selfPointer(false)»);«ENDIF»
							«IF state.isLeaf»
								/* in leaf state: return state id */
								return «state.getGenStateId»;
							«ELSE»
								/* state has a sub graph */
								«var sub_initt = state2node.get(state).subgraph.initialTransition»
								«IF sub_initt!==null»
									/* with init transition */
									if («getHistory(state.genStateId)»==NO_STATE) {
										state__et = executeTransitionChain(«langExt.selfPointer(true)»«chainIDScope»«sub_initt.genChainId»«IF handleEvents», «langExt.nullPointer», «langExt.nullPointer»«ENDIF»);
									}
									else {
										state__et = «state.genStateId.history»;
									}
								«ELSE»
									/* without init transition */
									state__et = «state.genStateId.history»;
								«ENDIF»
								break;
							«ENDIF»
						«ENDFOR»
						case STATE_TOP:
							state__et = «getHistory("STATE_TOP")»;
							break;
						default:
							/* should not occur */
							break;
					}
					«IF needsSkipVar»
						skip_entry__et = «langExt.booleanConstant(false)»;
					«ENDIF»
				}
				«unreachableReturn»
			}
		«ELSE»
			«stateType» enterHistory(«selfPtr»«stateType» state__et«IF usesHdlr», «boolType» handler__et«ENDIF»);
		«ENDIF»

		«IF generateImplementation»
			«publicIf»void «opScope»executeInitTransition(«selfOnly») {
				«var initt = gc.graph.initialTransition»
				«IF initt===null»
					/* no initial transition allowed for abstract actor class */
				«ELSE»
					int chain__et = «chainIDScope»«initt.genChainId»;
					«stateType» next__et = «opScopePriv»executeTransitionChain(«langExt.selfPointer(true)»chain__et«IF handleEvents», «langExt.nullPointer», «langExt.nullPointer»«ENDIF»);
					next__et = «opScopePriv»enterHistory(«langExt.selfPointer(true)»next__et«IF usesHdlr», «langExt.booleanConstant(false)»«ENDIF»);
					setState(«langExt.selfPointer(true)»next__et);
				«ENDIF»
			}
		«ELSE»
			void «opScope»executeInitTransition(«selfOnly»);
		«ENDIF»

		/* receiveEvent contains the main implementation of the FSM */
		«IF generateImplementation»
			«publicIf»void «opScope»receiveEventInternal(«langExt.selfPointer(mc.className, handleEvents)»«IF handleEvents»«ifItemPtr» ifitem, int localId, int evt, «langExt.voidPointer» generic_data__et«ENDIF») {
				«IF async»
					int trigger__et = (ifitem==«langExt.nullPointer»)? POLLING : localId + EVT_SHIFT*evt;
				«ELSEIF eventDriven»
					int trigger__et = localId + EVT_SHIFT*evt;
				«ENDIF»
				int chain__et = NOT_CAUGHT;
				«stateType» catching_state__et = NO_STATE;
				«IF usesHdlr»
				«boolType» is_handler__et = «langExt.booleanConstant(false)»;
				«ENDIF»
				«IF async || eventDriven»
					«markVariableUsed("trigger__et")»
				«ENDIF»

				«IF handleEvents»
					if (!handleSystemEvent(ifitem, evt, generic_data__et)) {
						«genStateSwitch(gc, usesHdlr)»
					}
				«ELSE»
					«genStateSwitch(gc, usesHdlr)»
				«ENDIF»
				if (chain__et != NOT_CAUGHT) {
					«opScopePriv»exitTo(«langExt.selfPointer(true)»getState(«langExt.selfPointer(false)»), catching_state__et«IF usesHdlr», is_handler__et«ENDIF»);
					{
						«stateType» next__et = «opScopePriv»executeTransitionChain(«langExt.selfPointer(true)»chain__et«IF handleEvents», ifitem, generic_data__et«ENDIF»);
						next__et = «opScopePriv»enterHistory(«langExt.selfPointer(true)»next__et«IF usesHdlr», is_handler__et«ENDIF»);
						setState(«langExt.selfPointer(true)»next__et);
						«finalAction»
					}
				}
			}
		«ELSE»
			void «opScope»receiveEventInternal(«langExt.selfPointer(mc.className, handleEvents)»«IF handleEvents»«ifItemPtr» ifitem, int localId, int evt, «langExt.voidPointer» generic_data__et«ENDIF»);
		«ENDIF»
		«IF handleEvents»
			«IF generateImplementation»
				«publicIf»void «opScope»receiveEvent(«langExt.selfPointer(mc.className, true)»«ifItemPtr» ifitem, int evt, «langExt.voidPointer» generic_data__et) {
					int localId = (ifitem==«langExt.nullPointer»)? 0 : ifitem«getLocalId»;
					«opScope»receiveEventInternal(«langExt.selfPointer(true)»ifitem, localId, evt, generic_data__et);
				}
			«ELSE»
				void «opScope»receiveEvent(«langExt.selfPointer(true)»«ifItemPtr» ifitem, int evt, «langExt.voidPointer» generic_data__et);
			«ENDIF»
		«ENDIF»
		'''
	}

	/**
	 * generate the do code calls for a given state
	 *
	 * @param state the {@link State}
	 * @return the generated code
	 */
	def String genDoCodes(State state) {'''
		«IF state.hasDoCode(true)»
			«state.doCodeOperationName»(«langExt.selfPointer(false)»);
		«ENDIF»
		«IF state.eContainer.eContainer instanceof State»
			«genDoCodes(state.eContainer.eContainer as State)»
		«ENDIF»
	'''}

	/**
	 * helper method which generates the state switch.
	 * Asynchronous, data driven and event driven state machines are distinguished
	 *
	 * @param gc the {@link GraphContainer}
	 * @param usesHdlr if the state machine uses no handler {@link TransitionPoint}s
	 *	  at all then unused variables can be avoided by passing <code>true</code>
	 * @return the generated code
	 */
	def genStateSwitch(GraphContainer gc, boolean usesHdlr) {
		var async = gc.component.commType==ComponentCommunicationType::ASYNCHRONOUS
		var eventDriven = gc.component.commType==ComponentCommunicationType::EVENT_DRIVEN
		var dataDriven = gc.component.commType==ComponentCommunicationType::DATA_DRIVEN
		val allLeafStateNodes = gc.graph.allStateNodes.filter[isLeaf].toList.sortBy[(stateGraphNode as State).genStateId]
		'''
			switch (getState(«langExt.selfPointer(false)»)) {
				«FOR stateNode : allLeafStateNodes»
					«val state = stateNode.stateGraphNode as State»
					case «state.genStateId»:
						«val caughtTriggers = stateNode.caughtTriggers»
						«IF async»
							«IF !caughtTriggers.isEmpty»
								switch(trigger__et) {
									case POLLING:
										«genDataDrivenTriggers(gc, stateNode, usesHdlr)»
										break;
									«genEventDrivenTriggers(gc, stateNode, usesHdlr)»
								}
							«ELSE»
								«genDataDrivenTriggers(gc, stateNode, usesHdlr)»
							«ENDIF»
						«ELSEIF dataDriven»
								«genDataDrivenTriggers(gc, stateNode, usesHdlr)»
						«ELSEIF eventDriven»
							«IF !caughtTriggers.isEmpty»
								switch(trigger__et) {
									«genEventDrivenTriggers(gc, stateNode, usesHdlr)»
								}
							«ENDIF»
						«ENDIF»
						break;
				«ENDFOR»
				default:
					/* should not occur */
					break;
			}
		'''
	}

	/**
	 * helper method which generates the data driven triggers
	 *
	 * @param gc the {@link GraphContainer}
	 * @param state the {@link State} for which the trigger if-else switch should be generated
	 * @param usesHdlr if the state machine uses no handler {@link TransitionPoints}
	 *	  at all then unused variables can be avoided by passing <code>true</code>
	 * @return the generated code
	 */
	def genDataDrivenTriggers(GraphContainer gc, Node stateNode, boolean usesHdlr) {
		val chainIDScope = if (langExt.usesInheritance) gc.className+langExt.scopeSeparator else ""
		val state = stateNode.stateGraphNode as State
		'''
			«genDoCodes(state)»
			«var links = stateNode.getOutgoingLinksHierarchically.filter[transition instanceof GuardedTransition]»
			«FOR l : links»
				if («genGuardedTransitionGuard(l, "", gc)»)
				{
					chain__et = «chainIDScope»«l.transition.genChainId»;
					catching_state__et = «l.transition.superState.genStateId»;
					«IF l.isHandler && usesHdlr»
						is_handler__et = TRUE;
					«ENDIF»
				}
				«IF l!=links.last»
					else
				«ENDIF»
			«ENDFOR»
		'''
	}

	/**
	 * helper method which generates the event driven triggers
	 *
	 * @param gc the {@link GraphContainer}
	 * @param state the {@link State} for which the trigger switch should be generated
	 * @param usesHdlr if the state machine uses no handler {@link TransitionPoints}
	 *	  at all then unused variables can be avoided by passing <code>true</code>
	 * @return the generated code
	 */
	def genEventDrivenTriggers(GraphContainer gc, Node stateNode, boolean usesHdlr) {
		val caughtTriggers = new ArrayList(stateNode.caughtTriggers).sortBy[triggerCodeName]
		val chainIDScope = if (langExt.usesInheritance) gc.className+langExt.scopeSeparator else ""
		'''
			«FOR ct : caughtTriggers»
				case «ct.triggerCodeName»:
					«var needData = ct.hasGuard»
					«IF needData»{ «langExt.getTypedDataDefinition(ct.msg)»«ENDIF»
					«FOR link : ct.links SEPARATOR " else "»
						«genTriggeredTransitionGuard(link, ct.trigger, gc)»
						{
							chain__et = «chainIDScope»«link.transition.genChainId»;
							catching_state__et = «link.transition.superState.genStateId»;
							«IF link.isHandler && usesHdlr»
								is_handler__et = «langExt.booleanConstant(true)»;
							«ENDIF»
						}
					«ENDFOR»
					«IF needData»}«ENDIF»
				break;
			«ENDFOR»
			default:
				/* should not occur */
				break;
		'''
	}

	def getClassName(GraphContainer gc) {
		gc.component.className
	}

	def getClassName(ModelComponent mc) {
		mc.componentName
	}

	def getTriggerCodeName(CommonTrigger tr) {
		val parts = tr.trigger.split(TriggerExtensions.TRIGGER_SEP)
		return "TRIG_"+parts.get(0)+"__"+parts.get(1)
	}
	
	/**
	 * getter for history array
	 *
	 * @param state the ID of the history state
	 * @return the generated code
	 */
	def getHistory(String state) {
		langExt.memberAccess+"history["+state+"]"
	}

	/**
	 * setter for history array
	 *
	 * @param state the ID of the state whose history should be set
	 * @param historyState the ID of the state that should be assigned
	 * @return the generated code
	 */
	def setHistory(String state, String historyState) {
		langExt.memberAccess+"history["+state+"] = "+historyState
	}

	/**
	 * @return the type of (temporary) state variables (defaults to "int")
	 * and has to be signed
	 */
	def stateType() {
		"int"
	}

	/**
	 * allow target language dependent generation of unreachable return in generated enterHistory method.
	 * The default is just a comment.
	 * @return the generated code
	 */
	def unreachableReturn() {
		"/* return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true) */"
	}

	/**
	 * type of (temporary) boolean variables (defaults to "boolean")
	 * @return the generated code
	 */
	def boolType() {
		return "boolean"
	}

	/**
	 * empty, but may be overridden
	 */
	def finalAction() {
		''''''
	}

	/**
	 * the type of the interface item passed into the receiveEvent() method
	 */
	def interfaceItemType() {
		"InterfaceItemBase"
	}

	/**
	 * empty, but may be overridden
	 */
	def markVariableUsed(String varname) {
		''''''
	}

	/**
	 * helper method to determine whether this state machine uses handler transitions
	 * points at all
	 *
	 * @param xpax the {@link GraphContainer}
	 * @return <code>true</code> if the state machine uses handler transition points
	 */
	def usesHandlerTrPoints(GraphContainer gc) {
		!gc.graph.allTransitionPointNodes.filter(t|((t.stateGraphNode as TransitionPoint).handler)).empty
	}

	def String genTriggeredTransitionGuard(Link link, String trigger, GraphContainer mc)
	def String genGuardedTransitionGuard(Link link, String trigger, GraphContainer mc)
	def String genActionCodeMethod(GraphContainer gc, Link link, boolean generateImplementation)
	def String genActionCodeMethods(GraphContainer gc, Node node, boolean generateImplementation)
}