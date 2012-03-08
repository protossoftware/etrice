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
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Transition
import org.eclipse.etrice.core.room.TriggeredTransition
import org.eclipse.etrice.core.room.NonInitialTransition
import org.eclipse.etrice.generator.etricegen.ExpandedActorClass
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
		for (mif : triggers) {
			list.add(pair(xpac.getTriggerCodeName(mif), "IFITEM_"+mif.from.name+" + EVT_SHIFT*"+pcGen.getMessageID(mif)))
		}
		
		return langExt.genEnumeration("triggers", list)
	}
	
	def genStateMachine(ExpandedActorClass xpac, ActorClass ac) {
		translator.setActorClass(ac)
		var dct = new DetailCodeTranslator(ac, translator)
		
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
			«IF xpac.isOwnObject(state)»
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
			«ENDIF»
		«ENDFOR»
		
		/* Action Codes */
		«FOR tr : xpac.stateMachine.getTransitionList()»
			«IF xpac.isOwnObject(tr) && tr.hasActionCode()»
				«langExt.accessLevelProtected»void «tr.getActionCodeOperationName()»(«langExt.selfPointer(ac.name, tr instanceof NonInitialTransition)»«IF tr instanceof NonInitialTransition»InterfaceItemBase ifitem«languageGen.getArgumentList(xpac, tr)»«ENDIF») {
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
		«langExt.accessLevelPrivate»int executeTransitionChain(«langExt.selfPointer(ac.name, true)»int chain, InterfaceItemBase ifitem, «langExt.voidPointer» generic_data) {
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
									state = executeTransitionChain(«langExt.selfPointer(true)»«xpac.getChain(sub_initt).getChainId()», «langExt.nullPointer», «langExt.nullPointer»);
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
			int next = executeTransitionChain(«langExt.selfPointer(true)»chain, «langExt.nullPointer», «langExt.nullPointer»);
			next = enterHistory(«langExt.selfPointer(true)»next, «langExt.booleanConstant(false)», «langExt.booleanConstant(false)»);
			setState(«langExt.selfPointer(true)»next);
		}
		
		/* receiveEvent contains the main implementation of the FSM */
		«IF langExt.usesInheritance»«langExt.accessLevelPublic»«ELSE»«langExt.accessLevelPrivate»«ENDIF»void receiveEvent(«langExt.selfPointer(ac.name, true)»InterfaceItemBase ifitem, int evt, «langExt.voidPointer» generic_data) {
			int trigger = «IF langExt.usesInheritance»ifitem.getLocalId()«ELSE»ifitem->localId«ENDIF» + EVT_SHIFT*evt;
			int chain = NOT_CAUGHT;
			int catching_state = NO_STATE;
			boolean is_handler = «langExt.booleanConstant(false)»;
			boolean skip_entry = «langExt.booleanConstant(false)»;
			
			if (!handleSystemEvent(ifitem, evt, generic_data)) {
				switch («langExt.memberAccess»state) {
					«FOR state : xpac.stateMachine.getLeafStateList()»
					case «state.getStateId()»:
						«var atlist =  xpac.getActiveTriggers(state)»
						«IF !atlist.isEmpty»
							switch(trigger) {
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
							}
						«ENDIF»
						break;
					«ENDFOR»
				}
			}
			if (chain != NOT_CAUGHT) {
				exitTo(«langExt.selfPointer(true)»«langExt.memberAccess»state, catching_state, is_handler);
				int next = executeTransitionChain(«langExt.selfPointer(true)»chain, ifitem, generic_data);
				next = enterHistory(«langExt.selfPointer(true)»next, is_handler, skip_entry);
				setState(«langExt.selfPointer(true)»next);
			}
		}
			 
		//******************************************
		// END of generated code for FSM
		//******************************************
	'''}
	
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
}