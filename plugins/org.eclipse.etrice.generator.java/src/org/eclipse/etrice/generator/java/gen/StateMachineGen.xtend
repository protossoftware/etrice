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

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.generator.etricegen.ExpandedActorClass
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.generic.GenericStateMachineGenerator

@Singleton
class StateMachineGen extends GenericStateMachineGenerator {
	
	@Inject extension RoomExtensions

	override genExtra(ExpandedActorClass xpac, ActorClass ac) {'''
		// state names
		protected static final String stateStrings[] = {"<no state>","<top>",«FOR state : ac.getAllBaseStatesLeavesLast() SEPARATOR ","»"«state.getStatePathName()»"
		«ENDFOR»};
		
«««	 	TODOHRR: history defined in ActorClassBase, init in constructor
«««			history = new int[5];
«««			for (int i = 0; i < history.length; i++) {
«««				history[i] = NO_STATE;
«««			}
		// history
		protected int history[] = {NO_STATE,NO_STATE«FOR state : ac.getAllBaseStates()»,NO_STATE«ENDFOR»};
		
		private void setState(int new_state) {
			DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
			if (stateStrings[new_state]!="Idle") {
«««				TODOTS: model switch for activation
				System.out.println(getInstancePath() + " -> " + stateStrings[new_state]);
			}	
			this.state = new_state;
		}
	'''}
}
