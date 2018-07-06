/*******************************************************************************
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.fsm

import org.eclipse.etrice.core.fsm.naming.FSMNameProvider
import com.google.inject.Inject
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf
import org.eclipse.etrice.core.fsm.fSM.Trigger

class TriggerExtensions {
	
	public static String TRIGGER_SEP = "#"
	
	@Inject
	protected extension FSMNameProvider
	
	def getTriggerTag(MessageFromIf it) {
		from.name + TRIGGER_SEP + message.messageName
	}
	
	def boolean isMatching(Trigger trig, String trigstr) {
		for (mif : trig.msgFromIfPairs) {
			val tr = mif.triggerTag
			if (tr==trigstr)
				return true
		}
		return false
	}
}