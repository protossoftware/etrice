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

import org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType
import org.eclipse.etrice.core.fsm.fSM.GuardedTransition
import org.eclipse.etrice.core.fsm.fSM.NonInitialTransition
import org.eclipse.etrice.core.fsm.fSM.State
import org.eclipse.etrice.core.fsm.fSM.Transition
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedRefinedState
import org.eclipse.etrice.generator.fsm.generic.AbstractStateMachineGenerator

/**
 * A target language independent generator of the state machine implementation-
 */
class GenericStateMachineGenerator extends AbstractStateMachineGenerator {
	
	/**
	 * generates the code of the whole state machine
	 * 
	 * @param xpmc the {@link ExpandedModelComponent}
	 * @return the generated code
	 * 
	 * @see #genStateMachine
	 */
	def genStateMachine(ExpandedModelComponent xpmc) {
		xpmc.genStateMachine(true)
	}
	
	/**
	 * generates the code of the whole state machine
	 * 
	 * @param xpmc the {@link ExpandedModelComponent}
	 * @param shallGenerateOneFile if <code>true</code> the generation of state IDs and
	 * 		other constants is skipped (and left for the header file)
	 * @return the generated code
	 */
	def genStateMachine(ExpandedModelComponent xpmc, boolean shallGenerateOneFile) {
		
	'''
		«IF shallGenerateOneFile»
			/* state IDs */
			«xpmc.genStateIdConstants»
			
			/* transition chains */
			«xpmc.genTransitionChainConstants»
			
			/* triggers */
			«xpmc.genTriggerConstants»
		«ENDIF»

		«genExtra(xpmc)»
		
		/* Entry and Exit Codes */
        «xpmc.genEntryAndExitCodes(true)»
		
		/* Action Codes */
        «xpmc.genActionCodes(true)»
		
		/* State Switch Methods */
		«xpmc.genStateSwitchMethods(true)»
	'''}

	/**
	 * generate a transition guard if applicable
	 * 
	 * @param tt a {@link TriggeredTransition}
	 * @param trigger a trigger string
	 * @param xpmc an expanded actor class
	 * @return the generated code
	 */	
	override String guard(TriggeredTransition tt, String trigger, ExpandedModelComponent mc) {
		val tr = tt.triggers.findFirst(e|mc.isMatching(e, trigger))
	'''
		«IF tr.hasGuard()»
			if («translator.getTranslatedCode(tr.guard.guard)»)
		«ENDIF»
	'''
	}
	
    override String guard(GuardedTransition tt, String trigger, ExpandedModelComponent mc) {
        '''
            «translator.getTranslatedCode(tt.guard)»
        '''
    }
	
	override String genActionCodeMethod(ExpandedModelComponent xpmc, Transition tr, boolean generateImplementation) {
        var chain = xpmc.getChains(tr)
        var hasArgs = !chain.empty && chain.forall[it.transition instanceof NonInitialTransition && !(it.transition instanceof GuardedTransition)]
        val opScope = langExt.operationScope(xpmc.getClassName, false)
        val opScopePriv = if (langExt.usesInheritance)
                            opScope
                        else
                            ""
        val ifItemPtr = "InterfaceItemBase"+langExt.pointerLiteral()
        val constIfItemPtr = if (langExt.usesPointers)
                                "const "+ifItemPtr
                            else
                                ifItemPtr
                            
        if (generateImplementation) {
    	    '''
                «langExt.accessLevelProtected»void «opScopePriv»«tr.getActionCodeOperationName()»(«langExt.selfPointer(xpmc.className, hasArgs)»«IF hasArgs»«constIfItemPtr» ifitem«transitionChainGenerator.generateArgumentList(xpmc, tr)»«ENDIF») {
                    «translator.getTranslatedCode(tr.action)»
                }
    	    '''
        }
        else {
            '''
                «langExt.accessLevelProtected»void «tr.getActionCodeOperationName()»(«langExt.selfPointer(xpmc.className, hasArgs)»«IF hasArgs»«constIfItemPtr» ifitem«transitionChainGenerator.generateArgumentList(xpmc, tr)»«ENDIF»);
            '''
        }
	}

