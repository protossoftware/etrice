/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

package org.eclipse.etrice.generator.fsm.generic

import com.google.inject.Inject
import java.util.ArrayList
import java.util.List
import org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType
import org.eclipse.etrice.core.fsm.fSM.GuardedTransition
import org.eclipse.etrice.core.fsm.fSM.ModelComponent
import org.eclipse.etrice.core.fsm.fSM.State
import org.eclipse.etrice.core.fsm.fSM.Transition
import org.eclipse.etrice.core.fsm.fSM.TransitionPoint
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition
import org.eclipse.etrice.core.fsm.util.FSMHelpers
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.util.FsmGenUtil
import org.eclipse.etrice.generator.fsm.base.CodegenHelpers
import org.eclipse.xtext.util.Pair

import static org.eclipse.xtext.util.Tuples.*

/**
 * @author Henrik Rentz-Reichert
 *
 */
abstract class AbstractStateMachineGenerator {

    @Inject public extension FSMHelpers
    @Inject public extension FsmGenUtil
    @Inject public extension CodegenHelpers
    @Inject public extension FSMExtensions
    @Inject public ILanguageExtensionBase langExt
    @Inject public IMessageIdGenerator msgIdGen
    @Inject public IIfItemIdGenerator itemIdGen
	@Inject public TransitionChainGenerator transitionChainGenerator
	@Inject public IDetailCodeTranslator translator

    /**
     * generates trigger IDs.
     * Inheritance (if available) is used for base class IDs.
     *
     * @param xpmc the {@link ExpandedModelComponent}
     * @return the generated code
     */
    def public String genTriggerConstants(ExpandedModelComponent xpmc) {
        xpmc.genTriggerConstants(langExt.usesInheritance)
    }

    /**
     * generates trigger IDs.
     * Inheritance (if available) is used for base class IDs.
     *
     * @param xpmc the {@link ExpandedModelComponent}
     * @param omitBase use <code>true</code> if no base class trigger constants are needed
     *
     * @return the generated code
     */
    def public String genTriggerConstants(ExpandedModelComponent xpmc, boolean omitBase) {
        val triggers = if (omitBase)
                    xpmc.modelComponent.ownMessagesFromInterfaces
                    else xpmc.modelComponent.allMessagesFromInterfaces

        val list = new ArrayList<Pair<String, String>>()
        list.add(pair("POLLING", "0"));
        for (mif : triggers) {
        	if (mif.from.eventDriven) {
	            list.add(pair(xpmc.getTriggerCodeName(mif), itemIdGen.getIfItemId(mif.from)+" + EVT_SHIFT*"+msgIdGen.getMessageID(mif)))
        	}
        }

        return langExt.genEnumeration("triggers", list)
    }

    /**
     * generates state ID constants.
     * Inheritance (if available) is used for base class IDs.
     *
     * @param xpmc the {@link ExpandedModelComponent}
     * @return the generated code
     */
    def public genStateIdConstants(ExpandedModelComponent xpmc) {
        xpmc.genStateIdConstants(langExt.usesInheritance)
    }

