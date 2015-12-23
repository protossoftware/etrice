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

import org.eclipse.etrice.core.fsm.fSM.GuardedTransition
import org.eclipse.etrice.core.fsm.fSM.NonInitialTransition
import org.eclipse.etrice.core.fsm.fSM.State
import org.eclipse.etrice.core.fsm.fSM.Transition
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedRefinedState
import org.eclipse.etrice.generator.fsm.generic.AbstractStateMachineGenerator

/**
 * A target language independent generator of the state machine implementation
 */
class GenericStateMachineGenerator extends AbstractStateMachineGenerator {

	/**
	 * generates the code of the whole state machine, consisting of constants + methods
	 *
	 * @param xpmc the {@link ExpandedModelComponent}
	 * @return the generated code
	 */
	def genStateMachine(ExpandedModelComponent xpmc) '''
		«genStateMachineConstants(xpmc)»

		«genStateMachineMethods(xpmc, true)»
	'''

	/**
	 * generates the constants for the state machine
	 */
	def genStateMachineConstants(ExpandedModelComponent xpmc) '''
		/* state IDs */
		«xpmc.genStateIdConstants»

		/* transition chains */
		«xpmc.genTransitionChainConstants»

		/* triggers */
		«xpmc.genTriggerConstants»
	'''

	/**
	 * generates the methods for the state machine codes and state switching
	 *
	 * @param xpmc the {@link ExpandedModelComponent}
	 * @param generateImplemenation or declaration only
	 * @return the generated code
	 */
	def genStateMachineMethods(ExpandedModelComponent xpmc, boolean generateImplementation) '''
		«genExtra(xpmc, generateImplementation)»

		/* Entry and Exit Codes */
		«xpmc.genEntryAndExitCodes(generateImplementation)»

		/* Action Codes */
		«xpmc.genActionCodes(generateImplementation)»

		/* State Switch Methods */
		«xpmc.genStateSwitchMethods(generateImplementation)»
	'''

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
        val opScopePriv = if (langExt.usesInheritance) opScope else ""
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

	 /**
     * let derived class add extra code after definition of constants
     *
     * @param xpmc an expanded actor class
     * @param generateImplementation or declaration only
     * @return the generated code
     */
    def public genExtra(ExpandedModelComponent xpmc, boolean generateImplementation) {''''''}
}
