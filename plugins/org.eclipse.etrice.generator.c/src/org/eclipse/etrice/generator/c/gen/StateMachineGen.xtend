/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

package org.eclipse.etrice.generator.c.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass
import org.eclipse.etrice.generator.c.Main
import org.eclipse.etrice.generator.generic.GenericStateMachineGenerator
import org.eclipse.etrice.generator.generic.RoomExtensions

import static extension org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions.*
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.eclipse.etrice.core.fsm.fSM.State

@Singleton
class StateMachineGen extends GenericStateMachineGenerator {

	@Inject extension RoomExtensions

	def genHeaderConstants(ExpandedActorClass xpac) {
		val ac = xpac.actorClass
		// number of all all states + 2 for TOP and NO_STATE
		val historySize = xpac.graphContainer.graph.allStateNodes.size + 2
		'''
			/* constant for state machine data */
			#define «ac.name.toUpperCase»_HISTORY_SIZE «historySize»
		'''
	}

	def genDataMembers(ExpandedActorClass xpac) {
		val ac = xpac.actorClass
		'''
			/* state machine variables */
			etInt16 state;
			etInt16 history[«ac.name.toUpperCase»_HISTORY_SIZE];
		'''
	}

	def genInitialization(ExpandedActorClass xpac) {
		val ac = xpac.actorClass
		'''
			self->state = STATE_TOP;
			{
				int i;
				for (i=0; i<«ac.name.toUpperCase»_HISTORY_SIZE; ++i)
					self->history[i] = NO_STATE;
			}
			«langExt.operationScope(ac.name, false)»executeInitTransition(self);
		'''
	}

	/**
	 * @param generateImplementation NOT used
	 */
	override public genExtra(GraphContainer gc, boolean generateImplementation) {
		val mc = gc.component
		val allStates = gc.graph.allStateNodes.map[stateGraphNode].filter(typeof(State)).toList
		val states = allStates.getLeafStatesLast
		'''
			«IF Main::settings.generateMSCInstrumentation»
				/* state names */
				static char* stateStrings[] = {"<no state>","<top>",«FOR state : states SEPARATOR ","»"«state.genStatePathName»"
				«ENDFOR»};
			«ENDIF»

			«langExt.accessLevelPrivate»void setState(«mc.componentName»* self, «stateType» new_state) {
				self->state = new_state;
				«IF Main::settings.generateMSCInstrumentation»
					ET_MSC_LOGGER_CHANGE_STATE(self->constData->instName, stateStrings[new_state]);
				«ENDIF»
			}

			«langExt.accessLevelPrivate»«stateType» getState(«mc.componentName»* self) {
				return self->state;
			}
		'''
	}

	override public stateType() {
		"etInt16"
	}

	override boolType() {
		"etBool"
	}

	override markVariableUsed(String varname) {
		'''
			((void)trigger__et);	/* avoids unused warning */
		'''
	}
	override public unreachableReturn() {
		"/* return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true) */"
	}

}