	/**
	 * generate action code method implementations or declarations
	 * 
	 * @param xpax the {@link ExpandedModelComponent}
	 * @param state the {@link State}
	 * @param generateImplementation if only declarations should be generated then <code>false</code> has to be passed
	 * @return the generated code
	 */
	override String genActionCodeMethods(ExpandedModelComponent xpmc, State state, boolean generateImplementation) {
		val mc = xpmc.modelComponent
		val selfPtr = langExt.selfPointer(mc.className, false)
		val opScope = langExt.operationScope(mc.className, false)
		val opScopePriv = if (langExt.usesInheritance)
							opScope
						else
							""
		val entryOp = state.getEntryCodeOperationName()
		val exitOp = state.getExitCodeOperationName()
		val doOp = state.getDoCodeOperationName()
		var entry = translator.getTranslatedCode(state.entryCode)
		var exit = translator.getTranslatedCode(state.exitCode)
		var docode = translator.getTranslatedCode(state.doCode)
		if (state instanceof ExpandedRefinedState) {
			val rs = state as ExpandedRefinedState
			val inhEntry = translator.getTranslatedCode(rs.inheritedEntry)
			val inhExit = translator.getTranslatedCode(rs.inheritedExit)
			val inhDo = translator.getTranslatedCode(rs.inheritedDo)
			if (langExt.usesInheritance) {
				// we call the super method in the generated code
				val baseName = mc.base.className
				if (rs.inheritedEntry.hasDetailCode)
					entry = langExt.superCall(baseName, entryOp, "") + entry
				if (rs.inheritedExit.hasDetailCode)
					exit = exit + langExt.superCall(baseName, exitOp, "")
				if (rs.inheritedDo.hasDetailCode)
					docode = langExt.superCall(baseName, doOp, "") + docode
			}
			else {
				// the inherited code is added directly
				entry = inhEntry + entry
				exit = exit + inhExit
				docode = inhDo + docode
			}
		}
		'''
		«IF !entry.empty»
			«IF generateImplementation»
				«langExt.accessLevelProtected»void «opScopePriv»«entryOp»(«selfPtr») {
					«entry»
				}
			«ELSE»
				«langExt.accessLevelProtected»void «entryOp»(«selfPtr»);
			«ENDIF»
		«ENDIF»
		«IF !exit.empty»
			«IF generateImplementation»
				«langExt.accessLevelProtected»void «opScopePriv»«exitOp»(«selfPtr») {
					«exit»
				}
			«ELSE»
				«langExt.accessLevelProtected»void «exitOp»(«selfPtr»);
			«ENDIF»
		«ENDIF»
		«IF !docode.empty»
			«IF generateImplementation»
				«langExt.accessLevelProtected» void «opScopePriv»«doOp»(«selfPtr») {
					«docode»
				}
			«ELSE»
				«langExt.accessLevelProtected»void «doOp»(«selfPtr»);
			«ENDIF»
		«ENDIF»
		'''
	}
	
	// TODO: move the next two methods to the C++ generator
	
	/**
	 * @param classname the name of the type
	 * @return the type name for a constant pointer
	 */
	def constPointer(String classname) {
		return classname	
	}

	/**
	 * generate all method declarations
	 * 
	 * @param xpax the {@link ExpandedModelComponent}
	 * @return the generated code
	 */
	def genStateMachineMethodDeclarations(ExpandedModelComponent xpmc)
	{
		val mc = xpmc.modelComponent
		val async = mc.commType==ComponentCommunicationType::ASYNCHRONOUS
		val eventDriven = mc.commType==ComponentCommunicationType::EVENT_DRIVEN
		val handleEvents = async || eventDriven
		val selfPtr = langExt.selfPointer(mc.className, true)
		val usesHdlr = usesHandlerTrPoints(xpmc)
		
	'''
		
		/* state IDs */
		«xpmc.genStateIdConstants»
		
		/* transition chains */
		«xpmc.genTransitionChainConstants»
		
		/* triggers */
		«xpmc.genTriggerConstants»

		«genExtraDecl(xpmc)»
		
		/* Entry and Exit Codes */
        «xpmc.genEntryAndExitCodes(false)»
		
		/* Action Codes */
        «xpmc.genActionCodes(false)»
		
		private:
			/**
			 * calls exit codes while exiting from the current state to one of its
			 * parent states while remembering the history
			 * @param current - the current state
			 * @param to - the final parent state
			 «IF usesHdlr»
			 * @param handler - entry and exit codes are called only if not handler (for handler TransitionPoints)
			 «ENDIF»
			 */
			void exitTo(«selfPtr»int current, int to«IF usesHdlr», «boolType» handler«ENDIF»);
			
			/**
			 * calls action, entry and exit codes along a transition chain. The generic data are cast to typed data
			 * matching the trigger of this chain. The ID of the final state is returned
			 * @param chain - the chain ID
			 * @param generic_data__et - the generic data pointer
			 * @return the ID of the final state
			 */
			int executeTransitionChain(«selfPtr»int chain«IF handleEvents», «constPointer("etRuntime::InterfaceItemBase")» ifitem, «langExt.voidPointer» generic_data__et«ENDIF»);
			
			/**
			 * calls entry codes while entering a state's history. The ID of the final leaf state is returned
			 * @param state - the state which is entered
			 «IF usesHdlr»
			 * @param handler - entry code is executed if not handler
			 «ENDIF»
			 * @return - the ID of the final leaf state
			 */
			int enterHistory(«selfPtr»int state«IF usesHdlr», «boolType» handler«ENDIF»);
		
		public:

			void executeInitTransition(«langExt.selfPointer(mc.className, false)»);
			
			/* receiveEvent contains the main implementation of the FSM */
			void receiveEvent(«langExt.selfPointer(mc.className, handleEvents)»«IF handleEvents»etRuntime::InterfaceItemBase* ifitem, int evt, «langExt.voidPointer» generic_data__et«ENDIF»);
	'''
	}
}
