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

import com.google.inject.Singleton
import java.util.Comparator
import org.eclipse.etrice.core.fsm.fSM.State
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node
import org.eclipse.etrice.generator.cpp.Main
import org.eclipse.etrice.generator.generic.GenericStateMachineGenerator

import static extension org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions.*
import com.google.inject.Inject
import org.eclipse.etrice.generator.cpp.setup.GeneratorOptionsHelper

@Singleton
class StateMachineGen extends GenericStateMachineGenerator {

	@Inject protected extension GeneratorOptionsHelper

	val nodeComparator = new NodeComparator
	
	override genExtra(GraphContainer gc, boolean generateImplementation) {
		var ac = gc.component
		val clsName = ac.componentName
		val orderedStateNodes = gc.graph.allStateNodes.toList.sortWith(nodeComparator)

		if(generateImplementation)
			'''
				«IF Main::settings.generateMSCInstrumentation || Main::settings.generateWithVerboseOutput»
					// state names
					const String «clsName»::s_stateStrings[] = {
						"<no state>",
						"<top>",
						«FOR state : orderedStateNodes SEPARATOR ","»
							"«(state.stateGraphNode as State).genStatePathName»"
						«ENDFOR»
					};
				«ENDIF»
				const int «clsName»::s_numberOfStates = «2+orderedStateNodes.size»;

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

				int history[«2+orderedStateNodes.size»];

				void setState(int new_state);
			'''
	}

	override public stateType() {
		"etInt16"
	}

	override boolType() {
		"etBool"
	}

	private static class NodeComparator implements Comparator<Node> {
		
		// it is crucial that we obey the order that is used for state IDs
		// that means we have to collect base classes first and each base class list with leaf states last
		override int compare(Node o1, Node o2) {
			if (o1.inheritanceLevel==o2.inheritanceLevel) {
				if (o1.isLeaf && o2.isLeaf) {
					return 0
				}
				if (o1.isLeaf) {
					return 1
				}
				if (o2.isLeaf) {
					return -1
				}
				return 0
			}
			else {
				return Integer.compare(o1.inheritanceLevel, o1.inheritanceLevel)
			}
		}
		
	}
}
