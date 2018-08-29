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
import java.util.Comparator
import org.eclipse.etrice.core.fsm.fSM.State
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node
import org.eclipse.etrice.generator.generic.GenericStateMachineGenerator
import org.eclipse.etrice.generator.java.Main

import static extension org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions.*
import com.google.inject.Inject
import org.eclipse.etrice.generator.java.setup.GeneratorOptionsHelper

@Singleton
class StateMachineGen extends GenericStateMachineGenerator {

	@Inject protected extension GeneratorOptionsHelper

	val nodeComparator = new NodeComparator

	/**
	 * @param generateImplementation NOT used
	 */
	override genExtra(GraphContainer gc, boolean generateImplementation) {
		val orderedStateNodes = gc.graph.allStateNodes.toList.sortWith(nodeComparator)

	'''
		«IF Main::settings.generateMSCInstrumentation || Main::settings.generateWithVerboseOutput»
			// state names
			protected static final String stateStrings[] = {
				"<no state>",
				"<top>",
				«FOR node : orderedStateNodes SEPARATOR ","»
					"«(node.stateGraphNode as State).genStatePathName»"
				«ENDFOR»
			};

		«ENDIF»
«««	 	TODOHRR: history defined in ActorClassBase, init in constructor
«««			history = new int[5];
«««			for (int i = 0; i < history.length; i++) {
«««				history[i] = NO_STATE;
«««			}
		// history
		protected int history[] = {NO_STATE, NO_STATE«FOR state : orderedStateNodes», NO_STATE«ENDFOR»};

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
