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

package org.eclipse.etrice.generator.cpp.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.ArrayList
import org.eclipse.xtext.util.Pair
import static org.eclipse.xtext.util.Tuples.*
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass
import org.eclipse.etrice.generator.generic.GenericStateMachineGenerator
import org.eclipse.etrice.generator.generic.RoomExtensions

@Singleton
class StateMachineGen extends GenericStateMachineGenerator {
	
	@Inject extension RoomExtensions
	@Inject ProtocolClassGen cppProtGen
	
	override genExtraDecl(ExpandedActorClass xpac) {
//		val ac = xpac.actorClass
	'''
		protected:
		 	static std::string s_stateStrings[];
		
«««	 	TODOHRR: history defined in ActorClassBase, init in constructor
«««			history = new int[5];
«««			for (int i = 0; i < history.length; i++) {
«««				history[i] = NO_STATE;
«««			}
		 	int history[];
		
		private:
			 void setState(int new_state);
	'''}
	
	override genExtra(ExpandedActorClass xpac) {
		val ac = xpac.actorClass
	'''
		std::string «ac.name»::s_stateStrings[] = {"<no state>","<top>",«FOR state : ac.getAllBaseStatesLeavesLast() SEPARATOR ","»"«state.getStatePathName()»"
		«ENDFOR»};
		
«««	 	TODOHRR: history defined in ActorClassBase, init in constructor
«««			history = new int[5];
«««			for (int i = 0; i < history.length; i++) {
«««				history[i] = NO_STATE;
«««			}
				
		void «ac.name»::setState(int new_state) {
			DebuggingService::getInstance().addActorState(*this, s_stateStrings[new_state]);
			if (s_stateStrings[new_state]!="Idle") {
«««				TODOTS: model switch for activation
				std::cout << getInstancePath() << " -> " << s_stateStrings[new_state] << std::endl;
			}	
			m_state = new_state;
		}
	'''}
	
	override genTriggerConstants(ExpandedActorClass xpac) {
		val triggers = if (langExt.usesInheritance)
			xpac.getOwnTriggers() else xpac.triggers

		val list = new ArrayList<Pair<String, String>>()
		list.add(pair("POLLING", "0"));
		for (mif : triggers) {
			list.add(pair(xpac.getTriggerCodeName(mif), "IFITEM_"+mif.from.name+" + EVT_SHIFT*"+cppProtGen.getMessageID(mif)))
		}
		
		return langExt.genEnumeration("triggers", list)
	}
	
	override constPointer(String classname) {
		return "const " + classname + "*"	
	}
	
	override boolType() {
		return "bool"
	}

	
	
	
}
