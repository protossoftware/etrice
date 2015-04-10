/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Peter Karlitschek
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.cpp.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.ArrayList
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.generator.generic.GenericStateMachineGenerator
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.xtext.util.Pair

import static org.eclipse.xtext.util.Tuples.*

/**
 * @author Peter Karlitschek
 *
 */
 @Singleton
class StateMachineGen extends GenericStateMachineGenerator {
	
	@Inject extension RoomExtensions
	@Inject ProtocolClassGen cppProtGen
	
	override genExtraDecl(ExpandedModelComponent xpac) {
//		val ac = xpac.actorClass
	'''
		protected:
		 	static std::string s_stateStrings[];
		 	static const int s_numberOfStates;
		
		private:
			 void setState(int new_state);
	'''}
	
	override genExtra(ExpandedModelComponent xpac) {
		val ac = xpac.modelComponent as ActorClass
	'''
		std::string «ac.name»::s_stateStrings[] = {"<no state>","<top>",«FOR state : ac.getAllBaseStatesLeavesLast() SEPARATOR ","»"«state.genStatePathName»"
		«ENDFOR»};
		const int «ac.name»::s_numberOfStates = «ac.getAllBaseStatesLeavesLast().size + 2»;
		
		void «ac.name»::setState(int new_state) {
			DebuggingService::getInstance().addActorState(*this, s_stateStrings[new_state]);
			if (s_stateStrings[new_state]!="Idle") {
«««				TODOTS: model switch for activation
				std::cout << getInstancePath() << " -> " << s_stateStrings[new_state] << std::endl;
			}	
			m_state = new_state;
		}
	'''}
	
	override genTriggerConstants(ExpandedModelComponent xpac) {
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