    /**
     * generates state ID constants.
     * Inheritance (if available) is used for base class IDs.
     *
     * @param xpmc the {@link ExpandedModelComponent}
     * @param omitBase use <code>true</code> if no base class state constants are needed
     *
     * @return the generated code
     */
    def public genStateIdConstants(ExpandedModelComponent xpmc, boolean omitBase) {
        val mc = xpmc.modelComponent
        // with inheritance we exclude inherited base states
        var offset = 2 + if (omitBase)
            mc.getNumberOfInheritedBaseStates() else 0
        var baseStates = if (omitBase)
            mc.stateMachine.getBaseStateList else xpmc.stateMachine.getBaseStateList

        baseStates = baseStates.leafStatesLast

        var list = new ArrayList<Pair<String, String>>()
        if (!omitBase) {
            list.add(pair("NO_STATE","0"))
            list.add(pair("STATE_TOP","1"))
        }
        for (state : baseStates) {
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
     * @param xpmc the {@link ExpandedModelComponent}
     *
     * @return the generated code
     */
    def public genTransitionChainConstants(ExpandedModelComponent xpmc) {
        xpmc.genTransitionChainConstants(false/*langExt.usesInheritance*/)
    }

    /**
     * generates transition chain ID constants.
     * Inheritance can't be used used for base class IDs because of corner cases
     * where base class and derived class chain IDs deviate.
     *
     * @param xpmc the {@link ExpandedModelComponent}
     * @param omitBase use <code>true</code> if no base class transition chain constants are needed
     *
     * @return the generated code
     */
    def public genTransitionChainConstants(ExpandedModelComponent xpmc, boolean omitBase) {
        var chains = if (omitBase)
            xpmc.getOwnTransitionChains() else xpmc.transitionChains
        var offset = if (omitBase)
            xpmc.getTransitionChains().size-chains.size else 0

        var list = new ArrayList<Pair<String, String>>()
        for (chain : chains) {
            offset = offset+1;
            list.add(pair(chain.genChainId, offset.toString))
        }

        return langExt.genEnumeration("ChainIDs", list)
    }

    /**
     * generates entry and exit code for states
     *
     * @param xpmc the {@link ExpandedModelComponent}
     * @param generateImplementation if <code>true</code> the implementation is generated, else the declaration
     *
     * @return the generated code
     */
    def public String genEntryAndExitCodes(ExpandedModelComponent xpmc, boolean generateImplementation) {
        xpmc.genEntryAndExitCodes(generateImplementation, langExt.usesInheritance)
    }

    /**
     * generates entry and exit code for states
     *
     * @param xpmc the {@link ExpandedModelComponent}
     * @param generateImplementation if <code>true</code> the implementation is generated, else the declaration
     * @param omitBase use <code>true</code> if no base class entry and exit codes are needed
     *
     * @return the generated code
     */
    def public String genEntryAndExitCodes(ExpandedModelComponent xpmc, boolean generateImplementation, boolean omitBase) {
        '''
        «FOR state : xpmc.stateMachine.getStateList()»
            «IF !omitBase || xpmc.isOwnObject(state)»
                «xpmc.genActionCodeMethods(state, generateImplementation)»
            «ENDIF»
        «ENDFOR»
        '''
    }

    /**
     * generates transition action codes
     *
     * @param xpmc the {@link ExpandedModelComponent}
     * @param generateImplementation if <code>true</code> the implementation is generated, else the declaration
     *
     * @return the generated code
     */
    def public String genActionCodes(ExpandedModelComponent xpmc, boolean generateImplementation) {
        xpmc.genActionCodes(generateImplementation, langExt.usesInheritance)
    }

    /**
     * generates transition action codes
     *
     * @param xpmc the {@link ExpandedModelComponent}
     * @param generateImplementation if <code>true</code> the implementation is generated, else the declaration
     * @param omitBase use <code>true</code> if no base class action codes are needed
     *
     * @return the generated code
     */
    def public String genActionCodes(ExpandedModelComponent xpmc, boolean generateImplementation, boolean omitBase) {
        '''
        «FOR tr : xpmc.stateMachine.allTransitionsRecursive»
            «IF (!omitBase || xpmc.isOwnObject(tr)) && tr.action.hasDetailCode»
                «xpmc.genActionCodeMethod(tr, generateImplementation)»
            «ENDIF»
        «ENDFOR»
        '''
    }

    def public String genStateSwitchMethods(ExpandedModelComponent xpmc, boolean generateImplementation) {
		val mc = xpmc.modelComponent
		val async = mc.commType==ComponentCommunicationType::ASYNCHRONOUS
		val eventDriven = mc.commType==ComponentCommunicationType::EVENT_DRIVEN
		val ifItemPtr = interfaceItemType()+langExt.pointerLiteral()
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
		val usesHdlr = usesHandlerTrPoints(xpmc)
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
						«FOR state : xpmc.stateMachine.getBaseStateList()»
							case «state.getGenStateId()»:
								«IF state.hasExitCode(true)»«IF usesHdlr»if (!handler__et) «ENDIF»«state.getExitCodeOperationName()»(«langExt.selfPointer(false)»);«ENDIF»
								«setHistory(state.getParentStateId(), state.getGenStateId())»;
								current__et = «state.getParentStateId()»;
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
					«var allchains = xpmc.getTransitionChains()»
					«FOR tc : allchains»
						case «chainIDScope»«tc.genChainId»:
						{
							«transitionChainGenerator.generateExecuteChain(xpmc, tc)»
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
				«val baseStateList = xpmc.stateMachine.baseStateList»
				«val needsSkipVar = !baseStateList.filter(s|s.hasEntryCode(true)).empty»
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
						«FOR state : baseStateList»
						case «state.getGenStateId()»:
							«IF state.hasEntryCode(true)»if (!(skip_entry__et«IF usesHdlr» || handler__et«ENDIF»)) «state.getEntryCodeOperationName()»(«langExt.selfPointer(false)»);«ENDIF»
							«IF state.isLeaf()»
								/* in leaf state: return state id */
								return «state.getGenStateId()»;
							«ELSE»
								/* state has a sub graph */
								«IF state.subgraph.hasInitTransition()»
									/* with init transition */
									if («getHistory(state.getGenStateId())»==NO_STATE) {
										«var sub_initt = state.subgraph.getInitTransition()»
										state__et = executeTransitionChain(«langExt.selfPointer(true)»«chainIDScope»«xpmc.getChain(sub_initt).genChainId»«IF handleEvents», «langExt.nullPointer», «langExt.nullPointer»«ENDIF»);
									}
									else {
										state__et = «getHistory(state.getGenStateId())»;
									}
								«ELSE»
									/* without init transition */
									state__et = «getHistory(state.getGenStateId())»;
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
				«var initt = xpmc.stateMachine.getInitTransition()»
				int chain__et = «chainIDScope»«xpmc.getChain(initt).genChainId»;
				«stateType» next__et = «opScopePriv»executeTransitionChain(«langExt.selfPointer(true)»chain__et«IF handleEvents», «langExt.nullPointer», «langExt.nullPointer»«ENDIF»);
				next__et = «opScopePriv»enterHistory(«langExt.selfPointer(true)»next__et«IF usesHdlr», «langExt.booleanConstant(false)»«ENDIF»);
				setState(«langExt.selfPointer(true)»next__et);
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
						«genStateSwitch(xpmc, usesHdlr)»
					}
				«ELSE»
					«genStateSwitch(xpmc, usesHdlr)»
				«ENDIF»
				if (chain__et != NOT_CAUGHT) {
					«opScopePriv»exitTo(«langExt.selfPointer(true)»getState(«langExt.selfPointer(false)»), catching_state__et«IF usesHdlr», is_handler__et«ENDIF»);
					{
						«stateType» next__et = «opScopePriv»executeTransitionChain(«langExt.selfPointer(true)»chain__et«IF handleEvents», ifitem, generic_data__et«ENDIF»);
						next__et = «opScopePriv»enterHistory(«langExt.selfPointer(true)»next__et«IF usesHdlr», is_handler__et«ENDIF»);
						setState(«langExt.selfPointer(true)»next__et);
						«finalAction()»
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
    def public String genDoCodes(State state) {'''
        «IF state.hasDoCode(true)»
            «state.getDoCodeOperationName()»(«langExt.selfPointer(false)»);
        «ENDIF»
        «IF state.eContainer.eContainer instanceof State»
            «genDoCodes(state.eContainer.eContainer as State)»
        «ENDIF»
    '''}

    /**
     * helper method which generates the state switch.
     * Asynchronous, data driven and event driven state machines are distinguished
     *
     * @param xpmc the {@link ExpandedModelComponent}
     * @param usesHdlr if the state machine uses no handler {@link TransitionPoint}s
     *      at all then unused variables can be avoided by passing <code>true</code>
     * @return the generated code
     */
    def public genStateSwitch(ExpandedModelComponent xpmc, boolean usesHdlr) {
        var async = xpmc.modelComponent.commType==ComponentCommunicationType::ASYNCHRONOUS
        var eventDriven = xpmc.modelComponent.commType==ComponentCommunicationType::EVENT_DRIVEN
        var dataDriven = xpmc.modelComponent.commType==ComponentCommunicationType::DATA_DRIVEN
        '''
            switch (getState(«langExt.selfPointer(false)»)) {
                «FOR state : xpmc.stateMachine.getLeafStateList()»
                case «state.getGenStateId()»:
                    «IF async»
                        «var atlist =  xpmc.getActiveTriggers(state)»
                        «IF !atlist.isEmpty»
                            switch(trigger__et) {
                                case POLLING:
                                    «genDataDrivenTriggers(xpmc, state, usesHdlr)»
                                    break;
                                «genEventDrivenTriggers(xpmc, state, atlist, usesHdlr)»
                            }
                        «ELSE»
                                «genDataDrivenTriggers(xpmc, state, usesHdlr)»
                        «ENDIF»
                    «ELSEIF dataDriven»
                            «genDataDrivenTriggers(xpmc, state, usesHdlr)»
                    «ELSEIF eventDriven»
                        «var atlist =  xpmc.getActiveTriggers(state)»
                        «IF !atlist.isEmpty»
                            switch(trigger__et) {
                                    «genEventDrivenTriggers(xpmc, state, atlist, usesHdlr)»
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
     * @param xpmc the {@link ExpandedModelComponent}
     * @param state the {@link State} for which the trigger if-else switch should be generated
     * @param usesHdlr if the state machine uses no handler {@link TransitionPoints}
     *      at all then unused variables can be avoided by passing <code>true</code>
     * @return the generated code
     */
    def public genDataDrivenTriggers(ExpandedModelComponent xpmc, State state, boolean usesHdlr) {
		val chainIDScope = if (langExt.usesInheritance) xpmc.className+langExt.scopeSeparator else ""
        '''
            «genDoCodes(state)»
            «var transitions = xpmc.getOutgoingTransitionsHierarchical(state).filter(t|t instanceof GuardedTransition)»
            «FOR tr : transitions»
                if («guard((tr as GuardedTransition), "", xpmc)»)
                {
                    «var chain = xpmc.getChain(tr)»
                    chain__et = «chainIDScope»«chain.genChainId»;
                    catching_state__et = «chain.stateContext.genStateId»;
                    «IF chain.isHandler() && usesHdlr»
                        is_handler__et = TRUE;
                    «ENDIF»
                }
                «IF tr!=transitions.last»
                    else
                «ENDIF»
            «ENDFOR»
        '''
    }

    /**
     * helper method which generates the event driven triggers
     *
     * @param xpmc the {@link ExpandedModelComponent}
     * @param state the {@link State} for which the trigger switch should be generated
     * @param atlist the list of {@link ActiveTrigger}s of this state
     * @param usesHdlr if the state machine uses no handler {@link TransitionPoints}
     *      at all then unused variables can be avoided by passing <code>true</code>
     * @return the generated code
     */
    def public genEventDrivenTriggers(ExpandedModelComponent xpmc, State state, List<ActiveTrigger> atlist, boolean usesHdlr) {
		val chainIDScope = if (langExt.usesInheritance) xpmc.className+langExt.scopeSeparator else ""
        '''
            «FOR at : atlist»
                case «xpmc.getTriggerCodeName(at)»:
                    «var needData = at.hasGuard»
                    «IF needData»{ «langExt.getTypedDataDefinition(at.msg)»«ENDIF»
                    «FOR tt : at.transitions SEPARATOR " else "»
                        «var chain = xpmc.getChain(tt)»
                        «guard(chain.getTransition as TriggeredTransition, at.trigger, xpmc)»
                        {
                            chain__et = «chainIDScope»«chain.genChainId»;
                            catching_state__et = «chain.stateContext.genStateId»;
                            «IF chain.isHandler() && usesHdlr»
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

    def public getClassName(ExpandedModelComponent xpmc) {
        xpmc.modelComponent.className
    }

    def public getClassName(ModelComponent mc) {
        mc.componentName
    }

    /**
     * getter for history array
     *
     * @param state the ID of the history state
     * @return the generated code
     */
    def public getHistory(String state) {
        langExt.memberAccess+"history["+state+"]"
    }

    /**
     * setter for history array
     *
     * @param state the ID of the state whose history should be set
     * @param historyState the ID of the state that should be assigned
     * @return the generated code
     */
    def public setHistory(String state, String historyState) {
        langExt.memberAccess+"history["+state+"] = "+historyState
    }

    /**
     * @return the type of (temporary) state variables (defaults to "int")
     * and has to be signed
     */
    def public stateType() {
        "int"
    }

    /**
     * allow target language dependent generation of unreachable return in generated enterHistory method.
     * The default is just a comment.
     * @return the generated code
     */
    def public unreachableReturn() {
        "/* return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true) */"
    }

    /**
     * type of (temporary) boolean variables (defaults to "boolean")
     * @return the generated code
     */
    def public boolType() {
        return "boolean"
    }

    /**
     * empty, but may be overridden
     */
    def public finalAction() {
        ''''''
    }

    /**
     * the type of the interface item passed into the receiveEvent() method
     */
    def public interfaceItemType() {
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
     * @param xpax the {@link ExpandedModelComponent}
     * @return <code>true</code> if the state machine uses handler transition points
     */
    def public usesHandlerTrPoints(ExpandedModelComponent xpmc) {
        if (xpmc.stateMachine.empty)
            return false
        !xpmc.stateMachine.allTrPointsRecursive.filter(t|t instanceof TransitionPoint && ((t as TransitionPoint).handler)).empty
    }

    def public String guard(TriggeredTransition tt, String trigger, ExpandedModelComponent mc)
    def public String guard(GuardedTransition tt, String trigger, ExpandedModelComponent mc)
    def public String genActionCodeMethod(ExpandedModelComponent xpmc, Transition tr, boolean generateImplementation)
    def public String genActionCodeMethods(ExpandedModelComponent xpmc, State state, boolean generateImplementation)
}