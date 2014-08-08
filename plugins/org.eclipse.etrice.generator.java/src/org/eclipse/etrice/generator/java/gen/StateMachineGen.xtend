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

package org.eclipse.etrice.generator.java.gen

import com.google.inject.Singleton
import java.util.ArrayList
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass
import org.eclipse.etrice.core.fsm.fSM.State
import org.eclipse.etrice.generator.generic.GenericStateMachineGenerator
import org.eclipse.etrice.generator.java.Main

@Singleton
class StateMachineGen extends GenericStateMachineGenerator {
	
	override genExtra(ExpandedActorClass xpac) {
		val states = new ArrayList<State>()
		var ac = xpac.actorClass
		
//		it is crucial that we obey the order that is used for state IDs
//		that means we have to collect base classes first and each base class list with leaf states last
		while (ac!=null) {
			states.addAll(0, ac.allBaseStates.leafStatesLast)
			ac = ac.actorBase
		}
	'''
		«IF Main::settings.generateMSCInstrumentation || Main::settings.generateWithVerboseOutput»
			// state names
			protected static final String stateStrings[] = {
				"<no state>",
				"<top>",
				«FOR state : states SEPARATOR ","»
					"«state.genStatePathName»"
				«ENDFOR»
			};
				
		«ENDIF»
«««	 	TODOHRR: history defined in ActorClassBase, init in constructor
«««			history = new int[5];
«««			for (int i = 0; i < history.length; i++) {
«««				history[i] = NO_STATE;
«««			}
		// history
		protected int history[] = {NO_STATE, NO_STATE«FOR state : states», NO_STATE«ENDFOR»};
		
		private void setState(int new_state) {
			«IF Main::settings.generateMSCInstrumentation»
				DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
			«ENDIF»
			«IF Main::settings.generateWithVerboseOutput»
				if (stateStrings[new_state]!="Idle") {
					System.out.println("state switch of "+getInstancePath() + ": "
							+ stateStrings[this.state] + " -> " + stateStrings[new_state]);
				}	
			«ENDIF»
			this.state = new_state;
		}
	'''}
	
	/**
	 * if {@code -storeDataObj} is set then a call to {@code finalAction()} is generated
	 */
	override finalAction() {
		'''
			«IF Main::settings.generateStoreDataObj»
				finalAction();
			«ENDIF»
		'''
	}
	
	def getHistorySize(ExpandedActorClass xpac) {
		xpac.actorClass.getAllBaseStates().size+2
	}
}
