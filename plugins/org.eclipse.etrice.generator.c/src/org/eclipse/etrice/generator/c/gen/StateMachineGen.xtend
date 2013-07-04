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
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.generic.GenericStateMachineGenerator
import static extension org.eclipse.etrice.generator.base.CodegenHelpers.*
import static extension org.eclipse.etrice.core.room.util.RoomHelpers.*
import org.eclipse.etrice.generator.base.GlobalGeneratorSettings

@Singleton
class StateMachineGen extends GenericStateMachineGenerator {
	
	@Inject extension RoomExtensions
	
	def genHeaderConstants(ExpandedActorClass xpac) {
		val ac = xpac.actorClass
		/* TODO: can save one entry if NO_STATE=-1 but influences Java */
		val historySize = ac.allBaseStates.size - ac.allLeafStates.size + 2
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
	
	override protected genExtra(ExpandedActorClass xpac) {
		val ac = xpac.actorClass
		'''
			/* state names */
			static char* stateStrings[] = {"<no state>","<top>",«FOR state : ac.getAllBaseStatesLeavesLast() SEPARATOR ","»"«state.genStatePathName»"
			«ENDFOR»};
			
			«langExt.accessLevelPrivate»void setState(«ac.name»* self, «stateType» new_state) {
				self->state = new_state;
				«IF GlobalGeneratorSettings::generateMSCInstrumentation»
					ET_MSC_LOGGER_CHANGE_STATE(self->constData->instName, stateStrings[new_state])
				«ENDIF»
			}
			
			«langExt.accessLevelPrivate»«stateType» getState(«ac.name»* self) {
				return self->state;
			}
		'''
	}
	
	override protected stateType() {
		"etInt16"
	}
	
	override protected unreachableReturn() {
		"/* return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true) */"
	}
	
}
