/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.generic

import com.google.inject.Inject
import java.util.ArrayList
import java.util.List
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.ActorCommunicationType
import org.eclipse.etrice.core.room.State
import org.eclipse.etrice.core.room.Transition
import org.eclipse.etrice.core.room.GuardedTransition
import org.eclipse.etrice.core.room.TriggeredTransition
import org.eclipse.etrice.core.room.NonInitialTransition
import org.eclipse.etrice.generator.etricegen.ExpandedActorClass
import org.eclipse.etrice.generator.etricegen.ActiveTrigger
import org.eclipse.etrice.generator.extensions.RoomExtensions
import org.eclipse.etrice.generator.base.DetailCodeTranslator
import org.eclipse.etrice.generator.base.ITranslationProvider
import static extension org.eclipse.etrice.generator.extensions.RoomNameProv.*
import org.eclipse.xtext.util.Pair
import static org.eclipse.xtext.util.Tuples.*

class GenericStateMachineGenerator {

	@Inject public extension ILanguageExtension langExt
	@Inject public extension RoomExtensions roomExt
	@Inject public extension GenericProtocolClassGenerator pcGen
	@Inject public extension org.eclipse.etrice.generator.generic.AbstractLanguageGenerator languageGen
	@Inject public ITranslationProvider translator

	def private genStateIdConstants(ExpandedActorClass xpac, ActorClass ac) {
		// with inheritance we exclude inherited base states
		var offset = 2 + if (langExt.usesInheritance)
			ac.getNumberOfInheritedBaseStates() else 0
		var baseStates = if (langExt.usesInheritance)
			ac.stateMachine.getBaseStateList else xpac.stateMachine.getBaseStateList
		
		baseStates = baseStates.leafStatesLast
		
		var list = new ArrayList<Pair<String, String>>()
		if (!langExt.usesInheritance) {
			list.add(pair("NO_STATE","0"))
			list.add(pair("STATE_TOP","1"))
		}
		for (state : baseStates) {
			list.add(pair(state.getStateId, offset.toString))
			offset = offset+1;
		}
		
		return langExt.genEnumeration("state_ids", list)
	}
	
	def private genTransitionChainConstants(ExpandedActorClass xpac, ActorClass ac) {
		var chains = if (langExt.usesInheritance)
			xpac.getOwnTransitionChains() else xpac.transitionChains
		var offset = if (langExt.usesInheritance)
			xpac.getTransitionChains().size-chains.size else 0

		var list = new ArrayList<Pair<String, String>>()
		for (chain : chains) {
			offset = offset+1;
			list.add(pair(chain.getChainId, offset.toString))
		}
		
		return langExt.genEnumeration("chain_ids", list)
	}
	
	def private genTriggerConstants(ExpandedActorClass xpac, ActorClass ac) {
		var triggers = if (langExt.usesInheritance)
			xpac.getOwnTriggers() else xpac.triggers

		var list = new ArrayList<Pair<String, String>>()
		list.add(pair("POLLING", "0"));
		for (mif : triggers) {
			list.add(pair(xpac.getTriggerCodeName(mif), "IFITEM_"+mif.from.name+" + EVT_SHIFT*"+pcGen.getMessageID(mif)))
		}
		
		return langExt.genEnumeration("triggers", list)
	}
	
