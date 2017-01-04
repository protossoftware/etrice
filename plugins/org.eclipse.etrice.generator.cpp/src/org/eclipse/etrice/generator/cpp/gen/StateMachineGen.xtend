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
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent
import org.eclipse.etrice.generator.cpp.Main
import org.eclipse.etrice.generator.generic.GenericStateMachineGenerator
import org.eclipse.etrice.generator.generic.RoomExtensions

@Singleton
class StateMachineGen extends GenericStateMachineGenerator {

	@Inject extension RoomExtensions

	override genExtra(ExpandedModelComponent xpac, boolean generateImplementation) {
		val states = newArrayList
		var ac = xpac.modelComponent
		val clsName = xpac.modelComponent.componentName

//		it is crucial that we obey the order that is used for state IDs
//		that means we have to collect base classes first and each base class list with leaf states last
		while (ac!=null) {
			states.addAll(0, ac.allBaseStates.leafStatesLast)
			ac = ac.base
		}
		if(generateImplementation)
			'''
				«IF Main::settings.generateMSCInstrumentation || Main::settings.generateWithVerboseOutput»
					// state names
					const String «clsName»::s_stateStrings[] = {
						"<no state>",
						"<top>",
						«FOR state : states SEPARATOR ","»
							"«state.genStatePathName»"
						«ENDFOR»
					};
				«ENDIF»
				const int «clsName»::s_numberOfStates = «2+states.size»;

				void «clsName»::setState(int new_state) {
					«IF Main::settings.generateMSCInstrumentation»
						DebuggingService::getInstance().addActorState(*this, s_stateStrings[new_state].c_str());
					«ENDIF»
					«IF Main::settings.generateWithVerboseOutput»
						if (s_stateStrings[new_state] != "Idle") {
							std::cout << getInstancePath().c_str() << " -> " << s_stateStrings[new_state].c_str() << std::endl;
						}
					«ENDIF»
					m_state = new_state;
				}
			'''
		else
			'''
				«IF Main::settings.generateMSCInstrumentation || Main::settings.generateWithVerboseOutput»
				static const String s_stateStrings[];
				«ENDIF»
				static const int s_numberOfStates;

				int history[«2+states.size»];

				void setState(int new_state);
			'''
	}

	override public stateType() {
		"etInt16"
	}

	override boolType() {
		"etBool"
	}

}
