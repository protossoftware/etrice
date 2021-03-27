/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.generator.generic

import com.google.inject.Inject
import org.eclipse.etrice.core.fsm.fSM.GuardedTransition
import org.eclipse.etrice.core.fsm.fSM.NonInitialTransition
import org.eclipse.etrice.core.fsm.fSM.RefinedState
import org.eclipse.etrice.core.fsm.fSM.State
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition
import org.eclipse.etrice.core.fsm.util.FSMHelpers
import org.eclipse.etrice.core.genmodel.fsm.TriggerExtensions
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node
import org.eclipse.etrice.generator.fsm.generic.AbstractStateMachineGenerator
import org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions

/**
 * A target language independent generator of the state machine implementation
 */
class GenericStateMachineGenerator extends AbstractStateMachineGenerator {

	@Inject
	protected extension TriggerExtensions
	
	@Inject
	protected extension FSMHelpers
	
	/**
	 * generates the code of the whole state machine, consisting of constants + methods
	 *
	 * @param xpmc the {@link ExpandedModelComponent}
	 * @return the generated code
	 */
	def genStateMachine(GraphContainer gc) '''
		«genStateMachineConstants(gc)»

		«genStateMachineMethods(gc, true)»
	'''

	/**
	 * generates the constants for the state machine
	 */
	def genStateMachineConstants(GraphContainer gc) '''
		/* state IDs */
		«gc.genStateIdConstants»

		/* transition chains */
		«gc.genTransitionChainConstants»

		/* triggers */
		«gc.genTriggerConstants»
	'''

	/**
	 * generates the methods for the state machine codes and state switching
	 *
	 * @param xpmc the {@link ExpandedModelComponent}
	 * @param generateImplemenation or declaration only
	 * @return the generated code
	 */
	def genStateMachineMethods(GraphContainer gc, boolean generateImplementation) '''
		«genExtra(gc, generateImplementation)»

		/* Entry and Exit Codes */
		«gc.genEntryAndExitCodes(generateImplementation)»

		/* Action Codes */
		«gc.genActionCodes(generateImplementation)»

		/* State Switch Methods */
		«gc.genStateSwitchMethods(generateImplementation)»
	'''

	/**
	 * generate a transition guard if applicable
	 *
	 * @param tt a {@link TriggeredTransition}
	 * @param trigger a trigger string
	 * @param xpmc an expanded actor class
	 * @return the generated code
	 */
	override String genTriggeredTransitionGuard(Link tt, String trigger, GraphContainer gc) {
		val tr = (tt.transition as TriggeredTransition).triggers.findFirst(trig|trig.isMatching(trigger))
	'''
		«IF tr.hasGuard()»
			if («translator.getTranslatedCode(tr.guard.guard)»)
		«ENDIF»
	'''
	}

    override String genGuardedTransitionGuard(Link link, String trigger, GraphContainer gc) {
        '''
            «translator.getTranslatedCode((link.transition as GuardedTransition).guard)»
        '''
    }

	override String genActionCodeMethod(GraphContainer gc, Link link, boolean generateImplementation) {
		var hasArgs = !link.chainHeads.empty && link.chainHeads.forall[transition instanceof NonInitialTransition && !(transition instanceof GuardedTransition)]
		val opScope = langExt.operationScope(gc.className, false)
		val opScopePriv = if (langExt.usesInheritance) opScope else ""
		val ifItemPtr = "InterfaceItemBase"+langExt.pointerLiteral()
		val constIfItemPtr = if (langExt.usesPointers) "const "+ifItemPtr else ifItemPtr
		val actionCodes = FsmGenExtensions.getAllActionCodes(link)
		
		'''
			«IF !actionCodes.empty»
				«IF generateImplementation»
					«langExt.accessLevelProtected»void «opScopePriv»«link.transition.getActionCodeOperationName()»(«langExt.selfPointer(gc.className, hasArgs)»«IF hasArgs»«constIfItemPtr» ifitem«transitionChainGenerator.generateArgumentList(gc, link)»«ENDIF») {
						«FOR dc : actionCodes»
							«translator.getTranslatedCode(dc)»
						«ENDFOR»
					}
				«ELSE»
					«langExt.accessLevelProtected»«langExt.makeOverridable»void «link.transition.getActionCodeOperationName()»(«langExt.selfPointer(gc.className, hasArgs)»«IF hasArgs»«constIfItemPtr» ifitem«transitionChainGenerator.generateArgumentList(gc, link)»«ENDIF»);
				«ENDIF»
			«ENDIF»
		'''
	}

	/**
	 * generate action code method implementations or declarations
	 *
	 * @param xpax the {@link ExpandedModelComponent}
	 * @param state the {@link State}
	 * @param generateImplementation if only declarations should be generated then <code>false</code> has to be passed
	 * @return the generated code
	 */
	override String genActionCodeMethods(GraphContainer gc, Node node, boolean generateImplementation) {
		val mc = gc.modelComponent
		val selfPtr = langExt.selfPointer(gc.className, false)
		val opScope = langExt.operationScope(gc.className, false)
		val opScopePriv = if (langExt.usesInheritance)
							opScope
						else
							""
		val state = node.stateGraphNode as State
		val entryOp = state.getEntryCodeOperationName()
		val exitOp = state.getExitCodeOperationName()
		val doOp = state.getDoCodeOperationName()
		var entry = translator.getTranslatedCode(state.entryCode)
		var exit = translator.getTranslatedCode(state.exitCode)
		var docode = translator.getTranslatedCode(state.doCode)
		if (state instanceof RefinedState) {
			val inhEntry = translator.getTranslatedCode(state.inheritedEntryCode)
			val inhExit = translator.getTranslatedCode(state.inheritedExitCode)
			val inhDo = translator.getTranslatedCode(state.inheritedDoCode)
			if (langExt.usesInheritance) {
				// we call the super method in the generated code
				val baseName = mc.base.className
				if (state.inheritedEntryCode.hasDetailCode)
					entry = langExt.superCall(baseName, entryOp, "") + entry
				if (state.inheritedExitCode.hasDetailCode)
					exit = exit + langExt.superCall(baseName, exitOp, "")
				if (state.inheritedDoCode.hasDetailCode)
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
				«langExt.accessLevelProtected»«langExt.makeOverridable»void «entryOp»(«selfPtr»);
			«ENDIF»
		«ENDIF»
		«IF !exit.empty»
			«IF generateImplementation»
				«langExt.accessLevelProtected»void «opScopePriv»«exitOp»(«selfPtr») {
					«exit»
				}
			«ELSE»
				«langExt.accessLevelProtected»«langExt.makeOverridable»void «exitOp»(«selfPtr»);
			«ENDIF»
		«ENDIF»
		«IF !docode.empty»
			«IF generateImplementation»
				«langExt.accessLevelProtected» void «opScopePriv»«doOp»(«selfPtr») {
					«docode»
				}
			«ELSE»
				«langExt.accessLevelProtected»«langExt.makeOverridable»void «doOp»(«selfPtr»);
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
    def genExtra(GraphContainer gc, boolean generateImplementation) {''''''}
}