	def genStateMachine(ExpandedActorClass xpac, ActorClass ac) {
		translator.setActorClass(ac)
		var dct = new DetailCodeTranslator(ac, translator)
		var async = ac.commType==ActorCommunicationType::ASYNCHRONOUS
		var eventDriven = ac.commType==ActorCommunicationType::EVENT_DRIVEN
		var dataDriven = ac.commType==ActorCommunicationType::DATA_DRIVEN
		var handleEvents = async || eventDriven
		
	'''
		
		/* state IDs */
		«genStateIdConstants(xpac, ac)»
		
		/* transition chains */
		«genTransitionChainConstants(xpac, ac)»
		
		/* triggers */
		«genTriggerConstants(xpac, ac)»

		«genExtra(xpac, ac)»
		
		/* Entry and Exit Codes */
		«FOR state : xpac.stateMachine.getStateList()»
			«IF !langExt.usesInheritance || xpac.isOwnObject(state)»
				«IF state.hasEntryCode()»
					«langExt.accessLevelProtected»void «state.getEntryCodeOperationName()»(«langExt.selfPointer(ac.name, false)») {
						«xpac.getEntryCode(state, dct)»
					}
				«ENDIF»
				«IF state.hasExitCode()»
					«langExt.accessLevelProtected»void «state.getExitCodeOperationName()»(«langExt.selfPointer(ac.name, false)») {
						«xpac.getExitCode(state, dct)»
					}
				«ENDIF»
				«IF state.hasDoCode()»
					static void «state.getDoCodeOperationName()»(«langExt.selfPointer(ac.name, false)») {
						«xpac.getDoCode(state, dct)»
					}
				«ENDIF»
			«ENDIF»
		«ENDFOR»
		
		/* Action Codes */
		«FOR tr : xpac.stateMachine.getTransitionList()»
			«IF xpac.isOwnObject(tr) && tr.hasActionCode()»
				«var hasArgs = tr instanceof NonInitialTransition && !(tr instanceof GuardedTransition)»
				«langExt.accessLevelProtected»void «tr.getActionCodeOperationName()»(«langExt.selfPointer(ac.name, hasArgs)»«IF hasArgs»InterfaceItemBase ifitem«languageGen.getArgumentList(xpac, tr)»«ENDIF») {
					«xpac.getActionCode(tr, dct)»
				}
			«ENDIF»
		«ENDFOR»
		
		/**
		 * calls exit codes while exiting from the current state to one of its
		 * parent states while remembering the history
		 * @param current - the current state
		 * @param to - the final parent state
		 * @param handler - entry and exit codes are called only if not handler (for handler TransitionPoints)
		 */
		«langExt.accessLevelPrivate»void exitTo(«langExt.selfPointer(ac.name, true)»int current, int to, boolean handler) {
			while (current!=to) {
				switch (current) {
					«FOR state : xpac.stateMachine.getBaseStateList()»
						case «state.getStateId()»:
							«IF state.hasExitCode()»if (!handler) «state.getExitCodeOperationName()»(«langExt.selfPointer(false)»);«ENDIF»
							«langExt.memberAccess»history[«state.getParentStateId()»] = «state.getStateId()»;
							current = «state.getParentStateId()»;
							break;
					«ENDFOR»
				}
			}
		}
		
		/**
		 * calls action, entry and exit codes along a transition chain. The generic data are cast to typed data
		 * matching the trigger of this chain. The ID of the final state is returned
		 * @param chain - the chain ID
		 * @param generic_data - the generic data pointer
		 * @return the ID of the final state
		 */
		«langExt.accessLevelPrivate»int executeTransitionChain(«langExt.selfPointer(ac.name, true)»int chain«IF handleEvents», InterfaceItemBase ifitem, «langExt.voidPointer» generic_data«ENDIF») {
			switch (chain) {
				«var allchains = xpac.getTransitionChains()»
				«FOR tc : allchains»
					case «tc.getChainId()»:
					{
						«xpac.getExecuteChain(tc)»
					}
				«ENDFOR»
			}
			return NO_STATE;
		}
		
		/**
		 * calls entry codes while entering a state's history. The ID of the final leaf state is returned
		 * @param state - the state which is entered
		 * @param handler - entry code is executed if not handler
		 * @return - the ID of the final leaf state
		 */
		«langExt.accessLevelPrivate»int enterHistory(«langExt.selfPointer(ac.name, true)»int state, boolean handler, boolean skip_entry) {
			while («langExt.booleanConstant(true)») {
				switch (state) {
					«FOR state : xpac.stateMachine.getBaseStateList()»
					case «state.getStateId()»:
						«IF state.hasEntryCode()»if (!(skip_entry || handler)) «state.getEntryCodeOperationName()»(«langExt.selfPointer(false)»);«ENDIF»
						«IF state.isLeaf()»
							// in leaf state: return state id
							return «state.getStateId()»;
						«ELSE»
							// state has a sub graph
							«IF state.subgraph.hasInitTransition()»
								// with init transition
								if («langExt.memberAccess»history[«state.getStateId()»]==NO_STATE) {
									«var sub_initt = state.subgraph.getInitTransition()»
									state = executeTransitionChain(«langExt.selfPointer(true)»«xpac.getChain(sub_initt).getChainId()»«IF handleEvents», «langExt.nullPointer», «langExt.nullPointer»«ENDIF»);
								}
								else {
									state = «langExt.memberAccess»history[«state.getStateId()»];
								}
							«ELSE»
								// without init transition
								state = «langExt.memberAccess»history[«state.getStateId()»];
							«ENDIF»
							break;
						«ENDIF»
					«ENDFOR»
					case STATE_TOP:
						state = «langExt.memberAccess»history[STATE_TOP];
						break;
				}
				skip_entry = «langExt.booleanConstant(false)»;
			}
			//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
		}
		
		«IF langExt.usesInheritance»«langExt.accessLevelPublic»«ELSE»«langExt.accessLevelPrivate»«ENDIF»void executeInitTransition(«langExt.selfPointer(ac.name, false)») {
			«var initt = xpac.stateMachine.getInitTransition()»
			int chain = «xpac.getChain(initt).getChainId()»;
			int next = executeTransitionChain(«langExt.selfPointer(true)»chain«IF handleEvents», «langExt.nullPointer», «langExt.nullPointer»«ENDIF»);
			next = enterHistory(«langExt.selfPointer(true)»next, «langExt.booleanConstant(false)», «langExt.booleanConstant(false)»);
			setState(«langExt.selfPointer(true)»next);
		}
		
		/* receiveEvent contains the main implementation of the FSM */
		«IF langExt.usesInheritance»«langExt.accessLevelPublic»«ELSE»«langExt.accessLevelPrivate»«ENDIF»void receiveEvent(«langExt.selfPointer(ac.name, handleEvents)»«IF handleEvents»InterfaceItemBase ifitem, int evt, «langExt.voidPointer» generic_data«ENDIF») {
			«IF async»
				int trigger = (ifitem==«langExt.nullPointer»)? POLLING : «IF langExt.usesInheritance»ifitem.getLocalId()«ELSE»ifitem->localId«ENDIF» + EVT_SHIFT*evt;
			«ELSEIF eventDriven»
				int trigger = «IF langExt.usesInheritance»ifitem.getLocalId()«ELSE»ifitem->localId«ENDIF» + EVT_SHIFT*evt;
			«ENDIF»
			int chain = NOT_CAUGHT;
			int catching_state = NO_STATE;
			boolean is_handler = «langExt.booleanConstant(false)»;
			boolean skip_entry = «langExt.booleanConstant(false)»;
			
			«IF handleEvents»
				if (!handleSystemEvent(ifitem, evt, generic_data)) {
					«genStateSwitch(xpac, dct)»
				}
			«ELSE»
				«genStateSwitch(xpac, dct)»
			«ENDIF»
			if (chain != NOT_CAUGHT) {
				exitTo(«langExt.selfPointer(true)»«langExt.memberAccess»state, catching_state, is_handler);
				int next = executeTransitionChain(«langExt.selfPointer(true)»chain«IF handleEvents», ifitem, generic_data«ENDIF»);
				next = enterHistory(«langExt.selfPointer(true)»next, is_handler, skip_entry);
				setState(«langExt.selfPointer(true)»next);
			}
		}
			 
		//******************************************
		// END of generated code for FSM
		//******************************************
	'''}
	
