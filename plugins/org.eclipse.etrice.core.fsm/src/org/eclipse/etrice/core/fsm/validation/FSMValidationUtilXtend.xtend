/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Mirza Klimenta (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.fsm.validation

import com.google.inject.Inject
import java.util.ArrayList
import java.util.HashMap
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.etrice.core.fsm.fSM.FSMPackage
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf
import org.eclipse.etrice.core.fsm.fSM.State
import org.eclipse.etrice.core.fsm.fSM.StateGraph
import org.eclipse.etrice.core.fsm.fSM.StateTerminal
import org.eclipse.etrice.core.fsm.fSM.Transition
import org.eclipse.etrice.core.fsm.fSM.Trigger
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider

class FSMValidationUtilXtend {


	static class Result {
		boolean ok;
		String msg;
		EObject source;
		EStructuralFeature feature;
		int index;

		def static FSMValidationUtilXtend.Result ok() {
			return new FSMValidationUtilXtend.Result(true, "", null, null, 0);
		}
		def static FSMValidationUtilXtend.Result error(String msg) {
			return new FSMValidationUtilXtend.Result(false, msg, null, null, -1);
		}
		def static FSMValidationUtilXtend.Result error(String msg, EObject source, EStructuralFeature feature) {
			return new FSMValidationUtilXtend.Result(false, msg, source, feature, -1);
		}
		def static FSMValidationUtilXtend.Result error(String msg, EObject source, EStructuralFeature feature, int index) {
			return new FSMValidationUtilXtend.Result(false, msg, source, feature, index);
		}
		
		new(boolean ok, String msg, EObject source, EStructuralFeature feature, int index) {
			this.ok = ok;
			this.msg = msg;
			this.source = source;
			this.feature = feature;
			this.index = index;
		}

		def boolean isOk() {
			return ok;
		}
		def String getMsg() {
			return msg;
		}
		def EObject getSource() {
			return source;
		}
		def EStructuralFeature getFeature() {
			return feature;
		}
		def int getIndex() {
			return index;
		}
	}
	
	@Inject
	extension FSMNameProvider
	
	def uniqueOriginTriggers(State myState) {
		val parent=getStateGraph(myState)
		val HashMap<String, TriggeredTransition> trig2trans = newHashMap
		val ArrayList<FSMValidationUtilXtend.Result> result = newArrayList
		
		for (Transition t:parent.transitions.filter(t|t instanceof TriggeredTransition && ((t as TriggeredTransition).from instanceof StateTerminal) && myState==((t as TriggeredTransition).from as StateTerminal).state)) {
			for (Trigger k:(t as TriggeredTransition).triggers.filter(k|k.guard===null)) {
				for (specMethod:k.getMsgFromIfPairs) {
					val triggerName = specMethod.triggerName
					if (trig2trans.containsKey(triggerName)) {
						val ot = trig2trans.get(triggerName)
						result.add(FSMValidationUtilXtend.Result.error("Triggers originating from a state should be unique.", t, FSMPackage.Literals.TRIGGERED_TRANSITION__TRIGGERS))
						result.add(FSMValidationUtilXtend.Result.error("Triggers originating from a state should be unique.", ot, FSMPackage.Literals.TRIGGERED_TRANSITION__TRIGGERS))
					}
					trig2trans.put(triggerName, t as TriggeredTransition)
				}
			}
		}
		return result
	}
	
	private def getTriggerName(MessageFromIf mif) {
		mif.from.name + "#" + mif.message.messageName
	}
	
	def getStateGraph(EObject obj) {
		var parent = obj.eContainer
		while (parent!==null) {
			if (parent instanceof StateGraph) {
				return parent
			}
			parent = parent.eContainer
		}
		return null
	}
}