	def private genStateSwitch(ExpandedActorClass xpac, DetailCodeTranslator dct) {
		var async = xpac.actorClass.commType==ActorCommunicationType::ASYNCHRONOUS
		var eventDriven = xpac.actorClass.commType==ActorCommunicationType::EVENT_DRIVEN
		var dataDriven = xpac.actorClass.commType==ActorCommunicationType::DATA_DRIVEN
		var handleEvents = async || eventDriven
		'''
			switch («langExt.memberAccess»state) {
				«FOR state : xpac.stateMachine.getLeafStateList()»
				case «state.getStateId()»:
					«IF async»
						«var atlist =  xpac.getActiveTriggers(state)»
						«IF !atlist.isEmpty»
							switch(trigger) {
							case POLLING:
								«genDataDrivenTriggers(xpac, state, dct)»
								break;
								«genEventDrivenTriggers(xpac, state, atlist, dct)»
							}
						«ENDIF»
					«ELSEIF dataDriven»
						«genDataDrivenTriggers(xpac, state, dct)»
					«ELSEIF eventDriven»
						«var atlist =  xpac.getActiveTriggers(state)»
						«IF !atlist.isEmpty»
							switch(trigger) {
								«genEventDrivenTriggers(xpac, state, atlist, dct)»
							}
						«ENDIF»
					«ENDIF»
					break;
				«ENDFOR»
			}
		'''
	}
	
	def private genDataDrivenTriggers(ExpandedActorClass xpac, State state, DetailCodeTranslator dct) {
		'''
			«genDoCodes(state)»
			«var transitions = xpac.getOutgoingTransitionsHierarchical(state).filter(t|t instanceof GuardedTransition)»
			«FOR tr : transitions»
				if («dct.translateDetailCode((tr as GuardedTransition).guard)»)
				{
					«var chain = xpac.getChain(tr)»
					chain = «chain.getChainId()»;
					catching_state = «chain.getContextId()»;
					«IF chain.isHandler()»is_handler = TRUE;«ENDIF»
					«IF chain.skipEntry»skip_entry = TRUE;«ENDIF»
				}
				«IF tr!=transitions.last»
					else 
				«ENDIF»
			«ENDFOR»
		'''
	}
	
	def private genEventDrivenTriggers(ExpandedActorClass xpac, State state, List<ActiveTrigger> atlist, DetailCodeTranslator dct) {
		'''
			«FOR at : atlist»
				case «xpac.getTriggerCodeName(at.trigger)»:
					«var needData = xpac.hasGuard(at)»
					«IF needData»{ «at.msg.getTypedDataDefinition()»«ENDIF»
					«FOR tt : at.transitions SEPARATOR " else "»
						«var chain = xpac.getChain(tt)»
						«guard(chain.transition, at.trigger, xpac, dct)»
						{
							chain = «chain.getChainId()»;
							catching_state = «chain.getContextId()»;
							«IF chain.isHandler()»is_handler = «langExt.booleanConstant(true)»;«ENDIF»
							«IF chain.skipEntry»skip_entry = «langExt.booleanConstant(true)»;«ENDIF»
						}
					«ENDFOR»
					«IF needData»}«ENDIF»
				break;
			«ENDFOR»
		'''
	}
	def genExtra(ExpandedActorClass xpac, ActorClass ac) {''''''}
	
	def private dispatch guard(TriggeredTransition tt, String trigger, ExpandedActorClass ac, DetailCodeTranslator dct) {
		var tr = tt.triggers.findFirst(e|ac.isMatching(e, trigger))
	'''
		«IF tr.hasGuard()»
			if («dct.translateDetailCode(tr.guard.guard)»)
		«ENDIF»
	'''
	}

	def private dispatch guard(Transition t, String trigger, ExpandedActorClass ac, DetailCodeTranslator dct) {
	'''
		/* error */
	'''
	}
	
	def private genDoCodes(State state) {'''
		«IF state.hasDoCode()»
			«state.getDoCodeOperationName()»(self);
		«ENDIF»
		«IF state.eContainer.eContainer instanceof State»
			«genDoCodes(state.eContainer.eContainer as State)»
		«ENDIF»
	'''}
	
}